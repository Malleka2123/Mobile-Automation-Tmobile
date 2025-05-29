package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SendImageInGroupMessageTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true); // Skip login/setup

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSendImageInGroupMessage() throws InterruptedException {
        // Start new conversation
        driver.findElementById("start_new_conversation_button").click();
        driver.findElementById("recipient_text_view").sendKeys("1234567890;0987654321");
        Thread.sleep(2000);

        // Create group
        driver.findElementById("contact_picker_create_group_button").click();

        // Tap on + or attachment icon (usually "Attach media")
        driver.findElementByAccessibilityId("Attach media").click();

        // Select Photos or Gallery (adjust text if different)
        driver.findElementByXPath("//android.widget.TextView[@text='Photos']").click();

        // Select the first image (XPath may vary)
        driver.findElementByXPath("(//android.widget.ImageView)[1]").click();

        // Optional: Wait for preview
        Thread.sleep(2000);

        // Tap send button
        driver.findElementById("send_message_button_icon").click();

        // Optional: Assert message sent (advanced – may use image preview or toast)
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
