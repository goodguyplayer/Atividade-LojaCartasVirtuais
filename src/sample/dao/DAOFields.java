package sample.dao;

/**
 * Like interface DAO, it contains the established method names for each class.
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}