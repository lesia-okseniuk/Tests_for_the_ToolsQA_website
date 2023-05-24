package demoqa.tests;

import com.github.javafaker.Faker;
import demoqa.steps.WebTablesSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;
import java.util.Random;

public class WebTablesTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.verifyThatWebTablesHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void numberOfColumnsTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.numberOfColumns();
    }
    @Test
    @SneakyThrows
    public void resizingAColumnTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.resizingAColumn();
    }
    @Test
    @SneakyThrows
    public void testForNumberOfRowsSelection() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.checkNumberOfRowsSelection();
    }
    @Test
    @SneakyThrows
    public void numberOfSearchResultsTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.assertThatSearchFindsAllTheMatchingRecords();
    }
    @Test
    @SneakyThrows
    public void searchTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.canSearchByAllColumnValues();
    }
    @Test
    @SneakyThrows
    public void deleteAllRecordsTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.deleteAllRecords();
    }
    @Test(priority = 1)
    @SneakyThrows
    public void addNewRecordTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.addNewRecord(
                "Harry",
                "Potter",
                "harry.potter@gmail.com",
                "30",
                "1000",
                "IT");
    }
    @Test(dependsOnMethods = "addNewRecordTest", priority = 3)
    @SneakyThrows
    public void delete4thRecordTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        webTablesSteps.delete4thRecord();
    }
    @Test(dependsOnMethods = "addNewRecordTest", priority = 2)
    @SneakyThrows
    public void editRecordTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        webTablesSteps.editRecord();
    }
    @Test(dataProvider = "validRegistrationData")
    @SneakyThrows
    public void addRecordWithDataProviderTest(String firstName, String lastName, String email, String age, String salary, String department) {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.addNewRecord(firstName, lastName, email, age, salary, department);
    }
    @Test
    @SneakyThrows
    public void paginationTest() {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");

        webTablesSteps.selectNumberOfRows("20 rows");

        for (int i = 1; i < 9; i++) { // Filling in the table with records
        Random random = new Random();
        int randomAge = random.nextInt(82) + 18;
        String age = Integer.toString(randomAge);
        int randomSalary = random.nextInt(99001) + 1000;
        String salary = Integer.toString(randomSalary);
        Faker faker = new Faker();
        webTablesSteps.addNewRecord(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), age, salary, faker.job().field());
        }

        webTablesSteps.selectNumberOfRows("5 rows");

        webTablesSteps.checkPagination();
    }
    @Test(dataProvider = "invalidRegistrationData")
    @SneakyThrows
    public void failToAddANewRecordTest(String firstName, String lastName, String email, String age, String salary, String department) {
        WebTablesSteps webTablesSteps = new WebTablesSteps();
        visit("webtables");
        webTablesSteps.failToAddANewRecord(firstName, lastName, email, age, salary, department);
    }
}
