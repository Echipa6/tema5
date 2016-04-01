package Listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controller.Controller;

public class WindowCloseListener extends WindowAdapter{
	protected Controller myFileTree;
	
	public void windowClosing(WindowEvent e) 
	{
		myFileTree.getSerealiser().serealizeFav();
		System.exit(0);
	}
	public WindowCloseListener(Controller myTreeController){
		
		myFileTree=myTreeController;
	}

}
