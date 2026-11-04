package hjdarnel.compassquickviews;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CameraDirection
{
	NORTH("Look North"),
	EAST("Look East"),
	SOUTH("Look South"),
	WEST("Look West");

	private final String option;

	/**
	 * Gets the direction for a compass menu option, or null if it isn't one.
	 */
	public static CameraDirection fromOption(String option)
	{
		for (CameraDirection direction : values())
		{
			if (direction.option.equals(option))
			{
				return direction;
			}
		}
		return null;
	}
}
