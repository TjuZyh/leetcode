package com.leetcode.Graph;

import java.util.*;

/**
 * @Author zyh
 * @Date 2023/5/12 13:45
 * @Version 1.0
 */
/*
* 寻找无环图中最小生成树
*   Kruskal算法：
*       算法步骤：
*         1. 将边按照权值依次从小达到排列
*         2. 依次将边所关联的节点加入维护的图中，若存在环，则丢弃该边
*         3. 直到全部节点加入到图中
*       实现方案：可以通过并查集实时判断是否成环，成环则之间抛弃
* */
public class Kruskal {
    public static int[] parent = new int[4];

    public Integer findRoot(Integer NodeId) {
        if(NodeId == parent[NodeId]) {
            return NodeId;
        }else {
            return parent[NodeId] = findRoot(parent[NodeId]);
        }
    }

    /**
     * 合并函数：如果两个点不存在关联关系，则将其合并，并返回true
     * 反之，返回false
     * @param nodeId1
     * @param nodeId2
     * @return
     */
    public boolean unionRoot(Integer nodeId1, Integer nodeId2) {
        int root1 = findRoot(nodeId1);
        int root2 = findRoot(nodeId2);
        if(root1 != root2) {
            parent[root1] = root2;
            return true;
        }
        return false;
    }

    public Integer kruskal(List<Edge> edges, Integer nodeCnt) {
        Integer minSum = 0;
        //最终形成的最小生成树中只能有 nodeCnt - 1 条边
        Integer edgeCnt = nodeCnt - 1;
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        for(Edge edge : edges) {
            //如果加入节点后不产生环，则累加边权值
            if(unionRoot(edge.getFrom(), edge.getTo())) {
                //System.out.println(Arrays.toString(parent));
                minSum += edge.getValue();
                edgeCnt--;
            }
            //所有节点均加入图中，无需判断后续的边了，直接退出即可
            if(edgeCnt == 0) {
                break;
            }
        }
        return minSum;
    }


    public static void main(String[] args) {
        Edge edge1 = new Edge(1, 2, 1);
        Edge edge2 = new Edge(2, 3, 2);
        Edge edge3 = new Edge(3, 1, 4);

        //init
        for(int i = 1; i <= 3; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        Kruskal kruskal = new Kruskal();
        System.out.println(kruskal.kruskal(edges, 3));

    }

}

class Edge {
    private Integer from;
    private Integer to;
    private Integer value;

    public Edge(Integer from, Integer to, Integer value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", value=" + value +
                '}';
    }
}
