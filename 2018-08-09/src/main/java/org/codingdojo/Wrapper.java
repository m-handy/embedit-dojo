package org.codingdojo;

import java.util.*;

class Wrapper {

    public static String fun(String sentence, int length) {

        if (sentence == null) {
            throw new IllegalArgumentException();
        }

        if (length < sentence.length()) {
            if (length > 10) {
                String[] words = sentence.split(" ");

                StringBuilder wrappedString = new StringBuilder();
                int linelength = 0;
                for (String word : words) {
                    if (linelength + word.length() > length) {
                        linelength = 0;
                        wrappedString.append("\n");
                    } else {
                        wrappedString.append(" ");
                    }
                    linelength += word.length();
                    wrappedString.append(word);
                }
                return wrappedString.toString().substring(1, wrappedString.length());
            }
            return sentence.replace(" ", "\n");
        } else {
            return sentence;
        }
    }
}
