package lru;

import java.util.HashMap;


public class LRUCache {
    class Node{
        int key;
	        int data;
	        Node next;
	        Node prev;
	        
	        public Node(int key,int data,Node prev,Node next){
             this.key=key;
	            this.data=data;
	            this.prev=prev;
	            this.next=next;
	        }
	    }
  HashMap<Integer,Node> map;
	    int capacity;
	    Node head;
	    Node tail;
 public LRUCache(int capacity) {
      this.capacity=capacity;
	        map=new HashMap<Integer,Node>();
	        head=new Node(0,0,null,null);
	        tail=new Node(0,0,null,null);
	        head.next=tail;
	        tail.prev=head;
 }
 
 public int get(int key) {
      int x=-1;
	        Node temp=null;
	        if(map.containsKey(key)){
	            temp=map.get(key);
	            x=temp.data;
	        }
	        else{
	            return -1;
	        }
	        temp.next.prev=temp.prev;
	        temp.prev.next=temp.next;
	        Node newNode=new Node(key,temp.data,head,head.next);
         head.next.prev=newNode;
	        head.next=newNode;
	        map.remove(key);
	        map.put(key,newNode);
	        
	        return x;
 }
 
 public void put(int key, int value) {
      if(map.containsKey(key)){
	            Node temp=map.get(key);
	            map.remove(temp.key);
	            temp.prev.next=temp.next;
             temp.next.prev=temp.prev;
	            Node newNode=new Node(key,value,head,head.next);
             head.next.prev=newNode;
	            head.next=newNode;
	            map.put(key,newNode);
	            
	        }
	        else{
	            if(map.size()==capacity){
	                Node last=tail.prev;
	                map.remove(last.key);
	                last.prev.next=last.next;
                 last.next.prev=last.prev;
	                
	                Node newNode=new Node(key,value,head,head.next);
                 head.next.prev=newNode;
                 head.next=newNode;
	                map.put(key,newNode);
	            }
	            else{
	                if(map.size()==0){
	                    Node newNode=new Node(key,value,head,tail);
                     head.next=newNode;
                     tail.prev=newNode;
	                    map.put(key,newNode);
	                }
	                else{
	                    Node NewNode=new Node(key,value,head,head.next);
                     head.next.prev=NewNode;
	                    head.next=NewNode;
	                    map.put(key,NewNode);
	                }
	            }
	        }
 }
	    public static void main(String[] args) {
	    	LRUCache cache = new LRUCache(2);
	    	cache.put(1, 1);
	    	cache.put(2, 2);
	    	System.out.println(cache.get(1));       // returns 1
	    	cache.put(3, 3);    // evicts key 2
	    	System.out.println(cache.get(2));       // returns -1 (not found)
	    	cache.put(4, 4);    // evicts key 1
	    	System.out.println(cache.get(1));       // returns -1 (not found)
	    	System.out.println(cache.get(3));       // returns 3
	    	System.out.println(cache.get(4));       // returns 4
	    	
	    	   
	    }
	   
	}

	