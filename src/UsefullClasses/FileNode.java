package UsefullClasses;

import java.io.File;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import Controller.Controller;
import Controller.IconData;

public class FileNode
{
	protected File m_file;

	public boolean expand(DefaultMutableTreeNode parent)
	{
		DefaultMutableTreeNode Child = (DefaultMutableTreeNode)parent.getFirstChild();
		if (Child==null)    
			return false;
		Object obj = Child.getUserObject();
		if (!(obj instanceof Boolean))
			return false;      

		parent.removeAllChildren();  

		File[] files = listFiles();
		if (files == null)
			return true;

		Vector<FileNode> v = new Vector<FileNode>();

		for (int k=0; k<files.length; k++)
		{
			File f = files[k];

			FileNode newNode = new FileNode(f);
			boolean isAdded = false;
			for (int i=0; i<v.size(); i++)
			{
				FileNode nd = (FileNode)v.elementAt(i);
				if (newNode.compareTo(nd) < 0)
				{
					v.insertElementAt(newNode, i);
					isAdded = true;
					break;
				}
			}
			if (!isAdded)
				v.addElement(newNode);
		}

		for (int i=0; i<v.size(); i++)
		{
			FileNode nd = (FileNode)v.elementAt(i);
			if(nd.getFile().isDirectory())
			{
				IconData idata = new IconData(Controller.ICON_FOLDER, Controller.ICON_EXPANDEDFOLDER, nd);
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(idata);
				parent.add(node);

				if (nd.hasChildren())
					node.add(new DefaultMutableTreeNode(new Boolean(true) ));
			}
			else{
				if( Pattern.matches("(.)+\\.wav",nd.getFile().getName()) || Pattern.matches("(.)+\\.mp3",nd.getFile().getName()) || Pattern.matches("(.)+\\.flac",nd.getFile().getName()))
				{
					IconData idata = new IconData(Controller.ICON_AUDIO, Controller.ICON_AUDIO, nd);
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(idata);
					parent.add(node);
				}
			}
		}

		return true;
	}

	public boolean hasChildren()
	{
		File[] files = listFiles();
		if (files == null)
			return false;
		for (int k=0; k<files.length; k++)
		{
			if (files[k].isDirectory()||Pattern.matches("(.)+\\.wav",files[k].getName()) || Pattern.matches("(.)+\\.mp3",files[k].getName()) || Pattern.matches("(.)+\\.flac",files[k].getName()))
				return true;
		}
		return false;
	}

	public int compareTo(FileNode toCompare)
	{ 
		return  m_file.getName().compareToIgnoreCase(toCompare.m_file.getName() ); 
	}

	protected File[] listFiles()
	{
		if (!m_file.isDirectory())
			return null;
		try
		{
			return m_file.listFiles();
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error reading directory "+m_file.getAbsolutePath(),"Warning", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	public FileNode(File file)
	{
		m_file = file;
	}

	public File getFile() 
	{ 
		return m_file;
	}

	public String toString() 
	{ 
		return m_file.getName().length() > 0 ? m_file.getName() : 
			m_file.getPath();
	}
}
