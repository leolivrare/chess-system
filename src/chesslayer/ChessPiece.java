package chessLayer;

import boardLayer.Board;
import boardLayer.Piece;
import boardLayer.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	private int moveCount;
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public Color getColor() {
		return color;
	}


	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece != null && piece.getColor() != color;
	}
	
	protected void increaseMoveCount() {
		moveCount += 1;
	}
	
	protected void decreaseMoveCount() {
		moveCount -= 1;
	}
}
