package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_ADJACENT {
    private Queue<NodeAdjacent> queue = new LinkedList<>(); //daftar Queue
    static ArrayList<NodeAdjacent> nodes = new ArrayList<NodeAdjacent>(); //daftar simpul

    /*
    Method ini digunakan untuk mencari daftar tetangga dari suatu simpul.
    Daftar tetangga didapatkan dari matrik adjacent.
    */
    public ArrayList<NodeAdjacent> listTetangga(int matriks[][], NodeAdjacent x) {
        int idx = -1;
        ArrayList<NodeAdjacent> tetangga = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getData() == x.getData()) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            for (int j = 0; j < matriks[idx].length; j++) {
                if (matriks[idx][j] == 1) {
                    tetangga.add(nodes.get(j));
                }
            }
        }
        return tetangga;
    }


    /*
    Algoritma utama dari BFS. Sesuai dengan Algoritma pada bagian 13.3.1.1
    Parameter
    a. matriks : daftar matriks adjacent
    b. node : simpul awal
    */
    public void bfs(int matriks[][], NodeAdjacent node) {
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            NodeAdjacent element = queue.remove();
            System.out.print(convertAlphabet(element.getData()) + " ");
            ArrayList<NodeAdjacent> tetangga = listTetangga(matriks, element);
            for (int i = 0; i < tetangga.size(); i++) {
                NodeAdjacent n = tetangga.get(i);
                if (n != null && !n.isVisited()) {
                    queue.add(n);
                    n.setVisited(true);
                }
            }
        }
    }

    public String convertAlphabet(int i){
        i--;
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i+1);
    }
}

