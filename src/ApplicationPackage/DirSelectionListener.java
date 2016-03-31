package ApplicationPackage;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class DirSelectionListener 
implements TreeSelectionListener 
{
	FileTree1 tree;
	DirSelectionListener(FileTree1 tree)
	{
		this.tree=tree;
	}
public void valueChanged(TreeSelectionEvent event)
{	
	
  DefaultMutableTreeNode node = tree.getTreeNode(
    event.getPath());
  FileNode fnode = tree.getFileNode(node);
  if (fnode != null)
    tree.myTextPath.setText(fnode.getFile().
      getAbsolutePath());
  else
    tree.myTextPath.setText("");
}
}
