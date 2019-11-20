package maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * A maze, represented by a graph object made of MazeNodes
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

	/**
	 * Constructor that makes a random maze given rows and columns
	 * @param rows
	 * @param cols
	 */
	public Maze(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;

		random = new Random();

		generateMaze();
	}

	/**
	 * Constructor that makes a random maze given rows, columns, and RNG seed
	 * @param rows
	 * @param cols
	 * @param seed
	 */
	public Maze(int rows, int cols, int seed) {
		this.rows = rows;
		this.cols = cols;

		random = new Random();
		random.setSeed(seed);

		generateMaze();
	}

	/**
	 * Helper method to construct a maze
	 */
	private void generateMaze() {
		nodes = new MazeNode[cols][rows];
		if (start == null || end == null) {
			for (int i = 0; i < cols; i++) { // FIX ISSUE WHERE RECTANGULAR MAZES DO NOT WORK!!!
				for (int j = 0; j < rows; j++) {
					nodes[i][j] = new MazeNode(i, j);
				}
			}

			for (int i = 0; i < cols; i++) { //
				for (int j = 0; j < rows; j++) {
					MazeNode curr = nodes[i][j];
					MazeNode check;
					if (i - 1 >= 0) {
						check = nodes[i - 1][j];
						curr.addAdjacent(check); // WEST
					}

					if (i + 1 < cols) {
						check = nodes[i + 1][j];
						curr.addAdjacent(check); // EAST
					}

					if (j - 1 >= 0) {
						check = nodes[i][j - 1];
						curr.addAdjacent(check); // SOUTH
					}

					if (j + 1 < rows) {
						check = nodes[i][j + 1];
						curr.addAdjacent(check); // NORTH
					}
				}
			}

			start = nodes[0][0];
			end = nodes[cols - 1][rows - 1];

			Stack<MazeNode> stack = new Stack<>();
			int totalCells = rows * cols;
			MazeNode curr = start;
			int visitedCells = 1;

			while (visitedCells < totalCells) {
				ArrayList<MazeNode> beigh = curr.getAdjacencyList();
				ArrayList<MazeNode> neigh = new ArrayList<>();

				for (MazeNode node : beigh) {
					if (node.getColor() == Color.WHITE && !neigh.contains(node)) {
						neigh.add(node);
					}
				}

				if (neigh.size() > 0) {
					curr.setColor(Color.GRAY);
					MazeNode chosen;
					int upper = neigh.size() - 1;
					int index = (int) (random.nextDouble() * neigh.size());
					chosen = neigh.get(index);
					curr.addConnected(chosen);
					chosen.setParent(curr);
					stack.push(curr);
					chosen.addConnected(curr);
					chosen.setColor(Color.GRAY);
					curr = chosen;
					visitedCells++;
				} else {
					curr = stack.pop();
				}
			}

			for (int i = 0; i < cols; i++) { //
				for (int j = 0; j < rows; j++) {
					nodes[i][j].setColor(Color.WHITE);
				}
			}
		}
	}

	@Override
	public String toString() {
		if (nodes != null && nodes.length != 0) {
			String represent = "";
			for (int h = 0; h < rows; h++) {
				for (int v = 0; v < cols; v++) {
					MazeNode test = getNode(v, h);
					if (test.getNorthConnected() != null || test.getCoord().equals(start.getCoord())) {
						represent += "+ ";
					} else {
						represent += "+-";
					}
				}
				represent += "+\n";
				for (int v = 0; v < cols; v++) {
					MazeNode test = getNode(v, h);
					if (test.getWestConnected() != null) {
						represent += " ";
					} else {
						represent += "|";
					}

					if (test.getLabel() == -1 && end.getColor() == Color.GRAY) {
						represent += " ";
					} else {
						represent += test.getLabel();
					}
				}
				MazeNode test = getNode(cols - 1, h);
				if (test.getEastConnected() != null) {
					represent += "";
				} else {
					represent += "|";
				}
				represent += "\n";
			}
			for (int v = 0; v < cols; v++) {
				MazeNode test = getNode(v, rows - 1);
				if (test.getSouthConnected() != null || test.getCoord().equals(end.getCoord())) {
					represent += "+ ";
				} else {
					represent += "+-";
				}
			}
			return represent + "+\n";
		} else {
			return "";
		}
	}

	/**
	 * Gets start node (by default, the top left node or nodes[0][0]
	 * @return
	 */
	public MazeNode getStart() {
		return start;
	}

	/**
	 * Gets end node (by default, the bottom right node or nodes[cols - 1][rows - 1]
	 * @return
	 */
	public MazeNode getEnd() {
		return end;
	}

	/**
	 * Gets width
	 * @return width
	 */
	public int getWidth() {
		return cols;
	}

	/**
	 * Gets height
	 * @return height
	 */
	public int getHeight() {
		return rows;
	}

	/**
	 * Gets node in nodes array from a coordinate object
	 * @param coord
	 * @return
	 */
	public MazeNode getNode(Coord2D coord) {
		int x = coord.getX();
		int y = coord.getY();

		return nodes[x][y];
	}

	/**
	 * Gets node in nodes array from an x and y coordinate
	 * @param coord
	 * @return
	 */
	public MazeNode getNode(int x, int y) {
		return nodes[x][y];
	}
	
	public MazeNode[][] getNodeArray() {
		return nodes;
	}
}
