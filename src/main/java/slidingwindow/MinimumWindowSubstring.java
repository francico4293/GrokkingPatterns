package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int charactersFound = 0;
        int stringLength = s.length(), patternLength = t.length();
        int left = 0;
        int minLength = stringLength + 1;
        int substringStart = left;
        Map<Character, Integer> patternCharFrequencyMap = getCharacterFrequencyMap(t);

        for (int right = 0; right < stringLength; right++) {
            char rightChar = s.charAt(right);

            if (patternCharFrequencyMap.containsKey(rightChar)) {
                if (patternCharFrequencyMap.get(rightChar) > 0) {
                    charactersFound++;
                }

                patternCharFrequencyMap.put(rightChar, patternCharFrequencyMap.get(rightChar) - 1);
            }

            while (charactersFound == patternLength) {
                if ((right - left) + 1 < minLength) {
                    minLength = (right - left) + 1;
                    substringStart = left;
                }

                char leftChar = s.charAt(left++);

                if (patternCharFrequencyMap.containsKey(leftChar)) {
                    patternCharFrequencyMap.put(leftChar, patternCharFrequencyMap.get(leftChar) + 1);

                    if (patternCharFrequencyMap.get(leftChar) > 0) {
                        charactersFound--;
                    }
                }
            }
        }

        return minLength > s.length() ? "" : s.substring(substringStart, substringStart + minLength);
    }

    private Map<Character, Integer> getCharacterFrequencyMap(String string) {
        int stringLength = string.length();
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (int idx = 0; idx < stringLength; idx++) {
            char currChar = string.charAt(idx);
            characterFrequencyMap.put(
                    currChar,
                    characterFrequencyMap.getOrDefault(currChar, 0) + 1
            );
        }

        return characterFrequencyMap;
    }
}
