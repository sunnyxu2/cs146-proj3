package maze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

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

	private MazeNode[][] nodes;

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
		nodes = new MazeNode[rows][cols];
		if (start == null || end == null) {
			for (int i = 0; i < cols; i++) { //
				for (int j = 0; j < rows; j++) {
					nodes[i][j] = new MazeNode(i, j);
				}
			}

			for (int i = 0; i < cols; i++) { //
				for (int j = 0; j < rows; j++) {
					MazeNode curr = nodes[i][j];

					if (nodes[i - 1][j] != null) {
						curr.addAdjacent(nodes[i - 1][j]); // WEST
					}
					if (nodes[i + 1][j] != null) {
						curr.addAdjacent(nodes[i + 1][j]); // EAST
					}
					if (nodes[i][j - 1] != null) {
						curr.addAdjacent(nodes[i][j - 1]); // SOUTH
					}
					if (nodes[i][j + 1] != null) {
						curr.addAdjacent(nodes[i][j + 1]); // NORTH
					}
				}
			}

			start = nodes[0][0];
			end = nodes[rows - 1][cols - 1];

			Stack<MazeNode> stack = new Stack<>();
			int totalCells = rows * cols;
			MazeNode curr = start;
			int visitedCells = 1;

			while (visitedCells < totalCells) {
				ArrayList<MazeNode> neigh = curr.getAdjacencyList();
				Iterator iter = neigh.iterator();
				
				while (iter.hasNext()) {
					MazeNode nextNode = (MazeNode) iter.next();
					if (nextNode.getColor() != Color.WHITE) {
						neigh.remove(nextNode); // THIS PART REMOVES GRAY/VISITED NODES FROM NEIGH
					}
				}
				
				if (neigh.size() > 0) {
					curr.setColor(Color.GRAY);
					int index = random.nextInt(neigh.size() - 1);
					MazeNode chosen = neigh.get(index);
					stack.push(curr);
					curr = chosen;
					visitedCells++;
				} else {
					curr = stack.pop();
				}
			}
		}
	}

	public String toString() {
		if (nodes != null && nodes.length != 0) {
			String represent = "";
			// TBD: MAKE GRID
			return represent;
		} else {
			return "";
		}
	}

	public MazeNode getStart() {
		return start;
	}

	public MazeNode getEnd() {
		return end;
	}
}
