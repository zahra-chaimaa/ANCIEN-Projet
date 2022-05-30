/**
 * Test1.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 28/11/2006
 */
package jcolibri.test.test1;


/**
 * Travel Recommender example for the jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 25/07/2006
 */

import java.awt.Dimension;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;

import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.NNretrieval.similarity.local.similaritry.Euclidienne;
import jcolibri.method.retrieve.NNretrieval.similarity.local.similaritry.JaroWinkler;
import jcolibri.method.retrieve.NNretrieval.similarity.local.similaritry.MetricLCS;
import jcolibri.method.retrieve.selection.SelectCases;
import jcolibri.test.test1.db.HSQLDBserver1;
import jcolibri.test.test1.userInterface.*;



/**
 * Implementes the recommender main class
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */

public class Test2 implements StandardCBRApplication {
public static Test2 recommender;
	private static Test2 _instance = null;
	public  static Test2 getInstance()
	{
		if(_instance == null)
		   _instance = new Test2();
		return _instance;
	}
	
	public Test2()
	{
	}
	HSQLDBserver1 con = new HSQLDBserver1();
	/** Connector object */
	Connector _connector;
	/** CaseBase object */
	CBRCaseBase _caseBase;
	
	//SimilarityDialog similarityDialog;
	Resultat_Requete1 resultDialog;
	Retenir_Query1 retainDialog;
	
	ResultSet rs;
	Statement stm;
	
	
	public void configure() throws ExecutionException {
		try {
			
			//Emulate data base server
			jcolibri.test.test1.db.HSQLDBserver1.init();
			
			// Create a data base connector
			_connector = new DataBaseConnector();
			
			// Init the ddbb connector with the config file
			_connector.initFromXMLfile(jcolibri.util.FileIO.findFile("jcolibri/test/test1/databaseconfig.xml"));
			// Create a Lineal case base for in-memory organization
			
			_caseBase = new LinealCaseBase();
			
			

			// Create the dialogs
			//similarityDialog = new SimilarityDialog(main);
				
		resultDialog     = new Resultat_Requete1(main);
			retainDialog     = new Retenir_Query1(main);
			
		} catch (Exception e) {
			throw new ExecutionException(e);
		}
	}
	
	public CBRCaseBase preCycle() throws ExecutionException {
		// Load cases from connector into the case base
		_caseBase.init(_connector);		
		// Print the cases
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for(CBRCase c: cases)
		{
			
			System.out.println(c);
		}
		return _caseBase;
	}

	public void cycle(CBRQuery query, int k) throws ExecutionException {
		// Obtain configuration for KNN

		//similarityDialog.setVisible(true);
		//fonction de similarite globale knn
		NNConfig config = new NNConfig();
		Attribute attribute;
		//SimilConfigPanel similConfig;
		LocalSimilarityFunction function;
		//similConfig = sympthome apres 48h;
		attribute = new Attribute("sa",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//fonction de similarite local
		attribute = new Attribute("t",CasenosoDescription.class);
		config.addMapping(attribute, new Euclidienne());
	
		attribute = new Attribute("ht",CasenosoDescription.class);
		config.addMapping(attribute, new Equal() );
		
		attribute = new Attribute("aus",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT14");
		attribute = new Attribute("des",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT9");
		attribute = new Attribute("kt",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT22");
		attribute = new Attribute("abl",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT23");
		attribute = new Attribute("infkt",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config. setWeight(attribute,0.1);
		attribute = new Attribute("sec",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT10");
		attribute = new Attribute("msec",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT11");
		attribute = new Attribute("tou",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT12");
		attribute = new Attribute("dys",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT13");
		//JOptionPane.showConfirmDialog(null, "DEBUT15");
		attribute = new Attribute("su",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT16");
		attribute = new Attribute("pyu",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT17");
		attribute = new Attribute("brm",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT18");
		attribute = new Attribute("dsp",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT19");
		attribute = new Attribute("lu",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT20");
		attribute = new Attribute("fr",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		//config.setWeight(attribute,0.1);
		//JOptionPane.showConfirmDialog(null, "DEBUT21");
		attribute = new Attribute("gb",CasenosoDescription.class);
		config.addMapping(attribute, new Euclidienne());
		//config.setWeight(attribute, 0.1);
		//JOptionPane.showConfirmDialog(null, "FIN5");
		//JOptionPane.showConfirmDialog(null, "DEBUT6");
		attribute = new Attribute("crp",CasenosoDescription.class);
		config.addMapping(attribute, new Euclidienne());
		//JOptionPane.showConfirmDialog(null, "FIN6");
		//config.setWeight(attribute,0.1);
		//config.setWeight(attribute, similConfig.getWeight());
		//JOptionPane.showConfirmDialog(null, "DEBUT7");
		attribute = new Attribute("pct",CasenosoDescription.class);
		config.addMapping(attribute, new Euclidienne());
		config.setWeight(attribute, 1.0);
		//JOptionPane.showConfirmDialog(null, "DEBUT8");
		attribute = new Attribute("rx",CasenosoDescription.class);
		config.addMapping(attribute, new Equal());
		config.setWeight(attribute,0.1);
	
		config.setDescriptionSimFunction(new Average());
		// Execute NN
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, config);
		System.out.println(eval);
		
		
		// Select k cases
		Collection<CBRCase> selectedcases = SelectCases.selectTopK(eval, k);
		
		
		
		// Show result
		resultDialog.showCases(eval, selectedcases);
		
	
		
		resultDialog.setVisible(true);
		
		
		
		// Retain
	
		
		retainDialog.showCases(selectedcases, _caseBase.getCases().size());
		
		retainDialog.showCase();
		retainDialog.setVisible(true);
		
	
		
		
		
		/*Collection<CBRCase> casesToRetain = retainDialog.getCasestoRetain();
		_caseBase.learnCases(casesToRetain);*/
		
	}

	public void postCycle() throws ExecutionException {
		PrintWriter fluxSortie = null;
		String requete;
		try {
			
			stm = con.obtenirconnexion().createStatement();
			rs = stm.executeQuery("select * from basecase");
		
				try
				{
				fluxSortie =new PrintWriter(new FileOutputStream("src/jcolibri/test/test1/db/basecase.csv"));
				
				}
				catch(FileNotFoundException e) 
				{ System.out.println("Erreur d�ouverture fichier.txt.");
				System.exit(0);
				}
				
			
				while(rs.next()){
					
					requete =rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"
						+ ""+rs.getString(6)+";"+rs.getString(7)+";"+rs.getString(8)+";"+rs.getString(9)+";"+rs.getString(10)+";"+rs.getString(11)+";"
						+ ""+rs.getString(12)+";"+rs.getString(13)+";"+rs.getString(14)+";"+rs.getString(15)+";"+rs.getString(16)+";"+rs.getString(17)+";"+rs.getString(18)+";"+rs.getString(19)+";"
						+ ""+rs.getString(20)+";"+rs.getString(21)+";"+rs.getString(22)+";"+rs.getString(23)+";"+rs.getString(24)+";"+rs.getString(25)+";"+rs.getString(26)+";"+rs.getString(27)+";"+rs.getString(28)+";"+rs.getString(29)+";"
								+ ""+rs.getString(30)+";"+rs.getString(31)+";"+rs.getString(32);
					
			
				fluxSortie.println(requete);
				
				
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}fluxSortie.close( );
		_connector.close();
		
		jcolibri.test.test1.db.HSQLDBserver1.shutDown();
	}

static JFrame main;
	
	public void showMainFrame()
	{
		main = new login();
	main.setResizable(false);
	main.setBounds(100,50,645,500);
	main.setTitle("Authentification");
	
	main.setVisible(true);
		
	/*	main = new JFrame("Hacini_Iratni");
		main.setResizable(false);
		main.setUndecorated(false);
		
		JPanel p =new JPanel();
		p.setLayout(null);
		JLabel label = new JLabel(new ImageIcon(jcolibri.util.FileIO.findFile("/jcolibri/test/test1/IDP.jpg")));
		
		
		p.add(label);
		main.getContentPane().add(label);
		main.pack();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		main.setVisible(true);*/
	}
	public void bou()
	{
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		main.setBounds((screenSize.width - main.getWidth()) / 2,
				(screenSize.height - main.getHeight()) / 2, 
			main.getWidth(),
				main.getHeight());
	}
	
	public static void main(String[] args) {
	
		 recommender = getInstance();
		recommender.showMainFrame();
	
		//recommender.bou();
/*
		try
		{
			recommender.configure();
			recommender.preCycle();
			Requete_Dialog1 qf = new Requete_Dialog1(null);
		
			boolean cont=true;
			while(cont)
			{
				
				qf.setVisible(true);
				
				
				CBRQuery query = qf.getQuery();
				
			
				System.out.println(query.getDescription());
			
				
				
				recommender.cycle(query,qf.getK());
				
				
		
				int ans = javax.swing.JOptionPane.showConfirmDialog(null, "Le cycle Pour ce cas est fini\n Voulez-vous le r�p�ter?", "Cycle termin�", javax.swing.JOptionPane.YES_NO_OPTION);
			
				cont = (ans == javax.swing.JOptionPane.YES_OPTION);
				
			}
			
			recommender.postCycle();
			
			
		}catch(Exception e)
		{
			
			org.apache.commons.logging.LogFactory.getLog(Test2.class).error(e);
		
			javax.swing.JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
		}
		System.exit(0);*/
		
	}
}
