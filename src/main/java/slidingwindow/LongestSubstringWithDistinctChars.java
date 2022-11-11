package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithDistinctChars {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int stringLength = s.length();
        int longestLength = 0;
        Map<Character, Integer> characterIndexMap = new HashMap<>();

        for (int right = 0; right < stringLength; right++) {
            char currChar = s.charAt(right);

            if (characterIndexMap.containsKey(currChar) && left <= characterIndexMap.get(currChar)) {
                left = characterIndexMap.get(currChar) + 1;
            }

            characterIndexMap.put(currChar, right);

            longestLength = Math.max(longestLength, (right - left) + 1);
        }

        return longestLength;
    }
}
