import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * 
 * @author Marcus Fong
 * 
 * This program creates a JFrame road race for a number 
 * of cars (ranging from 3-7) that move across the screen. 
 * Each car starts at the same place on the x axis but is 
 * randomly placed on the y axis. Their size is randomly 
 * generated too. 
 * 
 * However, all the cars move at the same speed and there 
 * will be a horizontal slider provided on the right hand 
 * side of the JFrame to adjust the speed the group of cars.
 * 
 * Gray puffs of smoke will come out of the car as they move. 
 * 
 * The Controller class is the main "hub" of the program and it
 * is in charge of creating the JFrame, the cars, and running 
 * the listeners. 
 * 
 * The entire group of cars displayed is represented as an icon
 * through the MyIcon class. 
 * 
 * Because the cars move at the same speed and have similar traits,
 * I decided to encapsulate the group of cars into one class, 
 * GroupOfCars, which implements the MovingObject interface. The 
 * MovingObject interface contains methods that help with translating
 * and drawing to the JFrame.
 * 
 * The CarBodyPart and CarBodyBuilder are helper classes (CarBodyBuilder
 * is an enum) to the class Car. 
 * 
 * Video of program: https://youtu.be/GtQnbMZQV4s
 * 
 * Code for this program was borrowed
 * from the original Hw4Runner class that was written
 * by professor Kender.
 * 
 * 
 *
 */
public class Runner {
	public static void main(String[] args) {
		new Controller();
		
	}
	
}
