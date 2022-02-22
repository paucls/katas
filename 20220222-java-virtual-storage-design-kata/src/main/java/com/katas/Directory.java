package com.katas;

import java.util.HashSet;
import java.util.Set;

public class Directory extends Resource {

    private final Set<Resource> resources;

    public Directory(String name) {
        super(name, 0);
        this.resources = new HashSet<>();
    }

    public Set<Resource> resources() {
        return new HashSet<>(resources);
    }

    public void add(Resource resource) {
        resources.add(resource);
    }

    @Override
    public int getSize() {
        return resources.stream()
                .mapToInt(Resource::getSize)
                .sum();
    }
}
