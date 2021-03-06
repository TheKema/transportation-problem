package com.ainullov.kamil.transportation_problem.utils;

public class Const {

    public static final class PrefKeys {
        public static final String SUPPLY = "supply";
        public static final String DEMAND = "demand";
        public static final String COSTS = "costs";
        public static final String PROBLEM_SOLUTION_ID = "problem_solution_id";
        public static final String DO_NOT_SHOW_HINTS = "do_not_show_hints";
    }

    public static final class ReferencePlanMethods {
        public static final int NORTHWEST_CORNER = 0;
        public static final int VOGELS_APPROXIMATION = 1;
    }

    public static final class Extras {
        public static final String SOLUTION_ID = "solution_id";
    }

    public static final class ErrorCode {
        public static final int ERROR = 0;
        public static final int INCORRECT_DATA = 1;
    }
}
