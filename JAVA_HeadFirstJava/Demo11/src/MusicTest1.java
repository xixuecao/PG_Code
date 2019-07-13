import javax.sound.midi.*;

public class MusicTest1 {
	public void play() {
		try {
		Sequencer sequencer = MidiSystem.getSequencer();
		System.out.println("Successfully got a sequencer");
		} catch(MidiUnavailableException ex) {
		System.out.println("Bummer");
		}
	}
	public static void main(String[] args) throws MidiUnavailableException {
		String[] a={"102","30"};
		MusicTest1 mt = new MusicTest1();		
		mt.play();

	}
} 

