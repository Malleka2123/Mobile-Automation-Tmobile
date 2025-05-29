package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.HasGsmCallOptions;
import io.appium.java_client.android.HasDeviceDetails;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class PhoneCallTest {
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

    @Test(priority = 1)
    public void testMakeCall() {
        driver.findElementById("com.android.dialer:id/fab").click();
        driver.findElementById("com.android.dialer:id/digits").sendKeys("1234567890");
        driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();
    }

    @Test(priority = 2)
    public void testSimulateIncomingCall() throws InterruptedException {
        ((HasGsmCallOptions) driver).makeGsmCall("9876543210", GsmCallActions.CALL);
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void testAnswerCall() throws InterruptedException {
        ((HasGsmCallOptions) driver).makeGsmCall("9876543210", GsmCallActions.ACCEPT);
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void testRejectCall() throws InterruptedException {
        ((HasGsmCallOptions) driver).makeGsmCall("9876543210", GsmCallActions.REJECT);
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void testHoldCall() throws InterruptedException {
        // Assumes you're already in an active call
        driver.findElementByAccessibilityId("Hold").click(); // May vary by device UI
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("Unhold").click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
