# 2095. Delete the Middle Node of a Linked List
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:
> Input: head = [1,3,4,7,1,2,6]

> Output: [1,3,4,1,2,6]

> Explanation: The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.

Example 2:
> Input: head = [1,2,3,4]

> Output: [1,2,4]

> Explanation: The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.

Example 3:
> Input: head = [2,1]

> Output: [2]

> Explanation: The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 

Constraints:
* The number of nodes in the list is in the range [1, 105].
* 1 <= Node.val <= 105

## My solution
* Runtime beats 99.77%
* Memory beats 91.99%

To solve this problem, the code must first find the middle node, then move the previous node's next pointer to the middle node's next pointer.
Because these nodes do not have a backwards pointer, though, the node directly before the middle is kept track of.

Finding the middle node is rather simple; the code simply keeps track of two pointers, and moves one two steps in the linked list at a time,
while the other moves one step at a time. Because the node directly before the middle is kept track of, though, one new node must be made,
pointing to the head node so that this process can begin. Once the node before the middle is found, it is simply pointed to the node after the
middle using ".next.next". The head node can usually be returned after this. The exception is if the size of the linked list is 1, which is
identified when the double speed pointer still points to the head. In this case, null is returned, since the only node in the list will be
removed.
