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
	        if (tree.m_clickedPath==null)
	          return;
	        if (tree.m_tree.isExpanded(tree.m_clickedPath))
	          tree.m_tree.collapsePath(tree.m_clickedPath);
	        else
	          tree.m_tree.expandPath(tree.m_clickedPath);
	      }
	    };
	    
	    return m_action;
	}
	
	public Action AddDeleteAction(){
		Action a1 = new AbstractAction("Delete") 
	    { 
	      public void actionPerformed(ActionEvent e)
	      {
	                                tree.m_tree.repaint();
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
		                                tree.m_tree.repaint();
		        JOptionPane.showMessageDialog(tree, 
		          "Rename option is not implemented",
		          "Info", JOptionPane.INFORMATION_MESSAGE);
		      }
		    };
		    
		    return a2;
	}
	
}
