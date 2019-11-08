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
	
	public MazeNode getEast() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getWest() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getNorth() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getSouth() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
				return node;
			}
		}
		return null;
	}
}
