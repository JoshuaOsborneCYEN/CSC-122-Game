package com.spiders_skeletons_shenanigans.game;

public class StatAndFutureChanger extends Option
{
	private String repercussion;
	private String statReward;
	private int rewardAmount;
	
	public StatAndFutureChanger(String repercussionName, String stat, int amount)
	{
		super();
		this.repercussion = repercussionName;
		this.statReward = stat;
		this.rewardAmount = amount;
	}

	public StatAndFutureChanger(String text, String repercussionName, String stat, int amount)
	{
		super(text);
		this.repercussion = repercussionName;
		this.statReward = stat;
		this.rewardAmount = amount;
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

	public Level resolve()
	{
		Player.addRepercussion(repercussion);
		Player.changeStat(statReward, rewardAmount);
		return super.resolve();
	}
}
