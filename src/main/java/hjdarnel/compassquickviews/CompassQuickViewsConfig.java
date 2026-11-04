package hjdarnel.compassquickviews;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("compass-quick-views")
public interface CompassQuickViewsConfig extends Config
{
	@ConfigItem(
		keyName = "rotationOrder",
		name = "Rotation order",
		description = "The order of the directions the camera rotates through when the compass is clicked repeatedly",
		position = 0
	)
	default RotationOrder rotationOrder()
	{
		return RotationOrder.NORTH_SOUTH_EAST_WEST;
	}

	@Units(Units.MILLISECONDS)
	@ConfigItem(
		keyName = "clickWindow",
		name = "Click window",
		description = "The maximum time between clicks for a click to move to the next direction. A slower click goes back to the first direction",
		position = 1
	)
	default int clickWindow()
	{
		return 500;
	}
}
