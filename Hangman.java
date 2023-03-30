import java.util.Scanner;

public class Hangman {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int wrongGuesses = 0;
        int counter = 0;

        String[] arrayToGuess = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
                "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
                "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                "wombat", "zebra" };
        String[] alreadyGuessedChars = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                " " };
        String wordToGuess = wordToguess(arrayToGuess);

        while (wrongGuesses < 6) {

            printArray(hangmanTemplates(wrongGuesses));
            System.out.print("\nWord: ");
            blankedWord(wordToGuess, alreadyGuessedChars);
            System.out.print("\nMisses: ");
            printGuessedChars(alreadyGuessedChars, wordToGuess);
            String askedChar = askChar(alreadyGuessedChars);
            alreadyGuessedChars[counter] = askedChar;
            counter++;
            if (checkHangman(wordToGuess, askedChar) == 1) {
                wrongGuesses++;
            }
            if (checkWin(wordToGuess, alreadyGuessedChars) == 1) {
                System.out.println("Word: " + wordToGuess);
                System.out.println("GOOD WORK");
                System.exit(0);
            }

        }
        printArray(hangmanTemplates(wrongGuesses));
        System.out.println("Word: " + wordToGuess);
        System.out.println("You have lost");
    }

    /*
     * function to print array
     * param String[][] array
     * returns void
     */
    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\n\t");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }

        }
        System.out.print("\n");
    }

    /*
     * function to store hangman templates
     * param int number of wrong guesses
     * returns String[][] hangman
     */
    public static String[][] hangmanTemplates(int i) {
        switch (i) {
            case 1:
                String[][] one = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return one;
            case 2:
                String[][] two = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return two;
            case 3:
                String[][] three = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { "/", "|", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return three;
            case 4:
                String[][] four = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { "/", "|", "\\", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return four;
            case 5:
                String[][] five = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { "/", "|", "\\", " ", " ", "|" },
                        { "/", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return five;
            case 6:
                String[][] six = {

                        { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", "O", " ", " ", " ", "|" },
                        { "/", "|", "\\", " ", " ", "|" },
                        { "/", " ", "\\", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return six;
            default:
                String[][] defaultString = { { " ", "+", "-", "-", "-", "+" },
                        { " ", "|", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", " ", " ", " ", " ", "|" },
                        { " ", "=", "=", "=", "=", "=", "=", "=", "=", "=" } };
                return defaultString;
        }
    }

    /*
     * function to pick random word
     * param String[] words to guess
     * returns String random word
     */
    public static String wordToguess(String[] words) {
        String randomWord = words[(int) (Math.random() * words.length)];
        return randomWord;
    }

    /*
     * function ask player character
     * param none
     * return character
     */
    public static String askChar(String[] alreadyGuessedChars) {
        System.out.print("Guess:\t");
        String guessedChar = scan.nextLine();
        for (int i = 0; i < alreadyGuessedChars.length; i++) {
            while (alreadyGuessedChars[i].charAt(0) == guessedChar.charAt(0)) {
                System.out.println("Already guessed!");
                System.out.print("Guess:\t");
                guessedChar = scan.nextLine();
            }
        }
        return guessedChar;
    }

    /*
     * function to print guessed chars
     * param characters
     * returns void printed characters
     */
    public static void printGuessedChars(String[] alreadyGuessedChars, String wordToGuess) {

        for (int i = 0; i < alreadyGuessedChars.length; i++) {
            int charCount = 0;
            if (alreadyGuessedChars[i] == null) {
                break;
            } else {
                for (int j = 0; j < wordToGuess.length(); j++) {
                    if (alreadyGuessedChars[i].charAt(0) == wordToGuess.charAt(j)) {
                        charCount--;
                    }
                }

            }
            if (charCount == 0) {
                System.out.print(alreadyGuessedChars[i]);
            }
        }
        System.out.print("\n");
    }

    /*
     * function that returns blank word, if correct char is guessed then it is
     * revealed
     * param String wordToguess
     * String[] alreadyGuessedChars
     * returns void, printed word
     */
    public static void blankedWord(String wordToguess, String[] alreadyGuessedChars) {

        for (int i = 0; i < wordToguess.length(); i++) {
            int count = 0;
            for (int j = 0; j < alreadyGuessedChars.length - 1; j++) {
                if (alreadyGuessedChars[j].charAt(0) == wordToguess.charAt(i)) {
                    System.out.print(wordToguess.charAt(i) + " ");
                } else {
                    count++;
                }

            }
            if (count >= alreadyGuessedChars.length - 1) {
                System.out.print("_ ");
            }
        }
    }

    /*
     * functin to trigger win condition
     * param String wordTogues
     * param String[] alreadyGuessedChars
     * returns int win condition
     */
    public static int checkWin(String wordToguess, String[] alreadyGuessedChars) {
        int winCounter = 1;
        for (int i = 0; i < wordToguess.length(); i++) {

            for (int j = 0; j < alreadyGuessedChars.length; j++) {
                if (alreadyGuessedChars[j].charAt(0) == wordToguess.charAt(i)) {
                    winCounter++;
                    break;
                }

            }

        }
        int winCondition = 0;
        if (winCounter > wordToguess.length()) {
            winCondition = 1;
        }
        return winCondition;
    }

    /*
     * function to check for incorrect answers
     * param String wordToguess
     * String askedChar
     * rises counter on hangman
     */
    public static int checkHangman(String wordToguess, String askedChar) {
        int hangmanCounter = 1;
        for (int i = 0; i < wordToguess.length(); i++) {

            for (int j = 0; j < askedChar.length(); j++) {
                if (askedChar.charAt(j) != wordToguess.charAt(i)) {
                    hangmanCounter++;
                    break;
                }

            }

        }
        int hangmanCounterOut = 0;
        if (hangmanCounter > wordToguess.length()) {
            hangmanCounterOut = 1;
        }
        return hangmanCounterOut;
    }
}
