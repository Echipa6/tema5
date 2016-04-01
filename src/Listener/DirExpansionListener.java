package Listener;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import UsefullClasses.FileNode;

public class DirExpansionListener implements TreeExpansionListener
{
	Controller tree;
	public DirExpansionListener(Controller tree)
	{
		this.tree=tree;
	}
    public void treeExpanded(TreeExpansionEvent event)
    {	
        final DefaultMutableTreeNode node = tree.getTreeNode(
            event.getPath());
        final FileNode fnode = tree.getFileNode(node);

        Thread runner = new Thread() 
        {
          public void run() 
          {
            if (fnode != null && fnode.expand(node)) 
            {
              Runnable runnable = new Runnable() 
              {
                public void run() 
                {
                   tree.getMyTreeModel().reload(node);
                }
              };
              SwingUtilities.invokeLater(runnable);
            }
          }
        };
        runner.start();
    }

    public void treeCollapsed(TreeExpansionEvent event) {}
}
