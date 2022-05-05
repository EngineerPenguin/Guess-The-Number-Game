import java.util.Scanner;
import java.util.Random;

public class Main {
    static String player1 = "";
    static boolean victory = false;
    static int min = 0;
    static int max = 20;
    static int range = max - min;
    static Random randomNumber = new Random();
    static int randomNum = randomNumber.nextInt(20) + 1;
    static int numOfGuess = 1;
    static String playAgain = "";

    public static void main(String[] args) {
        getName();
        startGame();
    }

    public static void getName() {
        System.out.println("Hello! What is your name?");
        Scanner name = new Scanner(System.in); // get users name
        System.out.print("Enter Name: ");
        String player1 = name.nextLine(); // read username
    }

    public static void playAgainPrompt() {
        System.out.print(" " + "Would you like to play again? (y/n): ");
        Scanner sc = new Scanner(System.in);
        playAgain = sc.nextLine();

        if (playAgain.equals("y") || playAgain.equals("Y")) {
            System.out.println("Alright here we go again");
            resetGame();

        } else if (playAgain.equals("n") || playAgain.equals("N")) {
            System.out.println("Thank you for playing!");

        } else {
            playAgainPrompt();
        }
    }

    public static void resetGame(){
        victory = false;
        randomNum = randomNumber.nextInt(20) + 1;
        startGame();
    }

        public static void startGame(){
            System.out.println("Hello " + player1 + " I want to play a game.\n" +
                    "I am thinking of a number between 1 - 20.\n" +
                    "you have 6 tries to get it right...");
        try {
            int attempt = 0;
            while (true) {
                System.out.print("Take a guess: ");
                Scanner firstGuess = new Scanner(System.in); // get player1 guess
                String guessStr = firstGuess.nextLine(); // read guess
                int guess1 = Integer.parseInt(guessStr);

                if (guess1 == randomNum) {
                    System.out.println("lucky guess... You win :)"); // win end game
                    break;

                } else if (guess1 < randomNum) {
                    System.out.println("Too low, try again. I insist.");
                    attempt++;

                } else {
                    System.out.println("Too high, try again. I insist.");
                    attempt++;
                }
                if (attempt > 5) {
                    System.out.print("Game over. Attempt limit reached. My number was" + " " + randomNum);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Code: FROG. You used illegal character");
        } finally{
            playAgainPrompt();
        }
    }
}
