/*

Это второе задание по селениум: Заходим в UserData
Создаем пользователя (Каждый раз когда мы будем запускать тест пользователь должен быть уникальным)
Логинимся в приложение
Идем в employes и находим себя.
Убедится что нашлось(В таблице вы находитесь)
-----------------------------------
50 балов - создаем пользователя и логинимся(Можно без уникальности )
75 балов - создаем пользователя и логинимся(Уникальный )
100 - все что в условии задания

*/

package com.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.io.model.StreamHandle;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {

    public static void main(String[] args){
        User user1 = new User();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://user-data.hillel.it/html/registration.html");
        driver.findElement(By.cssSelector(".registration")).click();

        WebElement element = driver.findElement(By.cssSelector("#first_name"));
        element.sendKeys(user1.firstName);

        element = driver.findElement(By.cssSelector("#last_name"));
        element.sendKeys(user1.lastName);

        element = driver.findElement(By.cssSelector("#field_work_phone"));
        element.sendKeys(user1.phone);

        element = driver.findElement(By.cssSelector("#field_phone"));
        element.sendKeys(user1.mobilePhone);

        element = driver.findElement(By.cssSelector("#field_email"));
        element.sendKeys(user1.email);

        element = driver.findElement(By.cssSelector("#field_password"));
        element.sendKeys(user1.password);

        if (user1.gender == 0) {
            driver.findElement(By.cssSelector("#male")).click();
        } else {
            driver.findElement(By.cssSelector("#female")).click();
        }

        Select position = new Select(driver.findElement(By.cssSelector("#position")));
        position.selectByIndex(user1.position);

        driver.findElement(By.cssSelector("#button_account")).click();

        try { Thread.sleep(5000); } catch (Exception e) { System.out.println(e); }

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);

        // Accepting alert
        alert.accept();

        driver.get("https://user-data.hillel.it/html/registration.html");
        driver.findElement(By.cssSelector(".authorization")).click();

        element = driver.findElement(By.cssSelector("#email"));
        element.sendKeys(user1.email);

        element = driver.findElement(By.cssSelector("#password"));
        element.sendKeys(user1.password);

        driver.findElement(By.cssSelector(".login_button")).click();

        try { Thread.sleep(5000); } catch (Exception e) { System.out.println(e); }

        driver.findElement(By.cssSelector("#employees")).click();

        element = driver.findElement(By.cssSelector("#first_name"));
        element.sendKeys(user1.firstName);

        element = driver.findElement(By.cssSelector("#last_name"));
        element.sendKeys(user1.lastName);

        Select positionSel = new Select(driver.findElement(By.cssSelector("#position")));
/*        positionSel.selectByIndex(0);
        try { Thread.sleep(3000); } catch (Exception e) { System.out.println(e); }
        positionSel.selectByIndex(1);
        try { Thread.sleep(3000); } catch (Exception e) { System.out.println(e); }
        positionSel.selectByIndex(2);
        try { Thread.sleep(3000); } catch (Exception e) { System.out.println(e); }*/

        positionSel.selectByIndex(user1.position - 1);

        element = driver.findElement(By.cssSelector("#mobile_phone"));
        element.sendKeys(user1.mobilePhone);

        Select genderSel = new Select(driver.findElement(By.cssSelector("#gender")));
        genderSel.selectByIndex(user1.gender);

        driver.findElement(By.cssSelector("#search")).click();

        //Row Count	in WebTable
        WebElement table = driver.findElement(By.cssSelector("#table"));
        List<WebElement> row = table.findElements(By.tagName("tr"));
        System.out.println("Total Number of Rows = " + row.size());


    }
}
