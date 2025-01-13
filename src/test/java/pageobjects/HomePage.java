package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.Base;

public class HomePage extends Base {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.brand ")
    WebElement logo;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/div[1]/div[2]/a[2]")
    WebElement quantity;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    WebElement addToCart;

    @FindBy(xpath = "//img[@alt='Cart']")
    WebElement cart;

    @FindBy(css = ".cart-icon")
    WebElement proceedToCheckout;

    public String getLogo() {
        return logo.getText();
    }

    public void setQuantity(int giveInput) {
        int n = giveInput;
        for (int i = 1; i < n; i++) {
            quantity.click();
        }

    }

    public void addToCart() {
        addToCart.click();

    }

    public void proceedToCheckout() throws InterruptedException {
        Thread.sleep(5000);
        proceedToCheckout.click();
    }
}
