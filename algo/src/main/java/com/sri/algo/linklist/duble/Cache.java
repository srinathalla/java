package com.sri.algo.linklist.duble;

import java.util.HashMap;
import java.util.Map;

public class Cache {

	    
	    static class DLL
	    {
	        DLLNode head,tail;
	        int max_size;
	        int curr_size =0;
	        DLL(int size)
	        {
	            this.max_size = size;
	        }
	        
	        public boolean capacityReached()
	        {
	            return this.curr_size == max_size;
	        }
	        
	       public DLLNode addLast(int key,int value)
	       {
	            
	            DLLNode node = new DLLNode(key,value);
	          
	           return addLast(node);
	        }
	        
	        public DLLNode addLast(DLLNode node)
	        {
	            curr_size++;
	            if (tail == null)
	            {
	                head = node;
	                tail = node;
	                return node;
	            }
	            
	            tail.next = node;
	            node.prev = tail;
	            tail = tail.next;
	            return node;
	           
	        }
	        
	         public DLLNode removeFirst()
	         {
	             return remove(head);
	         }
	        
	        public DLLNode remove(DLLNode node)
	        {
	            curr_size--;
	            if(node.key == head.key)
	            {
	               head = head.next; 
	               if (head != null)
	               {
	                    head.prev = null;
	               }
	               else
	               {
	            	   tail = null;
	               }
	               return node;
	            }
	            if(node.key == tail.key)
	            {
	               tail = tail.prev; 
	               if(tail != null)
	                {
	                    tail.next = null;
	                }
	               return node;
	            }
	            
	            node.prev.next = node.next;
	            node.next.prev = node.prev;
	            return node;
	        }
	    }
	    static class DLLNode
	    {
	        int key;
	        int value;
	        DLLNode prev,next;
	        
	        DLLNode(int key, int value)
	        {
	            this.key = key;
	            this.value = value;
	        }
	        
	        
	    }
	    
	    private DLL dll;
	    private Map<Integer,DLLNode> map = new HashMap<>();
	    
	     Cache(int capacity) 
	    {    
	         this.dll = new DLL(capacity);    
	    }
	    
	    public int get(int key) 
	    {
	         if(map.containsKey(key))
	         {
	             DLLNode node = map.get(key);
	             this.dll.remove(node);
	             this.dll.addLast(node);
	             
	             return node.value;
	         }
	        
	        return -1;
	    }
	    
	    public void put(int key, int value) 
	    {
	     
	        if(!map.containsKey(key))
	        {
	         
	        	if(this.dll.capacityReached())
	        	{
	        		DLLNode node = this.dll.removeFirst();
	        		map.remove(node.key);
	        	}
	           
	           DLLNode node = this.dll.addLast(key,value); 
	           map.put(key, node);
	           return;
	        }
	        
	        DLLNode node = map.get(key);
	        node.value = value;
	        
	        this.dll.remove(node);
	        this.dll.addLast(node);
	        
	    }
	    
	    public static void main(String[] args) {
			
	    	// [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
	    			
	    	/*Cache cache = new Cache(2);
	    	cache.put(1, 1);
	    	cache.put(2, 2);
	    	System.out.println(cache.get(1));
	    	cache.put(3, 3);
	    	System.out.println(cache.get(2));
	    	cache.put(4, 4);
	    	System.out.println(cache.get(1));
	    	System.out.println(cache.get(3));
	    	System.out.println(cache.get(4));*/
	    	
	    	// [[1],[2,1],[2],[3,2],[2],[3]]
	    	
	    	Cache cache = new Cache(1);
	    
	    	cache.put(2, 1);
	    	System.out.println(cache.get(2));
	    	cache.put(3, 2);
	    	System.out.println(cache.get(2));
	   
	    	System.out.println(cache.get(3));
	    
		}
	

}
