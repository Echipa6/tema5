package Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ApplicationPackage.TreeController;

public class AddFavAction extends AbstractAction{

	protected TreeController myFileTree;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public AddFavAction(String name, TreeController currentTree)
	{
		super(name);
		myFileTree=currentTree;
	}

}
