import slidingwindow.PermutationInString;

public class Main {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";

        PermutationInString permutationInString = new PermutationInString();
        boolean result = permutationInString.checkInclusion(s1, s2);
        System.out.println("Result = " + result);
    }
}
