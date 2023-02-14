package twopointers;

import java.util.Stack;

public class BackspaceStringCompare {
    private static final char BACKSPACE = '#';

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = processString(s);
        Stack<Character> tStack = processString(t);

        return sStack.equals(tStack);
    }

    private Stack<Character> processString(String string) {
        int stringLength = string.length();
        Stack<Character> stack = new Stack<>();

        for (int idx = 0; idx < stringLength; idx++) {
            char currChar = string.charAt(idx);

            if (!stack.isEmpty() && currChar == BACKSPACE) {
                stack.pop();
            } else if (currChar != BACKSPACE) {
                stack.push(currChar);
            }
        }

        return stack;
    }
}
