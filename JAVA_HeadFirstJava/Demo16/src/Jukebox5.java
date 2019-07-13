import java.io.*;
import java.util.*;

public class Jukebox5 {
	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args) {
		new Jukebox5().go();
	}
	
	class ArtistCompare implements Comparator<Song>{
		public int compare(Song one,Song two) {
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void go() {
		getSong();
		//System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList,artistCompare);
		System.out.println(songList);
	}
	
	void getSong(){
		
		try {
			File file = new File("E:\\LUBO\\Java\\SongList2.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line=reader.readLine())!=null) {
				addSong(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
