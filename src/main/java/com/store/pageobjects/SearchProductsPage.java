package com.store.pageobjects;

import java.util.List;
import java.util.Random;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actiondrivers.ActionDriver;
import com.store.base.BaseClass;

public class SearchProductsPage extends BaseClass {
	
	@FindBy(xpath = "//img[contains(@src, 'get_product_picture')]")
	List<WebElement> productImages;
	
	
	private WebElement getAddToCartLink(WebElement image) {
	    return image.findElement(
	        By.xpath(
	            "./ancestor::div[contains(@class,'product-image-wrapper')]" +
	            "//div[contains(@class,'product-overlay')]" +
	            "//div[contains(@class,'overlay-content')]" +
	            "/a[contains(@class,'add-to-cart')]"
	        )
	    );
	}
	  
	  @FindBy(xpath = "//button[text()='Continue Shopping']")
	  WebElement continueShoppingBtn;
	  
	  
	  @FindBy(xpath = "//a[text()=' Cart']")
	  WebElement cartBtn;
	  
	  
	  @FindBy(id = "search_product")
	  WebElement productSearchBox;
	
	
	public SearchProductsPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickSvgArrow() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(
	        "document.querySelector('grippy-host')?.shadowRoot" +
	        "?.querySelector('svg g.down')?.dispatchEvent(" +
	        "new MouseEvent('click', {bubbles:true}))"
	    );
	}
	
	public ViewCartPage addRandomProductsToCart() throws Throwable {
        action.implicitWait(getDriver(), 5);
        Random random = new Random();
        
        List<WebElement> images = productImages;

        int maxProducts = Math.min(30, productImages.size());

        // pick random product
        int index = random.nextInt(maxProducts);
        WebElement image = images.get(index);

        // hover
        action.mouseOverElement(getDriver(), image);

        // click Add to Cart
        WebElement addToCart = getAddToCartLink(image);
        action.explicitWait(getDriver(), addToCart, 10);
        
        action.JSClick(getDriver(), addToCart);

        // handle Continue Shopping popup
        action.explicitWait(getDriver(), continueShoppingBtn, 5);
        action.JSClick(getDriver(), continueShoppingBtn);

        // wait until popup disappears
        action.implicitWait(getDriver(), 2);
        action.click(getDriver(), cartBtn);
        return new ViewCartPage();
    }
	
	public boolean validateProductPage()
	{
		return action.isDisplayed(getDriver(), productSearchBox);
	}

}
