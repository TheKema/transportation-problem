package com.ainullov.kamil.transportation_problem.presentation.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ainullov.kamil.transportation_problem.R
import com.ainullov.kamil.transportation_problem.utils.adapter.ItemTouchHelperAdapter
import com.ainullov.kamil.transportation_problem.utils.adapter.OnStartDragListener
import java.util.*

class HistoryAdapter(
    var list: MutableList<Int>,
    private val onClickListener: (Int) -> Unit,
    private val onLongClickListener: (Int) -> Unit,
    private val onDeleteClickListener: (Int) -> Unit,
    private val onStartDragListener: OnStartDragListener
) : RecyclerView.Adapter<HistoryViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_history, parent, false
        )
        return HistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(
            position = position,
            quantity = list[position],
            onClickListener = onClickListener,
            onLongClickListener = onLongClickListener,
            onDeleteClickListener = onDeleteClickListener,
            onStartDragListener = onStartDragListener
        )
    }

    fun updateData(list: MutableList<Int>) {
        this.list = list
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition)
            for (i in fromPosition until toPosition)
                Collections.swap(list, i, i + 1)
        else
            for (i in fromPosition downTo toPosition + 1)
                Collections.swap(list, i, i - 1)

        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onItemSelected(viewHolder: RecyclerView.ViewHolder?) {
    }

    override fun onItemClear(viewHolder: RecyclerView.ViewHolder) {
        notifyDataSetChanged()
    }
}