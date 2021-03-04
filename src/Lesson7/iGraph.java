package Lesson7;

public interface iGraph {
    void addVertex(String label);

    void addEdge(String startLabel, String endLabel);

    void addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    // dfs = depth-first search

    void dfs(String startLabel);

    // bfs = breadth-first search

    void bfs(String startLabel);
}