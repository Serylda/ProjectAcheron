package noire.game.acheron;

import com.badlogic.gdx.Gdx;
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

    public Tile(int s)
    {
        state = s;
        tileTexture = new Texture("testTile.png");
        graphic = new Sprite(tileTexture, 100, 100);
        xPos = 0; //Gdx.graphics.getWidth() - graphic.getTexture().getWidth();
        yPos = Gdx.graphics.getHeight() - tileTexture.getHeight() / 3;
        xScale = 1f;
        yScale = 1f;
        System.out.println(xPos + " " + yPos);
    }

    public Tile(int s, int positionRow, int positionColumn)
    {
        state = s;
        tileTexture = new Texture("testTile.png");
        graphic = new Sprite(tileTexture, 100, 100);

        xPos = 10 + (tileTexture.getWidth() / 3.0f + 10) * positionRow;
        yPos = Gdx.graphics.getHeight() - 110 - (tileTexture.getHeight() / 3.0f + 10) * positionColumn;
        xScale = 1f;
        yScale = 1f;
        System.out.println(Gdx.graphics.getHeight() + " " + Gdx.graphics.getWidth());
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
