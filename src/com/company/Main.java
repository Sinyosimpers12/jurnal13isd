package com.company;

public class Main {

    public static void main(String[] args) {
        int nodes[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int matriks[][] = {
// Simpul    A  B  C  D  E  F  G  H  I
            {0, 1, 0, 1, 1, 0, 0, 0, 0}, // Simpul A
            {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Simpul B
            {0, 1, 0, 0, 0, 0, 0, 0, 0}, // Simpul C
            {0, 0, 0, 0, 0, 0, 1, 0, 0}, // Simpul D
            {0, 0, 0, 0, 0, 1, 0, 1, 0}, // Simpul E
            {0, 0, 1, 0, 0, 0, 0, 1, 0}, // Simpul F
            {0, 0, 0, 0, 0, 0, 0, 1, 0}, // Simpul G
            {0, 0, 0, 0, 0, 0, 0, 0, 1}, // Simpul H
            {0, 0, 0, 0, 0, 1, 0, 0, 0}, // Simpul I
        };
        get_BFS_ADJACENT(matriks, nodes);
        get_DFS_ADJACENT(matriks, nodes);
    }

    public static void  get_BFS_ADJACENT(int matriks[][],int nodes[]){
        BFS_ADJACENT bfs_adjacent = new BFS_ADJACENT();
        for (int node : nodes) {
            bfs_adjacent.nodes.add(new NodeAdjacent(node));
        }

        System.out.print("Traversal Graph BFS : ");
        bfs_adjacent.bfs(matriks, bfs_adjacent.nodes.get(0));
        System.out.println("");
    }

    public static void  get_DFS_ADJACENT(int matriks[][],int nodes[]){
        DFS_ADJACENT dfs_adjacent = new DFS_ADJACENT();
        for (int node : nodes) {
            dfs_adjacent.nodes.add(new NodeAdjacent(node));
        }

        System.out.print("Traversal Graph DFS : ");
        dfs_adjacent.dfsUsingStack(matriks, dfs_adjacent.nodes.get(0));
        System.out.println("");
    }
}
