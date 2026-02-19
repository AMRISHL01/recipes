package com.amrish.receipes.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrish.receipes.entity.Recipe;
import com.amrish.receipes.repository.RecipeRepository;
import com.amrish.receipes.specification.RecipeSpecification;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeRepository repository;

    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }
    @GetMapping
    public Page<Recipe> getAllRecipes(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int limit) {
            Pageable pageable = PageRequest.of(
                page - 1,
                limit,
                Sort.by("rating").descending());

    return repository.findAll(pageable);
    }
    @GetMapping("/search")
    public Page<Recipe> searchRecipes(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) Integer totalTime,
        @RequestParam(required = false) String cuisine,
        @RequestParam(required = false) Float rating,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int limit) {
            
            Specification<Recipe> spec = (root, query, cb) -> null;
            
            if (title != null)
            spec = spec.and(RecipeSpecification.hasTitle(title));
            
            if (cuisine != null)
            spec = spec.and(RecipeSpecification.hasCuisine(cuisine));

            if (totalTime != null)
            spec = spec.and(RecipeSpecification.totalTimeLessThan(totalTime));
            
            if (rating != null)
            spec = spec.and(RecipeSpecification.ratingGreaterThan(rating));
            
            Pageable pageable = PageRequest.of(
                page - 1,
                limit,
                Sort.by("rating").descending());
            
            return repository.findAll(spec, pageable);
    }
}
