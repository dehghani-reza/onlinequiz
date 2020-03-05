package ir.maktab.onlinequiz.utils;

import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import com.github.eloyzone.jalalicalendar.JalaliDateFormatter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyDate {

    public static Date changeFromJalali(String form) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(form, formatter);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        DateConverter converter = new DateConverter();
        LocalDate changeSubject = converter.jalaliToGregorian(year, month, day);

        return Date.from(changeSubject.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String changeFromGeorgian(Date date) {

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(date);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(s, formatter1);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        DateConverter converter = new DateConverter();
        JalaliDate jalaliDate = converter.gregorianToJalali(year, month, day);
        JalaliDateFormatter jalaliDateFormatter = new JalaliDateFormatter("yyyy/mm/dd");

        return jalaliDate.format(jalaliDateFormatter);
    }
}
