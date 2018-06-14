package org.dalol.RailsLoktraTask.Helper;

import android.content.Context;
import android.util.DisplayMetrics;

public class DeviceDimensionHelper {
        public static int getDisplayWidth(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels;
        }
        public static int getDisplayHeight(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.heightPixels;
        }
}
