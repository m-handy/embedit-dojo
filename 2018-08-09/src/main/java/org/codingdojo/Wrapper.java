package org.codingdojo;

class Wrapper {

    public static String fun(String sentence, int length) {

        if (sentence == null || length <= 0) {
            throw new IllegalArgumentException();
        }

        String[] words = sentence.split(" ");

        StringBuilder wrappedString = new StringBuilder();
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > length) {
                lineLength = 0;
                if (word.length() > length) {
                    wrappedString.append("\n");
                    wrappedString.append(word.substring(0,1)).append("-\n").append(word.substring(1));
                } else {
                    wrappedString.append("\n");
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
