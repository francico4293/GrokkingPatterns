package twopointers;

import java.util.Stack;

public class BackspaceStringCompare {
    public static char BACKSPACE_CHAR = '#';

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        processString(s, sStack);
        processString(t, tStack);

        return sStack.equals(tStack);
    }

    public void processString(String str, Stack<Character> stack) {
        int strLength = str.length();

        for (int idx = 0; idx < strLength; idx++) {
            char c = str.charAt(idx);

            if (!stack.isEmpty() && c == BACKSPACE_CHAR) {
                stack.pop();
            } else if (c != BACKSPACE_CHAR) {
                stack.push(c);
            }
        }
    }
}
