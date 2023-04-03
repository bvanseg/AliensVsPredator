package org.avp.common.config;

import org.avp.AVP;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A proxy class that gets and sets a config setting without any inference about the config property in question.
 *
 * @author Boston Vanseghi
 */
public class ConfigSettingProxy<T> {

    private final String key;
    private final String description;
    private final boolean requiresRestart;
    private final Class<?> type;
    private final Supplier<T> supplier;
    private final Consumer<T> consumer;

    public ConfigSettingProxy(String key, boolean requiresRestart, Class<?> type, Supplier<T> supplier, Consumer<T> consumer) {
        this.key = AVP.Properties.ID + ".config." + key + ".key";
        this.description = AVP.Properties.ID + ".config." + key + ".desc";
        this.requiresRestart = requiresRestart;
        this.type = type;
        this.supplier = supplier;
        this.consumer = consumer;
    }

    public String getUnlocalizedKey() {
        return this.key;
    }

    public String getUnlocalizedDescription() {
        return this.description;
    }

    public boolean getRequiresRestart() {
        return this.requiresRestart;
    }

    public Class<?> getType() {
        return this.type;
    }

    public T get() {
        return this.supplier.get();
    }

    public void set(T value) {
        this.consumer.accept(value);
    }
}
