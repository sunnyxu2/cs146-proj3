package maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeSolverTest {

	@Test
	void viewMazeGeneration() {
		Maze maze = new Maze((int) (Math.random() * 16 + 4), (int) (Math.random() * 16 + 4));
		maze.generateMaze();
		System.out.println(maze.getWidth() + " " + maze.getHeight() + "\n" + maze.toString());
		MazeSolver.solve_BFS(maze, maze.getStart());
		System.out.println("solve_BFS: \n" + maze.toString());
		MazeSolver.traverse(maze);
		System.out.println(maze.toString());
		
		MazeSolver.solve_DFS(maze, maze.getStart());
		System.out.println("solve_DFS: \n" + maze.toString());
		MazeSolver.traverse(maze);
		System.out.println(maze.toString());
		
		//now to test potika's mazes
		String t44 = "4 4\n" + 
				"+ +-+-+-+\n" + 
				"|   |   |\n" + 
				"+-+ +-+ +\n" + 
				"| |     |\n" + 
				"+ +-+-+ +\n" + 
				"|       |\n" + 
				"+ +-+-+-+\n" + 
				"|       |\n" + 
				"+-+-+-+ +";
		Maze test44 = MazeParser.parse(t44);
		System.out.println(test44.getWidth() + " " + test44.getHeight() + "\n" + test44.toString());
		assertEquals(test44.toString(), 
				"+ +-+-+-+\n" + 
				"|   |   |\n" + 
				"+-+ +-+ +\n" + 
				"| |     |\n" + 
				"+ +-+-+ +\n" + 
				"|       |\n" + 
				"+ +-+-+-+\n" + 
				"|       |\n" + 
				"+-+-+-+ +\n");
		System.out.println(test44.getWidth() + " " + test44.getHeight() + "\n" + test44.toString());
		MazeSolver.solve_BFS(test44, test44.getStart());
		System.out.println("solve_BFS: \n" + test44.toString());
		MazeSolver.traverse(test44);
		System.out.println(test44.toString());
		
		MazeSolver.solve_DFS(test44, test44.getStart());
		System.out.println("solve_DFS: \n" + test44.toString());
		MazeSolver.traverse(test44);
		System.out.println(test44.toString());
		
		String t66 = "6 6\r\n" + 
				"+ +-+-+-+-+-+\r\n" + 
				"|   |       |\r\n" + 
				"+-+ +-+-+-+ +\r\n" + 
				"| |       | |\r\n" + 
				"+ +-+-+-+ + +\r\n" + 
				"|     | |   |\r\n" + 
				"+ +-+ + +-+ +\r\n" + 
				"| |       | |\r\n" + 
				"+ +-+-+-+-+ +\r\n" + 
				"|     |     |\r\n" + 
				"+ +-+ + +-+-+\r\n" + 
				"|   |       |\r\n" + 
				"+-+-+-+-+-+ +";
		Maze test66 = MazeParser.parse(t66);
		System.out.println(test66.getWidth() + " " + test66.getHeight() + "\n" + test66.toString());
		assertEquals(test66.toString(), 
				"+ +-+-+-+-+-+\n" + 
				"|   |       |\n" + 
				"+-+ +-+-+-+ +\n" + 
				"| |       | |\n" + 
				"+ +-+-+-+ + +\n" + 
				"|     | |   |\n" + 
				"+ +-+ + +-+ +\n" + 
				"| |       | |\n" + 
				"+ +-+-+-+-+ +\n" + 
				"|     |     |\n" + 
				"+ +-+ + +-+-+\n" + 
				"|   |       |\n" + 
				"+-+-+-+-+-+ +\n");
		System.out.println(test66.getWidth() + " " + test66.getHeight() + "\n" + test66.toString());
		MazeSolver.solve_BFS(test66, test66.getStart());
		System.out.println("solve_BFS: \n" + test66.toString());
		MazeSolver.traverse(test66);
		System.out.println(test66.toString());
		
		MazeSolver.solve_DFS(test66, test66.getStart());
		System.out.println("solve_DFS: \n" + test66.toString());
		MazeSolver.traverse(test66);
		System.out.println(test66.toString());
		
		String t88 = "8 8\r\n" + 
				"+ +-+-+-+-+-+-+-+\r\n" + 
				"|   |         | |\r\n" + 
				"+-+ +-+-+-+ + + +\r\n" + 
				"| |       | |   |\r\n" + 
				"+ +-+-+-+ + +-+ +\r\n" + 
				"|   |   |   |   |\r\n" + 
				"+ + + + +-+-+ +-+\r\n" + 
				"| |   | |     | |\r\n" + 
				"+ +-+-+-+ +-+-+ +\r\n" + 
				"|         |   | |\r\n" + 
				"+ +-+-+-+-+ + + +\r\n" + 
				"| |     |   | | |\r\n" + 
				"+ + +-+ + +-+ + +\r\n" + 
				"| | | | | |   | |\r\n" + 
				"+ + + + + + +-+ +\r\n" + 
				"|   |     |     |\r\n" + 
				"+-+-+-+-+-+-+-+ +";
		Maze test88 = MazeParser.parse(t88);
		System.out.println(test88.getWidth() + " " + test88.getHeight() + "\n" + test88.toString());
		assertEquals(test88.toString(), 
				"+ +-+-+-+-+-+-+-+\n" + 
				"|   |         | |\n" + 
				"+-+ +-+-+-+ + + +\n" + 
				"| |       | |   |\n" + 
				"+ +-+-+-+ + +-+ +\n" + 
				"|   |   |   |   |\n" + 
				"+ + + + +-+-+ +-+\n" + 
				"| |   | |     | |\n" + 
				"+ +-+-+-+ +-+-+ +\n" + 
				"|         |   | |\n" + 
				"+ +-+-+-+-+ + + +\n" + 
				"| |     |   | | |\n" + 
				"+ + +-+ + +-+ + +\n" + 
				"| | | | | |   | |\n" + 
				"+ + + + + + +-+ +\n" + 
				"|   |     |     |\n" + 
				"+-+-+-+-+-+-+-+ +\n");
		System.out.println(test88.getWidth() + " " + test88.getHeight() + "\n" + test88.toString());
		MazeSolver.solve_BFS(test88, test88.getStart());
		System.out.println("solve_BFS: \n" + test88.toString());
		MazeSolver.traverse(test88);
		System.out.println(test88.toString());
		
		MazeSolver.solve_DFS(test88, test88.getStart());
		System.out.println("solve_DFS: \n" + test88.toString());
		MazeSolver.traverse(test88);
		System.out.println(test88.toString());
		
		String t2020 = "20 20\r\n" + 
				"+ +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\r\n" + 
				"| |     |   |       | | |     |     |   |\r\n" + 
				"+ + + + + +-+-+-+ + + + +-+ +-+-+ +-+-+ +\r\n" + 
				"|   | |   |   |   |   | | |       |     |\r\n" + 
				"+-+-+ +-+ + + +-+ + +-+ + + +-+-+ + + + +\r\n" + 
				"|   | |   | | |   |   |         |   | | |\r\n" + 
				"+-+ +-+-+ + +-+ +-+-+ +-+-+-+-+-+ + +-+ +\r\n" + 
				"| | |             | |     |       | |   |\r\n" + 
				"+ + + +-+ +-+-+-+-+ +-+ +-+-+ +-+-+ +-+-+\r\n" + 
				"| |     |   |     |           |   | |   |\r\n" + 
				"+ +-+-+ +-+-+-+ +-+-+-+ + +-+-+ +-+-+ +-+\r\n" + 
				"| |   |     | |         |   | | |   |   |\r\n" + 
				"+ +-+ + + +-+ + +-+-+-+ +-+-+ + + +-+-+ +\r\n" + 
				"|   | | |   |       | | |     |         |\r\n" + 
				"+ +-+ +-+-+-+ +-+-+-+ +-+ +-+ + +-+ +-+-+\r\n" + 
				"|     | | |   |   | |   | |   | | | |   |\r\n" + 
				"+-+ + + + + +-+-+ + +-+ + +-+ + + + + +-+\r\n" + 
				"|   |   |                 | |   |     | |\r\n" + 
				"+-+ +-+ + +-+ +-+-+-+ +-+-+ +-+ + +-+-+ +\r\n" + 
				"|   |     | |   |           |   | |     |\r\n" + 
				"+-+-+ + +-+ +-+-+ +-+-+ + +-+-+ + +-+ + +\r\n" + 
				"| |   | |   |     | |   | |     | |   | |\r\n" + 
				"+ + +-+-+ +-+ +-+ + +-+-+ +-+-+-+ +-+ +-+\r\n" + 
				"|   | |       |   | |         | |   | | |\r\n" + 
				"+ +-+ + +-+ +-+ +-+ +-+ + +-+-+ +-+-+ + +\r\n" + 
				"| |       |   |   |   | | |       | |   |\r\n" + 
				"+ + + +-+-+ +-+-+-+ +-+-+ + +-+-+ + + +-+\r\n" + 
				"| | | | |   |   |   | | | |   |       | |\r\n" + 
				"+-+-+-+ +-+ +-+ +-+ + + + + +-+-+ +-+ + +\r\n" + 
				"| |   |           | |         |     |   |\r\n" + 
				"+ + + +-+-+-+-+ + + + +-+ +-+ +-+ +-+ + +\r\n" + 
				"| | |           | |   | |   |   |   | | |\r\n" + 
				"+ +-+ +-+-+ + +-+ + + + + +-+ +-+-+ + +-+\r\n" + 
				"|     | |   | | | | | |   | | | |   | | |\r\n" + 
				"+ + + + +-+-+ + + +-+-+-+-+ + + + +-+-+ +\r\n" + 
				"| | | |   |     | |           | |   |   |\r\n" + 
				"+ +-+ + + + +-+ +-+ +-+-+-+ + + +-+-+ + +\r\n" + 
				"|   | | |   |     | |       |         | |\r\n" + 
				"+-+ + + + + +-+-+ +-+-+ +-+ + + +-+-+ + +\r\n" + 
				"|   | | | |   |     |   |   | | |     | |\r\n" + 
				"+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ +";
		Maze test2020 = MazeParser.parse(t2020);
		System.out.println(test2020.getWidth() + " " + test2020.getHeight() + "\n" + test2020.toString());
		assertEquals(test2020.toString(), "+ +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" + 
				"| |     |   |       | | |     |     |   |\n" + 
				"+ + + + + +-+-+-+ + + + +-+ +-+-+ +-+-+ +\n" + 
				"|   | |   |   |   |   | | |       |     |\n" + 
				"+-+-+ +-+ + + +-+ + +-+ + + +-+-+ + + + +\n" + 
				"|   | |   | | |   |   |         |   | | |\n" + 
				"+-+ +-+-+ + +-+ +-+-+ +-+-+-+-+-+ + +-+ +\n" + 
				"| | |             | |     |       | |   |\n" + 
				"+ + + +-+ +-+-+-+-+ +-+ +-+-+ +-+-+ +-+-+\n" + 
				"| |     |   |     |           |   | |   |\n" + 
				"+ +-+-+ +-+-+-+ +-+-+-+ + +-+-+ +-+-+ +-+\n" + 
				"| |   |     | |         |   | | |   |   |\n" + 
				"+ +-+ + + +-+ + +-+-+-+ +-+-+ + + +-+-+ +\n" + 
				"|   | | |   |       | | |     |         |\n" + 
				"+ +-+ +-+-+-+ +-+-+-+ +-+ +-+ + +-+ +-+-+\n" + 
				"|     | | |   |   | |   | |   | | | |   |\n" + 
				"+-+ + + + + +-+-+ + +-+ + +-+ + + + + +-+\n" + 
				"|   |   |                 | |   |     | |\n" + 
				"+-+ +-+ + +-+ +-+-+-+ +-+-+ +-+ + +-+-+ +\n" + 
				"|   |     | |   |           |   | |     |\n" + 
				"+-+-+ + +-+ +-+-+ +-+-+ + +-+-+ + +-+ + +\n" + 
				"| |   | |   |     | |   | |     | |   | |\n" + 
				"+ + +-+-+ +-+ +-+ + +-+-+ +-+-+-+ +-+ +-+\n" + 
				"|   | |       |   | |         | |   | | |\n" + 
				"+ +-+ + +-+ +-+ +-+ +-+ + +-+-+ +-+-+ + +\n" + 
				"| |       |   |   |   | | |       | |   |\n" + 
				"+ + + +-+-+ +-+-+-+ +-+-+ + +-+-+ + + +-+\n" + 
				"| | | | |   |   |   | | | |   |       | |\n" + 
				"+-+-+-+ +-+ +-+ +-+ + + + + +-+-+ +-+ + +\n" + 
				"| |   |           | |         |     |   |\n" + 
				"+ + + +-+-+-+-+ + + + +-+ +-+ +-+ +-+ + +\n" + 
				"| | |           | |   | |   |   |   | | |\n" + 
				"+ +-+ +-+-+ + +-+ + + + + +-+ +-+-+ + +-+\n" + 
				"|     | |   | | | | | |   | | | |   | | |\n" + 
				"+ + + + +-+-+ + + +-+-+-+-+ + + + +-+-+ +\n" + 
				"| | | |   |     | |           | |   |   |\n" + 
				"+ +-+ + + + +-+ +-+ +-+-+-+ + + +-+-+ + +\n" + 
				"|   | | |   |     | |       |         | |\n" + 
				"+-+ + + + + +-+-+ +-+-+ +-+ + + +-+-+ + +\n" + 
				"|   | | | |   |     |   |   | | |     | |\n" + 
				"+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ +\n");
		System.out.println(test2020.getWidth() + " " + test2020.getHeight() + "\n" + test2020.toString());
		MazeSolver.solve_BFS(test2020, test2020.getStart());
		System.out.println("solve_BFS: \n" + test2020.toString());
		MazeSolver.traverse(test2020);
		System.out.println(test2020.toString());
		
		MazeSolver.solve_DFS(test2020, test2020.getStart());
		System.out.println("solve_DFS: \n" + test2020.toString());
		MazeSolver.traverse(test2020);
		System.out.println(test2020.toString());
	}
}
