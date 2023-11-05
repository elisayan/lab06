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
        System.out.println(this.graph.keySet());
        return this.graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        List<N> pathList = new LinkedList<>();
        if (source == null || target == null) {
            return pathList;
        }

        List<N> toVisit = new LinkedList<>();
        Map<N, N> parentMap = new HashMap<>();
        Set<N> visited = new HashSet<>();

        toVisit.add(source);
        visited.add(source);

        while (!toVisit.isEmpty()) {
            N currentNode = toVisit.remove(0);

            Set<N> neighbors = linkedNodes(currentNode);

            for (N n : neighbors) {
                if(!visited.contains(neighbors)) {
                    parentMap.put(n, currentNode);
                    visited.add(n);
                    if (n.equals(target)) {
                        N node = target;
                        while (node != null) {
                            pathList.add(node);
                            node = parentMap.get(node);
                        }
                        List<N> reversePath = new LinkedList<>();
                        for (int i = pathList.size() - 1; i >= 0; i--) {
                            reversePath.add(pathList.get(i));
                        }
                        return pathList;
                    }
                    toVisit.add(n);
                }
            }
        }

        return pathList;
    } 
}
