package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
    Locatelerimizi tek bir yerde düzenli bir sekilde tutabilmek icin;
        1-Ilk olarak olusturmus oldugumuz Page Class'imizda bir constructor olustururuz
        2-PageFactory class'indan initelemets metodu ile driver'i tanitiriz.
        3-@FindBy notasyonu kullanarak Locate'lerimizi aliriz
     */

    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Driver.getDriver().findElement(By.xpath("locate))
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//h6")
    public WebElement dashboard;



}
