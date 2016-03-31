package ApplicationPackage;
import java.awt.BorderLayout;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeController extends JFrame
{
	public static final ImageIcon ICON_COMPUTER = new ImageIcon("pc.png");
	public static final ImageIcon ICON_DISK = new ImageIcon("Generic-Drive-icon.png");
	public static final ImageIcon ICON_FOLDER = new ImageIcon("folder.png");
	public static final ImageIcon ICON_EXPANDEDFOLDER = new ImageIcon("expendedFolder.png");
	public static final ImageIcon ICON_AUDIO = new ImageIcon("Music.png");

	protected CustomizedJTree  myTree;
	protected DefaultTreeModel myTreeModel;
	protected JTextField myTextPath;
	public DefaultMutableTreeNode fav;
	//New
	protected CustomizedJPopupMenu myPopupMenu;
	private TreePath myClickedPath;

	//  


	public TreeController()
	{
		//super("Visual Audio Manager");
		setSize(600, 400);

		myTreeModel = new DefaultTreeModel(createRootNode());
		myTree = new CustomizedJTree(myTreeModel,this);
		myPopupMenu = new CustomizedJPopupMenu(this);

		myTree.add(myPopupMenu);
		myTree.addMouseListener(new PopupTrigger(this));
		
		myTextPath = new JTextField();
		myTextPath.setEditable(false);
		getContentPane().add(myTextPath, BorderLayout.NORTH);


		JScrollPane scrollPanelTree = new JScrollPane();
		scrollPanelTree.getViewport().add(myTree);
		
		JTable table = new JTable();
		JScrollPane scrollPanelTable = new JScrollPane();
		scrollPanelTable.getViewport().add(table);
	    
	    
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(scrollPanelTree);
	    splitPane.setRightComponent(scrollPanelTable);
	    getContentPane().add(splitPane,BorderLayout.CENTER);
	    

		setVisible(true);
	}

	public DefaultMutableTreeNode createRootNode()
	{
		DefaultMutableTreeNode myComputerRoot = new DefaultMutableTreeNode(new IconData(ICON_COMPUTER, null, "MyComputer"));

		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k=0; k<roots.length; k++)
		{
			node = new DefaultMutableTreeNode(new IconData(ICON_DISK, null, new FileNode(roots[k])));
			myComputerRoot.add(node);
			node.add( new DefaultMutableTreeNode(new Boolean(true)));


		}

		fav=new DefaultMutableTreeNode(new IconData(ICON_FOLDER, ICON_EXPANDEDFOLDER, new FileNode(new File("Fav"))));
		//fav=deserealizeFav();

		myComputerRoot.add(fav);
		fav.add( new DefaultMutableTreeNode(new Boolean(true)));

		return myComputerRoot;

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

	public DefaultTreeModel getMyTreeModel() {
		return myTreeModel;
	}

	public void setMyTreeModel(DefaultTreeModel myTreeModel) {
		this.myTreeModel = myTreeModel;
	}
}



