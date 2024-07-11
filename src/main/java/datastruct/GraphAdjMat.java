package datastruct;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-08
 * @Description: 基于邻接矩阵实现的无向图
 */
public class GraphAdjMat {
    private List<Integer> nodes;//节点
    private List<List<Integer>> matrix;//邻接矩阵

    public GraphAdjMat(List<Integer> nodes, int[][] edges){//edges中为边中两点在节点数组中的索引值
        this.nodes = new ArrayList<>();
        this.matrix = new ArrayList<>();
        for (Integer node : nodes) {//点
            addNode(node);
        }
        for (int[] edge : edges) {//边
            addEdge(edge[0],edge[1]);
        }
    }

    public void removeEdge(int v1,int v2){
        int size = size();
        if(v1<0 || v2<0 || v1>= size|| v2>=size || v1==v2){
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        matrix.get(v1).set(v2,0);
        matrix.get(v2).set(v1,0);
    }

    public void addEdge(int v1, int v2) {//加边
        int size = size();
        if(v1<0 || v2<0 || v1>= size|| v2>=size || v1==v2){
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        //对称
        matrix.get(v1).set(v2,1);
        matrix.get(v2).set(v1,1);
    }

    public Integer removeNode(int index){//移除点
        if(index<0 || index>=size()){
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        Integer remove = nodes.remove(index);
        matrix.remove(index);
        for (List<Integer> list : matrix) {
            list.remove(index);
        }
        return remove;
    }


    public void addNode(Integer node) {//加点
        int size = size();
        nodes.add(node);
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < size; i++) {//先加一行
            row.add(0);
        }
        matrix.add(row);
        for (List<Integer> list : matrix) {//再加一列
            list.add(0);
        }
    }

    private int size() {//点的个数

        return nodes.size();
    }

    public static void main(String[] args) {
        GraphAdjMat graph = new GraphAdjMat(Arrays.asList(1, 6, 8, 9, 4), new int[][]{{0,1}, {0,2}, {0, 3}, {3, 4}});
        /*graph.removeEdge(3,4);
        graph.removeNode(3);*/
        System.out.println(graph);
        List<Integer> bfs = graph.BFS(0);
        List<Integer> dfs = graph.DFS(0);
        System.out.println(bfs);
        System.out.println(dfs);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[\n\t");
        int size = size();
        for (List<Integer> list : matrix) {
            if(size!=1){
                builder.append(list).append("\n\t");
            }else {
                builder.append(list).append("\n]");
            }
            size--;
        }
        return "GraphAdjMat{\n" +
                builder
                + "\n}";
    }

    public List<Integer> BFS(Integer rootIndex){//广度优先遍历
        if(size()==0){//空图，未初始化
            return null;
        }
         List<Integer> res = new ArrayList<>();//遍历节点序列的值
         Set<Integer> visited = new HashSet<>();//已经访问过的点的值
         Queue<Integer> queue = new LinkedList<>();//存放未访问节点的索引
         queue.offer(rootIndex);
         while (!queue.isEmpty()){
             Integer index = queue.poll();
             Integer node = nodes.get(index);
             res.add(node);
             visited.add(node);
             for (int i=0; i<size();i++) {//遍历矩阵每一列
                 Integer n = nodes.get(i);
                 if(matrix.get(index).get(i) ==1 && !visited.contains(n)){//是邻接点
                    queue.offer(i);
                 }
             }
         }
         return res;
    }
    private void dfs(Integer root,List<Integer> res,Set<Integer> visited){//辅助函数
        Integer node = nodes.get(root);
        res.add(node);
        visited.add(node);//当前节点
        for (int i = 0; i < size(); i++) {
            if(matrix.get(root).get(i)==1 && !visited.contains(nodes.get(i))){
                dfs(i,res,visited);//是邻接节点且未被访问
            }
        }
    }
    public List<Integer> DFS(Integer rootIndex){
        if(size()==0){
            return null;
        }
        List<Integer> res = new ArrayList<>();//记录点遍历序列
        Set<Integer> visited = new HashSet<>();//记录访问过的点的值
        dfs(rootIndex,res,visited);
        return res;
    }

}
