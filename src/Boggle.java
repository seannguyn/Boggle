import java.util.*;

public class Boggle {
		
	private Board board;
	private GameSolver solver;
	
	public Boggle(String input, GameSolver solver) {
		this.board = Board.buildBoard(input);
		this.solver = solver;
//		board.printBoard();
	}
	
	public static void main(String[] args) {
		
		TestInput Tester = TestInput.getTester();
		boolean error = Tester.checkError(args);
		
		// initialize solver
		DFS_Solver dfs_solver = new DFS_Solver();
		Dictionary_Solver dictionary_solver = new Dictionary_Solver();
		DFS_Trie_Solver dfs_trie_solver = new DFS_Trie_Solver();
		
		if (!error) {
			
			// Pick the suitable solver
			
//			Boggle boggle = new Boggle(args[0], dfs_solver);
//			Boggle boggle = new Boggle(args[0], dictionary_solver);
			Boggle boggle = new Boggle(args[0], dfs_trie_solver);
			boggle.solve();
		}
		
	}
	
	public void solve() {
		ArrayList<String> foundWord = solver.solve(this.board);
		int count = 0;
		for (String word : foundWord) {
			if (word.length() >= 3) {
				System.out.println(word);
				count++;
			}
			
		}
		System.out.println("======================");
		System.out.println("count: "+count+" words");
	}
}
