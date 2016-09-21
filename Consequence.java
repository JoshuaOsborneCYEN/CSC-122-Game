package com.spiders_skeletons_shenanigans.game;

public class Consequence extends Option
{
	private String deed;
	private Level alternateLevel;

	public Consequence (String deed)
	{
		super();
		this.deed = deed;
	}
	
	public Consequence (String text, String deed)
	{
		super(text);
		this.deed = deed;
	}
	
	
	/**
	 * Returns the alternate level decided by setAlternateLevel if player has done
	 * the "deed" specified.
	 * Otherwise, return normal next level.
	 * @return Level the next level
	 */
	public Level resolve()
	{
		if (Player.getRepercussions().contains(deed))
		{
			return alternateLevel;
		}
		else
		{
			return super.resolve();
		}
	}

	public Level getAlternateLevel()
	{
		return alternateLevel;
	}

	/**
	 * Sets the level the player will instead go to if he has the "deed." Not always bad.
	 * @param alternateLevel Level player will go to if he has the "deed."
	 */
	public void setAlternateLevel(Level alternateLevel)
	{
		this.alternateLevel = alternateLevel;
	}
}
