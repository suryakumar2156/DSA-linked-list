import java.util.*;

//Node Constructor
class Node{
    int data;
    Node next;
    Node prev;
    Node(int val){
        data=val;
        next=null;
        prev=null;
    }
}

//Main Class
class DoubleLinkedList{

    Node head;
    Node tail;

    DoubleLinkedList(){
        head=null;
        tail=null;
    }

    //Inser At Beginning
    public void insertAtbegin(int k){
        Node newnode=new Node(k);
        if(head==null){
            head=newnode;
            tail=newnode;
        }else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }

    //Insert At End
    public void insertAtend(int k){
        Node newnode=new Node(k);
        if(tail==null){
            head=newnode;
            tail=newnode;
        }else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }

    //Insert At Position
    public void insertAtpos(int pos,int k){
        Node newnode=new Node(k);
        Node temp=head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        newnode.prev=temp;
        temp.next=newnode;
        temp.next.prev=newnode;
    }

    //Display Node
    public void display(){
        Node temp=head;
        System.out.print("og ");
        while(temp!=null){
            System.out.print(temp.data+"  ");
            temp=temp.next;
        }
    }

    //Delete At Begin
    public void deleteAtbegin(){
        head=head.next;
        if(head==null)
            tail=null;
        else{
            head.prev=null;
        }
    }

    //Delet At Position
    public void deleteAtpos(int pos){
        if(pos==0){
            deleteAtbegin();
            return;
        }
        else{
        Node temp=head;
        Node prev=null;
        for(int i=1;i<=pos;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        if(temp.next==null)
            tail=prev;
        else
            temp.next.prev=prev;
        }
    }

    //Driver Code
    public static void main(String[] args){

        DoubleLinkedList dg=new DoubleLinkedList();
        dg.insertAtbegin(1);
        dg.insertAtend(9);
        dg.insertAtend(3);
        dg.insertAtend(4);
        dg.insertAtend(54);
        dg.insertAtend(6);
        dg.insertAtpos(3,56);
        //dg.deleteAtpos(0);
        dg.deleteAtpos(6);
        dg.display();

    }
}
