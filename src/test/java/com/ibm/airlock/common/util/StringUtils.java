package com.ibm.airlock.common.util;

public class StringUtils {
    public StringUtils() {
    }

    public static String findFirstMismatch(String str1, String str2, int interval) {
        String comp_res = "";
        if (str1.equals(str2)) {
            comp_res = "EQUALS";
        } else {
            int size1 = str1.length();
            int size2 = str2.length();
            int shorter = size1;
            if (size2 < size1) {
                shorter = size2;
            }

            boolean diff = false;

            for(int i = 0; i < shorter; ++i) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    int beginIndex = i - interval;
                    if (beginIndex < 0) {
                        beginIndex = 0;
                    }

                    int endIndex = i + interval;
                    if (endIndex > shorter) {
                        endIndex = shorter;
                    }

                    comp_res = comp_res + "Text diff. Expect: " + str1.substring(beginIndex, endIndex) + " Got: " + str2.substring(beginIndex, endIndex) + "\n";
                    i += interval;
                    diff = true;
                }
            }

            if (!diff) {
                String extra;
                if (str1.length() > shorter) {
                    extra = str1.substring(shorter);
                } else {
                    extra = str2.substring(shorter);
                }

                comp_res = "Text length diff. Expect: " + size1 + " Got: " + size2 + ". No string mismatch. Extra chars are: " + extra;
            }
        }

        return comp_res;
    }

    public static int howManyOccurrences(String findMe, String text) {
        int lastIndex = 0;
        int counter = 0;

        while(lastIndex != -1) {
            lastIndex = text.indexOf(findMe, lastIndex);
            if (lastIndex != -1) {
                ++counter;
                lastIndex += findMe.length();
            }
        }

        return counter;
    }

    public static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}
