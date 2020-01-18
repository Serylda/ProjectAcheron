package noire.game.acheron;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class MapElement {

    protected float xPos, yPos, xCoor, yCoor, xScale, yScale;

    public abstract void renderElement(SpriteBatch batch);

}
