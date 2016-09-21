package com.spiders_skeletons_shenanigans.game;

public class StatAndConsequenceCheck extends Option
{
	private String statToCheck;
	private int successThreshold;
	private Level failureLevel;
	private String deed;

	public StatAndConsequenceCheck(String deed, String stat, int threshold)
	{
		this.deed = deed;
		this.statToCheck = stat;
		this.successThreshold = threshold;
	}

	public StatAndConsequenceCheck(String text, String deed, String stat, int threshold)
	{
		super(text);
		this.deed = deed;
		this.statToCheck = stat;
		this.successThreshold = threshold;
	}

	public void setFailureLevel(Level failureLevel)
	{
		this.failureLevel = failureLevel;
	}

	public Level resolve()
	{
		if (Player.getStat(statToCheck) >= successThreshold && Player.getRepercussions().contains(deed))
		{
			return super.resolve();
		} else
		{
			return failureLevel;
		}
	}

}
