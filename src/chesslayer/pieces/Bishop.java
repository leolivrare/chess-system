package chessLayer.pieces;

import boardLayer.Board;
import chessLayer.ChessPiece;
import chessLayer.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
