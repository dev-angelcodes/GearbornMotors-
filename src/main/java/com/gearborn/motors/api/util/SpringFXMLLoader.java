package com.gearborn.motors.api.util;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SpringFXMLLoader {
    private final ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public Object load(String fxmlPath) throws IOException {
        try (InputStream fxmlStream = getClass().getResourceAsStream(fxmlPath)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(context::getBean);
            return loader.load(fxmlStream);
        }
    }
}