package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Joshua Osborne
 * @version 5-4-16
 * Primary superclass and main interaction object for the game. Users
 * click on the GUI implementation of Option, which knows where the next
 * level is and also contains the text it will display to the user. 
 * 
 * May or may not contain audio.
 */
public class Option implements DrawableTextWindow
{
	private String text;
	private String audioName;

	private static Texture background = new Texture("backgrounds/optionBackground.png");
	private TextureRegion backgroundField = new TextureRegion(background, 400, 300);
	
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;
	protected static int commonOptionHeight = 50;
	private Rectangle clickBox;
	
	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Old English.ttf"));
	private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	private BitmapFont font;
	
	private Level nextLevel;
	
	public Option()
	{
		this.text = "Continue...";
		initialize();
	}
	
	public Option(String text)
	{
		this.text = TextChoice.findOption(text);
		initialize();
	}

	protected void initialize()
	{
		audioName = null;
		backgroundField.setRegion(background);
		clickBox = new Rectangle();
		parameter.size = 45;
		parameter.color = Color.GOLD;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font = generator.generateFont(parameter);
		generator.dispose();
	}
	
	public Texture getBackgroundTexture()
	{
		return background;
	}
	
	public TextureRegion getBackgroundField()
	{
		return backgroundField;
	}

	public void setBackgroundField(int x, int y, int width, int height)
	{
		backgroundField.setRegion(x, y, width, height);
	}

	public Rectangle getClickBox()
	{
		return clickBox;
	}

	public void setBackgroundTexture(Texture backgroundTexture)
	{
		Option.background = backgroundTexture;
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

	public Level getNextLevel()
	{
		return nextLevel;
	}

	/**
	 * Set the next level the player will go to after clicking this option.
	 * 
	 * If the option is of subclass "Consequence," this is the level the player
	 * will go to if he does not have the string set by a "FutureChanger."
	 * 
	 * If the option is of subclass "StatCheck," this is the level the player will
	 * go to if his stat surpasses the threshold.
	 * 
	 * @param nextLevel the next level, under normal conditions, the player will go to when clicked.
	 */
	public void setNextLevel(Level nextLevel)
	{
		this.nextLevel = nextLevel;
	}
	
	//sets position on screen as (x,y), bottom left corner
	public void setPosition(int x, int y)
	{
		xPosition = x;
		yPosition = y;
		clickBox.setX(x);
		clickBox.setY(y);
	}
	
	//returns where this object is on screen as an array[x, y]
	public int[] getPosition()
	{
		return new int[] {xPosition, yPosition};
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

	public int getWidth()
	{
		return width;
	}
	

	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Set the dimensions of the GUI version of the option.
	 * @param width x-length
	 * @param height y-length
	 */
	public void setDimensions(int width, int height)
	{
		this.width = width;
		this.height = height;
		clickBox.setWidth(width);
		clickBox.setHeight(height);
	}

	public void setWidth(int width)
	{
		this.width = width;
		clickBox.setWidth(width);
	}

	public void setHeight(int height)
	{
		this.height = height;
		clickBox.setHeight(height);
	}

	@Override
	public String toString()
	{
		return "Option [xPosition=" + xPosition + ", yPosition=" + yPosition + ", width=" + width
				+ ", height=" + height + ", nextLevel=" + nextLevel.toString() + "]";
	}

	public Level resolve()
	{
		return nextLevel;
	}	
}