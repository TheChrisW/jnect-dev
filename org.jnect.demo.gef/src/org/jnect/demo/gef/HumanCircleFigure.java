package org.jnect.demo.gef;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class HumanCircleFigure extends Figure {
	private Label label;
	private RectangleFigure rectangle;
	
	public HumanCircleFigure() {
		setLayoutManager(new XYLayout());
		rectangle = new RectangleFigure();
		add(rectangle);
		label = new Label();
		add(label);
	}
	
	  @Override 
	  protected void paintFigure(Graphics graphics) {
	    Rectangle r = getBounds().getCopy();
	    setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
	    setConstraint(label, new Rectangle(0, 0, r.width, r.height));
	  }
	  
	  public Label getLabel() {
		  return label;
	  }
	  
	  public RectangleFigure getRectangle() {
		  return this.rectangle;
	  }
}
