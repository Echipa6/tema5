package ApplicationPackage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Serealizer {

	protected TreeController myFileTree;
	private static final String FILENAME = "favoriteSongs.xml";
	public void serealizeFav(){
		
		List<String> musicFiles=new ArrayList<String>();
		for(int i=0;i<myFileTree.fav.getChildCount();i++)
		{
			musicFiles.add(myFileTree.getFileNode(((DefaultMutableTreeNode)myFileTree.fav.getChildAt(i))).getFile().toString());
		}
		try{

			XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(FILENAME)));
			encoder.writeObject(musicFiles);
			encoder.close();
			
		}catch(FileNotFoundException ex)
		{
			System.out.println("eceptie la serializare");
		}
	}
	
	public DefaultMutableTreeNode deserealizeFav()
	{
		DefaultMutableTreeNode fav;
		fav=new DefaultMutableTreeNode(new IconData(myFileTree.ICON_FOLDER, myFileTree.ICON_EXPANDEDFOLDER, new FileNode(new File("Fav"))));
		
		List<String> musicFiles=new ArrayList<String>();
		try{
			XMLDecoder decoder =new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));
			
				musicFiles= (List<String>) decoder.readObject();
				decoder.close();
		}catch(FileNotFoundException e)
		
		{
			System.out.println("Exception");
		}
		
		for(int i=0;i<musicFiles.size();i++)
		{
			IconData idata = new IconData(TreeController.ICON_AUDIO, 
  				  TreeController.ICON_AUDIO, new FileNode(new File(musicFiles.get(i))));
      	  DefaultMutableTreeNode node = new 
      			  DefaultMutableTreeNode(idata);
      	  fav.add(node);
		}
		
		return fav;
	}
	
	public Serealizer(TreeController myFileTree )
	{
		this.myFileTree=myFileTree;
	}
}
