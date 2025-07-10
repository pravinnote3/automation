package com.retail.sosaxle.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import java.util.List;

public class AppUtils {

    public static void getInstalledApps(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo packageInfo : packages) {
            String appName = packageInfo.applicationInfo.loadLabel(pm).toString();
            String packageName = packageInfo.packageName;
            System.out.println("App Name: " + appName + ", Package: " + packageName);
        }
    }
}

