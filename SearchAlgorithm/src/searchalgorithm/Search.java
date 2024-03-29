package searchalgorithm;

import java.util.LinkedList;

/**
 * this class is the parent of all searches you want to define with this interface
 * you can use all searches in both tree or graph implementation by determining isGraph parameter
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public abstract class Search {
    protected int nodeSeen;
    protected int nodeExpand;
    protected LinkedList<Integer> path; //action sequence
    protected int pathCost;
    protected int maxNodeKeptInMemory;  //maximum node kept in memory at a time
    protected State answer;

    protected Problem problem;
    protected boolean isGraph;
    protected LinkedList<State> f;   //frontier list
    protected LinkedList<State> e;   //explored list


    public Search(boolean isGraph) {
        this.isGraph = isGraph;
        nodeSeen = 0;
        nodeExpand = 0;
        path = new LinkedList<>();
        pathCost = 0;
        maxNodeKeptInMemory = 0;
        f = new LinkedList<>();
        e = new LinkedList<>();
    }

    public int getNodeSeen() {
        return nodeSeen;
    }

    public int getNodeExpand() {
        return nodeExpand;
    }

    public int getMaxNodeKeptInMemory() {
        return maxNodeKeptInMemory;
    }

    public LinkedList<Integer> getPath() {
        return path;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    abstract public void execute();

    public void search() {
    }

    protected void createSolutionPath(State state) {
        State temp = state;
        while (temp != null) {
            path.add(temp.act);
            temp = temp.parent;
        }
    }

    protected void showLists() {
        System.out.print("Open : ");
        for (State state : f) {
            System.out.print(state + ", ");
        }
        System.out.print("\tClosed : ");
        for (State state : e) {
            System.out.print(state + ", ");
        }
        System.out.println();
    }

}
