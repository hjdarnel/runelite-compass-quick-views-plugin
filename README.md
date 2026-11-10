# Compass Quick Views Plugin

Switch between the four camera directions by clicking the compass. One click always faces your chosen first click direction, North by default, and quick follow-up clicks step through the other directions you've chosen.

## Usage

Left-click the compass on the minimap. With the default settings:

| Clicks | Camera faces |
|---|---|
| 1 | North |
| 2 | South |
| 3 | East |
| 4 | West |

A fifth quick click wraps back to North. If you wait longer than the click window, the next click starts again at North.

Each click's direction can be set separately, so any sequence is possible, such as South, North, East, West.

The left-click option on the compass always shows where the next click will go, such as "Look South". All four "Look" options are still available in the right-click menu.

## Settings

| Setting | Description | Default |
|---|---|---|
| First click | The direction a single click goes to | North |
| Second click | The direction a second quick click goes to | South |
| Third click | The direction a third quick click goes to | East |
| Fourth click | The direction a fourth quick click goes to | West |
| Click window | The maximum time between clicks, in milliseconds, for a click to move to the next direction | 500 |

## Menu swappers

Custom swaps on the compass from other plugins, such as [More Menu Entry Swaps](https://github.com/geheur/More-menu-entry-swaps/), take precedence over this plugin. If you've swapped the compass's left-click to a direction, clicking goes to that direction rather than stepping through your chosen directions.
