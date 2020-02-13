package com.bartrzym.wateringplan.utils;

public class TimeFormatter {


    public static String formatter(long time) {
        String formatted;
        int min = (int) (time/ 60);
        int sec = (int) (time - (min * 60));

        formatted = " " + min + "min. " + sec + "sec. ";

        return formatted;

    }
}

