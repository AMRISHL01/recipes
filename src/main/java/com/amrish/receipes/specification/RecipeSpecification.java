package com.amrish.receipes.specification;

import org.springframework.data.jpa.domain.Specification;

import com.amrish.receipes.entity.Recipe;

public class RecipeSpecification {

    public static Specification<Recipe> hasTitle(String title) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("title")),
                        "%" + title.toLowerCase() + "%");
    }

    public static Specification<Recipe> hasCuisine(String cuisine) {
        return (root, query, cb) ->
                cb.equal(root.get("cuisine"), cuisine);
    }

    public static Specification<Recipe> ratingGreaterThan(Float rating) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("rating"), rating);
    }
    public static Specification<Recipe> totalTimeLessThan(Integer time) {
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("totalTime"), time);
    }
}
