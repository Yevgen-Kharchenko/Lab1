package vancoffee.dao;

import org.apache.log4j.Logger;
import vancoffee.entity.CoffeeType;

import java.util.List;

public class CoffeeTypeDao extends AbstractDao<CoffeeType>{
    private static final Logger LOG = Logger.getLogger(CoffeeTypeDao.class);

    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String SELECT_ALL = "SELECT * FROM coffee_type";

    private static final String INSERT_INTO_COFFEE_TYPE = "INSERT INTO coffee_type ("
            + COLUMN_TYPE + ", "
            + COLUMN_WEIGHT + ") VALUE (?, ?)";

    private static final String UPDATE_COFFEE_TYPE = "UPDATE coffee_type "
            + COLUMN_TYPE + "= ?, "
            + COLUMN_WEIGHT + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_COFFEE_TYPE = "DELETE FROM coffee_type "
            + "WHERE " + COLUMN_ID + " =?";

    @Override
    public List<CoffeeType> getAll() {
        return getAll(SELECT_ALL, resultSet -> new CoffeeType(resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_TYPE),
                resultSet.getInt(COLUMN_WEIGHT)));
    }

    @Override
    public boolean create(CoffeeType entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_COFFEE_TYPE, ps ->{
                ps.setString(1, entity.getType());
                ps.setInt(2, entity.getWeight());
        });
    }

    @Override
    public boolean update(CoffeeType entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(UPDATE_COFFEE_TYPE, ps -> {
            ps.setString(1, entity.getType());
            ps.setInt(2, entity.getWeight());
            ps.setInt(3, entity.getId());
        });
    }

    @Override
    public boolean remove(CoffeeType entity) {
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_COFFEE_TYPE, ps -> ps.setInt(1, entity.getId()));
    }
}
