package maze;

/**
 * Immutable object that acts like a coordinate. Format is (x, y).
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

	public boolean equals(Coord2D other) {
		return other.x == this.x && other.y == this.y;
	}
	
	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
}
