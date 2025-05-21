package practice;

public class Stack {
 public static void main(String[] args) {
        Stack Stack = new Stack();
        Stack.push(-2);
        Stack.push(0);
        Stack.push(-3);
        System.out.println(Stack.getMin());
        Stack.pop();
        System.out.println(Stack.top());    
        System.out.println(Stack.getMin()); 
    }
    private Node head;
    public Stack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val,val,null);
        }
        else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop(){
        head =  head.next;
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return head.min;
    }

    private class Node {

        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
