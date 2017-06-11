package listeners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import piano.SimplePiano;

public class WhiteKeys extends SimplePiano implements ActionListener {
	public void actionPerformed(ActionEvent ev) {
		Object evSrc = ev.getSource();
		int noteNum = 0;
		for (int i = 0; i < whiteKeys.length; i++) {

			if (evSrc == whiteKeys[i]) {
				switch (i) {
				case 0:
					noteNum = 67;
					break;
				case 1:
					noteNum = 69;
					break;
				case 2:
					noteNum = 71;
					break;
				case 3:
					noteNum = 72;
					break;
				case 4:
					noteNum = 74;
					break;
				case 5:
					noteNum = 76;
					break;
				case 6:
					noteNum = 78;
					break;
				case 7:
					noteNum = 79;
					break;
				}
				break;
			}
		}
		try {
			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track t = seq.createTrack();
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			player.setSequence(seq);

			ShortMessage on = new ShortMessage();
			on.setMessage(144, 1, noteNum, 100);
			MidiEvent noteOn = new MidiEvent(on, 0);
			t.add(noteOn);

			ShortMessage off = new ShortMessage();
			off.setMessage(128, 1, noteNum, 100);
			MidiEvent noteOff = new MidiEvent(off, 1);
			t.add(noteOff);
			player.start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

