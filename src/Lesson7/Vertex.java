package Lesson7;

import java.util.Objects;

public class Vertex {

    private String label;
    private Vertex previousVertex;
    private boolean isVisited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean state) {
        isVisited = state;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.getLabel());
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(label);
    }

}
