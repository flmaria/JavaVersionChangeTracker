package io.github.flmaria.java_008.newdateandtimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();  // Current date
        LocalDate specificDate = LocalDate.of(2024, 8, 16);  // Specific date

        LocalTime time = LocalTime.now();  // Current time
        LocalTime specificTime = LocalTime.of(14, 30, 15);  // 14:30:15

        LocalDateTime dateTime = LocalDateTime.now();  // Current date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2024, 8, 16, 14, 30);  // Specific date and time

        ZonedDateTime zonedDateTime = ZonedDateTime.now();  // Current date and time with timezone
        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(2024, 8, 16, 14, 30, 0, 0, ZoneId.of("America/New_York"));

        OffsetDateTime offsetDateTime = OffsetDateTime.now();  // Current date and time with offset

        Instant instant = Instant.now();  // Current timestamp
        Instant specificInstant = Instant.ofEpochSecond(1623847200);  // Specific timestamp

        Duration duration = Duration.ofHours(5);  // 5 hours
//        Duration between = Duration.between(startTime, endTime);  // Duration between two times

        Period period = Period.ofDays(10);  // 10 days
        Period betweenDates = Period.between(LocalDate.of(2023, 8, 1), LocalDate.of(2024, 8, 16));  // Period between two dates

        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);  // 1 week later

        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));


        //Parsing and formatting dates
        LocalDate date2 = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date2.format(formatter);  // Format date to String
        System.out.println(formattedDate);  // Outputs: "16/08/2024"

        LocalDate parsedDate = LocalDate.parse("16/08/2024", formatter);  // Parse String to LocalDate
        System.out.println(parsedDate);  // Outputs: 2024-08-16

        //Adding and subtracting dates
        LocalDate today2 = LocalDate.now();
        LocalDate tomorrow = today2.plusDays(1);  // Add 1 day
        LocalDate lastMonth = today2.minusMonths(1);  // Subtract 1 month
        System.out.println(tomorrow);  // Outputs: 2024-08-17
        System.out.println(lastMonth);  // Outputs: 2024-07-16

        //handling time zones
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime2);  // Outputs: current date and time in New York time zone

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime newYorkDateTime = localDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println(newYorkDateTime);  // Outputs: local date and time in New York time zone

        //Calculating duration and period
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        Duration duration2 = Duration.between(startTime, endTime);
        System.out.println(duration2.toHours());  // Outputs: 8

        LocalDate startDate = LocalDate.of(2023, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 16);
        Period period2 = Period.between(startDate, endDate);
        System.out.println(period2.getYears());  // Outputs: 1
        System.out.println(period2.getMonths());  // Outputs: 0
        System.out.println(period2.getDays());  // Outputs: 15










    }


}
