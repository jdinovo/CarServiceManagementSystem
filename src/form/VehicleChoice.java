package form;

import java.util.*;

/**
 * VehicleChoice consists of a map that takes
 * the key as the vehicleBrand &
 * the value as the vehicleModel
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/13/2018
 *
 */
public class VehicleChoice {

    private static final Map<String, List<String>> vehicleModel = new HashMap<>();

    public static Map<String, List<String>> getVehicleModel() {

        vehicleModel.put("AUDI", Arrays.asList("A3", "A4", "A5", "Q3", "Q5", "TT", "RS"));
        vehicleModel.put("BMW", Arrays.asList("2 SERIES", "3 SERIES", "4 SERIES", "M2", "M3", "M4", "X1", "X2", "X3"));
        vehicleModel.put("CHEVROLET", Arrays.asList("CRUZE", "MALIBU", "IMPALA", "CAMARO", "CORVETTE", "EQUINOX", "TRAVERSE", "COLORADO", "SILVERADO"));
        vehicleModel.put("CHRYSLER", Arrays.asList("PACIFICA", "CHRYSLER 300"));
        vehicleModel.put("DODGE", Arrays.asList("JOURNEY", "CARAVAN", "CHALLENGER", "CHARGER", "DURANGO"));
        vehicleModel.put("FORD", Arrays.asList("FOCUS", "FIESTA", "FUSION", "MUSTANG", "TAURUS", "ESCAPE", "EDGE", "EXPLORER", "EXPEDITION", "FLEX", "F-150"));
        vehicleModel.put("HONDA", Arrays.asList("FIT", "CIVIC", "ACCORD", "INSIGHT", "CLARITY", "PILOT", "ODYSSEY", "RIDGELINE"));
        vehicleModel.put("JEEP", Arrays.asList("WRANGLER", "WRANGLER JK", "CHEROKEE", "COMPASS", "GRAND CHEROKEE", "RENEGADE"));
        vehicleModel.put("NISSAN", Arrays.asList("MICRA", "SENTRA", "ALTIMA", "MAXIMA", "KICKS", "ROGUE", "MURANO", "PATHFINDER", "ARMADA", "FRONTIER", "TITAN", "LEAF"));
        vehicleModel.put("PORSCHE", Arrays.asList("CAYMAN", "BOXSTER", "911 CARRERA", "MACAN", "CAYENNE"));
        vehicleModel.put("SUBARU", Arrays.asList("FORESTER", "IMPREZA", "LEGACY", "OUTBACK", "WRX", "WRX STI", "BRZ", "CROSSTREK", "ASCENT"));
        vehicleModel.put("TOYOTA", Arrays.asList("YARIS", "COROLLA", "PRIUS", "CAMRY", "AVALON", "SIENNA", "RAV 4", "HIGHLANDER", "4 RUNNER", "TACOMA", "TUNDRA"));
        vehicleModel.put("VOLKSWAGEN", Arrays.asList("TIGUAN", "ATLAS", "JETTA", "ARTEON", "PASSAT", "GOLD", "BEETLE"));

        return vehicleModel;
    }

    public Set<String> getVehicleKey() {
        return vehicleModel.keySet();
    }

    public Collection<List<String>> getVehicleValues() {
        return vehicleModel.values();
    }

    @Override
    public String toString() {
        return "VehicleChoice{" +
                "vehicleModel=" + vehicleModel +
                '}';
    }
}
