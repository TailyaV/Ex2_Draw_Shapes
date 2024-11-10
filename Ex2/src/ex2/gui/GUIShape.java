package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 * Docomentation @Talia.Vallerstein
 * assertEqualGeuShape - Check equalty between two Geo-Shapes, by comparing every parameter.
 * assertEqualColor - Check equalty between two Geo-Shapes colors, by comparing thare base colors.
 */
import ex2.geo.*;
import java.awt.*;


public class GUIShape implements GUI_Shape {
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;

	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g != null) {
			_g = g.copy();
		}
		_fill = f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}

	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}

	public GUIShape(String s) {
		String[] s1 = s.split(",");
		this._color = new Color(Integer.parseInt(s1[1]));
		this._fill = Boolean.parseBoolean(s1[2]);
		this._tag = Integer.parseInt(s1[3]);
		String tipe = s1[4];

		if (tipe.equals("Circle_2D")) {
			double x = Double.parseDouble(s1[5]);
			double y = Double.parseDouble(s1[6]);
			Point_2D p = new Point_2D(x, y);
			double rad = Double.parseDouble(s1[7]);
            this._g = new Circle_2D(p, rad);
		}

		if (tipe.equals("Segment_2D")) {
			double x = Double.parseDouble(s1[5]);
			double y = Double.parseDouble(s1[6]);
			double x1 = Double.parseDouble(s1[7]);
			double y1 = Double.parseDouble(s1[8]);
			Point_2D p = new Point_2D(x, y);
			Point_2D p1 = new Point_2D(x1, y1);
            this._g = new Segment_2D(p, p1);
		}

		if (tipe.equals("Rect_2D")) {
			double x =  Double.parseDouble(s1[5]);
			double y =  Double.parseDouble(s1[6]);
			double x1 = Double.parseDouble(s1[7]);
			double y1 = Double.parseDouble(s1[8]);
			double x2 = Double.parseDouble(s1[9]);
			double y2 = Double.parseDouble(s1[10]);
			double x3 = Double.parseDouble(s1[11]);
			double y3 = Double.parseDouble(s1[12]);
			Point_2D p = new Point_2D(x, y);
			Point_2D p1 = new Point_2D(x1, y1);
			Point_2D p2 = new Point_2D(x2, y2);
			Point_2D p3 = new Point_2D(x3, y3);
			this.setShape(new Rect_2D(p, p1, p2, p3));
		}
		if (tipe.equals("Triangle_2D")) {
			double x = Double.parseDouble(s1[5]);
			double y = Double.parseDouble(s1[6]);
			double x1 = Double.parseDouble(s1[7]);
			double y1 = Double.parseDouble(s1[8]);
			double x2 = Double.parseDouble(s1[9]);
			double y2 = Double.parseDouble(s1[10]);
			Point_2D p = new Point_2D(x, y);
			Point_2D p1 = new Point_2D(x1, y1);
			Point_2D p2 = new Point_2D(x2, y2);
			this.setShape(new Triangle_2D(p, p1, p2));
		}
		if (tipe.equals("Polygon_2D")) {
			Polygon_2D p1 = new Polygon_2D();
			for (int i = 5; i < s1.length - 1; i = i + 2) {
				double x = Double.parseDouble(s1[i]);
				double y = Double.parseDouble(s1[i + 1]);
				Point_2D p = new Point_2D(x, y);
				p1.add(p);
			}
			this.setShape(p1);
		}
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		int c = _color.getRed() * 256 * 256 + _color.getGreen() * 256 + _color.getBlue();
		String ans = ""+this.getClass().getSimpleName()+","+ c +","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}

	public boolean assertEqualGeuShape (GUIShape a){
		if(a._g.toString().equals(this._g.toString()) && a._fill == this._fill && a.assertEqualColor(this) && a._tag == this._tag){
			return true;
		}
		return false;
	}

	public boolean assertEqualColor (GUIShape a1) {
	return a1._color.getRed() == this._color.getRed() && a1._color.getGreen() == this._color.getGreen() && a1._color.getBlue() == this._color.getBlue();
	}
}
