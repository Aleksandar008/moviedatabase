package aleksandar.moviesdatabase.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    String token="token";
    String session_id="session_id";


    private static SharedPreferences getPreferences(Context c) {
        return c.getApplicationContext().getSharedPreferences("MySharedPreffsFile", Activity.MODE_PRIVATE);
    }
    public static String getToken(Context context){
        return getPreferences(context).getString("token","noname");
    }

    public static String getSessionId(Context context){
        return getPreferences(context).getString("session_id","");
    }

    public static void setSessionId(Context context, String session_id){
        getPreferences(context).edit().putString("session_id",session_id).apply();
    }


    public static void setToken(Context context, String token) {
        getPreferences(context).edit().putString("token",token).apply();
    }

//    public static void getSessionId(Context context) {
//        getPreferences(context).getString("session_id","");
//    }




    public static void removeToken(Context c) {
        getPreferences(c).edit().remove("token");
    }

    public static void removeSessionId(Context c) {
        getPreferences(c).edit().remove("session_id");
        getPreferences(c).edit().putString("session_id","").apply();
    }
}
