package ApplicationPackage;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Action;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

class PopupTrigger extends MouseAdapter
{
	TreeController tree;
	PopupTrigger(TreeController tree)
	{
		this.tree=tree;
	}
	public void mouseReleased(MouseEvent e)
	{
		if (e.isPopupTrigger()){

			int x = e.getX();
			int y = e.getY();
			TreePath path = tree.myTree.getPathForLocation(x, y);

			if (path != null && path.getPathCount()>1){

				if(!(tree.getFileNode(this.tree.getTreeNode(path)).getFile().isDirectory()))
					tree.myPopupMenu.show(tree.myTree, x, y);
				tree.setMyClickedPath(path);
			}
		}
	}
}