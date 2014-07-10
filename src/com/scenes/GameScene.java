package com.scenes;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.VerticalAlign;
import org.andengine.util.color.Color;

import com.badlogic.gdx.math.Vector2;
import com.manager.SceneManager.SceneType;

public class GameScene extends BaseScene {
	
	private HUD gameHUD; 
	private Text scoreText; 
	private int score = 0; 
	private PhysicsWorld physicsWorld; 

	@Override
	public void createScene() {
		createBackground(); 
		createHUD(); 
		createPhysics(); 
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}
	
	public void createBackground() {
		setBackground(new Background(Color.BLUE)); 
	}
	
	private void createHUD() {
		gameHUD = new HUD(); 
//		precisa inicializar com tudo isso pq a memória já fica alocada. 		
		scoreText = new Text(0, 0, resourcesManager.font, "Score: 0123456789",
				new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText.setSkewCenter(0, 0);     
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

}
