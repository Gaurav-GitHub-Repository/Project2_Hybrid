package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage2 {

	WebDriver driver;
	
	public DashboardPage2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for cart
	By Cart = By.xpath("//div[@class='shop-menu pull-right']/ul/li[3]/a");
	//Locator for subscription
	By Subscription = By.xpath("//div[@class='single-widget']/h2");
	//Locator for email
	By Email = By.xpath("//div[@class='single-widget']/form/input[2]");
	//Locator for button
	By Button = By.xpath("//div[@class='single-widget']/form/button");
	//Locator to verify subscription
	By SubscriptionSuccess = By.xpath("//div[text()='You have been successfully subscribed!']");
	
	//Locator for products
	By Product = By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a");
	//Locator for product category
	By Product_Category = By.xpath("//div[@class='panel-group category-products']");
	//Locator for add to cart
//	By AddCart1 = By.xpath("//a[@class='btn btn-default add-to-cart' and @data-product-id='1']/self::a");
	By AddCart1 = By.xpath("//a[@class='btn btn-default add-to-cart' and @data-product-id='1']");
	//Locator for continue button
	By ContinueButton = By.xpath("//div[@class='modal-content']/div[3]/button");
	//Locator for AddCart2
	By AddCart2 = By.xpath("//a[@data-product-id='2' and @class='btn btn-default add-to-cart']");
	//Locaotr forAddCart2 view cart
	By ViewCart = By.xpath("//div[@class='modal-content']/div[2]/p/a");
	//Locator for view product
	By ViewProduct = By.xpath("//div[@class='product-image-wrapper']/div[2]/ul/li/a[@href='/product_details/1']");
	//Locator for quantity
	By Quantity = By.xpath("//input[@id='quantity' and @value='1']");
	//Locator for Add to Cart
	By Add_to_Cart = By.xpath("//button[@class='btn btn-default cart']");
	//Locator for view cart
	By View_Cart = By.xpath("//div[@class='modal-content']/div/p[2]/a");
	//Locator to verify quantity
	By Product_Quantity = By.xpath("//table[@class='table table-condensed']/tbody/tr/td[4]/button");
	//Locator for webtable price
	By Table_Price = By.xpath("//table[@class='table table-condensed']/tbody/tr/td[3]/p[text()='Rs. 500']");
	//Locator for webtable quantity
	By Table_Quantity = By.xpath("//table[@class='table table-condensed']/tbody/tr/td[4]/button");
	//Locator for webtable total price
	By Table_TotalPrice = By.xpath("//table[@class='table table-condensed']/tbody/tr/td[5]/p");
	//Locator for product price
	By Price1 = By.xpath("//table[@id='cart_info_table']/tbody/tr/td[3]/p");
	//Locator for product price
	By Price2 = By.xpath("//table[@id='cart_info_table']/tbody/tr[2]/td[3]/p");
	//Locator for product information
	By Product_Information = By.xpath("//div[@class='product-information']");
	//Locator to delete product
	By Delete = By.xpath("//table[@class='table table-condensed']/tbody/tr/td[6]/a");
	//Locator to verify deleted product
	By DeleteProduct = By.xpath("//span[@id='empty_cart']/p");
	
	//Locator to verify categories
	By Category = By.xpath("//div[@class='left-sidebar']/h2");
	//Locator to verify women
	By Women = By.xpath("//div[@class='left-sidebar']/div/div/div/h4/a[@href='#Women']");
	//Locator to verify dress
	By Dress = By.xpath("//a[@href='/category_products/1']");
	//Locator to verify women dress products
	By WomenDressPage = By.xpath("//h2[@class='title text-center']");
	//Locator to click on men
	By Men = By.xpath("//a[@href='#Men']");
	//Locator to click on men shirts
	By MenShirt = By.xpath("//a[@href='/category_products/3']");
	//Locator to verify men products
	By MenProductPage = By.xpath("//h2[text()='Men - Tshirts Products']");
	//Locator for Polo brand
	By PoloBrand = By.xpath("//h2[@class='title text-center']");
	//Locator for H&M brand
	By HM_Brand = By.xpath("//a[@href='/brand_products/H&M']");
	//Locator to verify H&M brand
	By HMPage = By.xpath("//h2[@class='title text-center' and text()='Brand - H&M Products']");
	//Locator to add polo product
	By Polo_Product = By.xpath("//div[@class='product-image-wrapper']/div/div/a");
	
	//Locator for search
	By Search = By.xpath("//input[@name='search'and @id='search_product']");
	//Locator for search button
	By Search_Button = By.xpath("//button[@id='submit_search']");
	//Locator to verify search product page
	By Search_Page = By.xpath("//div[@class='features_items']/h2");
	//Locator to verify search product
	By Search_Product = By.xpath("//div[@class='product-overlay']/div/p");
	
	
	//Method to click on cart
	public void cart()
	{
		driver.findElement(Cart).click();
	}
	//Method to verifySubscriptiin
	public void verifySubscription()
	{
		String subscription = driver.findElement(Subscription).getText();
		System.out.println(subscription);
		Assert.assertEquals(subscription, "SUBSCRIPTION");
	}
	//Method to enter email
	public void email(String EmailAddress)
	{
		driver.findElement(Email).sendKeys(EmailAddress);
	}
	//Method to click on button
	public void button()
	{
		driver.findElement(Button).click();
	}
	//Method to verify subscription
	public void verifyCartSubscription()
	{
		String Success = driver.findElement(SubscriptionSuccess).getText();
		System.out.println(Success);
		Assert.assertEquals(Success, "You have been successfully subscribed!");
	}	
	//Method to click on product
	public void product() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Product).click();
	}
	//Method to verify product page
	public void verifyProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		if(driver.getTitle().equals("Automation Exercise - All Products"))
		{
			System.out.println("Product page is verified");
		}
		else
		{
			System.out.println("Product page is not verified");
		}
	}
	//Method to verify product category
	public void productCategory() throws InterruptedException
	{
		Thread.sleep(5000);
		String Product = driver.findElement(Product_Category).getText();
		System.out.println(Product);
//		Assert.assertEquals(Product,"WOMEN");
	}
	//Method to scroll
	public void scroll() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='brands_products']/h2[text()='Brands']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	//Method to scroll
	public void scrollDown() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	//Method to click on add to cart
	public void addCart() throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
		action.moveToElement(a).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(AddCart1));
		driver.findElement(AddCart1).click();
	}
	//Method to click on continue button
	public void continueButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(ContinueButton));
		driver.findElement(ContinueButton).click();
	}
	//Method to click on add cart2
	public void addCart2()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
		action.moveToElement(a).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(AddCart2));
		driver.findElement(AddCart2).click();
	}
	//Method to click on view cart
	public void viewCart() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(ViewCart).click();
		System.out.println(driver.getTitle());
	}
	//Method to click on view product
	public void viewProduct()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
		action.moveToElement(a).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(ViewProduct));
		driver.findElement(ViewProduct).click();
	}
	//Method to verify webtable price
	public void Price()
	{
		String Tab_Price = driver.findElement(Table_Price).getText();
		System.out.println(Tab_Price);
		Assert.assertEquals(Tab_Price, "Rs. 500");
	}	
	//Method to verify webtable quantity
	public void Quantity()
	{
		String Tab_Qty = driver.findElement(Table_Quantity).getText();
		System.out.println(Tab_Qty);
		Assert.assertEquals(Tab_Qty, "1");
	}
/*	//Method for total price
	public void TotalPrice()
	{
		String Tab_Price = driver.findElement(Table_Price).getText();
		System.out.println(Tab_Price);
		String Tab_Qty = driver.findElement(Table_Quantity).getText();
		System.out.println(Tab_Qty);
		String Tab_TotalPrice = Tab_Price*Tab_Qty; 
		System.out.println(Tab_TotalPrice); 
	} */
	//Method to verify webtable total price
	public void totalPrice()
	{
		String Tab_TotalPrice = driver.findElement(Table_TotalPrice).getText();
		System.out.println(Tab_TotalPrice);
		Assert.assertEquals(Tab_TotalPrice, "Rs. 500");
	}		
	//Method to verify product page
	public void verifyProductPage() throws InterruptedException
	{
		Thread.sleep(5000);
		if(driver.getTitle().equals("Automation Exercise - Product Details"))
		{
			System.out.println("Product cart details page is verified");
		}
		else
		{
			System.out.println("Product cart details page is not verified");
		}
	}	
	//Method to enter quantity
	public void quantity(String Qty) throws InterruptedException
	{
//		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Quantity));
		driver.findElement(Quantity).clear();
		Thread.sleep(1000);
		driver.findElement(Quantity).sendKeys(Qty);
	}
	//Method to Add to Cart
	public void addToCart()
	{
		driver.findElement(Add_to_Cart).click();
	}
	//Method to view cart
	public void ViewCart() throws InterruptedException 
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
//		wait.until(ExpectedConditions.presenceOfElementLocated(View_Cart));
		try {
			Thread.sleep(5000);
			driver.findElement(View_Cart).click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Method to verify product cat page
	public void verifyProductCartPage()
	{
		if(driver.getTitle().equals("Automation Exercise - Checkout"))
		{
			System.out.println("Product is displayed in cart page");
		}
		else
		{
			System.out.println("Product is not displayed in cart page");
		}
	}
	//Method to verify quantity
	public void verifyQuantity() throws InterruptedException
	{
		Thread.sleep(1000);
		String Qty = driver.findElement(Product_Quantity).getText();
		System.out.println(Qty);
		Assert.assertEquals(Qty, "4");
	}
	//Method to verify quantity
	public void productQuantity() throws InterruptedException
	{
		Thread.sleep(1000);
		String Qty = driver.findElement(Product_Quantity).getText();
		System.out.println(Qty);
		Assert.assertEquals(Qty, "1");
	}	
	//Method to verify product information
	public void verifyProductInformation()
	{
		String ProductInfo = driver.findElement(Product_Information).getText();
		System.out.println(ProductInfo);
		if(ProductInfo.contains("Availability: In Stock"))
		{
			System.out.println("Product is verified");
		}	
		else
		{
			System.out.println("Product is not verified");
		}
	}
	//Method to delete product
	public void deleteProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Delete).click();
	}
	//Method to verify deleted product
	public void verifyDeletedProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		String Del_Product = driver.findElement(DeleteProduct).getText();
		System.out.println(Del_Product);
		Assert.assertEquals(Del_Product, "Cart is empty! Click here to buy products.");
	}
	//Method to verify category
	public void verifyCategory() throws InterruptedException
	{
		Thread.sleep(5000);
		String category = driver.findElement(Category).getText();
		System.out.println(category);
		Assert.assertEquals(category, "CATEGORY");
	}
	//Method to click on women
	public void verifyWomen() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Women));
		driver.findElement(Women).click();
	}
	//Method to click on dress
	public void dress() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Dress).click();
	}
	//Method to verify women dress page
	public void verifyWomenDress()
	{
		String WomenPage = driver.findElement(WomenDressPage).getText();
		System.out.println(WomenPage);
		Assert.assertEquals(WomenPage,"WOMEN - DRESS PRODUCTS");
	}
	//Method to click on Men
	public void men() throws InterruptedException
	{
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Men));
		driver.findElement(Men).click();
	}
	//Method to click on men category
	public void menCategory() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(MenShirt).click();
	}
	//Method to verify men product page
	public void verifyMenPage() throws InterruptedException
	{
	   Thread.sleep(5000);
	   String MenPage = driver.findElement(MenProductPage).getText();
	   System.out.println(MenPage);
	   Assert.assertEquals(MenPage,"MEN - TSHIRTS PRODUCTS");
	}	
	//Method to verify brands
	public void verifyBrands() throws InterruptedException
	{
		String Brand = driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).getText();
		System.out.println(Brand);
		if(Brand.contains("POLO"))
		{
			System.out.println("Brand is verified");
		}
		else
		{
			System.out.println("Brand is not verified");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();	
	}
	//Method to verify polo brand
	public void verifyPolo()
	{
		String Polo_Brand = driver.findElement(PoloBrand).getText();
		System.out.println(Polo_Brand);
		Assert.assertEquals(Polo_Brand,"BRAND - POLO PRODUCTS");
	}
	//Method to click on H&M Brand
	public void verifyHM() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(HM_Brand).click();	
		String HM_Brand = driver.findElement(HMPage).getText();
		System.out.println(HM_Brand);
		Assert.assertEquals(HM_Brand,"BRAND - H&M PRODUCTS");
	}	
	//Method to click on search
	public void search(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Search).sendKeys(value);
	}
	//Method to click on search button
	public void searchButton()
	{
		driver.findElement(Search_Button).click();
	}
	//Method to verify search product page
	public void verifySearchPage()
	{
		String Search_ProductPage = driver.findElement(Search_Page).getText();
		System.out.println(Search_ProductPage);
		Assert.assertEquals(Search_ProductPage, "SEARCHED PRODUCTS");
	}
	//Method to verify search product
	public void verifySearchProduct()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//img[@src='/get_product_picture/30']"));
		action.moveToElement(a).build().perform();
		String Product = driver.findElement(Search_Product).getText();
		System.out.println(Product);
		Assert.assertEquals(Product, "Premium Polo T-Shirts");
	}
	//Method to verify search product
	public void PoloProduct()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//img[@src='/get_product_picture/30']"));
		action.moveToElement(a).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Polo_Product));
		driver.findElement(Polo_Product).click();
	}
	//Method to verify product price
	public void verifyPrice()
	{
		String productprice1 = driver.findElement(Price1).getText();
		System.out.println(productprice1);
		String productprice2 = driver.findElement(Price2).getText();
		if(productprice1.equals("Rs. 500"))
		{
			System.out.println("Product price is verified");
		}
		else
		{
			System.out.println("Product price is not verified");
		}
	}
}


