package demoqa.steps;

import demoqa.pages.WebTablesPage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class WebTablesSteps {
    WebTablesPage webTablesPage = new WebTablesPage();
    public void verifyThatWebTablesHeaderMatches() {
        webTablesPage.assertThatWebTablesHeaderExists();
    }
    public void numberOfColumns() {
        webTablesPage.verifyNumberOfColumns();
    }
    public void resizingAColumn() {
        webTablesPage.maximizeWindow();
        int initialWidth = webTablesPage.getWidthOfTheLastNameColumn();
        System.out.println(initialWidth);
        webTablesPage.resizeTheColumn();
        int newWidth = webTablesPage.getWidthOfTheLastNameColumn();
        System.out.println(newWidth);
        webTablesPage.assertThatWidthWasChanged(initialWidth, newWidth);
    }
    public void selectNumberOfRows(String numberOfRows) {
        webTablesPage.selectNumberOfRows(numberOfRows);
    }
    public void checkNumberOfRowsSelection() {
        webTablesPage.maximizeWindow();
        List<String> rows = Arrays.asList("5 rows", "10 rows", "20 rows", "25 rows", "50 rows", "100 rows");
        Random random = new Random();
        int randomRowIndex = random.nextInt(rows.size());
        String selectedRowOption = rows.get(randomRowIndex);
        System.out.println(selectedRowOption);
        webTablesPage.selectNumberOfRows(selectedRowOption);
        int numberOfRows = Integer.parseInt(selectedRowOption.split(" ")[0]) + 1;
        int actualNumberOfRows = webTablesPage.getActualNumberOfRows();
        System.out.println(actualNumberOfRows);
        webTablesPage.assertThatActualNumberOfRowsIsAsExpected(actualNumberOfRows, numberOfRows);
        if (actualNumberOfRows == numberOfRows) {
            System.out.println("Test passed - Number of rows match the selected option");
        } else {
            System.out.println("Test failed - Number of rows do not match the selected option");
        }
    }
    public void assertThatSearchFindsAllTheMatchingRecords() {
        webTablesPage.maximizeWindow();
        String searchQuery = "ierra";
        webTablesPage.search(searchQuery);
        webTablesPage.searchFindsAllTheMatchingRecords(searchQuery, 2);
        webTablesPage.assertThatTableContainsText("Vega");
        webTablesPage.assertThatTableContainsText("Legal");
    }
    public void canSearchByAllColumnValues() {
        webTablesPage.maximizeWindow();
        List<String> columnValues = Arrays.asList("Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance");
        Random random = new Random();
        int randomRowIndex = random.nextInt(columnValues.size());
        String selectedColumnValue = columnValues.get(randomRowIndex);
        System.out.println(selectedColumnValue);
        webTablesPage.search(selectedColumnValue);
        webTablesPage.searchFindsAllTheMatchingRecords(selectedColumnValue, 1);
        webTablesPage.assertThatTableContainsText("Alden");
        webTablesPage.assertThatTableDoesntContainText("ierra");
    }
    public void deleteAllRecords() {
        webTablesPage.maximizeWindow();
        webTablesPage.deleteAllRecords(3);
        webTablesPage.assertThatTableTextContainsText("No rows found");
    }
    public void delete4thRecord() {
        webTablesPage.delete4thRecord();
        webTablesPage.assertThatTableTextDoesntContainText("Harry");
        webTablesPage.assertThatTableTextDoesntContainText("Potter");
        webTablesPage.assertThatTableTextDoesntContainText("harry.potter@gmail.com");
    }
    public void editRecord() {
        webTablesPage.search("potter");
        webTablesPage.clickEditButton();
        webTablesPage.editLastNameField("Snotter");
        webTablesPage.clickSubmitButton();
        webTablesPage.assertThatTableTextContainsText("Snotter");
        webTablesPage.assertThatTableTextDoesntContainText("Potter");
    }
    public void addNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        webTablesPage.maximizeWindow();
        webTablesPage.clickAddNewRecordButton();
        webTablesPage.fillingInRegistrationForm(firstName, lastName, email, age, salary,department);
        webTablesPage.clickSubmitButton();
        webTablesPage.assertThatTableTextContainsText(firstName);
        webTablesPage.assertThatTableTextContainsText(lastName);
        webTablesPage.assertThatTableTextContainsText(email);
        webTablesPage.assertThatTableTextContainsText(age);
        webTablesPage.assertThatTableTextContainsText(salary);
        webTablesPage.assertThatTableTextContainsText(department);
    }
    public void checkPagination() {
        webTablesPage.clickNextButton();
        webTablesPage.assertNumberOfPage("2");
        webTablesPage.clickNextButton();
        webTablesPage.assertNumberOfPage("3");
        webTablesPage.clickPreviousButton();
        webTablesPage.assertNumberOfPage("2");
        webTablesPage.clickPreviousButton();
        webTablesPage.assertNumberOfPage("1");
        webTablesPage.goToPage("3");
        webTablesPage.clickPreviousButton();
        webTablesPage.assertNumberOfPage("2");
        webTablesPage.clickPreviousButton();
        webTablesPage.assertNumberOfPage("1");
    }
    public void failToAddANewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        webTablesPage.maximizeWindow();
        webTablesPage.clickAddNewRecordButton();
        webTablesPage.fillingInRegistrationForm(firstName, lastName, email, age, salary,department);
        webTablesPage.clickSubmitButton();
        webTablesPage.assertThatTableDoesntContainText(firstName);
        webTablesPage.assertThatTableDoesntContainText(lastName);
        webTablesPage.assertThatTableDoesntContainText(email);
    }
}
