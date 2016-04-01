package Controller;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import CustomizedJComponents.CustomizedJPopupMenu;
import CustomizedJComponents.CustomizedJTree;
import Listener.PopupTrigger;
import Listener.WindowCloseListener;
import UsefullClasses.FileNode;
import UsefullClasses.Serealizer;
import View.DisplayInformation;

public class Controller extends JFrame
{

	private static final long serialVersionUID = 1L;
	public static final ImageIcon ICON_COMPUTER = new ImageIcon("pc.png");
	public static final ImageIcon ICON_DISK = new ImageIcon("Generic-Drive-icon.png");
	public static final ImageIcon ICON_FOLDER = new ImageIcon("folder.png");
	public static final ImageIcon ICON_EXPANDEDFOLDER = new ImageIcon("expendedFolder.png");
	public static final ImageIcon ICON_AUDIO = new ImageIcon("Music.png");

	private CustomizedJTree  myTree;
	public DisplayInformation detailedInformation;
	protected DefaultTreeModel myTreeModel;
	private JTextField myTextPath;
	public DefaultMutableTreeNode fav;
	
	private CustomizedJPopupMenu myPopupMenu;
	private TreePath myClickedPath;
	private Serealizer serealiser=new Serealizer(this);
	private JScrollPane scrollPanelTable;



	public Serealizer getSerealiser() {
		return serealiser;
	}

	public Controller()
	{
		super("Visual Audio Manager");
		setSize(600, 400);
		setScrollPanelTable(new JScrollPane());
		myTreeModel = new DefaultTreeModel(createRootNode());
		setMyTree(new CustomizedJTree(myTreeModel,this));
		setMyPopupMenu(new CustomizedJPopupMenu(this));

		getMyTree().add(getMyPopupMenu());
		getMyTree().addMouseListener(new PopupTrigger(this));
		
		setMyTextPath(new JTextField());
		getMyTextPath().setEditable(false);
		getContentPane().add(getMyTextPath(), BorderLayout.NORTH);

		JScrollPane scrollPanelTree = new JScrollPane();
		scrollPanelTree.getViewport().add(getMyTree());
		
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(scrollPanelTree);
	    detailedInformation= new DisplayInformation();
	    splitPane.setRightComponent(detailedInformation);
	    getContentPane().add(splitPane,BorderLayout.CENTER);
	    

		WindowCloseListener wndCloser = new WindowCloseListener(this);
		addWindowListener(wndCloser);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}

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
		fav=serealiser.deserealizeFav();
		myComputerRoot.add(fav);

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

	public JScrollPane getScrollPanelTable() {
		return scrollPanelTable;
	}

	public void setScrollPanelTable(JScrollPane scrollPanelTable) {
		this.scrollPanelTable = scrollPanelTable;
	}

	public JTextField getMyTextPath() {
		return myTextPath;
	}

	public void setMyTextPath(JTextField myTextPath) {
		this.myTextPath = myTextPath;
	}

	public CustomizedJTree getMyTree() {
		return myTree;
	}

	public void setMyTree(CustomizedJTree myTree) {
		this.myTree = myTree;
	}

	public CustomizedJPopupMenu getMyPopupMenu() {
		return myPopupMenu;
	}

	public void setMyPopupMenu(CustomizedJPopupMenu myPopupMenu) {
		this.myPopupMenu = myPopupMenu;
	}
}



