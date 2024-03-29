package searchalgorithm;
/**
 * this class is the parent of all problems' state you want to define with this interface
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public abstract class State {
    protected State parent;
    protected int act;  //action that caused to reach this state
    protected int pathCost;


    public State() {
        parent = null;
        act = -1;
        pathCost = 0;
    }

    public int getAct() {
        return act;
    }
}
