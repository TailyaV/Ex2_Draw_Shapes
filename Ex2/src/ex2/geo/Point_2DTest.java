package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {
    private Point_2D p1 = new Point_2D(1,2);
    private Point_2D p4_6 = new Point_2D(4,6);

    @Test
    void add() {
        Point_2D p = p1.add(p4_6);
        Point_2D pp = new Point_2D(5,8);
        double d = p.distance(pp);
        assertTrue(d< Ex2_Const.EPS);
        assertEquals(p,pp);

    }

    @Test
    void testToString() {
        String s = p1.toString();
        String s1 = "1.0,2.0";
        assertEquals(s, s1);

    }

    @Test
    void distance() {
        assertEquals(5.0,  p1.distance(p4_6));
    }

    @Test
    void vectorAndMove() {
        Point_2D p = new Point_2D (1,1);
        Point_2D vec = Point_2D.ORIGIN.vector(p);
        p1.move(vec);
        Point_2D p2 = new Point_2D(2,3);
        p2.close2equals(p1, Ex2_Const.EPS);
    }

    @Test
    void scale() {
        Point_2D p = new Point_2D(p1);
        p.scale(Point_2D.ORIGIN, 0.5);
        Point_2D t = new Point_2D(0.5,1);
        assertEquals(p,t);
    }

    @Test
    void rotate() {
        Point_2D p = new Point_2D(p1);
        p.rotate(Point_2D.ORIGIN,360);
        assertTrue(p1.close2equals(p,Ex2_Const.EPS));


    }
}