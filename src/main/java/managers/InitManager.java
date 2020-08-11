package managers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static utils.PropertyConstants.*;

public class InitManager {
    private static PropertyManager properties;

    public static void initFramework() {
        properties = PropertyManager.initProperties();

        Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty(START_MAXIMIZED));
        Selenide.open(properties.getProperty(TARGET_URL));
    }
}
