package com.techmisal.medium;

import java.util.HashMap;

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
        String spacesRemovedOriginalWord = originalWord.replaceAll(" ", "");
        String spacesRemovedAnagram = anagram.replaceAll(" ", "");

        if (spacesRemovedAnagram.length() != spacesRemovedOriginalWord.length()) {
            return false;
        }

        String lowerCaseOriginalWord = spacesRemovedOriginalWord.toLowerCase();
        String lowerCaseAnagram = spacesRemovedAnagram.toLowerCase();

        HashMap<Character, Integer> letterCountsMap = new HashMap<>(lowerCaseAnagram.length());

        for (int i = 0; i < lowerCaseOriginalWord.length(); i++) {
            char originalWordCharKey = lowerCaseOriginalWord.charAt(i);
            Integer originalWordIntValue = letterCountsMap.get(originalWordCharKey) == null ? 0 : letterCountsMap.get(originalWordCharKey);
            letterCountsMap.put(originalWordCharKey, ++originalWordIntValue);

            char anagramWordCharKey = lowerCaseAnagram.charAt(i);
            Integer anagramIntValue = letterCountsMap.get(anagramWordCharKey) == null ? 0 : letterCountsMap.get(anagramWordCharKey);
            letterCountsMap.put(anagramWordCharKey, --anagramIntValue);
        }

        return letterCountsMap.values().stream().mapToInt(Integer::intValue).sum() == 0;
    }

    public static void main(String[] args) {
        new ValidAnagram().isValidAnagram("1234", "1234");
    }

}
