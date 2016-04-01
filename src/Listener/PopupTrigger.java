package Listener;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.TreePath;

import Controller.Controller;

public class PopupTrigger extends MouseAdapter
{
	Controller tree;
	 public PopupTrigger(Controller tree)
	{
		this.tree=tree;
	}
	public void mouseReleased(MouseEvent e)
	{
		if (e.isPopupTrigger()){

			int x = e.getX();
			int y = e.getY();
			TreePath path = tree.getMyTree().getPathForLocation(x, y);

			if (path != null && path.getPathCount()>1){

				if(!(tree.getFileNode(this.tree.getTreeNode(path)).getFile().isDirectory()))
					tree.getMyPopupMenu().show(tree.getMyTree(), x, y);
				tree.setMyClickedPath(path);
			}
		}
	}
}