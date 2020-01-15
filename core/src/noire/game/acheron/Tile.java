package noire.game.acheron;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends MapElement
{

    private int state;

    private Sprite graphic;
    private Texture tileTexture;

    public static final int DEFAULT = 0;
    public static final int EMPTY = 1;
    public static final int OCCUPIED_BY_PLAYER = 2;
    public static final int OCCUPIED_BY_OBSTACLE = 3;
    public static final int SPAWN_POINT = 4;

    public Tile(int x)
    {
        state = x;
        tileTexture = new Texture("testTile.png");
        graphic = new Sprite(tileTexture);
        xPos = 0;
        yPos = 0;
        xScale = 1f;
        yScale = 1f;
    }

    public void initialize()
    {
        graphic = new Sprite(new Texture(""));
    }

    public boolean occupiable()
    {
        return state == EMPTY;
    }

    public void setPos(float x, float y)
    {
        xPos = x;
        yPos = y;
    }

    public void setScale(float x, float y)
    {
        xScale = x;
        yScale = y;
    }

    public String toString()
    {
        return state + "";
    }

    public void renderElement(SpriteBatch batch)
    {
        batch.begin();
        graphic.setPosition(xPos, yPos);
        //graphic.setScale(xScale, yScale);
        graphic.draw(batch);
        batch.end();
    }
}
