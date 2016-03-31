package ApplicationPackage;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class PopupAcctions {
	
	
	
	

	FileTree1 tree;
	
	PopupAcctions(FileTree1 tree)
	{
		this.tree=tree;
		
	    
	    

	   
	}
	public Action AddExtendAction()
	{
		Action m_action; 
		m_action = new AbstractAction() 
	    { 
	      public void actionPerformed(ActionEvent e)
	      {
	        if (tree.myClickedPath==null)
	          return;
	        if (tree.myTree.isExpanded(tree.myClickedPath))
	          tree.myTree.collapsePath(tree.myClickedPath);
	        else
	          tree.myTree.expandPath(tree.myClickedPath);
	      }
	    };
	    
	    return m_action;
	}
	
	public Action AddDeleteAction(){
		Action a1 = new AbstractAction("Delete") 
	    { 
	      public void actionPerformed(ActionEvent e)
	      {
	                                tree.myTree.repaint();
	        JOptionPane.showMessageDialog(tree, 
	          "Delete option is not implemented",
	          "Info", JOptionPane.INFORMATION_MESSAGE);
	      }
	    };
	   
	    return a1;
	}
	
	public Action AddRenameAction()
	{
		 Action a2 = new AbstractAction("Rename") 
		    { 
		      public void actionPerformed(ActionEvent e)
		      {
		                                tree.myTree.repaint();
		        JOptionPane.showMessageDialog(tree, 
		          "Rename option is not implemented",
		          "Info", JOptionPane.INFORMATION_MESSAGE);
		      }
		    };
		    
		    return a2;
	}
	
}
