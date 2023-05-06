package edu.vtc.cis2271;

import java.awt.Color;
import java.awt.Graphics;

public class BahamaFlag extends Flag 
{
	public BahamaFlag()
	{
		super();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int h = this.getHeight();
		int w = this.getWidth();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 50, 50);
		
	}
}


