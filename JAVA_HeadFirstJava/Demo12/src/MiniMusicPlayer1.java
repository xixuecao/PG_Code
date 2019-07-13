import javax.sound.midi.*;

public class MiniMusicPlayer1 {
	
	public static void main(String[] args) {
		
		try {
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();//取得sequencer并打开
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();//建立列队，创建track
			
			for (int i = 5; i < 61; i+=4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception ex) {
			ex.printStackTrace();// TODO: handle exception
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {}
		return event;
	}
}
