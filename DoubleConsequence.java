package com.spiders_skeletons_shenanigans.game;

public class DoubleConsequence extends Option
{
	private String deed1;
	private String deed2;
	private Level alternateLevel;
	
	public DoubleConsequence(String deed1, String deed2)
	{
		super();
		this.deed1 = deed1;
		this.deed2 = deed2;
	}

	public DoubleConsequence(String text, String deed1, String deed2)
	{
		super(text);
		this.deed1 = deed1;
		this.deed2 = deed2;
	}
	
	public void setAlternateLevel(Level alternateLevel)
	{
		this.alternateLevel = alternateLevel;
	}
	
	public Level resolve()
	{
		if (Player.getRepercussions().contains(deed1) || (Player.getRepercussions().contains(deed2)))
		{
			return super.resolve();
		}
		else
		{
			return alternateLevel;
		}
	}
}
