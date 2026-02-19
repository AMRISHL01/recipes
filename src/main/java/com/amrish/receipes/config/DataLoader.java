package com.amrish.receipes.config;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.amrish.receipes.entity.Recipe;
import com.amrish.receipes.repository.RecipeRepository;

import jakarta.annotation.PostConstruct;
import tools.jackson.databind.ObjectMapper;

@Component
public class DataLoader {

    private final RecipeRepository repository;

    public DataLoader(RecipeRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() throws Exception {
        if (repository.count() > 0) {
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream =    getClass().getResourceAsStream("/recipes.json");
        
        if (inputStream == null) {
            throw new RuntimeException("recipes.json file not found!");
        }
        
        tools.jackson.databind.JsonNode rootNode =mapper.readTree(inputStream);
        // Your JSON is an OBJECT with numeric keys
        if (rootNode.isObject()) {
            for (tools.jackson.databind.JsonNode node : rootNode) {
                Recipe recipe =mapper.treeToValue(node, Recipe.class);
                repository.save(recipe);
            }
        } else {
            throw new RuntimeException("Unsupported JSON format");
        }
        System.out.println("Recipes loaded successfully!");
    }
}
