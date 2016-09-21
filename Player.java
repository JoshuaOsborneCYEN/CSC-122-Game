package com.spiders_skeletons_shenanigans.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectIntMap;

/**
 * @author Joshua Osborne
 * @version 5-4-16
 * Class meant to model the player's character, including stats, choices, etc.
 * Mostly static data that can be modified even from certain option subclasses.
 */
public class Player
{
	private static HashMap<String, Integer> stats;
	private static String name;
	boolean isAlive;
	public static final String[] listOfStats = {"Strength", "Agility", "Magic", "Leadership", "Intelligence", "Wealth" };
	private static ArrayList<String> repercussions;
	
	public Player(String name)
	{
		this.name = name;
		isAlive = true;
		stats = new HashMap<String, Integer>(listOfStats.length);
		repercussions = new ArrayList<String>();
		for (int i = 0; i < listOfStats.length; i++)
		{
			stats.put(listOfStats[i], new Integer(50));
		}
	}

	/**
	 * Puts in a new arbitrary value for stats.
	 * @param stat The stat to reset
	 * @param newValue Arbitrary net int value of stat
	 */
	public static void setStat(String stat, int newValue)
	{
		if (isValidStat(stat))
		{
			stats.put(stat, newValue);
		}
	}
	
	/**
	 * Adds a certain value to the specified stat.
	 * @param stat The stat to change
	 * @param change Integer of amount to add to the stat
	 */
	public static void changeStat(String stat, Integer change)
	{
		if (isValidStat(stat))
		{
			stats.put(stat, stats.get(stat) + change);
		}
	}
	
	/**
	 * Retrieves the current value of a specified stat.
	 * @param stat The value of the stat to retrieve
	 * @return Integer value of stat requested
	 */
	public static Integer getStat(String stat)
	{
		if (isValidStat(stat))
			return stats.get(stat);
		return new Integer(-1);
	}
	
	public String getName()
	{
		return name;
	}
	
	public static void setName(String newName)
	{
		name = newName;
	}

	public String toString()
	{
		String statString = "";
		//Set<String> playerStats;
		//playerStats = stats.keySet();
		//Iterator<String> it = playerStats.iterator();
		for(int i = 0; i < listOfStats.length; i++)
		{
			String statName = listOfStats[i];
			statString += statName + ": " + stats.get(statName) + "\n";
		}
		return "Player " + name + "\n" + statString;
	}


	/**
	 * This makes sure the stat one attempts to change or modify
	 * actually exists within the list of stats in the game.
	 * @param stat The stat to be validated
	 * @return whether the stat exists
	 */
	public static boolean isValidStat(String stat)
	{
		boolean valid = false;
		for (int i = 0; i < listOfStats.length; i++)
		{
			if (stat.equals(listOfStats[i]))
			{
				valid = true;
			}
		}
		return valid;
	}

	public static ArrayList<String> getRepercussions()
	{
		return repercussions;
	}
	
	/**
	 * Looks for a repercussion (string) in the player, identifying
	 * whether or not he has made a certain decision in the past. Used
	 * to punish or reward later on in the game.
	 * @param repercussion The repercussion to look for
	 * @return boolean whether the player possesses this certain repercussion
	 */
	public boolean isPlayerPunished(String repercussion)
	{
		if (repercussions.contains(repercussion))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Adds a string to the list of decisions (repercussions) the player 
	 * possesses.
	 * @param repercussion The decision to keep track of
	 */
	public static void addRepercussion(String repercussion)
	{
		repercussions.add(repercussion);
	}

	/**
	 * Resets the player's stats back to base levels and removes all repercussions,
	 * used at start and restart.
	 */
	public static void reset()
	{
		for(int i = 0; i < listOfStats.length; i++)
		{
			stats.put(listOfStats[i], 50);
		}
		repercussions.clear();		
	}
	
	
}