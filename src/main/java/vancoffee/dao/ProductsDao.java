package vancoffee.dao;

import vancoffee.entity.Products;
import org.apache.log4j.Logger;

import java.util.List;

public class ProductsDao extends AbstractDao<Products>{
private static final Logger LOG = Logger.getLogger(CoffeeTypeDao.class);

private static final String COLUMN_PRICE = "price";
private static final String COLUMN_SORT_ID = "sort_id";
private static final String COLUMN_TYPE_ID = "type_id";
private static final String COLUMN_ART = "art";
private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";

private static final String INSERT_INTO_PRODUCTS = "INSERT INTO products ("
        + COLUMN_PRICE + ", "
        + COLUMN_SORT_ID + ", "
        + COLUMN_TYPE_ID + ", "
        + COLUMN_ART + ") VALUE (?, ?, ?, ?)";

private static final String UPDATE_PRODUCTS = "UPDATE products "
        + COLUMN_PRICE + "= ?, "
        + COLUMN_SORT_ID + "= ?, "
        + COLUMN_TYPE_ID + "= ?, "
        + COLUMN_ART + "= ? WHERE "
        + COLUMN_ID + " = ?";

private static final String DELETE_PRODUCTS = "DELETE FROM products "
        + "WHERE " + COLUMN_ID + " =?";

@Override
public List<Products> getAll() {
        return getAll(SELECT_ALL_PRODUCTS, resultSet -> new Products(resultSet.getInt(COLUMN_ID),
        resultSet.getInt(COLUMN_ART),
        resultSet.getInt(COLUMN_SORT_ID),
        resultSet.getInt(COLUMN_TYPE_ID),
        resultSet.getDouble(COLUMN_PRICE)));
        }

@Override
public boolean create(Products entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_PRODUCTS, ps ->{
        ps.setDouble(1, entity.getPrice());
        ps.setInt(2, entity.getSort_id());
        ps.setInt(1, entity.getType_id());
        ps.setInt(2, entity.getArt());
        });
        }

@Override
public boolean update(Products entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(UPDATE_PRODUCTS, ps -> {
        ps.setDouble(1, entity.getPrice());
        ps.setInt(2, entity.getSort_id());
        ps.setInt(3, entity.getType_id());
        ps.setInt(4, entity.getArt());
        ps.setInt(5, entity.getId());
        });
        }

@Override
public boolean remove(Products entity) {
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_PRODUCTS, ps -> ps.setInt(1, entity.getId()));
        }
}
