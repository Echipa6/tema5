package ApplicationPackage;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class CustomizedJTree extends JTree {
	
	public CustomizedJTree(DefaultTreeModel treeModel,TreeController treeController)
	{
		super(treeModel);
		TreeCellRenderer renderer = new IconCellRenderer();
		setCellRenderer(renderer);

		addTreeExpansionListener(new DirExpansionListener(treeController));

		addTreeSelectionListener(new DirSelectionListener(treeController));

		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
		setShowsRootHandles(false);
		setEditable(false);
		
	}

}
