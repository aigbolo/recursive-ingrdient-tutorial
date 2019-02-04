package random.model;

import java.util.List;

public class IngredientCriteria {
    private List<Integer> ingredients;
    private Integer expectedResult;

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(Integer expectedResult) {
        this.expectedResult = expectedResult;
    }
}
