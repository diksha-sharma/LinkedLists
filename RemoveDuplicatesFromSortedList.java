import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 6/2/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList
{
    public static void main(String args[])
    {
        ListNode root = new ListNode(1);
        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(1);
        ListNode temp3 = new ListNode(2);
        ListNode temp4 = new ListNode(3);
        ListNode temp5 = new ListNode(3);
        root.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;

        ListNode result = deleteDuplicates(root);
        while(result.next != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
    }

    public static ListNode deleteDuplicates(ListNode a)
    {
        ListNode root = a;
        while(a.next != null)
        {
            if(a.val == a.next.val)
            {
                if(a.next.next != null)
                {
                    a.next = a.next.next;
                }
                else
                {
                    a.next = null;
                    break;
                }
            }
            if(a.val != a.next.val)
            {
                a = a.next;
            }
        }
        return root;
    }
}
