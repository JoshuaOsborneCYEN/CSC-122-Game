package com.spiders_skeletons_shenanigans.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RoleChoice extends Option
{
	private HashMap<String, Integer> stats;
	
	public RoleChoice(HashMap<String, Integer> stats)
	{
		initialize(stats);
	}

	public RoleChoice(String text, HashMap<String, Integer> stats)
	{
		super(text);
		initialize(stats);
	}
	
	public void initialize(HashMap<String, Integer> stats)
	{
		this.stats = stats;
	}
	
	public Level resolve()
	{
		Set<String> setOfStats = stats.keySet();
		Iterator<String> it = setOfStats.iterator();
		while(it.hasNext())
		{
			String stat = it.next();
			Player.setStat(stat, stats.get(stat));
		}
		return super.resolve();
	}
}
