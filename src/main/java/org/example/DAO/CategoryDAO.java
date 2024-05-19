package org.example.DAO;

import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM categories";


    public CategoryDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<Category> getAllCategories() {

        Connection connection = CONNECT.getConnect();

        List<Category> categories = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                Category category = new Category(resultSet.getInt("CATEGORY_ID"),
                        resultSet.getString("categoryName"),
                        resultSet.getString("categoryCreatedAt"),
                        resultSet.getString("categoryLastChange"));

                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all categories of them", e);
        }

        return categories;
    }

    public void insertCategory(Category category) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_CATEGORY = "INSERT INTO categories VALUES (%d, '%s', '%s')".formatted(category.getCATEGORY_ID(),
                category.getCategoryName(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_CATEGORY);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this category of them to data base", e);
        }
    }

    public void deleteCategoryByName(String name) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_CATEGORY = "DELETE FROM categories WHERE categoryName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_CATEGORY);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this category didn't occur", e);
        }
    }


    public void updateCategoryByName(String name, Category category) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_CATEGORY = "UPDATE categories SET categoryName = '%s', WHERE categoryName = %s".formatted(category.getCategoryName(), name);
        final String LAST_CHANGE = "UPDATE categories SET categoryLastChange = '%s', WHERE categoryName = %s".formatted(today.format(formatter), name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_CATEGORY);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the category failed", e);
        }
    }


    public Category getCategoryByName(String name) {

        Connection connection = CONNECT.getConnect();

        Category category = null;

        final String SELECT_CATEGORY = "SELECT * FROM categories WHERE categoryName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);

            while (resultSet.next()){
                if (resultSet.getString("categoryName").equals(name)) {
                    category = new Category(resultSet.getInt("CATEGORY_ID"),
                            resultSet.getString("categoryName"),
                            resultSet.getString("categoryCreatedAt"),
                            resultSet.getString("categoryLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this category of them", e);
        }

        return category;
    }
}
