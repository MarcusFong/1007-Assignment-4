import java.awt.*;

/**
 * 
 * @author Marcus Fong
 * 
 * This interface represents objects that move across the screen.
 * 
 * Most of this code for this class was borrowed
 * from the original MovingObject class that was written
 * by professor kender.
 *
 */
public interface MovingObject {
	void draw(Graphics2D g2D);
	void translate(int xChange, int yChange);
	void addCar(int index, Car theObject);
}