package numerics.definitions;

import numerics.logics.NumbersFactory;
import numerics.logics.ShapeDimensions;
import numerics.logics.ShapesFactory;
import numerics.utils.NumbersUtils;

public class SphereCalculations implements ShapesFactory {

    NumbersFactory arbitraryNumbers = new ArbitraryNumbers();
    @Override

    public String surfaceArea(ShapeDimensions dimensions) {
        // area = 4 * PI * radius * radius

        // solution is dividing 2 steps: 4 * PI and radius * radius
        return null;
    }

    @Override
    public String differenceOfAreas(ShapeDimensions dimensions1, ShapeDimensions dimensions2){

        return null;
    }

    @Override
    public String enclosedVolume(ShapeDimensions dimensions) {
        return null;
    }
}