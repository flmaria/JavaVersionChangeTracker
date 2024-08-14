package io.github.flmaria.java_009.factorymethodforImmutablelistsetandmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        /**
         * Before Java 9: creating immutable collections
         */
        List<Integer> sampleList = new ArrayList();
        sampleList.add(1);
        sampleList.add(2);
        sampleList.add(3);

        List<Integer> verboseImmutableList = Collections.unmodifiableList(sampleList);

        try {
            verboseImmutableList.add(4);
        }
        catch (UnsupportedOperationException e) {
            logger.error("Verbose way - You can not add items to an Immutable list.");
        }

        /**
         * Java 9: Use Interface static "of()" methods
         */

        //Immutable List
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        try {
            list.add(6);
        }
        catch (UnsupportedOperationException e) {
            logger.error("You can not add items to an Immutable List.");
        }

        //Immutable Set
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        try {
            set.add(6);
        }
        catch (UnsupportedOperationException e) {
            logger.error("You can not add items to an Immutable set.");
        }

        //Immutable Map
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");
        try {
            map.put(6, "six");
        }
        catch (UnsupportedOperationException e) {
            logger.error("You can not add items to an immutable Map");
        }

        //Immutable Map.Entry
        Map.Entry<Integer, String> mapEntry = Map.entry(1, "one");
        try {
            mapEntry.setValue("two");
        }
        catch (UnsupportedOperationException e) {
            logger.error("You can not change value of an Immutable Map.Entry.");
        }
    }
}