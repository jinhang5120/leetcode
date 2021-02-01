package graph;

import java.util.HashSet;
import java.util.Set;

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int countNodes = 0;
        int countEdges = 0;
        Set<Integer> nodes = new HashSet<>();//已访问节点
        for(int[] edge:edges){
            if(!nodes.contains(edge[0])){
                countNodes++;
            }
            if(!nodes.contains(edge[1])){
                countNodes++;
            }
            countEdges++;
            if(countEdges==countNodes){
                return edge;
            }
        }
        return null;
    }
}
