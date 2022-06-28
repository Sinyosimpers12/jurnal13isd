package com.company;

public class NodeAdjacent {
    private int data;
    private boolean visited=false;

    NodeAdjacent(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
