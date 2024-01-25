public class Car extends Vehicle{

    private boolean hasAutomaticEmergencyBraking;
    private boolean hasAirBags;
    private boolean hasAntiLockBrakes;
    private boolean hasElectronicStabilityControl;
    private boolean hasBackupCamera;
    private boolean heightGreaterThanAverage;
    private boolean weightGreaterThanAverage;

    private final double AVERAGE_CAR_WEIGHT = 1500.0;
    private final double AVERAGE_CAR_HEIGHT = 1.5;

    private final double AUTOMATIC_EMERGENCY_BRAKING_SAFETY_RATING = 0.3;
    private final double AIR_BAGS_SAFETY_RATING = 0.2;
    private final double ANTI_LOCK_BRAKES_SAFETY_RATING = 0.1;
    private final double ELECTRONIC_STABILITY_CONTROL_SAFETY_RATING = 0.1;
    private final double BACKUP_CAMERA_SAFETY_RATING = 0.1;
    private final double CAR_WEIGHT_SAFETY_RATING = 0.1;
    private final double CAR_HEIGHT_SAFETY_RATING = 0.1;

    Car(String color, String model, int maxSpeed, double weight, double height, 
        boolean hasAirBags, boolean hasAntiLockBrakes, boolean hasElectronicStabilityControl, 
        boolean hasAutomaticEmergencyBraking, boolean hasBackupCamera)
    {
        setVehicleAttributes(color, model, maxSpeed, weight, height);

        this.hasAirBags = hasAirBags;
        this.hasAntiLockBrakes = hasAntiLockBrakes;
        this.hasElectronicStabilityControl = hasElectronicStabilityControl;
        this.hasAutomaticEmergencyBraking = hasAutomaticEmergencyBraking;
        this.hasBackupCamera = hasBackupCamera;

        weightGreaterThanAverage = weight > AVERAGE_CAR_WEIGHT;
        heightGreaterThanAverage = height > AVERAGE_CAR_HEIGHT;
        
    }

    @Override
    double calculateSafetyRating() {
        double safetyRating = 0.0;

        if(hasAirBags){
            safetyRating += AIR_BAGS_SAFETY_RATING;
        }
        if(hasAntiLockBrakes){
            safetyRating += ANTI_LOCK_BRAKES_SAFETY_RATING;
        }
        if(hasElectronicStabilityControl){
            safetyRating += ELECTRONIC_STABILITY_CONTROL_SAFETY_RATING;
        }
        if(hasAutomaticEmergencyBraking){
            safetyRating += AUTOMATIC_EMERGENCY_BRAKING_SAFETY_RATING;
        }
        if(hasBackupCamera){
            safetyRating += BACKUP_CAMERA_SAFETY_RATING;
        }
        if(weightGreaterThanAverage){
            safetyRating += CAR_WEIGHT_SAFETY_RATING;
        }
        if(heightGreaterThanAverage){
            safetyRating += CAR_HEIGHT_SAFETY_RATING;
        }

        safetyRating = safetyRating * 100;
        return safetyRating;
    }

    @Override
    void safetyInformation() {
        System.out.println("Safety information for the car: "+calculateSafetyRating());
    }
}
