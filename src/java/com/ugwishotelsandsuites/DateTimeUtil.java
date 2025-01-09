/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.ugwishotelsandsuites;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Eric McWinNEr
 * @author Jevison7x
 * @since Jan 20, 2018 1:38:20 AM
 */
public class DateTimeUtil
{
    public static class TimeRange
    {
        private Timestamp beginTime;

        private Timestamp endTime;

        public TimeRange()
        {
        }

        public Timestamp getBeginTime()
        {
            return beginTime;
        }

        public void setBeginTime(Timestamp beginTime)
        {
            this.beginTime = beginTime;
        }

        public Timestamp getEndTime()
        {
            return endTime;
        }

        public void setEndTime(Timestamp endTime)
        {
            this.endTime = endTime;
        }
    }

    public static TimeRange getAnyTimeRange(Calendar beginCal, Calendar endCal)
    {
        Timestamp beginTS = new Timestamp(beginCal.getTime().getTime());
        Timestamp endTs = new Timestamp(endCal.getTime().getTime());
        TimeRange tr = new TimeRange();
        tr.setBeginTime(beginTS);
        tr.setEndTime(endTs);
        return tr;
    }

    public static TimeRange getDayTimeRange(Calendar cal)
    {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Calendar beginCal = Calendar.getInstance();
        beginCal.set(year, month, day, 0, 0, 0);
        Calendar endCal = Calendar.getInstance();
        endCal.set(year, month, day, 23, 59, 59);
        return getAnyTimeRange(beginCal, endCal);
    }

    public static TimeRange getWeekTimeRange(Calendar cal)
    {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DAY_OF_MONTH, -dayOfWeek + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Calendar beginCal = (Calendar)cal.clone();
        cal.add(Calendar.DAY_OF_MONTH, 6);
        Calendar endCal = cal;
        endCal.set(Calendar.HOUR_OF_DAY, 23);
        endCal.set(Calendar.MINUTE, 59);
        endCal.set(Calendar.SECOND, 59);
        return getAnyTimeRange(beginCal, endCal);
    }

    public static TimeRange getMonthTimeRange(Calendar cal)
    {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar beginCal = new GregorianCalendar(year, month, 1, 0, 0, 0);
        Calendar endCal = new GregorianCalendar(year, month, daysInMonth, 23, 59, 59);
        return getAnyTimeRange(beginCal, endCal);
    }

    public static TimeRange getYearTimeRange(Calendar cal)
    {
        int year = cal.get(Calendar.YEAR);
        Calendar beginCal = new GregorianCalendar(year, 0, 1, 0, 0, 0);
        Calendar endCal = new GregorianCalendar(year, 11, 31, 23, 59, 59);
        return getAnyTimeRange(beginCal, endCal);
    }

    public static TimeRange getTrialExpiryDate()
    {
        Calendar cal = new GregorianCalendar();
        Timestamp beginTS = new Timestamp(cal.getTime().getTime());
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Timestamp endTs = new Timestamp(cal.getTime().getTime());
        TimeRange tr = new TimeRange();
        tr.setBeginTime(beginTS);
        tr.setEndTime(endTs);
        return tr;
    }

    public static Timestamp getTodayTimeZone()
    {
        try
        {
            // Current date and time using now()
            ZonedDateTime currentDateTime = ZonedDateTime.now();
            ZoneId nigerianTimeZone = ZoneId.of("Africa/Lagos");
            ZonedDateTime nigerianDateTime = currentDateTime.withZoneSameInstant(nigerianTimeZone);

            // Datetime formatting using java.time.format.DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDateTime = nigerianDateTime.format(formatter);

            // Convert to java.sql.Timestamp
            Timestamp timestamp = Timestamp.valueOf(formattedDateTime);
            return timestamp;
        }
        catch(Exception xcp)
        {
            throw new RuntimeException(xcp);
        }
    }

    public static Timestamp getWCATimeZone(Date date)
    {
        try
        {
            TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
            Instant instant = date.toInstant();
            ZoneId nigerianTimeZone = ZoneId.of("Africa/Lagos");
            ZonedDateTime nigerianDateTime = instant.atZone(nigerianTimeZone);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(formatter.format(nigerianDateTime));
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        }
        catch(Exception xcp)
        {
            throw new RuntimeException(xcp);
        }
    }

    public static String getCurrFormattedDate()
    {
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        return df.format(now);
    }

    public static String getCurrFormattedTime()
    {
        Date now = new Date();
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.US);
        return tf.format(now);
    }

    public static String getFormattedDate(Date date)
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        return df.format(date);
    }

    public static String getFormattedTime(Date date)
    {
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.US);
        return tf.format(date);
    }

    public static String getFormattedTimeStamp(Date date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static boolean isSameDate(Calendar cal1, Calendar cal2)
    {
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    public static LocalDate convertToLocalDate(Date date)
    {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate;
    }

    public static Period calculatePeriodBetweenDates(LocalDate beginLocalDate, LocalDate endLocalDate)
    {
        Period period = Period.between(beginLocalDate, endLocalDate);
        return period;
    }

    public static void main(String[] args)
    {

        // Current date and time using now()
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Creating two timezone zoneid objects using ZoneId.of() method.
        ZoneId losAngelesTimeZone = ZoneId.of("America/Los_Angeles");
        ZoneId dubaiTimeZone = ZoneId.of("Asia/Dubai");

        // Converting Current timezone time to Log Angeles time
        ZonedDateTime losAngelesDateTime = currentDateTime.withZoneSameInstant(losAngelesTimeZone);

        // Converting Current timezone time to Dubai time
        ZonedDateTime dubaiDateTime = currentDateTime.withZoneSameInstant(dubaiTimeZone);

        // Datetime formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm z");

        // Print all 3 dates
        System.out.println("Current time in IST : " + formatter.format(currentDateTime));
        System.out.println("Los Angeles time now : " + formatter.format(losAngelesDateTime));
        System.out.println("Dubai time now : " + formatter.format(dubaiDateTime));

        // getting the diff b/w two los angeles and dubai times.
        printDurationBetweenTwoDates(losAngelesDateTime, dubaiDateTime);

    }

    private static void printDurationBetweenTwoDates(ZonedDateTime sfoDateTime, ZonedDateTime dubaiDateTime)
    {
        Duration d = Duration.between(sfoDateTime, dubaiDateTime);
        long days = d.get(ChronoUnit.SECONDS);
        System.out.println("Time Difference between los angeles and dubai : " + days / (60 * 60) + " Hours " + (days % (60 * 60)) / 60 + " Minites");
    }

    public static Date formatDate(String dateString) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = formatter.parse(dateString);
        return date;
    }

    public static Date stringTimestamp2Date(String dateTimeString) throws ParseException
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(dateTimeString);
            return date;
        }
        catch(NullPointerException xcp)
        {
            return null;
        }
    }
}
