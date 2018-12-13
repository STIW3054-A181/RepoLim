package realtime.project;


import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    /**
     * The color of the shape. By default, it is black.
     */
    private Color color = Color.BLACK;

    /**
     * Constructor.
     */
    public Shape() {
    }

    /**
     * Constructor.
     */
    public Shape(Color color) {
        this.color = color;
    }

    /**
     * Set the color of component.
     */
    public Shape setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * Returns the color of component.
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Draw the component with given graphics object.
     * @param painter
     */
    public abstract void paint(Graphics painter);

	public String getToolTip(double[] coord) {
		// TODO Auto-generated method stub
		return null;
	}
}