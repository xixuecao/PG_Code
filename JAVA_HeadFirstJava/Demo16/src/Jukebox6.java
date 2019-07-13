import java.io.*;
import java.util.*;

public class Jukebox6 {
	ArrayList<Song> songList = new ArrayList<Song>();
	public static  void main(String[] args) {
		new Jukebox6().go();
	}
	
	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
	}
	
	public void getSongs() {
		try {
			File file = new File("E:\\LUBO\\Java\\SongListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line=reader.readLine())!=null) {
				addSong(line);	
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void addSong(String linetoParse) {
		String[] tokens = linetoParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
