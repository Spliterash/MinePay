package ru.spliterash.minepay.donate.storage.yaml.utils;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.representer.Representer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class NonAnchorRepresenter extends Representer {

    public NonAnchorRepresenter() {
        this.multiRepresenters.put(Map.class, new RepresentMap() {
            public Node representData(Object data) {
                return representWithoutRecordingDescendents(data, super::representData);
            }
        });
    }

    protected Node representWithoutRecordingDescendents(Object data, Function<Object,Node> worker) {
        Map<Object,Node> representedObjectsOnEntry = new LinkedHashMap<Object,Node>(representedObjects);
        try {
            return worker.apply(data);
        } finally {
            representedObjects.clear();
            representedObjects.putAll(representedObjectsOnEntry);
        }
    }

}