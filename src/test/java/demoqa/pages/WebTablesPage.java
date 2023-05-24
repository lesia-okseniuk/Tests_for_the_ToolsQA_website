package demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


public class WebTablesPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(tagName = "select")
    WebElement rowCountDropdown;
    @FindBy(className = "rt-resizable-header-content")
    List<WebElement> columns;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div[2]")
    WebElement lastNameColumnResizer;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div[1]")
    WebElement lastNameColumnHeader;
    @FindBy(id = "searchBox")
    WebElement searchBox;
    @FindBy(css = ".rt-tbody")
    WebElement tableBody;
    @FindBy(className = "rt-tr-group")
    List<WebElement> rows;
    @FindBy(css = ".ReactTable")
    WebElement table;
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;
    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "userEmail")
    WebElement emailField;
    @FindBy(id = "age")
    WebElement ageField;
    @FindBy(id = "salary")
    WebElement salaryField;
    @FindBy(id = "department")
    WebElement departmentField;
    @FindBy(id = "submit")
    WebElement submitButton;
    @FindBy(id = "delete-record-4")
    WebElement delete4thRecordButton;
    @FindBy(xpath = "//*[starts-with(@id, 'edit-record-')]")
    WebElement editButton;
    @FindBy(className = "-next")
    WebElement nextButton;
    @FindBy(className = "-previous")
    WebElement previousButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[1]/div/input")
    WebElement numberOfPage;

    public void assertThatWebTablesHeaderExists() {
        assertThat(header.getText()).isEqualTo("Web Tables");
    }

    public void maximizeWindow() { driver.manage().window().maximize(); }
    public void verifyNumberOfColumns() {
        assertThat(columns.size()).isEqualTo(7);
        for (WebElement column : columns) {
            System.out.println(column.getText());
        }
    }
    public int getWidthOfTheLastNameColumn() {
        return lastNameColumnHeader.getSize().getWidth();
    }
    public void resizeTheColumn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(lastNameColumnResizer)
                .clickAndHold().moveByOffset(100, 0).release().perform();
    }
    public void assertThatWidthWasChanged(int initialWidth, int newWidth) {
        assertThat(initialWidth).isNotEqualTo(newWidth);
    }
    public void selectNumberOfRows(String selectedRowOption) {
        Select select = new Select(rowCountDropdown);
        select.selectByVisibleText(selectedRowOption);
    }
    public int getActualNumberOfRows() {
        List<WebElement> rowsElements = driver.findElements(By.cssSelector(".rt-tr"));
        return rowsElements.size();}
    public void assertThatActualNumberOfRowsIsAsExpected (int actualNumberOfRows, int numberOfRows) {
        assertThat(actualNumberOfRows)
                .as("Number of rows match the selected option")
                .isEqualTo(numberOfRows);
    }
    public void search(String searchQuery) {
        searchBox.clear();
        searchBox.sendKeys(searchQuery);
    }
    public void searchFindsAllTheMatchingRecords(String searchQuery, int expectedNumberOfRecords) {
        List<WebElement> filteredElements = rows.stream()
                .filter(element -> element.getText().contains(searchQuery))
                .collect(Collectors.toList());
        assertThat(filteredElements).hasSize(expectedNumberOfRecords);
    }
    public String getTableText() {
        String tableText = tableBody.getText();
        return tableText;
    }
    public void assertThatTableContainsText(String expectedText) {
        assertThat(getTableText()).contains(expectedText);
    }
    public void assertThatTableDoesntContainText(String expectedText) {
        assertThat(getTableText()).doesNotContain(expectedText);
    }
    public void deleteAllRecords(int expectedNumberOfRecords) {
        for (int i = 1; i <= expectedNumberOfRecords; i++) {
            WebElement deleteButton = driver.findElement(By.id("delete-record-" + i));
            deleteButton.click();
        }
    }
    public String tableText() {
        return table.getText();
    }
    public void assertThatTableTextContainsText(String expectedText) {
        assertThat(tableText()).contains(expectedText);
    }
    public void assertThatTableTextDoesntContainText(String expectedText) {
        assertThat(tableText()).doesNotContain(expectedText);
    }
    public void clickAddNewRecordButton() {
        addNewRecordButton.click();
    }
    public void fillingInRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        ageField.clear();
        ageField.sendKeys(age);
        salaryField.clear();
        salaryField.sendKeys(salary);
        departmentField.clear();
        departmentField.sendKeys(department);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void delete4thRecord() {
        delete4thRecordButton.click();
    }
    public void clickEditButton() {
        editButton.click();
    }
    public void editLastNameField(String newInput) {
        lastNameField.clear();
        lastNameField.sendKeys(newInput);
    }
    public void clickNextButton() {
        nextButton.click();
    }
    public void clickPreviousButton() {
        previousButton.click();
    }
    public void assertNumberOfPage(String expectedNumberOfPage) {
        assertThat(numberOfPage.getAttribute("value")).isEqualTo(expectedNumberOfPage);
    }
    public void goToPage(String pageNumber) {
        numberOfPage.clear();
        numberOfPage.sendKeys(pageNumber);
        numberOfPage.sendKeys(Keys.ENTER);
    }
}
