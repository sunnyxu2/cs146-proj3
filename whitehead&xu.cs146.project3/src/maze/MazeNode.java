package maze;

import java.util.LinkedList;

enum Color {
	WHITE, GRAY, BLACK;
}

public class MazeNode {
	private Color color;
	private LinkedList<MazeNode> adj;
	private Coord2D coord;

	public MazeNode(int x, int y) {
		coord = new Coord2D(x, y);
	}

	public MazeNode(Coord2D coord) {
		this.coord = coord;
	}

	public Coord2D getCoord() {
		return coord;
	}

	public LinkedList<MazeNode> getAdjacent() {
		return adj;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
