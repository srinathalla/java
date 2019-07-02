package com.sri.algo.math.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesforceDesignTest {protected Map<String, Object> map = new HashMap<>();

private SetCommand setCommand = new SetCommand(map);
private GetCommand getCommand = new GetCommand(map);
private DeleteCommand deleteCommand = new DeleteCommand(map);


public Object executeTask(String command)
{
	Object result = "";
	if (command.startsWith("SET"))
    {
		result =  setCommand.performAction(command);
    }
    else if (command.startsWith("GET"))
    {
    	result = getCommand.performAction(command);
    }
    else if (command.startsWith("DELETE"))
    {
    	result =  deleteCommand.performAction(command);
    }
	
	System.out.println(result);
	return "";
}
 
public  static abstract class Task

{
	
	Map<String, Object> map;
	
	public Task(Map<String, Object> map) {
		super();
		this.map = map;
	}




	abstract Object performAction(String command); 
}
public  static class SetCommand extends Task
{

	public SetCommand(Map<String, Object> map) {
		super(map);
		
	}

	@Override
	Object performAction(String command) {
		
		String[] inputs = command.split(" ");
		
		map.put(inputs[1], inputs[2]);
		
		return "SUCCESS";
	}
	
}

public  class GetCommand extends Task
{

	public GetCommand(Map<String, Object> map) {
		super(map);
	}

	@Override
	Object performAction(String command) {
		
		 String[] inputs = command.split(" ");
			
	    Object val = map.get(inputs[1]);
	  
	    
	    return val;
	}
	
}

public  class DeleteCommand extends Task
{

	public DeleteCommand(Map<String, Object> map) {
		super(map);
	
	}

	@Override
	Object performAction(String command) {
		
        String[] inputs = command.split(" ");
		
		map.remove(inputs[1]);
		
		return "SUCCESS";		
		
	}
	
}



 public static void main(String[] args) {
	 
	 
	 /**
	  * Tested with this sample input.
	  * 6
		SET A 100
		GET A
		SET B 200
		GET B
		DELETE A
		DELETE B
	  
	 
	 
	  * Got this output.
	  * 
	  * SUCCESS
		100
		SUCCESS
		200
		SUCCESS
		SUCCESS
	  */

	    SalesforceDesignTest solution = new SalesforceDesignTest();
	    try(Scanner sc = new Scanner(System.in))
	    {
	        int n = sc.nextInt();
	        for(int t = 0; t < n; t++) {
	            String command = sc.nextLine();
	            while (command.trim().isEmpty())
	            {
	            	command = sc.nextLine();
	            }
	            
	            solution.executeTask(command);            
	        }	
	    }
}

}

