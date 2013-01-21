package com.github.uthark.readability;

import com.github.uthark.readability.xauth.AuthorizationParams;
import com.github.uthark.readability.xauth.Readability;
import com.github.uthark.readability.xauth.XAuthParams;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/19/13
 */
public abstract class AbstractReadabilityTest {

    protected Readability instance;

    @BeforeMethod
    public final void setupReadability() throws Exception {

        InputStream is = getClass().getClassLoader().getResourceAsStream("auth.properties");
        final Properties properties = new Properties();
        properties.load(is);

        String apiKey = properties.getProperty("api.key");
        String apiSecret = properties.getProperty("api.secret");
        String username = properties.getProperty("xauth.username");
        String password = properties.getProperty("xauth.password");
        instance = Readability.getInstance(new AuthorizationParams(apiKey, apiSecret,
                new XAuthParams(username, password)));
    }

}
