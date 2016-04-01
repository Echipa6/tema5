package Action;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;

import Controller.Controller;

public class PlayAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	protected Controller myFileTree;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String path;
		path=myFileTree.getFileNode(myFileTree.getTreeNode(myFileTree.getMyClickedPath())).getFile().getPath();
		this.execute(path);

	}
	public void execute(String path) {


		Desktop desktop = null;
		try {
			File playFile= new File(path);
			if(playFile.isFile() && Desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();
				desktop.open(playFile);

			}
		}catch(FileNotFoundException e)
		{
			System.err.println("Play FileNotFoundException "+e);


		}catch (IOException e) {
			System.err.println("Play FileNotFoundException "+e);

		}
	}

		public PlayAction(String name, Controller currentTree)
		{
			super(name);
			myFileTree=currentTree;
		}
	}
