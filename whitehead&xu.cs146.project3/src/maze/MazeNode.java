package maze;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * White is undiscovered, grey is discovered, 
 * @author Sunny
 *
 */
enum Color {
	WHITE, GRAY, BLACK, RED;
}

/**
 * Compass directions.
 * @author Sunny
 *
 */
enum Compass {
	NORTH, SOUTH, WEST, EAST;
}

/**
 * Object node class for maze creation and search.
 * @author Sunny
 *
 */
public class MazeNode {
	private Color color;
	private ArrayList<MazeNode> adj;
	private LinkedList<MazeNode> connected;
	private Coord2D coord;
	private int distance;
	private int discovery;
	private int finish;
	private int label;
	private MazeNode parent;

	public MazeNode(int x, int y) {
		coord = new Coord2D(x, y);
		adj = new ArrayList<>();
		connected = new LinkedList<>();
		color = Color.WHITE;
		distance = 0;
		discovery = 0;
		finish = 0;
		setLabel(-1);
	}

	public MazeNode(Coord2D coord) {
		this.coord = coord;
		adj = new ArrayList<>();
		connected = new LinkedList<>();
		color = Color.WHITE;
		distance = 0;
		discovery = 0;
		finish = 0;
		setLabel(-1);
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
	
	public MazeNode getEastAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getWestAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getNorthAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getSouthAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
				return node;
			}
		}
		return null;
	}
	
	public Compass getCompassDirAdj(MazeNode node) {
		if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
			return Compass.SOUTH;
		} else if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
			return Compass.NORTH;
		} else if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
			return Compass.WEST;
		} else if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()){
			return Compass.EAST;
		} else {
			return null;
		}
	}
	
	public MazeNode getEastConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getWestConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getNorthConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
				return node;
			}
		}
		return null;
	}
	
	public MazeNode getSouthConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
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
	
	public MazeNode getParent() {
		return parent;
	}
	
	public void setParent(MazeNode other) {
		parent = other;
	}
	
	public String toString() {
		return "[" + color + ", " + coord.toString() + "]";
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
}
