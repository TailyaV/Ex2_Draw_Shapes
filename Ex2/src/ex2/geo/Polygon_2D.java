package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * Docomentation @Talia.Vallerstein
 * This class represents a 2D Polygon in the plane.
 * The Polygon implements the GeoShape Interface:
 * ToString- Converts the Polygon data to String.
 * Contains-Check if curtain point is in the Polygon area by dividing the polygon to segments, sent them to isCut3 function with segment of click point and outPoint, count the num fo intersections time(even- out, uneven-in) .
 * Area- Calculating the Polygon area by Geous algorithm.
 * Perimeter- Calculating the Polygon perimeter.
 * Translate-Move the Polygon according to given vector.
 * Copy-copy the given Polygon.
 * Scale - decreases or increases the Polygon according to given percentage.
 * Rotate - Rotate the Polygon by a given angle.
 * isEqualPol - check equality between two given Polygons.
 */

public class Polygon_2D implements GeoShape{
	////// add your code here //////
	private PointContainer points;


	////////////////////////////////
	public Polygon_2D() {
		////// add your code here //////
		this.points = new PointContainer();
		////////////////////////////////
	}
	public Polygon_2D(Polygon_2D po) {
		////// add your code here //////
		points = new PointContainer();
		 for(Point_2D p : po.getAllPoints()){
			 points.add(new Point_2D(p));
		 }
		////////////////////////////////
	}
	public Point_2D[] getAllPoints() {
		////// add your code here //////
		Point_2D[] p = new Point_2D[this.points.size()];
		for (int i = 0; i < this.points.size(); i = i + 1){
			p[i] = this.points.get(i);
		}
		return p;
		////////////////////////////////
	}

	public void add(Point_2D p) {
		////// add your code here //////
		if(p != null){
			this.points.add(p);
			}
		}
		////////////////////////////////

	@Override
	public String toString() {
		String ans = "";
		int i = 0;
		for(; i < this.points.size() - 1; i = i + 1){
			ans = ans + this.points.get(i).toString() + ", ";
		}
		ans = ans + this.points.get(i).toString();
		return ans;
	}

	@Override
	public boolean contains(Point_2D ot) {
		////// add your code here //////
		Point_2D maxPoint = new Point_2D(0,0);
		for(int i = 0; i < this.points.size(); i = i + 1){
			if(this.points.get(i).x() > maxPoint.x() && points.get(i).y() > maxPoint.y()){
				maxPoint = points.get(i);
			}
		}
		Point_2D outPoint = new Point_2D(maxPoint.x() + 2, maxPoint.y() + 1);
		int cutTime = 0;
		Segment_2D s1 = new Segment_2D(ot,outPoint);
		int i = 0;
		for(; i < points.size()-1; i = i + 1){
			Segment_2D newSeg = new Segment_2D(points.get(i),points.get(i + 1));
			this.rotate(Point_2D.ORIGIN,0.1);
			if(s1.isCut3(newSeg)){
				cutTime = cutTime + 1;
			}
			this.rotate(Point_2D.ORIGIN,-0.1);
		}
		Segment_2D endSeg = new Segment_2D(points.get(i), points.get(0));
		this.rotate(Point_2D.ORIGIN,0.1);
		if (s1.isCut3(endSeg)){
			cutTime = cutTime + 1;
		}
		this.rotate(Point_2D.ORIGIN,-0.1);

		if (cutTime % 2 != 0){
			return true;
		}
		return false;
		////////////////////////////////
	}

	@Override
	public double area() {
		////// add your code here //////
		double plus = 0;
		int i = 0;
		for(; i < points.size() - 2; i = i + 1){
			plus = plus + points.get(i).x() * points.get(i + 1).y();
		}
		plus = plus + points.get(i + 1).x() * points.get(0).y();

		int j = 0;
		double minus = 0;
		for(; j < points.size() - 2; j = j + 1) {
			minus = minus + -(points.get(i + 1).x() * points.get(i).y());
		}
		minus = minus + -(points.get(0).x() * points.get(i + 1).y());
		return 0.5 * Math.abs(plus + minus);
		////////////////////////////////
	}
	@Override
	public double perimeter() {
		////// add your code here //////
		int i = 0;
		double per = 0;
		for(; i < points.size() - 2; i = i + 1){
			per = per + points.get(i).distance(points.get(i + 1));
		}
		 return per + points.get(i + 1).distance(points.get(0));
		////////////////////////////////
	}
	@Override
	public void translate(Point_2D vec) {
		////// add your code here //////
		for(int i = 0; i < points.size(); i = i + 1){
			points.get(i).move(vec);
		}
		////////////////////////////////
	}
	@Override
	public GeoShape copy() {
		return new Polygon_2D(this);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		////// add your code here //////
			for(int i = 0; i < points.size(); i = i + 1){
				points.get(i).scale(center, ratio);
			}
		////////////////////////////////
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		////// add your code here //////
		for(int i = 0; i < points.size(); i = i + 1){
			points.get(i).rotate(center, angleDegrees);
		}
		////////////////////////////////
	}



	public boolean isEqualPol(Polygon_2D p1){
		if(p1.points.size() != this.points.size()){
			return false;
		}
		for(int i = 0; i < p1.points.size()-1; i = i + 1) {
			if(p1.points.get(i).notClose2equals(this.points.get(i), Ex2_Const.EPS)){
				return false;
			}

		}

		return true;
	}

}
