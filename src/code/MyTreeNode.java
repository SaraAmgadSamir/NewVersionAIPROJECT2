package code;

import java.util.*;

public class MyTreeNode {
    public String currentState;
    public MyTreeNode parent;
    public String action;
    public int depth;
    public int cost;

    public MyTreeNode(String state, MyTreeNode parent, String action) {
        currentState = state;
        this.parent = parent;
        this.action = action;
    }

    public MyTreeNode(String state, MyTreeNode parent, String action, int depth) {
        currentState = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
    }

    public MyTreeNode(String state, MyTreeNode parent, int cost, String action) {
        currentState = state;
        this.parent = parent;
        this.action = action;
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }

}