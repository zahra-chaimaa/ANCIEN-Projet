package jcolibri.test.test1.userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import jcolibri.cbrcore.CBRCase;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.test.test1.CasenosoDescription;
import jcolibri.test.test1.CasenosoSolution;
import jcolibri.test.test1.Test1;
import jcolibri.test.test1.Test2;
import jcolibri.test.test1.db.HSQLDBserver1;
import jcolibri.util.FileIO;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerModel;
import javax.swing.JCheckBox;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

public class Resultat_Requete1 extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HSQLDBserver1 con = new HSQLDBserver1();
	Statement stm;
    ResultSet rs,rd;
    CBRCase _case;
	
	/*SpinnerNumberModel agec;
	SpinnerNumberModel poidsc;
	SpinnerNumberModel gsc;
	SpinnerNumberModel ager;
	SpinnerNumberModel poidsr;
	SpinnerNumberModel gsr;
	SpinnerNumberModel Glasgowlieu;
	SpinnerNumberModel Glasgowurg;*/

	public ArrayList<RetrievalResult> cases;
	int currentCase;
	private JLabel lblCasRememors;
	private JButton button;
	private JPanel panel_4;
	private JLabel ider;
	private JPanel panel_1;
	private JLabel lblNombreDeCas;
	private JSpinner nh;
	private JTabbedPane tabbedPane;
	private JPanel panel_2;
	private JLabel lblNip;
	private JTextField nipcas;
	private JLabel lblJour;
	private JTextField jourcas;
	private JLabel lblLesSymptomesApres;
	private JLabel lblHypoTension;
	private JLabel lblTemprature;
	private JTextField tcas;
	private JPanel panel_3;
	private JLabel lblSecretion;
	private JLabel lblModificationScretion;
	private JLabel lblToux;
	private JLabel lblDyspnet;
	private JLabel lblAuscultaion;
	private JLabel lblDsaturation;
	private JLabel lblPrsenceCathters;
	private JLabel lblAblationCathtersh;
	private JLabel lblInfectionLocalSur;
	private JPanel panel_8;
	private JLabel lblSondageUrinaire;
	private JLabel lblPyurie;
	private JLabel lblLeucocyturieUrinaire;
	private JLabel lblBrulureMictionnelle;
	private JLabel lblDouleurSus;
	private JLabel lblFrisson;
	private JPanel panel_9;
	private JLabel lblGb;
	private JTextField gbcas;
	private JLabel CRP;
	private JTextField crpcas;
	private JLabel PCT;
	private JTextField pctcas;
	private JPanel panel_10;
	private JLabel lblRxDuPneumo;
	private JTabbedPane tabbedPane_1;
	private JPanel panel_5;
	private JLabel lblNip_1;
	private JTextField nipreq;
	private JLabel lblJour_1;
	private JTextField jourreq;
	private JLabel lblLesSymptomesApres_1;
	private JLabel lblHypoTension_1;
	private JLabel lblTemprature_1;
	private JTextField treq;
	private JPanel panel_6;
	private JLabel lblSecretion_1;
	private JLabel lblModificationScretion_1;
	private JLabel lblToux_1;
	private JLabel lblDyspnet_1;
	private JLabel lblAuscultaion_1;
	private JLabel lblDsaturation_1;
	private JLabel lblPrsenceCathters_1;
	private JLabel lblAblationCathtersh_1;
	private JLabel lblInfectionLocalSur_1;
	private JPanel panel_11;
	private JLabel lblSondageUrinaire_1;
	private JLabel lblPyurie_1;
	private JLabel lblLeucocyturieUrinaire_1;
	private JLabel lblBrulureMictionnelle_1;
	private JLabel lblDouleurSus_1;
	private JLabel lblFrisson_1;
	private JPanel panel_12;
	private JLabel lblGb_1;
	private JTextField gbreq;
	private JLabel CRP_1;
	private JTextField crpreq;
	private JLabel PCT_1;
	private JTextField pctreq;
	private JPanel panel_13;
	private JLabel lblRxDuPneumo_1;
	private JTextField ur;
	private JTextField pr;
	private JTextField br;
	private JTextField pasr;
	private JTextField sktr;
	private JTextField autrr;
	private JTextField confr;
	private JTextField uq;
	private JTextField pq;
	private JTextField bq;
	private JTextField pasq;
	private JTextField sktq;
	private JTextField autrq;
	private JTextField confq;
	private JCheckBox hyp_tenreq1;
	private JCheckBox hyp_tencas1;
	private JCheckBox pathcas;
	private JCheckBox sa_48hcas1;
	private JCheckBox auscas1;
	private JCheckBox descas1;
	private JCheckBox presence_ktcas1;
	private JCheckBox ablkt_48hcas1;
	private JCheckBox infec_local_ktcas1;
	private JCheckBox seccas1;
	private JCheckBox m_seccas1;
	private JCheckBox touxcas1;
	private JCheckBox dyscas1;
	private JCheckBox sond_urinairecas1;
	private JCheckBox pyuriecas1;
	private JCheckBox brulure_mictionnellecas1;
	private JCheckBox douleur_sus_pubiennecas1;
	private JCheckBox frissonscas1;
	private JCheckBox leuco_urinairecas1;
	private JCheckBox sa_48hreq1;
	private JCheckBox ausreq1;
	private JCheckBox desreq1;
	private JCheckBox presence_ktreq1;
	private JCheckBox ablkt_48hreq1;
	private JCheckBox infec_local_ktreq1;
	private JCheckBox secreq1;
	private JCheckBox m_secreq1;
	private JCheckBox touxreq1;
	private JCheckBox dysreq1;
	private JCheckBox sond_urinairereq1;
	private JCheckBox pyuriereq1;
	private JCheckBox brulure_mictionnellereq1;
	private JCheckBox douleur_sus_pubiennereq1;
	private JCheckBox frissonsreq1;
	private JCheckBox leuco_urinairereq1;
	private JCheckBox pathq;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat_Requete1 dialog = new Resultat_Requete1(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	
	public Resultat_Requete1(JFrame main)
	{
		super(main,true);
		getContentPane().setBackground(Color.WHITE);

	
		try {
			stm = con.obtenirconnexion().createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(200, 100, 1031, 588);
		
		try
		{
			//javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (Exception e1)
		{
		}
		
		this.setTitle("Resultat du requete");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "   Cas r\u00E9m\u00E9mor\u00E9s ", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(0, 40, 512, 271);
		getContentPane().add(panel);
		panel.setLayout(null);
	
		panel_1 = new JPanel();
		panel_1.setBounds(10, 24, 478, 236);
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		lblNombreDeCas = new JLabel("Nombre de cas \u00E0 retenir :");
		lblNombreDeCas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombreDeCas.setBackground(Color.WHITE);
		lblNombreDeCas.setBounds(10, 319, 166, 23);
		panel_1.add(lblNombreDeCas);
		
		/*nh = new JSpinner((SpinnerModel) null);
		nh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nh.setBounds(173, 319, 80, 23);
		panel_1.add(nh);*/
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 484, 236);
		panel_1.add(tabbedPane);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Clinique General", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNip = new JLabel("Nip :");
		lblNip.setBounds(10, 11, 35, 15);
		lblNip.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblNip);
		
		nipcas = new JTextField();
		nipcas.setEnabled(false);
		nipcas.setBounds(192, 7, 86, 20);
		nipcas.setColumns(10);
		panel_2.add(nipcas);
		
		lblJour = new JLabel("Jour  :");
		lblJour.setBounds(10, 48, 49, 15);
		lblJour.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblJour);
		
		jourcas = new JTextField();
		jourcas.setEnabled(false);
		jourcas.setBounds(192, 44, 86, 20);
		jourcas.setColumns(10);
		panel_2.add(jourcas);
		
		lblLesSymptomesApres = new JLabel("Les symptomes apres 48h :");
		lblLesSymptomesApres.setBounds(10, 78, 175, 15);
		lblLesSymptomesApres.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblLesSymptomesApres);
		
		lblHypoTension = new JLabel("Hypo tension :");
		lblHypoTension.setBounds(10, 153, 98, 15);
		lblHypoTension.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblHypoTension);
		
		lblTemprature = new JLabel("Temp\u00E9rature :");
		lblTemprature.setBounds(10, 115, 91, 15);
		lblTemprature.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblTemprature);
		
		tcas = new JTextField();
		tcas.setEnabled(false);
		tcas.setBounds(192, 107, 86, 20);
		tcas.setColumns(10);
		panel_2.add(tcas);
		
		hyp_tencas1 = new JCheckBox("");
		hyp_tencas1.setBackground(Color.WHITE);
		hyp_tencas1.setEnabled(false);
		hyp_tencas1.setBounds(217, 148, 25, 23);
		panel_2.add(hyp_tencas1);
		
		sa_48hcas1 = new JCheckBox("");
		sa_48hcas1.setBackground(Color.WHITE);
		sa_48hcas1.setEnabled(false);
		sa_48hcas1.setBounds(217, 73, 25, 23);
		panel_2.add(sa_48hcas1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Clinique Sp1", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblSecretion = new JLabel("S\u00E9cretion :   ");
		lblSecretion.setBounds(243, 56, 98, 15);
		lblSecretion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblSecretion);
		
		lblModificationScretion = new JLabel("Modif S\u00E9cretion :");
		lblModificationScretion.setBounds(243, 85, 124, 15);
		lblModificationScretion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblModificationScretion);
		
		lblToux = new JLabel("toux :");
		lblToux.setBounds(243, 117, 42, 15);
		lblToux.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblToux);
		
		lblDyspnet = new JLabel("Dyspn\u00E9e :");
		lblDyspnet.setBounds(243, 149, 63, 15);
		lblDyspnet.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblDyspnet);
		
		lblAuscultaion = new JLabel("Auscultaion :");
		lblAuscultaion.setBounds(3, 38, 91, 15);
		lblAuscultaion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblAuscultaion);
		
		lblDsaturation = new JLabel("D\u00E9saturation :");
		lblDsaturation.setBounds(3, 79, 98, 15);
		lblDsaturation.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblDsaturation);
		
		lblPrsenceCathters = new JLabel("Pr\u00E9sence KT :   ");
		lblPrsenceCathters.setBounds(3, 108, 112, 15);
		lblPrsenceCathters.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblPrsenceCathters);
		
		lblAblationCathtersh = new JLabel("AblationKT-48h :   ");
		lblAblationCathtersh.setBounds(3, 134, 147, 15);
		lblAblationCathtersh.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblAblationCathtersh);
		
		lblInfectionLocalSur = new JLabel("Infection localKT:   ");
		lblInfectionLocalSur.setBounds(3, 170, 179, 15);
		lblInfectionLocalSur.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblInfectionLocalSur);
		
		auscas1 = new JCheckBox("");
		auscas1.setEnabled(false);
		auscas1.setBackground(Color.WHITE);
		auscas1.setBounds(156, 33, 26, 23);
		panel_3.add(auscas1);
		
		descas1 = new JCheckBox("");
		descas1.setEnabled(false);
		descas1.setBackground(Color.WHITE);
		descas1.setBounds(156, 78, 26, 23);
		panel_3.add(descas1);
		
		presence_ktcas1 = new JCheckBox("");
		presence_ktcas1.setEnabled(false);
		presence_ktcas1.setBackground(Color.WHITE);
		presence_ktcas1.setBounds(156, 107, 26, 23);
		panel_3.add(presence_ktcas1);
		
		ablkt_48hcas1 = new JCheckBox("");
		ablkt_48hcas1.setEnabled(false);
		ablkt_48hcas1.setBackground(Color.WHITE);
		ablkt_48hcas1.setBounds(156, 139, 26, 23);
		panel_3.add(ablkt_48hcas1);
		
		infec_local_ktcas1 = new JCheckBox("");
		infec_local_ktcas1.setEnabled(false);
		infec_local_ktcas1.setBackground(Color.WHITE);
		infec_local_ktcas1.setBounds(156, 171, 26, 23);
		panel_3.add(infec_local_ktcas1);
		
		seccas1 = new JCheckBox("");
		seccas1.setEnabled(false);
		seccas1.setBackground(Color.WHITE);
		seccas1.setBounds(397, 56, 26, 23);
		panel_3.add(seccas1);
		
		m_seccas1 = new JCheckBox("");
		m_seccas1.setEnabled(false);
		m_seccas1.setBackground(Color.WHITE);
		m_seccas1.setBounds(397, 80, 29, 23);
		panel_3.add(m_seccas1);
		
		touxcas1 = new JCheckBox("");
		touxcas1.setEnabled(false);
		touxcas1.setBackground(Color.WHITE);
		touxcas1.setBounds(397, 109, 29, 23);
		panel_3.add(touxcas1);
		
		dyscas1 = new JCheckBox("");
		dyscas1.setEnabled(false);
		dyscas1.setBackground(Color.WHITE);
		dyscas1.setBounds(400, 144, 26, 23);
		panel_3.add(dyscas1);
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Clinique Sp2", null, panel_8, null);
		panel_8.setLayout(null);
		
		lblSondageUrinaire = new JLabel("Sondage Urinaire :   ");
		lblSondageUrinaire.setBounds(7, 10, 147, 15);
		lblSondageUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblSondageUrinaire);
		
		lblPyurie = new JLabel("Pyurie :   ");
		lblPyurie.setBounds(7, 36, 77, 15);
		lblPyurie.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblPyurie);
		
		lblLeucocyturieUrinaire = new JLabel("Leucocyturie Urinaire :   ");
		lblLeucocyturieUrinaire.setBounds(7, 167, 182, 15);
		lblLeucocyturieUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblLeucocyturieUrinaire);
		
		lblBrulureMictionnelle = new JLabel("Brulure mictionnelle :   ");
		lblBrulureMictionnelle.setBounds(7, 65, 175, 15);
		lblBrulureMictionnelle.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblBrulureMictionnelle);
		
		lblDouleurSus = new JLabel("Douleur sus-pubiens :   ");
		lblDouleurSus.setBounds(7, 99, 168, 15);
		lblDouleurSus.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblDouleurSus);
		
		lblFrisson = new JLabel("Frisson :   ");
		lblFrisson.setBounds(7, 136, 84, 15);
		lblFrisson.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_8.add(lblFrisson);
		
		sond_urinairecas1 = new JCheckBox("");
		sond_urinairecas1.setEnabled(false);
		sond_urinairecas1.setBackground(Color.WHITE);
		sond_urinairecas1.setBounds(280, 5, 27, 23);
		panel_8.add(sond_urinairecas1);
		
		pyuriecas1 = new JCheckBox("");
		pyuriecas1.setEnabled(false);
		pyuriecas1.setBackground(Color.WHITE);
		pyuriecas1.setBounds(280, 37, 27, 23);
		panel_8.add(pyuriecas1);
		
		brulure_mictionnellecas1 = new JCheckBox("");
		brulure_mictionnellecas1.setEnabled(false);
		brulure_mictionnellecas1.setBackground(Color.WHITE);
		brulure_mictionnellecas1.setBounds(280, 69, 27, 23);
		panel_8.add(brulure_mictionnellecas1);
		
		douleur_sus_pubiennecas1 = new JCheckBox("");
		douleur_sus_pubiennecas1.setEnabled(false);
		douleur_sus_pubiennecas1.setBackground(Color.WHITE);
		douleur_sus_pubiennecas1.setBounds(280, 94, 27, 23);
		panel_8.add(douleur_sus_pubiennecas1);
		
		frissonscas1 = new JCheckBox("");
		frissonscas1.setEnabled(false);
		frissonscas1.setBackground(Color.WHITE);
		frissonscas1.setBounds(280, 133, 27, 23);
		panel_8.add(frissonscas1);
		
		leuco_urinairecas1 = new JCheckBox("");
		leuco_urinairecas1.setEnabled(false);
		leuco_urinairecas1.setBackground(Color.WHITE);
		leuco_urinairecas1.setBounds(280, 167, 27, 23);
		panel_8.add(leuco_urinairecas1);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Biologique", null, panel_9, null);
		panel_9.setLayout(null);
		
		lblGb = new JLabel("GB :");
		lblGb.setBounds(15, 46, 28, 15);
		lblGb.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_9.add(lblGb);
		
		gbcas = new JTextField();
		gbcas.setEnabled(false);
		gbcas.setBounds(71, 42, 86, 20);
		gbcas.setColumns(10);
		panel_9.add(gbcas);
		
		CRP = new JLabel("CRP :");
		CRP.setBounds(15, 85, 35, 15);
		CRP.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_9.add(CRP);
		
		crpcas = new JTextField();
		crpcas.setEnabled(false);
		crpcas.setBounds(71, 81, 86, 20);
		crpcas.setColumns(10);
		panel_9.add(crpcas);
		
		PCT = new JLabel("PCT :");
		PCT.setBounds(15, 123, 35, 15);
		PCT.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_9.add(PCT);
		
		pctcas = new JTextField();
		pctcas.setEnabled(false);
		pctcas.setBounds(71, 119, 86, 20);
		pctcas.setColumns(10);
		panel_9.add(pctcas);
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Radiologique", null, panel_10, null);
		panel_10.setLayout(null);
		
		lblRxDuPneumo = new JLabel("Radio du thorax pathologique : ");
		lblRxDuPneumo.setBounds(24, 86, 217, 15);
		lblRxDuPneumo.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_10.add(lblRxDuPneumo);
		
		pathcas = new JCheckBox("");
		pathcas.setEnabled(false);
		pathcas.setBounds(262, 86, 23, 23);
		pathcas.setBackground(Color.WHITE);
		panel_10.add(pathcas);
		/*
		agec = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		poidsc = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		gsc = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		Glasgowlieu = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		Glasgowurg =new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		ager =new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		poidsr = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		gsr = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		*/
		lblCasRememors = new JLabel("");
		lblCasRememors.setForeground(Color.BLUE);
		lblCasRememors.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblCasRememors.setBounds(85, 6, 303, 23);
		getContentPane().add(lblCasRememors);
		
		button = new JButton("<<");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCase = (currentCase+cases.size()-1) % cases.size();
				
				showCase();
				
			}
		});
		button.setBounds(24, 6, 51, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton(">>");
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				currentCase = (currentCase+1) % cases.size();
				showCase();
			}
		});
		button_1.setBounds(399, 6, 61, 23);
		getContentPane().add(button_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 507, 1034, 42);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnNewButton = new JButton("Suivant");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205)));
		btnNewButton.setBounds(653, 11, 148, 27);
		panel_7.add(btnNewButton);
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(Color.RED);
		btnQuitter.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnQuitter.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 0, 0), new Color(128, 0, 0), new Color(128, 0, 0), new Color(128, 0, 0)));
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Test2.getInstance().postCycle();
				} catch (Exception ex) {
					org.apache.commons.logging.LogFactory.getLog(Test1.class).error(ex);
				}
				System.exit(-1);
			}
		});
		btnQuitter.setBounds(841, 12, 141, 25);
		panel_7.add(btnQuitter);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setrequete();
			}
		});
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  Nouveau cas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_4.setBounds(516, 40, 518, 271);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 22, 477, 238);
		panel_4.add(tabbedPane_1);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		tabbedPane_1.addTab("Clinique General", null, panel_5, null);
		
		lblNip_1 = new JLabel("Nip :");
		lblNip_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNip_1.setBounds(10, 22, 35, 15);
		panel_5.add(lblNip_1);
		
		nipreq = new JTextField();
		nipreq.setEnabled(false);
		nipreq.setColumns(10);
		nipreq.setBounds(208, 18, 86, 20);
		panel_5.add(nipreq);
		
		lblJour_1 = new JLabel("Jour  :");
		lblJour_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblJour_1.setBounds(10, 56, 49, 15);
		panel_5.add(lblJour_1);
		
		jourreq = new JTextField();
		jourreq.setEnabled(false);
		jourreq.setColumns(10);
		jourreq.setBounds(208, 52, 86, 20);
		panel_5.add(jourreq);
		
		lblLesSymptomesApres_1 = new JLabel("Les symptomes apres 48h :");
		lblLesSymptomesApres_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLesSymptomesApres_1.setBounds(10, 93, 175, 15);
		panel_5.add(lblLesSymptomesApres_1);
		
		lblHypoTension_1 = new JLabel("Hypo tension :");
		lblHypoTension_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblHypoTension_1.setBounds(10, 164, 98, 15);
		panel_5.add(lblHypoTension_1);
		
		lblTemprature_1 = new JLabel("Temp\u00E9rature :");
		lblTemprature_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblTemprature_1.setBounds(10, 130, 91, 15);
		panel_5.add(lblTemprature_1);
		
		treq = new JTextField();
		treq.setEnabled(false);
		treq.setColumns(10);
		treq.setBounds(208, 126, 86, 20);
		panel_5.add(treq);
		
		hyp_tenreq1 = new JCheckBox("");
		hyp_tenreq1.setEnabled(false);
		hyp_tenreq1.setBackground(Color.WHITE);
		hyp_tenreq1.setBounds(218, 156, 20, 23);
		panel_5.add(hyp_tenreq1);
		
		sa_48hreq1 = new JCheckBox("");
		sa_48hreq1.setEnabled(false);
		sa_48hreq1.setBackground(Color.WHITE);
		sa_48hreq1.setBounds(218, 85, 20, 23);
		panel_5.add(sa_48hreq1);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		tabbedPane_1.addTab("Clinique Sp1", null, panel_6, null);
		
		lblSecretion_1 = new JLabel("Secretion :   ");
		lblSecretion_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblSecretion_1.setBounds(256, 48, 98, 15);
		panel_6.add(lblSecretion_1);
		
		lblModificationScretion_1 = new JLabel("Modif S\u00E9cretion :");
		lblModificationScretion_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblModificationScretion_1.setBounds(256, 82, 147, 15);
		panel_6.add(lblModificationScretion_1);
		
		lblToux_1 = new JLabel("toux :");
		lblToux_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblToux_1.setBounds(253, 108, 42, 15);
		panel_6.add(lblToux_1);
		
		lblDyspnet_1 = new JLabel("Dyspn\u00E9e :");
		lblDyspnet_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDyspnet_1.setBounds(256, 143, 63, 15);
		panel_6.add(lblDyspnet_1);
		
		lblAuscultaion_1 = new JLabel("Auscultaion :");
		lblAuscultaion_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAuscultaion_1.setBounds(10, 48, 91, 15);
		panel_6.add(lblAuscultaion_1);
		
		lblDsaturation_1 = new JLabel("D\u00E9saturation :");
		lblDsaturation_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDsaturation_1.setBounds(10, 79, 98, 15);
		panel_6.add(lblDsaturation_1);
		
		lblPrsenceCathters_1 = new JLabel("Pr\u00E9sence KT :   ");
		lblPrsenceCathters_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPrsenceCathters_1.setBounds(10, 105, 112, 15);
		panel_6.add(lblPrsenceCathters_1);
		
		lblAblationCathtersh_1 = new JLabel("AblationKT -48h:   ");
		lblAblationCathtersh_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAblationCathtersh_1.setBounds(10, 134, 146, 15);
		panel_6.add(lblAblationCathtersh_1);
		
		lblInfectionLocalSur_1 = new JLabel("Infection localKT:   ");
		lblInfectionLocalSur_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblInfectionLocalSur_1.setBounds(10, 164, 171, 15);
		panel_6.add(lblInfectionLocalSur_1);
		
		ausreq1 = new JCheckBox("");
		ausreq1.setEnabled(false);
		ausreq1.setBackground(Color.WHITE);
		ausreq1.setBounds(181, 40, 35, 23);
		panel_6.add(ausreq1);
		
		desreq1 = new JCheckBox("");
		desreq1.setEnabled(false);
		desreq1.setBackground(Color.WHITE);
		desreq1.setBounds(181, 79, 19, 23);
		panel_6.add(desreq1);
		
		presence_ktreq1 = new JCheckBox("");
		presence_ktreq1.setEnabled(false);
		presence_ktreq1.setBackground(Color.WHITE);
		presence_ktreq1.setBounds(181, 100, 19, 23);
		panel_6.add(presence_ktreq1);
		
		ablkt_48hreq1 = new JCheckBox("");
		ablkt_48hreq1.setEnabled(false);
		ablkt_48hreq1.setBackground(Color.WHITE);
		ablkt_48hreq1.setBounds(182, 134, 34, 23);
		panel_6.add(ablkt_48hreq1);
		
		infec_local_ktreq1 = new JCheckBox("");
		infec_local_ktreq1.setEnabled(false);
		infec_local_ktreq1.setBackground(Color.WHITE);
		infec_local_ktreq1.setBounds(182, 156, 30, 23);
		panel_6.add(infec_local_ktreq1);
		
		secreq1 = new JCheckBox("");
		secreq1.setEnabled(false);
		secreq1.setBackground(Color.WHITE);
		secreq1.setBounds(411, 42, 30, 23);
		panel_6.add(secreq1);
		
		m_secreq1 = new JCheckBox("");
		m_secreq1.setEnabled(false);
		m_secreq1.setBackground(Color.WHITE);
		m_secreq1.setBounds(409, 74, 21, 23);
		panel_6.add(m_secreq1);
		
		touxreq1 = new JCheckBox("");
		touxreq1.setEnabled(false);
		touxreq1.setBackground(Color.WHITE);
		touxreq1.setBounds(411, 104, 31, 23);
		panel_6.add(touxreq1);
		
		dysreq1 = new JCheckBox("");
		dysreq1.setEnabled(false);
		dysreq1.setBackground(Color.WHITE);
		dysreq1.setBounds(411, 134, 30, 23);
		panel_6.add(dysreq1);
		
		panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setLayout(null);
		tabbedPane_1.addTab("Clinique sp2", null, panel_11, null);
		
		lblSondageUrinaire_1 = new JLabel("Sondage Urinaire :   ");
		lblSondageUrinaire_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblSondageUrinaire_1.setBounds(7, 10, 147, 15);
		panel_11.add(lblSondageUrinaire_1);
		
		lblPyurie_1 = new JLabel("Pyurie :   ");
		lblPyurie_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPyurie_1.setBounds(7, 36, 77, 15);
		panel_11.add(lblPyurie_1);
		
		lblLeucocyturieUrinaire_1 = new JLabel("Leucocyturie Urinaire :   ");
		lblLeucocyturieUrinaire_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLeucocyturieUrinaire_1.setBounds(7, 167, 182, 15);
		panel_11.add(lblLeucocyturieUrinaire_1);
		
		lblBrulureMictionnelle_1 = new JLabel("Brulure mictionnelle :   ");
		lblBrulureMictionnelle_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblBrulureMictionnelle_1.setBounds(7, 65, 175, 15);
		panel_11.add(lblBrulureMictionnelle_1);
		
		lblDouleurSus_1 = new JLabel("Douleur sus-pubiens :   ");
		lblDouleurSus_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDouleurSus_1.setBounds(7, 99, 168, 15);
		panel_11.add(lblDouleurSus_1);
		
		lblFrisson_1 = new JLabel("Frisson :   ");
		lblFrisson_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblFrisson_1.setBounds(7, 136, 84, 15);
		panel_11.add(lblFrisson_1);
		
		sond_urinairereq1 = new JCheckBox("");
		sond_urinairereq1.setEnabled(false);
		sond_urinairereq1.setBackground(Color.WHITE);
		sond_urinairereq1.setBounds(288, 5, 23, 23);
		panel_11.add(sond_urinairereq1);
		
		pyuriereq1 = new JCheckBox("");
		pyuriereq1.setEnabled(false);
		pyuriereq1.setBackground(Color.WHITE);
		pyuriereq1.setBounds(288, 36, 23, 23);
		panel_11.add(pyuriereq1);
		
		brulure_mictionnellereq1 = new JCheckBox("");
		brulure_mictionnellereq1.setEnabled(false);
		brulure_mictionnellereq1.setBackground(Color.WHITE);
		brulure_mictionnellereq1.setBounds(288, 69, 23, 23);
		panel_11.add(brulure_mictionnellereq1);
		
		douleur_sus_pubiennereq1 = new JCheckBox("");
		douleur_sus_pubiennereq1.setEnabled(false);
		douleur_sus_pubiennereq1.setBackground(Color.WHITE);
		douleur_sus_pubiennereq1.setBounds(288, 103, 23, 23);
		panel_11.add(douleur_sus_pubiennereq1);
		
		frissonsreq1 = new JCheckBox("");
		frissonsreq1.setEnabled(false);
		frissonsreq1.setBackground(Color.WHITE);
		frissonsreq1.setBounds(288, 131, 23, 23);
		panel_11.add(frissonsreq1);
		
		leuco_urinairereq1 = new JCheckBox("");
		leuco_urinairereq1.setEnabled(false);
		leuco_urinairereq1.setBackground(Color.WHITE);
		leuco_urinairereq1.setBounds(288, 162, 23, 23);
		panel_11.add(leuco_urinairereq1);
		
		panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setLayout(null);
		tabbedPane_1.addTab("Biologique", null, panel_12, null);
		
		lblGb_1 = new JLabel("GB :");
		lblGb_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblGb_1.setBounds(15, 46, 28, 15);
		panel_12.add(lblGb_1);
		
		gbreq = new JTextField();
		gbreq.setEnabled(false);
		gbreq.setColumns(10);
		gbreq.setBounds(71, 42, 86, 20);
		panel_12.add(gbreq);
		
		CRP_1 = new JLabel("CRP :");
		CRP_1.setFont(new Font("Consolas", Font.BOLD, 12));
		CRP_1.setBounds(15, 85, 35, 15);
		panel_12.add(CRP_1);
		
		crpreq = new JTextField();
		crpreq.setEnabled(false);
		crpreq.setColumns(10);
		crpreq.setBounds(71, 81, 86, 20);
		panel_12.add(crpreq);
		
		PCT_1 = new JLabel("PCT :");
		PCT_1.setFont(new Font("Consolas", Font.BOLD, 12));
		PCT_1.setBounds(15, 123, 35, 15);
		panel_12.add(PCT_1);
		
		pctreq = new JTextField();
		pctreq.setEnabled(false);
		pctreq.setColumns(10);
		pctreq.setBounds(71, 119, 86, 20);
		panel_12.add(pctreq);
		
		panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setLayout(null);
		tabbedPane_1.addTab("Radiologique", null, panel_13, null);
		
		lblRxDuPneumo_1 = new JLabel("Radio du thorax pathologique:");
		lblRxDuPneumo_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblRxDuPneumo_1.setBounds(24, 86, 220, 15);
		panel_13.add(lblRxDuPneumo_1);
		
		pathq = new JCheckBox("");
		pathq.setEnabled(false);
		pathq.setBackground(Color.WHITE);
		pathq.setBounds(264, 86, 22, 23);
		panel_13.add(pathq);
		
		ider = new JLabel("");
		ider.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		ider.setForeground(Color.RED);
		ider.setBounds(138, 6, 29, 23);
		getContentPane().add(ider);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  Solution ", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(526, 311, 489, 195);
		getContentPane().add(panel_3_1);
		
		JPanel jPanel3_1 = new JPanel();
		jPanel3_1.setBackground(new Color(255, 255, 255));
		jPanel3_1.setLayout(null);
		jPanel3_1.setBounds(10, 21, 469, 164);
		panel_3_1.add(jPanel3_1);
		
		JLabel jLabel6_1 = new JLabel();
		jLabel6_1.setText("Infection Bact\u00E9riemie nosocomiale");
		jLabel6_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel6_1.setBounds(0, 56, 257, 17);
		jPanel3_1.add(jLabel6_1);
		
		JLabel jLabel4_1 = new JLabel();
		jLabel4_1.setText("Infection Pneumopathie nosocomiale");
		jLabel4_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel4_1.setBounds(0, 0, 224, 27);
		jPanel3_1.add(jLabel4_1);
		
		JLabel jLabel5_1 = new JLabel();
		jLabel5_1.setText("Infection Urinaire nosocomiale");
		jLabel5_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel5_1.setBounds(0, 28, 208, 17);
		jPanel3_1.add(jLabel5_1);
		
		ur = new JTextField();
		ur.setEnabled(false);
		ur.setBounds(247, 27, 24, 20);
		jPanel3_1.add(ur);
		
		pr = new JTextField();
		pr.setEnabled(false);
		pr.setBounds(247, 2, 24, 20);
		jPanel3_1.add(pr);
		
		br = new JTextField();
		br.setEnabled(false);
		br.setBounds(247, 55, 24, 20);
		jPanel3_1.add(br);
		
		JLabel jLabel9_1 = new JLabel();
		jLabel9_1.setText("Pas d'infection nosocomiales");
		jLabel9_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel9_1.setBounds(0, 140, 186, 17);
		jPanel3_1.add(jLabel9_1);
		
		JLabel jLabel7_1 = new JLabel();
		jLabel7_1.setText("Infection li\u00E9es aux Cath\u00E9ters nosocomiale");
		jLabel7_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel7_1.setBounds(0, 84, 251, 17);
		jPanel3_1.add(jLabel7_1);
		
		JLabel jLabel8_1 = new JLabel();
		jLabel8_1.setText("Autre Infection");
		jLabel8_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel8_1.setBounds(0, 112, 119, 17);
		jPanel3_1.add(jLabel8_1);
		
		pasr = new JTextField();
		pasr.setEnabled(false);
		pasr.setBounds(247, 137, 24, 20);
		jPanel3_1.add(pasr);
		
		sktr = new JTextField();
		sktr.setEnabled(false);
		sktr.setBounds(247, 83, 24, 20);
		jPanel3_1.add(sktr);
		
		autrr = new JTextField();
		autrr.setEnabled(false);
		autrr.setBounds(247, 109, 24, 20);
		jPanel3_1.add(autrr);
		
		JLabel jLabel10_1 = new JLabel();
		jLabel10_1.setText("Confirmer l'infection");
		jLabel10_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel10_1.setBounds(291, 110, 134, 20);
		jPanel3_1.add(jLabel10_1);
		
		confr = new JTextField();
		confr.setEnabled(false);
		confr.setBounds(435, 109, 24, 20);
		jPanel3_1.add(confr);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		panel_2_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  Solution ", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(10, 311, 512, 194);
		getContentPane().add(panel_2_1);
		
		JPanel jPanel3_1_1 = new JPanel();
		jPanel3_1_1.setBackground(new Color(255, 255, 255));
		jPanel3_1_1.setLayout(null);
		jPanel3_1_1.setBounds(10, 19, 492, 168);
		panel_2_1.add(jPanel3_1_1);
		
		JLabel jLabel6_1_1 = new JLabel();
		jLabel6_1_1.setText("Infection Bact\u00E9riemie nosocomiale");
		jLabel6_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel6_1_1.setBounds(0, 56, 207, 17);
		jPanel3_1_1.add(jLabel6_1_1);
		
		JLabel jLabel4_1_1 = new JLabel();
		jLabel4_1_1.setText("Infection Pneumopathie nosocomiale");
		jLabel4_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel4_1_1.setBounds(0, 0, 207, 27);
		jPanel3_1_1.add(jLabel4_1_1);
		
		JLabel jLabel5_1_1 = new JLabel();
		jLabel5_1_1.setText("Infection Urinaire nosocomiale");
		jLabel5_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel5_1_1.setBounds(0, 28, 207, 17);
		jPanel3_1_1.add(jLabel5_1_1);
		
		uq = new JTextField();
		uq.setEnabled(false);
		uq.setBounds(247, 27, 23, 20);
		jPanel3_1_1.add(uq);
		
		pq = new JTextField();
		pq.setEnabled(false);
		pq.setBounds(247, 2, 23, 20);
		jPanel3_1_1.add(pq);
		
		bq = new JTextField();
		bq.setEnabled(false);
		bq.setBounds(247, 55, 23, 20);
		jPanel3_1_1.add(bq);
		
		JLabel jLabel9_1_1 = new JLabel();
		jLabel9_1_1.setText("Pas d'infection nosocomiales");
		jLabel9_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel9_1_1.setBounds(0, 140, 196, 17);
		jPanel3_1_1.add(jLabel9_1_1);
		
		JLabel jLabel7_1_1 = new JLabel();
		jLabel7_1_1.setText("Infection li\u00E9es aux Cath\u00E9ters nosocomiale");
		jLabel7_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel7_1_1.setBounds(0, 84, 251, 17);
		jPanel3_1_1.add(jLabel7_1_1);
		
		JLabel jLabel8_1_1 = new JLabel();
		jLabel8_1_1.setText("Autre Infection");
		jLabel8_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel8_1_1.setBounds(0, 112, 171, 17);
		jPanel3_1_1.add(jLabel8_1_1);
		
		pasq = new JTextField();
		pasq.setEnabled(false);
		pasq.setBounds(247, 137, 23, 20);
		jPanel3_1_1.add(pasq);
		
		sktq = new JTextField();
		sktq.setEnabled(false);
		sktq.setBounds(247, 84, 23, 20);
		jPanel3_1_1.add(sktq);
		
		autrq = new JTextField();
		autrq.setEnabled(false);
		autrq.setBounds(247, 109, 23, 20);
		jPanel3_1_1.add(autrq);
		
		JLabel jLabel10_1_1 = new JLabel();
		jLabel10_1_1.setText("Confirmer l'infection");
		jLabel10_1_1.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel10_1_1.setBounds(321, 110, 134, 20);
		jPanel3_1_1.add(jLabel10_1_1);
		
		confq = new JTextField();
		confq.setEnabled(false);
		confq.setBounds(459, 109, 23, 20);
		jPanel3_1_1.add(confq);
		
	
	
			}
	public void setrequete(){
		this.setVisible(false);
	 	try {
	 		
			String req = "insert into solution values("+pr.getText()+","+ur.getText()+","+br.getText()+","+sktr.getText()+","+autrr.getText()+","+pasr.getText()+","+confr.getText()+")";
		
			 
			
			
		//	req = "update basecase set pert = pert+1 where Id='"+ider.getText()+"'";
			
			 
			stm.executeUpdate(req);
		
				
				rs=stm.executeQuery("select * from solution");
			
				
			while(rs.next()){
				System.out.println("cc c resultquery");
			
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
			}
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 
	}
	public void showCases(Collection<RetrievalResult> eval, Collection<CBRCase> selected)
	{
		//JOptionPane.showConfirmDialog(null, "m1");
	
		cases = new ArrayList<RetrievalResult>();
		
		for(RetrievalResult rr: eval)
			
			if(selected.contains(rr.get_case()))
				cases.add(rr);
			
		
		
		currentCase = 0;
		showCase();
		
	}
	
	void showCase()
	{
		

		RetrievalResult rr = cases.get(currentCase);
		
		
		
		//JOptionPane.showConfirmDialog(null, "m2");
		double sim = rr.getEval();
		//JOptionPane.showConfirmDialog(null, "m3");
		_case = rr.get_case();
		
		this.lblCasRememors.setText("Cas N°:     -> "+sim+"   ("+(currentCase+1)+"/"+cases.size()+")");
		
		this.ider.setText(_case.getID().toString());
	
		CasenosoDescription desc = (CasenosoDescription) _case.getDescription();
		
	
	 /*	this.nipcas.setText(desc.getNip());
		this.jourcas.setText(desc.getJ());
		this.sa_48hcas.setSelectedItem(desc.getSa());
	    this.tcas.setText(""+desc.getT());
		this.descas.setSelectedItem(desc.getDes());
		this.presence_ktcas.setSelectedItem(desc.getKt());
		this.ablkt_48hcas.setSelectedItem(desc.getAbl());
		this.infec_local_ktcas.setSelectedItem(desc.getInfkt());
		this.seccas.setSelectedItem(desc.getSec());
		this.m_seccas.setSelectedItem(desc.getMsec());
		this.touxcas.setSelectedItem(desc.getTou());
		this.dyscas.setSelectedItem(desc.getDys());
		this.sond_urinairecas.setSelectedItem(desc.getSu());
		this.pyuriecas.setSelectedItem(desc.getPyu());
		this.brulure_mictionnellecas.setSelectedItem(desc.getBrm());
		this.frissonscas.setSelectedItem(desc.getFr());
		this.douleur_sus_pubiennecas.setSelectedItem(desc.getDsp());
		this.leuco_urinairecas.setSelectedItem(desc.getLu());
		this.gbcas.setText(""+desc.getGb());
		this.crpcas.setText(""+desc.getCrp());
		this.pctcas.setText(""+desc.getPct());
		this.rxcas.setSelectedItem(desc.getRx());

		if (desc.getHt().equals("true")){ this.moh.setSelected(true);}else {this.moh.setSelected(false);}
	
		
		this.hyp_tencas.setSelectedItem(desc.getHt().toString());
		/*this.auscas.setSelectedItem(desc);
		this.sa_48hcas.setSelectedItem(desc.getSa());
		this.sa_48hcas.setSelectedItem(desc.getSa());
		this.sa_48hcas.setSelectedItem(desc.getSa());
		this.sa_48hcas.setSelectedItem(desc.getSa()); 
		if (desc.getSa().equals("true")){this.chckbxCeinture.setSelected(true);}else{this.chckbxCeinture.setSelected(false);}
		this.ramassage.setText(desc.getMtrans());
		this.resp.setText(desc.getVoiessupp());
		this.pas.setValue(desc.getPas());
		this.pad.setValue(desc.getPad());
		this.trcc.setText(desc.getTrc());
		if (desc.getMarbure().equals("true")){this.Marburec.setSelected(true);}else{this.Marburec.setSelected(false);}
		if(desc.getCyanose().equals("true")){this.cyanosec.setSelected(true);}else{{this.cyanosec.setSelected(false);}
		if(desc.getSueurs().equals("true")){this.sueurc.setSelected(true);}else{this.sueurc.setSelected(false);}
		if(desc.getConjoctive().equals("true")){this.conjc.setSelected(true);}else{this.conjc.setSelected(true);}
		this.fcc.setValue(desc.getFc());
		this.frc.setValue(desc.getFr());
		this.spoc.setValue(desc.getSpo2());
		this.fioc.setValue(desc.getSousfio());
		if(desc.getBattement().equals("true")){this.battc.setSelected(true);}else{this.battc.setSelected(false);}
		if(desc.getBalancement().equals("true")){this.balancc.setSelected(true);}else{this.balancc.setSelected(false);}
		if(desc.getCyanoser().equals("true")){this.cyanoserc.setSelected(true);}else{this.cyanoserc.setSelected(false);}
		if(desc.getAgitation().equals("true")){this.agitationc.setSelected(true);}else{this.agitationc.setSelected(false);}
		if(desc.getMatire().equals("true")){this.matitec.setSelected(true);}else{this.matitec.setSelected(false);}
		if(desc.getSueurer().equals("true")){this.sueurcas.setSelected(true);}else{this.sueurcas.setSelected(false);}
		if(desc.getSonorite().equals("true")){this.sonoritc.setSelected(true);}else{this.sonoritc.setSelected(false);}
		if(desc.getAusculation().equals("true")){this.symetriquec.setSelected(true);}else{this.symetriquec.setSelected(false);}
		if(desc.getAsymetrique().equals("true")){this.asymetriquec.setSelected(true);}else{this.asymetriquec.setSelected(false);}
		this.gslieuc.setValue(desc.getGslieu());
		this.gcurgencelieu.setValue(desc.getGsurg());
		this.abdomen.setText(desc.getAbdomen());
		this.reines.setText(desc.getReins());
		this.face.setText(desc.getExamenface());
		this.bassin.setText(desc.getMemetbassin());
		this.hematome.setText(desc.getHematome());
		this.plaie.setText(desc.getPlaie()); */
		this.nipcas.setText(desc.getNip());
		this.jourcas.setText(desc.getJ());
		if (this.sa_48hcas1.isSelected()){desc.setSa("true");}else{desc.setSa("false");}
		if (desc.getSa().equals("true")){ this.sa_48hcas1.setSelected(true);}else {this.sa_48hcas1.setSelected(false);}
		 this.tcas.setText(""+desc.getT());
		if (desc.getHt().equals("true")){ this.hyp_tencas1.setSelected(true);}else {this.hyp_tencas1.setSelected(false);}
		if (desc.getAus().equals("true")){ this.auscas1.setSelected(true);}else {this.auscas1.setSelected(false);}
		if (desc.getDes().equals("true")){ this.descas1.setSelected(true);}else {this.descas1.setSelected(false);}
		if (desc.getKt().equals("true")){ this.presence_ktcas1.setSelected(true);}else {this.presence_ktcas1.setSelected(false);}
		if (desc.getAbl().equals("true")){ this.ablkt_48hcas1.setSelected(true);}else {this.ablkt_48hcas1.setSelected(false);}
		if (desc.getInfkt().equals("true")){ this.infec_local_ktcas1.setSelected(true);}else {this.infec_local_ktcas1.setSelected(false);}
		if (desc.getSec().equals("true")){ this.seccas1.setSelected(true);}else {this.seccas1.setSelected(false);}
		if (desc.getMsec().equals("true")){ this.m_seccas1.setSelected(true);}else {this.m_seccas1.setSelected(false);}
		if (desc.getTou().equals("true")){ this.touxcas1.setSelected(true);}else {this.touxcas1.setSelected(false);}
		if (desc.getDys().equals("true")){ this.dyscas1.setSelected(true);}else {this.dyscas1.setSelected(false);}
		if (desc.getSu().equals("true")){ this.sond_urinairecas1.setSelected(true);}else {this.sond_urinairecas1.setSelected(false);}
		if (desc.getPyu().equals("true")){ this.pyuriecas1.setSelected(true);}else {this.pyuriecas1.setSelected(false);}
		if (desc.getBrm().equals("true")){ this.brulure_mictionnellecas1.setSelected(true);}else {this.brulure_mictionnellecas1.setSelected(false);}
		if (desc.getDsp().equals("true")){ this.douleur_sus_pubiennecas1.setSelected(true);}else {this.douleur_sus_pubiennecas1.setSelected(false);}
		if (desc.getFr().equals("true")){ this.frissonscas1.setSelected(true);}else {this.frissonscas1.setSelected(false);}
		if (desc.getLu().equals("true")){ this.leuco_urinairecas1.setSelected(true);}else {this.leuco_urinairecas1.setSelected(false);}
		this.gbcas.setText(""+desc.getGb());
		this.crpcas.setText(""+desc.getCrp());
		this.pctcas.setText(""+desc.getPct());
		if (desc.getRx().equals("true")){ this.pathcas.setSelected(true);}else {this.pathcas.setSelected(false);}
		
		
		CasenosoSolution sol = (CasenosoSolution) _case.getSolution();
		
		this.pq.setText(""+sol.getP());this.pr.setText(""+sol.getP());
		this.uq.setText(""+sol.getU());this.ur.setText(""+sol.getU());
		this.bq.setText(""+sol.getB());this.br.setText(""+sol.getB());
		this.sktq.setText(""+sol.getSkt());this.sktr.setText(""+sol.getSkt());
		this.autrq.setText(""+sol.getAutr());this.autrr.setText(""+sol.getAutr());
		this.pasq.setText(""+sol.getPas());this.pasr.setText(""+sol.getPas());
		this.confq.setText(""+sol.getConf());this.confr.setText(""+sol.getConf());
		
		
		
		
		try{
			
			rs=stm.executeQuery("select * from requete");
		
			
		while(rs.next()){

			/*this.nipreq.setText(rs.getString(1));
			this.jourreq.setText(rs.getString(2));
			this.sa_48hreq.setSelectedItem(rs.getString(3));
			this.treq.setText(""+rs.getDouble(4));
			this.hyp_tenreq.setSelectedItem(rs.getString(5));
			this.ausreq.setSelectedItem(rs.getString(6));
			this.desreq.setSelectedItem(rs.getString(7));
			this.presence_ktreq.setSelectedItem(rs.getString(8));
			this.ablkt_48hreq.setSelectedItem(rs.getString(9));
			this.infec_local_ktreq.setSelectedItem(rs.getString(10));
			this.secreq.setSelectedItem(rs.getString(11));
			this.m_secreq.setSelectedItem(rs.getString(12));
			this.touxreq.setSelectedItem(rs.getString(13));
			this.dysreq.setSelectedItem(rs.getString(14));
			this.sond_urinairereq.setSelectedItem(rs.getString(15));
			this.pyuriereq.setSelectedItem(rs.getString(16));
			this.brulure_mictionnellereq.setSelectedItem(rs.getString(17));
			this.douleur_sus_pubiennereq.setSelectedItem(rs.getString(18));
			this.frissonsreq.setSelectedItem(rs.getString(19));
			this.leuco_urinairereq.setSelectedItem(rs.getString(20));
			this.gbreq.setText(rs.getString(21));
			this.crpreq.setText(rs.getString(22));
			this.pctreq.setText(rs.getString(23));
			this.rxreq.setSelectedItem(rs.getString(24));*/
			this.nipreq.setText(rs.getString(1));
			this.jourreq.setText(rs.getString(2));
			if (rs.getString(3).equals("true")){ this.sa_48hreq1.setSelected(true);}else {this.sa_48hreq1.setSelected(false);}
			this.treq.setText(""+rs.getString(4));
			if (rs.getString(5).equals("true")){ this.hyp_tenreq1.setSelected(true);}else {this.hyp_tenreq1.setSelected(false);}
			if (rs.getString(6).equals("true")){ this.ausreq1.setSelected(true);}else {this.ausreq1.setSelected(false);}
			if (rs.getString(7).equals("true")){ this.desreq1.setSelected(true);}else {this.desreq1.setSelected(false);}
			if (rs.getString(8).equals("true")){ this.presence_ktreq1.setSelected(true);}else {this.presence_ktreq1.setSelected(false);}
			if (rs.getString(9).equals("true")){ this.ablkt_48hreq1.setSelected(true);}else {this.ablkt_48hreq1.setSelected(false);}
			if (rs.getString(10).equals("true")){ this.infec_local_ktreq1.setSelected(true);}else {this.infec_local_ktreq1.setSelected(false);}
			if (rs.getString(11).equals("true")){ this.secreq1.setSelected(true);}else {this.secreq1.setSelected(false);}
			if (rs.getString(12).equals("true")){ this.m_secreq1.setSelected(true);}else {this.m_secreq1.setSelected(false);}
			if (rs.getString(13).equals("true")){ this.touxreq1.setSelected(true);}else {this.touxreq1.setSelected(false);}
			if (rs.getString(14).equals("true")){ this.dysreq1.setSelected(true);}else {this.dysreq1.setSelected(false);}
			if (rs.getString(15).equals("true")){ this.sond_urinairereq1.setSelected(true);}else {this.sond_urinairereq1.setSelected(false);}
			if (rs.getString(16).equals("true")){ this.pyuriereq1.setSelected(true);}else {this.pyuriereq1.setSelected(false);}
			if (rs.getString(17).equals("true")){ this.brulure_mictionnellereq1.setSelected(true);}else {this.brulure_mictionnellereq1.setSelected(false);}
			if (rs.getString(18).equals("true")){ this.douleur_sus_pubiennereq1.setSelected(true);}else {this.douleur_sus_pubiennereq1.setSelected(false);}
			if (rs.getString(19).equals("true")){ this.frissonsreq1.setSelected(true);}else {this.frissonsreq1.setSelected(false);}
			if (rs.getString(20).equals("true")){ this.leuco_urinairereq1.setSelected(true);}else {this.leuco_urinairereq1.setSelected(false);}
			this.gbreq.setText(rs.getString(21));
			this.crpreq.setText(rs.getString(22));
			this.pctreq.setText(rs.getString(23));
			if (rs.getString(24).equals("true")){ this.pathq.setSelected(true);}else {this.pathq.setSelected(false);}
			
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
}
