package ApplicationPackage;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class DirExpansionListener implements TreeExpansionListener
{
	TreeController tree;
	DirExpansionListener(TreeController tree)
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
                   tree.myTreeModel.reload(node);
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
