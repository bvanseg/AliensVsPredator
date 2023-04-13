package org.avp.common.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigProxyGenerator {

    private ModelConfigProxyGenerator() {}

    public static void recurseModelConfig(ModelConfig config, Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            List<Annotation> annotations = Arrays.asList(field.getAnnotations());

            annotations.forEach(annotation -> {
                if (annotation instanceof ConfigValue.Collection)
                {
                    ConfigValue.Collection label = (ConfigValue.Collection) annotation;
                    field.setAccessible(true);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
                else if (annotation instanceof ConfigValue.Enum)
                {
                    ConfigValue.Enum label = (ConfigValue.Enum) annotation;
                    field.setAccessible(true);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
                else if (annotation instanceof ConfigValue.Boolean)
                {
                    ConfigValue.Boolean label = (ConfigValue.Boolean) annotation;
                    field.setAccessible(true);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
                else if (annotation instanceof ConfigValue.Number)
                {
                    ConfigValue.Number label = (ConfigValue.Number) annotation;
                    processNumberValue(obj, field, label);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
                else if (annotation instanceof ConfigValue.Decimal)
                {
                    ConfigValue.Decimal label = (ConfigValue.Decimal) annotation;
                    processDecimalValue(obj, field, label);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
                else if (annotation instanceof ConfigValue.String)
                {
                    ConfigValue.String label = (ConfigValue.String) annotation;
                    field.setAccessible(true);
                    createConfigProxy(config, label.key(), label.requiresRestart(), obj, field);
                }
            });

            if (annotations.stream().anyMatch(ConfigValue.Category.class::isInstance)) {
                try {
                    field.setAccessible(true);
                    recurseModelConfig(config, field.get(obj));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static void createConfigProxy(ModelConfig config, String key, boolean requiresRestart, Object obj, Field field) {
        config.configSettingProxies.add(new ConfigSettingProxy<>(key, requiresRestart, field.getType(), () -> {
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

    private static void processNumberValue(Object obj, Field field, ConfigValue.Number annotation) {
        field.setAccessible(true);
        try {
            Object fieldValue = field.get(obj);
            if (fieldValue == null) return;

            long clampedValue = Math.min(Math.max(((Number)fieldValue).longValue(), annotation.minValue()), annotation.maxValue());

            if (field.getType().isAssignableFrom(byte.class)) {
                field.setByte(obj, (byte) clampedValue);
            } else if (field.getType().isAssignableFrom(short.class)) {
                field.setShort(obj, (short) clampedValue);
            } else if (field.getType().isAssignableFrom(int.class)) {
                field.setInt(obj, (int) clampedValue);
            } else if (field.getType().isAssignableFrom(long.class)) {
                field.setLong(obj, clampedValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processDecimalValue(Object obj, Field field, ConfigValue.Decimal annotation) {
        field.setAccessible(true);
        try {
            Object fieldValue = field.get(obj);
            if (fieldValue == null) return;

            double clampedValue = Math.min(Math.max(((Number)fieldValue).doubleValue(), annotation.minValue()), annotation.maxValue());

            if (field.getType().isAssignableFrom(float.class)) {
                field.setFloat(obj, (float) clampedValue);
            } else if (field.getType().isAssignableFrom(double.class)) {
                field.setDouble(obj, clampedValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
