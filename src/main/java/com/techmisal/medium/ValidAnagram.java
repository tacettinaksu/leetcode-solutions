package com.techmisal.medium;

import java.util.Arrays;

/**
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.[1]
 * <p>
 * For example,
 * the word "anagram" can be rearranged into "nag a ram",
 * or the word "binary" into "brainy".
 * <p>
 * <p>
 * Reference: https://en.wikipedia.org/wiki/Anagram
 */
public class ValidAnagram {

    public boolean isValidAnagram(String originalWord, String anagram) {
        String removeSpacesOriginalWord = originalWord.replaceAll(" ", "");
        String removeSpacesAnagram = anagram.replaceAll(" ", "");

        if (removeSpacesAnagram.length() != removeSpacesOriginalWord.length()) {
            return false;
        }

        String sortedOriginalWord = sortString(removeSpacesOriginalWord.toLowerCase());
        String sortedAnagram = sortString(removeSpacesAnagram.toLowerCase());

        return sortedOriginalWord.equals(sortedAnagram);
    }

    private String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

}
