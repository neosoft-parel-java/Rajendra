package neo.spring5.javaFeatures.java9;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class DateUntilDemo {

    /*
     Java 9 has introduced a new method LocalDate.datesUntil() which can give a stream on dates.
     Using datesUntil() makes it easy to create dates streams with fixed offset.
     */
    public static void main(String[] args) {
        System.out.println( getDaysInJava9(LocalDate.now(), LocalDate.now().plusDays(10)) );
        System.out.println( getDaysInJava9Weeks(LocalDate.now(), LocalDate.now().plusWeeks(10)) );
    }

    //Stream of dates with 1 day difference
    public static List<LocalDate> getDaysInJava9(LocalDate start, LocalDate end) {
        return start.datesUntil(end).collect(Collectors.toList());
    }

    //Stream of dates with 1 week difference
    public static List<LocalDate> getDaysInJava9Weeks(LocalDate start, LocalDate end) {
        return start.datesUntil(end, Period.ofWeeks(1)).collect(Collectors.toList());
    }
}
