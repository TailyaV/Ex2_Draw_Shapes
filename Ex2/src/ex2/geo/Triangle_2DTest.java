package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {
   private Point_2D p1 = new Point_2D(0,0);
   private Point_2D p2 = new Point_2D(0,10);
   private Point_2D p3 = new Point_2D(15,0);
   private Triangle_2D t = new Triangle_2D(p1,p2,p3);

    @Test
    void ToSrting() {
        String s = t.toString();
        String s1 = "0.0,0.0, 0.0,10.0, 15.0,0.0";
        assertEquals(s1, s);
    }

    @Test
    void contains() {
        Point_2D pContains = new Point_2D(5,2);
        assertTrue(t.contains(pContains));
    }

    @Test
    void area() {
        double a = t.area();
        assertEquals(75.0,a);
    }

    @Test
    void perimeter() {
        double p = t.perimeter();
        double dis = p2.distance(p3);
        assertEquals(dis+25 ,p);
    }

    @Test
    void translate() {
        Point_2D p = new Point_2D(2,2);
       Point_2D vec =  p1.vector(p);
        t.translate(vec);
        Point_2D po1 = new Point_2D(2,2);
        Point_2D po2 = new Point_2D(2,12);
        Point_2D po3 = new Point_2D(17,2);
        Triangle_2D t2 = new Triangle_2D(po1, po2, po3);
        assertTrue(t2.triangleAssertEqual(t));
    }

    @Test
    void copy() {
        assertTrue(t.triangleAssertEqual((Triangle_2D) t.copy()));
    }

    @Test
    void scale() {
        double ar = t.area();
        t.scale(p1, 10);
        t.scale(p1, 0.1);
        double ar2 = t.area();
        assertEquals(ar,ar2, Ex2_Const.EPS);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,10);
        Point_2D p3 = new Point_2D(15,0);
        Triangle_2D t1 = new Triangle_2D(p1,p2,p3);
        t.rotate(Point_2D.ORIGIN, 10);
        t.rotate(Point_2D.ORIGIN, -10);
        assertTrue(t.triangleAssertEqual(t1));
    }
}