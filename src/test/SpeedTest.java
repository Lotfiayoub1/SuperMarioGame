package test;

import static org.junit.Assert.assertEquals;
import java.awt.DisplayMode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.TETOSOFT.graphics.ScreenManager;
import com.TETOSOFT.tilegame.MapLoader;
import com.TETOSOFT.tilegame.TileMap;
import com.TETOSOFT.tilegame.TileMapDrawer;
import com.TETOSOFT.tilegame.sprites.Creature;

public class SpeedTest {

	private static ScreenManager screen;
	private static double speed;
	private static TileMap map;

	@BeforeAll
	static void beforeAll() {
		screen = new ScreenManager();
		DisplayMode POSSIBLE_MODES[] = { new DisplayMode(800, 600, 32, 0), new DisplayMode(800, 600, 16, 0),
				new DisplayMode(800, 600, 24, 0), new DisplayMode(640, 480, 16, 0), new DisplayMode(640, 480, 32, 0),
				new DisplayMode(640, 480, 24, 0), new DisplayMode(1024, 768, 16, 0), new DisplayMode(1024, 768, 32, 0),
				new DisplayMode(1024, 768, 24, 0), };

		DisplayMode displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);
		screen.setFullScreen(displayMode);
		MapLoader mapLoader = new MapLoader(screen.getFullScreenWindow().getGraphicsConfiguration());
		TileMapDrawer drawer = new TileMapDrawer();
		drawer.setBackground(mapLoader.loadImage("background_desert1.jpg"));
		mapLoader.loadCharacters();
		map = mapLoader.loadNextMap();

	}

	@ParameterizedTest
	@CsvSource({ "1, 0.5f", "2,1.0f", "3,1.25f", "4,1.5f" })
	void testSpeedChange(int input, double expected) {
		MapLoader.currentMap = input;
		double speed = ((Creature) (map.getPlayer())).getMaxSpeed();
		assertEquals(expected, speed, 0.0001);
	}

	@Test
	void testSpeedChange() {
		MapLoader.currentMap = 2;
		double speed = ((Creature) (map.getPlayer())).getMaxSpeed();
		assertEquals(1, speed, 0.0001);
	}

}
