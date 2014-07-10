package com.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.color.Color;

import com.manager.SceneManager.SceneType;
import com.util.Constants;

public class LoadingScene extends BaseScene {

	@Override
	public void createScene() {
		setBackground(new Background(Color.WHITE));
		//Essa font devia ser privada e na vdd ela nem devia estar no resources manager a num ser que seja utilizada em outro lugar. 
		Text text = new Text(0, 0, resourcesManager.font, "Loading...", vbom);
		text.setPosition(Constants.CAMERA_WIDTH / 2 - text.getWidth() / 2, Constants.CAMERA_HEIGHT / 2 - text.getHeight() / 2); 
		text.setColor(Color.BLACK); 
		attachChild(text);
	}

	@Override
	public void onBackKeyPressed() {
		return; 
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MENU; 
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

}
