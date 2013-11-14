package fr.masciulli.drinks.data;

import java.util.List;


import fr.masciulli.drinks.model.Drink;
import fr.masciulli.drinks.model.Liquor;
import retrofit.Callback;
import retrofit.RestAdapter;
public class DrinksProvider {

    private static RestAdapter mRestAdapter = new RestAdapter.Builder()
            .setServer("http://drinkstest.elasticbeanstalk.com/api")
            .build();
    private static DrinksService mService = mRestAdapter.create(DrinksService.class);

    public static void getDrinksList(Callback<List<Drink>> callback) {
        mService.listDrinks(callback);
    }

    public static void getDrink(int drinkId, Callback<Drink> callback) {
        mService.detailDrink(drinkId, callback);
    }

    public static void getLiquorsList(Callback<List<Liquor>> callback) {
        mService.listLiquors(callback);
    }

    public static void getLiquor(int liquorId, Callback<Liquor> callback){
        mService.detailLiquor(liquorId, callback);
    }

    public static void updateServer(String server) {
        mRestAdapter = new RestAdapter.Builder()
                .setServer(server)
                .build();
        mService = mRestAdapter.create(DrinksService.class);
    }

}
