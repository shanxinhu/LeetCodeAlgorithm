package com.shanxin.algorithm;

import com.shanxin.algorithm.node.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LC133_CloneGraphTest {

    private final LC133_CloneGraph solution = new LC133_CloneGraph();

    @Test
    public void testCloneGraph_Example1() {
        // 示例 1：adjList = [[2,4],[1,3],[2,4],[1,3]]
        // 输出：[[2,4],[1,3],[2,4],[1,3]]
        // 解释：图中有 4 个节点，形成一个正方形结构
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(2, clonedGraph.neighbors.size());
        
        // 验证是深拷贝（不是同一个对象）
        assertNotSame(node1, clonedGraph);
        
        // 验证所有节点都被克隆且是不同的对象
        for (Node neighbor : clonedGraph.neighbors) {
            assertNotSame(node1, neighbor);
            assertNotSame(node2, neighbor);
            assertNotSame(node3, neighbor);
            assertNotSame(node4, neighbor);
        }
        
        System.out.println("示例 1 - 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]");
        System.out.println("输出：克隆成功，节点数 = " + countNodes(clonedGraph));
    }

    @Test
    public void testCloneGraph_Example2() {
        // 示例 2：adjList = [[]]
        // 输出：[[]]
        // 解释：只有一个值为 1 的节点，没有邻居
        Node node1 = new Node(1);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(0, clonedGraph.neighbors.size());
        assertNotSame(node1, clonedGraph);
        
        System.out.println("示例 2 - 输入：adjList = [[]]");
        System.out.println("输出：克隆成功，单节点无邻居");
    }

    @Test
    public void testCloneGraph_Example3() {
        // 示例 3：adjList = []
        // 输出：[]
        // 解释：空图，不含任何节点
        Node clonedGraph = solution.cloneGraph(null);
        
        assertNull(clonedGraph);
        
        System.out.println("示例 3 - 输入：adjList = []");
        System.out.println("输出：null（空图）");
    }

    @Test
    public void testCloneGraph_SingleNode() {
        // 单节点测试
        Node node1 = new Node(1);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertTrue(clonedGraph.neighbors.isEmpty());
        assertNotSame(node1, clonedGraph);
        
        System.out.println("单节点 - 输入：节点 1（无邻居）");
        System.out.println("输出：克隆成功");
    }

    @Test
    public void testCloneGraph_TwoNodes() {
        // 两个节点互相连接
        // 1 -- 2
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(1, clonedGraph.neighbors.size());
        
        Node clonedNeighbor = clonedGraph.neighbors.get(0);
        assertEquals(2, clonedNeighbor.val);
        assertEquals(1, clonedNeighbor.neighbors.size());
        
        // 验证是深拷贝
        assertNotSame(node1, clonedGraph);
        assertNotSame(node2, clonedNeighbor);
        
        System.out.println("两节点 - 输入：1 <-> 2");
        System.out.println("输出：克隆成功");
    }

    @Test
    public void testCloneGraph_LinearGraph() {
        // 线性图：1 -- 2 -- 3 -- 4
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(1, clonedGraph.neighbors.size());
        
        // 验证整个图的结构
        int totalNodes = countNodes(clonedGraph);
        assertEquals(4, totalNodes);
        
        System.out.println("线性图 - 输入：1 -- 2 -- 3 -- 4");
        System.out.println("输出：克隆成功，总节点数 = " + totalNodes);
    }

    @Test
    public void testCloneGraph_CompleteGraph() {
        // 完全图：每个节点都与其他所有节点相连
        // 4 个节点的完全图 K4
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);
        
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        
        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(3, clonedGraph.neighbors.size());
        
        // 验证每个克隆节点的邻居数都是 3
        for (Node neighbor : clonedGraph.neighbors) {
            assertEquals(3, neighbor.neighbors.size());
        }
        
        System.out.println("完全图 K4 - 输入：4 个节点的完全图");
        System.out.println("输出：克隆成功");
    }

    @Test
    public void testCloneGraph_StarGraph() {
        // 星型图：中心节点 1，连接到 2、3、4
        //     2
        //     |
        // 3 - 1 - 4
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);
        node4.neighbors.add(node1);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(3, clonedGraph.neighbors.size());
        
        // 验证叶子节点只有 1 个邻居（中心节点）
        for (Node neighbor : clonedGraph.neighbors) {
            assertEquals(1, neighbor.neighbors.size());
        }
        
        System.out.println("星型图 - 输入：中心节点 1，叶子节点 2,3,4");
        System.out.println("输出：克隆成功");
    }

    @Test
    public void testCloneGraph_LargeGraph() {
        // 较大的图：9 个节点
        // 1-2-3
        // | | |
        // 4-5-6
        // | | |
        // 7-8-9
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nodes.add(new Node(i));
        }
        
        // 水平连接
        for (int i = 0; i < 9; i += 3) {
            if (i % 3 != 2) {
                nodes.get(i).neighbors.add(nodes.get(i + 1));
                nodes.get(i + 1).neighbors.add(nodes.get(i));
                nodes.get(i + 1).neighbors.add(nodes.get(i + 2));
                nodes.get(i + 2).neighbors.add(nodes.get(i + 1));
            }
        }
        
        // 垂直连接
        for (int i = 0; i < 6; i++) {
            nodes.get(i).neighbors.add(nodes.get(i + 3));
            nodes.get(i + 3).neighbors.add(nodes.get(i));
        }
        
        Node clonedGraph = solution.cloneGraph(nodes.get(0));
        
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        
        int totalNodes = countNodes(clonedGraph);
        assertEquals(9, totalNodes);
        
        System.out.println("大图 - 输入：3x3 网格图（9 个节点）");
        System.out.println("输出：克隆成功，总节点数 = " + totalNodes);
    }

    @Test
    public void testCloneGraph_DeepCopyVerification() {
        // 验证深拷贝：修改原图不影响克隆图
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        
        Node clonedGraph = solution.cloneGraph(node1);
        
        // 修改原图
        node1.neighbors.add(new Node(3));
        
        // 验证克隆图未受影响
        assertEquals(1, clonedGraph.neighbors.size());
        
        System.out.println("深拷贝验证 - 修改原图后，克隆图保持不变");
    }

    /**
     * 辅助方法：计算图中的节点总数（使用 BFS）
     */
    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        
        java.util.Set<Node> visited = new java.util.HashSet<>();
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        
        visited.add(node);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return visited.size();
    }
}
