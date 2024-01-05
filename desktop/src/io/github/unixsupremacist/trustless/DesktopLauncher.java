package io.github.unixsupremacist.trustless;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.useVsync(false);
		config.setIdleFPS(20);
		config.setForegroundFPS(main.getMaxFPS());
		config.setWindowedMode(main.getStartingWidth(), main.getStartingHeight());
		config.setTitle(main.getTitle());
		new Lwjgl3Application(new main(), config);
	}
}
