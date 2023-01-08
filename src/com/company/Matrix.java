package com.company;

import java.util.List;

public class Matrix {

    private int n;
    private int m;
    private char[][] matrix;
    private Node startNode;
    private Node finishNode;

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getFinishNode() {
        return finishNode;
    }

    public Matrix(int n, int m, Node startNode, Node finishNode) {
        this.n = n;
        this.m = m;
        this.startNode = startNode;
        this.finishNode = finishNode;
        matrix = new char[n][m];
        setMatrix();
        matrix[startNode.x][startNode.y] = 'S';
        matrix[finishNode.x][finishNode.y] = 'F';
    }

    private void setMatrix(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                matrix[i][j] = '.';
            }
        }
    }

    public void setBlocks(List<Node> blocks){
        for (Node block : blocks) {
            matrix[block.x][block.y] = '#';
        }
    }

    public char get(int x, int y){
        return matrix[x][y];
    }

    public void buildPath(List<Node> path){
        for (int i = 1; i < path.size() - 1; i++) {
            matrix[path.get(i).x][path.get(i).y] = 'x';
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                str.append(matrix[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
