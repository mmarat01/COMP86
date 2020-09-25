/* Robert Jacob
 * Definition of subclass Rect
 */

class Rect extends Shape {

	private int wid;
	private float aspect;

	public Rect (int x, int y, int wid, int ht) {
  	this.x = x;
    this.y = y;
		// convert from given inputs to our internal data
		this.wid = wid;
		aspect = (float)wid/ht;
	}

	public void setSize (int wid, int ht) {
		this.wid = wid;
		aspect = (float)wid/ht;
	}

	public void draw() {
		System.out.println ("Drawing rectangle at "
				    + x + ", " + y + ", " + wid + ", " + wid/aspect);
	}

	public float area() {
		return (float) (wid * wid / aspect);
	}
}
