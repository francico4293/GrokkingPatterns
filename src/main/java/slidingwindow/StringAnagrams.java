package slidingwindow;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length(), pLength = p.length();

        if (sLength < pLength) {
            return new ArrayList<>();
        }

        int left = 0, right = pLength;

        List<Integer> anagramIndexes = new ArrayList<>();

        Map<Character, Integer> sCharacterFrequencyMap = getCharacterFrequencyMap(s.substring(left, right));
        Map<Character, Integer> pCharacterFrequencyMap = getCharacterFrequencyMap(p);

        while (right < sLength) {
            if (pCharacterFrequencyMap.equals(sCharacterFrequencyMap)) {
                anagramIndexes.add(left);
            }

            char rightChar = s.charAt(right);

            if (sCharacterFrequencyMap.containsKey(rightChar)) {
                sCharacterFrequencyMap.put(rightChar, sCharacterFrequencyMap.get(rightChar) + 1);
            } else {
                sCharacterFrequencyMap.put(rightChar, 1);
            }

            right++;

            char leftChar = s.charAt(left);

            if (sCharacterFrequencyMap.get(leftChar) == 1) {
                sCharacterFrequencyMap.remove(leftChar);
            } else {
                sCharacterFrequencyMap.put(leftChar, sCharacterFrequencyMap.get(leftChar) - 1);
            }

            left++;
        }

        if (pCharacterFrequencyMap.equals(sCharacterFrequencyMap)) {
            anagramIndexes.add(left);
        }

        return anagramIndexes;
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
