package com.sri.algo.array.leet.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	
	
	  public List<String> addOperators(String num, int target) 
	  {
		  
		  var res = new ArrayList<String>();
		  if(num == null || num.length() == 0)
			  return res;
		  
		  helper(res, "",num,target,0,0,0);
		  
		  return res;
	  }
	  
	  
	  void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed)
	  {
		  if(pos == num.length())
		  {
			  if(target == eval)
				  res.add(path);
			  return;
		  }
		  
		  for(int i=pos; i < num.length(); i++)
		  {
			  if(i != pos && num.charAt(pos) == '0')
				  break;
			  
			  long curr = Long.parseLong(num.substring(pos, i +1));
			  
			  if(pos == 0)
			  {
				  helper(res, path + curr, num,target, i + 1,curr,curr);
			  }
			  else
			  {
				  helper(res, path + '+' + curr, num,target, i + 1,eval + curr,curr);
				  
				  helper(res, path + '-' + curr, num,target, i + 1,eval - curr,-curr);
				  
				  helper(res, path + '*' + curr, num,target, i + 1,eval - multed + multed * curr,multed * curr);
			  }
		  }
	  }

}
