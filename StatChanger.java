package com.spiders_skeletons_shenanigans.game;

public class StatChanger extends Option
{

	private String statReward;
	private int rewardAmount;

	public StatChanger(String stat, int amount)
	{
		super();
		this.statReward = stat;
		this.rewardAmount = amount;
	}

	public StatChanger(String text, String stat, int amount)
	{
		super(text);
		this.statReward = stat;
		this.rewardAmount = amount;
	}
	
	public Level resolve()
	{
		Player.changeStat(statReward, rewardAmount);
		return super.resolve();
	}

	public String getStatReward()
	{
		return statReward;
	}

	public int getRewardAmount()
	{
		return rewardAmount;
	}

	public void setStatReward(String statReward, int rewardAmount)
	{
		this.statReward = statReward;
		this.rewardAmount = rewardAmount;
	}

}
