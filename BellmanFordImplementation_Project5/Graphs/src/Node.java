import java.util.ArrayList;

/**
 * An adjacency list representation of a node.
 */
public class Node<E> {
    
    /**
     * The data contained in this Node.
     */
    private E data; //data of type E (could be Integer, Double, Float, String or any defined class)
    
    /**
     * A list of IDs corresponding to the Nodes that are adjacent to this Node.
     * 
     * The "ID" of a Node is the position (index) it is in the Graph class field of type ArrayList called "nodes".
     */
    private ArrayList<Integer> adjacentList;
    
    /**
     * A list of the weights for edges leaving this Node.
     * Note that for any valid index i, weights.get(i) is the weight
     * for the edge connecting this Node with the Node adjacentList.get(i).
     */
    private ArrayList<Double> weights;

    public Node(E data) {
        this.data = data;
        this.adjacentList = new ArrayList<Integer>();
        this.weights = new ArrayList<Double>();
    }

    /**
     * Add an edge to another node, with the specified weight.
     */
    public void addEdgeTo(int toID, double weight) {
        adjacentList.add(toID);
        weights.add(weight);
    }
    
    /**
     * Add an edge to another node, with a weight of 1, which 
     * can also be considered "unweighted".
     */
    public void addEdgeTo(int toID) {
        addEdgeTo(toID, 1);
    }
    
    /**
     * @return The entire list of adjacent node IDs.
     */
    public ArrayList<Integer> getAdjacentList() {
        return adjacentList;
    }
    
    /**
     * @return The weight of the edge at adjacentList.get(edgeID).
     */
    public double getWeight(int edgeID) {
        return weights.get(edgeID);
    }

    /**
     * @return The data of this node. Note also the getDataAsString() method.
     */
    public E getData() {
        return data;
    }
    
    /**
     * Just a little convenience method demonstrating how to get a String representation
     * of the data, no matter what type E is.
     */
    public String getDataAsString() {
        return getData().toString();
    }
    
    /**
     * @return A string representation of the node: the data, and adjacent nodes.
     */
    public String toString() {
        String result = getDataAsString() + ": {";
        int i;
        for(i = 0; i < adjacentList.size()-1; i++)
            result += "(" + adjacentList.get(i) + ", " + weights.get(i) + "), ";
        result += "(" + adjacentList.get(i) + ", " + weights.get(i) + ")";
        
        return result + "}";
    }
}
