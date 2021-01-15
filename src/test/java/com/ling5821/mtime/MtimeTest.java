package com.ling5821.mtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lsj
 * @date 2021/1/8 12:12
 */
public class MtimeTest {
    public static void main(String[] args) {
        System.out.println(Mtime.format(LocalDate.now(), "YYYY/MM/dd"));
        System.out.println(Mtime.format());
        System.out.println(Mtime.format("YYYY-MMdd"));
        System.out.println(Mtime.format(LocalDate.now(), DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(Mtime.format(LocalDateTime.now(), DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(Mtime.format(LocalDateTime.now(), "YYYYMMdd-HHmmss"));
        System.out.println(Mtime.format(LocalDate.now()));
        System.out.println(Mtime.format(DateTimeFormatter.ISO_TIME));
        System.out.println(Mtime.format(LocalDateTime.now()));
        System.out.println(Mtime.format("2020-11-23 11:23:23", Mtime.DEFAULT_DATE_TIME_PATTERN, "yyyyMM-ddHHmmss"));
        System.out.println(Mtime.formatEpochSecond(1610101084));
        System.out.println(Mtime.formatEpochSecond(1610101084, Mtime.DEFAULT_DATE_TIME_PATTERN));
        System.out.println(Mtime.formatEpochSecond(1610101084, Mtime.DEFAULT_DATE_TIME_FORMATTER));
        System.out.println(Mtime.formatEpochMilli(1610101152919L));
        System.out.println(Mtime.formatEpochMilli(1610101152919L, Mtime.DEFAULT_DATE_TIME_PATTERN));
        System.out.println(Mtime.formatEpochMilli(1610101152919L, Mtime.DEFAULT_DATE_TIME_FORMATTER));
        System.out.println(Mtime.toEpochSecond("2020-11-23 12:33:12"));
        System.out.println(Mtime.toEpochSecond(LocalDateTime.now()));
        System.out.println(Mtime.toEpochSecond(LocalDate.now()));
        System.out.println(Mtime.toEpochSecond("2020-11-23 12:33:12", Mtime.DEFAULT_DATE_TIME_PATTERN));
        System.out.println(Mtime.toEpochSecond("2020-11-23 12:33:12", Mtime.DEFAULT_DATE_TIME_FORMATTER));
        System.out.println(Mtime.toEpochMilli(LocalDate.now()));
        System.out.println(Mtime.ofEpochSecond(1610101084));
        System.out.println(Mtime.ofEpochMilli(1610101152919L));
        System.out.println(Mtime.toLocalDateOfEpochSecond(1610101084));
        System.out.println(Mtime.toLocalDateOfEpochMilli(1610101152919L));
        System.out.println(Mtime.toLocalDate("2020-11-23"));
        System.out.println(Mtime.toLocalDateTime("2020-11-23 12:45:34"));
        System.out.println(Mtime.startOfDay(LocalDateTime.now()));
        System.out.println(Mtime.startOfDay("2020-11-23 12:45:34"));
        System.out.println(Mtime.startOfDay("2020-11-23", Mtime.DEFAULT_DATE_PATTERN));
        System.out.println(Mtime.toEpochSecond(Mtime.startOfDay("2020-11-23", Mtime.DEFAULT_DATE_PATTERN)));
        System.out.println(Mtime.endOfDay(LocalDateTime.now()));
        System.out.println(Mtime.endOfDay("2020-11-23 12:45:34"));
        System.out.println(Mtime.endOfDay("2020-11-23", Mtime.DEFAULT_DATE_PATTERN));
        System.out.println(Mtime.toEpochSecond(Mtime.endOfDay("2020-11-23", Mtime.DEFAULT_DATE_PATTERN)));
        System.out.println(Mtime.dates("2020-11-11", "2020-11-23"));
        System.out.println(Mtime.getDiffDays("2020-11-11", "2020-11-23"));
        System.out.println(Mtime.toInstant(LocalDateTime.now()));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_1));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_2));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_3));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_4));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_5));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_6));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_7));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_8));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_9));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_10));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_11));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_12));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_13));
        System.out.println(Mtime.format(LocalDateTime.now(), Mtime.PRESET_PATTERN_14));
        System.out.println(Mtime.getDiffSeconds(LocalDateTime.now(), LocalDateTime.now().plusHours(10)));
    }

}
