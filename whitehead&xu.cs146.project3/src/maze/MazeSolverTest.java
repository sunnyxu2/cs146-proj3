package maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeSolverTest {

	@Test
	void viewMazeGeneration() {
		Maze maze = new Maze((int) (Math.random() * 16 + 4), (int) (Math.random() * 16 + 4));
		System.out.println(maze.getWidth() + " " + maze.getHeight() + "\n" + maze.toString());
		MazeSolver.solve_BFS(maze, maze.getStart());
		System.out.println("solve_BFS: \n" + maze.toString());
		MazeSolver.traverse(maze);
		System.out.println(maze.toString());
	}

}
