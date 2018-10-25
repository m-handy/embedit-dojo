package org.codingdojo;

import java.util.Arrays;
import java.util.stream.Collectors;

class Wrapper {

    private Wrapper() {
        throw new AssertionError();
    }

    static String wrapString(String text, int lineLength) {

        if (text == null || lineLength <= 1) {
            throw new IllegalArgumentException();
        }
        String[] paragraphs = text.split("\n");

        return Arrays.stream(paragraphs).map(s -> wrapParagraph(s,lineLength)).collect(Collectors.joining("\n"));
    }

    private static String wrapParagraph(String sentence, int length) {
        String[] words = sentence.split(" ");

        StringBuilder wrappedString = new StringBuilder();
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > length) {
                lineLength = 0;
                wrappedString.append("\n");
                    String wordRemain = word;
                    if (wordRemain.length() > length) {
                        while (wordRemain.length() > length) {
                            wrappedString.append(wordRemain.substring(0, length - 1)).append("-\n");
                            wordRemain = wordRemain.substring(length-1);
                        }
                        wrappedString.append(wordRemain);
                    } else {
                        wrappedString.append(word);
                    }
            } else {
                wrappedString.append(" ");
                wrappedString.append(word);
            }
            lineLength += word.length();

        }
        if (wrappedString.length() >=1) {
            return wrappedString.toString().substring(1, wrappedString.length());
        }
        return wrappedString.toString();
    }
}
