package com.example.android.sunshine.sync;
//  (9) Create a class called SunshineSyncUtils
//  (10) Create a public static void method called startImmediateSync
//  (11) Within that method, start the SunshineSyncIntentService

import android.content.Context;
import android.content.Intent;

public class SunshineSyncUtils {

    public static void startImmediateSync(Context context){
        Intent syncImmediatelyIntent = new Intent(context, SunshineSyncIntentService.class);
        context.startService( syncImmediatelyIntent );
    }
}