package hjdarnel.compassquickviews;

import com.google.inject.Provides;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.api.Menu;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PostMenuSort;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Compass Quick Views",
	description = "Quickly click on the compass to rotate through North/South/East/West views, or other configured order",
	tags = {"compass", "camera"}
)
public class CompassQuickViewsPlugin extends Plugin
{
	// The compass is a different component in each interface layout
	private static final Set<Integer> COMPASS_COMPONENTS = Set.of(
		InterfaceID.Toplevel.COMPASSCLICK,
		InterfaceID.ToplevelOsrsStretch.COMPASSCLICK,
		InterfaceID.ToplevelPreEoc.COMPASSCLICK,
		InterfaceID.ToplevelOsm.COMPASSCLICK,
		InterfaceID.OrbsOsmNomap.COMPASSCLICK
	);

	@Inject
	private Client client;

	@Inject
	private CompassQuickViewsConfig config;

	private static final int CLICKS_PER_RUN = 4;

	// Positions in the run of clicks, from 0 for a single click to 3 for a fourth click
	private int offeredClick;
	private int lastClick = -1;
	private long lastClickNanos;

	// Intentionally run before other menu swappers, so their custom swaps on the compass take precedence over this one
	@Subscribe
	public void onPostMenuSort(PostMenuSort event)
	{
		// Shift-clicks aren't part of the run of clicks, so they keep the compass's normal left-click
		if (isShiftHeld())
		{
			return;
		}

		Menu menu = client.getMenu();
		MenuEntry[] entries = menu.getMenuEntries();
		if (entries.length == 0 || !isCompass(entries[entries.length - 1].getParam1()))
		{
			return;
		}

		offeredClick = nextClick();
		String option = directionForClick(offeredClick).getOption();
		for (int i = entries.length - 1; i >= 0; --i)
		{
			MenuEntry entry = entries[i];
			if (isCompass(entry.getParam1()) && option.equals(Text.removeTags(entry.getOption())))
			{
				entries[i] = entries[entries.length - 1];
				entries[entries.length - 1] = entry;
				menu.setMenuEntries(entries);
				return;
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// Picking an option from the right-click menu or shift-clicking doesn't continue the run of clicks
		if (client.isMenuOpen() || isShiftHeld() || !isCompass(event.getParam1()))
		{
			return;
		}

		// Only count the option this plugin offered, not one another plugin swapped in
		if (directionForClick(offeredClick).getOption().equals(Text.removeTags(event.getMenuOption())))
		{
			lastClick = offeredClick;
			lastClickNanos = System.nanoTime();
		}
	}

	private int nextClick()
	{
		boolean inWindow = System.nanoTime() - lastClickNanos <= TimeUnit.MILLISECONDS.toNanos(config.clickWindow());
		return inWindow && lastClick >= 0 ? (lastClick + 1) % CLICKS_PER_RUN : 0;
	}

	private CameraDirection directionForClick(int click)
	{
		switch (click)
		{
			case 1:
				return config.secondDirection();
			case 2:
				return config.thirdDirection();
			case 3:
				return config.fourthDirection();
			default:
				return config.firstDirection();
		}
	}

	private boolean isShiftHeld()
	{
		return client.isKeyPressed(KeyCode.KC_SHIFT);
	}

	private static boolean isCompass(int param1)
	{
		return COMPASS_COMPONENTS.contains(param1);
	}

	@Provides
	CompassQuickViewsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CompassQuickViewsConfig.class);
	}
}
