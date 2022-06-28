package com.company;

import java.util.ArrayList;
import java.util.Stack;
public class DFS_ADJACENT {
    static ArrayList<NodeAdjacent> nodes = new ArrayList<>();
    /*
    Method ini digunakan untuk mencari daftar tetangga dari suatu simpul.
    Daftar tetangga didapatkan dari matrik adjacent.
    */
    public ArrayList<NodeAdjacent> findNeighbours(int matriks[][], NodeAdjacent x) {
        int idx = -1;
        ArrayList<NodeAdjacent> tetangga = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
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
    Algoritma utama dari DFS. Sesuai dengan Algoritma pada bagian 13.3.2.1
    Parameter
    matriks : daftar matriks adjacent
    node : simpul awal
    */

    public void dfsUsingStack(int matriks[][], NodeAdjacent node) {
        Stack<NodeAdjacent> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            NodeAdjacent element = stack.pop();
            if (!element.isVisited()) {
                System.out.print(convertAlphabet(element.getData()) + " ");
                element.setVisited(true);
            }
            ArrayList<NodeAdjacent> tetangga = findNeighbours(matriks, element);
            for (int i = 0; i < tetangga.size(); i++) {
                NodeAdjacent n = tetangga.get(i);
                if (n != null && !n.isVisited()) {
                    stack.add(n);
                }
            }
        }
    }

    public String convertAlphabet(int i){
        i--;
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i+1);
    }
}