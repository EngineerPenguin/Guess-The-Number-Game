import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int randomNumber = rand.nextInt(20) + 1;

        System.out.println("Hello! What is your name?");
        Scanner name = new Scanner(System.in); // get users name
        System.out.print("Enter Name: ");

        String player1 = name.nextLine(); // read username

        System.out.println("Hello " + player1 + " I want to play a game.\n" +
                "I am thinking of a number between 1 - 20.\n" +
                "you have 6 tries to get it right...");

        int attempt = 0;
        while (true) {
            System.out.print("Take a guess: ");
            Scanner firstGuess = new Scanner(System.in); // get player1 guess
            String guessStr = name.nextLine(); // read guess
            int guess1 = Integer.parseInt(guessStr);

            if (guess1 == randomNumber) {
                System.out.println("lucky guess... You win :)"); // win end game
                break;

            } else if (guess1 < randomNumber) {
                System.out.println("Too low, try again. I insist.");
                attempt++;

            } else if (attempt >= 6) {
                System.out.print("Game over. Attempt limit reached. My number was " + randomNumber);
                break;

            } else {
                System.out.println("Too high, try again. I insist.");
                attempt++;
            }
        }
    }
}
