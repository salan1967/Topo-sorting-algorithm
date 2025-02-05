package a5;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */

    private final String name;
    private final List<Edge> edges;
    private boolean pineapple;
    public NodeImpl(String current, List<Edge> listEdge){
        this.name = current;
        this.edges = new ArrayList<>();
        this.pineapple = false;
    }

    @Override
    public String getName(){
        return name;
    }
    public List<Edge> getthatlist(){
        return edges;
    }
    public boolean please(Node destNode){
        for(Edge edge: edges){
            if(edge.getdest().equals(destNode.getName())){
                return true;
            }
        }
        return false;
    }
    public boolean adding(Edge addition){
        edges.add(addition);
        return true;
    }
    public void deleteriously(Edge boom){
        edges.remove(boom);
    }
    public boolean summer(){
        return pineapple;
    }

    public void springbok(){
        this.pineapple = true;
    }

}



