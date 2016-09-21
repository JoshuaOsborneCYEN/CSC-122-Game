package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class IntroWindow implements DrawableTextWindow
{
	private static Texture background;
	private TextureRegion backgroundField;
	
	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Old English.ttf"));
	private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;
	private String text;
	private BitmapFont font;
	
	private String backgroundName;
	
	public IntroWindow()
	{
		background = new Texture("backgrounds/optionBackground.png");
		backgroundField = new TextureRegion(background, 400, 300);
		backgroundField.setRegion(background);
		
		parameter.size = 40;
		parameter.color = Color.GOLD;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font = generator.generateFont(parameter);
		generator.dispose();
		this.xPosition = 60;
		this.yPosition = 500;
		this.height = 1040 - yPosition;
		this.width = 1800;
	}

	public int getxPosition()
	{
		return xPosition;
	}

	public void setxPosition(int xPosition)
	{
		this.xPosition = xPosition;
	}

	public int getyPosition()
	{
		return yPosition;
	}

	public void setyPosition(int yPosition)
	{
		this.yPosition = yPosition;
	}

	public void setPosition(int x, int y)
	{
		this.xPosition = x;
		this.yPosition = y;
	}
	
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	
	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
		
	}

	public BitmapFont getFont()
	{
		return font;
	}
	
	public void setIntroBackground(String backgroundName)
	{
		background.dispose();
		background = new Texture(backgroundName);
		backgroundField = new TextureRegion(background, 400, 300);
		backgroundField.setRegion(background);
	}

	public TextureRegion getBackgroundField()
	{
		return backgroundField;
	}	
}