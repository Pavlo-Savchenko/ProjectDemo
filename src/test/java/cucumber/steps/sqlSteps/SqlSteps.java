package cucumber.steps.sqlSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.util.CucumberStorage;

import java.sql.*;

public class SqlSteps {

    private ResultSet resultSetOfName;
    private ResultSet resultSetOfNewPhone;
    private Connection connection;
    private Statement statement;
    private String INSERT_PATTERN = "INSERT INTO IPhoneTable (NamePhone,PrisePhone)" +
            "VALUES ('%s', '%s')";

@When("I check availability of the phone in the database")
public void check() throws SQLException, ClassNotFoundException {
    connectionDb();
    //statement.execute("ALTER TABLE IPhoneTable CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci");
    //statement.execute("DELETE FROM IPhoneTable");
    try {
        resultSetOfName = statement.executeQuery("SELECT NamePhone FROM IPhoneTable WHERE NamePhone='"
                + CucumberStorage.HOLDER.get("NameMob").toString() + "'");
        System.out.println(CucumberStorage.HOLDER.get("NameMob").toString());
       // Assert.assertTrue(resultSetOfName.next(), "!!!!!!такого телефона немає в базі!!!!!");
    }finally {
        closeConnection();
    }
}
    @Then("I put phone and his price in DB")
            public void putNewPhone() throws SQLException, ClassNotFoundException {
        connectionDb();
        try{
            statement.execute(String.format(INSERT_PATTERN,CucumberStorage.HOLDER.get("NameMob").toString(),CucumberStorage.HOLDER.get("PriceMob").toString()) );
    }finally{
            closeConnection();
        }
}
@And("I update price of new phone")
public void updateValue() throws SQLException, ClassNotFoundException {
    connectionDb();
    try{
        statement.execute("UPDATE IPhoneTable SET PrisePhone = '"
                      +CucumberStorage.HOLDER.get("PriceMob").toString()+"' WHERE NamePhone = '"
                    +CucumberStorage.HOLDER.get("NameMob").toString() +"'");
    }finally{
        closeConnection();
    }
}

    private void connectionDb() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        if(resultSetOfName  != null){
            resultSetOfName.close();
        }
        //if(resultSetOfPrice  != null){
        //    resultSetOfPrice.close();
       // }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }
}
