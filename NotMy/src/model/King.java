package model;

public class King extends ChessPiece {


	public String getInitial() { 
		return "K"; 
	}

	public boolean isValidMove(Square dest)
	{
		int xPos = Math.abs( dest.getX() - getLocation().getX());
		int yPos= Math.abs( dest.getY() - getLocation().getY());

		if (((xPos) <=1 && (yPos) <=1)) return true;


		if (xPos != 2 || numberOfMoves() != 0 || dest.getY() != getLocation().getY())
		{

			return false;
		}

		//Check for the location of a rook
		int xPosRook;
		if(dest.getX() == 6)
			xPosRook =7;
		else
			xPosRook = 0;

		ChessPiece castlingRook = getBoard()[xPosRook][getLocation().getY()].getPiece();

		if (!(castlingRook instanceof Rook)|| castlingRook.numberOfMoves() != 0 ||castlingRook == null)
		{

			return false;
		} 

		if (xPosRook == 7)
		{

			return getBoard()[5][getLocation().getY()].getPiece() == null &&  getBoard()[6][getLocation().getY()].getPiece() == null; 
		} 
		else 
		{
			return getBoard()[1][getLocation().getY()].getPiece() == null &&  getBoard()[2][getLocation().getY()].getPiece() == null &&  getBoard()[3][getLocation().getY()].getPiece() == null;
		}


	}

	public boolean inCheck(Square kingLoc) {

		for (ChessPiece chessP: getPlayer().getOpponent().getPieces())
		{
			if (chessP.getLocation() == null) {
				return false;

			}
			if (chessP.isValidMove(kingLoc) && chessP.getLocation() != null)
			{
				return true;
			}

		}

		return false;
	}	

	public boolean checkmate(Square kingLoc) {

		Square forward = new Square(kingLoc.getY() + 1, kingLoc.getX());
		Square backward = new Square(kingLoc.getY() - 1, kingLoc.getX());
		Square rightUp = new Square(kingLoc.getY() + 1, kingLoc.getX() + 1);
		Square leftUp = new Square(kingLoc.getY() + 1, kingLoc.getX() - 1);
		Square rightDown = new Square(kingLoc.getY() - 1, kingLoc.getX() + 1);
		Square leftDown = new Square(kingLoc.getY() - 1, kingLoc.getX() - 1);

		if (forward.getX() >= 0 && forward.getX() <= 7
				&& forward.getY() >= 0 && forward.getY() <= 7) {

			if (!inCheck(forward) && getBoard()[forward.getY()][forward.getX()].getPiece() == null) return false;

		}
		if (backward.getX() >= 0 && backward.getY() <= 7
				&& backward.getY() >= 0 && backward.getY() <= 7) {

			if (!inCheck(backward) && getBoard()[backward.getY()][backward.getX()].getPiece() == null) return false;
		}
		if (rightUp.getX() >= 0 && rightUp.getY() <= 7
				&& rightUp.getY() >= 0 && rightUp.getY() <= 7) {

			if (!inCheck(rightUp) && getBoard()[rightUp.getY()][rightUp.getX()].getPiece() == null) return false;
		}
		if (leftUp.getX() >= 0 && leftUp.getY() <= 7
				&& leftUp.getY() >= 0 && leftUp.getY() <= 7) {

			if (!inCheck(leftUp) && getBoard()[leftUp.getY()][leftUp.getX()].getPiece() == null) return false;
		}
		if (rightDown.getX() >= 0 && rightDown.getY() <= 7
				&& rightDown.getY() >= 0 && rightDown.getY() <= 7) {

			if (!inCheck(rightDown) && getBoard()[rightDown.getY()][rightDown.getX()].getPiece() == null) return false;
		}
		if (leftDown.getX() >= 0 && leftDown.getY() <= 7
				&& leftDown.getY() >= 0 && leftDown.getY() <= 7) {

			if (!inCheck(leftDown) && getBoard()[leftDown.getY()][leftDown.getX()].getPiece() == null) return false;
		}

		return true;

	}
}