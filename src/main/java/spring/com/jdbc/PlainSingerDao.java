package spring.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlainSingerDao implements SingerDao {

	private static final Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);
	
	static{
			try 
			{
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				logger.error("Driver not found!", e);
			}
	}
	
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5433/MusicDB", "prospring5","9832348798");
		} catch (SQLException e) {
			logger.error("Error connecting", e);
		}
		
		return null;
	}
	
	private void closeConnection(Connection connection){
		if(connection == null)
			return;
		
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error("Error closing connection", e);
		}
	}
	
	@Override
	public List<Singer> findAll() {
		List<Singer> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement =
			connection.prepareStatement("select * from \"MusicSchema\".\"Singer\"");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Singer singer = new Singer();
				singer.setId(resultSet.getLong("id"));
				singer.setFirstName(resultSet.getString("first_name"));
				singer.setLastName(resultSet.getString("last_name"));
				singer.setBirthDate(resultSet.getDate("birth_date"));
				result.add(singer);
			}
			
			statement.close();
		} catch (SQLException ex) {
			logger.error("Problem when executing SELECT!",ex);
		} finally {
			closeConnection(connection);
		}
		
		return result;
	}
	
	
	@Override
	public List<Singer> firstByFirstName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(Singer singer) {
	Connection connection = null;
	try {
		connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement(
		"insert into \"MusicSchema\".\"Singer\" (first_name, last_name, birth_date)values (?, ?, ?)"
		, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, singer.getFirstName());
		statement.setString(2, singer.getLastName());
		statement.setDate(3, singer.getBirthDate());
		statement.execute();
		System.out.println("Done");
		
		ResultSet generatedKeys = statement.getGeneratedKeys();
		
		if (generatedKeys.next()) {
			singer.setId(generatedKeys.getLong(1));
	}
		statement.close();
	} catch (SQLException ex) {
		logger.error("Prblem executing INSERT", ex);
	} finally {
		closeConnection(connection);
	}
	}

	@Override
	public void update(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long singerId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement
					("delete from \"MusicSchema\".\"Singer\" where id=?");
				statement.setLong(1, singerId);
				statement.execute();
				statement.close();
			} catch (SQLException ex) {
				logger.error("Prblem executing DELETE", ex);
			} finally {
				closeConnection(connection);
			}
		}

	@Override
	public List<Singer> findAllWithDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithDetail(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	private static SingerDao singerDao = new PlainSingerDao();
	public static void main(String args[]) {
		
			logger.info("Listing initial singer data:");
			listAllSingers();
			logger.info("-------------");
			logger.info("Insert a new singer");
			
			Singer singer = new Singer();
			
			singer.setFirstName("Ed");
			singer.setLastName("Sheeran");
			singer.setBirthDate(new Date((new GregorianCalendar(1991, 2, 1991)).getTime().getTime()));
			
			singerDao.insert(singer);
			
			logger.info("Listing singer data after new singer created:");
			listAllSingers();
			
			logger.info("-------------");
			logger.info("Deleting the previous created singer");
			
			singerDao.delete(singer.getId());
			logger.info("Listing singer data after new singer deleted:");
			
			listAllSingers();
		}
	
		private static void listAllSingers() {
		List<Singer> singers = singerDao.findAll();
			for (Singer singer: singers) {
					logger.info(singer.toString());
			}
		}

		@Override
		public String findFirsttNameById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String findLastNameById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
}
