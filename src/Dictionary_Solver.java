import java.util.*;
/*
 * iterate through every word of the of the dictionary, find if that word exist in a given board
 * 
 * 
 */

public class Dictionary_Solver implements GameSolver{

	
	public Dictionary_Solver() {
	}
	
	@Override
	public ArrayList<String> solve(Board board) {
		List<String> dict = DictionaryReader.readDictionary();
		ArrayList<String> foundWord = new ArrayList<String>();
		for (String word : dict) {
			if (findWord(word, board)) {
				foundWord.add(word);
			}
			
		}
		
		return foundWord;
	}
	
	public static boolean findWord(String word, Board board) {
		
		ArrayList<Node> startingNode = new ArrayList<Node>();
		for (Node n : board.getNode()) {
			if (n.getValue() == word.charAt(0)) {
				startingNode.add(n);
			}
		}
		
		// search for the whole word from the startingNode
		for (Node n : startingNode) {
			Set<Node> visited = new HashSet<Node>();
			visited.add(n);
			if (searchWord(1, word, n, board, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean searchWord(int index, String word, Node currentNode, Board board, Set<Node> visited) {
		if (index == word.length()) return true;
		
		List<Node> candidates = new ArrayList<Node>();
		for (Position p : currentNode.getNeighnors()) {
			
			Node neighbor = board.getNodeFromPosition(p);
			
			if (!visited.contains(neighbor) && (neighbor.getValue() == word.charAt(index))) {
				
				candidates.add(neighbor);
				
			}
		}
		
		for (Node node : candidates) {
            visited.add(node);
            if (searchWord(index + 1, word, node, board, visited)) return true;
            visited.remove(node);
        }
		
		return false;
	}

}
