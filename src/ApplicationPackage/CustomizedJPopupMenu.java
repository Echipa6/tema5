package ApplicationPackage;

import javax.swing.JPopupMenu;

import Action.AddFavAction;
import Action.PlayAction;

public class CustomizedJPopupMenu extends JPopupMenu{

	PlayAction myPlayAction;
	AddFavAction myAddFavAction;
	
	public CustomizedJPopupMenu(TreeController treeController)
	{
		super();
		myPlayAction = new PlayAction("Play",treeController);
		add(myPlayAction);
		addSeparator();
		myAddFavAction = new AddFavAction("Add to Fav",treeController);
		add(myAddFavAction);
		
	}
}
