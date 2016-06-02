import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 6/2/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */
public class AddTwoNumbersAsLists
{
    public static void main(String args[])
    {
        ListNode a = new ListNode(9);
        ListNode temp1 = new ListNode(9);
        ListNode temp2 = new ListNode(1);
        a.next = temp1;
        temp1.next = temp2;

        ListNode b = new ListNode(1);
        /*ListNode temp4 = new ListNode(6);
        ListNode temp5 = new ListNode(8);
        b.next = temp4;
        temp4.next = temp5;*/

        ListNode result = addTwoNumbers(a, b);

        while(result.next != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b)
    {
        ListNode result = null;
        ListNode add = null;
        if(a.equals(null))
        {
            return b;
        }
        else if(b.equals(null))
        {
            return a;
        }
        else
        {
            int sum = 0;
            int carry = 0;
            boolean bLSB = true;
            while(a.next != null && b.next != null)
            {
                sum = a.val + b.val + carry;
                if(sum <= 9) //no carry
                {
                    carry = 0;
                    if(bLSB == true)
                    {
                        add = new ListNode(sum);
                        result = add;
                        bLSB = false; // to indicate least significant digit of the result
                    }
                    else
                    {
                        ListNode temp = new ListNode(sum);
                        add.next = temp;
                        add = add.next;
                    }
                }
                else
                {
                    carry = sum/10;
                    sum = sum%10;
                    if(bLSB == true)
                    {
                        add = new ListNode(sum);
                        result = add;
                        bLSB = false; // to indicate least significant digit of the result
                    }
                    else
                    {
                        ListNode temp = new ListNode(sum);
                        add.next = temp;
                        add = add.next;
                    }
                }
                a = a.next;
                b = b.next;
            }

            if(a.next == null)
            {
                if(b.next != null)
                {
                    boolean bFirst = true;
                    while(b.next != null)
                    {
                        if(bFirst == true)
                        {
                            sum = a.val + b.val + carry;
                            bFirst = false;
                        }
                        else
                        {
                            sum = b.val + carry;
                        }

                        if(sum <= 9) //no carry
                        {
                            carry = 0;
                            if(bLSB == true)
                            {
                                add = new ListNode(sum);
                                result = add;
                                bLSB = false; // to indicate least significant digit of the result
                            }
                            else
                            {
                                ListNode temp = new ListNode(sum);
                                add.next = temp;
                                add = add.next;
                            }
                        }
                        else
                        {
                            carry = sum/10;
                            sum = sum%10;
                            if(bLSB == true)
                            {
                                add = new ListNode(sum);
                                result = add;
                                bLSB = false; // to indicate least significant digit of the result
                            }
                            else
                            {
                                ListNode temp = new ListNode(sum);
                                add.next = temp;
                                add = add.next;
                            }
                        }
                        b = b.next;
                    }

                    sum = b.val + carry;
                    if(sum <= 9) //no carry
                    {
                        carry = 0;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                    else
                    {
                        carry = sum/10;
                        sum = sum%10;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                }
                else //if a and b both next == null
                {
                    sum = a.val + b.val + carry;
                    if(sum <= 9) //no carry
                    {
                        carry = 0;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                    else
                    {
                        carry = sum/10;
                        sum = sum%10;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                }
            }
            else if(b.next == null)
            {
                if(a.next != null)
                {
                    boolean bFirst = true;
                    while(a.next != null)
                    {
                        if(bFirst == true)
                        {
                            sum = a.val + b.val + carry;
                            //System.out.println("A and B sum: " + sum);
                            bFirst = false;
                        }
                        else
                        {
                            sum = a.val + carry;
                            //System.out.println("only A sum: " + sum);
                        }

                        if(sum <= 9) //no carry
                        {
                            carry = 0;
                            if(bLSB == true)
                            {
                                add = new ListNode(sum);
                                result = add;
                                bLSB = false; // to indicate least significant digit of the result
                            }
                            else
                            {
                                ListNode temp = new ListNode(sum);
                                add.next = temp;
                                add = add.next;
                            }
                        }
                        else
                        {
                            carry = sum/10;
                            sum = sum%10;
                            //System.out.println("new sum: " + sum);
                            //System.out.println("carry: " + carry);
                            if(bLSB == true)
                            {
                                add = new ListNode(sum);
                                result = add;
                                bLSB = false; // to indicate least significant digit of the result
                            }
                            else
                            {
                                ListNode temp = new ListNode(sum);
                                add.next = temp;
                                add = add.next;
                            }
                        }
                        a = a.next;
                    }

                    sum = a.val + carry;
                    if(sum <= 9) //no carry
                    {
                        carry = 0;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                    else
                    {
                        carry = sum/10;
                        sum = sum%10;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                }
                else //if a and b both next == null
                {
                    sum = a.val + b.val + carry;
                    if(sum <= 9) //no carry
                    {
                        carry = 0;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                    else
                    {
                        carry = sum/10;
                        sum = sum%10;
                        if(bLSB == true)
                        {
                            add = new ListNode(sum);
                            result = add;
                            bLSB = false; // to indicate least significant digit of the result
                        }
                        else
                        {
                            ListNode temp = new ListNode(sum);
                            add.next = temp;
                            add = add.next;
                        }
                    }
                }
            }

            if(carry != 0)
            {
                ListNode temp = new ListNode(carry);
                add.next = temp;
                carry = 0;
            }
        }
        return result;
    }
}
