package com.techmisal.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

public class ValidAnagramTest {

    private ValidAnagram underTest = new ValidAnagram();

    @Test
    public void test_changing_order_of_letters_should_not_invalidate_anagram_rule() {
        String originalWord = "brainy";
        String anagramWord = "binary";
        Assert.assertTrue(underTest.isValidAnagram(originalWord, anagramWord));
    }


    @Test
    public void test_spaces_in_word_should_not_invalidate_anagram_rule() {
        String originalWord = "anagram";
        String anagramWord = "nag a ram";
        Assert.assertTrue(underTest.isValidAnagram(originalWord, anagramWord));
    }

    @Test
    public void test_anagram_rule_should_not_case_sensitive() {
        String originalWord = "anagram";
        String anagramWord = "NagAraM";
        Assert.assertTrue(underTest.isValidAnagram(originalWord, anagramWord));
    }
}
