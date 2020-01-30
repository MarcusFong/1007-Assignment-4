import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
/**
 * 
 * This class represents a random number of cars (ranging from 
 * 3-7 depending on what was created in class Controller) and groups
 * them together as a MovingObject. This is done because they all 
 * move and are drawn together in the same way.  
 * 
 * @author Marcus
 *
 */
public class GroupOfCars implements MovingObject{
	
	/**
	 * Creates an array of Car objects that holds each Car in each
	 * element of the array. 
	 * 
	 * @param numOfCars the number of cars in this group of cars.
	 */
	public GroupOfCars(int numOfCars) {
		cars = new Car[numOfCars];
	}
	
	/**
	 * This method is called to draw/fill the cars and their 
	 * smoke trails onto the JFrame. 
	 */
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		GeneralPath theGroupOfCars = new GeneralPath();
		GeneralPath theTrailsOfSmoke = new GeneralPath();
		
		for (int i = 0; i < cars.length; i++) {
			Car theCar = cars[i];
			
			theGroupOfCars.append(theCar.getCarBodyPart(CarBodyPart.BODY), false);
			theGroupOfCars.append(theCar.getCarBodyPart(CarBodyPart.PERSONHEAD), false);
			theGroupOfCars.append(theCar.getCarBodyPart(CarBodyPart.BACKWHEEL), false);
			theGroupOfCars.append(theCar.getCarBodyPart(CarBodyPart.FRONTWHEEL), false);
			
			addSmokeTrail(theTrailsOfSmoke, theCar);
			
			g2d.draw(theCar.getCarBodyPart(CarBodyPart.WINDSHIELD));
		}
		g2d.fill(theGroupOfCars);
		
		g2d.setColor(Color.GRAY);
		g2d.fill(theTrailsOfSmoke);

	}
	
	/**
	 * This method simplifies the process and code of adding individual puffs 
	 * to the smoke trail. 
	 * 
	 * @param theTrailsOfSmoke the GeneralPath that encompasses all smoke trails
	 * @param trailSize the size of smoke trail for this particular car. 
	 */
	public void addSmokeTrail(GeneralPath theTrailsOfSmoke, Car theCar) {
		LinkedList<Ellipse2D.Double> smokeTrail = theCar.getSmokeTrail();
		Iterator<Ellipse2D.Double> theIterator = smokeTrail.iterator();
		
		while (theIterator.hasNext()) {
			theTrailsOfSmoke.append(theIterator.next(), false);
		}
		
	}

	/**
	 * This method moves each car in cars xChange on the x-axis and
	 * yChange on the yAxis
	 */
	public void translate(int xChange, int yChange) {
		for (Car tempCar : cars) {
			tempCar.translate(xChange, yChange);
		}
	}
	
	/**
	 * This method helps set each element in cars equal to its
	 * corresponding Car. 
	 */
	public void addCar(int index, Car theObject) {
		cars[index] = theObject;
	}
	
	
	
	private Car[] cars;


	
}
