package ex2.ex2;

import ex2.geo.*;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {

    private ShapeCollection s = new ShapeCollection();
    private  Point_2D p1 = new Point_2D(1,2);
    private Circle_2D c = new Circle_2D(p1, 5);
    private Circle_2D c2 = new Circle_2D(p1, 3);
    private  GUI_Shape a = new GUIShape(c, true, Color.red,2);
    private  GUI_Shape b = new GUIShape(c2, false, Color.red,3);
    private  GUI_Shape cSh = new GUIShape(c, false, Color.red,4);

    @Test
    void get() {
       s.add(a);
       s.add(b);
       assertTrue(c.circleEqulse((Circle_2D) s.get(0).getShape()));

    }

    @Test
    void size() {
        Point_2D p1 = new Point_2D(1,2);
        Circle_2D c = new Circle_2D(p1, 5);
        GUI_Shape a = new GUIShape(c, true, Color.red,2);
      //  GUI_Shape b = new GUIShape(c, true, Color.red,2);
        s.add(a);
      //  s.add(b);
        if(s.size()!= 1){
            fail();
        }
    }

    @Test
    void removeElementAt() {
        s.add(a);
        s.add(b);
        s.removeElementAt(0);
        if(s.size() != 1){
            fail();
        }
    }

    @Test
    void addAt() {
        s.add(a);
        s.add(b);
        s.addAt(a,1);
        assertTrue(s.get(1).equals(a));
    }

    @Test
    void add() {
        s.add(a);
        assertTrue(c.circleEqulse((Circle_2D) s.get(0).getShape()));
    }

    @Test
    void copy() {
        s.add(a);
        s.add(b);
        Point_2D p2 = new Point_2D(0,0);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUI_Shape segm = new GUIShape(seg, true, Color.blue,4);
        s.add(segm);
        GUI_Shape_Collection newS = s.copy();
        for(int i = 0; i<s.size(); i = i + 1){
            assertTrue(s.get(i).getShape().equals(newS.get(i).getShape()));
        }
    }

    @Test
    void sort() {
        s.add(a);
        s.add(b);
        Point_2D p2 = new Point_2D(0,0);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUI_Shape segm = new GUIShape(seg, true, Color.blue,4);
        s.add(segm);
        s.sort(ShapeComp.CompByArea);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(0).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(2).getShape()));
        s.sort(ShapeComp.CompByAntiArea);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(2).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(0).getShape()));
        s.sort(ShapeComp.CompByTag);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(2).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(0).getShape()));
        s.sort(ShapeComp.CompByAntiTag);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(0).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(2).getShape()));
        s.sort(ShapeComp.CompByToString);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(2).getShape()) && c2.circleEqulse((Circle_2D) s.get(0).getShape()) && c.circleEqulse((Circle_2D) s.get(1).getShape()));
        s.sort(ShapeComp.CompByAntiToString);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(0).getShape()) && c2.circleEqulse((Circle_2D) s.get(2).getShape()) && c.circleEqulse((Circle_2D) s.get(1).getShape()));
        s.sort(ShapeComp.CompByPerimeter);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(0).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(2).getShape()));
        s.sort(ShapeComp.CompByAntiPerimeter);
        assertTrue(seg.segIsEqual((Segment_2D) s.get(2).getShape()) && c2.circleEqulse((Circle_2D) s.get(1).getShape()) && c.circleEqulse((Circle_2D) s.get(0).getShape()));

    }

    @Test
    void removeAll() {
        ShapeCollection s = new ShapeCollection();
        Point_2D p1 = new Point_2D(1,2);
        Circle_2D c = new Circle_2D(p1, 5);
        GUI_Shape a = new GUIShape(c, true, Color.red,2);
        GUI_Shape b = new GUIShape(c, true, Color.red,2);
        s.add(a);
        s.add(b);
        s.removeAll();
        if(s.size() != 0){
            fail();
        }
    }

    @Test
    void loadAndSave() {
        File f = new File("st_file");
        String st = f.getName();
        this.s.add(a);
        this.s.add(b);
        s.save(st);
//        s.add(cSh);
        ShapeCollection s2 = new ShapeCollection();
        s2.load(st);
        assertTrue(s2.assertEqualShapeCol(s));

    }

    @Test
    void testToString() {
        s.add(a);
        s.add(b);
        String st= s.toString();
        String st1 = a.toString()+ ", " +b.toString();
        assertEquals(st, st1);
    }
}