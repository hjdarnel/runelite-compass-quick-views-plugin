package hjdarnel.compassquickviews;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("compass-quick-views")
public interface CompassQuickViewsConfig extends Config
{
	@ConfigItem(
		keyName = "firstDirection",
		name = "First click",
		description = "The direction a single click on the compass goes to",
		position = 0
	)
	default CameraDirection firstDirection()
	{
		return CameraDirection.NORTH;
	}

	@ConfigItem(
		keyName = "secondDirection",
		name = "Second click",
		description = "The direction a second quick click goes to",
		position = 1
	)
	default CameraDirection secondDirection()
	{
		return CameraDirection.SOUTH;
	}

	@ConfigItem(
		keyName = "thirdDirection",
		name = "Third click",
		description = "The direction a third quick click goes to",
		position = 2
	)
	default CameraDirection thirdDirection()
	{
		return CameraDirection.EAST;
	}

	@ConfigItem(
		keyName = "fourthDirection",
		name = "Fourth click",
		description = "The direction a fourth quick click goes to. A fifth quick click goes back to the first click direction",
		position = 3
	)
	default CameraDirection fourthDirection()
	{
		return CameraDirection.WEST;
	}

	@Units(Units.MILLISECONDS)
	@ConfigItem(
		keyName = "clickWindow",
		name = "Click window",
		description = "The maximum time between clicks for a click to move to the next direction. A slower click goes back to the first click direction",
		position = 4
	)
	default int clickWindow()
	{
		return 500;
	}
}
