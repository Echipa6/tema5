package Action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;
import ApplicationPackage.IconData;
import ApplicationPackage.FileNode;
import ApplicationPackage.TreeController;

public class AddFavAction extends AbstractAction{

	protected TreeController myFileTree;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DefaultMutableTreeNode fav= myFileTree.fav;
		String path;
		path=myFileTree.getFileNode(myFileTree.getTreeNode((myFileTree.getMyClickedPath()))).getFile().getPath();
		 
		IconData idata = new IconData(myFileTree.ICON_AUDIO,myFileTree.ICON_AUDIO, new FileNode(new File(path)));
    	  DefaultMutableTreeNode node = new  DefaultMutableTreeNode(idata);
    	  if(!myFileTree.getFileNode(myFileTree.getTreeNode((myFileTree.getMyClickedPath().getParentPath()))).getFile().toString().equals("Fav"))
    	  fav.add(node);
		
		myFileTree.getMyTreeModel().reload(fav);
		
	}
	public AddFavAction(String name, TreeController currentTree)
	{
		super(name);
		myFileTree=currentTree;
	}

}
