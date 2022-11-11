package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithKDistinctChars {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int stringLength = s.length();
        int longestLength = 0;
        int distinctCharsInWindow = 0;
        Map<Character, Integer> charactersInWindow = new HashMap<>();

        for (int right = 0; right < stringLength; right++) {
            char currChar = s.charAt(right);
            if (charactersInWindow.containsKey(currChar)) {
                charactersInWindow.put(currChar, charactersInWindow.get(currChar) + 1);
            } else {
                charactersInWindow.put(currChar, 1);
                distinctCharsInWindow++;
            }

            while (distinctCharsInWindow > k) {
                currChar = s.charAt(left++);
                if (charactersInWindow.get(currChar) == 1) {
                    charactersInWindow.remove(currChar);
                    distinctCharsInWindow--;
                } else {
                    charactersInWindow.put(currChar, charactersInWindow.get(currChar) - 1);
                }
            }

            longestLength = Math.max(longestLength, (right - left) + 1);
        }

        return longestLength;
    }
}
