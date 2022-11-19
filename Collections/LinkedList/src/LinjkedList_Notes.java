/*

// Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;

     // constructor
     ListNode(int x) {
       val = x;
     }
 }

--------- Reverse a singly linked list -----------------------------
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Algorithm
- We use Three Pointers to reverse a List.
- The Three Pointers are Previous, Current and Next.
- Initialize Current pointer to Head.
- Traverse till the end of the List.
- Initialize the Previous pointer be null since there is nothing before head.
- At Each index, We have to know the next node. for traversing forward.
- Use Next to store the curr.next
- Now to Reverse the list. The current pointer’s next have to point the previous node.
- Now we have reversed the index. We have to repeat this step till the end of the list.
- We have to simply move one step ahead.
- For that, The current pointer becomes the previous pointer.
- The next pointer becomes the current.

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
}

------------- Reverse Linked List II ----------------------------------------------------
Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

Algorithm
Traverse till the mth node. Make it Current Node.
Make the m-1 node as a start node.
The Start Node indicates the start of the k-nodes that you have to reverse.
Then you have Reverse the List from m to n.
Now you have to link the start node to the last node of the reversed node.
Link the Last Node to the current nth node.
Return the List.

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode curr  =head;
        ListNode start= null;
        while( m > 1)
        {
            start = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode tail = curr;
        ListNode prev = null;
        while( n >0)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        if(start != null)
            start.next = prev;
        else
           head = prev;
        tail.next = curr;

        return head;

    }
}

--------------------- Two Pointer Approach.(Tortoise and Hare) Method --------------------
Two Pointer Approach
The Two Pointer Approach comprises of slow and fast pointers, which are manipulated
in a way to traverse the same list in different ways.
Mostly it depends on moving slow pointer with one step and fast pointer with two steps.

Get the middle element of the Linked List.
If there are two middle nodes, return the second middle node.

One Simple way of Finding the Middle of the Linked List is to Find the Count of the
Linked List in one pass. In the Next pass traverse till(count/2) times.
Return the node at (count/2 ) position.

Can you think of a way to Solve this in One Pass?

Algorithm -
- This approach is called a Two Pointer Approach.
- More Often than not, you will be implementing this approach to solve a LL Problem
- Initialize two Pointers Slow and Fast.
- Traverse till the End of the List based on the Fast pointer.
- For Each iteration, The Slow pointer moves one step while the Fast Pointer moves two Steps.
- So When the Fast Pointer Reaches the End of the List the Slow Pointer will be in the
  middle of the Linked List.

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow =head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

------------------------------ Palindrome Linked List ----------------------------------------------------
Given a singly linked list, determine if it is a palindrome.

Example 1 -
Input: 1->2
Output: false

Example 2 -
Input: 1->2->2->1
Output: true

Here is the Solution that Employs the Previous two Approaches.
- You have to Split the List in the Middle.
- Reverse the Second part of the List.
- Start from these two Lists. Check if they are similar or not till you reach the end of the list.

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode mid = find_mid(head);

        ListNode r = mid.next;
        mid.next = null;
        System.out.println(r.val);
        ListNode l = head;
        r = reverse(r);


        boolean result = true;
        while( l!=null &&  r!= null)
        {
            if(r.val != l.val)
                result = false;

            l = l.next;
            r = r.next;
        }
        return result;
    }

    public ListNode reverse(ListNode root)
    {
        ListNode curr = root;
        ListNode prev = null;
        ListNode next = root;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        System.out.println(prev.val);
        return prev;


    }
    public ListNode find_mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast= fast.next.next;
        }

        System.out.println(slow.val);
        return slow;
    }
}

---------------- Linked List Cycle Detection -----------------------------------------------------------
Given a linked list, determine if it has a cycle in it.

Algorithm
- For Detecting if there is a cycle in a Linked List.
- We Traverse the list using two pointer approach.
- At any time if the slow pointer has caught up to the fast pointer then the Linked List has a cycle.
- Otherwise if the fast pointer traverse the end of the List. Then there is no cycle

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        boolean ans = false;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ans = true;
                break;
             }
         }
         return ans;
    }
}

--------------------------------- Linked List Cycle Detection II -----------------------------------------
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the
position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Algorithm
We follow the Same Two Pointer Approach as Discussed Above.
Once we have detected a cycle is present.
We Initialize the first pointer to head of the list, keeping the Second pointer
at the intersection point.
Now, you have to traverse both pointers one by one.
The node where these two pointers meet is the Start of the Cycle.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag =0;
        while (fast != null && fast.next != null)
            {

System.out.println(slow.val +" " + fast.val);
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                {
                flag = 1;
                break;
                }

            }
        if(flag == 0)
            return null;

        System.out.println(fast.val);
        slow = head;
        ListNode ptr1 = head;
        ListNode ptr2 = fast;

        while(ptr1 != ptr2)
            {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            }
        System.out.println(ptr1.val);
        return ptr1;
    }
}

----------------------- Get Intersection of Linked List ----------------------------------------------
Write a program to find the node at which the intersection of two singly linked lists begins.

We use the same two pointer approach.
When you Reach the end of a list. Make the pointer point to the other list’s head.
If they meet at some point then that is the intersection point.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null|| headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a!= b)
            {
            a = a == null? headB: a.next;
            b = b == null? headA: b.next;
            }
        return a;
    }
}


--------------------- Merging Two Linked Lists -------------------------------------------------------
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

Algorithm
1.Create a dummy variable. This is done to overcome edge conditions.
2.Now traverse till both of the Linked Lists are Empty.
3.This is done by using an OR Condition.
    (l1 != null || l2 != null)
4. When you introduce this condition, it is important that you think of the Edge Conditions.
   i,e What if one list is longer than the other. Then one node will be null while the other
   is not null. Here we don’t even have to check which one to merge since you just have to
   merge the one with the value.
5. At each iteration, Check which one of the element is smaller, merge that to the result list.
   Move forward in that list alone.
6. Repeat this till the End of both the Lists.

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode a = ans;
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
            {
                ans.next = l2;
                break;
            }

            if(l2 == null)
            {
                ans.next = l1;
                break;
            }

            if(l1.val <= l2.val )

            {
                ans.next = l1;
                l1 = l1.next;
            }
            else
            {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;

        }
        return a.next;

    }
}

----------------------- Reorder List ----------------------------------------------------------------
Given a singly linked list L: L0→ L1→ …→ Ln-1 → Ln,
reorder it to: L0→ Ln→ L1→ Ln-1→ L2→ Ln-2→…
You may not modify the values in the list’s nodes, only nodes itself may be changed.

Eg. Given 1->2->3->4, reorder it to 1->4->2->3.

Algorithm
Find the Middle of the Linked List.
Split it into two halves.
Reverse the Second Half.
Merge both lists alternatively.

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode mid  =  find_mid(head);

        ListNode l2 =  mid.next;
        mid.next = null;
        ListNode l1 = head;

        ListNode prev =  null;
        l2 = reverse(l2);

        ListNode ans =  new ListNode(0);
        int dir = 0;
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
            {
                ans.next = l2;
                break;

            }

            if(l2 == null)
            {
                ans.next = l1;
                break;
            }

            if(dir == 0)
            {

                ans.next = l1;
                l1= l1.next;
                dir = 1;

            }
           else if(dir == 1)
            {

                ans.next = l2;
                l2 = l2.next;
                dir = 0;

            }
            ans = ans.next;
        }



    }
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next ==null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
            while(curr!= null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode find_mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}

------------------- Remove Linked List Elements -----------------------------------
The Sentinel Node is the node that you create as a dummy node.
Mostly you will be using it for overcoming the edge cases of deleting the head.

Whenever you are dealing with removal of a node or removing a particular value from a list,
anything that remotely resembles removal of a node, you have to think of using the Sentinel Node first.


Remove all elements from a linked list of integers that have value val.
Example
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

You will be creating a dummy node that acts as a node previous to the Head of the given Linked List.
ListNode sen = new ListNode(0); sen.next = head;
This is done so that you could delete the head of the list without going through the headache of
treating the head of the list differently and the rest of the List with different logic.
if the head of the list contains the given value.
Create a previous pointer that points to the sentinel node.
Traverse the List using curr pointer. If the current value has to be removed then make the
previous pointer’s next to the next of current pointer.
At the end of the Traversal. Return sen.next which is going to be the head of the new modified list.

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sen = new ListNode(0);
        sen.next = head;

        ListNode curr = head;
        ListNode prev = sen;

        while(curr != null)
        {
            if(curr.val == val)
                  prev.next = curr.next;
            else
            prev = curr;

            curr = curr.next;

        }
        return sen.next;
    }
}

Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

This Problem employs two pointer and use of Sentinel Node.

Algorithm
To Remove nth Node, Use two pointers Slow and Fast.
Move the fast pointer n-steps.
Initialize the Slow pointer to the Sentinel Node.
Move both the Slow and Fast pointers one by one.
When the Fast Pointer reaches the end of the List. The slow pointer has reached the nth Node.
Now just change the previous.next to slow.next
*/

