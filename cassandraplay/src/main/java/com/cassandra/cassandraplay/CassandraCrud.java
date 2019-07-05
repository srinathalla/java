package com.cassandra.cassandraplay;

import com.datastax.driver.core.Session;

public class CassandraCrud {
	
	private static final String TABLE_NAME = "books";
	private Session session;
	private static final String KEY_SPACE = "tp";
	
	public void createTable() {
	    StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
	      .append(TABLE_NAME).append("(")
	      .append("id uuid PRIMARY KEY, ")
	      .append("title text,")
	      .append("subject text);");
	 
	    String query = sb.toString();
	    session.execute(query);
	}
	
	public void insertRows() {
	   
	    session.execute("INSERT INTO books (id, title, subject) VALUES(now(),'ABC', 'Written by Sri');");
	    session.execute("INSERT INTO books (id, title, subject) VALUES(now(),'DEF', 'Written by Sri');");
	    session.execute("INSERT INTO books (id, title, subject) VALUES(now(),'Sai', 'Written by Sri');");
	    System.out.println("rows created"); 
	    
		}
	
	public void createKeySpace()
	{
		//Query
	      String query = "CREATE KEYSPACE IF NOT EXISTS " + KEY_SPACE + " WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};";
	                    
	      //Executing the query
	      session.execute(query);
	    
	      System.out.println("Keyspace created"); 
	}
	
	public void dropKeySpace()
	{
		//Query
	      String query = "DROP KEYSPACE " + KEY_SPACE + ";";
	                    
	      //Executing the query
	      session.execute(query);
	     
	      System.out.println("Keyspace dropped"); 
	}

}
