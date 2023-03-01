package slidingwindow;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int windowStart = 0;
        int sLength = s.length(), pLength = p.length();
        List<Integer> anagramIndices = new ArrayList<>();

        if (sLength < pLength) {
            return anagramIndices;
        }

        Map<Character, Integer> sCharFrequencyMap = getCharFrequencyMap(s.substring(0, pLength));
        Map<Character, Integer> pCharFrequencyMap = getCharFrequencyMap(p);

        for (int windowEnd = pLength; windowEnd < sLength; windowEnd++) {
            if (sCharFrequencyMap.equals(pCharFrequencyMap)) {
                anagramIndices.add(windowStart);
            }

            char charAtEnd = s.charAt(windowEnd);
            sCharFrequencyMap.put(charAtEnd, sCharFrequencyMap.getOrDefault(charAtEnd, 0) + 1);

            char charAtStart = s.charAt(windowStart++);
            sCharFrequencyMap.put(charAtStart, sCharFrequencyMap.get(charAtStart) - 1);

            if (sCharFrequencyMap.get(charAtStart) == 0) {
                sCharFrequencyMap.remove(charAtStart);
            }
        }

        if (sCharFrequencyMap.equals(pCharFrequencyMap)) {
            anagramIndices.add(windowStart);
        }

        return anagramIndices;
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
