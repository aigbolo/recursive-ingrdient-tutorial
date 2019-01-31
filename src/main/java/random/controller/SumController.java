package random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import random.function.SumFunctions;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SumController {

    @Autowired
    SumFunctions sumFunctions;
    @GetMapping(path = "/sum-stack")
    private ResponseEntity<Integer> sumStack(@RequestParam("stack") int stack){
        System.out.println("Stack =  "+stack);
        int result = sumFunctions.sumProcess(stack);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping(path = "/tailSum")
    private ResponseEntity<Integer> tailSum(){
        int result = sumFunctions.tailSum(0,20);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping(path = "/findIngredient")
    private ResponseEntity<List<String>> findIngredient() throws Exception{
        List<Integer> ingredients = new ArrayList<>();
        ingredients.add(1);
        ingredients.add(2);
        ingredients.add(3);
        ingredients.add(4);
        ingredients.add(5);
        ingredients.add(6);
        ingredients.add(7);
        ingredients.add(8);
        ingredients.add(9);

        List<String> result = sumFunctions.findIngredient(ingredients,0,1,1,ingredients.size(),0,new ArrayList<>(),new ArrayList<>(),null,10);
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
