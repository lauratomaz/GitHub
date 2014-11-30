package edu.cofc.csci221.ui;

/**
 * 
 * @author Laura Tomaz Da Silva
 * @since November 27th, 2014
 * Class that inherits from Line with methods to get koch lines between points, verifies if the koch lines are valid between the points and computes the fractal according
 * to the equations provided on the pdf assignment to draw it on the panel. This class has a constructor with two parameters. 
 *
 */
public class KochLine extends Line{

	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	private Point p5;
	
	public KochLine(Point start, Point end){
		super(start, end);
		p1 = super.getStart();
		p5 = super.getEnd();
	}
	
	/**
	 * Method that creates a new Koch Line passing the points p1 and p2 as arguments.
	 * Precondition: none.
	 * Postcondition: returns a KochLine between the points p1 and p2.
	 * @return lineA
	 */
	public KochLine getLineA(){
		KochLine lineA = new KochLine(p1, p2);
		return lineA;
	}
	
	/**
	 * Method that creates a new Koch Line passing the points p2 and p3 as arguments.
	 * Precondition: none.
	 * Postcondition: returns a KochLine between the points p2 and p3.
	 * @return lineB
	 */
	public KochLine getLineB(){
		KochLine lineB = new KochLine(p2, p3);
		return lineB;
	}
	
	/**
	 * Method that creates a new Koch Line passing the points p3 and p4 as arguments.
	 * Precondition: none.
	 * Postcondition: returns a KochLine between the points p3 and p4.
	 * @return lineC
	 */
	public KochLine getLineC(){
		KochLine lineC = new KochLine(p3, p4);
		return lineC;
	}
	
	/**
	 * Method that creates a new Koch Line passing the points p4 and p5 as arguments.
	 * Precondition: none.
	 * Postcondition: returns a KochLine between the points p4 and p5.
	 * @return lineD
	 */
	public KochLine getLineD(){
		KochLine lineD = new KochLine(p4, p5);
		return lineD;
	}
	
	/**
	 * Method responsible for calculating the coordinates for x and y of the points p2, p3 and p4.
	 * Precondition: none.
	 * Postcondition: setting the coordinates for x and y of the points according to the equations provided in the pdf assignment.
	 */
	public void computeFractal(){
		p2 = new Point();
		p3 = new Point();
		p4 = new Point();
		
		int varX = p5.getX() - p1.getX();
		int varY = p5.getY() - p1.getY();
		
		p2.setX((p1.getX() + (varX/3)));
		p2.setY((p1.getY() + (varY/3)));
		
		int setXP3 = (int) ((p1.getX() + p5.getX())/2 + (Math.sqrt(3) * (p1.getY() - p5.getY())/6));
		int setYP3 = (int) ((p1.getY() + p5.getY())/2 + (Math.sqrt(3) * (p5.getX() - p1.getX())/6));
		
		p3.setX(setXP3);
		p3.setY(setYP3);
		
		p4.setX(p1.getX() + (2 * (varX/3)));
		p4.setY(p1.getY() + (2 * (varY/3)));
	}
	
	/**
	 * Method that verifies if all the koch lines are valid and returns a boolean.
	 * Precondition: none.
	 * Postcondition: returns a boolean.
	 * @return isValid
	 */
	public boolean isKochLineValid(){
		boolean isValid = false;
		if((getLineA().isValid()) && (getLineB().isValid()) && (getLineC().isValid()) && (getLineD().isValid())){
			isValid = true;
		}
		
		return isValid;
	}
}
