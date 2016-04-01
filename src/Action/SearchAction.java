package Action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import Controller.IconData;
import UsefullClasses.FileNode;
import UsefullClasses.InfoCommand;
import UsefullClasses.PlayOnYoutube;

public class SearchAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	protected Controller myFileTree;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String path;
		path=myFileTree.getFileNode(myFileTree.getTreeNode(myFileTree.getMyClickedPath())).getFile().getPath();
		InfoCommand info= InfoCommand.getInstance();
		info.execute(path);
		PlayOnYoutube playOnYoutube=new PlayOnYoutube();
		playOnYoutube.Play(info.getArtist(), info.getTitle());
		
		

	}
	public SearchAction(String name, Controller currentTree)
	{
		super(name);
		myFileTree=currentTree;
	}

}