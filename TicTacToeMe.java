import java.util.Scanner;

public class TicTacToeMe {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] field = new String[3][3];

        fillEmptyArr(field);
        printArray(field);

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                turnX(field);
                printArray(field);
            } else {
                turnO(field);
                printArray(field);
            }
            System.out.println("skore " + checkWin(field));
            if (checkWin(field) == 3) {
                System.out.println("X wins!");
                System.exit(0);
            }
            if (checkWin(field) == -3) {
                System.out.println("O wins!");
                System.exit(0);
            }
        }
        System.out.println("Its a tie!");
        System.exit(0);

        scan.close();

    }

    /*
     * function to fill array with _ signs
     * param String[][] array
     * return String[][] array
     */
    public static String[][] fillEmptyArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] = "_";

            }
        }
        return arr;
    }

    /*
     * function to print out array
     * param String[][] array
     * return void
     */
    public static void printArray(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print("\n\t");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

        }
        System.out.println("\n");
    }

    /*
     * X turn function
     * param String[][] array
     * return String[][] array
     */
    public static String[][] turnX(String[][] arr) {

        System.out.print("Turn: X");
        System.out.print(" - pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();
        String X = "X";
        while (!arr[row][column].equals("_")) {
            System.out.print("Spot is taken, try again.");
            row = scan.nextInt();
            column = scan.nextInt();

        }
        arr[row][column] = X;
        return arr;
    }

    public static String[][] turnO(String[][] arr) {

        System.out.print("Turn: O" + "\n - pick a row and column number: ");
        int row = scan.nextInt();
        System.out.print(" ");
        int column = scan.nextInt();
        String O = "O";
        while (!arr[row][column].equals("_")) {
            System.out.print("Spot is taken, try again.");
            row = scan.nextInt();
            column = scan.nextInt();

        }
        arr[row][column] = O;
        return arr;
    }

    public static int checkWin(String[][] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[j][j].equals("X")) {
                    counter++;

                }
                if (arr[j][j].equals("O")) {
                    counter--;

                }

            }
            if (counter == 3 || counter == -3) {
                break;
            }
            if ((counter < 3) && (counter > -3)) {
                counter = 0;

            }

        }

        if (counter == 0)

        {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[j][2 - j].equals("X")) {
                        counter++;

                    }
                    if (arr[j][2 - j].equals("O")) {
                        counter--;

                    }

                }
                if (counter == 3 || counter == -3) {
                    break;

                }
                if ((counter < 3) && (counter > -3)) {
                    counter = 0;
                }
            }
        }
        if (counter == 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j].equals("X")) {
                        counter++;
                    }
                    if (arr[i][j].equals("X")) {
                        counter--;
                    }

                }
                if (counter == 3 || counter == -3) {
                    break;
                }
                if ((counter < 3) && (counter > -3)) {
                    counter = 0;
                }

            }
        }
        if (counter == 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[j][i].equals("X")) {
                        counter++;
                    }
                    if (arr[j][i].equals("O")) {
                        counter--;
                    }
                }
                if (counter == 3 || counter == -3) {
                    break;

                }
                if ((counter < 3) && (counter > -3)) {
                    counter = 0;
                }
            }
        }
        return counter;
    }
}
