package com.epam.tvmaze.utils;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

public class RandomData {
    static MockNeat mock = MockNeat.threadLocal();

    public static String generateRandomStringLettersAndNumbers() {
        return mock.strings().size(8).get();
    }

    public static String generateRandomStringLetters() {
        return mock.strings().size(8).type(StringType.LETTERS).get();
    }

    public static String generateNumbers() {
        return mock.strings().size(8).type(StringType.NUMBERS).get();
    }
}
