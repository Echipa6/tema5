package ApplicationPackage;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class myTableAudio {
  
	private JTable table;
	
	
	public static JTable getTableForDir(String path) {
		
		 Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		
		 List<Song> listOfSongs=new ArrayList<Song>();
		 ListCommand listCom=ListCommand.getInstance();
		 listCom.execute(path);
		 listOfSongs=listCom.getFoundAudioFiles();
		
		 for(int i=0; i<listOfSongs.size();i++)
		 {
			 Vector<String> newRow = new Vector<String>();
			 newRow.addElement((new File(listOfSongs.get(i).getPath())).getName());
			 newRow.addElement(listOfSongs.get(i).getTitle());
			 newRow.addElement(listOfSongs.get(i).getArtist());
			 rowData.addElement(newRow);
			 
		 }
		 Vector<String> columnNames = new Vector<String>();
		    columnNames.addElement("File Name");
		    columnNames.addElement("Songname");
		    columnNames.addElement("Artist");
		   
		    JTable table = new JTable(rowData, columnNames);
		 
		 return table;
	}
	
	


	public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   
    JTable table = getTableForDir("E:\\muzica\\Alternative");

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);

  }
}