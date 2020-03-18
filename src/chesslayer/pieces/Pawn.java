package chessLayer.pieces;

import boardLayer.Board;
import boardLayer.Position;
import chessLayer.ChessPiece;
import chessLayer.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position posAux = new Position(0, 0);
		posAux.setValues(position.getRow(), position.getColumn());
		
		if (getColor() == Color.WHITE) {
			posAux.setValues(position.getRow()-1, position.getColumn());
			if (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
				if (getMoveCount() == 0) {
					posAux.setValues(position.getRow()-2, position.getColumn());
					if (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
						mat[posAux.getRow()][posAux.getColumn()] = true;
					}
				}
			}
				
			posAux.setValues(position.getRow()-1, position.getColumn()-1);
			if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
			}
				
			posAux.setValues(position.getRow()-1, position.getColumn()+1);
			if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
			}
		}
			
		if (getColor() == Color.BLACK) {
			posAux.setValues(position.getRow()+1, position.getColumn());
			if (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
				if (getMoveCount() == 0) {
					posAux.setValues(position.getRow()+2, position.getColumn());
					if (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
						mat[posAux.getRow()][posAux.getColumn()] = true;
					}
				}
			}
				
			posAux.setValues(position.getRow()+1, position.getColumn()-1);
			if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
			}
			
			posAux.setValues(position.getRow()+1, position.getColumn()+1);
			if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
				mat[posAux.getRow()][posAux.getColumn()] = true;
			}
		}
		return mat;
	}

}
