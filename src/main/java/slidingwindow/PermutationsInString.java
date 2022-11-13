package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class PermutationsInString {

    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        int left = 0, right = s1Length;

        Map<Character, Integer> s1CharacterFrequencyMap = getCharacterFrequencyMap(s1);
        Map<Character, Integer> s2CharacterFrequencyMap = getCharacterFrequencyMap(s2.substring(left, right));

        while (right < s2Length) {
            if (s1CharacterFrequencyMap.equals(s2CharacterFrequencyMap)) {
                return true;
            }

            char rightChar = s2.charAt(right);

            if (s2CharacterFrequencyMap.containsKey(rightChar)) {
                s2CharacterFrequencyMap.put(rightChar, s2CharacterFrequencyMap.get(rightChar) + 1);
            } else {
                s2CharacterFrequencyMap.put(rightChar, 1);
            }

            right++;

            char leftChar = s2.charAt(left);

            if (s2CharacterFrequencyMap.get(leftChar) == 1) {
                s2CharacterFrequencyMap.remove(leftChar);
            } else {
                s2CharacterFrequencyMap.put(leftChar, s2CharacterFrequencyMap.get(leftChar) - 1);
            }

            left++;
        }

        return s1CharacterFrequencyMap.equals(s2CharacterFrequencyMap);
    }

    private Map<Character, Integer> getCharacterFrequencyMap(String string) {
        int stringLength = string.length();
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (int idx = 0; idx < stringLength; idx++) {
            char c = string.charAt(idx);

            if (characterFrequencyMap.containsKey(c)) {
                characterFrequencyMap.put(c, characterFrequencyMap.get(c) + 1);
            } else {
                characterFrequencyMap.put(c, 1);
            }
        }

        return characterFrequencyMap;
    }
}
