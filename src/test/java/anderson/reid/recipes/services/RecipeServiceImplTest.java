package anderson.reid.recipes.services;

import anderson.reid.recipes.domain.Recipe;
import anderson.reid.recipes.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

   RecipeServiceImpl recipeService;

   @Mock
   RecipeRepository recipeRepository;

   @BeforeEach
   public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      recipeService = new RecipeServiceImpl(recipeRepository);
   }

   @Test
   void getRecipes() {

      Recipe recipe = new Recipe();
      HashSet recipesData = new HashSet();
      recipesData.add(recipe);

      when(recipeRepository.findAll()).thenReturn(recipesData);

      Set<Recipe> recipes = recipeService.getRecipes();

      assertEquals(recipes.size(), 1);
      verify(recipeRepository, times(1)).findAll();
   }
}