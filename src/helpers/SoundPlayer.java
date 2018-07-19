package helpers;

import java.io.InputStream;
import java.net.URL;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

// Class that handles the playing of .wav and .mp3 files for game
// sound effects and music
public class SoundPlayer {
	
	private static Sequencer midiSequence;
	
	public static void playWAV(String wavPath, float gain) {
		if((gain > 6.0f) || (gain < -80.0f)) {
			System.out.println("Gain can only be between -80f and 6.0f: Your Gain = "+Float.toString(gain));
			return;
		}
		
	    try {
	    	URL urlPath = SoundPlayer.class.getClassLoader().getResource(wavPath);
	    	//DEBUG
	    	//System.out.println(wavFile.getAbsolutePath());
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlPath);
	        //DEBUG
	        //System.out.println(audioInputStream.getFormat());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(gain); // Reduce volume by set gain
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound: " + wavPath);
	        ex.printStackTrace();
	    }
	}
	
	public static void playWAV(String wavPath) {
		SoundPlayer.playWAV(wavPath, 0);
	}
	
	/// Midi play with set volume for each channel
	public static void playMidi(String midiPath, int volume) {
        // Obtains the default Sequencer connected to a default device.
        Sequencer sequencer;
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	        
	        // Opens the device, indicating that it should now acquire any
	        // system resources it requires and become operational.
	        sequencer.open();
	        
	        // create a stream from a file
	        InputStream is = SoundPlayer.class.getClassLoader().getResourceAsStream(midiPath);

	        // Sets the current sequence on which the sequencer operates.
	        // The stream must point to MIDI file data.
	        sequencer.setSequence(is);
	        
			Track[] tracks = sequencer.getSequence().getTracks();
			
			for(Track track : tracks) {
				for(int x = 0; x < 16; x++) {
					track.add(new MidiEvent(
							new ShortMessage(ShortMessage.CONTROL_CHANGE, x, 7, volume), 0));
				}
			}
	 
	        // Starts playback of the MIDI data in the currently loaded sequence.
	        sequencer.start();
	        SoundPlayer.midiSequence = sequencer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Play Midi without volume set
	public static void playMidi(String midiPath) {
        // Obtains the default Sequencer connected to a default device.
        Sequencer sequencer;
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	        
	        // Opens the device, indicating that it should now acquire any
	        // system resources it requires and become operational.
	        sequencer.open();
	        
	        // create a stream from a file
	        InputStream is = SoundPlayer.class.getClassLoader().getResourceAsStream(midiPath);

	        // Sets the current sequence on which the sequencer operates.
	        // The stream must point to MIDI file data.
	        sequencer.setSequence(is);
	 
	        // Starts playback of the MIDI data in the currently loaded sequence.
	        sequencer.start();
	        SoundPlayer.midiSequence = sequencer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Stops the current song
	public static void stopMidi() {
		if(SoundPlayer.midiSequence != null) {
			SoundPlayer.midiSequence.stop();
		}
	}
	
}
