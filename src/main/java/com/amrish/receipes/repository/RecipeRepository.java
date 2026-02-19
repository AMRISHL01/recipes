package com.amrish.receipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.amrish.receipes.entity.Recipe;

public interface RecipeRepository 
    extends JpaRepository<Recipe, Long>, 
            JpaSpecificationExecutor<Recipe> {
}
