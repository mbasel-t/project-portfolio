//package project_frontiers;
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
        this.actions.add(action);
        if(this.actions.size() > 1) {
            this.sorted = this.sorted && this.actions.get(this.actions.size()-1).priority() >= this.actions.get(this.actions.size()-2).priority();
            if (this.sorted = this.sorted && this.actions.get(this.actions.size()-1).priority() == this.actions.get(this.actions.size()-2).priority()) {
                this.sorted = this.sorted && this.actions.get(this.actions.size()-1).speed() >= this.actions.get(this.actions.size()-2).speed();
            }
        } else {
            this.sorted = true;
        }
        System.out.println("ADDED ACTION W/ SPEED VAL " + action.speed() + " && PRIO VAL " + action.priority() + "; " + (this.sorted ? "BRACKET SORTED\n" : "BRACKET NOT SORTED\n"));
    } // method add

    /** ArrayList sorter (fastest in back, slowest in front) */
    private void sort() {
        if(!this.actions.isEmpty()) {
            this.sorted = false;
            while (!this.sorted) {
                this.sorted = true;
                for (int i = 1; i < this.actions.size(); i++) {
                    if (actions.get(i).priority() < this.actions.get(i-1).priority()) {
                        Action swapper = this.actions.get(i);
                        this.actions.set(i, this.actions.get(i-1));
                        this.actions.set(i-1, swapper);
                        this.sorted = false;
                    } else if (actions.get(i).priority() == this.actions.get(i-1).priority() && actions.get(i).speed() < this.actions.get(i-1).speed()) {
                        Action swapper = this.actions.get(i);
                        this.actions.set(i, this.actions.get(i-1));
                        this.actions.set(i-1, swapper);
                        this.sorted = false;
                    }
                }
                System.out.println("A ROUND OF SORTING HAS BEEN COMPLETED");
            }
            System.out.println("SORTING COMPLETED\n");
        }
    } // method sort

    /** Fastest element retriever/remover method -- only works when sorted */
    public Action pop() {
        if (!this.sorted) {
            this.sort();
        }

        Action result = null;
        if (!actions.isEmpty()) {
            int num_same = 1;
            boolean same = (this.actions.size() >= 2 ? this.actions.get(this.actions.size()-1).speed() == this.actions.get(this.actions.size()-2).speed() && this.actions.get(this.actions.size()-1).priority() == this.actions.get(this.actions.size()-2).priority() : false);
            while(same) {
                num_same++;
                same = (this.actions.size() >= num_same+1 ? this.actions.get(this.actions.size()-num_same).speed() == this.actions.get(this.actions.size()-1-num_same).speed() : false);
            }
            int select = (int)Math.ceil(Math.random() * num_same);
            System.out.println("RANDOM DETERMINANT; SIZE " + actions.size() + "; EQUAL VALUE COUNT " + num_same + "; RANDOM VAL " + select + "; PRIORITY BRACKET " + actions.get(actions.size()-1).priority() + "; SPEED BRACKET " + actions.get(actions.size()-1).speed());
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
        bracket.add(new Action(null, 0, 1));
        bracket.add(new Action(null, -2, 8));
        bracket.add(new Action(null, 0, 4));
        bracket.add(new Action(null, 0, 2));
        bracket.add(new Action(null, 0, 5));

        bracket.add(new Action(null, 2, 1));
        bracket.add(new Action(null, 1, 4));
        bracket.add(new Action(null, 4, 2));
        bracket.add(new Action(null, -5, 5));
        bracket.add(new Action(null, 7, 3));
        bracket.add(new Action(null, 1, 4));
        bracket.add(new Action(null, 2, 2));
        bracket.add(new Action(null, 2, 3));
        bracket.add(new Action(null, 4, 4));

        bracket.add(new Action(null, 0, 3));
        bracket.add(new Action(null, 0, 4));
        bracket.add(new Action(null, 0, 2));
        bracket.add(new Action(null, 0, 3));
        bracket.add(new Action(null, 0, 4));

        boolean result = true;
        Action lastElement = bracket.pop();

        while(!bracket.isEmpty()) {
            Action currentElement = bracket.pop();
            if (currentElement.priority() != lastElement.priority()) {
                result = result && currentElement.priority() <= lastElement.priority();
            } else {
                result = result && currentElement.speed() <= lastElement.speed();
            }
            lastElement = currentElement;
        }
        //System.out.println("\nTEST RESULT: " + (result ? "passed" : "failed"));
    }
}
