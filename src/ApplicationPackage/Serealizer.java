package ApplicationPackage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
			System.out.println(myFileTree.fav.getChildAt(i).toString());
		}
//		try{
//
//			XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(FILENAME)));
//			encoder.writeObject(fav);
//			encoder.close();
//			
//		}catch(FileNotFoundException ex)
//		{
//			System.out.println("eceptie la serializare");
//		}
	}
	
//	public  deserealizeFav()
//	{
//		try{
//			XMLDecoder decoder =new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));
//			
//				fav = (DefaultMutableTreeNode) decoder.readObject();
//				decoder.close();
//		}catch(FileNotFoundException e)
//		
//		{
//			System.out.println("Exception");
//		}
		
		
	//}
	
	public Serealizer(TreeController myFileTree )
	{
		this.myFileTree=myFileTree;
	}
}
