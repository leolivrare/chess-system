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
		Position posAux = new Position(0, 0);
		
		posAux.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() + 1, posAux.getColumn() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() - 1, posAux.getColumn() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() + 1, posAux.getColumn() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() - 1, posAux.getColumn() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		return mat;
	}

}
