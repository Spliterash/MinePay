package ru.spliterash.minepay.donate.storage.yaml.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class YamlUtils {
    private final Map<Class<?>, Yaml> yamlMap = new HashMap<>();
    private final DumperOptions options;

    static {
        options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setIndent(2);
        options.setPrettyFlow(true);


    }

    public static Yaml getYaml(Class<?> rootClazz) {
        return yamlMap.computeIfAbsent(rootClazz, c -> {
            Representer representer = new Representer();
            representer.getPropertyUtils().setSkipMissingProperties(true);
            representer.addClassTag(rootClazz, Tag.MAP);
            Yaml yaml = new Yaml(new CustomClassLoaderConstructor(rootClazz, rootClazz.getClassLoader()), representer, options, new Resolver());
            yaml.setBeanAccess(BeanAccess.FIELD);
            return yaml;
        });
    }

    @SneakyThrows
    public static void writeYaml(File file, Object obj) {
        Yaml yaml = getYaml(obj.getClass());
        yaml.dump(obj, new FileWriter(file, false));
    }

    public static <T> T loadYaml(String rawYaml, Class<T> clazz) {
        Yaml yaml = getYaml(clazz);
        return yaml.loadAs(rawYaml, clazz);
    }

    @SneakyThrows
    public static <T> T loadYaml(File file, Class<T> clazz) {
        Yaml yaml = getYaml(clazz);
        return yaml.loadAs(new FileReader(file), clazz);
    }
}
