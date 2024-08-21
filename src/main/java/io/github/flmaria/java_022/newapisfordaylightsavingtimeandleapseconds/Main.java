package io.github.flmaria.java_022.newapisfordaylightsavingtimeandleapseconds;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

public class Main {

    public static void main(String[] args) {

        ZoneId zoneId = ZoneId.of("America/New_York");
        ZoneRules rules = zoneId.getRules();
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 10, 2, 0); // Just before DST starts
        ZoneOffsetTransition transition = rules.getTransition(dateTime);

        if (transition != null && transition.isGap()) {
            System.out.println("DST starts, clocks move forward by " + transition.getDuration());
        } else if (transition != null && transition.isOverlap()) {
            System.out.println("DST ends, clocks move backward by " + transition.getDuration());
        }

        long epochSecond = 1672531199L; // Represents a time close to a leap second
        long nanoAdjustment = 0L;
        boolean leapSecond = true;

//        Instant instantWithLeapSecond = Instant.ofEpochSecond(epochSecond, nanoAdjustment, leapSecond);
//        System.out.println("Instant with leap second: " + instantWithLeapSecond);


    }

}
