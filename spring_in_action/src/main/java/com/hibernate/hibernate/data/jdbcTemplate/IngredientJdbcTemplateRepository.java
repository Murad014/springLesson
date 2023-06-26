package com.hibernate.hibernate.data.jdbcTemplate;

import com.hibernate.hibernate.entity.Ingredient;

import java.util.Optional;


public interface IngredientJdbcTemplateRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
