package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PathFinder {

    private Matrix matrix;
    private boolean[][] visited;
    private QueueCustom<Integer> queue_x = new QueueCustom<>();
    private QueueCustom<Integer> queue_y = new QueueCustom<>();
    private Map<Node, List<Node>> map = new HashMap<>();

    private int[] direct_x = {-1, 1, 0, 0};
    private int[] direct_y = {0, 0, 1, -1};

    public PathFinder(Matrix matrix){
        this.matrix = matrix;
        visited = new boolean[matrix.getN()][matrix.getM()];
    }

    public List<Node> findPath(){
        boolean isFinish = false;

        queue_x.add(matrix.getStartNode().x);
        queue_y.add(matrix.getStartNode().y);
        visited[matrix.getStartNode().x][matrix.getStartNode().y] = true;
        while (queue_x.size() != 0){
            Integer x = queue_x.poll();
            Integer y = queue_y.poll();

            if(matrix.get(x, y) == 'F'){
                isFinish = true;
                path.add(new Node(x, y));
                getPath(map, new Node(x, y));
                break;
            }
            checkNeighbors(x, y);
        }

        if(isFinish){
            return path;
        }
        return null;
    }

    private List<Node> path = new ArrayList<>(){};
    private void getPath(Map<Node, List<Node>> map, Node value) {
        for (Map.Entry<Node, List<Node>> entry : map.entrySet()) {
            if(entry.getValue().stream().anyMatch(a -> a.equals(value))){
                path.add(entry.getKey());
                getPath(map, entry.getKey());
            }
        }
    }

    private void checkNeighbors(int x, int y) {
        Node key = new Node(x, y);
        map.put(key, new ArrayList<>());

        for (int i = 0; i < 4; i++) {
            int nx = x + direct_x[i];
            int ny = y + direct_y[i];

            if(nx < 0 || ny < 0 || nx >= matrix.getN() || ny >= matrix.getM()){
               continue;
            }

            if(!visited[nx][ny] && matrix.get(nx, ny) != '#'){
                queue_x.add(nx);
                queue_y.add(ny);
                map.get(key).add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
