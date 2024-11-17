package com.ss.anagram;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    public List<String> generate(String input) {
        List<String> anagrams = new ArrayList<>();

        generateAnagrams(anagrams, new StringBuilder(input), 0);
        return anagrams;
    }

    private void generateAnagrams(List<String> anagrams, StringBuilder word, int index) {
        if (index == word.length()-1) {
            anagrams.add(word.toString());
            return;
        }
        for (int i = index; i < word.length(); i++) {
            swap(word, index, i);
            generateAnagrams(anagrams, word, index+1);
            swap(word, index, i);
        }
    }

    private void swap(StringBuilder word, int i, int j){
        char temp = word.charAt(i);
        word.setCharAt(i, word.charAt(j));
        word.setCharAt(j, temp);
    }


}
