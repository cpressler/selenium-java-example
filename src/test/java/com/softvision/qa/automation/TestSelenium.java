package com.softvision.qa.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSelenium {

    @Test
    public void swTestAcademyBadEmailTest() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/");

        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));



        element.sendKeys("abc.gmail.com");


        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        // find the element that returns an error message
        WebElement erroMsg = driver.findElement(By.id("message9"));

        // validate the error message is what we expect
        assertEquals("Email ID is not valid", erroMsg.getText(), "Title check failed!");

        //Close Driver  and Quit Driver to close out browser window
        driver.close();
        driver.quit();
    }

    @Test
    public void swTestAcademyTestContextClick() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/");

        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));


        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .contextClick()
                .build();

        seriesOfActions.perform() ;
        driver.close();
        driver.quit();
    }

    @Test
    public void swTestAcademyTestOpenNewTab() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/");

        WebElement body = driver.findElement(By.tagName("body"));

        //WebElement e = driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        //String selectAll = Keys.chord(Keys.COMMAND, "t");
        body.sendKeys(Keys.COMMAND + "A");

        WebElement element = driver.findElement(By.name("emailid"));//Enter ID for the element. You can use Name, xpath, cssSelector whatever you like
        element.sendKeys(Keys.COMMAND + "P");

        driver.get("http://google.com/");

        //driver.close();
        //driver.quit();
    }
}