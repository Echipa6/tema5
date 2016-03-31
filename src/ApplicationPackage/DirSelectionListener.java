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
		{
			tree.myTextPath.setText(fnode.getFile().getAbsolutePath());
			if(fnode.getFile().isDirectory())
			{
				MyTableAudio tableCreator=new MyTableAudio();
				tree.detailedInformation.setTable(tableCreator.getTableForDir(fnode.getFile().getAbsolutePath()));
				tree.detailedInformation.displayTable();
			}
			else
			{
				tree.detailedInformation.displayTextArea();
			}
		}
		else
			tree.myTextPath.setText("");
		
		
	}
}
