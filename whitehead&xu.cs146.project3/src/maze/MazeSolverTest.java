package maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeSolverTest {

	@Test
	void viewMazeGeneration() {
		Maze maze = new Maze(4,4);
		System.out.println(maze.toString());
		MazeSolver.solve_BFS(maze, maze.getStart());
		System.out.println(maze.toString());
	}

}
