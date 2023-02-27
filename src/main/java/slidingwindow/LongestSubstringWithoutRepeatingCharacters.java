package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();
        int longestSubstringLength = 0;
        int windowStart = 0;
        Map<Character, Integer> characterIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < stringLength; windowEnd++) {
            char currChar = s.charAt(windowEnd);

            if (characterIndexMap.containsKey(currChar) && characterIndexMap.get(currChar) >= windowStart) {
                windowStart = characterIndexMap.get(currChar) + 1;
            }

            characterIndexMap.put(currChar, windowEnd);

            longestSubstringLength = Math.max(longestSubstringLength, windowEnd - windowStart + 1);
        }

        return longestSubstringLength;
    }
}
