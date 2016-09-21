package com.spiders_skeletons_shenanigans.game;

public class StatCheck extends Option
{
	private String statToCheck;
	private int successThreshold;
	private Level failureLevel;

	public StatCheck(String stat, int threshold)
	{
		super();
		this.statToCheck = stat;
		this.successThreshold = threshold;
	}

	public StatCheck(String text, String stat, int threshold)
	{
		super(text);
		this.statToCheck = stat;
		this.successThreshold = threshold;
	}
	
	public void setFailureLevel(Level failureLevel)
	{
		this.failureLevel = failureLevel;
	}

	public Level resolve()
	{
		if (Player.getStat(statToCheck) >= successThreshold)
		{
			return super.resolve();
		}
		else
		{
			return failureLevel;
		}
	}
}
