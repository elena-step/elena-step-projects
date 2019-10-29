package javasummer2017.NewFileEntityText.src.com.company.services.accessors;

import java.util.Collection;
import java.util.Collections;

public interface AbstractAccessor<T> {
    default void save(T entity) {
        save(Collections.singletonList(entity));
    }

    void save(Collection<T> entities);

    Collection<T> readAll();

    void startReading();

    /**
     * @return
     */

    T read();

    void stopReading();

}