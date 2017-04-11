package products.liverpool.com.liverpoolproducts.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public class CategoryNamePrefrence {
    public static final String PREFS_NAME = "history";
    public static final String PREFS_SEARCH_HISTORY = "SearchHistory";
    private static SharedPreferences pref;
    private static  CategoryNamePrefrence categoryNamePrefrence;
    public CategoryNamePrefrence(Context context) {
        pref = context.getSharedPreferences(PREFS_NAME, 0);

        SharedPreferences.Editor editor = pref.edit();
    }

    public static CategoryNamePrefrence getInstance(Context context) {
        if ( categoryNamePrefrence == null)
            categoryNamePrefrence = new CategoryNamePrefrence(context);

        return categoryNamePrefrence;
    }



}
