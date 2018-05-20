package by.aex.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionFactoryUtil {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public static void close() {
        FACTORY.close();
    }
}
