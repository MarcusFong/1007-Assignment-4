import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Marcus Fong
 * 
 * This class represents an icon on the JFrame to
 * be drawn/painted.   
 * 
 * Most of this code for this class was borrowed
 * from the original MyIcon class that was written
 * by professor kender.
 *
 */
public class MyIcon implements Icon {
	/**
	 * 
	 * This constructor creates an icon with width w
	 * and height h. This icon represents the entire group
	 * of cars that move together across the screen through
	 * the MovingObject obj.
	 * 
	 * @param obj A MovingObject to be displayed.
	 * @param w int width of the icon.
	 * @param h int height of the icon.
	 */
	public MyIcon(MovingObject obj, int w, int h) {
		theObj = obj;
		width = w;
		height = h;
	}
	
	/**
	 * @return the width of the icon
	 */
	public int getIconWidth() {
		return width;
	}
	/**
	 * @return the height of the icon
	 */
	public int getIconHeight() {
		return height;
	}
	/**
	 * This method paints the entire icon to the JFrame when invoked,
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		theObj.draw(g2D);
	}

	private int width;
	private int height;
	private MovingObject theObj;
}
