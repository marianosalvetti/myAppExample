package com.appexample.marianosalvetti.com.myappexample.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mariano Salvetti on 11/05/2014.
 *
 */
public class FontCache {
    private static Map<String, Typeface> fontMap = new HashMap<String, Typeface>();

        public static Typeface getFont(Context context, String fontName){
            if (fontMap.containsKey(fontName)){
                return fontMap.get(fontName);
            }
            else {
                Typeface tf = Typeface.createFromAsset(context.getAssets(), fontName);
                fontMap.put(fontName, tf);
                return tf;
            }
        }
}
