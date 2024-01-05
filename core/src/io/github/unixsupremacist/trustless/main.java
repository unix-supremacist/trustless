package io.github.unixsupremacist.trustless;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import lombok.Getter;
import lombok.Setter;

public class main extends Game {
    @Getter
    private static int startingWidth = 1280;
    @Getter
    private static int startingHeight = 720;
    @Getter
    private static int maxFPS = 300;
    @Getter
    private static String title = "Trustless";
    @Getter
    private int width;
    @Getter
    private int height;
    @Getter
    private SpriteBatch batch;
    @Getter
    private BitmapFont font;
    @Getter
    private OrthographicCamera camera;
    @Getter
    @Setter
    private TiledMap tileMap;
    @Getter
    @Setter
    private TiledMapRenderer tileMapRenderer;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(); // use libGDX's default Arial font
        camera = new OrthographicCamera();
        this.setScreen(new startmenu(this));
    }

    public void render() {
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void updateTileMap() {
        tileMapRenderer = new OrthogonalTiledMapRenderer(tileMap);
    }
}
