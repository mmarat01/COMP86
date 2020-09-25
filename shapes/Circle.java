/* Robert Jacob
 * Now, let's change implementation of circle
 * to use bounding box, starting at top left
 *
 * Note that Tester.java doesn't change at all
 */

class Circle extends Shape {

	private int width, height;

	public Circle (int x, int y, int rad) {
		this.x = x - rad;
		this.y = y - rad;
		width = 2 * rad;
		height = 2 * rad;
	}

	public void setSize (int rad) {
		width = 2 * rad;
		height = 2 * rad;
	}

	public void draw() {
		System.out.println ("Drawing circle at "
			+ (x + width/2) + ", " + (y + height/2)
			+ ", radius = " + width/2);
	}

	public float area() {
		return (float) ((width/2) * (width/2) * 3.14159);
	}
}
