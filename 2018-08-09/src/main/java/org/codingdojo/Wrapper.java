package org.codingdojo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Wrapper {

    public static String fun(String sentence, int length) {

        if (sentence == null || length <= 0) {
            throw new IllegalArgumentException();
        }
        String[] paragraphs = sentence.split("\n");
        final StringBuilder wrappedString = new StringBuilder();

        return String.join("\n", Arrays.stream(paragraphs).map(s -> wrapParagraph(s,length)).collect(Collectors.toList()));
    }

    private static String wrapParagraph(String sentence, int length) {
        String[] words = sentence.split(" ");

        StringBuilder wrappedString = new StringBuilder();
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > length) {
                lineLength = 0;
                wrappedString.append("\n");
                if (word.length() > length) {
                    wrappedString.append(word.substring(0,length-1)).append("-\n").append(word.substring(length-1));
                } else {
                    wrappedString.append(word);
                }
            } else {
                wrappedString.append(" ");
                wrappedString.append(word);
            }
            lineLength += word.length();

        }
        return wrappedString.toString().substring(1, wrappedString.length());
    }
}
