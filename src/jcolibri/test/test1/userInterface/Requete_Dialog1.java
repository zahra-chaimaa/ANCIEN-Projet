/**
 * Test1.java
 * jCOLIBRI2 framework. 
 * @author Bourahla Afif.
 * 
 * bourahla.afif@gmail.com
 * 2021
 */
package jcolibri.test.test1.userInterface;
/**
 *@author IB
 * 
 * iratni.basma@yahoo.com
 * 2021
 */

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import jcolibri.cbrcore.CBRQuery;
import jcolibri.test.test1.CasenosoDescription;
import jcolibri.test.test1.Test1;
import jcolibri.test.test1.Test2;
import jcolibri.test.test1.db.HSQLDBserver1;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class Requete_Dialog1 extends JDialog {
	/**
	 * 
	 */
	 JFileChooser jFileChooser1 = new JFileChooser();
	 String att[] =null;
	HSQLDBserver1 con = new HSQLDBserver1();
	Statement stm;
    ResultSet rs,rd;
	private static final long serialVersionUID = 1L;

	private SpinnerNumberModel nombrecas;
	
	private JTextField nip;
	private JTextField jour;
	private JTextField t;
	private JTextField gb;
	private JTextField crp;
	private JTextField pct;
	private JSpinner nh;
	private JCheckBox hyp_ten1;
	private JCheckBox aus1;
	private JCheckBox des1;
	private JCheckBox presence_kt1;
	private JCheckBox ablkt_48h1;
	private JCheckBox sec1;
	private JCheckBox m_sec1;
	private JCheckBox toux1;
	private JCheckBox dys1;
	private JCheckBox sa_48h1;
	private JCheckBox infec_local_kt1;
	private JCheckBox sond_urinaire1;
	private JCheckBox pyurie1;
	private JCheckBox brulure_mictionnelle1;
	private JCheckBox douleur_sus_pubienne1;
	private JCheckBox frissons1;
	private JCheckBox leuco_urinaire1;
	private JCheckBox path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requete_Dialog1 dialog = new Requete_Dialog1(null);
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
	public Requete_Dialog1(JFrame parent)
	{
		
		super(parent,true);
		configureframe();
		try {
			stm = con.obtenirconnexion().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void configureframe(){
		try
		{
			//javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (Exception e1)
		{
		}
		
		this.setTitle("Nouveau Cas");
		setBounds(300, 150, 653, 435);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(0, 0, 0));
		panel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		panel.setBounds(0, 0, 643, 354);
		getContentPane().add(panel);
		
		nombrecas = new SpinnerNumberModel(new Integer(3), new Integer(3), null, new Integer(1));
		panel.setLayout(null);
		
		JLabel lblNombreDeCas = new JLabel("Nombre de cas \u00E0 retenir :");
		lblNombreDeCas.setBounds(10, 322, 156, 17);
		lblNombreDeCas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombreDeCas.setBackground(Color.WHITE);
		panel.add(lblNombreDeCas);
		
		 nh = new JSpinner(new SpinnerNumberModel(new Integer(3), new Integer(3), null, new Integer(1)));
		 nh.setBounds(176, 319, 34, 24);
		nh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(nh);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 627, 300);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Clinique Général", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNip = new JLabel("Nip :");
		lblNip.setBounds(34, 51, 35, 15);
		lblNip.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_1.add(lblNip);
		
		nip = new JTextField();
		nip.setBounds(225, 47, 86, 20);
		nip.setColumns(10);
		panel_1.add(nip);
		
		JLabel lblJour = new JLabel("Jour  :");
		lblJour.setBounds(34, 89, 49, 15);
		lblJour.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_1.add(lblJour);
		
		jour = new JTextField();
		jour.setBounds(225, 85, 86, 20);
		jour.setColumns(10);
		panel_1.add(jour);
		
		JLabel lblLesSymptomesApres = new JLabel("Les symptomes apres 48h :");
		lblLesSymptomesApres.setBounds(34, 127, 175, 15);
		lblLesSymptomesApres.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_1.add(lblLesSymptomesApres);
		
		JLabel lblHypoTension = new JLabel("Hypo tension :");
		lblHypoTension.setBounds(34, 206, 98, 15);
		lblHypoTension.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_1.add(lblHypoTension);
		
		JLabel lblTemprature = new JLabel("Temp\u00E9rature :");
		lblTemprature.setBounds(34, 166, 91, 15);
		lblTemprature.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_1.add(lblTemprature);
		
		t = new JTextField();
		t.setToolTipText("la temp\u00E9rature doit \u00E8tre entre 32 et 42");
		t.setBounds(225, 162, 86, 20);
		t.setColumns(10);
		panel_1.add(t);
		
		sa_48h1 = new JCheckBox("");
		sa_48h1.setBackground(Color.WHITE);
		sa_48h1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sa_48h1.setBounds(225, 122, 22, 23);
		panel_1.add(sa_48h1);
		
		hyp_ten1 = new JCheckBox("");
		hyp_ten1.setBackground(Color.WHITE);
		hyp_ten1.setBounds(225, 201, 22, 23);
		panel_1.add(hyp_ten1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.BLUE);
		tabbedPane.addTab("Clinique spécifique1", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblSecretion = new JLabel("Secretion :   ");
		lblSecretion.setBounds(326, 58, 98, 15);
		lblSecretion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblSecretion);
		
		JLabel lblModificationScretion = new JLabel("Modification S\u00E9cretion :");
		lblModificationScretion.setBounds(326, 98, 189, 15);
		lblModificationScretion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblModificationScretion);
		
		JLabel lblToux = new JLabel("toux :");
		lblToux.setBounds(326, 143, 42, 15);
		lblToux.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblToux);
		
		JLabel lblDyspnet = new JLabel("Dyspn\u00E9e :");
		lblDyspnet.setBounds(326, 178, 63, 15);
		lblDyspnet.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblDyspnet);
		
		JLabel lblAuscultaion = new JLabel("Auscultaion Pathologique :");
		lblAuscultaion.setBounds(10, 58, 195, 15);
		lblAuscultaion.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblAuscultaion);
		
		JLabel lblDsaturation = new JLabel("D\u00E9saturation :");
		lblDsaturation.setBounds(10, 98, 98, 15);
		lblDsaturation.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblDsaturation);
		
		JLabel lblPrsenceCathters = new JLabel("Pr\u00E9sence KT :   ");
		lblPrsenceCathters.setBounds(10, 143, 112, 15);
		lblPrsenceCathters.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblPrsenceCathters);
		
		JLabel lblAblationCathtersh = new JLabel("Ablation KT -48h :   ");
		lblAblationCathtersh.setBounds(10, 175, 147, 15);
		lblAblationCathtersh.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblAblationCathtersh);
		
		JLabel lblInfectionLocalSur = new JLabel("Infection local sur KT :   ");
		lblInfectionLocalSur.setBounds(10, 217, 195, 15);
		lblInfectionLocalSur.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_2.add(lblInfectionLocalSur);
		
		aus1 = new JCheckBox("");
		aus1.setBackground(Color.WHITE);
		aus1.setBounds(208, 50, 19, 23);
		panel_2.add(aus1);
		
		des1 = new JCheckBox("");
		des1.setBackground(Color.WHITE);
		des1.setBounds(208, 93, 19, 23);
		panel_2.add(des1);
		
		presence_kt1 = new JCheckBox("");
		presence_kt1.setBackground(Color.WHITE);
		presence_kt1.setBounds(208, 138, 21, 23);
		panel_2.add(presence_kt1);
		
		ablkt_48h1 = new JCheckBox("");
		ablkt_48h1.setBackground(Color.WHITE);
		ablkt_48h1.setBounds(208, 173, 19, 23);
		panel_2.add(ablkt_48h1);
		
		infec_local_kt1 = new JCheckBox("");
		infec_local_kt1.setBackground(Color.WHITE);
		infec_local_kt1.setBounds(208, 212, 29, 23);
		panel_2.add(infec_local_kt1);
		
		sec1 = new JCheckBox("");
		sec1.setBackground(Color.WHITE);
		sec1.setBounds(516, 58, 24, 23);
		panel_2.add(sec1);
		
		m_sec1 = new JCheckBox("");
		m_sec1.setBackground(Color.WHITE);
		m_sec1.setBounds(515, 93, 25, 23);
		panel_2.add(m_sec1);
		
		toux1 = new JCheckBox("");
		toux1.setBackground(Color.WHITE);
		toux1.setBounds(516, 138, 24, 23);
		panel_2.add(toux1);
		
		dys1 = new JCheckBox("");
		dys1.setBackground(Color.WHITE);
		dys1.setBounds(516, 164, 24, 23);
		panel_2.add(dys1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setForeground(Color.WHITE);
		tabbedPane.addTab("Clinique spécifique2", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblSondageUrinaire = new JLabel("Sondage Urinaire :   ");
		lblSondageUrinaire.setBounds(32, 41, 147, 15);
		lblSondageUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblSondageUrinaire);
		
		JLabel lblPyurie = new JLabel("Pyurie :   ");
		lblPyurie.setBounds(32, 79, 77, 15);
		lblPyurie.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblPyurie);
		
		JLabel lblLeucocyturieUrinaire = new JLabel("Leucocyturie Urinaire :   ");
		lblLeucocyturieUrinaire.setBounds(32, 205, 182, 15);
		lblLeucocyturieUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblLeucocyturieUrinaire);
		
		JLabel lblBrulureMictionnelle = new JLabel("Brulure mictionnelle :   ");
		lblBrulureMictionnelle.setBounds(32, 112, 175, 15);
		lblBrulureMictionnelle.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblBrulureMictionnelle);
		
		JLabel lblDouleurSus = new JLabel("Douleur sus-pubiens :   ");
		lblDouleurSus.setBounds(32, 146, 168, 15);
		lblDouleurSus.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblDouleurSus);
		
		JLabel lblFrisson = new JLabel("Frisson :   ");
		lblFrisson.setBounds(32, 172, 84, 15);
		lblFrisson.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_4.add(lblFrisson);
		
		sond_urinaire1 = new JCheckBox("");
		sond_urinaire1.setBackground(Color.WHITE);
		sond_urinaire1.setBounds(266, 41, 25, 23);
		panel_4.add(sond_urinaire1);
		
		pyurie1 = new JCheckBox("");
		pyurie1.setBackground(Color.WHITE);
		pyurie1.setBounds(266, 79, 25, 23);
		panel_4.add(pyurie1);
		
		brulure_mictionnelle1 = new JCheckBox("");
		brulure_mictionnelle1.setBackground(Color.WHITE);
		brulure_mictionnelle1.setBounds(266, 112, 25, 23);
		panel_4.add(brulure_mictionnelle1);
		
		douleur_sus_pubienne1 = new JCheckBox("");
		douleur_sus_pubienne1.setBackground(Color.WHITE);
		douleur_sus_pubienne1.setBounds(266, 138, 25, 23);
		panel_4.add(douleur_sus_pubienne1);
		
		frissons1 = new JCheckBox("");
		frissons1.setBackground(Color.WHITE);
		frissons1.setBounds(266, 172, 25, 23);
		panel_4.add(frissons1);
		
		leuco_urinaire1 = new JCheckBox("");
		leuco_urinaire1.setBackground(Color.WHITE);
		leuco_urinaire1.setBounds(266, 205, 25, 23);
		panel_4.add(leuco_urinaire1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Biologique", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblGb = new JLabel("GB :");
		lblGb.setBounds(51, 46, 28, 15);
		lblGb.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(lblGb);
		
		gb = new JTextField();
		gb.setToolTipText("les globines blanc doit etre entre 0 et 70mille");
		gb.setBounds(142, 42, 86, 20);
		gb.setColumns(10);
		panel_3.add(gb);
		
		JLabel CRP = new JLabel("CRP :");
		CRP.setBounds(51, 85, 35, 15);
		CRP.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(CRP);
		
		crp = new JTextField();
		crp.setToolTipText("la valeur de CRP doit etre entre 0 et 400");
		crp.setBounds(142, 81, 86, 20);
		crp.setColumns(10);
		panel_3.add(crp);
		
		JLabel PCT = new JLabel("PCT :");
		PCT.setBounds(51, 123, 35, 15);
		PCT.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_3.add(PCT);
		
		pct = new JTextField();
		pct.setToolTipText("la valeur de PCT doit etre entre 0 et 200");
		pct.setBounds(142, 119, 86, 20);
		pct.setColumns(10);
		panel_3.add(pct);
		
		JLabel label = new JLabel("*1.000");
		label.setBounds(260, 45, 46, 14);
		panel_3.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("Radiologique", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblRxDuPneumo = new JLabel("Radio du thorax pathologique : ");
		lblRxDuPneumo.setBounds(24, 82, 233, 19);
		lblRxDuPneumo.setFont(new Font("Consolas", Font.BOLD, 12));
		panel_5.add(lblRxDuPneumo);
		 
		 path = new JCheckBox("");
		 path.setBackground(Color.WHITE);
		 path.setBounds(263, 82, 23, 23);
		 panel_5.add(path);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 353, 637, 43);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		
		JButton btnExecuter = new JButton("Ex\u00E9cuter");
		btnExecuter.setForeground(Color.WHITE);
		btnExecuter.setBackground(Color.MAGENTA);
		btnExecuter.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(218, 112, 214), new Color(218, 112, 214), new Color(218, 112, 214), new Color(218, 112, 214)));
		btnExecuter.setBounds(322, 11, 131, 23);
		panel_7.add(btnExecuter);
		btnExecuter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setForeground(Color.WHITE);
		btnQuitter.setBackground(Color.RED);
		btnQuitter.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(178, 34, 34), new Color(178, 34, 34), new Color(178, 34, 34), new Color(178, 34, 34)));
		btnQuitter.setBounds(515, 11, 112, 23);
		panel_7.add(btnQuitter);
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
		btnQuitter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnVider = new JButton("Vider");
		btnVider.setForeground(Color.WHITE);
		btnVider.setBackground(new Color(0, 191, 255));
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vider();
			}
		});
		btnVider.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		btnVider.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVider.setBounds(10, 11, 112, 23);
		panel_7.add(btnVider);
		//charger des donnees
		JButton btnChargement =  new JButton("Chargement");
		btnChargement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//-------------------------
				if(jFileChooser1.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    DefaultListModel apercu = new DefaultListModel();
                    apercu.removeAllElements();
			        String S=jFileChooser1.getSelectedFile().getPath();
                    File f = new File(S.toString() );
                    OUVRIR(f,apercu);
                    String tb[];
                    
                    att = new String[24];//apercu.getSize()];
                    
                         for(int i=0;i<24/*apercu.getSize()*/;i++)
                         {
                        	 tb     = RecupInfoData(apercu.getElementAt(i).toString());
                        	 att[i] = tb[1];
                        	 System.out.println("Attribut "+i+" ==> "+att[i]);
                         }
                         //------------------------
                         nip.setText(att[0]);
                 	     jour.setText(att[1]);
                    	 if(att[2].equals("true"))sa_48h1.setSelected(true);else sa_48h1.setSelected(false);
                    	 t.setText(att[3]); 
                    	 if(att[4].equals("true"))hyp_ten1.setSelected(true);else hyp_ten1.setSelected(false); 
                    	 if(att[5].equals("true"))aus1.setSelected(true);else aus1.setSelected(false); 
                    	 if(att[6].equals("true"))des1.setSelected(true);else des1.setSelected(false); 
                    	 if(att[7].equals("true"))presence_kt1.setSelected(true);else presence_kt1.setSelected(false); 
                    	 if(att[8].equals("true"))ablkt_48h1.setSelected(true);else ablkt_48h1.setSelected(false); 
                    	 if(att[9].equals("true"))infec_local_kt1.setSelected(true);else infec_local_kt1.setSelected(false); 
                    	 if(att[10].equals("true"))sec1.setSelected(true);else sec1.setSelected(false); 
                    	 if(att[11].equals("true"))m_sec1.setSelected(true);else m_sec1.setSelected(false);
                    	 
                    	 if(att[12].equals("true"))toux1.setSelected(true);else toux1.setSelected(false);
                    	 if(att[13].equals("true"))dys1.setSelected(true);else dys1.setSelected(false);
                    	 if(att[14].equals("true"))sond_urinaire1.setSelected(true);else sond_urinaire1.setSelected(false);
                    	 if(att[15].equals("true"))pyurie1.setSelected(true);else pyurie1.setSelected(false);
                    	 if(att[16].equals("true"))brulure_mictionnelle1.setSelected(true);else brulure_mictionnelle1.setSelected(false);
                    	 if(att[17].equals("true"))douleur_sus_pubienne1.setSelected(true);else douleur_sus_pubienne1.setSelected(false);
                    	 if(att[18].equals("true"))frissons1.setSelected(true);else frissons1.setSelected(false);
                    	 if(att[19].equals("true"))leuco_urinaire1.setSelected(true);else leuco_urinaire1.setSelected(false);
                    	 gb.setText(att[20]);
                 		 crp.setText(att[21]);
                 		 pct.setText(att[22]);
                 		//path.setSelected(false);
                    	if(att[23].equals("true"))path.setSelected(true);else path.setSelected(false);
                    	 
                         //------------------------
				}}}
 
		 );
		btnChargement.setForeground(Color.WHITE);
		btnChargement.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChargement.setBackground(Color.PINK);
		btnChargement.setBounds(161, 11, 112, 23);
		
		panel_7.add(btnChargement);
		btnExecuter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setQuery();
			}
		});


		

	}
	//vider les donnees de l'interface
private void vider(){
	
	nip.setText("");
	jour.setText("");
	//sa_48h.setSelectedIndex(0);
    t.setText("");
   // hyp_ten.setSelectedIndex(0);
  /*  aus1.setSelectedIndex(0);
	des.setSelectedIndex(0);
	presence_kt.setSelectedIndex(0);
	ablkt_48h.setSelectedIndex(0);
	infec_local_kt.setSelectedIndex(0);
	sec.setSelectedIndex(0);
	m_sec.setSelectedIndex(0);
	toux.setSelectedIndex(0);
	dys.setSelectedIndex(0);
	sond_urinaire.setSelectedIndex(0);
	pyurie.setSelectedIndex(0);
	brulure_mictionnelle.setSelectedIndex(0);
	douleur_sus_pubienne.setSelectedIndex(0);
	frissons.setSelectedIndex(0);
	leuco_urinaire.setSelectedIndex(0);*/
	gb.setText("");
	crp.setText("");
	pct.setText("");
	//rx.setSelectedIndex(0);
    nh.setValue(3);
}
//-------------------------------------------------------------------------------

public static String[] RecupInfoData(String attributs)
{
 
String tab[] = null;

 tab = attributs.toString().split(":");
 
 
 return tab;
}

//-------------------------------------------------------------------------------
public static  void OUVRIR(java.io.File fichier,javax.swing.DefaultListModel L)
{
L.removeAllElements();
java.io.BufferedReader IN= null;
String Ligne;

try{
 IN =new java.io.BufferedReader(new java.io.FileReader(fichier));
 while ( (Ligne =IN.readLine())!=null)
   {

        L.addElement(Ligne);
       System.out.println("Ligne : "+Ligne);

    }
 IN.close();

}
 catch (java.io.IOException ec){}
}
//--------------------------------------------------------------------------------
public int getK()
{
	return nombrecas.getNumber().intValue();
}
	void setQuery()
	{
		
		if(t.getText().isEmpty())
		{
			t.setText("-1");
		}else
		{
			double vt = Double.parseDouble(t.getText().toString().trim());
				if ((vt<32)||(vt>42))
		    {
			JOptionPane.showConfirmDialog(null, "La temperature doit etre entre 32 et 42 degre","Erreur",JOptionPane.DEFAULT_OPTION);
			return;
			
		    }	
		}
		

		
		if(gb.getText().isEmpty())
		{
			gb.setText("-1");
		}else 
		{
			double vgb = Double.parseDouble(gb.getText().toString().trim());
			if ((vgb<0)||(vgb>70))
			{
				JOptionPane.showConfirmDialog(null, "Les globines blancs doivent etre entre 0 et 70 mille","Erreur",JOptionPane.DEFAULT_OPTION);
				return;
				
			}
		}
		
		
		
		if(crp.getText().isEmpty())
		{
			crp.setText("-1");
		}else 
		{
			double vcrp = Double.parseDouble(crp.getText().toString().trim());
			if ((vcrp<0)||(vcrp>400))
			{
				JOptionPane.showConfirmDialog(null, "Le crp doit etre entre 0 et 400 ","Erreur",JOptionPane.DEFAULT_OPTION);
				return;
				
			}
		}
		if(pct.getText().isEmpty())
		{
			pct.setText("-1");
		}else 
		{
			double vpct = Double.parseDouble(pct.getText().toString().trim());
			if ((vpct<0)||(vpct>200))
			{
				JOptionPane.showConfirmDialog(null, "Le pct doit etre entre 0 et 200 ","Erreur",JOptionPane.DEFAULT_OPTION);
				return;
				
			}
		}
		this.setVisible(false);
//	stm.executeQuery("DELETE FROM requete");
		
		String req ="Insert into requete (nip,j,sa,t,ht,aus,des,kt,abl,infkt,sec,msec,tou,dys,su,pyu,brm,dsp,fr,lu,gb,crp,pct,rx) values ('"+nip.getText()+"','"+jour.getText()+"','"+
				sa_48h1.isSelected()+"',"+t.getText().trim()+",'"+hyp_ten1.isSelected()+"','"+aus1.isSelected()+"','"+des1.isSelected()+"','"+presence_kt1.isSelected()+"','"+ablkt_48h1.isSelected()+"','"+infec_local_kt1.isSelected()+"','"+sec1.isSelected()+"','"+
				m_sec1.isSelected()+"','"+toux1.isSelected()+"','"+dys1.isSelected()+"','"+
				sond_urinaire1.isSelected()+"','"+pyurie1.isSelected()+"','"+brulure_mictionnelle1.isSelected()+"','"+
				douleur_sus_pubienne1.isSelected()+"','"+frissons1.isSelected()+"','"+leuco_urinaire1.isSelected()+"',"+
				gb.getText().trim()+","+crp.getText().trim()+","+pct.getText().trim()+",'"+path.isSelected()+"');";
		System.out.println("REQ : "+req);
		 try {
			stm.executeQuery(req);
			
				
				rs=stm.executeQuery("select * from requete");
			
				
			while(rs.next()){
				
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(""+rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			System.out.println(rs.getString(9));
			System.out.println(rs.getString(10));
			System.out.println(rs.getString(11));
			System.out.println(rs.getString(12));
			System.out.println(rs.getString(13));
			System.out.println(rs.getString(14));
			System.out.println(rs.getString(15));
			System.out.println(rs.getString(16));
			System.out.println(rs.getString(17));
			System.out.println(rs.getString(18));
			System.out.println(rs.getString(19));
			System.out.println(rs.getString(20));
			System.out.println(""+rs.getString(21));
			System.out.println(""+rs.getString(22));
			System.out.println(""+rs.getString(23));
			System.out.println(rs.getString(24));
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	public CBRQuery getQuery()
	{
		CasenosoDescription desc = new CasenosoDescription();
		
		desc.setNip(this.nip.getText());
		desc.setJ(this.jour.getText());
		if (this.sa_48h1.isSelected()){desc.setSa("true");}else{desc.setSa("false");}
		desc.setT(this.t.getAlignmentX());
		if (this.hyp_ten1.isSelected()){desc.setHt("true");}else{desc.setHt("false");}
		if (this.aus1.isSelected()){desc.setAus("true");}else{desc.setAus("false");}
		if (this.des1.isSelected()){desc.setDes("true");}else{desc.setDes("false");}
		if (this.presence_kt1.isSelected()){desc.setKt("true");}else{desc.setKt("false");}
		if (this.ablkt_48h1.isSelected()){desc.setAbl("true");}else{desc.setAbl("false");}
		if (this.infec_local_kt1.isSelected()){desc.setInfkt("true");}else{desc.setInfkt("false");}
		if (this.sec1.isSelected()){desc.setSec("true");}else{desc.setSec("false");}
		if (this.m_sec1.isSelected()){desc.setMsec("true");}else{desc.setMsec("false");}
		if (this.toux1.isSelected()){desc.setTou("true");}else{desc.setTou("false");}
		if (this.dys1.isSelected()){desc.setDys("true");}else{desc.setDys("false");}
		if (this.sond_urinaire1.isSelected()){desc.setSu("true");}else{desc.setSu("false");}
		if (this.pyurie1.isSelected()){desc.setPyu("true");}else{desc.setPyu("false");}
		if (this.brulure_mictionnelle1.isSelected()){desc.setBrm("true");}else{desc.setBrm("false");}
		if (this.douleur_sus_pubienne1.isSelected()){desc.setDsp("true");}else{desc.setDsp("false");}
		if (this.frissons1.isSelected()){desc.setFr("true");}else{desc.setFr("false");}
		if (this.leuco_urinaire1.isSelected()){desc.setLu("true");}else{desc.setLu("false");}
		desc.setGb(this.gb.getAlignmentX());
		desc.setCrp(this.crp.getAlignmentX());
		desc.setPct(this.pct.getAlignmentX());
		if (this.path.isSelected()){desc.setRx("true");}else{desc.setRx("false");}

		CBRQuery query = new CBRQuery();
		query.setDescription(desc);
		
		
		
		return query;
		
	}
}
