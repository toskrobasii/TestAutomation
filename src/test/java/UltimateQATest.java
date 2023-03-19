import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

// modyfikatory dostępu w Java
// różnica pomiędzy klasą, interfejsem, a klasą abstrakcyjną
public class UltimateQATest extends PageSetup {

    // slowo kluczowe void - zwracanie z funkcji
    // slowo static
    @Test
    public void testOne() {
        WebElement button = driver.findElement(By.id("idExample"));
        button.click();

        WebElement buttonSuccess = driver.findElement(By.className("entry-title"));
        //import static
        assertEquals("Button success", buttonSuccess.getText());
    }

    @Test
    public void testTwo() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("et_pb_contact_name_0"));
        nameInput.sendKeys("Tomasz");

        WebElement emailInput = driver.findElement(By.id("et_pb_contact_email_0"));
        emailInput.sendKeys("tester@tester.pl");

        // waity w Selenium: explicit wait, implicit wait, fluent wait
        Thread.sleep(2000);

        WebElement buttonEmailMe = driver.findElement(By.name("et_builder_submit_button"));
        buttonEmailMe.click();

        Thread.sleep(2000);

        WebElement thanksText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        assertEquals("Thanks for contacting us", thanksText.getText());
    }
    
}
