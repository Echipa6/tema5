package ApplicationPackage;

import java.io.File;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class DirSelectionListener implements TreeSelectionListener 
{
	TreeController tree;
	DirSelectionListener(TreeController tree)
	{
		this.tree=tree;
	}
	public void valueChanged(TreeSelectionEvent event)
	{	

		DefaultMutableTreeNode node = tree.getTreeNode(event.getPath());
		FileNode fnode = tree.getFileNode(node);
		if (fnode != null)
		{	tree.myTextPath.setText(fnode.getFile().getAbsolutePath());
			if((new File(fnode.getFile().getAbsolutePath()).isDirectory()))
			{
				MyTableAudio tableCreator=new MyTableAudio();
				tree.setTable(tableCreator.getTableForDir(fnode.getFile().getAbsolutePath()));
			}
		}
		else
			tree.myTextPath.setText("");
	}
}
