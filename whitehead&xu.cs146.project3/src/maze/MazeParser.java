package maze;

import java.util.Scanner;

public class MazeParser {
	public static Maze parse(String ascii) {
		Scanner scanner = new Scanner(ascii);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		Maze maze = new Maze(x, y);
		scanner.nextLine(); // skip second line because it's pointless if all the mazes have the same format
		int row = 0;
		int col = 0;
		char[][] grid = new char[2 * y + 1][2 * x + 1];
		while (scanner.hasNextLine()) { // break up the maze into a char grid
			char[] split = scanner.nextLine().substring(0, 2 * x + 1).toCharArray();
			for (int i = 0; i < 2 * x + 1; i++) {
				grid[i][row] = split[i];
				//System.out.print(split[i]);
			}
			//System.out.println();
			row++;
		}

		for (int ver = 1; ver < 2 * y; ver += 2) {
			for (int hor = 1; hor < 2 * x; hor += 2) {
				int xc = (ver - 1) / 2;
				int yc = (hor - 1) / 2;
				MazeNode curr = maze.getNode(xc, yc);
				if (curr.getNorthAdj() != null) {
					String wall = grid[ver][hor - 1] + "";
					//System.out.print(wall);
					if (!wall.equals(" ")) {
						//System.out.println(curr.toString() + " encountered the north wall");
					} else {
						connectTwoNodes(curr, curr.getNorthAdj());
						//System.out.println("Connected " + curr + " to the north");
					}
				}
				if (curr.getSouthAdj() != null) {
					String wall = grid[ver][hor + 1] + "";
					//System.out.print(wall);
					if (!wall.equals(" ")) {
						//System.out.println(curr.toString() + " encountered the south wall");
					} else {
						connectTwoNodes(curr, curr.getSouthAdj());
						//System.out.println("Connected " + curr + " to the south");
					}
				}
				if (curr.getEastAdj() != null) {
					String wall = grid[ver + 1][hor] + "";
					//System.out.print(wall);
					if (wall.equals("|")) {
						//System.out.println(curr.toString() + " encountered the east wall");
					} else {
						connectTwoNodes(curr, curr.getEastAdj());
						//System.out.println("Connected " + curr + " to the east");
					}
				}
				if (curr.getWestAdj() != null) {
					String wall = grid[ver - 1][hor] + "";
					//System.out.print(wall);
					if (wall.equals("|")) {
						//System.out.println(curr.toString() + " encountered the west wall");
					} else {
						connectTwoNodes(curr, curr.getWestAdj());
						//System.out.println("Connected " + curr + " to the west");
					}
				}
				//System.out.println();
			}
		}
		scanner.close();
		return maze;
	}

	private static void connectTwoNodes(MazeNode a, MazeNode b) {
		a.addConnected(b);
		b.addConnected(a);
	}
}
