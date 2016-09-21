package com.spiders_skeletons_shenanigans.game;

public class FutureChanger extends Option
{
	private String repercussion;

	public FutureChanger (String repercussionName)
	{
		super();
		this.repercussion = repercussionName;
	}
	
	public FutureChanger (String text, String repercussionName)
	{
		super(text);
		this.repercussion = repercussionName;
	}
	
	public Level resolve()
	{
		Player.addRepercussion(repercussion);
		return super.resolve();
	}
	
	
}
