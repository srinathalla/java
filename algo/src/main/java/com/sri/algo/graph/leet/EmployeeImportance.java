package com.sri.algo.graph.leet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImportance {
	
	
	
	static class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	}
	

	class Solution {
	    
	    private int imp = 0;
	    public int getImportance(List<Employee> employees, int id) {
	        
	        Map<Integer,Employee> employeeMap = 
	            employees.stream().collect(Collectors.toMap(
	            		e -> e.id, 
	            		e -> e));
	        
	     importance(id, employeeMap);
	        
	       return  imp;
	    }
	    
	    public void importance(int id, Map<Integer,Employee> employeeMap)
	    {
	        Employee e = employeeMap.get(id);
	        this.imp += e.importance;
	        
	        for(int sid: e.subordinates)
	        {
	            importance(sid, employeeMap);
	        }
	    }
	}

}
