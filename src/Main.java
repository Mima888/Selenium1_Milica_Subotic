import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://bvtest.school.cubes.rs/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");

        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("cubesqa");

        WebElement logIn = driver.findElement(By.className("btn-primary"));
        logIn.click();

        System.out.println("Page title is: " + driver.getTitle());

//        driver.quit();
        WebElement signaturesLink = driver.findElement(By.linkText("Signatures"));
        signaturesLink.click();

        System.out.println("Page title is: " + driver.getTitle());

        
        //CATEGORIES
        WebElement navBar = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTagsCat = navBar.findElements(By.tagName("li"));
        liTagsCat.get(2).click();

        System.out.println("Page title is: " + driver.getTitle());
        
        WebDriverWait waitCat = new WebDriverWait(driver, 8);
        WebElement addCategoryButton = waitCat.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addCategoryButton.click();

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.sendKeys(Helper.getRandomTextCat());

        WebElement saveCatButton = driver.findElement(By.id("save-category-button"));
        saveCatButton.click();

        

        //REGIONS
        WebElement navBar1 = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTagsReg = navBar1.findElements(By.tagName("li"));
        liTagsReg.get(3).click();
        
        System.out.println("Page title is: " + driver.getTitle());

        WebDriverWait waitReg = new WebDriverWait(driver, 10);
        WebElement addRegionButton = waitReg.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addRegionButton.click();
        
        WebElement writeRegion = driver.findElement(By.id("title"));
        writeRegion.sendKeys(Helper.getRandomTextReg());
        
        WebElement saveRegButton = driver.findElement(By.id("save-region-button"));
        saveRegButton.click();
        

        //PORTALS
        WebElement navBar2 = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTagsPort = navBar2.findElements(By.tagName("li"));
        liTagsPort.get(4).click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        WebDriverWait waitPort = new WebDriverWait(driver, 10);
        WebElement addPortalButton = waitPort.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addPortalButton.click();
        
        WebElement writePortalTitle = driver.findElement(By.id("title"));
        writePortalTitle.sendKeys(Helper.getRandomTextPort());
        
        WebElement writePortalUrl = driver.findElement(By.id("url"));
        writePortalUrl.sendKeys(Helper.getRandomUrl());
        
        Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
        dropDownReg.selectByValue("4");
        
//        Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
//        dropDownReg.selectByVisibleText("Balkan");
        
        WebElement savePortButton = driver.findElement(By.id("save-portal-button"));
        savePortButton.click();
        
        
        
        Thread.sleep(7000);
        driver.quit();

    }

}
