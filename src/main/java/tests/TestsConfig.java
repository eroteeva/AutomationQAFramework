package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestsConfig {

    String browser;
    String baseUrl;

    Map<String, String> propertyValueMap = getPropValues();

    InputStream inputStream;

    public TestsConfig() throws IOException {
        this.browser = propertyValueMap.get("browser");
        this.baseUrl = propertyValueMap.get("baseUrl");
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Map<String, String> getPropValues() throws IOException {

        Map<String, String> propertyValueMap = new HashMap<String, String>();
        try {
            Properties prop = new Properties();
            String propFileName = "test.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String browser = prop.getProperty("browser");
            propertyValueMap.put("browser", browser);

            String baseUrl = prop.getProperty("baseUrl");
            propertyValueMap.put("baseUrl", baseUrl);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return propertyValueMap;
    }

}
