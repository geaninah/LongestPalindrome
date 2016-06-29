import java.util.*;

public class Palindrome
{
    // Check if a string is a palindrome
    static boolean isPalindrome(String x)
    {
        StringBuffer reverseString = new StringBuffer(x);
        reverseString.reverse();
        
        return x.compareTo(reverseString.toString()) == 0;
    }

    static Pair longestPalindrome(String x)
    {
        if(x.isEmpty())
        {
            return new Pair(0, 0);
        }

        char[] array = x.toCharArray();

        String palindrome = "";
        int indexOfPalindrome = 0, length = 1;
        
        for(int index1 = 0; index1 < array.length; index1++)
        {
            String sequence = array[index1] + "";
            for(int index2 = index1 + 1; index2 < array.length; index2++)
            {
                // Create sequence adding letters one by one and checking if the sequence is a palindrome
                sequence = sequence + "" + array[index2];
                if(isPalindrome(sequence))
                {
                    if(sequence.length() > length)
                    {
                        palindrome = sequence;
                        length = sequence.length();
                        indexOfPalindrome = index1;
                    }
                }
            }
        }

        return new Pair(indexOfPalindrome, length);
    }

    public static void main(String args[])
    {
        Pair pair = longestPalindrome("abaaaabbbbabababa");

        System.out.println("abaaaabbbbabababa");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();

        System.out.println("abba");
        pair = longestPalindrome("abba");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();

        System.out.println("abcd");
        pair = longestPalindrome("abcd");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();

        System.out.println("");
        pair = longestPalindrome("");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();

        System.out.println("a");
        pair = longestPalindrome("a");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();

        System.out.println("aa");
        pair = longestPalindrome("aa");
        System.out.println(pair.getIndex());
        System.out.println(pair.getLength());
        System.out.println();
    }
}