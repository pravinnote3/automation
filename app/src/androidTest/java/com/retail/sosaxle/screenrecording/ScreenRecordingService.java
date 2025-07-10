package com.retail.sosaxle.screenrecording;

import com.retail.sosaxle.configloader.PropertyUtils;
import com.retail.sosaxle.enums.ConfigProperties;

public class ScreenRecordingService {
    public static void startRecording() {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.startScreenRecording();
        }
    }

    public static void stopRecording(String methodName) {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.stopScreenRecording(methodName);
        }
    }
}
