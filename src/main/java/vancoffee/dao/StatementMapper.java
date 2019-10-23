package vancoffee.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementMapper<T> {
    void map(PreparedStatement ps) throws SQLException;
}
