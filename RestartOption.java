package com.spiders_skeletons_shenanigans.game;

public class RestartOption extends Option
{

	public RestartOption()
	{
		super();
		super.setText("Restart, or hit Quit down below.");
	}

	public RestartOption(String text)
	{
		super(text);
	}
	
	public Level resolve()
	{
		Player.reset();
		return getNextLevel();
	}
}
