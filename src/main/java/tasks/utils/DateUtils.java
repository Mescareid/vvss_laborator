package tasks.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int HOURS_IN_A_DAY = 24;

    private TasksUtils service;

    public DateUtils(TasksUtils service){
        this.service=service;
    }
    public static LocalDate getLocalDateValueFromDate(Date date){//for setting to DatePicker - requires LocalDate
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }
    public Date getDateValueFromLocalDate(LocalDate localDate){//for getting from DatePicker
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return Date.from(instant);
    }
    public Date getDateMergedWithTime(String time, Date noTimeDate) {//to retrieve Date object from both DatePicker and time field
        final Date epochDate = new GregorianCalendar(1970, Calendar.JANUARY, 1, 0, 0).getTime();

        if (noTimeDate.before(epochDate))
            throw new IllegalArgumentException("date out of bound");

        String[] units = time.split(":");
        if (units.length != 2)
            throw new IllegalArgumentException("invalid time format");

        int hour = Integer.parseInt(units[0]);
        int minute = Integer.parseInt(units[1]);

        if (hour >= HOURS_IN_A_DAY || minute >= MINUTES_IN_HOUR || hour < 0 || minute < 0)
            throw new IllegalArgumentException("time unit exceeds bounds");

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(noTimeDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
    public String getTimeOfTheDayFromDate(Date date){//to set in detached time field
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        return service.formTimeUnit(hours) + ":" + service.formTimeUnit(minutes);
    }

}