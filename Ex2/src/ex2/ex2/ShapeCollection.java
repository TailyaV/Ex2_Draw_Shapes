package ex2.ex2;

import ex2.geo.GeoShape;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 *Docomentation @Talia.Vallerstein
 *assertEqualShapeCol- Check equality between two Shapes Collections.
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		//////////add your code below ///////////
		GUI_Shape removeEl = _shapes.get(i);
		_shapes.remove(i);
		return removeEl;
		//////////////////////////////////////////
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		//////////add your code below ///////////
		_shapes.add(i, s);
		//////////////////////////////////////////
	}
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public GUI_Shape_Collection copy() {
		//////////add your code below ///////////
		GUI_Shape_Collection t = new ShapeCollection();
		for(int i = 0; i < _shapes.size(); i = i +1){
			t.add(_shapes.get(i));
		}
		return t;
		//////////////////////////////////////////
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		//////////add your code below ///////////
		if(_shapes.size() != 0){
		for (int  i=1 ; i < _shapes.size() ; i++) {
			for (int  j=i ; j > 0 ; j--) {
				if (comp.compare(_shapes.get(j - 1), _shapes.get(j)) > 0) {
					GUI_Shape temp = _shapes.get(j);
					this._shapes.set(j, _shapes.get(j - 1));
					this._shapes.set((j - 1), temp);
				}
			}
		}
		}

		
		//////////////////////////////////////////
	}

	@Override
	public void removeAll() {
		//////////add your code below ///////////
		_shapes.removeAll(_shapes);
		//////////////////////////////////////////
	}

	@Override
	public void save(String file) {
		//////////add your code below ///////////
		try {
			FileWriter myWriter = new FileWriter(file);
			for(int i = 0; i < _shapes.size(); i = i + 1) {
				myWriter.write(_shapes.get(i).toString() + "\n");
			}
			myWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//////////////////////////////////////////
	}

	@Override
	public void load(String file) {
		////////// add your code below ///////////
		_shapes.clear();
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				GUIShape g = new GUIShape(data);
				_shapes.add(g);
			}
			myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		//////////////////////////////////////////
	}

	@Override
	public String toString() {
		String ans = "";
		int i=0;
		for(;i<size() - 1;i=i+1) {
			ans += this.get(i) + ", ";
		}
		ans += this.get(i);
		return ans;
	}

	public boolean assertEqualShapeCol (ShapeCollection s){
		if(s.size() != this._shapes.size()){
			return false;
		}
		for(int i = 0; i < s.size(); i = i + 1) {
			GUIShape a = (GUIShape) s.get(i);
			GUIShape b = (GUIShape) this._shapes.get(i);
			if (a.assertEqualGeuShape(b)){
				return true;
			}
		}
		return false;
	}
	

}
