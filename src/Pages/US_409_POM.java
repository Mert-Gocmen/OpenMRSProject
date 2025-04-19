package Pages;

public class US_409_POM {

    @FindBy(linkText = "Data Management")
    public WebElement dataManagementLink;

    @FindBy(linkText = "Merge Patient Electronic Records")
    public WebElement mergePatientRecordsButton;

    @FindBy(css = "input#patient1")
    public WebElement patientIdField1;

    @FindBy(css = "input#patient2")
    public WebElement patientIdField2;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(), 'Merging cannot be undone')]")
    public WebElement mergeWarningMessage;

    @FindBy(xpath = "//input[@name='preferred']")
    public WebElement selectMergeTargetRadioButton;

    @FindBy(xpath = "//input[@value='Yes, Continue']")
    public WebElement yesContinueButton;

    @FindBy(css = ".float-sm-right span")
    public WebElement mergedPatientIdInfo;


}
