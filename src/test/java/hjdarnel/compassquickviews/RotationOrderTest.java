package hjdarnel.compassquickviews;

import static hjdarnel.compassquickviews.CameraDirection.EAST;
import static hjdarnel.compassquickviews.CameraDirection.NORTH;
import static hjdarnel.compassquickviews.CameraDirection.SOUTH;
import static hjdarnel.compassquickviews.CameraDirection.WEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RotationOrderTest
{
	@Test
	public void nextFollowsEachOrderAndWraps()
	{
		assertCycle(RotationOrder.NORTH_SOUTH_EAST_WEST, NORTH, SOUTH, EAST, WEST);
		assertCycle(RotationOrder.NORTH_EAST_SOUTH_WEST, NORTH, EAST, SOUTH, WEST);
		assertCycle(RotationOrder.NORTH_WEST_SOUTH_EAST, NORTH, WEST, SOUTH, EAST);
	}

	@Test
	public void nextWithoutPreviousIsFirstDirection()
	{
		for (RotationOrder order : RotationOrder.values())
		{
			assertEquals(NORTH, order.next(null));
		}
	}

	@Test
	public void fromOptionMatchesCompassOptions()
	{
		for (CameraDirection direction : CameraDirection.values())
		{
			assertEquals(direction, CameraDirection.fromOption(direction.getOption()));
		}
		assertNull(CameraDirection.fromOption("Walk here"));
	}

	private static void assertCycle(RotationOrder order, CameraDirection... directions)
	{
		for (int i = 0; i < directions.length; i++)
		{
			assertEquals(directions[(i + 1) % directions.length], order.next(directions[i]));
		}
	}
}
