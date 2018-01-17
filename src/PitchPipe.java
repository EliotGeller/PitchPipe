import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class PitchPipe extends JFrame implements ActionListener{
	
	//Declare Constants
	final String SINE = "Sine";
	final String SQUARE = "Square";
	final String SAW = "Saw";
	
	//Create sound options
	String octave = "1";
    String tone = "Sine";
	
	
	//Create UI Panels
	JPanel panel1 = new JPanel(new GridLayout(4,3));
	JPanel panel2 = new JPanel(new GridLayout(1,3));
	
	//Create UI Controls
	JButton c = new JButton("C");
	JButton cSharp = new JButton("C#");
	JButton d = new JButton("D");
	JButton dSharp = new JButton("D#");
	JButton e = new JButton("E");
	JButton f = new JButton("F");
	JButton fSharp = new JButton("F#");
	JButton g = new JButton("G");
	JButton gSharp = new JButton("G#");
	JButton a = new JButton("A");
	JButton aSharp = new JButton("A#");
	JButton b = new JButton("B");
	
	JComboBox octSel = new JComboBox();
	JComboBox toneSel = new JComboBox();
	
	JLabel options = new JLabel("OPTIONS");
	
	JFrame frame = new JFrame();

	//  Declare static variables:
	static PitchPipe pp;
	
	public void playSound(String file) {
		// method to create the audio player
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file + ".wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {	
		pp = new PitchPipe();
		pp.setUi();
		
		
		//Create JFrame
		pp.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pp.frame.setSize(new Dimension(600, 440));
	    pp.frame.setTitle("dB Software - Pitch Pipe");
	    pp.frame.setLayout(new GridLayout(2, 1));
		pp.frame.add(pp.panel1);
		pp.frame.add(pp.panel2);
		pp.frame.setVisible(true);
	}
	
	public void setUi(){
		
		//Fill combo boxes
		octSel.addItem("Octave 1");
		octSel.addItem("Octave 2");
		octSel.addItem("Octave 3");
		toneSel.addItem(SINE);
		toneSel.addItem(SQUARE);
		toneSel.addItem(SAW);
		
		//Build Screen
		//Set controls in panels
		panel1.add(c);
		panel1.add(cSharp);
		panel1.add(d);
		panel1.add(dSharp);
		panel1.add(e);
		panel1.add(f);
		panel1.add(fSharp);
		panel1.add(g);
		panel1.add(gSharp);
		panel1.add(a);
		panel1.add(aSharp);
		panel1.add(b);
		panel2.add(octSel);
		panel2.add(options);
		options.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(toneSel);

		
		// add action Listeners
		c.addActionListener(this);
		cSharp.addActionListener(this);
		d.addActionListener(this);
		dSharp.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		fSharp.addActionListener(this);
		g.addActionListener(this);
		gSharp.addActionListener(this);
		a.addActionListener(this);
		aSharp.addActionListener(this);
		b.addActionListener(this);
		octSel.addActionListener(this);
		toneSel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event){
	    Object source = event.getSource();
	    
	    // Octave selection
	    if (source == pp.octSel){
	    	String octSelection = (String) pp.octSel.getSelectedItem();
	    	if (octSelection.equals("Octave 1")){
	    		octave = "1";
	    	}
	    	if (octSelection.equals("Octave 2")){
	    		octave = "2";
	    	}
	    	if (octSelection.equals("Octave 3")){
	    		octave = "3";
	    	}
	    }
	    
	    // Tone selection
    	if (source == pp.toneSel){
	    	String toneSelection = (String) pp.toneSel.getSelectedItem();
	    	if (toneSelection.equals(SINE)){
	    		tone = "Sine";
	    	}
	    	if (toneSelection.equals(SQUARE)){
	    		tone = "Square";
	    	}
	    	if (toneSelection.equals(SAW)){
	    		tone = "Saw";
	    	}
    	}
    	
    	//Push buttons to play selected sounds
	    if (source == pp.c){
	    	pp.playSound(tone + "C" + octave);
	    }
	    if (source == pp.cSharp){
	    	pp.playSound(tone + "C#" + octave);
	    }
	    if (source == pp.d){
	    	pp.playSound(tone + "D" + octave);
	    }
	    if (source == pp.dSharp){
	    	pp.playSound(tone + "D#" + octave);
	    }
	    if (source == pp.e){
	    	pp.playSound(tone + "E" + octave);
	    }
	    if (source == pp.f){
	    	pp.playSound(tone + "F" + octave);
	    }
	    if (source == pp.fSharp){
	    	pp.playSound(tone + "F#" + octave);
	    }
	    if (source == pp.g){
	    	pp.playSound(tone + "G" + octave);
	    }
	    if (source == pp.gSharp){
	    	pp.playSound(tone + "G#" + octave);
	    }
	    if (source == pp.a){
	    	pp.playSound(tone + "A" + octave);
	    }
	    if (source == pp.aSharp){
	    	pp.playSound(tone + "A#" + octave);
	    }
	    if (source == pp.b){
	    	pp.playSound(tone + "B" + octave);
	    }
	    
	}
}
