package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class EndCallTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("appPackage", "com.android.dialer");
        caps.setCapability("appActivity", ".DialtactsActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testEndCall() throws InterruptedException {
        // Start a call first
        driver.findElementById("com.android.dialer:id/fab").click();
        driver.findElementById("com.android.dialer:id/digits").sendKeys("1234567890");
        driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();

        Thread.sleep(5000); // Wait for call to connect

        // End the call by clicking the End Call button
        // Accessibility id or resource id might vary; common id is:
        driver.findElementByAccessibilityId("End call").click();

        Thread.sleep(2000); // Wait for call to end
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
