package edu.vtc.cis2271;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class FlagApp extends JFrame
{
	private Flag _currentFlag;
	public FlagApp()
	{
		super("Flags");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		Flag f = new JapaneseFlag();
		this._currentFlag = f;
		add(BorderLayout.CENTER,f);
		Box box = new Box(BoxLayout.X_AXIS);
		add(BorderLayout.SOUTH,box);
		box.add(Box.createHorizontalGlue());
		JButton button = new JButton("French");
		button.addActionListener(e->setFlag(new FrenchFlag()));
		box.add(button);
		box.add(Box.createHorizontalGlue());
		JButton button2 = new JButton("Japanese");
		button2.addActionListener(e->setFlag(new JapaneseFlag()));
		box.add(button2);
		box.add(Box.createHorizontalGlue());
		JButton button3 = new JButton("Bahama");
		button3.addActionListener(e->setFlag(new BahamaFlag()));
		box.add(button3);
		box.add(Box.createHorizontalGlue());

		pack();

	}
	public void setFlag(Flag f) 
	{
		remove(this._currentFlag);
		this._currentFlag = f;
		add(BorderLayout.CENTER,f);
		validate();
	}
	public static void main(String[] args) 
	{
		FlagApp w = new FlagApp();
		w.setVisible(true);
	}

}
