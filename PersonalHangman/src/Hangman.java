import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private static final int NUMBER_OF_TRIES = 5;
    private static String secretWord;
    private static String guessedWord;
    private static int tries;
    private static boolean guessed;
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> words = new ArrayList<String>();
    static {
        words.add("ONE");
        words.add("TWO");
        words.add("THREE");
        words.add("FOUR");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to my Hangman game!");
        initializeGame();
        do {
            System.out.println("Guess the letter: ");
            char letter = scanner.next().charAt(0);
            checkLetter(letter);
            printStatus();
        } while (tries >=0 && !guessed);
        if(guessed){
            System.out.println("Winner!");
        } else {
            System.out.println("Looser! Right word is " + secretWord + ".");
        }
    }

    public static void initializeGame() {
        secretWord = words.get((int) (Math.random() * words.size()));
        guessedWord = secretWord.replaceAll(".","*");
        tries = NUMBER_OF_TRIES;
        guessed = false;
    }
    public static void updateGuessedWord(char letter){
        char[] secretWordArray = secretWord.toCharArray();
        char[] guessedWordArray = guessedWord.toCharArray();
        for (int i = 0; i<secretWordArray.length; i++){
            if(secretWordArray[i] == letter){
                guessedWordArray[i] = letter;
            }
        }
        guessedWord = new String(guessedWordArray);
    }

    public static void checkLetter (char letter){
        if(secretWord.indexOf(letter)>=0){
            updateGuessedWord(letter);
            if(guessedWord.equals(secretWord)){
                guessed = true;
            } else {
                tries--;
            }
        }
    }

    private static void printStatus(){
        System.out.println("Guessed word is " + guessedWord);
        System.out.println("Tries left " + tries);
    }
}
