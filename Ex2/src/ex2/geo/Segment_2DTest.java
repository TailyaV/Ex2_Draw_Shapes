package ex2.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {

    private Point_2D p1 = new Point_2D(0, 0);
    private Point_2D p2 = new Point_2D(5, 5);
    private Segment_2D s1 = new Segment_2D(p1, p2);

    @Test
    void ToString(){
        String s = s1.toString();
        String s1 = "0.0,0.0, 5.0,5.0";
        assertEquals(s, s1);
    }

    @Test
    void contains() {
        Point_2D p = new Point_2D(1,1);
        assertTrue(s1.contains(p));
    }

    @Test
    void area() {
        assertEquals(p1.distance(p2), s1.area());

    }

    @Test
    void perimeter() {
        assertEquals(2*p1.distance(p2), s1.perimeter());
    }

    @Test
    void translate() {
        Point_2D vec = p1.vector(p2);
        s1.translate(vec);
        Point_2D p3 = new Point_2D(10,10);
        Segment_2D s = new Segment_2D(this.p2, p3);
        assertTrue(s.segIsEqual(s1));
    }

    @Test
    void copy() {
        Segment_2D s = (Segment_2D) this.s1.copy();
        assertTrue(s.segIsEqual(s1));
    }

    @Test
    void scale() {
        Segment_2D s = (Segment_2D) this.s1.copy();
        this.s1.scale(Point_2D.ORIGIN, 10);
        this.s1.scale(Point_2D.ORIGIN, 0.1);
        assertTrue(s.segIsEqual(s1));
    }

    @Test
    void rotate() {
        Segment_2D s = (Segment_2D) this.s1.copy();
        this.s1.rotate(Point_2D.ORIGIN, 360);
        assertTrue(s.segIsEqual(s1));
    }

    @Test
    void isCut3() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(5, 5);
        Point_2D a1 = new Point_2D(0, 1);
        Point_2D a2 = new Point_2D(1, 0);
        Segment_2D s1 = new Segment_2D(p1, p2);
        Segment_2D nSeg = new Segment_2D(a1, a2);
        if (s1.isCut3(nSeg) != true) {
            fail();
        }
    }
}