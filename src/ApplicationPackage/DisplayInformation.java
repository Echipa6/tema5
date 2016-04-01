package ApplicationPackage;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DisplayInformation extends JScrollPane{
	public JTable table;
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		
		this.table = table;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JTextArea textArea;
	public DisplayInformation()
	{
		textArea=new JTextArea();
		
	}
	public void displayTable()
	{
	
		getViewport().add(table);
		
		
	}
	public void displayTextArea(String info)
	{
		textArea.setText(info);
		getViewport().add(textArea);
	}

}
