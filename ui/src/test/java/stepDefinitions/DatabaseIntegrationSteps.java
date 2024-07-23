package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseIntegrationSteps {
    private Connection connection;
    private ResultSet resultSet;

    @Given("the database is set up")
    public void theDatabaseIsSetUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(255))");
        statement.execute("INSERT INTO students (id, name) VALUES (1, 'John Doe'), (2, 'Jane Smith')");
    }

    @When("I query the students table")
    public void iQueryTheStudentsTable() throws Exception {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("SELECT * FROM students");
    }

    @Then("I should see the student with ID {int} and name {string}")
    public void iShouldSeeTheStudentWithIDAndName(int id, String name) throws Exception {
        boolean found = false;
        resultSet.beforeFirst(); // Move cursor to the beginning
        while (resultSet.next()) {
            if (resultSet.getInt("id") == id && resultSet.getString("name").equals(name)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("Student with ID " + id + " and name " + name + " not found", found);
    }

    @Then("I print the students table")
    public void iPrintTheStudentsTable() throws Exception {
        resultSet.beforeFirst(); // Move cursor to the beginning
        System.out.println("ID | Name");
        System.out.println("-----------");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " | " + name);
        }
    }

    @After
    public void tearDown() throws Exception {
        if (resultSet != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
