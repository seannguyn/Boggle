import java.util.*;

public class Node {
	
	final char value; 
	final Position position;
	final ArrayList<Position> neighbors;
	
	public Node(char value, Position position, ArrayList<Position> neighbors) {
		this.value = value;
		this.position = position;
		this.neighbors = neighbors;
	}
	
	public char getValue() {
		return value;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public ArrayList<Position> getNeighnors() {
		return neighbors;
	}
	
	public void printNode() {
		System.out.println("Value: "+this.value+" AT ( "+position.row+" , " +position.col+" )");
		System.out.print("      ");
		for (Position neighbor : neighbors) {
			System.out.print(" ("+neighbor.row+","+neighbor.col+") ");
		}
		System.out.println();
	}
	
}
