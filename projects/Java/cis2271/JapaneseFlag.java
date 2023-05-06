package edu.vtc.cis2271;

import java.awt.Color;
import java.awt.Graphics;

public class JapaneseFlag extends Flag 
{
	public JapaneseFlag()
	{
		super();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int h = this.getHeight();
		int w = this.getWidth();
		int size = (3*h)/5;
		g.setColor(Color.RED);
		g.fillOval((w/2)-size/2, (h/2)-size/2, size, size);
	}
}
