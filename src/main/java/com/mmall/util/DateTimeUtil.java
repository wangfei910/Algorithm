package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by wangfei
 */
public class DateTimeUtil {

    //joda-time
    //str->Date
    //Date->str
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date strToDate(String dateTimeStr, String formatStr){
        org.joda.time.format.DateTimeFormatter dateTimeFormatter = org.joda.time.format.DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = ((org.joda.time.format.DateTimeFormatter) dateTimeFormatter).parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String  dateToStr(Date date, String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        org.joda.time.format.DateTimeFormatter dateTimeFormatter = org.joda.time.format.DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = ((org.joda.time.format.DateTimeFormatter) dateTimeFormatter).parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String  dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2010-10-10 11:11:11", "yyyy-MM-dd HH:mm:ss"));
    }
}
