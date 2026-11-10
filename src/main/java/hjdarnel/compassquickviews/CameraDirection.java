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
}
