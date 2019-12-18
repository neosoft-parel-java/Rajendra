package neo.spring5.javaFeatures.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeDemo {
    public static void main(String[] args) {

        // The LocalDate class represents a date,
        // There is no representation of a time or time-zone.
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());                //2019-12-10
        System.out.println(localDate.getDayOfWeek().toString()); //TUESDAY
        System.out.println(localDate.getDayOfMonth());           //10
        System.out.println(localDate.getDayOfYear());            //344
        System.out.println(localDate.isLeapYear());              //false
        System.out.println(localDate.plusDays(12).toString());   //2019-12-22

        // The LocalTime class represents a time.
        // There is no representation of a date or time-zone.

        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1.toString());  //toString() in format 09:57:59.744
        LocalTime localTime = LocalTime.of(12, 20);
        System.out.println(localTime.toString());    //12:20
        System.out.println(localTime.getHour());     //12
        System.out.println(localTime.getMinute());   //20
        System.out.println(localTime.getSecond());   //0
        System.out.println(localTime.MIDNIGHT);      //00:00
        System.out.println(localTime.NOON);          //12:00

        //LocalDateTime
        // The LocalDateTime class represents a date-time,
        // There is no representation of a time-zone.

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());      //2019-12-10T13:05:50.109977
        System.out.println(localDateTime.getDayOfMonth()); //10
        System.out.println(localDateTime.getHour());       //13
        System.out.println(localDateTime.getNano());       //109977000

        /*
        If you want to use the date functionality with zone information,
        then Lambda provide you extra 3 classes similar to above one i.e. OffsetDate, OffsetTime and OffsetDateTime.
        Timezone offset can be represented in “+05:30” or “Europe/Paris” formats. This is done via using another class i.e. ZoneId.
         */

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime.toString());              //2019-12-10T13:05:50.110808+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
        System.out.println(offsetDateTime.toString());              //2019-12-10T13:05:50.110930+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
        System.out.println(offsetDateTime.toString());              //2019-12-10T01:05:50.111041-06:30

        ZonedDateTime zonedDateTime =
                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(zonedDateTime.toString());               //2019-12-10T08:35:50.112349+01:00[Europe/Paris]

        // Instant Class:
        // For representing the specific timestamp ant any moment, the class needs to be used is Instant.
        // The Instant class represents an instant in time to an accuracy of nanoseconds.
        // Operations on an Instant include comparison to another Instant and adding or subtracting a duration.

        Instant instant = Instant.now();
        System.out.println(instant.toString());
        System.out.println(instant.plus(Duration.ofMillis(5000)).toString());
        System.out.println(instant.minus(Duration.ofMillis(5000)).toString());
        System.out.println(instant.minusSeconds(10).toString());

        // Duration Class:
        // Duration class is a whole new concept brought first time in java language.
        // It represents the time difference between two time stamps.
        // Duration deals with small unit of time such as milliseconds, seconds, minutes and hour.
        // They are more suitable for interacting with application code.

        Duration duration = Duration.ofMillis(5000);
        System.out.println(duration.toString());     //PT5S (Period Time -> PT)

        duration = Duration.ofSeconds(60);
        System.out.println(duration.toString());     //PT1M

        duration = Duration.ofMinutes(10);
        System.out.println(duration.toString());     //PT10M

        duration = Duration.ofHours(2);
        System.out.println(duration.toString());     //PT2H

        duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
        System.out.println(duration.toString());  //PT10M

        // Period
        // To interact with human, you need to get bigger durations which are presented with Period class.

        Period period = Period.ofDays(6);
        System.out.println(period.toString());    //P6D

        period = Period.ofMonths(6);
        System.out.println(period.toString());    //P6M

        period = Period.between(LocalDate.now(),
                LocalDate.now().plusDays(60));
        System.out.println(period.toString());   //P1M29D


        //Date Formatting
        // Date formatting is supported via two classes mainly i.e. DateTimeFormatterBuilder and DateTimeFormatter.
        // DateTimeFormatterBuilder works on builder pattern to build custom patterns where as DateTimeFormatter provides necessary input in doing so.

        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
        formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                        .appendLiteral("-")
                        .appendZoneOrOffsetId();
        DateTimeFormatter formatter = formatterBuilder.toFormatter();
        System.out.println(formatter.format(ZonedDateTime.now()));
    }
}
