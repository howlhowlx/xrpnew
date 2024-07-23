package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Random;

public class Main {
    private static WebDriver driver;
    private static String baseUrl;

    public static void main(String[] args) throws InterruptedException {
        // Loop for retrying the entire process
        for (int i = 0; i < 99999; i++) {
            try {


                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

                // Configure ChromeOptions
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");

                // Pass ChromeOptions to ChromeDriver
                driver = new ChromeDriver(options);

                // Set base URL
                baseUrl = "https://xrp.pub/register";
                //launching the specified URL
                driver.get(baseUrl);

                // Optional: Set implicit wait
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                String generateRandomUsername = generateRandomUsername();
                String generateRandomPass = generateRandomUsername();
                driver.get("https://xrp.pub/share?code=GN5TKmHx2EjGg5SBglZeAu46IR5rgf5v");
                driver.findElement(By.xpath("//div[@id='root']/div/section/div")).click();
                driver.findElement(By.linkText("Start")).click();
                driver.findElement(By.id("userName")).click();
                driver.findElement(By.id("userName")).clear();
                driver.findElement(By.id("userName")).sendKeys(generateRandomUsername);
                driver.findElement(By.id("email")).click();
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys(generateRandomUsername + "@gmail.com");
                driver.findElement(By.id("password")).click();
                driver.findElement(By.id("password")).clear();
                driver.findElement(By.id("password")).sendKeys(generateRandomPass);
                driver.findElement(By.id("password2")).click();
                driver.findElement(By.id("password2")).clear();
                driver.findElement(By.id("password2")).sendKeys(generateRandomPass);
                driver.findElement(By.id("agreement")).click();
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/div[5]/button")).click();
                //ERROR: Caught exception [unknown command []]
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                Thread.sleep(5000);
//                driver.findElement(By.id("address")).click();
//                driver.findElement(By.id("address")).clear();
//                driver.findElement(By.id("address")).sendKeys("rHic6o5mRtxdn4Xm1iYBYen3gBA8Re3vwJ");
//                driver.findElement(By.id("tag")).click();
//                driver.findElement(By.id("tag")).clear();
//                driver.findElement(By.id("tag")).sendKeys(generateRandomNumber());
//                driver.findElement(By.xpath("//div[@id='tabItem7']/form/div/div/div/div/div")).click();
//                driver.findElement(By.xpath("//button[@type='button']")).click();
//                driver.findElement(By.xpath("//div[@id='tabItem7']/form/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/button/span")).click();
//                driver.findElement(By.xpath("//div[@id='tabItem7']/form/div/div/div/div/div/div/button[2]")).click();
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                Thread.sleep(2000);
//                driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                Thread.sleep(1000);
//                driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/form/div/div/div/div/div/div/div[5]/button/span")).click();
//                Thread.sleep(1500);
//                driver.get("https://xrp.pub/");
                System.out.println("Now is : " + (i+1));
                driver.quit();
            } catch (Exception e) {
                // Handle exception
                System.err.println("Caught exception: " + e.getMessage());
                // Perform logging or error handling if needed

                // Continue to the next iteration of the loop
                continue;
            } finally {
                // Ensure WebDriver instance is properly closed
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }

    // Method to generate random username
    public static String generateRandomUsername() {
        String characters = "axbccvdbenfmgqhwiejrktlymuniooppqlrksjthugvfwdxsyaz";
        int lengthOfRandomString = 6;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lengthOfRandomString; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        int numberOfDigits = 2;
        for (int i = 0; i < numberOfDigits; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // Method to generate random number
    public static String generateRandomNumber() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1_000_000) + 9);
    }
}