package spring.com.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestConnection {

	   private static final Logger log = LoggerFactory.getLogger(TestConnection.class);

		public static void main(String[] argv) {

			System.out.println("-------- PostgreSQL "
					+ "JDBC Connection Testing ------------");

			try {

				Class.forName("org.postgresql.Driver");

			} catch (ClassNotFoundException e) {

				System.out.println("Where is your PostgreSQL JDBC Driver? "
						+ "Include in your library path!");
				e.printStackTrace();
				return;

			}

			System.out.println("PostgreSQL JDBC Driver Registered!");

			Connection connection = null;

			try {

				connection = DriverManager.getConnection(
						"jdbc:postgresql://127.0.0.1:5433/MusicDB", "prospring5","9832348798");

			} catch (SQLException e) {

				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;

			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
		
			log.trace("Hello World!");
			
			String name = "Abhijit";
			log.debug("Hi, {}", name);
			log.info("Welcome to the HelloWorld example of Logback.");
			log.warn("Dummy warning message.");
			log.error("Dummy error message.");
			
			log.info("Exiting application");
		}

}

