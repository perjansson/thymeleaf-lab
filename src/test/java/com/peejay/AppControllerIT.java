package com.peejay;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class AppControllerIT {

    public static final String REPORT_URI = "http://127.0.0.1:8080/report";

    @Test
    public void shouldHaveCorrectTitle() {
        // given
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.navigate().to(REPORT_URI);
        // when
        String title = webDriver.getTitle();
        // then
        assertThat(title).isEqualTo("Report by Spring MVC, Thymeleaf, Bootstrap and Flying saucer");
    }

    @Test
    public void shouldHaveOnePanelForEachModule() {
        // given
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.navigate().to(REPORT_URI);
        // when
        List<WebElement> webElements = webDriver.findElements(By.className("panel"));
        // then
        assertThat(webElements).hasSize(4);
    }

}
