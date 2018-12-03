package form;

import java.util.ArrayList;

public class ProvinceChoice {

    private static final ArrayList<String> provinceModel = new ArrayList<>();

    public static ArrayList<String> getProvinceModel() {
        provinceModel.clear();

        provinceModel.add("ALBERTA");
        provinceModel.add("BRITISH COLUMBIA");
        provinceModel.add("MANITOBA");
        provinceModel.add("NEW BRUNSWICK");
        provinceModel.add("NEWFOUNDLAND");
        provinceModel.add("NORTHWEST TERRITORIES");
        provinceModel.add("NOVA SCOTIA");
        provinceModel.add("NUNAVUT");
        provinceModel.add("ONTARIO");
        provinceModel.add("PRINCE EDWARD ISLAND");
        provinceModel.add("ALBERTA");
        provinceModel.add("QUEBEC");
        provinceModel.add("SASKATCHEWAN");
        provinceModel.add("YUKON");

        return provinceModel;
    }


}
