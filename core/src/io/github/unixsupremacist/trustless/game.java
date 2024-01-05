package io.github.unixsupremacist.trustless;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class game implements Screen {
    main engine;
    Rectangle bucket;
    Texture img;

    public game(main engine) {
        this.engine = engine;

        img = new Texture("icon.png");
        bucket = new Rectangle();
        bucket.width = 64;
        bucket.height = 64;
        bucket.x = engine.getWidth() / 2 - bucket.width / 2;
        bucket.y = 20;
    }

    @Override
    public void render(float delta) {
        engine.getCamera().setToOrtho(false, engine.getWidth(), engine.getHeight());
        ScreenUtils.clear(1, 0, 0, 1);
        engine.getCamera().update();
        engine.getTileMapRenderer().setView(engine.getCamera());
        engine.getTileMapRenderer().render();
        engine.getBatch().setProjectionMatrix(engine.getCamera().combined);
        engine.getBatch().begin();
        String fps = String.valueOf(Gdx.graphics.getFramesPerSecond());
        engine.getFont().draw(engine.getBatch(), fps, 25, engine.getHeight() - 25);
        engine.getBatch().draw(img, bucket.x, bucket.y, bucket.width, bucket.height);
        engine.getBatch().end();
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            engine.getCamera().unproject(touchPos);
            bucket.x = touchPos.x - bucket.width / 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > engine.getWidth() - bucket.width)
            bucket.x = engine.getWidth() - bucket.width;
    }

    @Override
    public void dispose() {
        img.dispose();
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
}
