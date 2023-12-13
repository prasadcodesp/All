// A Linked List Node
class Node
{
    int data;       // integer data
    Node next;      // pointer to the next node
 
    public Node(int data)
    {
        // set data in the allocated node and return it
        this.data = data;
        this.next = null;
    }
}
 
class Queue
{
    private static Node rear = null, front = null;
    private static int count = 0;

 
    // Utility function to add an item to the queue
    public static void enqueue(int item)     // insertion at the end
    {
        // allocate a new node in a heap
        Node node = new Node(item);
        System.out.printf("Inserting %d\n", item);
 
        // special case: queue was empty
        if (front == null)
        {
            // initialize both front and rear
            front = node;
            rear = node;
        }
        else {
            // update rear
            rear.next = node;
            rear = node;
        }
 
        // increase the node's count by 1
        count += 1;
    }
 
 
    // Utility function to dequeue the front element
    public static int dequeue()     // delete at the beginning
    {
        if (front == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }
 
        Node temp = front;
        System.out.printf("Removing %d\n", temp.data);
 
        // advance front to the next node
        front = front.next;
 
        // if the list becomes empty
        if (front == null) {
            rear = null;
        }
 
        // decrease the node's count by 1
        count -= 1;
 
        // return the removed item
        return temp.data;
    }

    // Utility function to return the top element in a queue
    public static int peek()
    {
        // check for an empty queue
        if (front == null) {
            System.exit(-1);
        }
 
        return front.data;
    }
 
    // Utility function to check if the queue is empty or not
    public static boolean isEmpty() {
        return rear == null && front == null;
    }
 
    // Function to return the size of the queue
    private static int size() {
        return count;
    }
}
 
class Main1
{
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enqueue(1);  // front 
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);	// rear
 
        System.out.printf("The front element is %d\n", q.peek());
 
        q.dequeue(); // 1
        q.dequeue();
        q.dequeue();
        q.dequeue(); // 4
 
        if (q.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}






// Implementation of Stack using Single Linked List 

class Stack
{

// A Linked List Node
	class Node
	{
    		int data;       // integer data
    		Node next;      // pointer to the next node

    		public Node(int x) {
			this.data = x;
			next = null;
   		}
	}

    private Node top;
    private int nodesCount;
    
    public Stack() {
        this.top = null;
        this.nodesCount = 0;
    }

// Utility function to add an element `x` to the stack

public void push(int x)        // insert at the beginning
{
	Node node = new Node(x);		// allocate a new node in a heap
        
        if (node == null)	// check if stack (heap) is full. Then inserting an element would lead to stack overflow
        {
            System.out.println("Heap Overflow");
            return;
        }

        System.out.println("Inserting " + x);
        node.data = x;
        node.next = top;
        top = node;
        this.nodesCount = this.nodesCount + 1;
}

public boolean isEmpty() 	 // Utility function to check if the stack is empty or not
{
	return top == null;
}


// Utility function to return the top element of the stack

public int peek()
{
       	if (isEmpty())  // check for an empty stack
	{
            System.out.println("The stack is empty");
            System.exit(-1);
        }
        return top.data;
}

// Utility function to pop a top element from the stack
    
public int pop()        // remove at the beginning
{
        if (isEmpty())		// check for stack underflow
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        int top = peek();			// take note of the top node's data
        System.out.println("Removing " + top);
        this.nodesCount = this.nodesCount - 1;				 // decrease stack's size by 1
        this.top = (this.top).next;		 // update the top pointer to point to the next node
        return top;
}

// Utility function to return the size of the stack
    
public int size() {
	return this.nodesCount;
}
 
public void display()
{
        if (isEmpty()) // check for an empty stack
	{
            System.out.println("The stack is empty");
        }
        else 
	{
		Node current = top;
		System.out.print("Stack elements: ");
		while (current != null)
		{
			System.out.print(current.data + " ");
        		current = current.next;
     		}
      		System.out.println();
   	}
		

}   

}

class Main
{
public static void main(String[] args)
    {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

	stack.display();
        System.out.println("The top element is " + stack.peek());
        stack.pop();
        stack.pop();
	stack.display();
        stack.pop();
        
        
    }

}





// Java Program to Implement Hash Tables with Linear Probing

import java.io.*;
import java.util.*;
import java.util.Scanner;	// Importing Scanner class as inputs are entered at run-time when
 
class LP {
   
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;
 
    public LP(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }
 
    public void makeEmpty()	 // Function to clear hash table
    {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }
  
    public int getSize() 	// Function to get size of hash table
    { 
	return currentSize; 
    }
 
    public boolean isFull()	// Function to check if hash table is full
    {
        return currentSize == maxSize;
    }
 
    public boolean isEmpty() 	 // Function to check if hash table is empty
    { 
	return getSize() == 0; 
    }
   
    public boolean contains(String k)	 // Function to check if hash table contains a key
    {
        return get(k) != null;
    }
 
    private int hash(String k)  // Function to get hash code of a given key
    {
        //return k.hashCode() % maxSize;
        return Integer.parseInt(k)%maxSize;
    }
 
    public void insert(String k, String v)	    // Function to insert key-value pair
    {
        int tmp = hash(k);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = k;
                vals[i] = v;
                currentSize++;
                return;
            }
 
            if (keys[i].equals(k)) {
                vals[i] = v;
                return;
            }

            i = (i + 1) % maxSize;
        }
        while (i != tmp);
    }

    public String get(String k)     // Function to get value for a given key
    {
        int i = hash(k);
        while (keys[i] != null) {
            if (keys[i].equals(k))
                return vals[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }
 
    public void remove(String k)	    // Function to remove key and its value
     {
        if (!contains(k))
            return;
        int i = hash(k);		 // Find position key and delete
        while (!k.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = vals[i] = null;
         // rehash all keys
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) 
	{
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }
 
    public void printHashTable()	   // Function to print HashTable
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + vals[i]);
        System.out.println();
    }
}
 
public class Hashtable {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
 
        LP l = new LP(scan.nextInt());
 
        char ch;
 
        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");
            System.out.println("5. size");
            int choice = scan.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter key and value");
                l.insert(scan.next(), scan.next());
                break;
 	     
            case 2:
                System.out.println("Enter key");
                l.remove(scan.next());
                break;
 
            case 3:
                System.out.println("Enter key");
                System.out.println("Value = "+ l.get(scan.next()));
                break;
 
            case 4:
                l.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
 
            case 5:
                System.out.println("Size = "+ l.getSize());
                break;
 
            default:
                System.out.println("Wrong Entry \n ");
                break;
            }
 
            l.printHashTable();		 // Display hash table
            
            System.out.println("\nDo you want to continue (Type y or n) \n");
 
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}




// for max heap
public class Heapsort{


public void sort(int arr[])
{
   int n= arr.length;
   for(int i=n/2-1;i>=0;i--)
 	heapify (arr,n,i);

   for(int i=n-1; i>=0;i--)
   {
      int temp=arr[0];
      arr[0]= arr[i];
      arr[i]=temp;
      heapify(arr,i,0);
   }
}

void heapify(int arr[], int n, int i)
{
    int largest=i;
    int l=2*i+1;
    int r=2*i+2;

  if(l<n && arr[l]>arr[largest])
	largest = l;

  if(r<n && arr[r]>arr[largest])
	largest = r;

  if(largest!=i){
       int swap=arr[i];
	arr[i]= arr[largest];
	arr[largest]=swap;
	heapify(arr,n,largest);
    }
}


/*void heapify(int arr[], int n, int i)
{
    int largest=i;
    int l=2*i+1;
    int r=2*i+2;

  if(l<n && arr[l]<arr[largest])
	largest = l;

  if(r<n && arr[r]<arr[largest])
	largest = r;

  if(largest!=i){
       int swap=arr[i];
	arr[i]= arr[largest];
	arr[largest]=swap;
	heapify(arr,n,largest);
    }
}
*/
public static void main(String[] args)
{
  
  Heapsort h= new Heapsort();
  int[] Arr= new int[]{6,3,4,5,2,7};
  h.sort(Arr);
    System.out.println("Array is:");
    System.out.println("{");
  for(int i=0;i<6;i++)
  System.out.println(+Arr[i]);
     System.out.println("{");
}
}






//Binary search Tree

import java.util.Scanner;  
class Node
{
  int key;
  Node left,right;
   Node (int data)
   {
     key=data;
     left=right=null;
    }
  }
class BST
{
  Node root;
   BST()
  {
    root=null;
   }
  void insert(int key)
   {
    root=insert_recursive(root,key);
   }
    Node insert_recursive (Node root,int key)
    {
     if (root==null)
     {
       root= new Node(key);
       return root;
     }
     if ( key < root.key)
        root.left =insert_recursive(root.left,key);
     else if ( key > root.key)
             root.right=insert_recursive(root.right,key);
     return root;
    }
    void inorder()
     {
        inorder_traversal(root);
     }
     void inorder_traversal(Node root)
     {
       if (root !=null)
       {
        inorder_traversal(root.left);
        System.out.println(root.key+"  ");
        inorder_traversal(root.right);
        }
      }
       
  int minvalue(Node root)
  {
    int minval=root.key;
    while(root.left!=null)
    {
      minval=root.left.key;
      root=root.left;
      }
        return minval;
        }
   int maxvalue(Node root)
  {
    int maxval=root.key;
    while(root.right!=null)
    {
      maxval=root.right.key;
      root=root.right;
      }
        return maxval;
        }
   boolean search(int key)
   {
     root =search_recursive(root,key);
     if (root!=null)
        return true;
     else 
        return  false;
   }
     Node search_recursive(Node root,int key)
     {
       if(  root==null || root.key==key)
           return root;
       if (root.key>key)
           return search_recursive(root.left,key);
       else 
           return search_recursive(root.right,key);
     }
     
     public void deletekey(int key) 
     {
        root = delete_recursive(root, key);
     }  
    
     Node delete_recursive(Node root, int key)
     {
         Node temp=root;
        if (temp==null)
           return temp;
    
    if (key<temp.key)
           temp.left=delete_recursive(temp.left,key);
        else if (key>temp.key)
              temp.right=delete_recursive(temp.right,key);
        else
        {
          if (temp.left==null)
             return temp.right;
          else if (temp.right==null)
          
              return temp.left;
                            
              temp.key=minvalue(temp.right);
              temp.right=delete_recursive(temp.right,temp.key);
        }
         return temp;
     }
             
             
               
              
              
                 
                                               
              
              
              
                           
              
              
  public static void main (String []args)
  {
    BST b=new BST();
   /* Scanner sc=new Scanner(System.in);
    System.out.println("Enter the elements:");
    int a=sc.nextInt();
    b.insert(a);
    System.out.println("Display:");
    b.inorder();
    }
    }*/
 
     b.insert(35);
     b.insert(40);
     b.insert(10);
     b.insert(60);
     b.insert(20);
     b.insert(50);
     b.insert(15);
     System.out.println("Display:");
     b.inorder();
     
    b.minvalue(b.root);
    System.out.println("Minimum element is:"+b.minvalue(b.root));
    b.maxvalue(b.root);
    System.out.println("Maximum element is:"+b.maxvalue(b.root));
    boolean  y=b.search(20);
    System.out.println("Elements is found:  " +y);
    b.deletekey(40);
    System.out.println("Display:");
    b.inorder();
    
        
    }
   
   
   }
  



// Breadth First Search


import java.io.*;
import java.util.*;

class Graph
{
    private int V;                              //number of vertices in the graph
    private LinkedList<Integer> adj[];              //adjacency list
    private Queue<Integer> queue;                   //maintaining a queue
 
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
        {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }
 
    void addEdge(int v,int w)
    {
        adj[v].add(w);                          //adding an edge to the adjacency list (edges are bidirectional in this example)//
    }
 
    void BFS(int n)
    {

        boolean nodes[] = new boolean[V];       //initialize boolean array for holding the vertices
        int a = 0;
 
        nodes[n]=true;                  
        queue.add(n);                   //root node is added to the rear of the queue
 
        while (queue.size() != 0)
        {
            n = queue.poll();             //remove the front element of the queue
            System.out.print(n+" ");           //print the front element of the queue
 
            for (int i = 0; i < adj[n].size(); i++)  //iterate through the linked list and push all neighbors into queue
            {
                a = adj[n].get(i);
                if (!nodes[a])                    //only insert nodes into queue if they have not been explored already
                {
                    nodes[a] = true;
                    queue.add(a);
                }
            }  
        }
    }

    public static void main(String args[])
    {
        Graph graph = new Graph(6);
 
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
 
        System.out.println("The Breadth First Traversal of the graph is as follows :");
 
        graph.BFS(0);
    }
}



//Depth first search
import java.io.*;
import java.util.*;
 

class Graph {
    private int V;                              //number of nodes
 
    private LinkedList<Integer> adj[];              //adjacency list
 
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
	{
          adj[i] = new LinkedList();
    	}
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);                              //adding an edge to the adjacency list (edges are bidirectional in this example)
    }
 
    void DFSUtil(int vertex, boolean nodes[])
    {
        nodes[vertex] = true;                         //mark the node as explored
        System.out.print(vertex + " ");
        int a = 0;
 
        for (int i = 0; i < adj[vertex].size(); i++)  //iterate through the linked list and then propagate to the next few nodes
            {
                a = adj[vertex].get(i);
                if (!nodes[a])                    //only propagate to next nodes which haven't been explored
                {
                    DFSUtil(a, nodes);
                }
            }  
    }

    void DFS(int v)
    {
        boolean already[] = new boolean[V];             //initialize a new boolean array to store the details of explored nodes
        DFSUtil(v, already);
    }
 
    public static void main(String args[])
    {
        Graph g = new Graph(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
 
        System.out.println("Following is Depth First Traversal: ");
 
        g.DFS(0);
    }
}


// Prim


import java.util.Arrays;
class PGraph {
  public void Prim(int G[][], int V) {
    int INF = 9999999;
    int no_edge; // number of edge
    // create a array to track selected vertex
    // selected will become true otherwise false
    boolean[] selected = new boolean[V];

    // set selected false initially
    Arrays.fill(selected, false);

    // set number of edge to 0
    no_edge = 0;

    // the number of egde in minimum spanning tree will be
    // always less than (V -1), where V is number of vertices in
    // graph

    // choose 0th vertex and make it true
    selected[0] = true;

    // print for edge and weight
    System.out.println("Edge : Weight");

    while (no_edge < V - 1) {
     

      int min = INF;
      int x = 0; // row number
      int y = 0; // col number

      for (int i = 0; i < V; i++) {
        if (selected[i] == true) {
          for (int j = 0; j < V; j++) {
            // not in selected and there is an edge
            if (!selected[j] && G[i][j] != 0) {
              if (min > G[i][j]) {
                min = G[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      System.out.println(x + " - " + y + " :  " + G[x][y]);
      selected[y] = true;
      no_edge++;
    }
  }

 public static void main(String[] args) {
    PGraph g = new PGraph();
    // number of vertices in grapj
    int V = 5;
    // create a 2d array of size 5x5
    // for adjacency matrix to represent graph
    int[][] G = { { 0, 9, 75, 0, 0 }, 
	{ 9, 0, 95, 19, 42 }, 
	{ 75, 95, 0, 51, 66 }, 
	{ 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };
    g.Prim(G, V);
  }
}


//Kruskal
class K
 {
    static int v = 5;
    static int[] parent = new int[v];
    static int INF = Integer.MAX_VALUE;

    static int find(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    static void kruskal(int[][] cost) {
        int minCost = 0;
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        int edgeCount = 0;
        while (edgeCount < v - 1) {
            int min = INF;
            int a = -1, b = -1;
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if (a != -1 && b != -1) {
                System.out.println("Edge " + a + " - " + b + " : Cost = " + min);
                union(a, b);
                minCost += min;
                edgeCount++;
            } else {
                break;
            }
        }
        System.out.println("Minimum Cost of the Spanning Tree: " + minCost);
        
    }

    public static void main(String[] args) {
        int[][] cost = {
            {INF, 2, INF, 6, INF},
            {2, INF, 3, 8, 5},
            {INF, 3, INF, INF, 7},
            {6, 8, INF, INF, 9},
            {INF, 5, 7, 9, INF}
        };
        kruskal(cost);
    }
}

//Priority queue

import java.util.*;
class PQ
{
   static int[]H=new int[50];
   static int size=-1;
 
static int parent(int i)
{
   return(i-1)/2;
}

static int leftChild(int i)
{
   return((2*i)+1);
}

static int rightChild(int i)
{
   return((2*i)+2);
}

static void shiftUp(int i)
{ 
  while(i>0 && H[parent(i)]<H[i])
  {
   swap(parent(i),i);
   i=parent(i);
  }
}


static void shiftDown(int i)
{
   int maxIndex=i;
   int l=leftChild(i);
   if(l<=size && H[l]>H[maxIndex])
   {
      maxIndex=l;
   }
  int r=rightChild(i);
  if(r<=size && H[r]> H[maxIndex])
  {
     maxIndex=r;
  }
 
  if(i!=maxIndex)
  {
    swap(i,maxIndex);
    shiftDown(maxIndex);
  }
}
  

static void insert(int p)
{
  size=size+1;
  H[size]= p;
  shiftUp(size);
}

static int extractMax()
{
  int result=H[0];
  H[0]=H[size];
  size=size-1;
  shiftDown(0);
  return result;
}

static void ChangePriority(int i, int p)
{
  int oldp=H[i];
   H[i]=p;
   if(p>oldp)
   {
      shiftUp(i);
   }
   else
   {
      shiftDown(i);
    }
}

static int getMax()
{
  return H[0];
}

static void remove(int i)
{
   H[i]= getMax()+i;
   shiftUp(i);
   extractMax();
}

static void swap(int i, int j)
{
  int temp=H[i];
  H[i]=H[j];
  H[j]=temp;
}

public static void main(String[] args)
{

  insert(45);
  insert(20);
  insert(14);
  insert(12);
  insert(31);
  insert(7);
  insert(11);
  insert(13);
  insert(7);
 int i=0;
  

System.out.print("Priority Queue:");
while(i<=size)
{
  System.out.println(H[i]+"  ");
  i++;
}
System.out.print("\n");

System.out.print("Node With maximum priority:"+extractMax()+"\n");


System.out.print("Priority queue after extracting Maximum:");
int j=0;
while(j<=size)
{
  System.out.print(H[j]+"  ");
  j++;
}
 
System.out.print("\n");
ChangePriority(2,49);
System.out.print("Priority queue after"+"Priority Change:");

int k=0;
while(k<=size)
{
  System.out.println("\n");
  remove(3);
  
System.out.print("Priority queue after"+"removing the element:");
int l=0;
while(l<=size)
{
  System.out.print(H[l]+ " ");
  l++;
}
}
}}


//Binary Tree

import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class BT{
    Node root;
    BT()
    {
        System.out.println("Please enter your binary tree elements to store elements:");
        Scanner sc=new Scanner(System.in);
        root=createtree(sc);
    }
    Node createtree(Scanner sc){
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        Node n=new Node(data);
        n.left=createtree(sc);
        n.right=createtree(sc);
        return n;

    }
    void display()
    {   

        inorder_traversal(root);
    }
    void inorder_traversal(Node root){
        if(root!=null)
        {
            return;
        }
          inorder_traversal(root.left);
            System.out.println(root.data);
            inorder_traversal(root.right);
          }
   public int countNodes()
   {
     return countNodes(root);
    }
      public  static int  countNodes (Node node)
       {
         if (node==null)
           return 0;
           else 
              {
                int count=1;
                count +=countNodes(node.left);
                count +=countNodes(node.right);
                return count;
}
}
public static int countLeaf(Node node)
{
 if (node == null)
  {
    return 0;
    }
    if (node.left==null && node.right==null)
     return 1;
      else 
           return countLeaf(node.left)+ countLeaf(node.right);
        }
static void LeafNodes(Node node)
{
  if (node==null)
       return;
  if (node.left==null  && node.right==null)
   {
    System.out.println(node.data+" ");
      return;
   }
    if (node.left!=null)
    LeafNodes(node.left);
    if (node.right!=null)
    LeafNodes(node.right);
}
int maxDepth(Node  node)
{
  if (node==null)
   return 0;
 else 
     {
       int lDepth=maxDepth(node.left);
       int rDepth=maxDepth(node.right);   
       
    if (lDepth>rDepth)
        return (lDepth+1);
     else 
             return  (rDepth+1);
}
}
public static void main(String   [] args) 
{
        BT b=new BT();
        b.display();
        int  leafNodes=countLeaf(b.root);
        System.out.println("Total no of leaf nodes are:"+ leafNodes);
        System.out.println("Leaf Nodes are:");
        b.LeafNodes(b.root);
        System.out.println("Total nodes are:"+ b.countNodes());
        System.out.println("Total height of tree is:"+b.maxDepth(b.root));
     }
}



