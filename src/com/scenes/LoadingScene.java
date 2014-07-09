package com.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.color.Color;
import com.manager.SceneManager.SceneType;

public class LoadingScene extends BaseScene {

	@Override
	public void createScene() {
		setBackground(new Background(Color.WHITE));
		//Essa font devia ser privada e na vdd ela nem devia estar no resources manager a num ser que seja utilizada em outro lugar. 
		attachChild(new Text(400, 240, resourcesManager.font, "Loading...", vbom));
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
