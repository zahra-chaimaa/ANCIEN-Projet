package jcolibri.test.test1.db;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.egothor.stemmer.Row;
import org.hsqldb.Server;

/**
 * Creates a data base server with the tables for the examples/tests using the HSQLDB library.
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class HSQLDBserver1
{
    static boolean initialized = false;
    static Connection conn;
    private static Server server;
    static Row row;
    static Statement stm;
    static ArrayList<String> values = new ArrayList<String>();
    public HSQLDBserver1(){
    	try
    	{
    		server = new Server();
    		server.setDatabaseName(0, "hopital");
    		server.setDatabasePath(0, "hopital;sql.enforce_strict_size=true");
    		

    		
    		server.setLogWriter(null);
    		server.setErrWriter(null);
    		server.setSilent(true);
    		server.start();


    		initialized = true;
    	    Class.forName("org.hsqldb.jdbcDriver");

    	   // System.out.println("Debut de connexion......1");
    	     conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hopital", "sa", "");
    	    // System.out.println("Fin de connexion......1");
    	     
    	   
    	   
    	     stm = conn.createStatement();
    	     
    	    //System.out.println("Debut suppression de la table : bc");
 		 VerifExisteTable("basecase");
 		   // System.out.println("fin suppression de la table : bc");
    	     
    		    String req;	
    		    req ="CREATE TABLE  basecase (id int,nip varchar(50),j varchar(50),sa varchar(50),t double,ht varchar(50),aus varchar(50),des varchar(50),kt varchar(50),abl varchar(50),infkt varchar(50),sec varchar(50),msec varchar(50),tou varchar(50),dys varchar(50),su varchar(50),pyu varchar(50),brm varchar(50),dsp varchar(50),fr varchar(50),lu varchar(50),gb double,crp double,pct double,rx varchar(50),p Integer,u Integer,b Integer,skt Integer,autr Integer,pas Integer,conf Integer,PRIMARY KEY (id))";
    			//System.out.println("requete : "+req);	
    		    stm.executeQuery(req);
    		  //  System.out.println("FIN REQUETE BASECASE---");	
    		    
    		    
    		   // System.out.println("Debut suppression de la table : rq");
    		VerifExisteTable("requete");
    		   // System.out.println("fin suppression de la table : rq");
    		    
    		   // System.out.println("debut requette................");
    		
    		   stm.executeQuery("create table requete (nip varchar(50),j varchar(50),sa varchar(50),t double,ht varchar(30),aus varchar(20),des varchar(30),kt varchar(30),abl varchar(30),infkt varchar(30),sec varchar(30),msec varchar(30),tou varchar(30),dys varchar(30),su varchar(30),pyu varchar(30),brm varchar(30),dsp varchar(30),fr varchar(30),lu varchar(30),gb double,crp double,pct double,rx varchar(30))");
    		   // System.out.println("fin req.......");
    		    
    		   // System.out.println("Debut suppression de la table : sl");
    		   VerifExisteTable("solution");
    		    //System.out.println("fin suppression de la table : sl");
    		    
    		    stm.executeQuery("create table solution (p Integer,u Integer,b Integer,skt Integer,autr Integer,pas Integer,conf Integer)");
    		  //  System.out.println("FIN sol.......");
    		    		
    	    
    	     Scanner fluxEntree = null;
    	     Scanner fluxsor = null;
    		    try
    			 { fluxEntree =
    			 new Scanner(new FileInputStream("src/jcolibri/test/test1/db/basecase.csv"));
    			  }
    			 catch(FileNotFoundException e)
    			 { System.out.println("Erreur ouverture fichier.");
    			 System.exit(0); }
    		    String ligne = null; 
    		  
    		    while (fluxEntree.hasNextLine())
    			 { 
    		    	
    		    	
    		    	ligne = fluxEntree.nextLine();
    		    	
    			    String[] values = ligne.split(";");
    			    
    			    
    			    String sql1 =("Insert into basecase values ('"+values[0]+"','"+values[1]+"','"+values[2]+"','"+values[3]+"',"+values[4]+",'"+values[5]+"','"+values[6]+"','"+values[7]+"','"+values[8]+"','"+values[9]+"','"+values[10]+"','"+values[11]+"','"+values[12]+"','"+values[13]+"','"+values[14]+"',"
    		         		+ "'"+values[15]+"','"+values[16]+"','"+values[17]+"','"+values[18]+"','"+values[19]+"','"+values[20]+"',"+values[21]+","+values[22]+","+values[23]+",'"+values[24]+"',"+values[25]+","
    		         		+ ""+values[26]+","+values[27]+","+values[28]+","+values[29]+","+values[30]+","+values[31]+");");
    			 System.out.println("sql1 : "+sql1);
    			 int i =  stm.executeUpdate(sql1);
    		            	
    			 }
    		    
    		    //System.out.println("999999999999999999999999999999999999");
    		    try
    			 { fluxsor =
    			 new Scanner(new FileInputStream("src/jcolibri/test/test1/db/casTemporaire.csv"));
    			  }
    			 catch(FileNotFoundException e)
    			 { 
    				 System.out.println("Erreur ouverture fichier.");
    			 System.exit(0); 
    			 }
    		    String input = null; 
    		    
    		    while (fluxsor.hasNextLine())
    			 {
    		    	input = fluxsor.nextLine( );
    		    	
    			 String[] val = input.split(";");
    			 for(int i=0;i<val.length;i++)
    				 System.out.println("val"+i+" = "+val[i]);
    			 
    		         /*/String sql =("Insert into temp values ('"+val[0]+"','"+val[1]+"','"+val[2]+"','"+val[3]+"','"+val[4]+"','"+val[5]+"','"+val[6]+"','"+val[7]+"','"+val[8]+"','"+val[9]+"','"+val[10]+"','"+val[11]+"','"+val[12]+"','"+val[13]+"','"+val[14]+"',"
    		         		+ "'"+val[15]+"','"+val[16]+"','"+val[17]+"','"+val[18]+"','"+val[19]+"','"+val[20]+"','"+val[21]+"','"+val[22]+"','"+val[23]+"','"+val[24]+"','"+val[25]+"',"
    		         		+ "'"+val[26]+"','"+val[27]+"','"+val[28]+"','"+val[29]+"','"+val[30]+"','"+val[31]+"','"+val[32]+"','"+val[33]+"','"+val[34]+"');");
    		        int i =  stm.executeUpdate(sql);*/
    		       
    		            	}
    		    
    		    fluxsor.close();
    		    fluxEntree.close( );
	   
    	    org.apache.commons.logging.LogFactory.getLog(HSQLDBserver1.class).info("Data base generation finished");
    	       
    	} catch (Exception e)
    	{
    	    org.apache.commons.logging.LogFactory.getLog(HSQLDBserver1.class).error(e);
    	}
    	//System.out.println("00000000000000000000000000");
        
    }
    
    /**
     * Initialize the server
     */
    public static void init()
    {
	if (initialized)
	    return;
        org.apache.commons.logging.LogFactory.getLog(HSQLDBserver1.class).info("Creating data base ...");
//System.out.println("1111111111111111111111111111111");
	server = new Server();
	server.setDatabaseName(0, "hopital");
	server.setDatabasePath(0, "hopital;sql.enforce_strict_size=true");
	
	//System.out.println("2222222222222222222222");
	
	server.setLogWriter(null);
	server.setErrWriter(null);
	server.setSilent(true);
	server.start();

	//System.out.println("33333333333333333333333333333333333");
	initialized = true;
	try
	{
		//System.out.println("44444444  444444444  44444444  444444444");
	    Class.forName("org.hsqldb.jdbcDriver");

	  //System.out.println("DEBUT CONNEXION BDD HOPITAL");
	     conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hopital", "sa", "");
	    // System.out.println("FIN CONNEXION BDD HOPITAL");
	    stm = conn.createStatement();
	   // System.out.println("55555  555555  55555  555");
	    
	    
	
	    
	   // System.out.println("Debut suppression de la table : basecase");
	 VerifExisteTable("basecase");
	  //  System.out.println("fin suppression de la table : basecase");
	    
	    
	    String req;	
	    req ="CREATE TABLE  basecase (id int,nip varchar(50),j varchar(50),sa varchar(50),t double,ht varchar(50),aus varchar(50),des varchar(50),kt varchar(50),abl varchar(50),infkt varchar(50),sec varchar(50),msec varchar(50),tou varchar(50),dys varchar(50),su varchar(50),pyu varchar(50),brm varchar(50),dsp varchar(50),fr varchar(50),lu varchar(50),gb double,crp double,pct double,rx varchar(50),p Integer,u Integer,b Integer,skt Integer,autr Integer,pas Integer,conf Integer,PRIMARY KEY (id))";
		//System.out.println("requete : "+req);	
	   stm.executeQuery(req);
	 
	    
	    
	   // System.out.println("Debut suppression de la table : rq");
	 VerifExisteTable("requete");
	  //  System.out.println("fin suppression de la table : rq");
	    
	  //  System.out.println("debut requette................");
	    stm.executeQuery("create table requete (nip varchar(50),j varchar(50),sa varchar(50),t double,ht varchar(30),aus varchar(20),des varchar(30),kt varchar(30),abl varchar(30),infkt varchar(30),sec varchar(30),msec varchar(30),tou varchar(30),dys varchar(30),su varchar(30),pyu varchar(30),brm varchar(30),dsp varchar(30),fr varchar(30),lu varchar(30),gb double,crp double,pct double,rx varchar(30))");
	   // System.out.println("fin req.......");
	    
	   // System.out.println("Debut suppression de la table : sl");
	  VerifExisteTable("solution");
	    //System.out.println("fin suppression de la table : sl");
	    
	    stm.executeQuery("create table solution (p Integer,u Integer,b Integer,skt Integer,autr Integer,pas Integer,conf Integer)");
	   // System.out.println("FIN sol.......");
	    		
	    Scanner fluxEntree = null;
	    Scanner fluxsor = null;
	   
	    try
		 { fluxEntree =
		 new Scanner(new FileInputStream("src/jcolibri/test/test1/db/basecase.csv"));
		  }
		 catch(FileNotFoundException e)
		 { System.out.println("Erreur ouverture fichier.");
		 System.exit(0); }
	    String ligne = null; 
	    while (fluxEntree.hasNextLine())
		 { ligne = fluxEntree.nextLine( );
		 String[] values = ligne.split(";");
		 
		// System.out.println("taille du tableau est : "+values.length);
		 
		 String sql1 =("Insert into basecase values ('"+values[0]+"','"+values[1]+"','"+values[2]+"','"+values[3]+"','"+values[4]+"','"+values[5]+"','"+values[6]+"','"+values[7]+"','"+values[8]+"','"+values[9]+"','"+values[10]+"','"+values[11]+"','"+values[12]+"','"+values[13]+"','"+values[14]+"',"
	         		+ "'"+values[15]+"','"+values[16]+"','"+values[17]+"','"+values[18]+"','"+values[19]+"','"+values[20]+"','"+values[21]+"','"+values[22]+"','"+values[23]+"','"+values[24]+"','"+values[25]+"',"
	         		+ "'"+values[26]+"','"+values[27]+"','"+values[28]+"','"+values[29]+"','"+values[30]+"','"+values[31]+"');");
		 System.out.println("sql1 : "+sql1);
		 int i =  stm.executeUpdate(sql1);
	            	}
	    
	  
	    try
		 { fluxsor =
		 new Scanner(new FileInputStream("src/jcolibri/test/test1/db/casTemporaire.csv"));
		  }
		 catch(FileNotFoundException e)
		 { System.out.println("Erreur ouverture fichier.");
		 System.exit(0); }
	    String input = null; 
	    
	    while (fluxsor.hasNextLine())
		 { input = fluxsor.nextLine( );
		 String[] val = input.split(";");
		 /* String sql2 =("Insert into casTemporaire values ('"+val[0]+"','"+val[1]+"','"+val[2]+"',"+val[3]+",'"+val[4]+"',"+val[5]+","+val[6]+","+val[7]+",'"+val[8]+"','"+val[9]+"','"+val[10]+"','"+val[11]+"','"+val[12]+"','"+val[13]+"','"+val[14]+"',"
	         		+ "'"+val[15]+"','"+val[16]+"','"+val[17]+"','"+val[18]+"','"+val[19]+"','"+val[20]+"','"+val[21]+"','"+val[22]+"','"+val[23]+"',"+val[24]+","+val[25]+","
	         		+ ""+val[26]+","+val[27]+","+val[28]+","+val[29]+","+val[30]+");");
		 System.out.println("sql2 : "+sql2);
		 int i =  stm.executeUpdate(sql2);*/
		 
	            	}
	    fluxsor.close();
	    fluxEntree.close( );

	    org.apache.commons.logging.LogFactory.getLog(HSQLDBserver1.class).info("Data base generation finished");
	       
	} catch (Exception e)
	{
	    org.apache.commons.logging.LogFactory.getLog(HSQLDBserver1.class).error(e);
	}
	  
    }
    //-------------------------------------------------------------------------------------------------------
    public static void VerifExisteTable(String table)
    {
    	String req = "DROP TABLE "+table; 
    	try {
			            stm.executeQuery(req);
			            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    //-------------------------------------------------------------------------------------------------------
    public Connection obtenirconnexion(){
        return conn;
    }

    /**
     * Shutdown the server
     */
    public static void shutDown()
    {

	if (initialized)
	{
	    server.stop();
	    initialized = false;
	}
    }

    /**
     * Testing method
     */
    public static void main(String[] args)
    {
	HSQLDBserver1.init();
	HSQLDBserver1.shutDown();
	System.exit(0);
	
    }
    
  
}

