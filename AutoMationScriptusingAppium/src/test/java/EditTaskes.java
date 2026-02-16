import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class EditTaskes {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.example.android.architecture.blueprints.main");
        options.setAppActivity("com.example.android.architecture.blueprints.todoapp.TodoActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void modifyTask() {

        // 1️⃣ اضغط Add Task
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New Task"))).click();

        // 2️⃣ اكتب اسم المهمة
        driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("BuyMilk");

        // 3️⃣ Enter Description
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[2]"))).sendKeys("From Market");


        // 3️⃣ اضغط Save
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")).click();


        // 4️⃣ افتح المهمة
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"BuyMilk\")"))).click();

        // 5️⃣ اضغط Edit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // زيدي الوقت لو لازم
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Edit Task"))).click();

        // 6️⃣ امسح الاسم القديم
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.example.android.architecture.blueprints:id/add_task_title")));
        titleField.clear();

        // 7️⃣ اكتب الاسم الجديد
        titleField.sendKeys("BuyBread");

        // 8️⃣ اضغط Save
        driver.findElement(AppiumBy.accessibilityId("Save")).click();
    }
}

