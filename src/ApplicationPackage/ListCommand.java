package ApplicationPackage;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



// TODO: Auto-generated Javadoc
/**
 * The Class ListCommand the command are meant to list all audio files from current dir.
 */
public class ListCommand  {
	
	/** The instance. */
	private static ListCommand instance= null;
	private String executionType="ok";
	private List<Song> foundAudioFiles;
	/**
	 * Gets the single instance of ListCommand.
	 *
	 * @return single instance of ListCommand
	 */
	public static ListCommand getInstance(){
		if(instance == null) {
	         instance = new ListCommand();
	      }
	      return instance;
	}

	
	
	public void execute(String parameters) {
		Path dir;
		
		dir=Paths.get(parameters);
	
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			
			for (Path file: stream) {
				if( Pattern.matches("(.)+\\.wav",file.getFileName().toString()) || Pattern.matches("(.)+\\.mp3", file.getFileName().toString()) || Pattern.matches("(.)+\\.flac",file.getFileName().toString()) ){	 
					InfoCommand.getInstance().execute(file.toString());
					if(InfoCommand.getInstance().getExecutionType().equals("ok")){
						foundAudioFiles.add(new Song(InfoCommand.getInstance()));
						executionType="ok";
					}
				}
			}
			
		   
		} catch (IOException | DirectoryIteratorException x) {
			executionType="Exception";
		    System.err.println("ListCommand IOException"+ x);
		}
	}
	
	/**
	 * Instantiates a new list command.
	 */
	private ListCommand()
	{
		foundAudioFiles=new ArrayList<Song>();
	}	
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
	public List<Song> getFoundAudioFiles() {
		return foundAudioFiles;
	}
	public void setFoundAudioFiles(List<Song> foundAudioFiles) {
		this.foundAudioFiles = foundAudioFiles;
	}
}
