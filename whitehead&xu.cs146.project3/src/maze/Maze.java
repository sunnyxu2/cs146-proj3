package maze;

import java.util.ArrayList;
import java.util.Random;

/**
 * A maze, represented by a graph object
 * 
 * @author Sunny
 *
 */
public class Maze {
	private final int rows;
	private final int cols;
	private Random random;

	private MazeNode start;
	private MazeNode end;
	
	private ArrayList<MazeNode> nodes;

	public Maze(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;

		random = new Random();
		
		generateMaze();
	}

	public Maze(int rows, int cols, int seed) {
		this.rows = rows;
		this.cols = cols;

		random = new Random();
		random.setSeed(seed);
		
		generateMaze();
	}

	private void generateMaze() {
		if (start == null || end == null) {
			for (int i = 0; i < cols; i++) { //
				for (int j = 0; j < rows; j++) {
					nodes.add(new MazeNode(i, j));
				}
			}
			
			start = nodes.get(0);
			end = nodes.get(nodes.size() - 1);
			// implement a way to make a maze out of DFS
		}
	}

	public String toString() {
		return ""; // TBD
	}
	
	public MazeNode getStart() {
		return start;
	}
	
	public MazeNode getEnd() {
		return end;
	}
}
