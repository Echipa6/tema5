package UsefullClasses;


import java.io.IOException;


public class PlayOnYoutube {
	public void Play(String artist, String title)
	{
	try {
		imagineDownload2 play=new	imagineDownload2(artist,title);
		play.openWebpage(play.getUrl());
	} catch (IOException e) {
		System.out.println("Conexiunea la ineternet este foarte slaba!");
		//e.printStackTrace();
	}
		
	}
	
	
	
}
