package numerics.logics;

public interface ShapesFactory {

    String surfaceArea(ShapeDimensions dimensions);

    String differenceOfAreas(ShapeDimensions dimensions1, ShapeDimensions dimensions2);

    String enclosedVolume(ShapeDimensions dimensions);
}
