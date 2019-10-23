package vancoffee.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static vancoffee.costant.AppConstants.*;






public class DataSourceFactory {
    private final static Logger LOG = Logger.getLogger(DataSourceFactory.class);

    private final static DataSourceFactory INSTANCE = new DataSourceFactory();

    private static DataSource dataSource;

    private DataSourceFactory() {
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceFactory.class.getResourceAsStream(DB_PROPERTIES));
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(properties.getProperty(DB_URL));
            mysqlDataSource.setDatabaseName(properties.getProperty(DB_NAME));
            mysqlDataSource.setCharacterEncoding(properties.getProperty(DB_CHARACTER_ENCODING));
            mysqlDataSource.setUser(properties.getProperty(DB_USERNAME));
            mysqlDataSource.setPassword(properties.getProperty(DB_PASSWORD));
            dataSource = mysqlDataSource;
            LOG.info("DataSource is created" + dataSource);
        } catch (IOException e) {
            LOG.error("Error while reading properties from file!",e);
        }catch (SQLException e){
            LOG.error("Error while setting Data source");
        }
    }

     public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (SQLException e){
            LOG.error("Error while connection creation", e);
        }
        return connection;
     }

     public static PreparedStatement getPreparedStatement(String query) throws SQLException{
        return getConnection().prepareStatement(query);
     }
}
