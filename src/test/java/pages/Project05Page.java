package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project05Page {

    public Project05Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".mb-5 h1")
    public WebElement heading;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement content;

    @FindBy(id = "previous")
    public WebElement previous;

    @FindBy(id = "next")
    public WebElement next;



}
