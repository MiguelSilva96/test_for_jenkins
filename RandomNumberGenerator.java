import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        // Create an instance of Random class
        Random random = new Random();
        
        // Generate and print 10 random numbers
        System.out.println("10 Random Numbers:");
        for (int i = 0; i < 10; i++) {
            // Generate a random integer between 0 and 100
            int randomNumber = random.nextInt(100); // Change 100 to any upper limit
            System.out.println(randomNumber);
        }
    }
}
