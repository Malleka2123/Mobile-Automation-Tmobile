import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessagingTest extends BaseTest {

    @Test
    public void testSendSMS() {
        driver.findElement(By.id("com.android.messaging:id/start_new_conversation_button")).click();
        driver.findElement(By.id("recipient_text_view")).sendKeys("1234567890");
        driver.findElement(By.id("compose_message_text")).sendKeys("Hello from automation!");
        driver.findElement(By.id("send_message_button_icon")).click();

        String lastMessage = driver.findElement(By.id("message_text")).getText();
        Assert.assertEquals(lastMessage, "Hello from automation!");
    }
}
