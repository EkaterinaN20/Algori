package Lesson7;

import java.util.Stack;

public class HW7 {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");


        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Курск", "Воронеж");

        // System.out.println("Size of graph is " + graph.getSize());
        // graph.display();
        // graph.bfs("Москва");
        Stack<String> path = graph.findShortestWays("Москва", "Воронеж");

        showPath(path);
    }

    private static void showPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while(!path.isEmpty()) {
            if (!isFirst) {
                sb.append(" - > ");
            }
            isFirst = false;
            sb.append(path.pop());
        }
        System.out.println(sb);
    }

}
