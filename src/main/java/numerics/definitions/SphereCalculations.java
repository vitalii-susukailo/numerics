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
        String firstPhrase = arbitraryNumbers.multiply("4",NumbersUtils.getPINumber());
        String secondPhrase = arbitraryNumbers.multiply(dimensions.getRadius(),dimensions.getRadius());
        return arbitraryNumbers.multiply(firstPhrase,secondPhrase);
    }

    @Override
    public String differenceOfAreas(ShapeDimensions dimensions1, ShapeDimensions dimensions2){
        // we want calculate diff of areas between the sun and the closest star! (proxima)
        // first calculate each of them area
        String firstShapeArea = this.surfaceArea(dimensions1);
        String secondShapeAre = this.surfaceArea(dimensions2);
        //then calcualte diff
        return arbitraryNumbers.subtraction(firstShapeArea,secondShapeAre);
    }

    @Override
    public String enclosedVolume(ShapeDimensions dimensions) {
        return null;
    }
}
