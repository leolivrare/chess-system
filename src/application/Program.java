package application;


import java.util.InputMismatchException;
import java.util.Scanner;

import chessLayer.ChessException;
import chessLayer.ChessMatch;
import chessLayer.ChessPiece;
import chessLayer.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.println("Digite a posicao inicial:");
				ChessPosition source = UI.readChessPosition(sc);
				System.out.println();
				System.out.println("Digite a posicao de destino:");
				ChessPosition target = UI.readChessPosition(sc);
				System.out.println();
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
