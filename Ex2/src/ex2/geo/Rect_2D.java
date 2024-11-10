package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 * Docomentation @Talia.Vallerstein
 * This class represents a 2D Rectangle in the plane.
 * The Rectangle implements the GeoShape Interface:
 * ToString- Converts the Rectangle data to String.
 * Contains-Check if curtain point is in the Rectangle area by dividing the Rect to four Triangle according to the click point, colcolating each area and compar to the Ract area.
 * Area- Calculating the Rectangle area.
 * Perimeter- Calculating the Rectangle perimeter.
 * Translate-Move the Rectangle according to given vector.
 * Copy-copy the given Rectangle.
 * Scale - decreases or increases the Rectangle according to given percentage.
 * Rotate - Rotate the Rectangle by a given angle.
 * recAssertEqual2 - check equality between two given Rectangle.
 */
public class Rect_2D implements GeoShape {
	private Point_2D point1;
	private Point_2D point2;
	private Point_2D point3;
	private Point_2D point4;

	public Rect_2D(Point_2D p1, Point_2D p2) {
		////// add your code here //////
		this.point1 = new Point_2D(p1);
		this.point2 = new Point_2D(p1.x(), p2.y());
		this.point3 = new Point_2D(p2);
		this.point4 = new Point_2D(p2.x(), p1.y());
		////////////////////////////////
	}

	public Rect_2D(Point_2D p1, Point_2D p2, Point_2D p3, Point_2D p4) {
		////// add your code here //////
		this.point1 = new Point_2D(p1);
		this.point2 = new Point_2D(p2);
		this.point3 = new Point_2D(p3);
		this.point4 = new Point_2D(p4);
		////////////////////////////////
	}


	public Rect_2D(Rect_2D t1) {
		////// add your code here //////
		this.point1 = t1.point1;
		this.point2 = t1.point2;
		this.point3 = t1.point3;
		this.point4 = t1.point4;
		////////////////////////////////
	}

	public Point_2D[] getAllPoints(){
		Point_2D[] p = {point1, point2, point3, point4};
		return p;
	}

	@Override
	public boolean contains(Point_2D ot) {
		//boolean res = xInRange && yInRange;
		double dis1 = ot.distance(this.point1);
		double dis2 = ot.distance(this.point2);
		double dis3 = ot.distance(this.point3);
		double dis4 = ot.distance(this.point4);

		double dis1_4 = this.point1.distance(this.point4);
		double dis4_2 = this.point2.distance(this.point4);
		double dis2_3 = this.point2.distance(this.point3);
		double dis3_1 = this.point3.distance(this.point1);

		double s1 = (dis1 + dis4 + dis1_4)/2;
		double s2 = (dis2 + dis4 + dis4_2)/2;
		double s3 = (dis2 + dis3 + dis2_3)/2;
		double s4 = (dis3 + dis1 + dis3_1)/2;

		double area1 = Math.sqrt(s1*(s1-dis1)*(s1-dis4)*(s1-dis1_4));
		double area2 = Math.sqrt(s2*(s2-dis2)*(s2-dis4)*(s2-dis4_2));
		double area3 = Math.sqrt(s3*(s3-dis2)*(s3-dis3)*(s3-dis2_3));
		double area4 = Math.sqrt(s4*(s4-dis3)*(s4-dis1)*(s4-dis3_1));
		double areaRect = dis2_3*dis4_2;
		if(area1 + area2 + area3 + area4 <= areaRect + Ex2_Const.EPS) {
			return true;
		}
		else
		return false;
	}

	public double recWidCal(){
		double xLong = 0;
		if (point1.x() > point2.x()){
			xLong = point1.x() - point2.x();
			Math.abs(xLong);
		}
		else {
			xLong = point2.x() - point1.x();
			Math.abs(xLong);
		}
		return xLong;
	}

	public double recHighCal(){
		double yLong = 0;
		if (point1.y() > point2.y()){
			yLong = point1.y() - point2.y();
			Math.abs(yLong);
		}
		else {
			yLong = point2.y() - point1.y();
			Math.abs(yLong);
		}
		return yLong;
	}

	@Override
	public String toString(){
		String toStRec = new String(this.point1.toString() + ", " + this.point2.toString() + ", " + this.point3.toString() + ", " + this.point4.toString());
		return toStRec;
	}

	@Override
	public double area() {
		return recHighCal()*recWidCal();
	}

	@Override
	public double perimeter() {
		double nPerimeter =recWidCal()*2 + recHighCal()*2;
		return nPerimeter;
	}

	@Override
	public void translate(Point_2D vec) {
		this.point1.move(vec);
		this.point2.move(vec);
		this.point3.move(vec);
		this.point4.move(vec);

	}

	@Override
	public GeoShape copy() {
		Rect_2D newRectangle = new Rect_2D(this);
		return newRectangle;
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this.point1.scale(center,ratio);
		this.point2.scale(center,ratio);
		this.point3.scale(center,ratio);
		this.point4.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.point1.rotate(center,angleDegrees);
		this.point2.rotate(center,angleDegrees);
		this.point3.rotate(center, angleDegrees);
		this.point4.rotate(center, angleDegrees);
	}
	public boolean recAssertEqual2(Rect_2D r){
		if(point1.close2equals(r.point1, Ex2_Const.EPS )&& point2.close2equals(r.point2, Ex2_Const.EPS)){
			return true;
		}
		return false;
	}
}
