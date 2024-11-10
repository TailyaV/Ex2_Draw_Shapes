package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane.
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 * Docomentation @Talia.Vallerstein
 * This class represents a 2D circle in the plane.
 * The Circle implements the GeoShape Interface:
 * ToString- Converts the Circle data to String.
 * Contains-Check if curtain point is in the Circle area by checking that the point distance from the center smaller than the Radeus.
 * Area- Calculating the Circle area- PI*Rad square.
 * Perimeter- Calculeting the Circle perimeter 2*PI*Rad.
 * Translate-Move the Circle according to given vector.
 * Copy-copy the given Circle.
 * Scale - decreases or increases the Circle according to given percentage.
 * Rotate - Rotate the Circle by a given angle.
 * circleEqulse - check equality between two given Circles by comparing thare Rad&Center.
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;
	
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c) {
		this(c.getCenter(), c.getRadius());
	}
	public double getRadius() {return this._radius;}
	public Point_2D getCenter(){ return _center;}

	 @Override
	    public String toString() {
			return _center.toString()+", "+_radius;
		}

	@Override
	public boolean contains(Point_2D ot) {
		double dist = ot.distance(_center);
		return dist < this._radius;

	}
	
	@Override
	public double area() {
		////// add your code here //////
		double area = Math.PI * Math.pow(this._radius,2);
		return area;
		////////////////////////////////
	}
	@Override
	public double perimeter() {
		////// add your code here //////
		double perimeter = 2*this._radius*Math.PI;
		return perimeter;
		////////////////////////////////
	}
	@Override
	public void translate(Point_2D vec) {
		////// add your code here //////
	this._center.move(vec);
		////////////////////////////////
	}
	@Override
	public GeoShape copy() {
		////// add your code here //////
		return new Circle_2D(this._center,this._radius);
		//return null;
		////////////////////////////////
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		////// add your code here //////
		this._radius = this._radius * ratio;
		this._center.scale(center,ratio);
		////////////////////////////////
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		////// add your code here //////
		this._center.rotate(center,angleDegrees);

		////////////////////////////////
	}

	public boolean circleEqulse(Circle_2D c1){
		if(c1._radius == this._radius && c1._center.x() == this._center.x() && c1._center.y() == this._center.y()){
			return true;
			}
			return false;
		}
	}

