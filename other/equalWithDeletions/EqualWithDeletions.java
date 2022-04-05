import java.util.*;

/**
Given two strings n and m, return true if they are equal when both are entered into text editors.
But: a # means a backspace character (deleting backwards), and a % means a delete character (deleting forwards).
Example:
> equalWithDeletions("a##x", "#a#x")
> true      // both strings become "x"
> equalWithDeletions("fi##f%%%th %%year #time###", "fifth year time")
> false     // the first string becomes "fart"
 */


public class EqualWithDeletions {
    
    public static void main(String[] args) {
        String a = "a%#abc";
        String b = "bc";
        System.out.println(equalWithDeletions(a, b));
    }

    public static boolean equalWithDeletions(String a, String b) {
        return extracted(a).equals(extracted(b));
    }

    private static List<Character> extracted(String a) {
        List<Character> A = new ArrayList<>();
        int forwardDeletions = 0;
        for (char c : a.toCharArray()) {
            if (c == '#') {
                // if non empty remove last character
                if (!A.isEmpty()) A.remove(A.size() - 1);
            } else if (c == '%') {
                forwardDeletions++;
            } else if (forwardDeletions > 0) {
                forwardDeletions--;
            } else {
                A.add(c);
            }
        }
        return A;
    }
}