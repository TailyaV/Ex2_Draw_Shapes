package ex2.gui;

import ex2.geo.Circle_2D;
import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    private Point_2D p = new Point_2D(1,1);
    private Circle_2D c = new Circle_2D(p,5);
    private GUIShape gui = new GUIShape(c, false, Color.red, 1);

    @Test
    void isFilled() {
        assertFalse(gui.isFilled());
    }

    @Test
    void setFilled() {
        gui.setFilled(true);
        assertTrue(gui.isFilled());
    }

    @Test
    void getColor() {
        assertSame(gui.getColor(), Color.red);
    }

    @Test
    void setColor() {
        gui.setColor(Color.BLUE);
        assertSame(gui.getColor(), Color.BLUE);
    }

    @Test
    void getTag() {
        assertTrue(gui.getTag() == 1);
    }

    @Test
    void setTag() {
        gui.setTag(3);
        assertTrue(gui.getTag() == 3);
    }

    @Test
    void copy() {
        GUIShape nG = (GUIShape) gui.copy();
       assertTrue(nG.assertEqualGeuShape(gui));
    }

    @Test
    void testToString() {
        String s = gui.toString();
        int c = gui.getColor().getRed() * 256 * 256 + gui.getColor().getGreen() * 256 + gui.getColor().getBlue();
        String ns = ""+this.gui.getClass().getSimpleName()+","+ c +","+gui.isFilled()+","+gui.getTag()+"," + this.c.getClass().getSimpleName() +","+ gui.getShape().toString();
        assertTrue(s.equals(ns));
    }

    @Test
    void isSelected() {
        boolean sel = gui.isSelected();
        assertSame(false, sel);
    }

    @Test
    void setSelected() {
        gui.setSelected(true);
        assertSame(true, gui.isSelected());
    }

    @Test
    void assertEqualGeuShape() {
        GUIShape nG = (GUIShape) gui.copy();
        assertTrue(nG.assertEqualGeuShape(gui));
    }

    @Test
    void assertEqualColor() {
        GUIShape gui2 = new GUIShape(c, true, Color.red, 1);
        assertTrue(gui2.assertEqualColor(this.gui));
    }
}