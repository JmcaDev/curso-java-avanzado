package com.devtalles.proyecto.category.persistence;

import com.devtalles.proyecto.category.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public Category save(Category category){
        String sql = "INSERT INTO categories (name) VALUES (?) RETURNING id";

        try(
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, category.getName());

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    long id = resultSet.getLong("id");
                    category.setId(id);
                    System.out.println("Categoria Creada con exito");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al agregar la categoria: " + e.getMessage());;
        }

        return category;
    }

    public List<Category> findAll(){
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
        } catch (SQLException e) {
            System.out.println("Error al consultar las categoria: " + e.getMessage());;
        }

        return  categories;
    }

    public void update(Category category){
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

    public void delete(Long id){
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
