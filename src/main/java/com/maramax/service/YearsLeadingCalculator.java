package com.maramax.service;

import java.time.Year;

public class YearsLeadingCalculator {
    private static final int LEADER_BECOME_IN = 2001;

    public static String calculate() {
        int yearsLeader = Year.now().getValue() - LEADER_BECOME_IN;
        String wordMeaningYears;

        switch (yearsLeader % 10){
            case 0: wordMeaningYears = "років"; break;
            case 1: wordMeaningYears = "рік"; break;
            case 2: wordMeaningYears = "роки"; break;
            case 3: wordMeaningYears = "роки"; break;
            case 4: wordMeaningYears = "роки"; break;
            case 5: wordMeaningYears = "років"; break;
            case 6: wordMeaningYears = "років"; break;
            case 7: wordMeaningYears = "років"; break;
            case 8: wordMeaningYears = "років"; break;
            case 9: wordMeaningYears = "років"; break;
            default: wordMeaningYears = "років";
        }

        return yearsLeader + " " + wordMeaningYears;
    }
}
