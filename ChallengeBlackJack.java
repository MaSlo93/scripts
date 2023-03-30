import java.util.Scanner;

public class ChallengeBlackJack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();
        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        int playerScore = Math.min(playerCard1, 10) + Math.min(playerCard2, 10);
        System.out.println("\nYou get a \n" + card(playerCard1) + "\nand a \n" + card(playerCard2));
        System.out.println("Your total is: " + playerScore);

        scan.nextLine();
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerScore = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println("\nDealer gets a \n" + card(dealerCard1) + "\nand a \n" + faceDown());
        System.out.println("\nThe dealers total is hidden.");

        while (true) {
            String playerChoice = hitOrStay();
            if (playerChoice.equals("hit")) {
                int anotherCard = drawRandomCard();
                System.out.println("\nYou get a\n" + card(anotherCard));
                playerScore += Math.min(anotherCard, 10);
                System.out.println("Your total is " + playerScore);
            }
            if (playerChoice.equals("stay")) {
                break;
            }
            if (playerScore > 21) {
                System.out.println("Bust! Player loses.");
                System.exit(0);
            }
        }

        System.out.println("\nDealers turn" + "\nThe dealers cards are\n" + card(dealerCard1) + "\nand a\n"
                + card(dealerCard2) + "\nThe dealers total is " + dealerScore);

        while (true) {
            if (dealerScore < 17) {
                int anotherCard = drawRandomCard();
                scan.nextLine();
                System.out.println("\nDealer gets a\n" + card(anotherCard));
                dealerScore += Math.min(anotherCard, 10);
                System.out.println("Dealers total is " + dealerScore);

                if (dealerScore > 21) {
                    System.out.println("Bust! Dealer loses.");
                    System.exit(0);
                }
            } else {
                break;
            }
        }

        if (playerScore > dealerScore) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }

        scan.close();
    }

    public static String hitOrStay() {
        Scanner scan = new Scanner(System.in);
        String decision = "";
        while (true) {
            System.out.println("Please write 'hit' or 'stay'");
            decision = scan.nextLine();
            if (decision.equals("hit") || decision.equals("stay")) {
                break;
            }
        }
        return decision;
    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13 + 1;
        return (int) randomNumber;
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String card(int number) {
        switch (number) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";

            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";

            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";

            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return "";
        }
    }
}
