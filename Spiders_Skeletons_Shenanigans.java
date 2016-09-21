package com.spiders_skeletons_shenanigans.game;

import java.util.ArrayList;
import java.util.HashMap;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.utils.Align;

/**
 * @author Joshua Osborne Main logic and execution class for the game. Starts
 *         and maintains levels and updates the GUI.
 */
public class Spiders_Skeletons_Shenanigans extends ApplicationAdapter
{
	public static final int GAME_WIDTH = 1920;
	public static final int GAME_HEIGHT = 1080;
	private int gameState;
	private SpriteBatch batch;
	public static ArrayList<Level> gameLevels;
	private Player player;
	private Texture background;
	private IntroWindow introWindow;
	private Level currentLevel;
	private OrthographicCamera camera;
	//private TextField nameInputField;
	
	//private FreeTypeFontGenerator mainGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Old English.ttf"));
	//private FreeTypeFontParameter mainParameter = new FreeTypeFontParameter();
	//private BitmapFont mainFont;
	//private TextFieldStyle nameInputFieldStyle = new TextFieldStyle();
	private ArrayList<Option> currentOptions;
	private StatButton statButton;
	private QuitButton quitButton;

	// private TextChoice tc = new TextChoice();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationAdapter#create()
	 */
	@Override
	public void create()
	{
		Gdx.input.setInputProcessor(new MyInputProcessor());

		camera = new OrthographicCamera();
		camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);

		player = new Player("Gorthalon");
		batch = new SpriteBatch();
		gameLevels = new ArrayList<Level>();
		currentOptions = new ArrayList<Option>();
		
		//mainParameter.size = 45;
		//mainParameter.color = Color.GOLD;
		//mainParameter.borderColor = Color.BLACK;
		//mainParameter.borderWidth = 3;
		//mainFont = mainGenerator.generateFont(mainParameter);
		//mainGenerator.dispose();

		introWindow = new IntroWindow();
		//nameInputFieldStyle.fontColor = Color.GOLD;
		//nameInputFieldStyle.font = new BitmapFont();
		//nameInputField = new TextField("Enter your name here:", nameInputFieldStyle);
		//mStage.addActor(nameinputField);

		initializeLevels();
		
		Audio.playMusic("TitleScreenTOSlide4");
	}

	/**
	 * Creates all the levels and options for the game, initializing all the
	 * game's data.
	 */
	private void initializeLevels()
	{
		// options for restart level
		Level restartLevel = new Level("Restart Level");
		restartLevel.setIntroText("It looks like you died horribly. Would you like to play again from the beginning?");
		restartLevel.setBackground("backgrounds/black.jpg");
		Option restartGameOption = new RestartOption();
		restartLevel.addOption(restartGameOption);
		
		//instantiate levels
		Level titleLevel = new Level("Title Screen");
		titleLevel.setIntroText("Welcome to Spiders, Skeletons, and Shenanigans! Prepare for a grisly adventure full of death and gore. Good luck, and remember to play to your strengths as you develop your character!");
		titleLevel.setBackground("backgrounds/black.jpg");
		
		Level level0 = new Level("Intro Level", "INTROtoGAME", "backgrounds/Dungeon room with torches.jpg");
		level0.setAudioName("TitleScreenTOslide4");
		Level level1 = new Level("Level 1", "OUTCOMEofNAME", "backgrounds/tunnel base.jpg");
		//level1.setAudioName("TitleScreenTOslide4");
		Level level2p1 = new Level("Level 2 Part 2", "INTROtoO2p1", "backgrounds/tunnel base.jpg");
		Level level2p2 = new Level("Level 2 Part 2", "INTROtoO2p2", "backgrounds/tunnel base.jpg");
		Level level2CBOutcome = new Level ("Level 2 CB Outcome", "OUTCOMEofO2CB", "backgrounds/tunnel base.jpg");
		Level level3 = new Level("Level 3", "INTROtoO3", "backgrounds/tunnel base.jpg");
		Level level4 = new Level("Level 4", "INTROtoO4", "backgrounds/tunnel base.jpg");
		Level level4CAOutcome = new Level("Level 4 CA Outcome", "OUTCOMEofO4CA", "backgrounds/tunnel base.jpg");
		Level level4CBOutcome = new Level("Level 4 CB Outcome", "OUTCOMEofO4CB", "backgrounds/tunnel base.jpg");
		Level level4t1 = new Level("Level 4 transition 1", "TRANSITIONfrom4TO5p1", "backgrounds/tunnel base.jpg");
		level4t1.setAudioName("slide5TOslide9");
		Level level4t2 = new Level("Level 4 transition 2", "TRANSITIONfrom4TO5p2", "backgrounds/tunnel base.jpg");
		Level level4t3 = new Level("Level 4 transition 3", "TRANSITIONfrom4TO5p3", "backgrounds/tunnel base.jpg");
		Level level4t4 = new Level("Level 4 transition 4", "TRANSITIONfrom4TO5p4", "backgrounds/tunnel base.jpg");
		Level level4t5 = new Level("Level 4 transition 5", "TRANSITIONfrom4TO5p5", "backgrounds/tunnel base.jpg");
		Level level4t6 = new Level("Level 4 transition 6", "TRANSITIONfrom4TO5p6", "backgrounds/rocky hills.jpg");
		Level level4t7 = new Level("Level 4 transition 7", "TRANSITIONfrom4TO5p7", "backgrounds/rocky hills.jpg");
		Level level5 = new Level("Level 5", "INTROtoO5", "backgrounds/town street on fire.jpg");
		Level level5CAOutcome = new Level("Level 5 CA Outcome", "OUTCOMEofO5CA", "backgrounds/town street on fire.jpg");
		Level level5CBOutcome = new Level("Level 5 CB Outcome", "OUTCOMEofO5CB", "backgrounds/town street on fire.jpg");
		level5CBOutcome.setAudioName("slide10TOslide14");
		Level level5t1 = new Level("Level 5 transition 1", "TRANSITIONfrom5TO6p1", "backgrounds/town street on fire.jpg");
		Level level5t2 = new Level("Level 5 transition 2", "TRANSITIONfrom5TO6p2", "backgrounds/town street on fire.jpg");
		Level level6 = new Level("Level 6", "INTROtoO6", "backgrounds/town street on fire.jpg");
		Level level6CAOutcome = new Level("Level 6 Outcome A", "OUTCOMEofO6CA", "backgrounds/town street on fire.jpg");
		Level level6CBOutcome = new Level("Level 6 Outcome B", "OUTCOMEofO6CB", "backgrounds/town street on fire.jpg");
		Level level6CCOutcome = new Level("Level 6 Outcome C", "OUTCOMEofO6CC", "backgrounds/town street on fire.jpg");
		Level level6Failure = new Level("Level 6 Failure", "FAILUREofO6", "backgrounds/town street on fire.jpg");
		Level level7 = new Level("Level 7", "INTROtoO7", "backgrounds/town street on fire.jpg");
		Level level7CAOutcome = new Level("Level 7 Outcome A", "OUTCOMEofO7CA", "backgrounds/town street on fire.jpg");
		Level level7CBOutcome = new Level("Level 7 Outcome B", "OUTCOMEofO7CB", "backgrounds/town street on fire.jpg");
		level7CBOutcome.setAudioName("option14B");
		Level level7CCOutcome = new Level("Level 7 Outcome C", "OUTCOMEofO7CC", "backgrounds/town street on fire.jpg");
		Level level7t1 = new Level("Level 7 Transition 1", "TRANSITIONfrom7TO8p1", "backgrounds/Pub.jpg");
		level7t1.setAudioName("slide15TOslide18");
		Level level7t2 = new Level("Level 7 Transition 2", "TRANSITIONfrom7TO8p2", "backgrounds/Pub.jpg");
		Level level7t3 = new Level("Level 7 Transition 3", "TRANSITIONfrom7TO8p3", "backgrounds/Pub.jpg");
		Level level7t4 = new Level("Level 7 Transition 4", "TRANSITIONfrom7TO8p4", "backgrounds/Pub.jpg");
		Level level7t5 = new Level("Level 7 Transition 5", "TRANSITIONfrom7TO8p5", "backgrounds/Pub.jpg");
		Level level7t6 = new Level("Level 7 Transition 6", "TRANSITIONfrom7TO8p6", "backgrounds/Pub.jpg");
		Level level7t7 = new Level("Level 7 Transition 7", "TRANSITIONfrom7TO8p7", "backgrounds/Pub.jpg");
		Level level7t8 = new Level("Level 7 Transition 8", "TRANSITIONfrom7TO8p8", "backgrounds/Pub.jpg");
		Level level7t9 = new Level("Level 7 Transition 9", "TRANSITIONfrom7TO8p9", "backgrounds/Pub.jpg");
		Level level7t10 = new Level("Level 7 Transition 10", "TRANSITIONfrom7TO8p10", "backgrounds/Pub.jpg");
		Level level8 = new Level("Level 8", "INTROtoO8", "backgrounds/Pub.jpg");
		Level level8CAOutcome = new Level("Level 8 Outcome A", "OUTCOMEofO8CA", "backgrounds/Pub.jpg");
		Level level8CBOutcome = new Level("Level 8 Outcome B", "OUTCOMEofO8CB", "backgrounds/Pub.jpg");
		Level level8CCOutcome = new Level("Level 8 Outcome C", "OUTCOMEofO8CC", "backgrounds/Pub.jpg");
		Level level9 = new Level("Level 9", "INTROtoO9", "backgrounds/road.jpg");
		level9.setAudioName("slide19TOslide24");
		Level level9t1 = new Level("Level 9 Transition 1", "TRANSITIONfrom9TO10p1", "backgrounds/road.jpg");
		Level level9t2 = new Level("Level 9 Transition 2", "TRANSITIONfrom9TO10p2", "backgrounds/road.jpg");
		Level level9t3 = new Level("Level 9 Transition 3", "TRANSITIONfrom9TO10p3", "backgrounds/road.jpg");
		Level level9t4 = new Level("Level 9 Transition 4", "TRANSITIONfrom9TO10p4", "backgrounds/forge.jpg");
		Level level9t5 = new Level("Level 9 Transition 5", "TRANSITIONfrom9TO10p5", "backgrounds/forge.jpg");
		Level level10 = new Level("Level 10", "INTROtoO10", "backgrounds/forge.jpg");
		Level level10CAOutcome = new Level("Level 10 Outcome A", "OUTCOMEofO10CA", "backgrounds/forge.jpg");
		Level level10CBOutcomeSuccess = new Level("Level 10 Outcome B", "OUTCOMEofO10CBsucceed", "backgrounds/forge.jpg");
		Level level10CBOutcomeFailure = new Level("Level 10 Outcome B Failure", "OUTCOMEofO10CBfail", "backgrounds/forge.jpg");
		Level level10t1 = new Level("Level 10 Transition 1", "TRANSITIONfrom10TO11p1", "backgrounds/town street.jpg");
		Level level10t2 = new Level("Level 10 Transition 2", "TRANSITIONfrom10TO11p2", "backgrounds/town street.jpg");
		Level level11 = new Level("Level 11", "INTROtoO11", "backgrounds/town street.jpg");
		level11.setAudioName("slide25TOslide30");
		Level level11CAorBOutcomeFailure = new Level("Level 11 CAorB Failure", "OUTCOMEofO11CAfail", "backgrounds/town street on fire.jpg");
		level11CAorBOutcomeFailure.setAudioName("slide26TOslide29");
		Level level11CASuccess = new Level("Level 11 CA Outcome Success", "OUTCOMEofO11CA", "backgrounds/town street on fire.jpg");
		level11CASuccess.setAudioName("slide26TOslide29");
		Level level11CBSuccess = new Level("Level 11 CB Outcome Success", "OUTCOMEofO11CB", "backgrounds/town street on fire.jpg");
		level11CBSuccess.setAudioName("slide26TOslide29");
		Level level11CCOutcome = new Level("Level 11 CC Outcome", "OUTCOMEofO11CC", "backgrounds/town street on fire.jpg");
		Level level12 = new Level("Level 12", "INTROtoO12", "backgrounds/town street on fire.jpg");
		Level level12CAOutcome = new Level("Level 12 CA Outcome", "OUTCOMEofO12CA", "backgrounds/town street on fire.jpg");
		Level level12CBOutcome = new Level("Level 12 CB Outcome", "OUTCOMEofO12CB", "backgrounds/town street on fire.jpg");
		Level level12CCOutcomep1 = new Level("Level 12 CC Outcome p1", "OUTCOMEofO12CCp1", "backgrounds/town street on fire.jpg");
		Level level12CCOutcomep2 = new Level("Level 12 CC Outcome p2", "OUTCOMEofO12CCp2", "backgrounds/town street on fire.jpg");
		Level level12Failure = new Level("Level 12 Failure", "OUTCOMEofO12fail", "backgrounds/town street on fire.jpg");	
		Level level12t1 = new Level("Level 12 Transition 1", "TRANSITIONfrom12TO13p1", "backgrounds/town street on fire.jpg");
		Level level12t2 = new Level("Level 12 Transition 2", "TRANSITIONfrom12TO13p2", "backgrounds/town street on fire.jpg");
		Level level12t3 = new Level("Level 12 Transition 3", "TRANSITIONfrom12TO13p3", "backgrounds/town street.jpg");
		level12t3.setAudioName("slide25TOslide30");
		
		Level level12t4 = new Level("Level 12 Transition 4", "TRANSITIONfrom12TO13p4", "backgrounds/road.jpg");
		level12t4.setAudioName("slide31TOslide34");
		Level level12t5 = new Level("Level 12 Transition 5", "TRANSITIONfrom12TO13p5", "backgrounds/road.jpg");
		Level level13intro1 = new Level("Level 13 Intro 1", "INTROtoO13p1", "backgrounds/castle.jpg");
		level13intro1.setAudioName("slide32TOslide33");
		Level level13intro2 = new Level("Level 13 Intro 2", "INTROtoO13p2", "backgrounds/castle.jpg");
		Level level13CAIntro = new Level("Level 13 CAIntro", "INTROtoO13CA", "backgrounds/castle.jpg");
		Level level13CASuccess = new Level("Level 13 CASuccess", "OUTCOMEofO13CAsucceed", "backgrounds/castle on fire.jpg");
		Level level13CAFail = new Level("Level 13 CAFail", "OUTCOMEofO13CAfail", "backgrounds/castle on fire.jpg");
		Level level13CBOutcome = new Level("Level 13 CBOutcome", "OUTCOMEofO13CB", "backgrounds/castle on fire.jpg");
		Level level13CBSuccess = new Level("Level 13 CBSuccess", "OUTCOMEofO13CBsucceed", "backgrounds/castle on fire.jpg");
		Level level13CBFail = new Level("Level 13 CBFail", "OUTCOMEofO13CBfail", "backgrounds/castle on fire.jpg");
		Level level13t1 = new Level("Level 13 Transition 1", "TRANSITIONfrom13TO14p1", "backgrounds/castle on fire.jpg");
		//level13t1.setAudioName("slide31TOslide34");
		Level level13t2 = new Level("Level 13 Transition 2", "TRANSITIONfrom13TO14p2", "backgrounds/throne room.jpg");
		level13t2.setAudioName("slide35TOslide37");
		Level level13t3 = new Level("Level 13 Transition 3", "TRANSITIONfrom13TO14p3", "backgrounds/throne room.jpg");
		Level level13t4True = new Level("Level 13 Transition 4", "TRANSITIONfrom13TO14p4TRUE", "backgrounds/throne room.jpg");
		Level level13t4False = new Level("Level 13 Transition 4", "TRANSITIONfrom13TO14p4FALSE", "backgrounds/throne room.jpg");
		Level level13t5 = new Level("Level 13 Transition 5", "TRANSITIONfrom13TO14p5", "backgrounds/throne room.jpg");
		Level level13t6True = new Level("Level 13 Transition 6", "TRANSITIONfrom13TO14p6TRUE", "backgrounds/throne room.jpg");
		Level level13t6False = new Level("Level 13 Transition 6", "TRANSITIONfrom13TO14p6FALSE", "backgrounds/throne room.jpg");
		Level level13t7 = new Level("Level 13 Transition 7", "TRANSITIONfrom13TO14p7", "backgrounds/throne room.jpg");
		level13t7.setAudioName("slide38TOslide39");
		Level level13t8 = new Level("Level 13 Transition 8", "TRANSITIONfrom13TO14p8", "backgrounds/throne room.jpg");
		
		Level level14 = new Level("Level 14", "INTROtoO14", "backgrounds/throne room.jpg");
		Level level14CAOutcome = new Level("Level 14 CA Outcome", "OUTCOMEofO14CA", "backgrounds/throne room.jpg");
		Level level14CBOutcome = new Level("Level 14 CB Outcome", "OUTCOMEofO14CB", "backgrounds/throne room.jpg");
		Level level14CCOutcomep1 = new Level("Level 14 CC Outcome p1", "OUTCOMEofO14CCp1", "backgrounds/throne room.jpg");
		Level level14CCOutcomep2 = new Level("Level 14 CC Outcome p2", "OUTCOMEofO14CCp2", "backgrounds/throne room.jpg");
		Level level14t1 = new Level("Level 14 Transition 1", "TRANSITIONfrom14", "backgrounds/throne room.jpg");
		
		Level endgameLevel = new Level("Game Over!");
		endgameLevel.setIntroText("Congratulations, you have won the game! Though you did some seriously messed up things"
				+ " and still have a spider in your brain. Would you like to play again?");
		endgameLevel.setBackground("backgrounds/black.jpg");
		endgameLevel.addOption(restartGameOption);
		
		//setup level introductions; yes those are letter Os not zeros.
		Option titleOption = new Option();
		titleOption.setText("Begin");
		titleOption.setNextLevel(level0);
		titleLevel.addOption(titleOption);
		
		// option for level 0
		Option level0CA = new Option();
		level0CA.setNextLevel(level1);
		level0.addOption(level0CA);
		
		// options for level 1
		HashMap<String, Integer> knightStats = new HashMap<String, Integer>();
		knightStats.put("Strength", 75);
		knightStats.put("Leadership", 60);
		Option level1CA = new RoleChoice("O1CA", knightStats);
		level1CA.setNextLevel(level2p1);
		level1.addOption(level1CA);

		HashMap<String, Integer> wizardStats = new HashMap<String, Integer>();
		wizardStats.put("Magic", 75);
		wizardStats.put("Intelligence", 60);
		Option level1CB = new RoleChoice("O1CB", wizardStats);
		level1CB.setNextLevel(level2p1);
		level1.addOption(level1CB);

		HashMap<String, Integer> thiefStats = new HashMap<String, Integer>();
		thiefStats.put("Agility", 75);
		thiefStats.put("Intelligence", 60);
		Option level1CC = new RoleChoice("O1CC", thiefStats);
		level1CC.setNextLevel(level2p1);
		level1.addOption(level1CC);

		// options for level 2
		Option level2Cont = new Option();
		level2Cont.setNextLevel(level2p2);
		level2p1.addOption(level2Cont);		
		
		Option level2CA = new Option("O2CA");
		level2CA.setNextLevel(level3);
		level2p2.addOption(level2CA);

		Option level2CB = new Option("O2CB");
		level2CB.setNextLevel(level2CBOutcome);
		level2p2.addOption(level2CB);
		
		// options for outcome of level 2 CB
		FutureChanger level2CBOutLoot = new FutureChanger("LOOT");
		level2CBOutLoot.setNextLevel(level3);
		level2CBOutcome.addOption(level2CBOutLoot);
		
		// options for level 3
		StatChanger level3CA = new StatChanger("O3CA", "Leadership", 10);
		level3CA.setNextLevel(level4);
		level3.addOption(level3CA);
		
		StatChanger level3CB = new StatChanger("O3CB", "Intelligence", 10);
		level3CB.setNextLevel(level4);
		level3.addOption(level3CB);
		
		// options for level 4
		Option level4CA = new Option("O4CA");
		level4CA.setNextLevel(level4t1);
		//level4CA.setAudioName("slide5TOslide9");
		level4.addOption(level4CA);
		
		Option level4CB = new Option("O4CB");
		level4CB.setNextLevel(level4t1);
		//level4CB.setAudioName("slide5TOslide9");
		level4.addOption(level4CB);

		// options for level 4 outcomes
		Option level4CAorBContinue = new Option();
		level4CAorBContinue.setNextLevel(level4t1);
		level4CAOutcome.addOption(level4CAorBContinue);
		level4CBOutcome.addOption(level4CAorBContinue);
		
		// options for level 4 transition 1
		Option level4t1Continue = new Option();
		level4t1Continue.setNextLevel(level4t2);
		level4t1.addOption(level4t1Continue);
		
		// options for level 4 transition 2
		Option level4t2Continue = new Option();
		level4t2Continue.setNextLevel(level4t3);
		level4t2.addOption(level4t2Continue);
		
		// options for level 4 transition 3
		Option level4t3Continue = new Option();
		level4t3Continue.setNextLevel(level4t4);
		level4t3.addOption(level4t3Continue);
		
		// options for level 4 transition 4 that may skip next level
		Consequence level4t4Continue = new Consequence("LOOT");
		level4t4Continue.setNextLevel(level4t6);
		level4t4Continue.setAlternateLevel(level4t5);
		level4t4.addOption(level4t4Continue);
		
		// option for level 4 transition 5 if corpses were looted
		Option level4t5Continue = new Option();
		level4t5Continue.setNextLevel(level4t6);
		level4t5.addOption(level4t5Continue);
		
		// option for level 4 transition 6
		Option level4t6Continue = new Option();
		level4t6Continue.setNextLevel(level4t7);
		level4t6.addOption(level4t6Continue);
		
		// option for level 4 transition 7
		Option level4t7Continue = new Option();
		level4t7Continue.setNextLevel(level5);
		level4t7.addOption(level4t7Continue);
		
		// options for level 5
		Option level5CA = new Option("O5CA");
		level5CA.setNextLevel(level5CAOutcome);
		level5.addOption(level5CA);
		
		Option level5CB = new Option("O5CB");
		level5CB.setNextLevel(level5CBOutcome);
		level5.addOption(level5CB);
		
		// option for level 5 choice A outcome
		Option level5CAOutcomeContinue = new Option();
		level5CAOutcomeContinue.setNextLevel(restartLevel);
		level5CAOutcome.addOption(level5CAOutcomeContinue);
		
		// option for level 5 choice B outcome
		Option level5CBOutcomeContinue = new Option();
		level5CBOutcomeContinue.setNextLevel(level5t1);
		level5CBOutcome.addOption(level5CBOutcomeContinue);
		
		// option for level 5 transition 1
		Option level5t1Continue = new Option();
		level5t1Continue.setNextLevel(level5t2);
		level5t1.addOption(level5t1Continue);
		
		// option for level 5 transition 2
		Option level5t2Continue = new Option();
		level5t2Continue.setNextLevel(level6);
		level5t2.addOption(level5t2Continue);
		
		// options for level 6
		StatCheck level6CA = new StatCheck("O6CA", "Strength", 70);
		level6CA.setNextLevel(level6CAOutcome);
		level6CA.setFailureLevel(level6Failure);
		level6.addOption(level6CA);

		StatCheck level6CB = new StatCheck("O6CB", "Magic", 70);
		level6CB.setNextLevel(level6CBOutcome);
		level6CB.setFailureLevel(level6Failure);
		level6.addOption(level6CB);
		
		StatCheck level6CC = new StatCheck("O6CC", "Agility", 70);
		level6CC.setNextLevel(level6CCOutcome);
		level6CC.setFailureLevel(level6Failure);
		level6.addOption(level6CC);
		
		// level 6 outcomes
		Option level6CAOutcomeCont = new Option();
		level6CAOutcomeCont.setNextLevel(level7);
		level6CAOutcome.addOption(level6CAOutcomeCont);	
		
		Option level6CBOutcomeCont = new Option();
		level6CBOutcomeCont.setNextLevel(level7);
		level6CBOutcome.addOption(level6CBOutcomeCont);	
		
		Option level6CCOutcomeCont = new Option();
		level6CCOutcomeCont.setNextLevel(level7);
		level6CCOutcome.addOption(level6CCOutcomeCont);	
		
		Option level6FailureCont = new Option();
		level6FailureCont.setNextLevel(restartLevel);
		level6Failure.addOption(level6FailureCont);
		
		//options for level 7
		Option level7CA = new Option("O7CA");
		level7CA.setNextLevel(level7CAOutcome);
		level7.addOption(level7CA);

		Option level7CB = new Option("O7CB");
		level7CB.setNextLevel(level7CBOutcome);
		level7.addOption(level7CB);
		
		Option level7CC = new Option("O7CC");
		level7CC.setNextLevel(level7CCOutcome);
		level7.addOption(level7CC);
		
		// level 7 outcomes
		Option level7CAOutcomeCont = new Option();
		level7CAOutcomeCont.setNextLevel(level7t1);
		level7CAOutcome.addOption(level7CAOutcomeCont);	
		
		Option level7CBOutcomeCont = new Option();
		level7CBOutcomeCont.setNextLevel(restartLevel);
		level7CBOutcome.addOption(level7CBOutcomeCont);	
		
		FutureChanger level7CCOutcomeCont = new FutureChanger("MERCY");
		level7CCOutcomeCont.setNextLevel(level7t1);
		level7CCOutcome.addOption(level7CCOutcomeCont);	
		
		//level 7 transition levels
		Option level7t1Continue = new Option();
		level7t1Continue.setNextLevel(level7t2);
		level7t1.addOption(level7t1Continue);

		Option level7t2Continue = new Option();
		level7t2Continue.setNextLevel(level7t3);
		level7t2.addOption(level7t2Continue);

		Option level7t3Continue = new Option();
		level7t3Continue.setNextLevel(level7t4);
		level7t3.addOption(level7t3Continue);

		Consequence level7t4Continue = new Consequence("LOOT");
		level7t4Continue.setNextLevel(level7t6);
		level7t4Continue.setAlternateLevel(level7t5);
		level7t4.addOption(level7t4Continue);

		Option level7t5Continue = new Option();
		level7t5Continue.setNextLevel(level7t6);
		level7t5.addOption(level7t5Continue);

		Option level7t6Continue = new Option();
		level7t6Continue.setNextLevel(level7t7);
		level7t6.addOption(level7t6Continue);

		Option level7t7Continue = new Option();
		level7t7Continue.setNextLevel(level7t8);
		level7t7.addOption(level7t7Continue);

		Option level7t8Continue = new Option();
		level7t8Continue.setNextLevel(level7t9);
		level7t8.addOption(level7t8Continue);

		Consequence level7t9Continue = new Consequence("MERCY");
		level7t9Continue.setNextLevel(level8);
		level7t9Continue.setAlternateLevel(level7t10);
		level7t9.addOption(level7t9Continue);

		Option level7t10Continue = new Option();
		level7t10Continue.setNextLevel(level8);
		level7t10.addOption(level7t10Continue);
		
		//Finally on level 8
		StatChanger level8CA = new StatChanger("O8CA", "Wealth", 25);
		level8CA.setNextLevel(level8CAOutcome);
		level8.addOption(level8CA);

		StatChanger level8CB = new StatChanger("O8CB", "Wealth", 15);
		level8CB.setNextLevel(level8CBOutcome);
		level8.addOption(level8CB);
		
		Option level8CC = new Option("O8CC");
		level8CC.setNextLevel(level8CCOutcome);
		level8.addOption(level8CC);
		
		// level 8 outcomes
		Option level8CAOutcomeCont = new Option();
		level8CAOutcomeCont.setNextLevel(level9);
		level8CAOutcome.addOption(level8CAOutcomeCont);	
		
		Option level8CBOutcomeCont = new Option();
		level8CBOutcomeCont.setNextLevel(level9);
		level8CBOutcome.addOption(level8CBOutcomeCont);	
		
		Option level8CCOutcomeCont = new Option();
		level8CCOutcomeCont.setNextLevel(restartLevel);
		level8CCOutcome.addOption(level8CCOutcomeCont);
		
		//level 9 options
		StatChanger level9CA = new StatChanger("O9CA", "Intelligence", 10);
		level9CA.setNextLevel(level9t1);
		level9.addOption(level9CA);
		
		StatChanger level9CB = new StatChanger("O9CB", "Leadership", 10);
		level9CB.setNextLevel(level9t1);
		level9.addOption(level9CB);
		
		//level 9 transitions
		StatCheck level9t1Cont = new StatCheck("Wealth", 70);
		level9t1Cont.setNextLevel(level9t2);
		level9t1Cont.setFailureLevel(level9t3);
		level9t1.addOption(level9t1Cont);
		
		StatChanger level9t2Cont = new StatChanger("Leadership", 10);
		level9t2Cont.setNextLevel(level9t4);
		level9t2.addOption(level9t2Cont);
		
		Option level9t3Cont = new Option();
		level9t3Cont.setNextLevel(level9t4);
		level9t3.addOption(level9t3Cont);
		
		Option level9t4Cont = new Option();
		level9t4Cont.setNextLevel(level9t5);
		level9t4.addOption(level9t4Cont);
		
		Option level9t5Cont = new Option();
		level9t5Cont.setNextLevel(level10);
		level9t5.addOption(level9t5Cont);
		
		//level 10 options
		FutureChanger level10CA = new FutureChanger("O10CA", "MAD");
		level10CA.setNextLevel(level10CAOutcome);
		level10.addOption(level10CA);
		
		StatCheck level10CB = new StatCheck("O10CB", "Wealth", 70);
		level10CB.setNextLevel(level10CBOutcomeSuccess);
		level10CB.setFailureLevel(level10CBOutcomeFailure);
		level10.addOption(level10CB);
		
		//level 10 outcome options
		Option level10CAOutcomeCont = new StatChanger("Leadership", -10);
		level10CAOutcomeCont.setNextLevel(level10t1);
		level10CAOutcome.addOption(level10CAOutcomeCont);
		
		Option level10CBOutcomeSuccessCont = new StatAndFutureChanger("BLACKSMITH", "Leadership", 10);
		level10CBOutcomeSuccessCont.setNextLevel(level10t1);
		level10CBOutcomeSuccess.addOption(level10CBOutcomeSuccessCont);
		
		Option level10CBOutcomeFailureCont = new StatChanger("Leadership", -10);
		level10CBOutcomeFailureCont.setNextLevel(level10t1);
		level10CBOutcomeFailure.addOption(level10CBOutcomeFailureCont);
		
		//level 10 transitions
		Option level10t1Cont = new Option();
		level10t1Cont.setNextLevel(level10t2);
		level10t1.addOption(level10t1Cont);
		
		Option level10t2Cont = new Option();
		level10t2Cont.setNextLevel(level11);
		level10t2.addOption(level10t2Cont);
		
		//level 11 options
		StatAndConsequenceCheck level11CA = new StatAndConsequenceCheck("O11CA", "BLACKSMITH", "Intelligence", 70);
		level11CA.setNextLevel(level11CASuccess);
		level11CA.setFailureLevel(level11CAorBOutcomeFailure);
		level11.addOption(level11CA);
		
		StatAndConsequenceCheck level11CB = new StatAndConsequenceCheck("O11CB", "BLACKSMITH", "Leadership", 70);
		level11CB.setNextLevel(level11CBSuccess);
		level11CB.setFailureLevel(level11CAorBOutcomeFailure);
		level11.addOption(level11CB);
		
		Option level11CC = new Option("O11CC");
		level11CC.setNextLevel(level11CCOutcome);
		level11.addOption(level11CC);
		
		//level 11 outcomes
		Option level11CASuccessCont = new Option();
		level11CASuccessCont.setNextLevel(level12);
		level11CASuccess.addOption(level11CASuccessCont);
		
		Option level11CBSuccessCont = new Option();
		level11CBSuccessCont.setNextLevel(level12);
		level11CBSuccess.addOption(level11CBSuccessCont);
		
		Option level11CAorBOutcomeFailCont = new Option();
		level11CAorBOutcomeFailCont.setNextLevel(restartLevel);
		level11CAorBOutcomeFailure.addOption(level11CAorBOutcomeFailCont);
		
		Option level11CCOutcomeCont = new Option();
		level11CCOutcomeCont.setNextLevel(restartLevel);
		level11CCOutcome.addOption(level11CCOutcomeCont);
		
		//level 12 options
		StatCheck level12CA = new StatCheck("O12CA", "Strength", 70);
		level12CA.setNextLevel(level12CAOutcome);
		level12CA.setFailureLevel(level12Failure);
		level12.addOption(level12CA);

		StatCheck level12CB = new StatCheck("O12CB", "Magic", 70);
		level12CB.setNextLevel(level12CBOutcome);
		level12CB.setFailureLevel(level12Failure);
		level12.addOption(level12CB);
		
		StatCheck level12CC = new StatCheck("O12CC", "Agility", 70);
		level12CC.setNextLevel(level12CCOutcomep1);
		level12CC.setFailureLevel(level12Failure);
		level12.addOption(level12CC);
		
		//level 12 outcomes
		Option level12CAOutcomeCont = new Option();
		level12CAOutcomeCont.setNextLevel(level12t2);
		level12CAOutcome.addOption(level12CAOutcomeCont);
		
		Option level12CBOutcomeCont = new Option();
		level12CBOutcomeCont.setNextLevel(level12t2);
		level12CBOutcome.addOption(level12CBOutcomeCont);

		Option level12CCOutcomeContp1 = new Option();
		level12CCOutcomeContp1.setNextLevel(level12CCOutcomep2);
		level12CCOutcomep1.addOption(level12CCOutcomeContp1);

		Option level12CCOutcomeContp2 = new Option();
		level12CCOutcomeContp2.setNextLevel(level12t2);
		level12CCOutcomep2.addOption(level12CCOutcomeContp2);
		
		Option level12FailCont = new Option();
		level12FailCont.setNextLevel(restartLevel);
		level12Failure.addOption(level12FailCont);
		
		//transitions from level 12
		Option level12t1Cont = new Option();
		level12t1Cont.setNextLevel(level12t2);
		level12t1.addOption(level12t1Cont);
		
		Consequence level12t2Cont = new Consequence("BLACKSMITH");
		level12t2Cont.setNextLevel(level12t4);
		level12t2Cont.setAlternateLevel(level12t3);
		level12t2.addOption(level12t2Cont);
		
		Option level12t3Cont = new Option();
		level12t3Cont.setNextLevel(level12t4);
		level12t3.addOption(level12t3Cont);
		
		Option level12t4Cont = new Option();
		level12t4Cont.setNextLevel(level12t5);
		level12t4.addOption(level12t4Cont);
		
		Option level12t5Cont = new Option();
		level12t5Cont.setNextLevel(level13intro1);
		level12t5.addOption(level12t5Cont);
		
		//options for level 13
		Option level13intro1Cont = new Option();
		level13intro1Cont.setNextLevel(level13intro2);
		level13intro1.addOption(level13intro1Cont);
		
		Option level13CA = new Option("O13CA");
		level13CA.setNextLevel(level13CAIntro);
		level13intro2.addOption(level13CA);
		
		StatCheck level13CAIntroCont = new StatCheck("Leadership", 70);
		level13CAIntroCont.setNextLevel(level13CASuccess);
		level13CAIntroCont.setFailureLevel(level13CAFail);
		level13CAIntro.addOption(level13CAIntroCont);
		
		Option level13CB = new Option("O13CB");
		level13CB.setNextLevel(level13CBOutcome);
		level13intro2.addOption(level13CB);
		
		Consequence level13CBOutcomeCont = new Consequence("MERCY");
		level13CBOutcomeCont.setNextLevel(level13CBFail);
		level13CBOutcomeCont.setAlternateLevel(level13CBSuccess);
		level13CBOutcome.addOption(level13CBOutcomeCont);
		
		//transitions for level 13
		Option level13CASuccessCont = new Option();
		level13CASuccessCont.setNextLevel(level13t1);
		level13CASuccess.addOption(level13CASuccessCont);
		
		Option level13CAFailDeath = new Option();
		level13CAFailDeath.setNextLevel(restartLevel);
		level13CAFail.addOption(level13CAFailDeath);
		
		Option level13CBSuccessCont = new Option();
		level13CBSuccessCont.setNextLevel(level13t1);
		level13CBSuccess.addOption(level13CBSuccessCont);
		
		Option level13CBFailCont = new Option();
		level13CBFailCont.setNextLevel(level13t1);
		level13CBFail.addOption(level13CBFailCont);
		
		Option level13t1Cont = new Option();
		level13t1Cont.setNextLevel(level13t2);
		level13t1.addOption(level13t1Cont);
		
		Option level13t2Cont = new Option();
		level13t2Cont.setNextLevel(level13t3);
		level13t2.addOption(level13t2Cont);
		
		//resolving part of player's sword
		Consequence level13t3Cont = new Consequence("BLACKSMITH");
		level13t3Cont.setNextLevel(level13t4False);
		level13t3Cont.setAlternateLevel(level13t4True);
		level13t3.addOption(level13t3Cont);
		
		Option level13t4FalseCont = new Option();
		level13t4FalseCont.setNextLevel(restartLevel);
		level13t4False.addOption(level13t4FalseCont);
		
		Option level13t4TrueCont = new Option();
		level13t4TrueCont.setNextLevel(level13t5);
		level13t4True.addOption(level13t4TrueCont);
		
		//resolving part of player's wound
		Consequence level13t5Cont = new Consequence("LOOT");
		level13t5Cont.setNextLevel(level13t6False);
		level13t5Cont.setAlternateLevel(level13t6True);
		level13t5.addOption(level13t5Cont);
		
		Option level13t6FalseCont = new Option();
		level13t6FalseCont.setNextLevel(level13t7);
		level13t6False.addOption(level13t6FalseCont);
		
		Option level13t6TrueDeath = new Option();
		level13t6TrueDeath.setNextLevel(restartLevel);
		level13t6True.addOption(level13t6TrueDeath);
		
		//resolving mercy
		Consequence level13t7Cont = new Consequence("MERCY");
		level13t7Cont.setNextLevel(level14);
		level13t7Cont.setAlternateLevel(level13t8);
		level13t7.addOption(level13t7Cont);
		
		Option level13t8Death = new Option();
		level13t8Death.setNextLevel(restartLevel);
		level13t8.addOption(level13t8Death);
		
		//final level, level 14
		Option level14CA = new Option("O14CA");
		level14CA.setNextLevel(level14CAOutcome);
		level14.addOption(level14CA);
		
		Option level14CB = new Option("O14CB");
		level14CB.setNextLevel(level14CBOutcome);
		level14.addOption(level14CB);
		
		Option level14CC = new Option("O14CC");
		level14CC.setNextLevel(level14CCOutcomep1);
		level14.addOption(level14CC);
		
		//outcomes of level 14 choices
		Option level14CAOutcomeCont = new Option();
		level14CAOutcomeCont.setNextLevel(restartLevel);
		level14CAOutcome.addOption(level14CAOutcomeCont);
		
		Option level14CBOutcomeCont = new Option();
		level14CBOutcomeCont.setNextLevel(restartLevel);
		level14CBOutcome.addOption(level14CBOutcomeCont);
		
		Option level14CCOutcomep1Cont = new Option();
		level14CCOutcomep1Cont.setNextLevel(level14CCOutcomep2);
		level14CCOutcomep1.addOption(level14CCOutcomep1Cont);
		
		Option level14CCOutcomep2Cont = new Option();
		level14CCOutcomep2Cont.setNextLevel(level14t1);
		level14CCOutcomep2.addOption(level14CCOutcomep2Cont);
		
		Option level14t1Cont = new Option();
		level14t1Cont.setNextLevel(endgameLevel);
		level14t1.addOption(level14t1Cont);
		
		
		
		
		// ———————————— all we have! ——————————————————————————————————————————
		restartGameOption.setNextLevel(level0);
		//level11.addOption(restartGameOption);
		//level4t1.addOption(restartGameOption);


		// MyTextInputListener listener = new MyTextInputListener();
		// Gdx.input.getTextInput(listener, "What would you like to be called?",
		// "", "Your name please");


		statButton = new StatButton(level0);
		quitButton = new QuitButton();
		level0.addCommonOption(statButton);
		level0.addCommonOption(quitButton);
		
		gameLevels.add(titleLevel);
		gameLevels.add(level0);
		gameLevels.add(level1);
		gameLevels.add(level2p1);
		gameLevels.add(level2p2);
		gameLevels.add(level2CBOutcome);
		gameLevels.add(level3);
		gameLevels.add(level4);
		gameLevels.add(level4CAOutcome);
		gameLevels.add(level4CBOutcome);
		gameLevels.add(level4t1);
		
		currentLevel = gameLevels.get(0);
		
		gameState = 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationAdapter#render()
	 */
	@Override
	public void render()
	{

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/**if (gameState == 0)
		{
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			
			batch.begin();
			introWindow.setText("Please enter your name, adventurer.");
			drawTextWindow(introWindow);
			nameInputField.draw(batch, 1);
			batch.end();
		}*/
		if (gameState == 1)
		{
			background = currentLevel.getBackground();
			//fixes issue of font clash with background in certain level
			/**if(currentLevel.getBackgroundName().equals("backgrounds/town street on fire.jpg"))
			{
				introWindow.setIntroBackground("backgrounds/optionBackgroundGrey.png");
			}
			else
			{
				introWindow.setIntroBackground("backgrounds/optionBackground.png");
			}*/
			introWindow.setText(currentLevel.getIntro());
			camera.update();

			batch.setProjectionMatrix(camera.combined);

			batch.enableBlending();
			batch.begin();
			batch.draw(background, 0, 0);
			for (Option option : currentLevel.getOptions())
			{
				drawTextWindow(option);
			}

			drawTextWindow(introWindow);

			batch.end();

			//System.out.println(player.toString());
		}
	}

	/**
	 * Activated by the input processor, this function determines mouse
	 * location, iterates through all the options on screen, and, if the mouse
	 * is in one of the option boxes, it activates its resolve() method, which
	 * always updates the level. Also updates the stat option should the level
	 * update.
	 * 
	 * @param x
	 * @param y
	 */
	public void onMouseDown(int x, int y)
	{
		Vector3 input = new Vector3(x, y, 0);
		camera.unproject(input);
		int optionCount = currentLevel.getOptions().size();
		for (int i = 0; i < optionCount; i++)
		{
			Option currentOption = currentLevel.getOption(i);
			if (currentOption.getClickBox().contains(input.x, input.y))
			{
				currentLevel = currentOption.resolve();
				if (currentLevel.getAudioName() != null)
				{
					Audio.playMusic(currentLevel.getAudioName());
				}
				statButton = new StatButton(currentLevel);
				quitButton = new QuitButton();
				currentLevel.addCommonOption(statButton);
				currentLevel.addCommonOption(quitButton);
				break;
			}
		}
	}

	/**
	 * @author Joshua Osborne This simple InputProcessor watches for a player's
	 *         click and invokes onMouseDown().
	 */
	private class MyInputProcessor implements InputProcessor
	{
		@Override
		public boolean keyDown(int keycode)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyUp(int keycode)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyTyped(char character)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button)
		{
			if (button == Input.Buttons.LEFT)
			{
				onMouseDown(screenX, screenY);
				return true;
			}
			return false;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean scrolled(int amount)
		{
			// TODO Auto-generated method stub
			return false;
		}
	}

	/**
	 * Draws a window and its text according to their parameters and a standard
	 * formula.
	 * 
	 * @param w
	 *            The window to be drawn
	 */
	private void drawTextWindow(DrawableTextWindow w)
	{
		batch.draw(w.getBackgroundField(), w.getxPosition(), w.getyPosition(), w.getWidth(), w.getHeight());
		w.getFont().draw(batch, w.getText(), w.getxPosition() + (float) 0.03 * w.getWidth(),
				w.getyPosition() + (float) 0.97 * w.getHeight(), (float) 0.95 * w.getWidth(), Align.left, true);
	}

	/**
	 * @author Joshua Osborne Used for Swing dialog box at beginning to set
	 *         player's name.
	 */
	public class MyTextInputListener implements TextInputListener
	{
		@Override
		public void input(String text)
		{
			if (text.trim().equals(""))
			{
				text = "Galahad";
			}
			Player.setName(text);
		}

		@Override
		public void canceled()
		{
			Player.setName("Billy");
		}
	}
	
	@Override
	public void dispose()
	{
		background.dispose();
		batch.dispose();
	}
}
