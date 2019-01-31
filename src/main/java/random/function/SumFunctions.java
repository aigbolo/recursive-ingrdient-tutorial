package random.function;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SumFunctions {


    public int sumProcess(int sumStack){
        int sum = sum(sumStack);
        System.out.println("Result sum: "+sum);
        return sum;
    }
    public int sum(int n) {
        if (n >= 1) {
            System.out.println("Current sum: "+n);
            return sum(n - 1) + n;
        }
        return n;
    }

    public int tailSum(int currentSum, int n) {
        if (n <= 1) {
            System.out.println("Current sum: "+currentSum);
            return currentSum + n;
        }
        System.out.println("Current sum: "+currentSum);
        return tailSum(currentSum + n, n - 1);
    }

    public List<String> findIngredient(List<Integer> ingredients, Integer startIndex, Integer startRootIndex , Integer currentRootIndex , Integer stack, Integer currentStack, List<Integer> keptIngredients, List<String> collected, Integer currentCount, Integer expectedResult) throws Exception{



        System.out.println("index: "+startIndex+" start root: "+startRootIndex+"  current root: "+currentRootIndex);
        // Exit when last
        if(startIndex >= ingredients.size() - 1 && startRootIndex >= ingredients.size() - 1){
            return collected;
        }

        // Fill ingredient
        if(currentCount == null){
            currentCount = ingredients.get(startIndex) + ingredients.get(startRootIndex);
            keptIngredients.add(ingredients.get(startIndex));
            keptIngredients.add(ingredients.get(startRootIndex));
        }else {
            currentCount = currentCount + ingredients.get(currentRootIndex);
            keptIngredients.add(ingredients.get(currentRootIndex));
        }




        System.out.println("Current count: "+ currentCount);
        // Check
        if(currentCount < expectedResult){
            System.out.println("currentCount < expectedResult ");


            if(currentRootIndex < ingredients.size() - 1){
                currentRootIndex++;
            }else{
                if(startRootIndex < ingredients.size() - 1){
                    startRootIndex++;
                    currentRootIndex = startRootIndex;
                }else{
                    startRootIndex = ++startIndex + 1;
                    currentRootIndex = startRootIndex;
                }
                stack = ingredients.size() - startRootIndex;
                return findIngredient(ingredients,startIndex,startRootIndex, currentRootIndex,stack,0,new ArrayList<>(),collected,null,expectedResult);
            }
            return findIngredient(ingredients,startIndex,startRootIndex,currentRootIndex,stack,currentStack, keptIngredients,collected,currentCount,expectedResult);

        }else if(currentCount == expectedResult){
            System.out.println("currentCount == expectedResult ");
            String keep = "";
            for(Integer data: keptIngredients){
                keep += data+"+";
            }
            System.out.println("keep:  "+keep);

            collected.add(keep);
            if(startRootIndex < ingredients.size() - 1){
                startRootIndex++;
            }else{
                if(startRootIndex < ingredients.size() - 1){
                    startRootIndex++;
                    currentRootIndex = startRootIndex;
                }else{
                    startRootIndex = ++startIndex + 1;
                    currentRootIndex = startRootIndex;
                }
            }
            stack = ingredients.size() - startRootIndex;
            return findIngredient(ingredients,startIndex,startRootIndex,currentRootIndex,stack,0, new ArrayList<>(),collected,null,expectedResult);
        }else{
            System.out.println("currentCount > expectedResult ");
            if(stack != currentStack){
                currentRootIndex = startRootIndex + currentStack;
                currentStack++;
            }else{
                if(startRootIndex < ingredients.size() - 1){
                    startRootIndex++;
                }else{
                    if(startRootIndex < ingredients.size() - 1){
                        startRootIndex++;
                        currentRootIndex = startRootIndex;
                    }else{
                        startRootIndex = ++startIndex + 1;
                        currentRootIndex = startRootIndex;
                    }
                }
            }

            return findIngredient(ingredients,startIndex,startRootIndex,currentRootIndex,stack,currentStack, new ArrayList<>(),collected,null,expectedResult);
        }

    }
}
