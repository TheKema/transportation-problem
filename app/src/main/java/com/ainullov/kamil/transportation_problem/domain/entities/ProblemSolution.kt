package com.ainullov.kamil.transportation_problem.domain.entities

data class ProblemSolution(
    val id: Long,
    var transportationProblemData: TransportationProblemData,
    var minimumCosts: Int,
    var matrix: Array<Array<Shipment>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProblemSolution

        if (id != other.id) return false
        if (transportationProblemData != other.transportationProblemData) return false
        if (minimumCosts != other.minimumCosts) return false
        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + transportationProblemData.hashCode()
        result = 31 * result + minimumCosts
        result = 31 * result + matrix.contentDeepHashCode()
        return result
    }
}