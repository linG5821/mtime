package com.ling5821.mtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lsj
 * @date 2021/1/8 9:56
 */
public class Mtime {
    public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String PRESET_PATTERN_1 = "E MMM d HH:mm:ss:SSS yyyy";
    public static final String PRESET_PATTERN_2 = "E MM d HH:mm:ss:SSS yyyy";
    public static final String PRESET_PATTERN_3 = "E M d HH:mm:ss:SSS yyyy";
    public static final String PRESET_PATTERN_4 = "yyyyMMddHHmmss";
    public static final String PRESET_PATTERN_5 = "yyyyMMdd HHmmss";
    public static final String PRESET_PATTERN_6 = "yyyy/MM/dd HH:mm:ss";
    public static final String PRESET_PATTERN_7 = "dd/MM/yyyy HH:mm:ss";
    public static final String PRESET_PATTERN_8 = "HH:mm:ss dd/MM/yyyy";
    public static final String PRESET_PATTERN_9 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String PRESET_PATTERN_10 = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String PRESET_PATTERN_11 = "yyyy-MM-dd HH:mm:ss EE";
    public static final String PRESET_PATTERN_12 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String PRESET_PATTERN_13 = "HH:mm:ss yyyy/MM/dd";
    public static final String PRESET_PATTERN_14 = "yyMMddHHmmss";


    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN);
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

    /**
     * {@link TemporalAccessor}转换为 时间戳(毫秒)
     *
     * @param temporalAccessor 时间对象
     * @return 时间戳(毫秒)
     */
    public static long toEpochMilli(TemporalAccessor temporalAccessor) {
        return toInstant(temporalAccessor).toEpochMilli();
    }

    /**
     * {@link TemporalAccessor}转换为 时间戳(秒)
     *
     * @param temporalAccessor 时间对象
     * @return 时间戳(秒)
     */
    public static long toEpochSecond(TemporalAccessor temporalAccessor) {
        return toInstant(temporalAccessor).getEpochSecond();
    }

    /**
     * 转换日期时间文本为时间戳
     *
     * @param text      日期时间文本
     * @param formatter 日期时间格式对象
     * @return 时间戳
     */
    public static long toEpochSecond(String text, DateTimeFormatter formatter) {
        return toEpochSecond(LocalDateTime.parse(text, formatter));
    }

    /**
     * 转换日期时间文本为时间戳
     *
     * @param text    日期时间文本
     * @param pattern 日期时间格式文本
     * @return 时间戳
     */
    public static long toEpochSecond(String text, String pattern) {
        return toEpochSecond(text, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转换日期时间文本为时间戳,使用默认的格式 yyyy-MM-dd HH:mm:ss
     *
     * @param text 日期时间文本
     * @return 时间戳
     */
    public static long toEpochSecond(String text) {
        return toEpochSecond(text, DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * 转换时间戳(秒)为 {@link LocalDateTime}
     *
     * @param timestamp 时间戳
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime ofEpochSecond(long timestamp) {
        return LocalDateTime.from(Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换时间戳(毫秒)为 {@link LocalDateTime}
     *
     * @param timestamp 时间戳
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime ofEpochMilli(long timestamp) {
        return LocalDateTime.from(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换时间戳(秒)为 {@link LocalDate}
     *
     * @param timestamp 时间戳
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDateOfEpochSecond(long timestamp) {
        return LocalDate.from(Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换时间戳(毫秒)为 {@link LocalDate}
     *
     * @param timestamp 时间戳
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDateOfEpochMilli(long timestamp) {
        return LocalDate.from(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()));
    }

    /**
     * 解析字符串为 {@link LocalDateTime}
     * @param text 字符串
     * @param pattern 日期时间格式
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parse(String text, String pattern) {

        if (null == pattern) {
            pattern = DEFAULT_DATE_TIME_PATTERN;
        }
        return of(DateTimeFormatter.ofPattern(pattern).parse(text));
    }

    /**
     * 转换日期文本为 {@link LocalDateTime} 使用默认的日期时间文本格式 yyyy-MM-dd HH:mm:ss
     *
     * @param text 时间戳
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime toLocalDateTime(String text) {
        return LocalDateTime.parse(text, DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * 转换日期文本为 {@link LocalDate} 使用默认的日期格式文本
     *
     * @param text 时间戳
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDate(String text) {
        return LocalDate.parse(text, DEFAULT_DATE_FORMATTER);
    }

    /**
     * 格式化 {@link LocalDate} 使用默认的格式 yyyy-MM-dd
     *
     * @param localDate 日期对象
     * @return 格式化后的日期文本
     */
    public static String format(LocalDate localDate) {
        return format(localDate, DEFAULT_DATE_FORMATTER);
    }

    /**
     * 格式化 {@link LocalDate} 使用指定的格式文本
     *
     * @param localDate 日期
     * @return 格式化后的日期文本
     */
    public static String format(LocalDate localDate, String pattern) {
        return format(localDate, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化 {@link LocalDate} 使用指定的格式对象
     *
     * @param localDate 日期
     * @return 格式化后的日期文本
     */
    public static String format(LocalDate localDate, DateTimeFormatter formatter) {
        return localDate.format(formatter);
    }

    /**
     * 格式化 {@link LocalDateTime} 使用默认的日期时间格式
     *
     * @param localDateTime 日期时间
     * @return 格式化后的日期时间文本
     */
    public static String format(LocalDateTime localDateTime) {
        return format(localDateTime, DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * 格式化 {@link LocalDateTime} 使用指定的日期时间格式文本
     *
     * @param localDateTime 日期时间
     * @return 格式化后的日期时间文本
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化 {@link LocalDateTime} 使用指定的日期时间格式对象
     *
     * @param localDateTime 日期时间
     * @return 格式化后的日期时间文本
     */
    public static String format(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return localDateTime.format(formatter);
    }

    /**
     * 将一个日期时间文本转为另一种格式的日期时间
     *
     * @param text          源格式文本
     * @param srcPattern    原格式文本
     * @param targetPattern 目标格式文本
     * @return 格式化后的日期时间文本
     */
    public static String format(String text, String srcPattern, String targetPattern) {
        return format(parse(text, srcPattern), targetPattern);
    }

    /**
     * 格式化当前时间默认格式
     *
     * @return 格式化后的日期时间文本
     */
    public static String format() {
        return format(LocalDateTime.now());
    }

    /**
     * 格式化当前时间使用指定格式文本
     *
     * @param pattern 指定格式文本
     * @return 格式化后的日期时间文本
     */
    public static String format(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    /**
     * 格式化当前时间使用指定格式对象
     *
     * @param formatter 指定格式对象
     * @return 格式化后的日期时间文本
     */
    public static String format(DateTimeFormatter formatter) {
        return format(LocalDateTime.now(), formatter);
    }

    /**
     * 格式化 指定时间戳(秒) 使用指定的格式文本
     *
     * @param timestamp 时间戳
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochSecond(long timestamp) {
        return format(ofEpochSecond(timestamp));
    }

    /**
     * 格式化 指定时间戳(秒) 使用指定的格式文本
     *
     * @param timestamp 时间戳
     * @param pattern   指定格式
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochSecond(long timestamp, String pattern) {
        return format(ofEpochSecond(timestamp), pattern);
    }

    /**
     * 格式化 指定时间戳(秒) 使用指定的格式对象
     *
     * @param timestamp 时间戳
     * @param formatter 指定格式对象
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochSecond(long timestamp, DateTimeFormatter formatter) {
        return format(ofEpochSecond(timestamp), formatter);
    }

    /**
     * 格式化 指定时间戳(毫秒) 使用指定的格式文本
     *
     * @param timestamp 时间戳
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochMilli(long timestamp) {
        return format(ofEpochMilli(timestamp));
    }

    /**
     * 格式化 指定时间戳(毫秒) 使用指定的格式文本
     *
     * @param timestamp 时间戳
     * @param pattern   指定格式
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochMilli(long timestamp, String pattern) {
        return format(ofEpochMilli(timestamp), pattern);
    }

    /**
     * 格式化 指定时间戳(毫秒) 使用指定的格式对象
     *
     * @param timestamp 时间戳
     * @param formatter 指定格式对象
     * @return 格式化后的日期时间文本
     */
    public static String formatEpochMilli(long timestamp, DateTimeFormatter formatter) {
        return format(ofEpochMilli(timestamp), formatter);
    }

    /**
     * 转换 {@link LocalDateTime} 一天的开始时间
     *
     * @param localDateTime 指定时间
     * @return 转换后的时间
     */
    public static LocalDateTime startOfDay(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MIN);
    }

    /**
     * 转换 {@link LocalDateTime} 一天的开始时间
     *
     * @param text 指定时间文本
     * @return 转换后的时间
     */
    public static LocalDateTime startOfDay(String text) {
        return startOfDay(toLocalDateTime(text));
    }

    /**
     * 转换 {@link LocalDateTime} 一天的开始时间
     *
     * @param text 指定时间文本
     * @param pattern 指定日期时间
     * @return 转换后的时间
     */
    public static LocalDateTime startOfDay(String text, String pattern) {
        return startOfDay(parse(text, pattern));
    }

    /**
     * 转换 {@link LocalDateTime} 一天的结束时间
     *
     * @param localDateTime 指定时间
     * @return 转换后的时间
     */
    public static LocalDateTime endOfDay(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MAX);
    }

    /**
     * 转换 {@link LocalDateTime} 一天的结束时间
     *
     * @param text 指定时间文本
     * @return 转换后的时间
     */
    public static LocalDateTime endOfDay(String text) {
        return endOfDay(toLocalDateTime(text));
    }

    /**
     * 转换 {@link LocalDateTime} 一天的结束时间
     *
     * @param text 指定时间文本
     * @param pattern 指定日期时间格式
     * @return 转换后的时间
     */
    public static LocalDateTime endOfDay(String text, String pattern) {
        return endOfDay(parse(text, pattern));
    }

    /**
     * 获取指定时间范围的日期文本列表
     *
     * @param startDateText 开始时间文本
     * @param endDateText   结束时间文本
     * @return 日期文本列表
     */
    public static List<String> dates(String startDateText, String endDateText) {
        long interval = getDiffDays(startDateText, endDateText);
        List<String> dates = new LinkedList<>();
        for (int i = 0; i <= interval; i++) {
            dates.add(format(LocalDate.parse(startDateText).plusDays(i)));
        }
        return dates;
    }

    /**
     * 获取两个时间的间隔天数
     *
     * @param startDateText 开始时间文本
     * @param endDateText   结束时间文本
     * @return 间隔天数
     */
    public static long getDiffDays(String startDateText, String endDateText) {
        return ChronoUnit.DAYS.between(LocalDate.parse(startDateText), LocalDate.parse(endDateText));
    }

    /**
     * {@link TemporalAccessor} 转换为 {@link Instant}对象 From: hutool
     *
     * @param temporalAccessor {@link TemporalAccessor}
     * @return {@link Instant}
     */
    public static Instant toInstant(TemporalAccessor temporalAccessor) {
        if (null == temporalAccessor) {
            return null;
        }

        Instant result;
        if (temporalAccessor instanceof Instant) {
            result = (Instant)temporalAccessor;
        } else if (temporalAccessor instanceof LocalDateTime) {
            result = ((LocalDateTime)temporalAccessor).atZone(ZoneId.systemDefault()).toInstant();
        } else if (temporalAccessor instanceof ZonedDateTime) {
            result = ((ZonedDateTime)temporalAccessor).toInstant();
        } else if (temporalAccessor instanceof OffsetDateTime) {
            result = ((OffsetDateTime)temporalAccessor).toInstant();
        } else if (temporalAccessor instanceof LocalDate) {
            result = ((LocalDate)temporalAccessor).atStartOfDay(ZoneId.systemDefault()).toInstant();
        } else if (temporalAccessor instanceof LocalTime) {
            // 指定本地时间转换 为Instant，取当天日期
            result = ((LocalTime)temporalAccessor).atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant();
        } else if (temporalAccessor instanceof OffsetTime) {
            // 指定本地时间转换 为Instant，取当天日期
            result = ((OffsetTime)temporalAccessor).atDate(LocalDate.now()).toInstant();
        } else {
            result = Instant.from(temporalAccessor);
        }
        return result;
    }

    /**
     * 安全获取时间的某个属性，属性不存在返回0 FROM: hutool
     *
     * @param temporalAccessor 需要获取的时间对象
     * @param field            需要获取的属性
     * @return 时间的值，如果无法获取则默认为 0
     */
    public static int get(TemporalAccessor temporalAccessor, TemporalField field) {
        if (temporalAccessor.isSupported(field)) {
            return temporalAccessor.get(field);
        }

        return (int)field.range().getMinimum();
    }

    /**
     * {@link TemporalAccessor}转{@link LocalDateTime}，使用默认时区 FROM: hutool
     *
     * @param temporalAccessor {@link TemporalAccessor}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime of(TemporalAccessor temporalAccessor) {
        if (null == temporalAccessor) {
            return null;
        }

        if(temporalAccessor instanceof LocalDate){
            return ((LocalDate)temporalAccessor).atStartOfDay();
        }

        return LocalDateTime.of(
            get(temporalAccessor, ChronoField.YEAR),
            get(temporalAccessor, ChronoField.MONTH_OF_YEAR),
            get(temporalAccessor, ChronoField.DAY_OF_MONTH),
            get(temporalAccessor, ChronoField.HOUR_OF_DAY),
            get(temporalAccessor, ChronoField.MINUTE_OF_HOUR),
            get(temporalAccessor, ChronoField.SECOND_OF_MINUTE),
            get(temporalAccessor, ChronoField.NANO_OF_SECOND)
        );
    }

}
