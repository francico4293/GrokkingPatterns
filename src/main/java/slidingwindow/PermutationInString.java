package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int s1Length = s1.length(), s2Length = s2.length();

        if (s2Length < s1Length) {
            return false;
        }

        Map<Character, Integer> s1CharFrequencyMap = getCharFrequencyMap(s1);
        Map<Character, Integer> s2CharFrequencyMap = getCharFrequencyMap(s2.substring(0, s1Length));

        for (int windowEnd = s1Length; windowEnd< s2Length; windowEnd++) {
            if (s1CharFrequencyMap.equals(s2CharFrequencyMap)) {
                return true;
            }

            char charAtEnd = s2.charAt(windowEnd);

            s2CharFrequencyMap.put(charAtEnd, s2CharFrequencyMap.getOrDefault(charAtEnd, 0) + 1);

            char charAtStart = s2.charAt(windowStart++);

            if (s2CharFrequencyMap.get(charAtStart) == 1) {
                s2CharFrequencyMap.remove(charAtStart);
            } else {
                s2CharFrequencyMap.put(charAtStart, s2CharFrequencyMap.get(charAtStart) - 1);
            }
        }

        return s1CharFrequencyMap.equals(s2CharFrequencyMap);
    }

    private Map<Character, Integer> getCharFrequencyMap(String string) {
        int stringLength = string.length();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int idx = 0; idx < stringLength; idx++) {
            char currChar = string.charAt(idx);
            charFrequencyMap.put(currChar, charFrequencyMap.getOrDefault(currChar, 0) + 1);
        }

        return charFrequencyMap;
    }
}
