package com.scenes;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.adt.color.Color;
import org.andengine.util.level.simple.SimpleLevelLoader;

import com.badlogic.gdx.math.Vector2;
import com.manager.SceneManager;
import com.manager.SceneManager.SceneType;
import com.util.Constants;

public class GameScene extends BaseScene {
	
	private HUD gameHUD; 
	private Text scoreText; 
	private int score = 0; 
	private PhysicsWorld physicsWorld; 
	
	private static final String TAG_ENTITY = "entity";
	private static final String TAG_ENTITY_ATTRIBUTE_X = "x";
	private static final String TAG_ENTITY_ATTRIBUTE_Y = "y";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE = "type";
	    
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM1 = "platform1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM2 = "platform2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM3 = "platform3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_COIN = "coin";

	@Override
	public void createScene() {
		createBackground(); 
		createHUD(); 
		createPhysics(); 
	}

	@Override
	public void onBackKeyPressed() {
		SceneManager.getInstance().loadMenuScene(engine); 
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		camera.setHUD(null); 
		camera.setCenter(Constants.CAMERA_WIDTH / 2 , Constants.CAMERA_HEIGHT / 2); 
	}
	
	public void createBackground() {
		setBackground(new Background(Color.BLUE)); 
	}
	
	private void createHUD() {
		gameHUD = new HUD(); 
//		precisa inicializar com tudo isso pq a memória já fica alocada. 		
		scoreText = new Text(20, 420, resourcesManager.font, "Score: 0123456789",
				new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText.setAnchorCenter(0, 0);      
	    scoreText.setText("Score: 0");
	    gameHUD.attachChild(scoreText);
		camera.setHUD(gameHUD); 
	}
	
	private void addToScore(int i) {
		score += i; 
		scoreText.setText("Score: " + score); 
	}
	
	private void createPhysics() {
		physicsWorld = new FixedStepPhysicsWorld(60, new Vector2(0, -17), false); 
		registerUpdateHandler(physicsWorld); 
	}
	
	private void loadLevel(int levelID) {
		final SimpleLevelLoader levelLoader = new SimpleLevelLoader(vbom); 
	}
	
	

}
