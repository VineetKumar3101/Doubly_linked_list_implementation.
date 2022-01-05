//Doubly linked list implementation

interface DoublyLinkedListADTs

{

    void addFirst(int element);

    void addLast(int element);

    int removeFirst();

    int removeLast();

    int removeLastUsingTail();

/*void inBetween(int element);

int removeGivenNode(int givenElement);

int first();

int last();

int lastWithoutUsingTail();*/

    boolean isEmpty();

    int size();

    void traverse();

//boolean search(int searchElement);

    void moveMiddleToTop();

    int deleteMiddle();

}

class DoublyLinkedList

{

    public static void main(String args[])

    {

        DoublyLinkListImplementation list=new DoublyLinkListImplementation();

        list.addFirst(1);

        list.addLast(2);

        list.addLast(3);

        list.addLast(4);

        //list.addLast(5);



        //list.addLast(5);

        list.traverse();

        list.deleteMiddle();

        System.out.println("\nLinked list after deleting middle node .");



        //list.moveMiddleToTop();

        //System.out.println("\nLinked list after moving middle node to Top :");

        list.traverse();

        //list.removeFirst();

//System.out.println("\nLinkedList after deleting first node :");		

        //list.traverse();

        //list.removeLast();

        //System.out.println("\nLinked list after deleting last node without using tail.");

        //list.removeLastUsingTail();

        //System.out.println("\nLinked list after deleting last node with using tail.");



        //list.traverse();

    }





}

class Node

{

    private int data;

    private Node next;

    private Node previous;

    public Node()

    {

        data=0;

        next=null;





    }

    public Node(int data)

    {



        this.data=data;

        next=null;





    }

    public void setData(int data)

    {

        this.data=data;



    }

    public int getData()

    {

        return data;

    }

    public void setNext(Node next)

    {

        this.next=next;

    }

    public Node getNext()

    {



        return next;



    }

    public void setPrevious(Node previous)

    {



        this.previous=previous;



    }

    public Node getPrevious()

    {

        return previous;



    }



}

class DoublyLinkListImplementation implements DoublyLinkedListADTs

{

    private Node head;

    private Node tail;

    private int size;



    public DoublyLinkListImplementation()

    {



        head=null;

        tail=null;

        size=0;



    }



    public void moveMiddleToTop()

    {

        Node temp=head;

        int count=1;

        Node prev=null;

        if(!isEmpty())

        {

            if(size%2!=0)

            {

                while(count!=(size+1)/2)

                {

                    prev=temp;

                    temp=temp.getNext();

                    count++;

                }

                prev.setNext(temp.getNext());

                temp.setNext(head);

                head=temp;

            }

            else

            {

                while(count!=(size)/2)

                {

                    prev=temp;

                    temp=temp.getNext();

                    count++;

                }

                prev.setNext(temp.getNext());

                temp.setNext(head);

                head=temp;

            }

        }

        else

        {

            System.out.println("Sorry! you can not perform this operation.");

        }

    }

    public int deleteMiddle()

    {

        int response=0;

        Node temp=head;

        Node prev=null;

        int count=1;

        if(!isEmpty())

        {

            if(size%2!=0)

            {

                while(count!=(size+1)/2)

                {

                    prev=temp;

                    temp=temp.getNext();

                    count++;



                }

                response=temp.getData();

                prev.setNext(temp.getNext());

            }

            else

            {

                while(count!=(size)/2)

                {

                    prev=temp;

                    temp=temp.getNext();

                    count++;



                }

                response=temp.getData();

                prev.setNext(temp.getNext());

            }

            size--;

        }

        else

        {

            System.out.println("Sorry ! delete can not be performed.");



        }

        return response;







    }

    public void addFirst(int element)

    {

        Node node=new Node(element);

        if(!isEmpty())

        {



            node.setNext(head);

            head.setPrevious(node);

            head=node;



        }

        else

        {



            head=node;

            tail=node;





        }

        size++;

    }

    public void addLast(int element)

    {

        Node node=new Node(element);

        Node temp=head;

        if(!isEmpty())

        {

            while(temp.getNext()!=null)

            {



                temp=temp.getNext();



            }

            temp.setNext(node);

            node.setPrevious(temp);

            tail=node;

        }

        else

        {



            head=node;

            tail=node;



        }



        size++;

    }

    public int removeFirst()

    {



        int response=0;//zero is consider as invalid data

        if(!isEmpty())

        {

            response=head.getData();

            if(head==tail)//size==1

            {



                head=null;

                tail=null;

            }

            else

            {

                head=head.getNext();

                head.setPrevious(null);

            }

            size--;

        }

        else

        {

            System.out.println("Sorry! Linked List is already Empty..");



        }

        return response;

    }

    public int removeLast()

    {

        int response=0;

        if(!isEmpty())

        {

            response=tail.getData();

            if(head==tail)

            {

                head=null;

                tail=null;

            }

            else

            {

                Node temp=head;

                while(temp.getNext().getNext()!=null)

                {

                    temp=temp.getNext();

                }

                temp.setNext(null);

                tail=temp;

            }

            size--;

        }

        else

        {

            System.out.println("Sorry ! linked list is already empty.");



        }

        return response;

    }

    public int removeLastUsingTail()

    {

        int response=0;

        if(!isEmpty())

        {

            response=tail.getData();

            if(head==tail)

            {

                head=null;

                tail=null;

            }

            else

            {

                tail=tail.getPrevious();

                tail.setNext(null);

            }

            size--;

        }

        else

        {

            System.out.println("Sorry ! linked list is already empty.");



        }

        return response;

    }



    public void traverse()

    {

        System.out.println();

        if(!isEmpty())

        {

            Node temp=head;

            System.out.print("head"+" "+"---->"+" ");

            while(temp!=null)

            {

                System.out.print(" "+temp.getData());

                //System.out.print(" "+temp.getPrevious()+"  "+temp.getData()+" "+temp.getNext()+" ");

                temp=temp.getNext();



            }



        }

        else

        {



            System.out.println("Sorry Linked list is empty..");

        }

    }

    public boolean isEmpty()

    {

        if(head==null)

        {



            return true;



        }

        else

        {



            return false;



        }



    }



    public int size()

    {



        return size;



    }





}