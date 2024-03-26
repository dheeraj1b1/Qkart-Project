package QKART_SANITY_LOGIN.Module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/checkout";

    public Checkout(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckout() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }

    /*
     * Return Boolean denoting the status of adding a new address
     */
    public Boolean addNewAddress(String addresString) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Click on the "Add new address" button, enter the addressString in the address
             * text box and click on the "ADD" button to save the address
             */

            WebElement addnewAddress = driver.findElement(By.id("add-new-btn"));
            addnewAddress.click();

            WebElement textArea = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[2]/div[1]/div/textarea[1]"));
            textArea.sendKeys(addresString);
            Thread.sleep(3000);

            WebElement addAdress = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
            addAdress.click();

            return false;
        } catch (Exception e) {
            System.out.println("Exception occurred while entering address: " + e.getMessage());
            return false;

        }
    }

    /*
     * Return Boolean denoting the status of selecting an available address
     */
    public Boolean selectAddress(String addressToSelect) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through all the address boxes to find the address box with matching
             * text, addressToSelect and click on it
             */
            List<WebElement> addressBoxes = driver.findElements(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[1]/div/div[1]"));

        for (WebElement addressBox : addressBoxes) {
            if (addressBox.getText().equals(addressToSelect)) {
                addressBox.click();
                Thread.sleep(3000);
                return true;
            }
        }
        Thread.sleep(3000);
            System.out.println("Unable to find the given address");
            return false;
        } catch (Exception e) {
            System.out.println("Exception Occurred while selecting the given address: " + e.getMessage());
            return false;
        }

    }

    /*
     * Return Boolean denoting the status of place order action
     */
    public Boolean placeOrder() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find the "PLACE ORDER" button and click on it
            
            WebElement placeOrder = driver.findElement(By.xpath("//*/div/div[2]/div[1]/div/button[2]"));
             Thread.sleep(2000);
             placeOrder.click();

        
            return false;

        } catch (Exception e) {
            System.out.println("Exception while clicking on PLACE ORDER: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean denoting if the insufficient balance message is displayed
     */
    public Boolean verifyInsufficientBalanceMessage() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 07: MILESTONE 6
            
            // Find the insufficient balance message element
        WebElement insufficientBalanceMessage = driver.findElement(By.className("SnackbarItem-wrappedRoot"))
                .findElement(By.id("notistack-snackbar"));

        // Get the text of the insufficient balance message
        String messageText = insufficientBalanceMessage.getText();

        // Verify that the message content matches the expected value
        String expectedMessage = "You do not have enough balance in your wallet for this purchase";
        if (messageText.equals(expectedMessage)) {
            return true; // Message content matches
        } else {
            System.out.println("Insufficient balance message does not match the expected content.");
            return false;
        }
          
            //return false;
        } catch (Exception e) {
            System.out.println("Exception while verifying insufficient balance message: " + e.getMessage());
            return false;
        }
    }
}
