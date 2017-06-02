package com.sri.algo.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CalcCopied {
	
	 public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int n = scanner.nextInt();
		    int[] numbers = new int[n];
		    for (int i = 0; i < numbers.length; i++) {
		      numbers[i] = scanner.nextInt();
		    }

		    String s = "" + numbers[0];
		    Iterator<Operation> iterator = new Recursion(numbers).recurse().iterator();
		    for (int i = 1; i < numbers.length; i++) {
		      s += iterator.next().symbol + numbers[i];
		    }
		    System.out.println(s);
		  }

		  private static class Recursion {
		    private final int[] numbers;
		    private final List<Operation> operations;

		    Recursion(int[] numbers) {
		      this.numbers = numbers;
		      this.operations = new ArrayList<Operation>();
		    }

		    List<Operation> recurse() {
		      recurse(numbers[0], 1);
		      return operations;
		    }

		    private boolean recurse(long resultSoFar, int index) {
		      if (index == numbers.length) {
		        return resultSoFar % 101 == 0;
		      }
		      for (Operation operation: Operation.values()) {
		        operations.add(operation);
		        if (recurse(operation.operateOn(resultSoFar, numbers[index]), index + 1)) {
		          return true;
		        } else {
		          operations.remove(operations.size() - 1);
		        }
		      }
		      return false;
		    }
		  }

		  private enum Operation {
		    ADD("+") {
		      public long operateOn(long n1, long n2) {
		        return n1 + n2;
		      }
		    },
		    SUBTRACT("-") {
		      public long operateOn(long n1, long n2) {
		        return n1 - n2;
		      }
		    },
		    MULTIPLY("*") {
		      public long operateOn(long n1, long n2) {
		        return n1 * n2;
		      }
		    };

		    final String symbol;

		    Operation(String symbol) {
		      this.symbol = symbol;
		    }

		    public abstract long operateOn(long n1, long n2);
		  }

}
