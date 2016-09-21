package com.spiders_skeletons_shenanigans.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Audio
{
	// MUSIC
	private static Music TitleScreenTOslide4 = Gdx.audio.newMusic(Gdx.files.internal("sounds/4hands.mp3"));
	private static Music slide5TOslide9 = Gdx.audio.newMusic(Gdx.files.internal("sounds/april.mp3"));
	private static Music slide10TOslide14 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Vox Vulgaris - Stella splendens.mp3"));
	private static Music slide15TOslide18 = Gdx.audio.newMusic(Gdx.files.internal("sounds/mylady.mp3"));
	private static Music slide19TOslide24 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Vox Vulgaris - Rgibberish.mp3"));
	private static Music slide25TOslide30 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Vox Vulgaris - La Suite Meurtrire.mp3"));
	private static Music slide31TOslide34 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Omnia - Etrezomp-ni Kelted.mp3"));
	private static Music slide35TOslide37 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/The Final Battle - Epic Orchestral Music.mp3"));
	private static Music slide38TOslide39 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Omnia - The Bold Fenian Men.mp3"));
	// SOUND EFFECTS
	private static Music slide26TOslide29 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/rage_of_blades-Blaga_Saun-1763516257.mp3"));
	private static Music slide32TOslide33 = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/rage_of_blades-Blaga_Saun-1763516257.mp3"));
	private static Music option14B = Gdx.audio
			.newMusic(Gdx.files.internal("sounds/Tortured Person Screaming-SoundBible.com-63498375.mp3"));

	public static void playMusic(String s)
	{
		switch (s)
		{
			case "TitleScreenTOslide4":
				stopMusic();
				TitleScreenTOslide4.setLooping(true);
				TitleScreenTOslide4.play();
				break;
			case "slide5TOslide9":
				stopMusic();
				slide5TOslide9.setLooping(true);
				slide5TOslide9.play();
				break;
			case "slide10TOslide14":
				stopMusic();
				slide10TOslide14.setLooping(true);
				slide10TOslide14.play();
				break;
			case "slide15TOslide18":
				stopMusic();
				slide15TOslide18.setLooping(true);
				slide15TOslide18.play();
				break;
			case "slide19TOslide24":
				stopMusic();
				slide19TOslide24.setLooping(true);
				slide19TOslide24.play();
				break;
			case "slide25TOslide30":
				stopMusic();
				slide25TOslide30.setLooping(true);
				slide25TOslide30.play();
				break;
			case "slide31TOslide34":
				stopMusic();
				slide31TOslide34.setLooping(true);
				slide31TOslide34.play();
				break;
			case "slide35TOslide37":
				stopMusic();
				slide35TOslide37.setLooping(true);
				slide35TOslide37.play();
				break;
			case "slide38TOslide39":
				stopMusic();
				slide38TOslide39.setLooping(true);
				slide38TOslide39.play();
				break;
			// sound effects
			case "slide26TOslide29":
				slide26TOslide29.setLooping(true);
				slide26TOslide29.play();
				break;
			case "slide32TOslide33":
				slide32TOslide33.setLooping(true);
				slide32TOslide33.play();
				break;
			case "option14B":
				option14B.play();
				break;
		}
	}

	public static void stopMusic()
	{
		TitleScreenTOslide4.stop();
		slide5TOslide9.stop();
		slide10TOslide14.stop();
		slide15TOslide18.stop();
		slide19TOslide24.stop();
		slide25TOslide30.stop();
		slide31TOslide34.stop();
		slide35TOslide37.stop();
		slide38TOslide39.stop();
		slide26TOslide29.stop();
		slide32TOslide33.stop();

	}

	public static void dispose()
	{
		TitleScreenTOslide4.dispose();
		slide5TOslide9.dispose();
		slide10TOslide14.dispose();
		slide15TOslide18.dispose();
		slide19TOslide24.dispose();
		slide25TOslide30.dispose();
		slide31TOslide34.dispose();
		slide35TOslide37.dispose();
		slide38TOslide39.dispose();
		slide26TOslide29.dispose();
		slide32TOslide33.dispose();

	}
}
