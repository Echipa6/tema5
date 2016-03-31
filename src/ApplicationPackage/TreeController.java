package ApplicationPackage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;
import javax.swing.tree.*;

import Action.AddFavAction;
import Action.PlayAction;

import javax.swing.event.*;

public class TreeController extends JFrame 
{
	public static final ImageIcon ICON_COMPUTER = new ImageIcon("pc.png");
	public static final ImageIcon ICON_DISK = new ImageIcon("Generic-Drive-icon.png");
	public static final ImageIcon ICON_FOLDER = new ImageIcon("folder.png");
	public static final ImageIcon ICON_EXPANDEDFOLDER = new ImageIcon("expendedFolder.png");
	public static final ImageIcon ICON_AUDIO = new ImageIcon("Music.png");

	protected JTree  myTree;
	protected DefaultTreeModel myTreeModel;
	protected JTextField myTextPath;
	//New
	protected JPopupMenu myPopupMenu;
	private TreePath myClickedPath;
	protected PlayAction myPlayAction;
	protected AddFavAction myAddFavAction;
	
	//  
	public TreeController()
	{
		super("Visual Audio Manager");
		setSize(400, 300);

		DefaultMutableTreeNode myComputerRoot = new DefaultMutableTreeNode(new IconData(ICON_COMPUTER, null, "MyComputer"));

		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k=0; k<roots.length; k++)
		{
			node = new DefaultMutableTreeNode(new IconData(ICON_DISK, null, new FileNode(roots[k])));
			myComputerRoot.add(node);
			node.add( new DefaultMutableTreeNode(new Boolean(true)));
		}

		myTreeModel = new DefaultTreeModel(myComputerRoot);
		myTree = new JTree(myTreeModel);


		TreeCellRenderer renderer = new IconCellRenderer();
		myTree.setCellRenderer(renderer);

		myTree.addTreeExpansionListener(new DirExpansionListener(this));

		myTree.addTreeSelectionListener(new DirSelectionListener(this));

		myTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
		myTree.setShowsRootHandles(false);
		myTree.setEditable(false);

		JScrollPane s = new JScrollPane();
		s.getViewport().add(myTree);
		getContentPane().add(s, BorderLayout.CENTER);

		myTextPath = new JTextField();
		myTextPath.setEditable(false);
		getContentPane().add(myTextPath, BorderLayout.NORTH);
		//new
		myPopupMenu = new JPopupMenu();


		myPlayAction= new PlayAction("Play",this);

		myPopupMenu.add(myPlayAction);
		
		myPopupMenu.addSeparator();
		
		myAddFavAction=new AddFavAction("Add to Fav",this);

		myPopupMenu.add(myAddFavAction);
		myTree.add(myPopupMenu);
		myTree.addMouseListener(new PopupTrigger(this));
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

	public DefaultMutableTreeNode getTreeNode(TreePath path)
	{
		return (DefaultMutableTreeNode)(path.getLastPathComponent());
	}

	public FileNode getFileNode(DefaultMutableTreeNode node)
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

	public TreePath getMyClickedPath() {
		return myClickedPath;
	}

	public void setMyClickedPath(TreePath myClickedPath) {
		this.myClickedPath = myClickedPath;
	}

}



