package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class StatButton extends Option implements DrawableTextWindow
{
	private String statString;
	private Level returnLevel;

	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Old English.ttf"));
	private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	private BitmapFont font;

	public StatButton(Level returnLevel)
	{
		super();
		this.setPosition(60, 10);
		this.setHeight(commonOptionHeight);
		this.setWidth(300);
		statString = this.initializeStatString();
		this.setText("Stats");

		parameter.size = 45;
		parameter.color = Color.GOLD;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font = generator.generateFont(parameter);

		this.setReturnLevel(returnLevel);
	}

	private String initializeStatString()
	{
		String builder = "Stats: \n";
		for (int i = 0; i < Player.listOfStats.length; i++)
		{
			String stat = Player.listOfStats[i];
			builder += stat + ": " + Player.getStat(stat) + "\n";
		}
		return builder;
	}

	public Level getReturnLevel()
	{
		return returnLevel;
	}

	public void setReturnLevel(Level returnLevel)
	{
		this.returnLevel = returnLevel;
	}

	public BitmapFont getFont()
	{
		return font;
	}

	public Level resolve()
	{
		if (!returnLevel.getName().equals("Stat Level"))
		{
			Level statLevel = new Level("Stat Level");
			statLevel.setIntroText(statString);
			statLevel.setBackground("backgrounds/black.jpg");

			Option goBack = new Option();
			goBack.setText("Return...");
			goBack.setNextLevel(returnLevel);
			statLevel.addOption(goBack);

			return statLevel;
		}
		return returnLevel;
	}

	public boolean equals(Object o)
	{
		if (o instanceof StatButton)
		{
			return true;
		}
		return false;
	}

}
