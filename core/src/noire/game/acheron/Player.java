package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private float xPos ,yPos, scaleX, scaleY;
    SpriteBatch batch;
    Sprite graphic;

    public void initialize()
    {
        batch = new SpriteBatch();
        graphic = new Sprite(new Texture("sans.png"));
        graphic.setScale(0.05f);
    }

    public void turnBasedAction(int turn_count) {
        int turnCount = turn_count;
        int movementIndex = 1;

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
            xPos += -5;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            xPos += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            yPos += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            yPos += -5;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            setScale(0.2f, 0.2f);
    }

    public void render()//SpriteBatch batch)
    {
        batch.begin();
        graphic.draw(batch);
        graphic.setPosition(xPos, yPos);
        batch.end();
    }

    public void dispose()
    {
        batch.dispose();
    }
}
