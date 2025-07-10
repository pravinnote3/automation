package com.retail.sosaxle.configloader;

import com.retail.sosaxle.constants.FrameWorkConstants;
import com.retail.sosaxle.enums.ConfigProperties;
import com.retail.sosaxle.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties property = new Properties();

    static void loadProperties() {
        try (var input = new FileInputStream(FrameWorkConstants.CONFIG_PROPERTIES_PATH)) {
            property.load(input);
        } catch (IOException e) {
            throw new PropertyFileUsageException("IOException occurred while loading Property file in the specified path");
        }
    }

    public static String getPropertyValue(ConfigProperties key) {
        loadProperties();
        if (Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
        }
        return property.getProperty(key.name().toLowerCase());
    }
}
