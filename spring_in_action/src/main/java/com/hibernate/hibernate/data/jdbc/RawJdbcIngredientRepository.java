package com.hibernate.hibernate.data.jdbc;

import com.hibernate.hibernate.entity.Ingredient;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RawJdbcIngredientRepository implements IngredientRepository {

    private final DataSource dataSource;

    public RawJdbcIngredientRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "select id, name, type from Ingredient where id=?"
            );
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;

            if(resultSet.next()){

                ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type"))

                );
            }
            assert ingredient != null;
            return Optional.of(ingredient);

        }catch(SQLException e){


        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {

                }
            }
            if(statement != null) {
                try {
                    statement.close();
                }catch (SQLException ex){

                }
            }

            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){

                }
            }


        }
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
