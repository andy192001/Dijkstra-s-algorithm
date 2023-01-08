package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Matrix matrix = new Matrix(8, 8, new Node(0, 2), new Node(5, 4));
        matrix.setBlocks(List.of(
                new Node(0, 0),
                new Node(1, 0), new Node(1, 1), new Node(1, 3), new Node(1, 5), new Node(1, 6), new Node(1, 7),
                new Node(3, 1), new Node(3, 2), new Node(3, 3), new Node(3, 4), new Node(3, 6),
                new Node(4, 5),
                new Node(5, 2), new Node(5, 5),
                new Node(6, 2), new Node(6, 3), new Node(6, 4), new Node(6, 5)));
        System.out.println(matrix);

        PathFinder pathFinder = new PathFinder(matrix);
        matrix.buildPath(pathFinder.findPath());
        System.out.println(matrix);
    }
}
