package edu.vtc.cis2271;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Carter Irish
 *
 */
public abstract class Flag extends JPanel 
{
	/**
	 * 
	 */
	public Flag()
	{
		setMinimumSize(new Dimension(300,200));
		setPreferredSize(new Dimension(300,200));
		setBackground(Color.WHITE);
		
		
	}



}
