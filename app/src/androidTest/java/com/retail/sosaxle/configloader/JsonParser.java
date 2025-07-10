package com.retail.sosaxle.configloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.sosaxle.constants.FrameWorkConstants;
import com.retail.sosaxle.enums.ConfigJson;
import com.retail.sosaxle.exceptions.JsonFileUsageException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonParser {
    private static Map<String, String> map;

    static void readJson(String jsonPath) {
        try {
            map = new ObjectMapper().readValue(new File(jsonPath),
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            throw new JsonFileUsageException("Exception occurred while reading Json file in the specified path");
        }
    }

    public static String getConfig(ConfigJson key) {
       System.out.println("CONFIG PATH "+FrameWorkConstants.CONFIG_JSON_PATH);
        readJson(FrameWorkConstants.CONFIG_JSON_PATH);
        if (Objects.isNull(map.get(key.name().toLowerCase()))) {
            throw new JsonFileUsageException("Property name - " + key + " is not found. Please check the config.json");
        }
        return map.get(key.name().toLowerCase());
    }
}
