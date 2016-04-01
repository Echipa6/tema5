package ApplicationPackage;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import UsefullClasses.FileNode;
import UsefullClasses.InfoCommand;

class DirSelectionListener implements TreeSelectionListener 
{
	Controller tree;
	DirSelectionListener(Controller tree)
	{
		this.tree=tree;
	}
	public void valueChanged(TreeSelectionEvent event)
	{	

		DefaultMutableTreeNode node = tree.getTreeNode(event.getPath());
		FileNode fnode = tree.getFileNode(node);
		if (fnode != null)
		{
			tree.getMyTextPath().setText(fnode.getFile().getAbsolutePath());
			if(fnode.getFile().isDirectory())
			{
				MyTableAudio tableCreator=new MyTableAudio();
				tree.detailedInformation.setTable(tableCreator.getTableForDir(fnode.getFile().getAbsolutePath()));
				tree.detailedInformation.displayTable();
			}
			else
			{
				if(	fnode.getFile().isFile())
				{
					InfoCommand info= InfoCommand.getInstance();
							info.execute(fnode.getFile().getAbsolutePath());
							tree.detailedInformation.displayTextArea(info.toString());
				}
			}
		}
		else
			tree.getMyTextPath().setText("");


	}
}
