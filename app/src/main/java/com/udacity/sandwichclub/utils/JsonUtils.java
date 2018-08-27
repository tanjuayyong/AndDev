package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        final String SW_NAME = "name";
        final String SW_MAIN = "mainName";
        final String SW_AKA = "alsoKnownAs";
        final String SW_PON = "placeOfOrigin";
        final String SW_DES = "description";
        final String SW_IMG = "image";
        final String SW_IGD = "ingredients";

        Sandwich selectedSandwich = new Sandwich();

        JSONObject sandwichInfoJson = new JSONObject(json);

        JSONObject nameJson = sandwichInfoJson.getJSONObject(SW_NAME);

        String mainName = nameJson.getString(SW_MAIN);

        JSONArray akaJsons = nameJson.getJSONArray(SW_AKA);
        ArrayList<String> akas = new ArrayList<String>(akaJsons.length());

        for (int i=0; i<akaJsons.length(); i++) {
            akas.add(akaJsons.getString(i));
        }

        String placeOfOrigin = sandwichInfoJson.getString(SW_PON);
        String description = sandwichInfoJson.getString(SW_DES);
        String image = sandwichInfoJson.getString(SW_IMG);

        JSONArray ingredientJsons = sandwichInfoJson.getJSONArray(SW_IGD);
        ArrayList<String> ingredients = new ArrayList<String>(ingredientJsons.length());

        for (int i=0; i<ingredientJsons.length(); i++) {
            ingredients.add(ingredientJsons.getString(i));
        }

        selectedSandwich.setMainName(mainName);
        selectedSandwich.setAlsoKnownAs(akas);
        selectedSandwich.setPlaceOfOrigin(placeOfOrigin);
        selectedSandwich.setDescription(description);
        selectedSandwich.setImage(image);
        selectedSandwich.setIngredients(ingredients);

        return selectedSandwich;
    }
}
