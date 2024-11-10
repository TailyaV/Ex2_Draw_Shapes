package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 *
 * Docomentation @Talia.Vallerstein
 * This class represents a 2D Triangle in the plane.
 * The Triangle implements the GeoShape Interface:
 * ToString- Converts the Triangle data to String.
 * Contains-Check if curtain point is in the Triangle area by dividing the Triangle to three Triangles according to the click point, colcolating each area and compar to the Triangle area.
 * Area- Calculating the Triangle area by Heron algorithm.
 * Perimeter- Calculeting the Triangle perimeter.
 * Translate-Move the Triangle according to given vector.
 * Copy-copy the given Triangle.
 * Scale - decreases or increases the Triangle according to given percentage.
 * Rotate - Rotate the Triangle by a given angle.
 * triangleAssertEqual - check equality between two given Triangle.
 */
public class Triangle_2D implements GeoShape{
	////// add your code here //////
private Point_2D point_1;
private Point_2D point_2;
private Point_2D point_3;

	////////////////////////////////
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		////// add your code here //////
		this.point_1 = new Point_2D(p1);
		this.point_2 = new Point_2D(p2);
		this.point_3 = new Point_2D(p3);
		////////////////////////////////
	}
	public Triangle_2D(Triangle_2D t1) {
		////// add your code here //////
		t1.getAllPoints();
		////////////////////////////////
	}
	public Point_2D[] getAllPoints() {
		////// add your code here //////
		Point_2D[] arrPoint = {this.point_1, this.point_2, this.point_3};
		return arrPoint;
		////////////////////////////////
	}

@Override
	public String toString(){
		String s = this.point_1.toString() + ", " + this.point_2.toString() +", " + this.point_3.toString();
		return s;
	}

	@Override
	public boolean contains(Point_2D ot) {
		double b1 = ot.distance(this.point_1);
		double b2 = ot.distance(this.point_2);
		double b3 = ot.distance(this.point_3);
		double a1 = this.point_1.distance(this.point_2);
		double a2 = this.point_1.distance(this.point_3);
		double a3 = this.point_3.distance(this.point_2);
		double sA1 = (a1 + b2 + b1)/2;
		double area1 = Math.sqrt(sA1*(sA1-a1)*(sA1-b2)*(sA1-b1));
		double sA2 = (a3 + b2 + b3)/2;
		double area2 = Math.sqrt(sA2*(sA2-a3)*(sA2-b2)*(sA2-b3));
		double sA3 = (a2 + b1 + b3)/2;
		double area3 = Math.sqrt(sA3*(sA3-a2)*(sA3-b1)*(sA3-b3));
		double sAll4 = (a1 + a2 + a3)/2;
		double areaAll4 = Math.sqrt(sAll4*(sAll4-a1)*(sAll4-a2)*(sAll4-a3));
		if(area1 +area2 +area3 < (areaAll4 + Ex2_Const.EPS))
		return true;
		else
			return false;
	}

	@Override
	public double area() {
		double a1 = this.point_1.distance(this.point_2);
		double a2 = this.point_1.distance(this.point_3);
		double a3 = this.point_3.distance(this.point_2);
		double s = (a1 + a2 + a3)/2;
		return Math.sqrt(s*(s-a1)*(s-a2)*(s-a3));
	}

	@Override
	public double perimeter() {
		double a1 = this.point_1.distance(this.point_2);
		double a2 = this.point_1.distance(this.point_3);
		double a3 = this.point_3.distance(this.point_2);
		return a1 + a2 + a3;
	}

	@Override
	public void translate(Point_2D vec) {
		this.point_1.move(vec);
		this.point_2.move(vec);
		this.point_3.move(vec);
	}

	@Override
	public GeoShape copy() {
		Triangle_2D nTri = new Triangle_2D(this.point_1, this.point_2, this.point_3);
		return nTri ;
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this.point_1.scale(center,ratio);
		this.point_2.scale(center,ratio);
		this.point_3.scale(center,ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.point_1.rotate(center,angleDegrees);
		this.point_2.rotate(center,angleDegrees);
		this.point_3.rotate(center,angleDegrees);

	}

	public boolean triangleAssertEqual(Triangle_2D t1) {
	if( t1.point_1.close2equals(this.point_1,Ex2_Const.EPS) && t1.point_2.close2equals(this.point_2, Ex2_Const.EPS) && t1.point_3.close2equals(this.point_3, Ex2_Const.EPS)){
	return true;
	}
	return false;
	}
}
