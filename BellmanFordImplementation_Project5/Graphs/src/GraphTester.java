////////////////////////////////////////////////////////////////////////////////
// File:             Project 4
// Course:           CSC233A, Spring 2022
// Authors:          Minh Nguyen
//
// Acknowledgements: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
public class GraphTester {
    
    public void test1() {
        Graph<String> g = new Graph<String>();
        
        // Create the nodes
        
        int albany = g.addNode("Albany, NY"); //0
        int atlanta = g.addNode("Atlanta, GA");//1
        int boise = g.addNode("Boise, ID");
        int buffalo = g.addNode("Buffalo, NY");//3
        int chicago = g.addNode("Chicago, IL");
        int dallas = g.addNode("Dallas, TX");
        int denver = g.addNode("Denver, CO");//6
        int fargo = g.addNode("Fargo, ND");
        int indianapolis = g.addNode("Indianapolis, IN");//8
        
        // Create the edges
        g.addUndirectedEdge(albany, atlanta, 1004);
        g.addUndirectedEdge(albany, buffalo, 288);
        g.addUndirectedEdge(atlanta, indianapolis, 533);
        g.addUndirectedEdge(atlanta, dallas, 786);
        g.addUndirectedEdge(boise, denver, 831);
        g.addUndirectedEdge(boise, fargo, 1221);
        g.addUndirectedEdge(buffalo, chicago, 538);
        g.addUndirectedEdge(buffalo, fargo, 1177);
        g.addUndirectedEdge(buffalo, indianapolis, 503);
        g.addUndirectedEdge(chicago, denver, 1009);
        g.addUndirectedEdge(chicago, fargo, 644);
        g.addUndirectedEdge(chicago, indianapolis, 179);
        g.addUndirectedEdge(dallas, denver, 882);
        g.addUndirectedEdge(dallas, indianapolis, 873);
        
        System.out.println("Here's the graph:");
        System.out.println(g); // calls toString automatically
        
        System.out.println("=============================");
        System.out.println("=============================");
        System.out.println("=============================");
        System.out.println("=============================");
        
        g.printOneEdgeAtATime();
    }
    
    public void testBellmanFord1(){
        Graph<String> g = new Graph<String>();

        int albany = g.addNode("Albany, NY"); //0
        int atlanta = g.addNode("Atlanta, GA");//1
        int boise = g.addNode("Boise, ID");
        int buffalo = g.addNode("Buffalo, NY");//3
        int chicago = g.addNode("Chicago, IL");
        int dallas = g.addNode("Dallas, TX");
        int denver = g.addNode("Denver, CO");//6
        int fargo = g.addNode("Fargo, ND");
        int indianapolis = g.addNode("Indianapolis, IN");//8
        
        g.addUndirectedEdge(albany, atlanta, 1004);
        g.addUndirectedEdge(albany, buffalo, 288);
        g.addUndirectedEdge(atlanta, indianapolis, 533);
        g.addUndirectedEdge(atlanta, dallas, 786);
        g.addUndirectedEdge(boise, denver, 831);
        g.addUndirectedEdge(boise, fargo, 1221);
        g.addUndirectedEdge(buffalo, chicago, 538);
        g.addUndirectedEdge(buffalo, fargo, 1177);
        g.addUndirectedEdge(buffalo, indianapolis, 503);
        g.addUndirectedEdge(chicago, denver, 1009);
        g.addUndirectedEdge(chicago, fargo, 644);
        g.addUndirectedEdge(chicago, indianapolis, 179);
        g.addUndirectedEdge(dallas, denver, 882);
        g.addUndirectedEdge(dallas, indianapolis, 873);

        g.bellmanFord(albany);
        System.out.println();

        System.out.println("Bellman-Ford improved: ");
        g.bellmanFordImporved(albany);
    }

    public void testBellmanFord2(){
        Graph<String> g = new Graph<String>();

        int albany = g.addNode("Albany, NY"); //0
        int atlanta = g.addNode("Atlanta, GA");//1
        int boise = g.addNode("Boise, ID");
        int buffalo = g.addNode("Buffalo, NY");//3
        int chicago = g.addNode("Chicago, IL");
        int dallas = g.addNode("Dallas, TX");
        int denver = g.addNode("Denver, CO");//6
        int fargo = g.addNode("Fargo, ND");
        int indianapolis = g.addNode("Indianapolis, IN");//8
        
        g.addUndirectedEdge(albany, atlanta, 1004);
        g.addUndirectedEdge(albany, buffalo, 288);
        g.addUndirectedEdge(atlanta, indianapolis, 533);
        g.addUndirectedEdge(atlanta, dallas, 786);
        g.addUndirectedEdge(boise, denver, 831);
        g.addUndirectedEdge(boise, fargo, 1221);
        g.addUndirectedEdge(buffalo, chicago, 538);
        g.addUndirectedEdge(buffalo, fargo, 1177);
        g.addUndirectedEdge(buffalo, indianapolis, 503);
        g.addUndirectedEdge(chicago, denver, 1009);
        g.addUndirectedEdge(chicago, fargo, 644);
        g.addUndirectedEdge(chicago, indianapolis, 179);
        g.addUndirectedEdge(dallas, denver, 882);
        g.addUndirectedEdge(dallas, indianapolis, 873);

        g.bellmanFord(dallas);
        System.out.println();

        System.out.println("Bellman-Ford improved: ");
        g.bellmanFordImporved(dallas);
    }

    public static void main(String[] args){
        GraphTester map = new GraphTester();
        map.test1();
        map.testBellmanFord1();
        map.testBellmanFord2();
    }
}