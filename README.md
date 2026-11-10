# Compass Quick Views Plugin

Switch between the four camera directions by clicking the compass. One click always faces North, and quick follow-up clicks step through the other directions.

## Usage

Left-click the compass on the minimap. With the default settings:

| Clicks | Camera faces |
|---|---|
| 1 | North |
| 2 | South |
| 3 | East |
| 4 | West |

A fifth quick click wraps back to North. If you wait longer than the click window, the next click starts again at North.

The left-click option on the compass always shows where the next click will go, such as "Look South". All four "Look" options are still available in the right-click menu.

## Settings

| Setting | Description | Default |
|---|---|---|
| Rotation order | The order of directions to step through: North/South/East/West, North/East/South/West or North/West/South/East | North/South/East/West |
| Click window | The maximum time between clicks, in milliseconds, for a click to move to the next direction | 500 |

## Menu swappers

Custom swaps on the compass from other plugins, such as [More Menu Entry Swaps](https://github.com/geheur/More-menu-entry-swaps/), take precedence over this plugin. If you've swapped the compass's left-click to a direction, clicking goes to that direction rather than stepping through the rotation order.
