package net.sindrenj.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {
	//Connection details:
		private  static String host = "127.0.0.1";
		private  static String port = "3306";
		private  static String db = "movie_rating";
		private  static String user = "root";
		private  static String password = "";
		private  static String type = "mysql";
		//Connection:
		private  Connection conn = null;
		
		public static MysqlDataSource getDatasource() {
			MysqlDataSource dataSource = new MysqlDataSource (); 
			dataSource.setServerName(host); 
			dataSource.setUser(user); 
			dataSource.setPassword(password); 
			dataSource.setDatabaseName(db); 
			return dataSource;
		}
		
		public void connect() {
			System.out.println("Hello! Testing database..");
			try {
				//Add user/password:
				Properties prop = new Properties();
				prop.put("user", user);
				prop.put("password", password);
				//Connect:
				conn = DriverManager.getConnection("jdbc:" + type + "://" + 
										host + ":" + port + "/" + db, prop);
				System.out.println("The connection were successfully created!");
			} catch(SQLException e) {
				System.out.println("Oh noes :(. Some error occured:");
				System.out.println(e.getMessage());
			}
		}
		
		public void select() throws SQLException {
			//Define the query:
			String sql = "SELECT person, film, rate FROM rating ORDER BY person";
			//Create the statement:
			Statement stmt = conn.createStatement();
			//Notify the user:
			System.out.println("Performing sql-query..");
			//Execute the query and get the results:
			ResultSet rs = stmt.executeQuery(sql);
			//Show the result:
			while( rs.next() ) {
				System.out.println("Person: " + rs.getString("person") + ",Film: " + 
					  rs.getString("film") + ", Rating: " + rs.getString("rate"));
			}
		}
		
		public ArrayList<User> getRatings() throws SQLException {
			ArrayList<User> ratings = new ArrayList<User>();
			//Define the sql-query:
			String sql = "SELECT person, film, rate FROM rating ORDER BY person";
			
			return null;
		}
}
