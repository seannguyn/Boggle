import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary_Solver_2 implements GameSolver{
	
	 public ArrayList<String> solve(Board board) {
	        List<String> words = DictionaryReader.readDictionary();
	        ArrayList<String> foundWords = new ArrayList<String>();
	        for (String word : words) {
	        	
	            if (findWord(word, board)) {
	                foundWords.add(word);
	            }
	        }

	        return foundWords;
	    }
	 
	 private boolean findWord(String word, Board board) {
		 
		 	ArrayList<Node> startingNodes = new ArrayList<Node>();
	        
	        for (Node n : board.getNode()) {
	        		if (n.getValue() == word.charAt(0)) {
	        			startingNodes.add(n);
	        		}
	        }

	        for (Node n : startingNodes) {

	            Set<Node> visitedNode = new HashSet<Node>();
	            visitedNode.add(n);

	            if (searchForWord(1, word, board, n, visitedNode)) {
	                return true;
	            }
	        }

	        return false;
	}
	 

	 
	 private boolean searchForWord(int index, String word, Board board, Node currentNode, Set<Node> visited) {
	        if (index == word.length()) return true;

	        List<Node> neighbours = new ArrayList<Node>();

	        for (Position p :  currentNode.getNeighnors()) {
	        		neighbours.add(board.getNodeFromPosition(p));
	        }
	        

	        List<Node> candidates = new ArrayList<Node>();

	        for (Node candidate : neighbours) {
	            if (visited.contains(candidate)) continue;
	            if (candidate.getValue() == word.charAt(index)) {
	                candidates.add(candidate);
	            }
	        }

	        for (Node node : candidates) {
	            visited.add(node);
	            if (searchForWord(index + 1, word, board, node, visited)) return true;
	            visited.remove(node);
	        }

	        return false;
	    }
	 

}
