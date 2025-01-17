package Problem3;

public class Pawn extends Piece{
	public Pawn(){
		super();
	}
	public Pawn(Position a, Color color){
		super(a, color);
	}
	@Override
	public boolean isLegalMove(Position b) {
		if(a.checkPosition() && b.checkPosition()) {
			if(this.a.xx() == b.xx() && a.yy() != 1) {
				if(a.yy() == 2 && a.yy() + 2 == b.yy() || a.yy() + 1 == b.yy()) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "♙";
	}
}
