package test;

import static org.junit.Assert.assertFalse;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TETOSOFT.graphics.ScreenManager;
import com.TETOSOFT.test.EndMenu;

public class EndMenuTest {

	private EndMenu endmenu;
	private ScreenManager screen;

	@BeforeEach
	public void before() {
		screen = new ScreenManager();
		DisplayMode POSSIBLE_MODES[] = { new DisplayMode(800, 600, 32, 0), new DisplayMode(800, 600, 16, 0),
				new DisplayMode(800, 600, 24, 0), new DisplayMode(640, 480, 16, 0), new DisplayMode(640, 480, 32, 0),
				new DisplayMode(640, 480, 24, 0), new DisplayMode(1024, 768, 16, 0), new DisplayMode(1024, 768, 32, 0),
				new DisplayMode(1024, 768, 24, 0), };

		DisplayMode displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);
		screen.setFullScreen(displayMode);

		Window window = screen.getFullScreenWindow();
		window.setFont(new Font("Dialog", Font.PLAIN, 18));
		window.setBackground(Color.BLACK);
		window.setForeground(Color.WHITE);

		endmenu = new EndMenu(5, screen);
	}

	/*
	 * @Test void testExit() {
	 * 
	 * new Thread( ()->{try { Thread.sleep(3000); } catch (InterruptedException ex)
	 * { ex.printStackTrace(); }
	 * 
	 * endmenu.getExit().press(); try { Thread.sleep(3000); } catch
	 * (InterruptedException ex) { ex.printStackTrace(); } assertNull(screen);
	 * 
	 * } ).start();
	 * 
	 * endmenu.run();
	 * 
	 * }
	 */

	@Test
	public void testExit() {

		endmenu.getExit().press();
		endmenu.run();
		assertFalse(endmenu.isWaiting());

	}

}
