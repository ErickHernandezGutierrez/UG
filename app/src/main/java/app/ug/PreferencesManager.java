package app.ug;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class
PreferencesManager {
    SharedPreferences preferences;
    Editor editor;
    Context context;

    //Shared preference mode
    int PRIVATE_MODE = 0;

    //Shared prefenrences file name
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String FIRST_LAUNCH = "IsFirstTimeLaunch";

    public PreferencesManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(FIRST_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return preferences.getBoolean(FIRST_LAUNCH, true);
    }
}
