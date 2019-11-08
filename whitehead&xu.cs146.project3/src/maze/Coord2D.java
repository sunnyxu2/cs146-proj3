package maze;

/**
 * Immutable object that acts like a coordinate
 */
public class Coord2D {
	private final int x;
	private final int y;

	public Coord2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
