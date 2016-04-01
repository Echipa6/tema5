package Action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import Controller.IconData;
import UsefullClasses.FileNode;

public class AddFavAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	protected Controller myFileTree;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean arleadyAdded=false;
		
		DefaultMutableTreeNode fav= myFileTree.fav;
		String path;
		path=myFileTree.getFileNode(myFileTree.getTreeNode((myFileTree.getMyClickedPath()))).getFile().getPath();
		for(int i=0;i<myFileTree.fav.getChildCount();i++)
		{
			if(new File(path).getName().equals((myFileTree.getFileNode(((DefaultMutableTreeNode)myFileTree.fav.getChildAt(i))).getFile().getName().toString())))
			{
				arleadyAdded=true;
			}
		}
		if(!arleadyAdded){
		

		IconData idata = new IconData(Controller.ICON_AUDIO,Controller.ICON_AUDIO, new FileNode(new File(path)));
		DefaultMutableTreeNode node = new  DefaultMutableTreeNode(idata);
		if(!myFileTree.getFileNode(myFileTree.getTreeNode((myFileTree.getMyClickedPath().getParentPath()))).getFile().toString().equals("Fav"))
			fav.add(node);
		}
		myFileTree.getMyTreeModel().reload(fav);

	}
	public AddFavAction(String name, Controller currentTree)
	{
		super(name);
		myFileTree=currentTree;
	}

}
