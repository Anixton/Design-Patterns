public class Bicycle extends Vehicle {

    private boolean hasReflectors;
    private boolean hasBells;
    private boolean hasLights;
    private boolean hasHelmet;

    // Notice that safety ratings don't sum up to 1.0
    // Because Bicycle is never fully "safe"
    private final double REFLECTORS_SAFETY_RATING = 0.2;
    private final double BELLS_SAFETY_RATING = 0.1;
    private final double LIGHTS_SAFETY_RATING = 0.1;
    private final double HELMET_SAFETY_RATING = 0.2;

    Bicycle(String color, String model, int maxSpeed,
            boolean hasReflectors, boolean hasBells, boolean hasLights, boolean hasHelmet) {

        setVehicleAttributes(color, model, maxSpeed);

        this.hasReflectors = hasReflectors;
        this.hasBells = hasBells;
        this.hasLights = hasLights;
        this.hasHelmet = hasHelmet;
    }

    @Override
    double calculateSafetyRating() {
        double safetyRating = 0.0;

        if (hasReflectors) {
            safetyRating += REFLECTORS_SAFETY_RATING;
        }
        if (hasBells) {
            safetyRating += BELLS_SAFETY_RATING;
        }
        if (hasLights) {
            safetyRating += LIGHTS_SAFETY_RATING;
        }
        if (hasHelmet) {
            safetyRating += HELMET_SAFETY_RATING;
        }

        safetyRating *= 100;
        return safetyRating;
    }

    @Override
    void safetyInformation() {
        System.out.println("Safety information for the bicycle: " + calculateSafetyRating());
    }
}
