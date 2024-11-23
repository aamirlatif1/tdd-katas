package com.ss.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class TextJustificationTest {

    private TextJustification justification;

    @BeforeEach
    void setUp() {
        justification = new TextJustification();
    }

    @Test
    public void oneWordWithSameWidth() {
        String[] words = {"test"};

        List<String> result = justification.fullJustify(words, 4);

        assertThat(result, is(List.of("test")));
    }

    @Test
    public void oneWordWithExtraSpaces() {
        String[] words = {"test"};

        List<String> result = justification.fullJustify(words, 6);

        assertThat(result, is(List.of("test  ")));
    }

    @Test
    public void twoWordsOfGivenWidth() {
        String[] words = {"test", "line"};

        List<String> result = justification.fullJustify(words, 4);

        assertThat(result, is(List.of("test", "line")));
    }

    @Test
    public void twoWordsCanFitInOneLine() {
        String[] words = {"test", "line"};

        List<String> result = justification.fullJustify(words, 9);

        assertThat(result, is(List.of("test line")));
    }

    @Test
    public void threeWordWithUnevenSpaces() {
        String[] words = {"a", "test", "line", "with", "spaces" };

        List<String> result = justification.fullJustify(words, 12);

        assertThat(result, is(List.of("a  test line", "with spaces ")));
    }

    @Test
    public void withMultipleLinesAndSpaces() {
        String[] words = {"Science","is","what","we","understand","well","enough"
                ,"to","explain","to","a","computer.","Art","is","everything","else","we","do" };

        List<String> result = justification.fullJustify(words, 20);

        assertThat(result, is(List.of("Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ")));
    }

}
