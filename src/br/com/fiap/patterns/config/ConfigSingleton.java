package br.com.fiap.patterns.config;

import java.io.IOException;
import java.util.Properties;

// Utilizando design pattern em nível Criação -> Singleton
public class ConfigSingleton {
    private static Properties prop;

    private ConfigSingleton() {

    }

    public static Properties getInstance() throws IOException {
        if (prop == null) {
            prop = new Properties();
            prop.load(ConfigSingleton.class.getResourceAsStream("/config.properties"));
        }
        return prop;
    }
}
