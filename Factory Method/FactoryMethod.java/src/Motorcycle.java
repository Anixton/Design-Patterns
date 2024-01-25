public class Motorcycle extends Vehicle {

    private boolean hasAntiLockBrakes;
    private boolean hasHelmetAirbags;
    private boolean hasTractionControl;
    private boolean hasStabilityControl;
    private boolean hasRearviewCamera;
    private boolean heightGreaterThanAverage;
    private boolean weightGreaterThanAverage;

    private final double AVERAGE_MOTORCYCLE_WEIGHT = 300.0;
    private final double AVERAGE_MOTORCYCLE_HEIGHT = 1.2;

    // Notice that safety ratings don't sum up to 1.0
    // Because Motorcycle is never fully "safe"
    private final double HELMET_AIRBAGS_SAFETY_RATING = 0.2;
    private final double STABILITY_CONTROL_SAFETY_RATING = 0.2;
    private final double TRACTION_CONTROL_SAFETY_RATING = 0.15;
    private final double ANTI_LOCK_BRAKES_SAFETY_RATING = 0.1;  
    private final double REARVIEW_CAMERA_SAFETY_RATING = 0.05;
    private final double MOTORCYCLE_WEIGHT_SAFETY_RATING = 0.05;
    private final double MOTORCYCLE_HEIGHT_SAFETY_RATING = 0.05;

    Motorcycle(String color, String model, int maxSpeed, double weight, double height,
               boolean hasAntiLockBrakes, boolean hasHelmetAirbags, boolean hasTractionControl,
               boolean hasStabilityControl, boolean hasRearviewCamera) 
    {

        setVehicleAttributes(color, model, maxSpeed, weight, height);

        this.hasAntiLockBrakes = hasAntiLockBrakes;
        this.hasHelmetAirbags = hasHelmetAirbags;
        this.hasTractionControl = hasTractionControl;
        this.hasStabilityControl = hasStabilityControl;
        this.hasRearviewCamera = hasRearviewCamera;

        weightGreaterThanAverage = weight > AVERAGE_MOTORCYCLE_WEIGHT;
        heightGreaterThanAverage = height > AVERAGE_MOTORCYCLE_HEIGHT;
    }

    @Override
    double calculateSafetyRating() {
        double safetyRating = 0.0;

        if (hasAntiLockBrakes) {
            safetyRating += ANTI_LOCK_BRAKES_SAFETY_RATING;
        }
        if (hasHelmetAirbags) {
            safetyRating += HELMET_AIRBAGS_SAFETY_RATING;
        }
        if (hasTractionControl) {
            safetyRating += TRACTION_CONTROL_SAFETY_RATING;
        }
        if (hasStabilityControl) {
            safetyRating += STABILITY_CONTROL_SAFETY_RATING;
        }
        if (hasRearviewCamera) {
            safetyRating += REARVIEW_CAMERA_SAFETY_RATING;
        }
        if (weightGreaterThanAverage) {
            safetyRating += MOTORCYCLE_WEIGHT_SAFETY_RATING;
        }
        if (heightGreaterThanAverage) {
            safetyRating += MOTORCYCLE_HEIGHT_SAFETY_RATING;
        }

        safetyRating *= 100;
        return safetyRating;
    }

    @Override
    void safetyInformation() {
        System.out.println("Safety information for the motorcycle: " + calculateSafetyRating());
    }
}
