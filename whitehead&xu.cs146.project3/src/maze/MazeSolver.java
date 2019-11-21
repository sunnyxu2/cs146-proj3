package maze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class that solves mazes
 * 
 * @author Sunny
 *
 */
public class MazeSolver {
	/**
	 * Traverses the maze using breadth-first search
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
		outer:
		while (!queue.isEmpty()) {
			MazeNode you = queue.remove();
			for (MazeNode adj : you.getConnectedList()) {
				if (adj.getColor() == Color.WHITE) {
					counter++;
					adj.setColor(Color.GRAY);
					adj.setDistance(you.getDistance() + 1);
					adj.setParent(you);
					adj.setLabel(Integer.toString(counter % 10)); //adj.setLabel(Integer.toString(adj.getDistance() % 10));
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
			MazeNode curr = end;
			while (!curr.equals(maze.getStart())) {
				curr.setLabel("#");
				curr = curr.getParent();
			}
			if (!curr.equals(maze.getStart())) {
				return false;
			}
			curr.setLabel("#");
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Traverses the maze using depth-first search
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
		// No need to return, just call solve_DFS and print the maze again in the solver test
	}
}