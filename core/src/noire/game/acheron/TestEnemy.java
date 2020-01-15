package noire.game.acheron;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestEnemy extends Actor {

    public TestEnemy()
    {
        setScale(4);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        //batch.draw (new Texture("sans.png"), getX(), getY(), getOriginX(), getOriginY(), getWidth(),getHeight(), getScaleX(),
        //getScaleY(), getRotation(), , int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY);


        //batch.draw(new Texture("sans.png"), getX(), getY()); //getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), );
    }
}
