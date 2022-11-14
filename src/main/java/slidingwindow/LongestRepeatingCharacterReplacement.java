package slidingwindow;

import java.util.Map;
import java.util.HashMap;

// AABABBA

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int stringLength = s.length();
        int maxRepeatingCharacterCount = 0;
        int longestLength = 0;

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (int right = 0; right < stringLength; right++) {
            char currChar = s.charAt(right);

            characterFrequencyMap.put(
                    currChar,
                    characterFrequencyMap.getOrDefault(currChar, 0) + 1
            );

            maxRepeatingCharacterCount = Math.max(maxRepeatingCharacterCount, characterFrequencyMap.get(currChar));

            int windowSize = (right - left) + 1;

            while ((windowSize - maxRepeatingCharacterCount) > k) {
                currChar = s.charAt(left++);
                characterFrequencyMap.put(currChar, characterFrequencyMap.get(currChar) - 1);
                windowSize = (right - left) + 1;
            }

            longestLength = Math.max(longestLength, (right - left) + 1);
        }

        return longestLength;
    }
}
