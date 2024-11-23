package com.ss.text;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        for (String word : words) {
            if (length + line.size() + word.length() > maxWidth) {
                result.add(buildLine(line, maxWidth));
                line.clear();
                length = 0;
            }
            line.add(word);
            length += word.length();
        }
        result.add(buildLastLine(maxWidth, line));
        return result;
    }

    private String buildLine(List<String> line, int maxWidth) {
        int length = line.stream().mapToInt(String::length).sum();
        int lineSize = Math.max(1, line.size() - 1);
        int allSpaces = maxWidth - length;
        int space = allSpaces / lineSize;
        int reminder = allSpaces % lineSize;
        for (int i = 0; i < lineSize; i++) {
            line.set(i, line.get(i) + spaces(space));
            if (reminder > 0) {
                line.set(i, line.get(i) + spaces(1));
                reminder--;
            }
        }
        return String.join("", line);
    }

    private String buildLastLine(int maxWidth, List<String> line) {
        String lineStr = String.join(" ", line);
        int trailingSpaces = maxWidth - lineStr.length();
        return lineStr + spaces(trailingSpaces);
    }

    private String spaces(int spaces) {
        return " ".repeat(spaces);
    }
}
