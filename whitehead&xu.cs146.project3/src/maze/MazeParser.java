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
				System.out.print(split[i]);
			}
			System.out.println();
			row++;
		}

		for (int ver = 1; ver < 2 * y; ver += 2) {
			for (int hor = 1; hor < 2 * x; hor += 2) {
				int xc = (hor - 1) / 2;
				int yc = (ver - 1) / 2;
				System.out.print("(" + xc + ", " + yc + ")");
				if (yc == 0) { // topmost row, ignore the top wall
					// TBD
				} else if (yc == y - 1) { // bottom most row, ignore the bottom wall
					// TBD
				} else { // do not ignore the walls above and below
					if ((grid[ver - 1][hor] + "").equals("-")) { // check top wall
						// TBD: wall
					} else {
						// TBD: connect the top npde to this node
					}

					if (xc == 0) { // leftmost column, ignore the left wall
						// TBD: check right wall
					} else if (xc == x - 1) { // rightmost column, ignore the right wall
						// TBD: check left wall
					} else { // do not ignore the right and left walls
						if ((grid[ver][hor - 1] + "").equals("|")) { // check left wall
							// TBD: wall
						} else {
							// TBD: connect the left node to this node
						}

						if ((grid[ver][hor + 1] + "").equals("|")) { // check right wall
							// TBD: wall
						} else {
							// TBD: connect the right node to this node
						}
					}

					if ((grid[ver + 1][hor] + "").equals("-")) { // check bottom wall
						// TBD: wall
					} else {
						// TBD: connect the bottom node to this node
					}
				}
			}
			System.out.println();
		}
		return maze;
	}

	public static void main(String[] args) {
		String test = "4 4\r\n" + "+ +-+-+-+\r\n" + "|   |   |\r\n" + "+-+ +-+ +\r\n" + "| |     |\r\n"
				+ "+ +-+-+ +\r\n" + "|       |\r\n" + "+ +-+-+-+\r\n" + "|       |\r\n" + "+-+-+-+ +\r\n" + "";
		MazeParser.parse(test);
	}
}
