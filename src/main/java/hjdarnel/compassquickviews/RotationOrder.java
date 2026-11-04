package hjdarnel.compassquickviews;

import static hjdarnel.compassquickviews.CameraDirection.EAST;
import static hjdarnel.compassquickviews.CameraDirection.NORTH;
import static hjdarnel.compassquickviews.CameraDirection.SOUTH;
import static hjdarnel.compassquickviews.CameraDirection.WEST;
import java.util.Arrays;
import java.util.List;

public enum RotationOrder
{
	NORTH_SOUTH_EAST_WEST("North/South/East/West", NORTH, SOUTH, EAST, WEST),
	NORTH_EAST_SOUTH_WEST("North/East/South/West", NORTH, EAST, SOUTH, WEST),
	NORTH_WEST_SOUTH_EAST("North/West/South/East", NORTH, WEST, SOUTH, EAST);

	private final String label;
	private final List<CameraDirection> directions;

	RotationOrder(String label, CameraDirection... directions)
	{
		this.label = label;
		this.directions = Arrays.asList(directions);
	}

	/**
	 * Gets the direction that follows previous in this order, wrapping around at the end.
	 * A null previous direction gives the first direction in the order.
	 */
	public CameraDirection next(CameraDirection previous)
	{
		return directions.get((directions.indexOf(previous) + 1) % directions.size());
	}

	@Override
	public String toString()
	{
		return label;
	}
}
