package org.avp.common.config;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ConfigTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                T obj = delegate.read(in);

                if (obj instanceof ModelConfig) {
                    ModelConfig config = (ModelConfig) obj;
                    this.recurseObject(config, config);
                }

                return obj;
            }

            private void recurseObject(ModelConfig config, Object obj) {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                Arrays.stream(declaredFields).forEach(field -> {
                    List<Annotation> annotations = Arrays.asList(field.getAnnotations());

                    annotations.forEach(annotation -> {
                        if (annotation instanceof ConfigValue.Enum)
                        {
                            ConfigValue.Enum label = (ConfigValue.Enum) annotation;
                            field.setAccessible(true);
                            createConfigProxy(config, label.description(), label.requiresRestart(), obj, field);
                        }
                        else if (annotation instanceof ConfigValue.Boolean)
                        {
                            ConfigValue.Boolean label = (ConfigValue.Boolean) annotation;
                            field.setAccessible(true);
                            createConfigProxy(config, label.description(), label.requiresRestart(), obj, field);
                        }
                        else if (annotation instanceof ConfigValue.Number)
                        {
                            ConfigValue.Number label = (ConfigValue.Number) annotation;
                            processNumberValue(obj, field, label);
                            createConfigProxy(config, label.description(), label.requiresRestart(), obj, field);
                        }
                        else if (annotation instanceof ConfigValue.Decimal)
                        {
                            ConfigValue.Decimal label = (ConfigValue.Decimal) annotation;
                            processDecimalValue(obj, field, label);
                            createConfigProxy(config, label.description(), label.requiresRestart(), obj, field);
                        }
                    });

                    if (annotations.stream().anyMatch(ConfigValue.Category.class::isInstance)) {
                        try {
                            field.setAccessible(true);
                            recurseObject(config, field.get(obj));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }

            private void createConfigProxy(ModelConfig config, String description, boolean requiresRestart, Object obj, Field field) {
                config.configSettingProxies.add(new ConfigSettingProxy<>(field.getName(), description, requiresRestart, field.getType(), () -> {
                    try {
                        return field.get(obj);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }, newValue -> {
                    try {
                        field.set(obj, newValue);
                    } catch (IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }));
            }

            private void processNumberValue(Object obj, Field field, ConfigValue.Number annotation) {
                field.setAccessible(true);
                try {
                    long clampedValue = Math.min(Math.max(((Number) field.get(obj)).longValue(), annotation.minValue()), annotation.maxValue());

                    if (field.getType().isAssignableFrom(byte.class)) {
                        field.setByte(obj, (byte) clampedValue);
                    } else if (field.getType().isAssignableFrom(short.class)) {
                        field.setShort(obj, (short) clampedValue);
                    } else if (field.getType().isAssignableFrom(int.class)) {
                        field.setInt(obj, (int) clampedValue);
                    } else if (field.getType().isAssignableFrom(long.class)) {
                        field.setLong(obj, clampedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            private void processDecimalValue(Object obj, Field field, ConfigValue.Decimal annotation) {
                field.setAccessible(true);
                try {
                    double clampedValue = Math.min(Math.max(((Number) field.get(obj)).doubleValue(), annotation.minValue()), annotation.maxValue());

                    if (field.getType().isAssignableFrom(float.class)) {
                        field.setFloat(obj, (float) clampedValue);
                    } else if (field.getType().isAssignableFrom(double.class)) {
                        field.setDouble(obj, clampedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
