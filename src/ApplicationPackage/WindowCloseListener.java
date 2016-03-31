package ApplicationPackage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseListener extends WindowAdapter{
	protected TreeController myFileTree;
	
	public void windowClosing(WindowEvent e) 
	{
		myFileTree.getSerealiser().serealizeFav();
		System.exit(0);
	}
	WindowCloseListener(TreeController myTreeController){
		
		myFileTree=myTreeController;
	}

}
