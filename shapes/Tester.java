/*
 * Just a main program for testing our objects
 * this time exploiting polymorphism
 * Note that the other *.java files don't change
 */

class Tester {

	// The main program
	public static void main (String args[]) {

		/*
		 * Data definitions
		 */
		Shape s1, s2, s3;

		/*
		 * And now, instantiate the objects
		 */
		s1 = new Rect (10, 10, 50, 50);
		s2 = new Rect (80, 10, 10, 100);
		s3 = new Circle (35, 90, 10);

		/*
		 * "Draw" them
		 */
		s1.draw ();
		s2.draw ();
		s3.draw ();

		/*
		 * Compute and print total area
		 */
		System.out.println ("Total area = " +
			(s1.area() + s2.area() + s3.area()));
	}
}
