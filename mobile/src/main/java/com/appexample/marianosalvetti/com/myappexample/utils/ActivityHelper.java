package com.appexample.marianosalvetti.com.myappexample.utils;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Mariano Salvetti on 16/04/2014.
 */

public class ActivityHelper {
	// Declare a xlarge size constant instead of using Configuration.SCREENLAYOUT_SIZE_XLARGE for backward compatibility
	private static final int SCREENLAYOUT_SIZE_XLARGE = 4;
	private static final int SCREENLAYOUT_SIZE_LARGE = 3;

	/**
	 * Reset context of the ContextDependent objects stored in the Last Non-Configuration Instance.
	 *
	 * @return true if there is a Last Non-Configuration Instance, otherwise return false

	public static <T extends Activity > boolean refreshNonConfigInstanceContext(T activity) {
		Map<String, Object> map = activity.getLastNonConfigurationInstanceMap();
		if (map == null) return false;

		for (Object eachValue : map.values()) {
			if (eachValue instanceof IContextDependent) {
				if (Config.IS_LOGGABLE) {
					Log.d("lnb_mobile", "Refreshing Context in getLastNonConfigurationInstanceMap for %s", eachValue.getClass().getName());
				}

				((IContextDependent) eachValue).setContext(activity);
			}
		}

		return true;
	}
     */
	public static void showSoftKeyboard(Activity activity, View view) {
		InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (mgr != null) {
			mgr.showSoftInput(view, InputMethodManager.SHOW_FORCED);
		}
	}

	public static void closeSoftKeyboard(Activity activity) {
		InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (mgr != null) {
			mgr.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
		}
	}

	public static void alertNotImplemented(Context context) {
		Toast.makeText(context, "Coming soon!", Toast.LENGTH_SHORT).show();
	}

	public static boolean hasXLargeScreen(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
				>= SCREENLAYOUT_SIZE_XLARGE;
	}

	public static boolean hasLargeScreen(Context context) {
	    return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
	            >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}


	public static void enforcePortrait(Activity activity) {
		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	public static Drawable resolveDrawableAttribute(Context themedContext, int attrResId) {
		// Create an array of the attributes we want to resolve
		// using values from a theme
		int[] attrs = new int[] { attrResId /* index 0 */};

		// Obtain the styled attributes. 'themedContext' is a context with a
		// theme, typically the current Activity (i.e. 'this')
		TypedArray ta = themedContext.obtainStyledAttributes(attrs);

		// Now get the value of the attrResId attribute that was
		// set in the theme used in 'themedContext'. The parameter is the index
		// of the attribute in the 'attrs' array. The returned Drawable
		// is what you are after
		Drawable drawableFromTheme = ta.getDrawable(0 /* index */);

		// Finally free resources used by TypedArray
		ta.recycle();
		return drawableFromTheme;
	}

    public static final int VERSION_CODES_GINGERBREAD = 9;
       public static final int VERSION_CODES_HONEYCOMB = 11;
       public static final int VERSION_CODES_HONEYCOMB_MR1 = 12;
       public static final int VERSION_CODES_ICE_CREAM_SANDWICH = 14;
       public static final int VERSION_CODES_JELLY_BEAN = 16;

       private static final String COM_GOOGLE_ANDROID_TV = "com.google.android.tv";

       public static boolean isGoogleTV(Context context) {
       	return context.getPackageManager().hasSystemFeature(COM_GOOGLE_ANDROID_TV);
       }

       public static boolean haseCLAIR() {
           return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR; //5
       }
       public static boolean hasFroyo() {
           // Can use static final constants like FROYO, declared in later versions
           // of the OS since they are inlined at compile time. This is guaranteed behavior.
           return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
       }

       public static boolean hasGingerbread() {
           return Build.VERSION.SDK_INT >= VERSION_CODES_GINGERBREAD ; // 9
       }

       public static boolean hasHoneycomb() {
           return Build.VERSION.SDK_INT >= VERSION_CODES_HONEYCOMB; // 11
       }

       public static boolean hasHoneycombMR1() {
           return Build.VERSION.SDK_INT >= VERSION_CODES_HONEYCOMB_MR1; // 12
       }

       public static boolean hasICS() {
           return Build.VERSION.SDK_INT >= VERSION_CODES_ICE_CREAM_SANDWICH; //14;
       }

       public static boolean hasJellyBean() {
           return Build.VERSION.SDK_INT >= VERSION_CODES_JELLY_BEAN; // 16 is the last current version Build.VERSION_CODES.JELLY_BEAN;
       }

       public static boolean isTablet(Context context) {
           return (context.getResources().getConfiguration().screenLayout
                   & Configuration.SCREENLAYOUT_SIZE_MASK)
                   >= Configuration.SCREENLAYOUT_SIZE_LARGE;
       }

       public static boolean isHoneycombTablet(Context context) {
           return hasHoneycomb() && isTablet(context);
       }

       public static String randomText() {
           Random generator = new Random();
           StringBuilder randomStringBuilder = new StringBuilder();
           int randomLength = generator.nextInt(100);
           char tempChar;
           for (int i = 0; i < randomLength; i++){
               tempChar = (char) (generator.nextInt(96) + 32);
               randomStringBuilder.append(tempChar);
           }
           return randomStringBuilder.toString();
       }

       public static int randomNumber(int from, int to) {
       	final Random rand = new Random();
       	int diceRoll = rand.nextInt(to) + from; // uniformly distributed int from 1 to 6
       	return diceRoll;
       }

}
