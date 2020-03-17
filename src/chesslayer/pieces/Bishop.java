package chessLayer.pieces;

import boardLayer.Board;
import boardLayer.Position;
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

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position posAux = new Position(position.getRow(), position.getColumn());
		
		while (getBoard().positionExists(posAux.getRow()+1, posAux.getColumn()+1)) {
			mat[posAux.getRow()+1][posAux.getColumn()+1] = true;
			posAux.setRow(posAux.getRow()+1);
			posAux.setColumn(posAux.getColumn()+1);
		}
		
		posAux.setRow(position.getRow());
		posAux.setColumn(position.getColumn());
		
		while (getBoard().positionExists(posAux.getRow()-1, posAux.getColumn()-1)) {
			mat[posAux.getRow()-1][posAux.getColumn()-1] = true;
			posAux.setRow(posAux.getRow()-1);
			posAux.setColumn(posAux.getColumn()-1);
		}
		
		posAux.setRow(position.getRow());
		posAux.setColumn(position.getColumn());
		
		while (getBoard().positionExists(posAux.getRow()+1, posAux.getColumn()-1)) {
			mat[posAux.getRow()+1][posAux.getColumn()-1] = true;
			posAux.setRow(posAux.getRow()+1);
			posAux.setColumn(posAux.getColumn()-1);
		}
		
		posAux.setRow(position.getRow());
		posAux.setColumn(position.getColumn());
		
		while (getBoard().positionExists(posAux.getRow()-1, posAux.getColumn()+1)) {
			mat[posAux.getRow()-1][posAux.getColumn()+1] = true;
			posAux.setRow(posAux.getRow()-1);
			posAux.setColumn(posAux.getColumn()+1);
		}
		
		
		return mat;
	}

}
