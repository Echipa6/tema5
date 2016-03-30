package ApplicationPackage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;


public class Play{
	
	
	
	public void execute(String path) {
		
		
		Desktop desktop = null;
		try {
			File playFile= new File(path);
			if(playFile.isFile() && Desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();
				desktop.open(playFile);
				
			}
		}catch(FileNotFoundException e)
		{
			System.err.println("Play FileNotFoundException "+e);
			
			
		}catch (IOException e) {
			System.err.println("Play FileNotFoundException "+e);
			
		}

	}
	
	
	public Play()
	{
	}	
	
}
