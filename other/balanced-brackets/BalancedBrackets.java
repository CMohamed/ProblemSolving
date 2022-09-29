import java.util.*;

public class BalancedBrackets {

    static final Set<Character> startBrackets = Set.of('(', '[', '{');
    static final Map<Character, Character> bracketsMap = Map.of('(', ')', '[', ']', '{', '}');

    public static void main(String[] args) {
        // Here you can add test cases
        Arrays.asList(
                "(())",
                "([])",
                "()()(())({})"
        ).forEach(expTest -> System.out.printf("%s is %s balanced%n", expTest, isBalancedBrackets(expTest) ? "" : "not"));
    }

    public static boolean isBalancedBrackets(String exp) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < exp.length(); i++) {
            Character chr = exp.charAt(i);
            if (bracketsMap.containsKey(chr)) {
                stack.push(chr);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character check = stack.pop();
            if (bracketsMap.get(check) != chr) {
                return false;
            }
        }
        return (stack.isEmpty());
    }
}