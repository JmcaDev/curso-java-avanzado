package com.devtalles.proyecto.category;

import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO {
    private final Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public Category save(Category category) {
        String sql = "INSERT INTO categories (name) VALUES (?) RETURNING id";

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, category.getName());

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    long id =  resultSet.getLong("id");
                    category.setId(id);
                    System.out.println("Categoria creada exitosamente...");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return category;
    }

    private void message(int rows,String success, String fail){
        if(rows>0){
            System.out.println(success);
        }else if(!fail.isBlank()){
            System.out.println(fail);
        }
    }
}
