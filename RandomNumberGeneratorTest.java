import java.util.HashSet;
import java.util.Random;

public class RandomNumberGeneratorTest {
    
    private final Random random;

    // Constructor to allow dependency injection for better testing
    public RandomNumberGeneratorTest(Random random) {
        this.random = random;
    }

    // Generate an array of random integers
    public int[] generateRandomNumbers(int count, int upperLimit) {
        int[] randomNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextInt(upperLimit);
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        RandomNumberGenerator rng = new RandomNumberGeneratorTest(new Random());

        // Run tests
        testRandomNumberGenerator(rng);
    }

    // Method to test the random number generator
    public static void testRandomNumberGenerator(RandomNumberGenerator rng) {
        int[] randomNumbers = rng.generateRandomNumbers(10, 100);

        // Check if the array length is 10
        if (randomNumbers.length != 10) {
            System.out.println("Test Failed: Expected array length of 10, but got " + randomNumbers.length);
        } else {
            System.out.println("Test Passed: Correct array length.");
        }

        // Check if all numbers are within the expected range
        boolean inRange = true;
        for (int number : randomNumbers) {
            if (number < 0 || number >= 100) {
                inRange = false;
                break;
            }
        }
        if (inRange) {
            System.out.println("Test Passed: All numbers are within the range of 0 to 99.");
        } else {
            System.out.println("Test Failed: Some numbers are out of range.");
        }

        // Check for uniqueness (at least some unique values)
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int number : randomNumbers) {
            uniqueNumbers.add(number);
        }

        if (uniqueNumbers.size() >= 5) {
            System.out.println("Test Passed: At least 5 unique numbers found.");
        } else {
            System.out.println("Test Failed: Fewer than 5 unique numbers.");
        }
    }
}
