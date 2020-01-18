package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends MapElement
{

    private int state, modifier;

    private Sprite graphic;
    private Texture tileTexture;

    public static final int DEFAULT = 0;
    public static final int EMPTY = 1;
    public static final int OCCUPIED_BY_PLAYER = 2;
    public static final int OCCUPIED_BY_OBSTACLE = 3;

    public static final int SPAWN_POINT = 4;
    public static final int PORTAL = 5;

    public static final float tileWidth = 100;
    public static final float tileHeight = 100;
    public static final float tileDistance = 5;

    public Tile(int state)
    {
        initialize(state);
        xScale = 1f;
        yScale = 1f;
        System.out.println(xPos + " " + yPos);
    }

    public Tile(int state, int xCoordinate, int yCoordinate)
    {
        initialize(state, xCoordinate, yCoordinate);
        xScale = 1f;
        yScale = 1f;
        //System.out.println(Gdx.graphics.getHeight() + " " + Gdx.graphics.getWidth());
    }

    public Tile(int state, int modifier, int xCoordinate, int yCoordinate)
    {
        initialize(state, xCoordinate, yCoordinate);
        this.modifier = modifier;
    }

    public void initialize(int s)
    {
        state = s;
        modifier = DEFAULT;
        tileTexture = new Texture("testTile.png");
        graphic = new Sprite(tileTexture, 100, 100);
    }

    public void initialize(int s, int xCoordinate, int yCoordinate)
    {
        state = s;
        modifier = DEFAULT;
        tileTexture = new Texture("testTile.png");
        graphic = new Sprite(tileTexture, 100, 100);

        //tileWidth = tileTexture.getWidth() / 3;
        //tileHeight = tileTexture.getHeight() / 3;

        setCoordinate(xCoordinate, yCoordinate);

    }

    public void setCoordinate(int xCoordinate, int yCoordinate)
    {
        xCoor = xCoordinate;
        yCoor = yCoordinate;
        xPos = tileDistance + (tileWidth + tileDistance) * xCoor;
        yPos = Gdx.graphics.getHeight() - 100 - tileDistance - (tileHeight + tileDistance) * yCoor;
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
