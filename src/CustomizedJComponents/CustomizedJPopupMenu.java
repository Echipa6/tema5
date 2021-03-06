package CustomizedJComponents;

import javax.swing.JPopupMenu;

import Action.AddFavAction;
import Action.DownloadAction;
import Action.PlayAction;
import Action.SearchAction;
import Controller.Controller;

public class CustomizedJPopupMenu extends JPopupMenu{

	private static final long serialVersionUID = 1L;
	PlayAction myPlayAction;
	AddFavAction myAddFavAction;
	SearchAction mySearchAction;
	DownloadAction myDownloadAction;
	public CustomizedJPopupMenu(Controller treeController)
	{
		super();
		myPlayAction = new PlayAction("Play",treeController);
		add(myPlayAction);
		addSeparator();
		myAddFavAction = new AddFavAction("Add to Fav",treeController);
		add(myAddFavAction);
		addSeparator();
		mySearchAction=new SearchAction("Search",treeController);
		add(mySearchAction);
		addSeparator();
		myDownloadAction=new DownloadAction("Download",treeController);
		add(myDownloadAction);
		
	}
}
