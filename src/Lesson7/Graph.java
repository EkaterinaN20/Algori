package Lesson7;

import java.util.*;

public class Graph implements iGraph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public void addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == - 1 && endIndex ==-1)
            throw new IllegalArgumentException("Invalid index for vertex");

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;

    }

    private int indexOf(String startLabel) {

        for (int i = 0; i < getSize(); i++) {
            if (startLabel.equals(vertexList.get(i).getLabel())) return i;
        }
        return -1;
    }

    @Override
    public void addEdge(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String other: others) {
            addEdge(startLabel, other);
        }
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize() ; i++) {
            System.out.println(vertexList.get(i).getLabel());
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j).getLabel());
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {

        int startIndex = indexOf(startLabel);

        if (startIndex == -1) throw new IllegalArgumentException("Invalid start label");

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);


        while (!stack.isEmpty()) {
            vertex = getNearestUnvisitedVertex(stack.peek());

            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearestUnvisitedVertex(Vertex current) {
        for (int i = 0; i < getSize(); i++) {
            int currentIndex = vertexList.indexOf(current);

            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        vertex.setVisited(true);
        stack.push(vertex);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        // System.out.println(vertex.getLabel());
        vertex.setVisited(true);
        queue.add(vertex);
    }

    private void visitVertexWoPrinting(Queue<Vertex> queue, Vertex vertex) {

        vertex.setVisited(true);
        queue.add(vertex);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) throw new IllegalArgumentException("Invalid start label");

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);


        while (!queue.isEmpty()) {
            vertex = getNearestUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    public List<Vertex> getShortestway(String startLabel, String endLabel)
    {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(startLabel);;
        int minWay = 0;
        boolean isFinished = false;
        String[] ways = new String[getSize()];

        if (startIndex == -1 || endIndex == -1) throw new IllegalArgumentException("Invalid start label");

        Queue<Vertex> queue = new LinkedList<>();

        Vertex startVertex = vertexList.get(startIndex);

        Vertex endVertex = vertexList.get(endIndex);

        visitVertexWoPrinting(queue, startVertex);


        while (!queue.isEmpty() || endIndex != indexOf(endLabel)) {
            startVertex = getNearestUnvisitedVertex(queue.peek());

            if (startVertex != null || endIndex != indexOf(endLabel)) {
                visitVertex(queue, startVertex);


            } else {
                queue.remove();
            }
        }

        resetVertexState();
        return null;
    }

    public Stack<String> findShortestWays(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(startLabel);


        if (startIndex == -1) throw new IllegalArgumentException("Invalid start label" + startLabel);
        if (endIndex == -1) throw new IllegalArgumentException("Invalid end label" + endLabel);

        Queue<Vertex> queue = new ArrayDeque<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);


        while (!queue.isEmpty()) {
            vertex = getNearestUnvisitedVertex(queue.peek());

            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getLabel().equals(endLabel)) {
                    return buildPath(vertex);
                }
            }
        }
        resetVertexState();
        return null;
    }

    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> stack = new Stack<>();

        Vertex current = vertex;

        while(current != null) {
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }
        return stack;
    }
}
