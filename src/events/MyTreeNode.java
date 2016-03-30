package events;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.Transient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;



public class MyTreeNode extends DefaultMutableTreeNode {

		private boolean loaded = false;

		private File file;
		public File getFile() {
			return file;
		}

		public MyTreeNode(File fileP) {
			file=fileP; 
			//add(new DefaultMutableTreeNode("Loading...", false));
			if(file.isDirectory()){
				setAllowsChildren(true);

			}else
			{
				setAllowsChildren(false);
			}
			if(Pattern.matches("[A-Z]:(.)*", file.toString())){
				setUserObject(file.toString());
			}else
			{
				setUserObject(file.getName().toString());
			}
		}

		public MyTreeNode() {
			// TODO Auto-generated constructor stub
		}

		
			
		

		@Override
		public boolean isLeaf() {
			return false;
		}

		public void loadChildren()
		{
			if (loaded) {
				return;
			}
			File folder=this.getFile();
			

			File[] listOfFiles = folder.listFiles();
			List<File> listOfFolders= new ArrayList<File>();
			List<File> listOfMusicFiles= new ArrayList<File>();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					if( Pattern.matches("(.)+\\.wav",listOfFiles[i].getName()) || Pattern.matches("(.)+\\.mp3", listOfFiles[i].getName()) || Pattern.matches("(.)+\\.flac",listOfFiles[i].getName()))
					{	
						listOfMusicFiles.add(listOfFiles[i]);
						//System.out.println("File " + listOfFiles[i].getName());
					}	
				} else if (listOfFiles[i].isDirectory()) {
					listOfFolders.add(listOfFiles[i]);
					//System.out.println("Directory " + listOfFiles[i].getName());
				}
			}

			for (int i = 0; i < listOfFolders.size(); i++) {
				this.add(new MyTreeNode(listOfFolders.get(i)));
			}
			for (int i = 0; i < listOfMusicFiles.size(); i++) {

				add(new DefaultMutableTreeNode(listOfMusicFiles.get(i)));

			}


			loaded = true;

		}

		protected DefaultMutableTreeNode inceptionTree(){
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(new File("MyPc"));
			File[] drives = File.listRoots(); // Get list of names
		    for (int i = 0; i < drives.length; i++)
		    {
		    	root.add(new MyTreeNode( drives[i]));
		    }
		    return root;
		}


		protected void initUI() {
			JFrame frame = new JFrame(MyTreeNode.class.getSimpleName());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			DefaultMutableTreeNode root=inceptionTree();
			final DefaultTreeModel model = new DefaultTreeModel(root);
			
			
			JTree tree = new JTree() {
				@Override
				@Transient
				public Dimension getPreferredSize() {
					Dimension preferredSize = super.getPreferredSize();
					preferredSize.width = Math.max(400, preferredSize.width);
					preferredSize.height = Math.max(400, preferredSize.height);
					return preferredSize;
				}
			};
			tree.setShowsRootHandles(true);
			tree.addTreeWillExpandListener(new TreeWillExpandListener() {

				@Override
				public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
					TreePath path = event.getPath();
					if (path.getLastPathComponent() instanceof MyTreeNode) {
						
						MyTreeNode node = (MyTreeNode) path.getLastPathComponent();
						System.out.println("You selected " + node);
						node.loadChildren();
						
						DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
			            model.reload(node);
					}
				}

				@Override
				public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {

				}
			});
			tree.setModel(model);
			//root.loadChildren();
			frame.add(new JScrollPane(tree));
			
			frame.pack();
			frame.setVisible(true);
		}

		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
		UnsupportedLookAndFeelException {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new MyTreeNode().initUI();
				}
			});
		}
	}



