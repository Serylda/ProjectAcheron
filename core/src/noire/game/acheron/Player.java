package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private float xPos ,yPos, scaleX, scaleY;
    private int xCoor, yCoor;
    SpriteBatch batch;
    Sprite graphic;
    //private float

    public void initialize()
    {
        batch = new SpriteBatch();
        graphic = new Sprite(new Texture("sans.png"));
        graphic.setScale(0.05f);
        graphic.setCenter(graphic.getWidth()/2, graphic.getHeight()/2);
        graphic.setOrigin(graphic.getWidth()/2, graphic.getHeight()/2);
    }

    public void initTBLevel(int initialXCoor, int initialYCoor)
    {
        
    }


    public void turnBasedAction(int turn_count) {
        int turnCount = turn_count;
        int movementIndex = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            xPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            xPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            yPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            yPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            setScale(0.2f, 0.2f);

    }

    public void setPosition(float x, float y)
    {
        xPos = x;
        yPos = y;
    }

    public void setScale(float x, float y)
    {
        scaleX = x;
        scaleY = y;
        graphic.setScale(scaleX, scaleY);
    }

    public void freeMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            xPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            xPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            yPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            yPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            setScale(0.2f, 0.2f);
    }

    public void render()//SpriteBatch batch)
    {
        batch.begin();
        graphic.draw(batch);
        graphic.setOriginBasedPosition(xPos, yPos);
        batch.end();
    }

    public void dispose()
    {
        batch.dispose();
    }
}
