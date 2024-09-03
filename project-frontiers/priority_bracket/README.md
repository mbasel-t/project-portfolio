# Priority Bracket

## Concept overview
This is a custom data structure built on top of the ArrayList from the Java Collections Framework. When engaging in combat in Frontiers, everyone chooses their action for their turn at the same time, but the order of action execution is determined by the priority level of the action and the speed stat of the action user.

In the Frontiers game, combat is executed in "rounds". At the start of a round, each player chooses their action— for instance,
attacking another player— at the same time. Their action is represented as an **Action** object, which is added into a **PriorityBracket** object. Different actions have different levels of **priority**. When one Action has a higher priority level than another, it always goes
first. When two Actions have equal priority values, the tie is broken by the action-user's own **speed**. In the unlikely event that
two Actions have equal priority and speed, the Action that executes first is randomly determined. Actions are output with this order
in mind, and are removed when they are read, like a stack or a queue.

Once everyone has chosen their action in this round, every Action is executed in the aforementioned sequence. Then, the next round begins.

## Action.java
The version of Action.java included is used specifically for testing PriorityBracket.java's functionality, so it only includes
a basic constructor with the priority and speed instance variables, and accessor methods for each. In actual production, Action.java
includes the instance variables and methods necessary for the main file to execute an action in its entirety using a single Action
object.

## PriorityBracket.java
The PriorityBracket.java only contains two instance variables: "actions" (ArrayList<Action>) and "sorted" (boolean). actions is the
underlying data structure that manages inputs and outputs for the PriorityBracket, while sorted keeps track of whether actions is
sorted or not, so that it can always output actions in the intended "priority then speed then randomness" order, while also only
sorting when necessary.

Aside from the methods below, there is an accessor that indicates whether actions is empty or not, as well as a public method "kill"
that erases the contents of actions. This is necessary for certain actions and events in production that end a round of combat prematurely.

### Method add
The add method does not return, and takes one Action object as an argument. It adds the argument to the back of actions, then updates
the sorted instance variable by checking if the previous last Action in actions has either lower priority or the same priority and
equal or lower speed. If this is true, and if sorted was already true, then sorted will continue to be true; otherwise, sorted is
false.

### Method sort
The sort method does not return, and takes no arguments. It uses bubble sort to sort actions in "priority then speed then randomness"
order, with the "quickest" action in the back, then updates the sorted instance variable to true. Although sort is O(n^2) time complexity,
it has very simple implementation, and actions will almost never have more than four items in it in production, so this is not a major
concern. The sort method is private because it is automatically called when needed.

### Method pop
The pop method returns an Action object, and takes no arguments. First, it checks sorted to determine that actions is in order; if not,
the sort method is called. Then, it will view the last element in actions— the "quickest"— and will continue to iterate from that point
until it finds an item that is "slower" (that is, has lower priority, or equal priority and lower speed), or until it reads the entire
ArrayList. This is done to find Action objects that have equal priority and speed to the last one, so that the first one out can be
randomly selected. If this was not done, the first of these Actions out would be the last one to be inputted, which violates the concept
overview. Once the Action to be popped is selected, it is removed from actions and is returned.

### Method main
The main method demonstrates the ability of PriorityBracket.java to take several objects of different priorities and speeds and output
them in order. To facilitate this, print statements are added throughout the different methods so you can follow the process along. Feel
free to copy PriorityBracket.java and Action.java into your IDE and test out the PriorityBracket with your own inputs!
