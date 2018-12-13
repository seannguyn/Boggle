import java.util.*;

public class DFS_Trie_Solver implements GameSolver{

	@Override
	public ArrayList<String> solve(Board board) {
		
		Trie trie = new Trie();
		ArrayList<String> dict = DictionaryReader.readDictionary();
		Set<String> foundWord = new HashSet<>();
		
		for (String word : dict ) {
			trie.addWord(word);
		}
		
		for (Node n : board.getNode()) {
			Set<Node> visited = new HashSet<Node>();
			visited.add(n);
			findWord("" + n.getValue(), board, n, visited, trie, foundWord);
		}
		
		// TODO Auto-generated method stub
		return new ArrayList<>(foundWord);
	}
	
	public void findWord(String currentWord, Board board, Node currentNode, Set<Node> visited, Trie trie, Set<String> foundWord) {
		
		if (!trie.hasPrefix(currentWord)) return;
		
		if (trie.isWord(currentWord)) {
			foundWord.add(currentWord);
		}
		
		for (Position p : currentNode.getNeighnors()) {
			Node neighbor = board.getNodeFromPosition(p);
			if (visited.contains(neighbor)) continue;
			
			visited.add(neighbor);
			
			findWord(currentWord+neighbor.getValue(), board, neighbor, visited, trie, foundWord);
			
			visited.remove(neighbor);
		}
		
	}

}
