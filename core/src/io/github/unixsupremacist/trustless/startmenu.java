package io.github.unixsupremacist.trustless;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.ScreenUtils;

public class startmenu implements Screen {
    main engine;

    public startmenu(main engine) {
        this.engine = engine;
        engine.setTileMap(new TmxMapLoader().load("untitled.tmx"));
        engine.updateTileMap();
    }

    @Override
    public void render(float delta) {
        engine.getCamera().setToOrtho(false, engine.getWidth(), engine.getHeight());
        ScreenUtils.clear(0, 0, 0.2f, 1);

        engine.getCamera().update();

        engine.getTileMapRenderer().setView(engine.getCamera());
        engine.getTileMapRenderer().render();

        engine.getBatch().setProjectionMatrix(engine.getCamera().combined);

        engine.getBatch().begin();
        engine.getFont().draw(engine.getBatch(), "Welcome to " + main.getTitle() + "!!!", 100, 150);
        engine.getBatch().end();

        if (Gdx.input.isTouched()) {
            engine.setScreen(new game(engine));
            dispose();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
