package edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void testThatShortenStringRunsAsIntended() {
        String random = "Test!?=]@[]123456789øæå-*/+-.,<>)(/&%¤#!@£$€{[]}";
        random = Utilities.shortenAndReplaceUnnecessarySymbolsInString(random);
        System.out.println(random);
    }

}