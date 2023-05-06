package edu.vtc.cis2271;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Carter Irish
 *
 */
public class FrenchFlag extends Flag 
{
	public FrenchFlag()
	{
		super();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int h = this.getHeight();
		int w = this.getWidth();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, w/3, h);
		g.setColor(Color.RED);
		g.fillRect(2*(w/3), 0, w/3, h);
		
	}
}
