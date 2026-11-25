package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.util.*;

public class Graph<T> {
    private Map<Vertex<T>, List<Vertex<T>>> graph = new HashMap<>();
    public void addVertex(T t) { //adds a vertex
        graph.putIfAbsent(new Vertex<>(t), new ArrayList<>());
    }

    public void removeVertex(T t) { //removes vertex based on input element
        Vertex<T> vertex = new Vertex<>(t);
        graph.remove(vertex);
        graph.values().forEach(values -> values.remove(vertex));
    }
    public void addEdge(T t1, T t2) { //connects two vertices together
        Vertex<T> vertex1 = new Vertex<>(t1);
        Vertex<T> vertex2 = new Vertex<>(t2);
        Optional.ofNullable(graph.get(vertex1))
                .orElseThrow()
                .add(vertex2);
        Optional.ofNullable(graph.get(vertex2))
                .orElseThrow()
                .add(vertex1);
    }
    public void removeEdge(T t1, T t2) { //removes the edge of the corresponding vertices
        Vertex<T> vertex1 = new Vertex<>(t1);
        Vertex<T> vertex2 = new Vertex<>(t2);
        Optional.ofNullable(graph.get(vertex1))
                .orElseThrow()
                .remove(vertex2);
        Optional.ofNullable(graph.get(vertex2))
                .orElseThrow()
                .remove(vertex1);
    }
    public List<Vertex<T>> getAdjVertices(T t) { //gets all the connected vertices of the vertex
        return graph.get(new Vertex<>(t));
    }
}