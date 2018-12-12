import java.util.*;
/*
 * 
 * do DFS on every node of the board
 * if a word is found, add it to the foundWord list, return this list at the end
 * 
 * 
 */
public class DFS_Solver implements GameSolver {

	private Set<String> dict;
	private Set<String> foundWord;
	
	public DFS_Solver() {
		dict = new HashSet<>(DictionaryReader.readDictionary());
		foundWord = new HashSet<>();
	}
	
	@Override
	public ArrayList<String> solve(Board board) {
		
		for (Node n : board.getNode()) {
			Set<Node> visited = new HashSet<Node>();
			visited.add(n);
			searchWord(""+n.getValue(), n, board, dict, foundWord, visited);
		}
		
		return new ArrayList<String>(foundWord);
	}
	
	public void searchWord(String currentWord, Node currentNode, Board board, Set<String> dict, Set<String> foundWord, Set<Node> visited) {
		if (currentWord.length() > board.dimension * board.dimension || currentWord.length() > 20) {
			return;
		}
		
		if (dict.contains(currentWord)) {
			foundWord.add(currentWord);
		}
		
		for (Position p : currentNode.getNeighnors()) {
			
			Node neighborNode = board.getNodeFromPosition(p);
			
			if (visited.contains(neighborNode)) continue;
			
			visited.add(neighborNode);
			
			searchWord(currentWord+neighborNode.getValue(), neighborNode, board, dict, foundWord, visited );
			
			visited.remove(neighborNode);
			
		}
	}
	
	public void printDict() {
		for (String word : dict) {
			System.out.println("\""+word+"\"");
		}
		System.out.println("length: "+dict.size());
	}
	
}
