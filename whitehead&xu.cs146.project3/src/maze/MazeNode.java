package maze;

import java.util.ArrayList;
import java.util.LinkedList;

enum Color {
	WHITE, GRAY, BLACK;
}

public class MazeNode {
	private Color color;
	private ArrayList<MazeNode> adj;
	private LinkedList<MazeNode> connected;
	private Coord2D coord;
	private int distance;
	private int discovery;
	private int finish;
	private Coord2D parent;

	public MazeNode(int x, int y) {
		coord = new Coord2D(x, y);
	}

	public MazeNode(Coord2D coord) {
		this.coord = coord;
	}

	public Coord2D getCoord() {
		return coord;
	}

	public ArrayList<MazeNode> getAdjacencyList() {
		return adj;
	}

	public void addAdjacent(MazeNode other) {
		adj.add(other);
	}
	
	public LinkedList<MazeNode> getConnectedList() {
		return connected;
	}
	
	public void addConnected(MazeNode other) {
		connected.add(other);
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
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDiscoveryTime(int d) {
		discovery = d;
	}
	
	public int getDiscoveryTime() {
		return discovery;
	}
	
	public void setFinishTime(int f) {
		finish = f;
	}
	
	public int getFinishTime() {
		return finish;
	}
	
	public Coord2D getParent() {
		return parent;
	}
	
	public void setParent(Coord2D other) {
		parent = other;
	}
}
