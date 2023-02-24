package fastandslowpointers;

public class HappyNumbers {

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = sumOfDigitsSquared(slow);
            fast = sumOfDigitsSquared(sumOfDigitsSquared(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int sumOfDigitsSquared(int n) {
        int sum = 0;

        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }
}
