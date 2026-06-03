package com.devtalles.proyecto.postgress;

import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.time.LocalDate;

@RequiredArgsConstructor
public class PersonDAO {

    private final Connection connection;

    public void save(Person person) throws SQLException {
        String sql = "INSERT INTO persons (name, birth_Date) VALUES (?, ?)";

        try(
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, person.getName());
            statement.setDate(2, Date.valueOf(person.getBirthDate()));
            int rows = statement.executeUpdate();
            message(rows, "La persona fue ingresada correctamente", "");
        }
    }

    public Person findById(int id) throws SQLException {
        String sql ="SELECT * FROM persons WHERE id = ?";

        try(
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String name =  resultSet.getString("name");
                LocalDate birthDate =  resultSet.getDate("birth_date").toLocalDate();

                return new Person(id, name, birthDate);
            }else{
                System.out.println("No se encontro la persona con ID: " + id);
                return null;
            }
        }
    }

    private void message(int rows,String success, String fail){
        if(rows>0){
            System.out.println(success);
        }else if(!fail.isBlank()){
            System.out.println(fail);
        }
    }
}
