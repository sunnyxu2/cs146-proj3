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
	public static String solve_BFS(Maze maze, MazeNode source) {
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
		int counter = 0;
		while (!queue.isEmpty()) {
			MazeNode you = queue.remove();
			counter = 0;
			you.setLabel(0);
			for (MazeNode adj : you.getConnectedList()) {
				if (adj.getColor() == Color.WHITE) {
					counter++;
					adj.setColor(Color.WHITE);
					adj.setDistance(you.getDistance() + 1);
					adj.setParent(you);
					adj.setLabel(counter);
					queue.add(adj);
				}
			}
			you.setColor(Color.BLACK);
		}
		
		return "";
	}
	
	public static String solve_DFS(Maze maze, MazeNode source) {
		return "";
	}
}