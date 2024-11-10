package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {

    @Test
    void testToString() {
        Point_2D p = new Point_2D(1,2);
        Circle_2D c = new Circle_2D(p,5.5);
        String strTest = "1.0,2.0, 5.5";
        if (!( c.toString() == strTest)){
            fail();
        }
    }

    @Test
    void contains() {
        Point_2D p = new Point_2D(1,2);
        Point_2D in = new Point_2D(5,3);
        Circle_2D c = new Circle_2D(p,5.5);
       assertTrue(c.contains(in));
    }

    @Test
    void area() {
        Point_2D p = new Point_2D(1,2);
        Circle_2D c = new Circle_2D(p,5.5);
        double area = c.area();
        double actualErea = 95.03317;
       if (!(area<actualErea + Ex2_Const.EPS && area > actualErea)) {
           fail();
       };
    }

    @Test
    void perimeter() {
        Point_2D p = new Point_2D(1,2);
        Circle_2D circPer = new Circle_2D(p,5);
        double perimTest = circPer.perimeter();
        double perimCalc = 2*5*Math.PI;
        assertEquals(perimCalc,perimTest);
    }

    @Test
    void translate() {
        Point_2D p = new Point_2D(5,2);
        Point_2D resP = new Point_2D(1,1);
        Point_2D target = new Point_2D(1,1);
        Circle_2D c = new Circle_2D(p,5);
        Point_2D nVec = p.vector(target);
        c.translate(nVec);
        Circle_2D resC = new Circle_2D(resP,5);
        if(resC.circleEqulse(c) == false){
            fail();
        };

    }

    @Test
    void copy() {
        Point_2D p = new Point_2D(1,2);
        Circle_2D nCirc = new Circle_2D(p,5);
        nCirc.copy();
       if( nCirc.circleEqulse((Circle_2D) nCirc.copy()) == false){
           fail();
       };
    }

    @Test
    void scale() {
        Point_2D p = new Point_2D(1,2);
        Circle_2D Circ = new Circle_2D(p,5);
        Circ.scale(Point_2D.ORIGIN,0.5);
        Point_2D p2 = new Point_2D(0.5,1);
        Circle_2D nCirc = new Circle_2D(p2,2.5);
      if( nCirc.circleEqulse(Circ) == false){
          fail();
      };

    }

    @Test
    void rotate() {
        Point_2D circleCen = new Point_2D(2,3);
        Point_2D cen = new Point_2D(1,1);
        double d1 = circleCen.distance(cen);
        circleCen.rotate(cen, 180);
        double d2 = circleCen.distance(cen);
        assertTrue(d1 == d2);
    }
}