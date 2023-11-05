package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private Map<N, Set<N>> graph = new HashMap<>();

    @Override
    public void addNode(N node) {
        this.graph.put(node, new HashSet<N>());
    }

    @Override
    public void addEdge(N source, N target) {
        this.graph.put(source, new HashSet<N>()).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return this.graph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return this.graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        
    } 
}
