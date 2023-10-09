package com.bigkoo.pickerview.utils;

import android.annotation.SuppressLint;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class TimeUtils {
    public static String getStartEndTime(String time){
        Calendar calendar = Calendar.getInstance();
        if (Objects.equals(time,"近一个月")){
            calendar.add(Calendar.MONTH,-1);
        }else if (Objects.equals(time,"近七天")){
            calendar.add(Calendar.DATE,-6);
        }else if (Objects.equals(time,"近三天")){
            calendar.add(Calendar.DATE,-2);
        }
        String startTime = getZeroClockTimestamp(com.ved.framework.utils.TimeUtils.dateToLong(calendar.getTime()));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        String endTime = String.valueOf(com.ved.framework.utils.TimeUtils.dateToLong(calendar2.getTime()));
        return startTime+"-"+endTime;
    }

    public static String getZeroClockTimestamp(long time){
        long zeroTimestamp = time - (time + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000);
        return String.valueOf(zeroTimestamp);
    }

    @SuppressLint("SimpleDateFormat")
    public static String getStartEndTime(long time){
        String t = com.ved.framework.utils.TimeUtils.f_long_2_str(time);
        int year = com.ved.framework.utils.TimeUtils.getYear(t);
        int m = com.ved.framework.utils.TimeUtils.getMonth(t)+1;
        int days = com.ved.framework.utils.TimeUtils.getMonthLastDay(year,m);
        String start = "";
        if (String.valueOf(m).length() > 1) {
            start = year+"-"+m+"-"+"01 00:00:00";
        } else {
            start = year+"-0"+m+"-"+"01 00:00:00";
        }
        String startTime = String.valueOf(com.ved.framework.utils.TimeUtils.f_str_2_long(start));
        String end = "";
        if (String.valueOf(m).length() > 1) {
            end = year+"-"+m+"-"+days+" 23:59:59";
        } else {
            end = year+"-0"+m+"-"+days+" 23:59:59";
        }
        String endTime = String.valueOf(com.ved.framework.utils.TimeUtils.f_str_2_long(end));
        return startTime+"-"+endTime;
    }
}
