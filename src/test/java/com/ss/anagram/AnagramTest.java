package com.ss.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramTest {

    private Anagram anagram;

    private void assertAnagram(List<String> output, String[] expected) {
        assertTrue(output.size() == expected.length && List.of(expected).containsAll(output));
    }

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }

    @Test
    public void oneLetterAnagram() throws Exception {
        assertAnagram(anagram.generate("a"), new String[]{"a"});
    }

    @Test
    public void twoLetterAnagram() throws Exception {
        assertAnagram(anagram.generate("ab"), new String[]{"ab", "ba"});
    }

    @Test
    public void threeLetterAnagram() throws Exception {
        assertAnagram(anagram.generate("abc"), new String[]{"abc", "acb", "bac", "bca", "cab", "cba"});
    }

    @Test
    public void fourLetterAnagram() throws Exception {
        String[] expected = {
                "biro", "bior", "brio", "broi", "boir", "bori",
                "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                "rbio", "rboi", "ribo", "riob", "roib", "robi",
                "obir", "obri", "oibr", "oirb", "orbi", "orib"
        };

        assertAnagram(anagram.generate("biro"), expected);
    }
}
