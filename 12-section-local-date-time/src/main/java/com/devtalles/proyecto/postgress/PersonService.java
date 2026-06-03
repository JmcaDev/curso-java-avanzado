package com.devtalles.proyecto.postgress;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonService {

    public void savePerson(Person person) throws SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            PersonDAO personDAO = new PersonDAO(connection);
            personDAO.save(person);
            connection.commit();

        } catch (SQLException e) {
            if(connection != null){
                connection.rollback();
            }
            System.out.println("Error: " + e.getMessage());
            throw e;
        }finally {
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    public Person findPersonById(int id) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection()){
            PersonDAO personDAO = new PersonDAO(connection);
            return personDAO.findById(id);
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
