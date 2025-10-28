package com.patterns.twoPointers;

/*
* Statement
* Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.
* A phrase is considered a palindrome if it reads the same backward as forward after converting
* all uppercase letters to lowercase and removing any characters that are not letters or numbers.
* Only alphanumeric characters (letters and digits) are taken into account.
*
* Constraints:
* 1 ≤ s.length ≤ 3000
* s consists only of printable ASCII characters.
* */
public class ValidPalindrome {
    public static boolean isValidPalindrome(String sentence) {
        int start = 0, end = sentence.length()-1;
        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(sentence.charAt(start)))
                start++;
            while(start < end && !Character.isLetterOrDigit(sentence.charAt(end)))
                end--;
            if(start < end && Character.toLowerCase(sentence.charAt(start)) != Character.toLowerCase(sentence.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
        /*
        * Time Complexity = o(n)
        * Space Complexity = o(1)
        * */
    }

    public static void main(String[] args) {
        System.out.println("Madam, in Eden, Im Adam -->" + isValidPalindrome("Madam, in Eden, Im Adam"));
        System.out.println("kaYak -->" + isValidPalindrome("kaYak"));
        System.out.println("RaCEACAR -->" + isValidPalindrome("RaCEACAR"));
        System.out.println("@#$%^&* -->" + isValidPalindrome("@#$%^&*"));
        System.out.println("Able was I, I saw Elba -->" + isValidPalindrome("Able was I, I saw Elba"));
    }
}
