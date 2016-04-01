package UsefullClasses;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




public class PlayOnYoutube {
	public void Play(String artist, String title)
	{
		try {
	      URI uri = new URI("http://www.youtube.com/results?search_query="+artist+"+"+title);
	      Desktop desktop = null;
	      if (Desktop.isDesktopSupported()) {
	        desktop = Desktop.getDesktop();
	      }

	      if (desktop != null)
	        desktop.browse(uri);
	    } catch (IOException ioe) {
	      ioe.printStackTrace();
	    } catch (URISyntaxException use) {
	      use.printStackTrace();
	    }
//		Desktop desc=Desktop.getDesktop();
//		try {
//			desc.open(new File("http://www.youtube.com/result?search_query="+artist+"+"+title));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
}
