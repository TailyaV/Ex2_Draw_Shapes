package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 *
 * Docomentation @Talia.Vallerstein
 * This class represents a 2D Segment in the plane.
 * The Segment implements the GeoShape Interface:
 * ToString- Converts the Segment data to String.
 * Contains-Check if curtain point is in the Segment area.
 * Area- Calculating the Segment area.
 * Perimeter- Calculeting the Segment perimeter.
 * Translate-Move the Segment according to given vector.
 * Copy-copy the given Segment.
 * Scale - decreases or increases the Segment according to given percentage.
 * Rotate - Rotate the Segment by a given angle.
 * SegIsEqual - check equality between two given Segment.
 * isCut3 -Is a function that check if two segments have an intersection point, by calculating their equations.
 */
public class Segment_2D implements GeoShape{

	private Point_2D a1;
	private Point_2D b1;

	public Segment_2D(Point_2D a, Point_2D b) {
		////// add your code here //////
		this.a1 = new Point_2D(a);
		this.b1 = new Point_2D(b);
		////////////////////////////////
	}
	public Segment_2D(Segment_2D t1) {
		////// add your code here //////
		////////////////////////////////
		this.a1 = t1.get_p1();
		this.b1 = t1.get_p2();
	}

	public Point_2D get_p1() {
		////// add your code here //////
		return this.a1;
		////////////////////////////////
	}
	public Point_2D get_p2() {
		////// add your code here //////
		return this.b1;
		////////////////////////////////
	}

	@Override
	public String toString(){
		return this.a1.toString() + ", " + this.b1.toString();
	}


	@Override
	public boolean contains(Point_2D ot) {
		double dis1 = a1.distance(ot);
		double dis2 = b1.distance(ot);
		double disBoth = a1.distance(b1);
		return dis1 + dis2 < disBoth + Ex2_Const.EPS;
	}

	@Override
	public double area() {
		double area = this.b1.distance(this.a1);
		return area;
	}

	@Override
	public double perimeter() {
		double perimeter = 2*(this.b1.distance(this.a1));
		return perimeter;
	}

	@Override
	public void translate(Point_2D vec) {
		this.a1.move(vec);
		this.b1.move(vec);
	}

	@Override
	public GeoShape copy() {
		Segment_2D nSegment = new Segment_2D(this);
		return nSegment;
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this.a1.scale(center,ratio);
		this.b1.scale(center,ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.a1.rotate(center,angleDegrees);
		this.b1.rotate(center,angleDegrees);
	}


	public boolean isCut3(Segment_2D ns) {
		double m_ns = 0;
		double m_s1 = 0;
		if (ns.get_p1().x() == ns.get_p2().x()) {
			m_ns = 0;
		} else {
			m_ns = (ns.get_p1().y() - ns.get_p2().y()) / (ns.get_p1().x() - ns.get_p2().x());
		}
		if (a1.x() == b1.x()) {
			m_s1 = 0;
		} else {
			m_s1 = (a1.y() - b1.y()) / (a1.x() - b1.x());
		}
		if (m_ns == m_s1) {
			return false;
		}
		double d_s1 = a1.y() - m_s1 * a1.x();
		double d_ns = ns.get_p1().y() - m_ns * ns.get_p1().x();
		double x_Co = (d_ns - d_s1) / (m_s1 - m_ns);
		double y_Co = m_s1 * x_Co + d_s1;
		Point_2D inRange = new Point_2D(x_Co, y_Co);
		if (this.contains(inRange) && ns.contains(inRange)) {
			return true;
		}
		return false;
	}

	public boolean segIsEqual(Segment_2D seg){
		return (this.a1.close2equals(seg.a1, Ex2_Const.EPS) && this.b1.close2equals(seg.b1, Ex2_Const.EPS));
	}

}