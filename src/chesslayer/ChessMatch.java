package chessLayer;

import boardLayer.Board;
import boardLayer.Piece;
import boardLayer.Position;
import chessLayer.pieces.Bishop;
import chessLayer.pieces.King;
import chessLayer.pieces.Knight;
import chessLayer.pieces.Pawn;
import chessLayer.pieces.Queen;
import chessLayer.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	
	//ALTERAR O JEITO DE POSICIONAR AS PECAS
	
	
	private void initialSetup() {
		//White pieces
		insertInitialGroupOfPieces(Color.WHITE, 7, 6);
		
		//Black pieces
		insertInitialGroupOfPieces(Color.BLACK, 0, 1);
		
		placeNewPiece('d', 4, new Bishop(board, Color.BLACK));
						
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void insertInitialGroupOfPieces(Color color, int row1, int row2) {
		board.placePiece(new Rook(board, color), new Position(row1, 0));
		board.placePiece(new Rook(board, color), new Position(row1, 7));
		board.placePiece(new Knight(board, color), new Position(row1, 1));
		board.placePiece(new Knight(board, color), new Position(row1, 6));
		board.placePiece(new Bishop(board, color), new Position(row1, 2));
		board.placePiece(new Bishop(board, color), new Position(row1, 5));
		board.placePiece(new Queen(board, color), new Position(row1, 3));
		board.placePiece(new King(board, color), new Position(row1, 4));
				
		for(int i=0; i<board.getColumns(); i++) {
			board.placePiece(new Pawn(board, color), new Position(row2, i));
		}
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	public void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Nao há nenhuma peça na posicao inicial!");
		}
		if (!(board.piece(position).isThereAnyPossibleMove())) {
			throw new ChessException("Não há nenhum movimento possível para essa peça!");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	public Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
}
