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
			}
			System.out.println();
		}
		return maze;
	}

	public static void main (String[] args) {
		String test = "4 4\r\n" + 
				"+ +-+-+-+\r\n" + 
				"|   |   |\r\n" + 
				"+-+ +-+ +\r\n" + 
				"| |     |\r\n" + 
				"+ +-+-+ +\r\n" + 
				"|       |\r\n" + 
				"+ +-+-+-+\r\n" + 
				"|       |\r\n" + 
				"+-+-+-+ +\r\n" + 
				"";
		MazeParser.parse(test);
	}
}
