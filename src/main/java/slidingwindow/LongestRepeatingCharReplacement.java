package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {
        int stringLength = s.length();
        int windowStart = 0;
        int longestLength = 0;
        int maxRepeatingChar = 0;
        Map<Character, Integer> charFrequencyInWindowMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < stringLength; windowEnd++) {
            char currCharAtEnd = s.charAt(windowEnd);

            if (charFrequencyInWindowMap.containsKey(currCharAtEnd)) {
                charFrequencyInWindowMap.put(currCharAtEnd, charFrequencyInWindowMap.get(currCharAtEnd) + 1);
            } else {
                charFrequencyInWindowMap.put(currCharAtEnd, 1);
            }

            maxRepeatingChar = Math.max(maxRepeatingChar, charFrequencyInWindowMap.get(currCharAtEnd));

            while ((windowEnd - windowStart + 1) - maxRepeatingChar > k) {
                char currCharAtStart = s.charAt(windowStart++);
                charFrequencyInWindowMap.put(currCharAtStart, charFrequencyInWindowMap.get(currCharAtStart) - 1);
            }

            longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
        }

        return longestLength;
    }
}
