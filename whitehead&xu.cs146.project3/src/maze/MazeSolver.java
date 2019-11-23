package maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class that solves mazes
 * 
 * @author Sunny and williamwhitehead
 *
 */
public class MazeSolver {
	/**
	 * Traverses the maze using breadth-first search
	 * 
	 * @param maze
	 * @param source
	 * @return String representation of the maze
	 */
	public static void solve_BFS(Maze maze, MazeNode source) {
		for (int i = 0; i < maze.getWidth(); i++) {
			for (int j = 0; j < maze.getHeight(); j++) {
				MazeNode u = maze.getNode(i, j);
				u.setColor(Color.WHITE);
				u.setDistance(0);
				u.setParent(null);
				u.setLabel(" ");
			}
		}
		source.setColor(Color.GRAY);
		source.setDistance(0);
		source.setParent(null);
		Queue<MazeNode> queue = new LinkedList<MazeNode>();
		queue.add(source);
		source.setLabel("0");
		int counter = 0;
		outer: while (!queue.isEmpty()) {
			MazeNode you = queue.remove();
			for (MazeNode adj : you.getConnectedList()) {
				if (adj.getColor() == Color.WHITE) {
					counter++;
					adj.setColor(Color.GRAY);
					adj.setDistance(you.getDistance() + 1);
					adj.setParent(you);
					adj.setLabel(Integer.toString(counter % 10)); // adj.setLabel(Integer.toString(adj.getDistance() %
																	// 10));
					queue.add(adj);
					if (adj.equals(maze.getEnd())) {
						break outer;
					}
				}
			}
			you.setColor(Color.BLACK);
		}
	}

	/**
	 * Traverses a solved maze to find the path from start to end
	 * 
	 * @param maze
	 * @return true if the maze has been solved, false otherwise
	 */
	public static boolean traverse(Maze maze) {
		MazeNode end = maze.getEnd();
		if (end.getParent() != null) { // this assumes that if the end has a parent, the maze is solved
			for (int i = 0; i < maze.getWidth(); i++) {
				for (int j = 0; j < maze.getHeight(); j++) {
					MazeNode u = maze.getNode(i, j);
					u.setLabel(" ");
				}
			}
			Stack<Coord2D> coords = new Stack<Coord2D>();
			MazeNode curr = end;
			while (!curr.equals(maze.getStart())) {
				curr.setLabel("#");
				coords.push(curr.getCoord());
				curr = curr.getParent();
			}
			if (!curr.equals(maze.getStart())) {
				return false;
			}
			curr.setLabel("#");
			coords.push(curr.getCoord());
			pathStats(coords, maze);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns path and cell statistics for a traversed maze
	 * 
	 * @param coords a stack of visited cell coordinates
	 * @param maze   the traversed maze
	 */
	public static void pathStats(Stack<Coord2D> coords, Maze maze) {
		System.out.print("Path: ");
		int pathCounter = 0;
		while (!coords.isEmpty()) {
			System.out.print(coords.pop().toString() + ", ");
			pathCounter++;
			if (pathCounter % 10 == 0)
				System.out.println("");
		}
		System.out.println();
		System.out.println("Length of path: " + pathCounter);

		int visitCounter = 0;
		for (int i = 0; i < maze.getWidth(); i++) {
			for (int j = 0; j < maze.getHeight(); j++) {
				if (maze.getNode(i, j).getColor() == Color.GRAY || maze.getNode(i, j).getColor() == Color.BLACK) {
					visitCounter++;
				}
			}
		}
		System.out.println("Visited cells: " + visitCounter);
		System.out.println();

	}

	/**
	 * Traverses the maze using depth-first search
	 * 
	 * @param maze
	 * @param source
	 */
	/**
	 * @param maze
	 * @param source
	 */
	public static void solve_DFS(Maze maze, MazeNode source) {
		for (int i = 0; i < maze.getWidth(); i++) {
			for (int j = 0; j < maze.getHeight(); j++) {
				MazeNode u = maze.getNode(i, j);
				u.setColor(Color.WHITE);
				u.setDiscoveryTime(0);
				u.setFinishTime(0);
				u.setParent(null);
				u.setLabel(" ");
			}
		}
		source.setDistance(0);
		source.setParent(null);
		Stack<MazeNode> stack = new Stack<MazeNode>();
		stack.add(source);
		source.setLabel("0");
		int counter = 0;
		while (!stack.isEmpty()) {
			MazeNode u = stack.pop();
			if (u.getColor() == Color.WHITE) {
				u.setColor(Color.GRAY);
				if (u.equals(maze.getEnd()))
					break;
				for (MazeNode adj : u.getConnectedList()) {
					if (adj.getColor() == Color.WHITE) {
						stack.push(adj);
						adj.setParent(u);
						counter++;
						adj.setLabel(Integer.toString(counter % 10));
					}
				}
				u.setColor(Color.BLACK);
			}
		}
	}
}