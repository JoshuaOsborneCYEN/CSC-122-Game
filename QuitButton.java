package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class QuitButton extends Option implements DrawableTextWindow
{
	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Old English.ttf"));
	private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	private BitmapFont font;

	public QuitButton()
	{
		super();
		this.setPosition(420, 10);
		this.setHeight(commonOptionHeight);
		this.setWidth(300);
		this.setText("Quit");

		parameter.size = 45;
		parameter.color = Color.GOLD;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font = generator.generateFont(parameter);
	}

	public BitmapFont getFont()
	{
		return font;
	}
	
	public Level resolve()
	{
		System.exit(0);
		return null;
	}
	

	public boolean equals(Object o)
	{
		if (o instanceof QuitButton)
		{
			return true;
		}
		return false;
	}
}
