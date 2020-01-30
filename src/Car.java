import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 
 * @author Marcus Fong
 * 
 * This class represents an individual Car and its particular traits.
 * Things like its UNIT size, its location, etc. This class also 
 * contains methods that help with drawing its individual parts of 
 * the Car to the JFrame.
 * 
 * Much code for this classed was borrowed from the example
 * provided on Courseworks written by Professor kender.
 *
 */
public class Car {
	/**
	 * 
	 * @param x the x coordinate of the object in the Icon
	 * @param y the y coordinate of the object in the Icon
	 * @param UNIT one "UNIT" for a Car is defined to be the diameter 
	 * of a wheel
	 */
	public Car(int x, int y, int UNIT) {
		xPos = x;
		yPos = y;
		this.UNIT = UNIT; // UNIT is in pixels
		randGenerator = new Random();
		
		carBuilder = new CarBodyBuilder();
		smokeTrail = new LinkedList<Ellipse2D.Double>();
		
		setUpCarBodyCoords();
	}
	
	/**
	 * This method is called to set up the relative 
	 * coordinates (relative/based on the upper left hand 
	 * corner of the body of the car) each time the car 
	 * needs to be updated.
	 */
	public void setUpCarBodyCoords() {
		int bodyTopCoordsX = xPos;
		int bodyTopCoordsY = yPos + (2 * UNIT);		
		
		bodyTopCoords = new Point(bodyTopCoordsX, bodyTopCoordsY);
		bodyBotCoords = new Point(bodyTopCoordsX + (5 * UNIT), bodyTopCoordsY + (2 * UNIT));
		
	}
	
	/**
	 * This method moves the car xChange in the x direction and
	 * yChange in the y direction. As this method is called 
	 * every time the Car is meant to move, this method also 
	 * helps readjust its coordinates and creates a smoke puff.  
	 * 
	 * @param xChange
	 * @param yChange
	 */
	public void translate(int xChange, int yChange) {
		
		xPos += xChange;
		yPos += yChange;
		
		setUpCarBodyCoords();
		createSmokePuff();
	}

	public Shape getCarBodyPart(CarBodyPart part) {
		switch (part) {
		case BODY:
			return carBuilder.getBody(bodyTopCoords, UNIT);
		case PERSONHEAD:
			return carBuilder.getPersonHead(bodyTopCoords, UNIT);
		case BACKWHEEL:
			return carBuilder.getBackWheel(bodyTopCoords, bodyBotCoords, UNIT);
		case FRONTWHEEL:
			return carBuilder.getFrontWheel(bodyBotCoords, UNIT);
		case WINDSHIELD:
			return carBuilder.getWindShield(bodyTopCoords, bodyBotCoords, UNIT);

		}
		return null;
	}
	
	
	/**
	 * This method creates a new smokePuff and removes the head of
	 * the trail if the size of the trail has reached 3.
	 */
	public void createSmokePuff() {
		int smokePuffWidth = (int) (UNIT * randGenerator.nextDouble() + 0.5);
		int smokePuffHeight = (int) (UNIT * randGenerator.nextDouble() + 0.5);
	
		int smokePuffX = (int) bodyTopCoords.getX(); 
		int smokePuffY = (int) bodyBotCoords.getY() - smokePuffHeight;
		
		Ellipse2D.Double newSmokePuff = new Ellipse2D.Double(smokePuffX, smokePuffY, smokePuffWidth, smokePuffHeight);
		
		smokeTrail.add(newSmokePuff);
		
		// gets rid of the head smoke puff
		if (smokeTrail.size() == 3) {
			smokeTrail.poll();
		}
		
		Iterator<Ellipse2D.Double> theIterator = smokeTrail.iterator();
		
		// shifts each smoke puff in the smokeTrail down by the width of the
		// new smoke puff (smokePuffWidth);
		while (theIterator.hasNext()) {
			Ellipse2D.Double tempPuff = theIterator.next();
			tempPuff.x -= smokePuffWidth;

		}

	}
	
	/**
	 * 
	 * @return the trail of smoke puffs as a LinkedList
	 */
	public LinkedList<Ellipse2D.Double> getSmokeTrail() {
		return smokeTrail;
	}
	
	
	private final int UNIT;
	private final Random randGenerator;

	

	// xPos and yPos positions are in the lop left corner 
	private int xPos;
	private int yPos;
	private CarBodyBuilder carBuilder;
	/**
	 * Represents the upper left hand coordinates.
	 */
	private Point bodyTopCoords;
	/**
	 * Represents the lower right hand coordinates.
	 */
	private Point bodyBotCoords;

	
	private LinkedList<Ellipse2D.Double> smokeTrail;

	
	

}
