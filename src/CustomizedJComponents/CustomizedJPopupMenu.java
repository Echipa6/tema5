package CustomizedJComponents;

import javax.swing.JPopupMenu;

import Action.AddFavAction;
import Action.PlayAction;
import Controller.Controller;

public class CustomizedJPopupMenu extends JPopupMenu{

	private static final long serialVersionUID = 1L;
	PlayAction myPlayAction;
	AddFavAction myAddFavAction;
	
	public CustomizedJPopupMenu(Controller treeController)
	{
		super();
		myPlayAction = new PlayAction("Play",treeController);
		add(myPlayAction);
		addSeparator();
		myAddFavAction = new AddFavAction("Add to Fav",treeController);
		add(myAddFavAction);
		
	}
}
