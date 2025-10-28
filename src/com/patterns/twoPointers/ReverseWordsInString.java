package com.patterns.twoPointers;

/*
*
* Statement
You are given a string sentence that may contain leading or trailing spaces, as well as multiple spaces between words.
* Your task is to reverse the order of the words in the sentence without changing the order of characters within each word.
* Return the resulting modified sentence as a single string with words separated by a single space, and no leading or
* trailing spaces.
* Note: A word is defined as a continuous sequence of non-space characters.
* Multiple words separated by single spaces form a valid English sentence.
* Therefore, ensure there is only a single space between any two words in the returned string,
* with no leading, trailing, or extra spaces.
*
* Constraints:
* The sentence contains English uppercase and lowercase letters, digits, and spaces.
* There is at least one word in a sentence.
* 1 ≤ sentence.length ≤ 10^4
* */
public class ReverseWordsInString {
    public static String reverseWords_I(String sentence) {
        sentence = sentence.trim();
        int start=0, end=0, n = sentence.length();
        StringBuilder sb = new StringBuilder();
        while(end < n) {
            if(sentence.charAt(start) == ' ') {
                start++;
                end = start;
            } else {
                if(sentence.charAt(end) != ' ')
                    end ++;
                else {
                    String substring = sentence.substring(start,end);
                    sb.insert(0,substring + " ");
                    start = end;
                    end ++;
                }
            }
        }
        if(start < end && sentence.charAt(start) != ' ')
            sb.insert(0,sentence.substring(start,end) + " ");
        return sb.toString();
        /*
        * Time Complexity = o(n)
        * Space Complexity = o(n)
        * */
    }

    public static String reverseWords_II(String sentence) {
        sentence = sentence.trim();
        String[] arr = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.insert(0, s+" ");
        }
        return sb.toString();
        /*
         * Time Complexity = o(n)
         * Space Complexity = o(n)
         * */
    }

    public static String reverseWords_III(String sentence) {
        String[] arr = sentence.split("\\s+");
        int start =0, end = arr.length-1;
        while(start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return String.join(" ",arr);
        /*
         * Time Complexity = o(n)
         * Space Complexity = o(n)
         * */
    }

    public static void main(String[] args) {
        //Approach I - using string builder
        System.out.println("## Approach I:");
        System.out.println("-->My name      is Sayali    \n-->" + reverseWords_I("My name      is Sayali    "));
        System.out.println("\n-->I am a Software Engineer  \n-->" + reverseWords_I("I am a Software Engineer  "));
        System.out.println("\n-->   Reverse this      String      \n-->" + reverseWords_I("   Reverse this      String      "));

        //Approach II - using split function & stringbuilder
        System.out.println("\n\n## Approach II:");
        System.out.println("-->My name      is Sayali    \n-->" + reverseWords_II("My name      is Sayali    "));
        System.out.println("\n-->I am a Software Engineer  \n-->" + reverseWords_II("I am a Software Engineer  "));
        System.out.println("\n-->   Reverse this      String      \n-->" + reverseWords_II("   Reverse this      String      "));

        //Approach II - using split function
        System.out.println("\n\n## Approach III:");
        System.out.println("-->My name      is Sayali    \n-->" + reverseWords_III("My name      is Sayali    "));
        System.out.println("\n-->I am a Software Engineer  \n-->" + reverseWords_III("I am a Software Engineer  "));
        System.out.println("\n-->   Reverse this      String      \n-->" + reverseWords_III("   Reverse this      String      "));
    }
}
