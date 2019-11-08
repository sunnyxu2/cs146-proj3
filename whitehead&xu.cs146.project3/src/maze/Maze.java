package maze;

import java.util.Random;

/**
 * A maze, represented by a graph object
 * @author Sunny
 *
 */
public class Maze {
	private final int rows;
	private final int cols;
	private Random random;
	
	public Maze(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		random = new Random();
	}
	
	public Maze(int rows, int cols, int seed) {
		this.rows = rows;
		this.cols = cols;
		
		random = new Random();
		random.setSeed(seed);
	}
	
	public String toString() {
		return ""; // TBD
	}
}
