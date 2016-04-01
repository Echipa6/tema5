package CustomizedJComponents;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import Controller.Controller;
import Listener.DirExpansionListener;
import Listener.DirSelectionListener;
import View.IconCellRanderer;



public class CustomizedJTree extends JTree {
	
	private static final long serialVersionUID = 1L;

	public CustomizedJTree(DefaultTreeModel treeModel,Controller treeController)
	{
		super(treeModel);
		TreeCellRenderer renderer = new IconCellRanderer();
		setCellRenderer(renderer);

		addTreeExpansionListener(new DirExpansionListener(treeController));

		addTreeSelectionListener(new DirSelectionListener(treeController));

		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
		setShowsRootHandles(false);
		setEditable(false);
		
	}

}
