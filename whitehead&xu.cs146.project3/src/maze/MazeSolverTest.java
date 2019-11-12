package maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeSolverTest {

	@Test
	void viewMazeGeneration() {
		fail("FIX ISSUE WHERE RECTANGULAR MAZE CONSTRUCTION CAUSES INDEX OUT OF BOUNDS");
		Maze maze = new Maze(4,4,20);
		System.out.println(maze.toString());
	}

}
