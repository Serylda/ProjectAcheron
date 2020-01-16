package noire.game.acheron;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TiledMap extends Map {

    int rowCount, columnCount;
    MapElement[][] mapScript;


    public TiledMap()
    {
        type = Map.TILED_MAP;
        rowCount = 0;
        columnCount = 0;
    }

    public TiledMap(FileHandle mapFile)
    {
        type = Map.TILED_MAP;
        importMap(mapFile);
    }

    public void importMap(Scanner script)
    {
        //Scanner script = new Scanner(input);
        rowCount = script.nextInt();
        columnCount = script.nextInt();
        script.nextLine();
        script.nextLine();
        mapScript = new MapElement[rowCount][columnCount];

        //System.out.println(rowCount + " " + columnCount);

        int r = 0;
        int c = 0;
        while (script.hasNextLine())
        {
            Scanner line = new Scanner(script.nextLine());
            line.useDelimiter("\t");
            c = 0;
            while (line.hasNext())
            {
                String t = line.next();

                /*
                    The map is created based on the String Code
                    Each Code corresponds to a specific element created on the map

                    TE - Tile_EMPTY
                    TO - Tile_OBSTACLE
                    TS - Tile_SPAWN
                 */

                if (t.equals("TE"))
                    mapScript[r][c] = new Tile(Tile.EMPTY, r, c);
                    //mapScript[r][c] = "TE";
                else if (t.equals("TO"))
                    mapScript[r][c] = new Tile(Tile.OCCUPIED_BY_OBSTACLE);
                    //mapScript[r][c] = "TO";
                else if (t.equals("TS"))
                    mapScript[r][c] = new Tile(Tile.SPAWN_POINT);
                else
                    mapScript[r][c] = new Tile(Tile.DEFAULT);

                c++;
            }
            r++;
        }

    }

    public void importMap(FileHandle mapFile)
    {
        Scanner script = new Scanner(mapFile.readString());
        //script.useDelimiter("\t");
        importMap(script);
    }

    public void outputMap()
    {
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++)
                System.out.print(mapScript[i][l] + " ");
            System.out.println("");
        }
    }

    public void renderMap(SpriteBatch batch)
    {
        for (MapElement[] e : mapScript)
            for (MapElement element : e)
                element.renderElement(batch);
    }

}
