package ApplicationPackage;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DisplayInformation extends JScrollPane{
	JTable table;
	JTextArea textArea;
	public DisplayInformation()
	{
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
	    table = new JTable(rowData, columnNames);
		
		textArea= new JTextArea("ana are multe mere");
		//JScrollPane scrollPanelTable = new JScrollPane();
		getViewport().add(table);
		getViewport().add(textArea);
	}
	public void displayTable()
	{
		getViewport().add(table);
	}
	public void displayTextArea()
	{
		getViewport().add(textArea);
	}

}
