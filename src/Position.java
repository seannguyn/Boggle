import java.util.*;

public class Position {
	
	final int row;
	final int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public static ArrayList<Position> computeNeighbors(Position p, int dimension) {
		ArrayList<Position> neighbors = new ArrayList<Position>();
		
		int[] direction = new int[] {-1,0,1};
		
		for (int r : direction) {
			for (int c : direction) {
				Position neighbor = new Position(p.row + r, p.col+c);
				if (isValid(p, neighbor, dimension)) {
					neighbors.add(neighbor);
				}
			}
		}
		
		return neighbors;
	}
	
	private static boolean isValid(Position p, Position neighbor, int dimension) {
		if (p.equals(neighbor)) {
			return false;
		} else if (inRange(neighbor,dimension)) {
			return true;
		}
		return false;
	}
	
	private static boolean inRange(Position neighbor, int dimension) {
		if ((neighbor.row >= 0 && neighbor.row < dimension) && (neighbor.col >= 0 && neighbor.col < dimension) ) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		} else if (obj == null){
			return false;
		} else if (obj instanceof Position) {
			Position p = (Position) obj;
			if (this.row == p.row && this.col == p.col) {
				return true;
			}
		}
		
		return false;
	}
}
