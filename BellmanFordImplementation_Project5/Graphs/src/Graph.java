import java.util.ArrayList;
/**
 * Representation of a graph
 */

public class Graph<E> {
    /**
     * An ArrayList containing <code>Node<E></code> objects, representing a graph
     */
    private ArrayList<Node<E>> nodes;
    /**
     * An ArrayList containing distances from a node to its predecessor
     */
    ArrayList<Double> d = new ArrayList<Double>();

    /**
     * An ArrayList containing a node's predecessor
     */
    ArrayList<Integer> pi = new ArrayList<Integer>();

    private static final double INF = Double.MAX_VALUE;

    /**
     * Records the total number of changes made when implementing Bellman-Ford on a <code>Graph</code>
     */
    private int changes;

    private int thisChange;

    public Graph() {
        nodes = new ArrayList<Node<E>>();
        
    }
    
    /**
     * @return The ID for this node.
     */
    public int addNode(E data) {
        nodes.add(new Node<E>(data));
        return nodes.size() - 1;
    }
    
    /**
     * Adds an undirected edge, with weight 1, to the graph.
     */
    public void addUndirectedEdge(int nodeID1, int nodeID2) {
        addUndirectedEdge(nodeID1, nodeID2, 1);
    }
    
    /**
     * Adds an undirected edge of the given weight to the graph.
     */
    public void addUndirectedEdge(int nodeID1, int nodeID2, double weight) {
        addDirectedEdge(nodeID1, nodeID2, weight); //Undirected edge is actually an edge that can be directed back and forth between two nodes
        addDirectedEdge(nodeID2, nodeID1, weight);
    }
    
    /**
     * Adds a directed edge of weight 1.
     */
    public void addDirectedEdge(int fromID, int toID) {
        addDirectedEdge(fromID, toID, 1);
    }
    
    /**
     * Adds a directed edge of the given weight.
     */
    public void addDirectedEdge(int fromID, int toID, double weight) {
        nodes.get(fromID).addEdgeTo(toID, weight);
    }
    
    /**
     * Returns a string representation of the graph.
     */
    public String toString() {
        String result = "---------------------------------\n";
        
        for(int i = 0; i < nodes.size(); i++){
            result += i + ": " + nodes.get(i).toString() + "\n" ;
        }
        result += "---------------------------------";

        return result;
    }
    
    /**
     * This is step (2) in the project.
     */
    public void printOneEdgeAtATime() {
        for (int i = 0; i < nodes.size(); i++){
            Node <E> node =  nodes.get(i);
            ArrayList <Integer> adjacentIDList = node.getAdjacentList();
            for (int j = 0; j < adjacentIDList.size();j++){
                int adjacentNodeID = adjacentIDList.get(j);
                System.out.println(
                "Edge from " + i + " " 
                + node.getDataAsString() + " to " + adjacentNodeID + " " 
                + nodes.get(adjacentIDList.get(j)).getData() + " " 
                + node.getWeight(j)
                );
            }
        }
    }
    
    /**
     * Performs the Bellman-Ford algorithm for the given source Node ID, printing out all results.
     * This is step (3) in the project, and optionally step (4) as well if you choose to do it.
     */
    public void bellmanFord(int sourceID){
        initializeSingleSource(sourceID);
        int i  = sourceID;
        changes = 0;
        do{
            thisChange = changes;
            while (i < nodes.size()){
                if (d.get(i) != INF){
                    Node <E> exam =  nodes.get(i);
                    ArrayList <Integer> adjToExam = exam.getAdjacentList();
                    int examID = nodes.indexOf(exam);
                    for (int j = 0; j < adjToExam.size(); j++){
                        relax(examID, adjToExam.get(j));
                    }
                }
                i++;
            }
            i = 0;
            while (i < sourceID){
                if (d.get(i) != INF){
                    Node <E> exam =  nodes.get(i);
                    ArrayList <Integer> adjToExam = exam.getAdjacentList();
                    int examID = nodes.indexOf(exam);
                    for (int j = 0; j < adjToExam.size(); j++){
                        relax(examID, adjToExam.get(j));
                    }
                }
                i++;
            }
        }
        while(changes > thisChange);

        //print out the results
        System.out.println("Source: "+ nodes.get(sourceID).getData());
        for (int j = 0; j < nodes.size(); j++){
            if (pi.get(j) == -1){
                System.out.println(nodes.get(j).getData()+ ": " + d.get(j) + ", by way of N/A");
            
            }
            else{
                System.out.println(nodes.get(j).getData()+ ": "+ d.get(j) + ", by way of "+ nodes.get(pi.get(j)).getData());
            }
        }
    }


    public void bellmanFordImporved(int sourceID){
        initializeSingleSource(sourceID);
        int i  = sourceID;
        changes = 0;
        do{
            thisChange = changes;
            while (i < nodes.size()){
                if (d.get(i) != INF){
                    Node <E> exam =  nodes.get(i);
                    ArrayList <Integer> adjToExam = exam.getAdjacentList();
                    int examID = nodes.indexOf(exam);
                    for (int j = 0; j < adjToExam.size(); j++){
                        relax(examID, adjToExam.get(j));
                    }
                }
                i++;
            }
            i = 0;
            while (i < sourceID){
                if (d.get(i) != INF){
                    Node <E> exam =  nodes.get(i);
                    ArrayList <Integer> adjToExam = exam.getAdjacentList();
                    int examID = nodes.indexOf(exam);
                    for (int j = 0; j < adjToExam.size(); j++){
                        relax(examID, adjToExam.get(j));
                    }
                }
                i++;
            }
        }
        while(changes > thisChange);

        //print out the results
        System.out.println("Source: "+ nodes.get(sourceID).getData());
        for (int j = 0; j < nodes.size(); j++){
            if (pi.get(j) == -1){
                System.out.println( "From " + nodes.get(sourceID).getData() + " to " +
                    nodes.get(j).getData()+ " distance: " + d.get(j) + ", path: " + nodes.get(sourceID).getData()
                );
            
            }
            else{
                System.out.print(
                    "From " + nodes.get(sourceID).getData() + " to " + 
                    nodes.get(j).getData()+ " distance: "+ d.get(j) + ", path: "
                ); 
                path(j, sourceID);
                System.out.print(nodes.get(j).getData());
                System.out.println();
            }
        }
    }

    /**
     * the total path from the source node to a given node
     * @param uID
     * @param sourceID
     */
    
    public void path(int uID, int sourceID){
        String path = "";
        if (pi.get(uID) == -1){
            path += "";
        } else{
            path += nodes.get(pi.get(uID)).getData() + ", ";
            path(pi.get(uID), sourceID);
        }
        System.out.print(path);
    }

    /**
     * initializes <code>d</code> and <code>pi</code>
     * @param sourceID
     */
    public void initializeSingleSource(int sourceID){
        for (int i = 0; i < nodes.size(); i++){
            d.add(INF);
            pi.add(-1);
        }
        d.set(sourceID, 0.0);
    }

    /**
     * find the shortest path from the source node to a given node
     * @param uID
     * @param vID
     */
    public void relax(int uID, int vID){
        double uD = d.get(uID);
        double vD = d.get(vID);
        double w = distanceFromUtoV(uID, vID);
        if (uD + w < vD){
            d.set(vID, uD + w);
            pi.set(vID, uID);
            changes++; 
        }
    }

    /**
     * return the distance between two adjacent node
     * @param uID
     * @param vID
     * @return the distance from node with ID of uID to node v with vID, return 0.0 if two nodes are not adjacent
     */
    public Double distanceFromUtoV(int uID, int vID){;
        for (int i = 0; i < nodes.size(); i++){
            Node<E> u = nodes.get(i);
            if (i == uID){
                ArrayList <Integer> adjacentList = u.getAdjacentList();
                for (int j = 0; j <adjacentList.size(); j++){
                    if (adjacentList.get(j) == vID){
                        return u.getWeight(j);
                    }
                }
            }
        }
        return 0.0;
    }
}


