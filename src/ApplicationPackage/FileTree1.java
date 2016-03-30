package ApplicationPackage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class FileTree1 
  extends JFrame 
{
  public static final ImageIcon ICON_COMPUTER = 
    new ImageIcon("C:\\Users\\L\\Desktop\\icons\\pc.png");
  public static final ImageIcon ICON_DISK = 
    new ImageIcon("C:\\Users\\L\\Desktop\\icons\\Generic-Drive-icon.png");
  public static final ImageIcon ICON_FOLDER = 
    new ImageIcon("C:\\Users\\L\\Desktop\\icons\\folder.png");
  public static final ImageIcon ICON_EXPANDEDFOLDER = 
    new ImageIcon("C:\\Users\\L\\Desktop\\icons\\expendedFolder.png");
  public static final ImageIcon ICON_AUDIO = 
		  new ImageIcon("C:\\Users\\L\\Desktop\\icons\\Music.png");

  protected JTree  m_tree;
  protected DefaultTreeModel m_model;
  protected JTextField m_display;
//New
  protected JPopupMenu m_popup;
  protected Action m_action;
  protected TreePath m_clickedPath;
//  
  public FileTree1()
  {
    super("Directories Tree");
    setSize(400, 300);

    DefaultMutableTreeNode top = new DefaultMutableTreeNode(
      new IconData(ICON_COMPUTER, null, "MyComputer"));

    DefaultMutableTreeNode node;
    File[] roots = File.listRoots();
    for (int k=0; k<roots.length; k++)
    {
      node = new DefaultMutableTreeNode(new IconData(ICON_DISK, 
        null, new FileNode(roots[k])));
      top.add(node);
                        node.add( new DefaultMutableTreeNode(new Boolean(true)));
    }

    m_model = new DefaultTreeModel(top);
    m_tree = new JTree(m_model);

                m_tree.putClientProperty("JTree.lineStyle", "Angled");

    TreeCellRenderer renderer = new IconCellRenderer();
    m_tree.setCellRenderer(renderer);

    m_tree.addTreeExpansionListener(new  DirExpansionListener(this));

    m_tree.addTreeSelectionListener(new  DirSelectionListener(this));

    m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
    m_tree.setShowsRootHandles(true); 
    m_tree.setEditable(false);

    JScrollPane s = new JScrollPane();
    s.getViewport().add(m_tree);
    getContentPane().add(s, BorderLayout.CENTER);

    m_display = new JTextField();
    m_display.setEditable(false);
    getContentPane().add(m_display, BorderLayout.NORTH);
    //new
    m_popup = new JPopupMenu();
    m_action = new AbstractAction() 
    { 
      public void actionPerformed(ActionEvent e)
      {
        if (m_clickedPath==null)
          return;
        if (m_tree.isExpanded(m_clickedPath))
          m_tree.collapsePath(m_clickedPath);
        else
          m_tree.expandPath(m_clickedPath);
      }
    };
    m_popup.add(m_action);
    m_popup.addSeparator();

    Action a1 = new AbstractAction("Play") 
    { 
      public void actionPerformed(ActionEvent e)
      {
    	  
          m_tree.repaint();
        
       String path=m_clickedPath.getPathComponent(1).toString();
       System.out.println(m_clickedPath);
       for(int i=2; i<m_clickedPath.getPathCount()-1;i++)
       {
    	   path=path+m_clickedPath.getPathComponent(i)+"\\";
       }
       path=path+m_clickedPath.getLastPathComponent();
      
      
       (new Play()).execute(path);
      }
    };
    m_popup.add(a1);

    Action a2 = new AbstractAction("Rename") 
    { 
      public void actionPerformed(ActionEvent e)
      {
                                m_tree.repaint();
        JOptionPane.showMessageDialog(FileTree1.this, 
          "Rename option is not implemented",
          "Info", JOptionPane.INFORMATION_MESSAGE);
      }
    };
    m_popup.add(a2);
    m_tree.add(m_popup);
    m_tree.addMouseListener(new PopupTrigger(this));
    //
    WindowListener wndCloser = new WindowAdapter()
    {
      public void windowClosing(WindowEvent e) 
      {
        System.exit(0);
      }
    };
    addWindowListener(wndCloser);
    
    setVisible(true);
  }

  DefaultMutableTreeNode getTreeNode(TreePath path)
  {
    return (DefaultMutableTreeNode)(path.getLastPathComponent());
  }

  FileNode getFileNode(DefaultMutableTreeNode node)
  {
    if (node == null)
      return null;
    Object obj = node.getUserObject();
    if (obj instanceof IconData)
      obj = ((IconData)obj).getObject();
    if (obj instanceof FileNode)
      return (FileNode)obj;
    else
      return null;
  }




  public static void main(String argv[]) 
  {
    new FileTree1();
  }
}



