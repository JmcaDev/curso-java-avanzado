package com.devtalles.proyecto.category.persistence;

import com.devtalles.proyecto.category.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO {

    public Optional<Category> save(Connection connection, Category category) throws SQLException {
        String sql = "INSERT INTO categories (name) VALUES (?) RETURNING id";

        try(
                PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ){
            statement.setString(1, category.getName());
            int rows =  statement.executeUpdate();

            if(rows>0){
                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    if(resultSet.next()){
                        long id = resultSet.getLong(1);
                        category.setId(id);
                        return Optional.of(category);
                    }
                }
                System.out.println("Categoria guardada exitosamente!");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la categoria: " + e.getMessage());
        }
        return Optional.empty();
    }

    public List<Category> findAll(Connection connection) throws SQLException {
        String sql = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();

        try(
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
        ){
            while (resultSet.next()){
                Category category = mapResult(resultSet);
                categories.add(category);
            }
        }

        return  categories;
    }

    public Optional<Category> findById(Connection connection, Long id) throws SQLException {
        String sql = "SELECT * FROM categories WHERE id = ?";

        try(
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery();){
                if(resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }

        }
        return  Optional.empty();
    }

    public Optional<Category> findCategoryByName(Connection connection, String categoryName) throws SQLException {
        String sql = "SELECT * FROM categories WHERE name = ?";

        try(
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, categoryName);
            try(ResultSet resultSet = statement.executeQuery();){
                if(resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }

        }
        return  Optional.empty();
    }

    public void update(Connection connection, Category category){
        String sql = "UPDATE categories SET name = ? WHERE id = ?";

        try(
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, category.getName());
            statement.setLong(2, category.getId());

            int rows  = statement.executeUpdate();
            message(rows, "Categoria Actualizada exitosamente", "No existe la categoria con el id: " + category.getId());
        } catch (SQLException e) {
            System.out.println("Error al actualizar la categoria: " + e.getMessage());;
        }
    }

    public void delete(Connection connection, Long id){
        String sql = "DELETE FROM categories WHERE id = ?";

        try(
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1, id);
            int rows  = statement.executeUpdate();

            message(rows, "Categoria eliminada exitosamente", "No existe la categoria con el id: " + id);
        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoria: " + e.getMessage());;
        }
    }

    private Category mapResult(ResultSet resultSet) throws SQLException {
        Category category = new Category(
          resultSet.getLong("id"),
          resultSet.getString("name")
        );
        return  category;
    }

    private void message(int rows,String success, String fail){
        if(rows>0){
            System.out.println(success);
        }else if(!fail.isBlank()){
            System.out.println(fail);
        }
    }
}
