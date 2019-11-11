import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Player 1's Name : ");
        Player player1 = new Player(scan.nextLine());
        System.out.println("Player 1 is " + player1.getName());

        System.out.println("Enter Player 2's Name : ");
        Player player2 = new Player(scan.nextLine());
        System.out.println("Player 2 is " + player2.getName());

        Board board = new Board();
        Dice dice = new Dice();
        int rolledNumber;
        boolean player1out = false;
        boolean player2out = false;
        int lastTurn = 2;
        System.out.println("So here is the snakes and ladders Board, enter 'roll' \n" +
                " on your turn to roll the dice. Lets starts!");

        while (true) {
            String next;
                if (lastTurn == 2) {
                    System.out.println(player1.getName() + "'s turn.");
                    next = scan.nextLine();
                    if (next.equals("roll")) {
                        rolledNumber = dice.roll();
                        System.out.println(player1.getName() + " rolled " + rolledNumber);
                        if (rolledNumber == 6 || player1out) {
                            player1out = true;
                            player1.changePosition(rolledNumber);
                            if (player1.getPosition() >= 100) {
                                System.out.println(player1.getName() + " won!");
                                break;
                            }
                            System.out.println(player1.getName() + " is at " + player1.getPosition());
                            if (board.dec(player1.getPosition()) != -1) {
                                System.out.println("A snake bit " + player1.getName() + " at " + player1.getPosition());
                                player1.setPosition(board.dec(player1.getPosition()));
                                System.out.println(player1.getName() + " is at " + player1.getPosition());
                            } else if (board.inc(player1.getPosition()) != -1) {
                                System.out.println(player1.getName() + " got a ladder at " + player1.getPosition());
                                player1.setPosition(board.inc(player1.getPosition()));
                                System.out.println(player1.getName() + " is at " + player1.getPosition());
                            }
                        } else {
                            System.out.println("You can only play after rolling one 6.");
                            System.out.println(player1.getName() + " is at " + player1.getPosition());
                        }
                    }
                    lastTurn = 1;
                } else {
                    System.out.println(player2.getName() + "'s turn.");
                    next = scan.nextLine();
                    if (next.equals("roll")) {
                        rolledNumber = dice.roll();
                        System.out.println(player2.getName() + " rolled " + rolledNumber);
                        if (rolledNumber == 6 || player2out) {
                            player2out = true;
                            player2.changePosition(rolledNumber);
                    if (player2.getPosition() >= 100) {
                        System.out.println(player2.getName() + " won!");
                        break;
                    }
                    System.out.println(player2.getName() + " is at " + player2.getPosition());
                    if (board.dec(player2.getPosition()) != -1) {
                        System.out.println("A snake bit " + player2.getName() + " at " + player2.getPosition());
                        player2.setPosition(board.dec(player2.getPosition()));
                        System.out.println(player2.getName() + " is at " + player2.getPosition());
                    } else if (board.inc(player2.getPosition()) != -1) {
                        System.out.println(player2.getName() + " got a ladder at " + player2.getPosition());
                        player2.setPosition(board.inc(player2.getPosition()));
                        System.out.println(player2.getName() + " is at " + player2.getPosition());
                    }
                        } else {
                            System.out.println("You can only play after rolling one 6.");
                            System.out.println(player2.getName() + " is at " + player2.getPosition());
                        }
                    lastTurn = 2;
                }
            }
            board.printBoard(player1.getPosition(), player2.getPosition());
        }
    }
}
