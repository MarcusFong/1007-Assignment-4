import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * This class is a helper class to the Car class with
 * creating and returning certain geometric shapes to be
 * drawn to the JFrame.
 * 
 * @author Marcus
 *
 */
public class CarBodyBuilder {
	/**
	 * 
	 * @return a Rectangle2D.Double that represents the body
	 * of the car to be drawn.
	 */
	public Rectangle2D.Double getBody(Point bodyTopCoords, int unit) {
		// body of car

		Rectangle2D.Double body = new Rectangle2D.Double(bodyTopCoords.getX(), bodyTopCoords.getY(), 
				5*unit, 2*unit);
		return body;
	}
	
	
	/**
	 * 
	 * @return a Rectangle2D.Double that represents the body
	 * of the car to be drawn.
	 */
	public Ellipse2D.Double getPersonHead(Point bodyTopCoords, int unit){
		double headUpLeftX = bodyTopCoords.getX() + (3.5 * unit);
		int headUpLeftY = (int) bodyTopCoords.getY() - unit/2;
		int headSize = unit/2;
		Ellipse2D.Double headOfPerson = new Ellipse2D.Double(headUpLeftX, headUpLeftY, headSize, headSize);
		
		return headOfPerson;
	}
	
	/**
	 * 
	 * @return a Ellipse2D.Double that represents the back wheel
	 * of the car to be drawn.
	 */
	public Ellipse2D.Double getBackWheel(Point bodyTopCoords, Point bodyBotCoords, int unit){
		int backWheelX = (int) bodyTopCoords.getX();
		int backWheelY = (int) bodyBotCoords.getY();
		int wheelSize = unit;
		Ellipse2D.Double backWheel = new Ellipse2D.Double(backWheelX, backWheelY, wheelSize, wheelSize);
		
		return backWheel;
	}
	
	/**
	 * 
	 * @return a Ellipse2D.Double that represents the front wheel
	 * of the car to be drawn.
	 */
	public Ellipse2D.Double getFrontWheel(Point bodyBotCoords, int unit){
		int frontWheelX = (int) bodyBotCoords.getX()-unit;
		int frontWheelY = (int) bodyBotCoords.getY();
		int wheelSize = unit;
		Ellipse2D.Double frontWheel = new Ellipse2D.Double(frontWheelX, frontWheelY, wheelSize, wheelSize);
		
		return frontWheel;
	}
	
	/**
	 * 
	 * @return a Line2D.Double that represents the windshield
	 * of the car to be drawn.
	 */
	public Line2D.Double getWindShield(Point bodyTopCoords, Point bodyBotCoords, int unit){
		double windShieldTopX = bodyTopCoords.getX() + 3.5 * unit;
		double windShieldTopY = bodyTopCoords.getY() - unit;
		
		double windShieldBotX = bodyBotCoords.getX()-unit/2;
		double windShieldBotY = bodyTopCoords.getY();
		
		Line2D.Double windShield = new Line2D.Double(windShieldTopX, windShieldTopY, 
				windShieldBotX, windShieldBotY);	
		
		return windShield;
	}
}
