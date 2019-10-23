package vancoffee.dao;

import org.apache.log4j.Logger;
import vancoffee.entity.CoffeeSort;

import java.util.List;

public class CoffeeSortDao extends AbstractDao<CoffeeSort> {
    private static final Logger LOG = Logger.getLogger(CoffeeSortDao.class);

    private static final String COLUMN_SORT = "sort";
    private static final String SELECT_ALL = "SELECT * FROM coffee_sort";

    private static final String INSERT_INTO_COFFEE_SORT = "INSERT INTO coffee_sort ("
            + COLUMN_SORT + ") VALUE (?)";

    private static final String UPDATE_COFFEE_SORT = "UPDATE coffee_sort "
            + COLUMN_SORT + " = ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_COFFEE_SORT = "DELETE FROM coffee_sort "
            + "WHERE " + COLUMN_ID + " =?";

    @Override
    public List<CoffeeSort> getAll() {
        return getAll(SELECT_ALL, resultSet -> new CoffeeSort(resultSet.getInt(COLUMN_ID), resultSet.getString(COLUMN_SORT)));
    }

    @Override
    public boolean create(CoffeeSort entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_COFFEE_SORT, ps ->
                ps.setString(1, entity.getSort()));
    }

    @Override
    public boolean update(CoffeeSort entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(UPDATE_COFFEE_SORT, ps -> {
            ps.setString(1, entity.getSort());
            ps.setInt(2, entity.getId());
        });
    }

    @Override
    public boolean remove(CoffeeSort entity) {
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_COFFEE_SORT,ps -> ps.setInt(1,entity.getId()));
    }

}
