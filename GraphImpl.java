package a5;

import java.util.*;
public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    int numOfNodes = 0;
    private int numOfEdges;
    Stack <String> sortedValid = new Stack<>();

    public GraphImpl() {
        nodes = new HashMap<>();
        int numOfEdges = 0;
    }

    @Override
    public boolean addNode(String name) {
        if(nodes.containsKey(name)){
            return false;
        }
        else{
            List<Edge> tree = new ArrayList<>();
            Node grass = new NodeImpl(name, tree);
            nodes.put(name, grass);
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0 || ! nodes.containsKey(dest) || ! nodes.containsKey(src)){
            return false;
        }
        Node house = nodes.get(src);
        Node faraway = nodes.get(dest);

        if (house.please(faraway)){
            return false;
        }
        else{
            Edge brick= new EdgeImpl(src, dest, weight);
            house.adding(brick);
            faraway.adding(brick);
            numOfEdges ++;
            return true;
        }
    }

    @Override
    public boolean deleteNode(String name) {
        //Hint: Do you need to remove edges when you delete a node?
        if (nodes.containsKey(name)) {
            Node school = nodes.get(name);
            List<Edge> note = school.getthatlist();
            for (Edge grade : note) {
                deleteEdge(grade.getstart(), grade.getdest());
            }
            nodes.remove(name);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        for (Node strawberry: nodes.values()){
            List<Edge> mango = strawberry.getthatlist();
            for(Edge kiwi: mango){
                if(Objects.equals(kiwi.getdest(), dest) && Objects.equals(kiwi.getstart(), src)){
                    strawberry.deleteriously(kiwi);
                    numOfEdges --;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int numNodes() {
        return nodes.size();
    }

    @Override
    public int numEdges() {
        return numOfEdges;
    }

    @Override
    public Stack<String> topoSort() {
        for (String cookie : nodes.keySet()) {
            winter(cookie);
        }
        Stack<String> donut = new Stack<>();
        while (!sortedValid.isEmpty()) {
            donut.push(sortedValid.pop());
        }
        return donut;
    }

    public void winter(String name) {
        if (!nodes.get(name).summer()) {
            nodes.get(name).springbok();
            for (int i = 0; i < nodes.get(name).getthatlist().size(); i++) {
                winter(nodes.get(name).getthatlist().get(i).getdest());
            }
            sortedValid.push(name);
        }
    }
}

