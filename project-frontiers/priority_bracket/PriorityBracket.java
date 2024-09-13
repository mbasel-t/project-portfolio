import java.util.ArrayList;

public class PriorityBracket {
    
    private ArrayList<Action> actions;

    private boolean sorted;

    /** Constructor */
    public PriorityBracket() {
        this.actions = new ArrayList<Action>(4);
        this.sorted = true;
    } // constructor

    /** Adds an action to the back of the underlying ArrayList */
    public void add(Action action) {

        // if sorted, check if item to-be-added will cause array to be unsorted
        if(this.sorted && this.actions.size() > 0) {
            // ensure priority is not out-of-order
            this.sorted = action.priority() >= this.actions.get(this.actions.size()-1).priority();

            // if priority is equal, ensure speed is not out-of-order
            if (action.priority() == this.actions.get(this.actions.size()-1).priority()) {
                this.sorted = action.speed() >= this.actions.get(this.actions.size()-1).speed();
            }
        }

        this.actions.add(action);
        //System.out.println("ADDED ACTION W/ SPEED VAL " + action.speed() + " && PRIO VAL " + action.priority() + "; " + (this.sorted ? "BRACKET SORTED\n" : "BRACKET NOT SORTED\n"));
    } // method add

    /** ArrayList sorter (fastest in back, slowest in front) */
    private void sort() {
        if(this.actions.size() > 1) {
            this.sorted = false;

            // bubble sort
            while (!this.sorted) {

                // assume list is sorted until observed otherwise
                this.sorted = true;

                // iterate through adjacent pairs of indices
                for (int i = 1; i < this.actions.size(); i++) {
                    // case: out of order due to priority
                    if (actions.get(i).priority() < this.actions.get(i-1).priority()) {
                        Action swapper = this.actions.get(i);
                        this.actions.set(i, this.actions.get(i-1));
                        this.actions.set(i-1, swapper);
                        this.sorted = false;
                    }
                    // case: same priority, but out of order due to speed
                    else if (actions.get(i).priority() == this.actions.get(i-1).priority() && actions.get(i).speed() < this.actions.get(i-1).speed()) { 
                        Action swapper = this.actions.get(i);
                        this.actions.set(i, this.actions.get(i-1));
                        this.actions.set(i-1, swapper);
                        this.sorted = false;
                    }
                }
                //System.out.println("A ROUND OF SORTING HAS BEEN COMPLETED");
            }
            //System.out.println("SORTING COMPLETED\n");
        } else {
            // array of 0 or 1 items is always sorted
            this.sorted = true;
        }
    } // method sort

    /** Fastest element retriever/remover method -- if multiple items tied for fastest, random selection */
    public Action pop() {
        if (!this.sorted) {
            this.sort();
        }
        Action result = null;
        if (!actions.isEmpty()) {
            // checks if multiple items tied for fastest
            int num_same = 1;
            boolean same = (this.actions.size() >= 2 ? this.actions.get(this.actions.size()-1).speed() == this.actions.get(this.actions.size()-2).speed() && this.actions.get(this.actions.size()-1).priority() == this.actions.get(this.actions.size()-2).priority() : false);
            while(same) {
                num_same++;
                same = (this.actions.size() >= num_same+1 ? this.actions.get(this.actions.size()-num_same).speed() == this.actions.get(this.actions.size()-1-num_same).speed() : false);
            }

            // select and remove fastest value; if multiple are tied, pick at random
            int select = (int)Math.ceil(Math.random() * num_same);
            System.out.println((num_same > 1 ? "RANDOM" : "STATIC" ) + " DETERMINANT; Current bracket size " + (actions.size() > 9 ? actions.size() : "0" + actions.size()) + "; Equal value count " + num_same + "; Random value " + select + "; Priority level " + (actions.get(actions.size()-1).priority() < 0 ? actions.get(actions.size()-1).priority() : "+" + actions.get(actions.size()-1).priority() ) + "; Speed stat " + actions.get(actions.size()-1).speed());
            result = this.actions.remove(this.actions.size()-select);
        }
        return result;
    } // method pop

    /** Emptiness accessor */
    public boolean isEmpty() {
        return actions.isEmpty();
    } // method isEmpty

    /** Turn kill; for effects that instantly end turn */
    public void killTurn() {
        this.actions = new ArrayList<Action>(4);
        this.sorted = true;
    } // method killTurn

    // Tester; TEST PASSED
    public static void main(String[] args) {
        PriorityBracket bracket = new PriorityBracket();
        bracket.add(new Action(0, 1));
        bracket.add(new Action(-2, 8));
        bracket.add(new Action(0, 4));
        bracket.add(new Action(0, 2));
        bracket.add(new Action(0, 5));

        bracket.add(new Action(2, 1));
        bracket.add(new Action(1, 4));
        bracket.add(new Action(4, 2));
        bracket.add(new Action(-5, 5));
        bracket.add(new Action(7, 3));
        bracket.add(new Action(1, 4));
        bracket.add(new Action(2, 2));
        bracket.add(new Action(2, 3));
        bracket.add(new Action(4, 4));

        bracket.add(new Action(0, 3));
        bracket.add(new Action(0, 4));
        bracket.add(new Action(0, 2));
        bracket.add(new Action(0, 3));
        bracket.add(new Action(0, 4));

        boolean result = true;
        Action lastElement = bracket.pop();

        while(!bracket.isEmpty()) {
            Action currentElement = bracket.pop();
            if (currentElement.priority() != lastElement.priority()) {
                result = result && currentElement.priority() < lastElement.priority();
            } else {
                result = result && currentElement.speed() <= lastElement.speed();
            }
            lastElement = currentElement;
        }
        System.out.println("\nTEST RESULT: " + (result ? "passed" : "failed"));
    }
}
