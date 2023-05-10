package config;

import config.webui.WebConfig;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {
    private final WebConfig webConfig;

    public WebDriverProvider(WebConfig webConfig) {

        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.baseUrl = webConfig.getBaseUrl();
        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
