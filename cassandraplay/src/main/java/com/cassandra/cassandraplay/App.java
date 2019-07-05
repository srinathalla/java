package com.cassandra.cassandraplay;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */
public class App 
{

	private Session session;
	private  Cluster cluster;
	
	public App()
	{
		//creating Cluster object
	      cluster = Cluster.builder().addContactPoint("127.0.0.1").withPort(9042).build();
	    
	      //Creating Session object
	       this.session = cluster.connect();
	    
	     // this.createKeySpace();
	     // this.session.execute("USE tp");
	}
	
	private App use(String keyspace)
	{
		this.session.execute("USE "+ keyspace);
		
		return this;
	}
	
	private App describeTables(String keyspace)
	{
		ResultSet rs = this.session.execute("describe tables");
		
		for(Row row : rs.all())
		{
			System.out.println(row.getString(0));
		}
		
		return this;
	}
	
	
	public void close() {

		if (session != null) {
			session.close();
			cluster.close();
		}
	}
	
	
	 public static void main(String[] args)
	 {
		 App app = new App();
		 app.use("efi_signal_store").describeTables("efi_signal_store").close();
		
		 // app.dropKeySpace();
	 }
}
