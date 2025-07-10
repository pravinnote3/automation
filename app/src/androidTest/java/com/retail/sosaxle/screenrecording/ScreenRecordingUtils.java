package com.retail.sosaxle.screenrecording;

import com.retail.sosaxle.constants.FrameWorkConstants;
import com.retail.sosaxle.drivers.DriverManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import io.appium.java_client.screenrecording.CanRecordScreen;

public class ScreenRecordingUtils {
    public static void startScreenRecording() {
        ((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
    }

    public static void stopScreenRecording(String methodName) {
        var recordedVideoFile = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
        var pathToWriteVideoFile = FrameWorkConstants.getScreenRecordingsPath() + File.separator + methodName + ".mp4";
        writeToOutputStream(pathToWriteVideoFile, recordedVideoFile);
    }

    static void writeToOutputStream(String filePathToWrite, String recordedVideoFile) {
        try (var outputStream = new FileOutputStream(filePathToWrite)) {
           // outputStream.write(Base64.decodeBase64(recordedVideoFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
