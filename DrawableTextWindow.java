package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface DrawableTextWindow
{
	public abstract TextureRegion getBackgroundField();
	public abstract int getxPosition();
	public abstract int getyPosition();
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract String getText();
	public abstract BitmapFont getFont();
}
