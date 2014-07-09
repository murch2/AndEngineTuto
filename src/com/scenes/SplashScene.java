package com.scenes;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.engine.camera.Camera;

import com.manager.SceneManager.SceneType;
import com.util.Constants;

public class SplashScene extends BaseScene {	

	private Sprite splash; 

	@Override
	public void createScene()
	{
		splash = new Sprite(0, 0, resourcesManager.splash_region, vbom)
    	{
    		@Override
            protected void preDraw(GLState pGLState, Camera pCamera) 
    		{
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
    	};
    
    	splash.setPosition((Constants.CAMERA_WIDTH / 2) - splash.getWidth()/ 2,
    			(Constants.CAMERA_HEIGHT / 2) - splash.getHeight() / 2);
    	
    	attachChild(splash);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_SPLASH;
	}

	//Dealloc
	@Override
	public void disposeScene() {
		splash.detachSelf(); 
		splash.dispose(); 
		this.detachSelf(); 
		this.dispose(); 
		
	}

}
