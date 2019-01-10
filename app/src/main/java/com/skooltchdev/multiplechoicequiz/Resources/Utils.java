package com.skooltchdev.multiplechoicequiz.Resources;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class Utils {
    public static void switchActivity(Context context, Class<?> c) {
        Intent intent = new Intent(context, c);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
