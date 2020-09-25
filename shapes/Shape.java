/* Robert Jacob
 * Definition of superclass Shape
 */

abstract class Shape {
	// protected, not private, cause is used by our subclasses
	protected int x, y;

	public void setPos (int x, int y) {
		this.x = x;
    this.y = y;
	}

	abstract public void draw();

	abstract public float area();
}
