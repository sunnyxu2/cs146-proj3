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
			}
		}
		source.setColor(Color.GRAY);
		source.setDistance(0);
		source.setParent(null);
		Queue<MazeNode> queue = new LinkedList<MazeNode>();
		queue.add(source);
		while (!queue.isEmpty()) {
			MazeNode you = queue.remove();
			you.setLabel(Integer.toString(you.getDistance() % 10));
			for (MazeNode adj : you.getConnectedList()) {
				if (adj.getColor() == Color.WHITE) {
					adj.setColor(Color.GRAY);
					adj.setDistance(you.getDistance() + 1);
					adj.setParent(you);
					adj.setLabel(Integer.toString(adj.getDistance() % 10));
					queue.add(adj);
				}
			}
			you.setColor(Color.BLACK);
		}
	}
	
	/**
	 * Traverses the maze using depth-first search
	 * @param maze
	 * @param source
	 */
	public static void solve_DFS(Maze maze, MazeNode source) {
		// No need to return, just call solve_DFS and print the maze again in the solver test
	}
}