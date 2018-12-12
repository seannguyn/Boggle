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
		
		DFS_Solver dfs_solver = new DFS_Solver();
		
		if (!error) {
			Boggle boggle = new Boggle(args[0], dfs_solver);
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
		System.out.println("count: "+count);
	}
}
