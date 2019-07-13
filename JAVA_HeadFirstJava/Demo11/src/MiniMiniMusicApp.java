import javax.sound.midi.*;

public class MiniMiniMusicApp {
	
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();                               //get a Sequencer and open it
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);//
			
			Track track = seq.createTrack();/*Ask the Sequence for a Track. Remember, the
			                                  Track lives in the Sequence, and the MIDI data
			                                  lives in the Track.*/
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 40, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192,1,70,0);
			MidiEvent noteon1 = new MidiEvent(first, 1);
			track.add(noteon1);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);/*Put some MidiEvents into the Track. This part
                                 is mostly Ready-bake code. The only thing you��ll
                                 have to care about are the arguments to the
                                 setMessage() method, and the arguments to
                                 the MidiEvent constructor. We��ll look at those
                                 arguments on the next page.*/
			
			player.setSequence(seq);/*Give the Sequence to the Sequencer (like
			                          putting the CD in the CD player)*/
			
			player.start();//Start() the Sequencer (like pushing PLAY)
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
}