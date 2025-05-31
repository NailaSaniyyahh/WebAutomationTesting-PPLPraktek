package com.a8.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.a8.core.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // Setup driver sebelum setiap scenario
        DriverManager.getDriver(); // pastikan driver sudah terinisialisasi di sini
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        if (scenario.isFailed()) {
            // Ambil screenshot saat gagal
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Tutup driver setelah scenario selesai
        DriverManager.quitDriver();
    }
}
