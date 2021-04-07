package ProHot_100;

import java.util.Stack;

/**
 * @author danchun
 * @date 2021/4/7 12:01
 */
public class Pro020_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * <p>
     * Example 1:
     * Input: s = "()"
     * Output: true
     * <p>
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     * <p>
     * Example 3:
     * Input: s = "(]"
     * Output: false
     * <p>
     * Example 4:
     * Input: s = "([)]"
     * Output: false
     * <p>
     * Example 5:
     * Input: s = "{[]}"
     * Output: true
     * <p>
     * Constraints:
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     */
    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0)
                return true;
            if (s.length() % 2 != 0)
                return false;

            Stack<Character> charStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    charStack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (charStack.isEmpty())
                        return false;
                    char c2 = charStack.pop();
                    if ((c2 == '(' && c == ')')
                            || (c2 == '{' && c == '}')
                            || (c2 == '[' && c == ']')) {
                        continue;
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return charStack.empty();
        }
    }
}
