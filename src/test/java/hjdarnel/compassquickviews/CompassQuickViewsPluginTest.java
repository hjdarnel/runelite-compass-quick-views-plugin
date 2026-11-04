package hjdarnel.compassquickviews;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CompassQuickViewsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CompassQuickViewsPlugin.class);
		RuneLite.main(args);
	}
}