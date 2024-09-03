public class Action {

    private int priority;
    private int speed;

    /** test constructor for PriorityBracket.java */
    public Action(int _priority, int _speed) {
        this.priority = _priority;
        this.speed = _speed;
    } // constructor for test use only

    /** priority accessor */
    public int priority() {
        return priority;
    } // method priority

    /** speed accessor */
    public int speed() {
        return speed;
    } // method speed
}
