package UsefullClasses;

import UsefullClasses.InfoCommand;


/**
 * The Class Song.
 */
public class Song  {
	

	private String fileName;
	
	/** The path. */
	private String path;
	
	/** The title. */
	private String title;
	
	/** The artist. */
	private String artist;
	
	/** The composer. */
	private String composer;
	
	/** The genre. */
	private String genre;
	
	/** The album. */
	private String album;
	
	/**
	 * Instantiates a new song.
	 */
	public Song()
	{
		setPath(null);
		setTitle(null);
		setArtist(null);
		setComposer(null);
		setGenre(null);
		setAlbum(null);
	}
	
	/**
	 * Instantiates a new song.
	 *
	 * @param infoSong the info song
	 */
	Song(InfoCommand infoSong)
	{
		this.setPath(infoSong.getPath());
		this.setTitle(infoSong.getTitle());
		this.setArtist(infoSong.getArtist());
		this.setComposer(infoSong.getComposer());
		this.setGenre(infoSong.getGenre());
		this.setAlbum(infoSong.getAlbum());
	}
	
	/**
	 * Afisare. dysplay methadata about the song
	 */
	public void afisare()
	{
		System.out.println("Afisare din song");
		System.out.println(this.path);
		System.out.println(this.title);
		System.out.println(this.artist);
		System.out.println(this.album);
		System.out.println(this.composer);
		System.out.println(this.genre);

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	  public String toString() {
	    return String.format("[Song: path='%s', \n\t title=%s,\n\t artist=%s,\n\t album=%s, \n\t composer=%s, \n\t genre=%s]\n\n", path, title, artist,album,composer,genre);
	  }

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Gets the composer.
	 *
	 * @return the composer
	 */
	public String getComposer() {
		return composer;
	}

	/**
	 * Sets the composer.
	 *
	 * @param composer the new composer
	 */
	public void setComposer(String composer) {
		this.composer = composer;
	}

	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre.
	 *
	 * @param genre the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the album.
	 *
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * Sets the album.
	 *
	 * @param album the new album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
