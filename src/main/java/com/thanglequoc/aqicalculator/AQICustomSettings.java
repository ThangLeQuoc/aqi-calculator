package com.thanglequoc.aqicalculator;

/**
 * Class for user to customize their messages settings, by supplying the custom messages file paths in the classpath
 * to be used by AQICalculator instance
 * */
public class AQICustomSettings {

    // Init default values
    private boolean useCustomMessagesFiles = false;
    private String generalMessagesResourcePath = AQICalculatorConstants.AQI_GENERAL_MESSAGES_RESOURCE_PATH;
    private String specificMessageResourcePath = AQICalculatorConstants.AQI_SPECIFIC_MESSAGES_RESOURCE_PATH;

    /**
     * Set the flag to indicate if the settings should use the custom messages from the path that user supply
     * @param useCustomMessagesFiles : set to true to enable custom messages files
     * @return the settings instance
     * */
    public AQICustomSettings withCustomMessagesMode(boolean useCustomMessagesFiles) {
        this.useCustomMessagesFiles = useCustomMessagesFiles;
        return this;
    }

    /**
     * Set the path of the General Message resource file (in the classpath)
     * @param generalMessagesResourcePath : path to the general messages resource JSON file
     * */
    public AQICustomSettings withGeneralMessageResourcePath(String generalMessagesResourcePath) {
        this.generalMessagesResourcePath = generalMessagesResourcePath;
        return this;
    }

    /**
     * Set the path of the Specific Message resource file (in the classpath)
     * @param specificMessageResourcePath : path to the specific messages resource JSON file
     * */
    public AQICustomSettings withSpecificMessageResourcePath(String specificMessageResourcePath) {
        this.specificMessageResourcePath = specificMessageResourcePath;
        return this;
    }

    boolean isInOverrideSettingMode() {
        return useCustomMessagesFiles;
    }

    String getGeneralMessagesResourcePath() {
        return generalMessagesResourcePath;
    }

    String getSpecificMessageResourcePath() {
        return specificMessageResourcePath;
    }

    @Override
    public String toString() {
        return "AQICustomSettings{" +
                "useCustomMessagesFiles=" + useCustomMessagesFiles +
                ", generalMessagesResourcePath='" + generalMessagesResourcePath + '\'' +
                ", specificMessageResourcePath='" + specificMessageResourcePath + '\'' +
                '}';
    }
}
