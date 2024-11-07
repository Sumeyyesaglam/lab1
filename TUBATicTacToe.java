import java.util.*;

public class TUBATicTacToe {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TUBATTTBoard board = new TUBATTTBoard();
        Random random = new Random();

        System.out.println("Welcome to Tic Tac Toe with a Capital Quiz!");

        // Başkent oyununu başlat ve oyuncunun başlayıp başlamayacağını öğren
        boolean isPlayerStarting = CapitalQuiz.startQuiz(reader);

        // Kullanıcıdan 'X' veya 'O' seçimi alınır
        char playerSymbol;
        while (true) {
            System.out.print("Do you want to be 'X' or 'O'? ");
            playerSymbol = reader.nextLine().toUpperCase().charAt(0);
            if (playerSymbol == 'X' || playerSymbol == 'O') {
                break;
            } else {
                System.out.println("Invalid choice. Please choose 'X' or 'O'.");
            }
        }

        char computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';
        boolean playerTurn = isPlayerStarting;

        System.out.println("You are '" + playerSymbol + "' and the computer is '" + computerSymbol + "'.");
        System.out.println(board);

        // Oyun döngüsü
        while (board.getWinner() == '-' && !board.full()) {
            int row, column;
            boolean success;
            System.out.println((playerTurn ? playerSymbol : computerSymbol) + "'s turn.");

            if (playerTurn) { // Oyuncunun hamlesi
                do {
                    System.out.print("Enter row and column [1-3]: ");
                    row = reader.nextInt() - 1;
                    column = reader.nextInt() - 1;
                    success = board.placeXorO(playerSymbol, row, column);
                    if (!success) {
                        System.out.println("Invalid move: cell is occupied or out of range. Try again.");
                    }
                } while (!success);
            } else { // Bilgisayarın hamlesi
                do {
                    row = random.nextInt(3);
                    column = random.nextInt(3);
                    success = board.placeXorO(computerSymbol, row, column);
                } while (!success);
                System.out.println("The computer placed '" + computerSymbol + "' at (" + (row + 1) + ", " + (column + 1) + ")");
            }

            System.out.println(board);
            playerTurn = !playerTurn; // Sırayı değiştir
        }

        // Oyun sonucunu göster
        char winner = board.getWinner();
        if (winner != '-') {
            System.out.println(winner + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        reader.close();
    }
}
