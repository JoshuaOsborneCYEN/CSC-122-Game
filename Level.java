package com.spiders_skeletons_shenanigans.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Joshua Osborne
 * @version 5-4-16
 * Model of a level with its own background, changed every time an option is
 * selected. Contains a background and the text that should go in the text window.
 * Also contains options (in an ArrayList) and organizes them whenever one is added
 * (unless it's StatOption or QuitOption, which use addCommonOption() so as not to
 * mess with the layou logic of the other options).
 */
public class Level
{
	public static final int GAME_WIDTH = 1920;
	private String name;
	private ArrayList<Option> options;
	private Texture background = new Texture("backgrounds/WIP.png");

	private String intro;
	private String backgroundName;
	private int numberOfOptions;
	private String audioName;

	/**
	 * Initializes a level with a specific name.
	 * @param name Name that can be used to identify the level
	 */
	public Level(String name)
	{
		options = new ArrayList<Option>();
		this.name = name;
		numberOfOptions = 0;
	}

	
	/**
	 * Initializes a level with a specific name, intro, and a background.
	 * @param name Name to identify level
	 * @param intro Corresponding intro text to be pulled from TextChoice.java
	 * @param background String name of the background for the level (jpg, png)
	 */
	public Level(String name, String intro, String background)
	{
		options = new ArrayList<Option>();
		this.name = name;
		this.setIntro(intro);
		numberOfOptions = 0;
		this.setBackground(background);
	}

	public String getName()
	{
		return name;
	}
	
	public ArrayList<Option> getOptions()
	{
		return options;
	}

	public int getNumberOfOptions()
	{
		return numberOfOptions;
	}

	public void setOptions(ArrayList<Option> options)
	{
		this.options = options;
	}

	/**
	 * Adds a new choice for the player to select. This will appear as a box
	 * when the level is loaded. When this method is called, it sets the positions
	 * of the options as well.
	 * @param option The regular option to be added to the player choices.
	 */
	public void addOption(Option option)
	{
		options.add(option);
		numberOfOptions++;
		
		setOptionSizes();
	}
	
	/**
	 * Adds a choice (like stats or quit) for the player to select. This will
	 * appear as a box when the level is loaded. When this method is called, it 
	 * does not set the position of the options and does not mess with the math
	 * used for the other normal options.
	 * @param option The common option to be added to the player choices.
	 */
	public void addCommonOption(Option option)
	{
		if (options.contains(option))
		{
			options.remove(option);
		}
		options.add(option);
	}


	/**
	 * Uses an equation to normalize spacing between options and set their locations
	 * and dimensions on screen. This isn't very good coding practice 
	 * (model view controller), but at least it's taken care of outside
	 * the option class. Uses numberOfOptions in the equation to decide spacing rather
	 * than the size of the options list.
	 */
	private void setOptionSizes()
	{
		int xPosition;
		int yPosition = 80;
		int optionHeight = 400;
		int xSep = 60;
		int n = numberOfOptions;
		for (int i = 0; i < n; i++)
		{
			Option o = options.get(i);
			int optionWidth = ( (GAME_WIDTH - ( xSep * ( n + 1 ) ) ) / n );
			o.setWidth(optionWidth);
			o.setHeight(optionHeight);
			xPosition = ( ( i + 1 ) * xSep ) + (i * optionWidth);
			o.setPosition(xPosition, yPosition);
		}
		
	}

	public Option getOption(int index)
	{
		return options.get(index);
	}

	public Texture getBackground()
	{
		return background;
	}

	public String getBackgroundName()
	{
		return backgroundName;
	}


	/**
	 * @param background Name of the image file of the background
	 */
	public void setBackground(String background)
	{
		setBackgroundName(background);
		this.background = new Texture(background);
	}
	
	public void setBackgroundName(String background)
	{
		this.backgroundName = background;
	}

	/**
	 * Retrieves text used for title card (IntroWindow)
	 * @return String that gets displayed in the title card
	 */
	public String getIntro()
	{
		return intro;
	}

	/**
	 * Used to set the text displayed by the title card (IntroWindow)
	 * @param intro String that gets displayed in the title card pulled from TextChoice.
	 */
	public void setIntro(String intro)
	{
		this.intro = TextChoice.findOption(intro);
	}
	
	/**
	 * Used to set text displayed by the title card without going through TextChoice
	 * @param intro String that gets displayed as written on the title card
	 */
	public void setIntroText(String intro)
	{
		this.intro = intro;
	}

	public void setAudioName(String audioName)
	{
		this.audioName = audioName;
	}
	
	public String getAudioName()
	{
		return audioName;
	}
	
	@Override
	public String toString()
	{
		String links = "Links to: ";
		for (Option option : options)
		{
			links += (option.getNextLevel().getName() + ", ");
		}
		links += ",,.\n";
		return links;
	}

}