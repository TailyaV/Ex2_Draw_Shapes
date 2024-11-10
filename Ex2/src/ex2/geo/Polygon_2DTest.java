package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {

    private Polygon_2D po1, po5;

    @BeforeEach
    public void setUp(){
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,5);
        Point_2D p3 = new Point_2D(5,5);
        Point_2D p4 = new Point_2D(5,0);
        Point_2D p5 = new Point_2D(0,1);
        Point_2D p6 = new Point_2D(1,1);
        Point_2D p7 = new Point_2D(1,0);
        po5 = new Polygon_2D();
        po1 = new Polygon_2D();
        Point_2D[] ps = {p1, p2, p3 , p4};
        Point_2D[] ps2 = {p1, p5, p6, p7};
        for(int i = 0; i < ps.length; i = i + 1){
            po5.add(ps[i]);
        }
        for(int i = 0; i < ps2.length; i = i + 1){
            po1.add(ps2[i]);
        }
    }

    @Test
    void testToString() {
        String s = po1.toString();
        String s1 = "0.0,0.0, 0.0,1.0, 1.0,1.0, 1.0,0.0";
        assertEquals(s,s1);
    }

    @Test
    void contains() {
       Point_2D isIn = new Point_2D(4,4);
       assertTrue(this.po5.contains(isIn));
    }

    @Test
    void area() {
        double a1= this.po5.area();
        assertEquals(a1, 25.0, Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        double per1 = po5.perimeter();
        double per2 = po1.perimeter();
        assertEquals(per1, per2*5);
    }

    @Test
    void translate() {
       Point_2D pO = new Point_2D(0,0);
       Point_2D point1 = new Point_2D(5,5);
       Point_2D vec = pO.vector(point1);
        po1.translate(vec);
        Polygon_2D np = new Polygon_2D();
        Point_2D poi1 = new Point_2D(5,5);
        Point_2D po2 = new Point_2D(0,5);
        Point_2D po3 = new Point_2D(10,10);
        Point_2D po4 = new Point_2D(5,0);
        Point_2D[] pos = {poi1, po2, po3, po4};
        for(int i = 0; i < pos.length; i = i + 1) {
            np.add(pos[i]);
        }
       assertTrue(po1.isEqualPol(np));


    }

    @Test
    void copy() {
        Polygon_2D pol1 = (Polygon_2D) po5.copy();
        assertTrue(pol1.isEqualPol(po5));
    }

    @Test
    void scale() {
        po1.scale(Point_2D.ORIGIN,5);
        assertTrue(po5.isEqualPol(po1));
    }

    @Test
    void rotate() {
        Polygon_2D np = (Polygon_2D) po5.copy();
        po5.rotate(Point_2D.ORIGIN, 360);
        assertTrue(np.isEqualPol(po5));
    }
}