// Name: Yuntao Liang
// USC NetID: 3462638190
// CS 455 PA1
// Fall 2018

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private int bottom;
   private int left;
   private int width;
   private int barHeight;
   private double scale;
   private final Color color;
   private final String label;


   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      this.bottom = bottom;
      this.left = left;
      this.width = width;
      this.barHeight = barHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      //get the origin point, width and height of label
      //draw the label
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label, context);
      int labelWidth = (int)labelBounds.getWidth();
      int heightOfLabel = (int)labelBounds.getHeight();
      int originXOfLabel = left + (width - labelWidth) / 2;
      int originYOfLabel = bottom;
      g2.setColor(Color.BLACK);
      g2.drawString(label, originXOfLabel, originYOfLabel);
      //get the origin point, width and height of rectangle
      //draw the rectangle
      int heightOfRectangle = (int)(scale * barHeight);
      int originXOfRectangle = left;
      int originYOfRectangle = bottom - heightOfLabel - heightOfRectangle;
      Rectangle bar = new Rectangle(originXOfRectangle, originYOfRectangle, width,  heightOfRectangle);
      g2.setColor(color);
      g2.fill(bar);
   }
}
