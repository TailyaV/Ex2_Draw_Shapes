package ex2.gui;

import ex2.ex2.Ex2_Const;
import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
 private GUI_Shape_Collection g;
 private Point_2D p = new Point_2D(1,1);
 private Circle_2D c = new Circle_2D(p,5);
 private GUIShape gui = new GUIShape(c, true, Color.red, 1);
 private GUIShape gui1 = new GUIShape(c, false, Color.green, 2);

    @Test
    void init() {
     Ex2 ex2 = Ex2.getInstance();
     g = ex2.getShape_Collection();
     this.g.add(this.gui);
     ex2.init(g);
     assertTrue(ex2.getShape_Collection().equals(g));
     assertNotNull(ex2.getShape_Collection());

    }

    @Test
    void show() {
     Ex2 ex2 = Ex2.getInstance();
     g = ex2.getShape_Collection();
     g.add(gui);
     ex2.init(g);
     g.get(0).getShape().rotate(Point_2D.ORIGIN, 60);
     g.get(0).getShape().copy();
     g.add(gui1);
     double a = 4;
     String s = ex2.getInfo();
     assertNotNull(ex2.getInfo());
     ex2.show(a);
    }

    @Test
    void getInfo() {
     Ex2 ex2 = Ex2.getInstance();
     g = ex2.getShape_Collection();
     this.g.add(this.gui);
     this.g.add(this.gui1);
     gui.isSelected();
     String s = ex2.getInfo();
     String s1 = gui.toString() +"\n"+ gui1.toString() + "\n";
     System.out.println(s +"\n"+s1);
     assertNotNull(ex2.getInfo());
     assertTrue(s.equals(s1));

    }
}