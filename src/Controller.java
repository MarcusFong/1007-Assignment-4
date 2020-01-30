import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * 
 * This class is in charge of running the responsible methods
 * that run the road race. This includes setting up the JFrame,
 * creating each individual car, and the car-speed slider. 
 * 
 * @author Marcus
 *
 */
public class Controller {
	
	/**
	 * Creating an instance of this class starts the game and
	 * creates the random number generator.
	 */
	public Controller() {
		randGenerator = new Random();
		startRoadRace();	
	}
	
	
	/**
	 * This method starts the race and runs the following methods
	 * that are responsible with creating the JFrame and its components
	 * to start the road race. 
	 */
	public void startRoadRace() {
		createGroupOfCars();
		setUpJFrame();
		sliderListener();
		timerListener();
	}
	
	/**
	 * This method creates a random number from 3-7 and creates that many 
	 * Car objects for the race to begin. It then adds each car to 
	 * theGroupOfCars, which is supposed to represent all of the cars as
	 * one MovingObject.
	 */
	public void createGroupOfCars() {
		int numOfCars = randGenerator.nextInt(5) + 3; //creates a random number from 3-7
		
		theGroupOfCars = new GroupOfCars(numOfCars); 
		
		for (int i = 0; i < numOfCars; i++) {
			theGroupOfCars.addCar(i, createCar());
		}	
	}
	
	/**
	 * This method creates Car objects when called with randomly generated
	 * sizes and vertical coordinates. 
	 * 
	 * @return a Car with randomly generated size and vertical coordinates. 
	 */
	public Car createCar() {
		double scale = randGenerator.nextDouble()*(1.5) + 0.5;
		int theUnit = (int) (SIZE * scale);
		
		//I multiply theUnit by 6 so the random y cord won't create
		//a car that will go off the screen
		int randYCord = randGenerator.nextInt(ICON_H - SIZE*6);
		
		return new Car(0, randYCord, theUnit);
		
	}
	
	
	/**
	 * This method sets up the JFrame for the game and adds the 
	 * corresponding components to it (theGroupOfCars and theSlider).  
	 * I define the entire group of cars to be one icon. 
	 * 
	 * Code for Hashtable borrowed and used from the following oracle 
	 * tutorial:
	 * https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
	 */
	public void setUpJFrame() {
		JFrame myFrame = new JFrame();
		
		final MyIcon myIcon = new MyIcon(theGroupOfCars, ICON_W, ICON_H);
		myLabel = new JLabel(myIcon); 		
		createSlider();
		
		myFrame.add(myLabel); 
		myFrame.add(theSlider); 
		
		myFrame.setLayout(new FlowLayout()); //creates lay out of the GUI
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
		
		
	}
	

	/**
	 * This method creates a horizontal slider that has a range of 
	 * adjustable values from -10 to 10.
	 */
	public void createSlider() {
		theSlider = new JSlider(JSlider.HORIZONTAL, -10, 10, 5);
		theSlider.setMajorTickSpacing(5); // each tick is an increment of 5
		theSlider.setPaintTicks(true);
		theSlider.setValue(1); // sets starting value of slider to positive one
		
		
		// creates a label table for 3 of the tick marks on the slider
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(-10, new JLabel("-10"));
		labelTable.put(0, new JLabel("0"));
		labelTable.put(10, new JLabel("10"));
		theSlider.setLabelTable(labelTable);
		
		theSlider.setPaintLabels(true);
	}
	
	/**
	 * This method contains the code that creates a listener
	 * for the slider component. This slider component controls 
	 * the speed (xSpeed) of the group of cars.
	 */
	public void sliderListener() {
		theSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				xSpeed = theSlider.getValue();
			}
			
		});
	}
	
	/**
	 * This method contains the code that creates a listener
	 * that runs and translates theGroupOfCars every DELAY 
	 * milliseconds by xSpeed. 
	 */
	public void timerListener() {
		final int DELAY = 100;
		
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			//moves the object by 1 pixel every 100 milliseconds
			public void actionPerformed(ActionEvent event) {
				theGroupOfCars.translate(xSpeed, 0);
				myLabel.repaint();
			}
		});
		myTimer.start();
	}
	
	
	
	private static final int SIZE = 20;
	private static final int ICON_W =  1200; // width of the frame
	private static final int ICON_H = 600; // height of the frame
	private final Random randGenerator;
	
	private MovingObject theGroupOfCars;
	private JLabel myLabel;
	private JSlider theSlider;
	
	private int xSpeed = 1;	

}
