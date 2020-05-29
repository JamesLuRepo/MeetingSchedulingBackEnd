package main.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCalculator {



    /**
     *
     * @param time 23-05-2020 12:25:43
     * @param minutes 10
     * @return
     */
    public static String showTime(String time, Integer minutes) {
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = null;
        try {
            date = sdfInput.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millisecond = date.getTime();
        long resultMillisecond = millisecond+minutes*60*1000;

        return sdfOutput.format(resultMillisecond);
    }
    public static long getMillisecondsFromTime(String time) {
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdfInput.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millisecond = date.getTime();
        return millisecond;
    }




}
