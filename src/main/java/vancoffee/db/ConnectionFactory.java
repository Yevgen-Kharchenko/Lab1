package vancoffee.db;

import com.mysql.cj.jdbc.Driver;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static vancoffee.costant.AppConstants.*;

public class ConnectionFactory {
    private static final Logger LOG = Logger.getLogger(ConnectionFactory.class);
    private static final ConnectionFactory INSTANCE = new ConnectionFactory();

    static {
        try {
            DriverManager.registerDriver(new Driver());

        } catch (SQLException e) {
            LOG.error("Error while registering driver");
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(ConnectionFactory.class.getResourceAsStream(DB_PROPERTIES));
            connection = DriverManager
                    .getConnection(properties.getProperty(DB_URL),
                    properties.getProperty(DB_USERNAME),
                    properties.getProperty(DB_PASSWORD));
        }catch (IOException e){
            LOG.error("Could not load properties!", e);
        }catch (SQLException e){
            LOG.error("Could not get connection!", e);
        }
        return connection;
    }
}
