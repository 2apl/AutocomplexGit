package by.aex.util;

import by.aex.config.ServiceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class ContextUtil {

    private static final AnnotationConfigApplicationContext CONTEXT = new AnnotationConfigApplicationContext(ServiceConfiguration.class);

    public static <T> T getContext(Class<T> clazz) {
        return CONTEXT.getBean(clazz);
    }
}
