package Listener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import UsefullClasses.FileNode;
import UsefullClasses.MyTableAudio;

public class DirSelectionListener implements TreeSelectionListener 
{
	Controller tree;
	public DirSelectionListener(Controller tree)
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
				Thread runner = new Thread() 
				{
					public void run() 
					{
						MyTableAudio tableCreator=new MyTableAudio();
						tree.detailedInformation.setTable(tableCreator.getTableForDir(fnode.getFile().getAbsolutePath()));
						tree.detailedInformation.displayTable();
					}
				};
				runner.start();
			}
			else
			{
				tree.detailedInformation.displayTextArea();
			}
		}
		else
			tree.getMyTextPath().setText("");


	}
}
