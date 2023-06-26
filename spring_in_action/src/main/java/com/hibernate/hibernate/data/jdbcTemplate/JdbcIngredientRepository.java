package com.hibernate.hibernate.data.jdbcTemplate;

import com.hibernate.hibernate.config.DataSourceSingleton;
import com.hibernate.hibernate.data.jdbc.IngredientRepository;
import com.hibernate.hibernate.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientJdbcTemplateRepository {


    private final JdbcTemplate jdbcTemplate;
    public JdbcIngredientRepository(){
        this.jdbcTemplate = new JdbcTemplate(DataSourceSingleton.getDataSource());
    }
    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> ingredientFromDB = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id
        );

        return ingredientFromDB.size() == 0 ?
                Optional.empty():
                Optional.of(ingredientFromDB.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient(id, name, type)" +
                        "values(?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNUm) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type"))
        );
    }

}
