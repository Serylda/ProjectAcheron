package noire.game.acheron;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.File;

public class AcheronMain extends ApplicationAdapter {

	private OrthographicCamera camera;
	SpriteBatch backgroundBatch;
	Texture backgroundTexture;
	Sprite background;
	Player player1, player2;
	TurnBasedLevel testLevel;
	TiledMap testMap;

	@Override
	public void create () {
		camera = new OrthographicCamera(1280, 720);
		//camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backgroundBatch = new SpriteBatch();

		testLevel = new TurnBasedLevel(1,"Test Level", new TiledMap(Gdx.files.internal("maps/bigMapTest.txt")));
		//testLevel.stage.addActor(new TestEnemy());

		testMap = new TiledMap();
		testMap.importMap(Gdx.files.internal("maps/bigMapTest.txt"));
		testMap.outputMap();

		player1 = new Player();
		player1.initialize();
		player1.initTBLevel(0, 0);
		//player1.setPosition(0, 0);

		backgroundTexture = new Texture("tempBg.jpg");
		background =new Sprite(backgroundTexture);


		//TiledMap testMap = new TiledMap(Gdx.files.internal("maps/testMap.txt"));
		//System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		//Gdx.gl.g
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Gdx.gl.glClearColor(0, 0, 0, 0);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderBackground(background);
		//testLevel.map().renderMap(backgroundBatch);
		testMap.renderMap(backgroundBatch);

		//testLevel.stage.act(delta);
		//testLevel.stage.draw();

		player1.turnBasedAction(testLevel, testMap, 10);
		player1.render();
	}

	@Override
	public void dispose () {
		//testLevel.stage.dispose();
	}

	public void renderBackground(Sprite bg)
	{
		backgroundBatch.begin();
		bg.draw(backgroundBatch);
		backgroundBatch.end();
	}

}
