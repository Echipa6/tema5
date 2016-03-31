package ApplicationPackage;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Action;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

class PopupTrigger extends MouseAdapter
{
	FileTree1 tree;
	PopupTrigger(FileTree1 tree)
	{
		this.tree=tree;
	}
  public void mouseReleased(MouseEvent e)
  {
    if (e.isPopupTrigger())
    {
      int x = e.getX();
      int y = e.getY();
      TreePath path = tree.m_tree.getPathForLocation(x, y);
      
     
      if (path != null)
      {
    	  String absolutePath=path.getPathComponent(1).toString();
          //System.out.println("Right click on:"+path);
          for(int i=2; i<path.getPathCount()-1;i++)
          {
       	   absolutePath=absolutePath+path.getPathComponent(i)+"\\";
          }
          if(path.getPathCount()-1>1)absolutePath=absolutePath+path.getLastPathComponent();
    	  
      /*  if (tree.m_tree.isExpanded(path))
          tree.m_action.putValue(Action.NAME, "Collapse");
        else
          tree.m_action.putValue(Action.NAME, "Expand");
        */
         if(!(new File(absolutePath)).isDirectory())
         {
        	 tree.m_popup.show(tree.m_tree, x, y);
        	 System.out.println("Right click on tralala:"+absolutePath);
         }
        tree.m_clickedPath = path;
      }
    }
  }
}