import java.util.*;

public class Board {
	private ArrayList<Node> nodes;
	public int dimension;
	private Node[][] nodePosition;
	
	public Board(ArrayList<Node> nodes, int dimension, Node[][] nodePosition) {
		this.nodes = nodes;
		this.dimension = dimension;
		this.nodePosition = nodePosition;
	}
	
	public static Board buildBoard(String input) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		int dimension = (int) Math.sqrt(input.length());
		Node[][] nodePosition = new Node[dimension][dimension];
		
		for (int i = 0; i < input.length(); i++) {
			
			// compute position
			Position p = new Position(i / dimension, i % dimension);
			
			// compute neigbors
			ArrayList<Position> neighbors = Position.computeNeighbors(p, dimension);
			
			// create a new Node
			Node newNode = new Node(input.charAt(i), p, neighbors);
			
			// add to list of nodes 
			nodes.add(newNode);
			
			// add to nodePosition
			nodePosition[p.row][p.col] = newNode;
		}
		
		return new Board(nodes, dimension, nodePosition);
	}
	
	public void printBoard() {
		
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				Node n = this.nodePosition[i][j];
				System.out.print(" "+n.getValue()+" ");
			}
			System.out.println();
 		}
		
		System.out.println("===========================================");
		
		for (Node n : nodes) {
			n.printNode();
		}
	}
	
	public Node getNodeFromPosition(Position p) {
		return this.nodePosition[p.row][p.col];
	}
	
	public Node getNodeFromPosition(int row, int col) {
		return this.nodePosition[row][col];
	}
	
	public ArrayList<Node> getNode() {
		return this.nodes;
	}
}
