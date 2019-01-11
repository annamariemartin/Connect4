package app;
import java.util.Scanner;

public class Launcher {

	public static Scanner s = new Scanner(System.in)
			;
	public static void main(String[] args) {
		
		System.out.println("---- WELCOME ----");
		System.out.println("------ TO -------");
		System.out.println("--- CONNECT 4 ---");
		System.out.println("...press Enter to play");
		s.nextLine();
		gameLoop();
	}

	public static void gameLoop() {
		Board game = new Board();
		boolean player1 = true;
		while(true) {
			System.out.println(game);
			if(player1) {
				System.out.print("Player 1, select column:  ");
				int choice = s.nextInt();
				while(!game.dropPiece('x', choice)) {
					System.out.print("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('x')) {
					System.out.println("Player 1 wins!");
					System.out.println(game);
					break;
				}

			}else {
				System.out.println("Player 2, select column:  ");
				int choice = s.nextInt();
				while(!game.dropPiece('o',  choice)) {
					System.out.print("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('o')) {
					System.out.println("Player 2 wins!");
					System.out.println(game);
					break;
				}
				
			}
			if(game.tieGame()) {
				System.out.println("Tie game");
				break;
			}
			player1 = !player1;
		}
	System.out.println("Press 1 and Enter to Play Again");
	int choice = s.nextInt();
	if(choice == 1) gameLoop();
	}
}