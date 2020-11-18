// Lab 008	: Graph Floyd Algorithm 
// Name : Leegeonmin
// Student ID : 20171660

import java.util.*;


class Graph {
    int numofnodes;  // the number of nodes in the graph
    private int[][] CostAdj; // Adjacency matrix
    private int[][] c; // c array
    private int[][] kay; // kay array

    final int LargeCost = 999999999;

    Graph() {
        // Graph constructor.
        numofnodes = 0;
    }


    void Init(int n) {
        numofnodes = n;
        // now create 2 dimensional array of numofnodes * numofnodes
        CostAdj = new int[numofnodes][numofnodes];
        c = new int[numofnodes][numofnodes];
        kay = new int[numofnodes][numofnodes];

        for(int i = 0; i < numofnodes; i++) {
            for(int j = 0; j < numofnodes; j++)
                CostAdj[i][j] = LargeCost;  // initialize the adjacency matrix
            CostAdj[i][i] = 0;
        }
    }

    // return the path length between i and j
    int GetPathLength(int i, int j) {
        return c[i][j];
    };

    void Edge(int v1, int v2, int cost) {
        //	NEED TO IMPLEMENT
        CostAdj[v1][v2] = cost;
    }
    void Floyd() {
        // initialize the matrix
        for(int i = 0; i < numofnodes; i++) {
            // initialize all entries to 0
            for(int j = 0; j < numofnodes; j++) {
                c[i][j] = CostAdj[i][j]; // initial distances
                kay[i][j] = -1;	// not intermediate nodes
            }
        }

        //	NEED TO IMPLEMENT
        for(int k = 0; k < numofnodes; k++){
            for(int i = 0; i < numofnodes; i++){
                for(int j = 0; j < numofnodes; j++){
                    if(c[i][j] > c[i][k] + c[k][j]){
                        c[i][j] = c[i][k] + c[k][j];
                        kay[i][j] = k;
                    }
                }
            }
        }
        // end of the algorithm
    }

    String outputPath(int i, int j) {
        //	NEED TO IMPLEMENT
        String str = new String();
        if(i == j){
            return str;
        }
        if(kay[i][j] == -1){
            str += "-";
            str += j;
            return str;
        }else {
            str+=outputPath(i, kay[i][j]);
            str+=outputPath(kay[i][j], j);
        }
        return str;
    }
}
