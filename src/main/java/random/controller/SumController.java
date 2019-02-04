package random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import random.function.SumFunctions;
import random.model.IngredientCriteria;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SumController {

    @Autowired
    SumFunctions sumFunctions;

    @PostMapping(path = "/findIngredient")
    private ResponseEntity<List<String>> findIngredient(@RequestBody IngredientCriteria ingredientCriteria) throws Exception{
        List<String> result = sumFunctions.findIngredient(ingredientCriteria.getIngredients(),0,1,1,ingredientCriteria.getIngredients().size(),0,new ArrayList<>(),new ArrayList<>(),null,ingredientCriteria.getExpectedResult());
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
