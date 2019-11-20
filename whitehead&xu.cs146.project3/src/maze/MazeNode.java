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

	/**
	 * Constructs a node from x and y coordinate
	 * @param x
	 * @param y
	 */
	public MazeNode(int x, int y) {
		coord = new Coord2D(x, y);
		adj = new ArrayList<>();
		connected = new LinkedList<>();
		color = Color.WHITE;
		distance = 0;
		discovery = 0;
		finish = 0;
		setLabel(0);
	}

	/**
	 * Constructs a node from a coordinate object
	 * @param x
	 * @param y
	 */
	public MazeNode(Coord2D coord) {
		this.coord = coord;
		adj = new ArrayList<>();
		connected = new LinkedList<>();
		color = Color.WHITE;
		distance = 0;
		discovery = 0;
		finish = 0;
		setLabel(0);
	}

	/**
	 * Returns a 2d coordinate object in the format (x, y)
	 * @return
	 */
	public Coord2D getCoord() {
		return coord;
	}

	/**
	 * Gets arraylist of adjacent nodes
	 * @return
	 */
	public ArrayList<MazeNode> getAdjacencyList() {
		return adj;
	}

	/**
	 * Adds node to arraylist of adjacent nodes
	 * @param other
	 */
	public void addAdjacent(MazeNode other) {
		adj.add(other);
	}
	
	/**
	 * Gets the linkedlist of connected nodes
	 * @return
	 */
	public LinkedList<MazeNode> getConnectedList() {
		return connected;
	}
	
	/**
	 * Adds node to linkedlist of connected nodes
	 * @param other
	 */
	public void addConnected(MazeNode other) {
		connected.add(other);
	}
	
	/**
	 * Gets color
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Gets eastern node in adjacency array (not connected)
	 * @return eastern node or null
	 */
	public MazeNode getEastAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets western node in adjacency array (not connected)
	 * @return western node or null
	 */
	public MazeNode getWestAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets northern node in adjacency array (not connected)
	 * @return northern node or null
	 */
	public MazeNode getNorthAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets southern node in adjacency array (not connected)
	 * @return southern node or null
	 */
	public MazeNode getSouthAdj() {
		for (MazeNode node : adj) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Gets eastern node in linkedlist of connected nodes
	 * @return eastern node or null
	 */
	public MazeNode getEastConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() + 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets western node in linkedlist of connected nodes
	 * @return western node or null
	 */
	public MazeNode getWestConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() - 1 && node.getCoord().getY() == this.coord.getY()) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets northern node in linkedlist of connected nodes
	 * @return northern node or null
	 */
	public MazeNode getNorthConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() - 1) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Gets southern node in linkedlist of connected nodes
	 * @return southern node or null
	 */
	public MazeNode getSouthConnected() {
		for (MazeNode node : connected) {
			if (node.getCoord().getX() == this.coord.getX() && node.getCoord().getY() == this.coord.getY() + 1) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Sets distance
	 * @param d
	 */
	public void setDistance(int d) {
		distance = d;
	}
	
	/**
	 * Gets distance
	 * @return
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * Sets discovery time
	 * @param d
	 */
	public void setDiscoveryTime(int d) {
		discovery = d;
	}
	
	/**
	 * Gets discovery time
	 * @return
	 */
	public int getDiscoveryTime() {
		return discovery;
	}
	
	/**
	 * Sets finish time
	 * @param f
	 */
	public void setFinishTime(int f) {
		finish = f;
	}
	
	/**
	 * Gets finish time
	 * @return
	 */
	public int getFinishTime() {
		return finish;
	}
	
	/**
	 * Gets parent node
	 * @return
	 */
	public MazeNode getParent() {
		return parent;
	}
	
	/**
	 * Sets parent node
	 * @param other
	 */
	public void setParent(MazeNode other) {
		parent = other;
	}
	
	public String toString() {
		return "[" + color + ", " + coord.toString() + "]";
	}

	/**
	 * Gets label (an integer)
	 * @return
	 */
	public int getLabel() {
		return label;
	}

	/**
	 * Sets label as an integer
	 * @param label
	 */
	public void setLabel(int label) {
		this.label = label;
	}
}
