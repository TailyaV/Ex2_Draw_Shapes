package ex2.geo;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {
    private Point_2D p1 = new Point_2D(1,1);
   private Point_2D p2 = new Point_2D(4,4);
    private Rect_2D r = new Rect_2D(p1, p2);

    @Test
    void contains() {
        Point_2D pInRange = new Point_2D(2,2);
       if( r.contains(pInRange) == false){
           fail();
       };

    }

    @Test
    void testToString() {
        String s = r.toString();
        String s1 = "1.0,1.0, 1.0,4.0, 4.0,4.0, 4.0,1.0";
        assertEquals(s,s1);

    }

    @Test
    void area() {
       double area =  r.area();
       double actualArea = 9.0;
        assertEquals(area, actualArea);
    }

    @Test
    void perimeter() {
        double perimeter = r.perimeter();
        double actualPer = 3*4;
        assertEquals(perimeter, actualPer);
    }

    @Test
    void translate() {
        Point_2D p = new Point_2D(0,0);
        Point_2D vec =  p.vector(p1);
        r.translate(vec);
        Point_2D po1 = new Point_2D(2,2);
        Point_2D po2 = new Point_2D(5,5);
        Rect_2D rec = new Rect_2D(po1,po2);
        rec.recAssertEqual2(r);
    }

    @Test
    void copy() {
        Rect_2D nRec = (Rect_2D) r.copy();
        r.recAssertEqual2(nRec);

    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(4,4);
        Rect_2D r = new Rect_2D(p1, p2);
        Point_2D cen = new Point_2D(1.5,1.5);
        Point_2D np1 = new Point_2D(6.5, 6.5);
        Point_2D np2 = new Point_2D(0.5,0.5);
        Rect_2D nr = new Rect_2D(np2, np1);
        r.scale(cen,2);
       if( r.recAssertEqual2(nr) == false){
           fail();
       }
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Rect_2D rec = new Rect_2D(p1, p2);
        Rect_2D rec1 = new Rect_2D(p1, p2);
        Point_2D cen = new Point_2D(2,2);
        rec.rotate(cen,360);
       if( rec.recAssertEqual2(rec1) == false){
           fail();
       }


    }
}