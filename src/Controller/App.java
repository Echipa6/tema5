package Controller;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import ApplicationPackage.TreeController;
import ApplicationPackage.WindowCloseListener;

public class App {

	public static void main(String[] args) {
		new TreeController();
		/*
		JFrame f = new JFrame("Tree Dragging Tester");
		TreeController tree1= new TreeController();
		TreeController tree2= new TreeController();
		
		Vector<String> rowOne = new Vector<String>();
	    rowOne.addElement("Row1-Column1");
	    rowOne.addElement("Row1-Column2");
	    rowOne.addElement("Row1-Column3");
	    
	    Vector<String> rowTwo = new Vector<String>();
	    rowTwo.addElement("Row2-Column1");
	    rowTwo.addElement("Row2-Column2");
	    rowTwo.addElement("Row2-Column3");
	    
	    Vector<Vector> rowData = new Vector<Vector>();
	    rowData.addElement(rowOne);
	    rowData.addElement(rowTwo);
	    
	    Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Column One");
	    columnNames.addElement("Column Two");
	    columnNames.addElement("Column Three");
	    JTable table = new JTable(rowData, columnNames);
		

		


	    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(tree1);
	    splitPane.setRightComponent(table);
	    f.getContentPane().add(splitPane, BorderLayout.CENTER);
	    f.setSize(300, 200);
	    f.setVisible(true);
	    
	    WindowCloseListener wndCloser = new WindowCloseListener();
		f.addWindowListener(wndCloser);*/

	}

}
