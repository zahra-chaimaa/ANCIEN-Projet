package jcolibri.test.test1.userInterface;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import jcolibri.cbrcore.CBRCase;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.test.test1.CasenosoDescription;
import jcolibri.test.test1.CasenosoSolution;
import jcolibri.test.test1.db.HSQLDBserver1;
import jcolibri.test.test1.Test2;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;

public class Retenir_Query1 extends JDialog {

	/**
	 * Launch the application.
	 */
	private static int numcases = 0;
	HSQLDBserver1 con = new HSQLDBserver1();
	Statement stm,stm1;
    ResultSet rs,rd;
	SpinnerNumberModel agec;
	SpinnerNumberModel poidsc;
	SpinnerNumberModel gsc;
	SpinnerNumberModel ager;
	SpinnerNumberModel poidsr;
	SpinnerNumberModel gsr;
	ArrayList<CBRCase> cases;
	int currentCase;
	ArrayList<CBRCase> casesToRetain;
	private JPanel jPanel3;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JTextField pr;
	private JTextField ur;
	private JTextField br;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel3;
	private JTextField confr;
	private JTextField sktr;
	private JTextField autrr;
	private JLabel jLabel10;
	private JTextField pasr;
	private JTextField nipreq;
	private JTextField jourreq;
	private JTextField treq;
	private JPanel panel;
	private JLabel lblSecretion;
	private JLabel lblModificationScretion;
	private JLabel lblToux;
	private JLabel lblDyspnet;
	private JLabel lblAuscultaion;
	private JLabel lblDsaturation;
	private JLabel lblPrsenceCathters;
	private JLabel lblAblationCathtersh;
	private JLabel lblInfectionLocalSur;
	private JPanel panel_2;
	private JLabel lblSondageUrinaire;
	private JLabel lblPyurie;
	private JLabel lblLeucocyturieUrinaire;
	private JLabel lblBrulureMictionnelle;
	private JLabel lblDouleurSus;
	private JLabel lblFrisson;
	private JPanel panel_3;
	private JLabel lblGb;
	private JTextField gbreq;
	private JLabel CRP;
	private JTextField crpreq;
	private JLabel PCT;
	private JTextField pctreq;
	private JPanel panel_4;
	private JLabel lblRxDuPneumo;
	private JComboBox sa_48hreq;
	private JComboBox hyp_tenreq;
	private JSpinner idEditor;
	private JCheckBox sa_48hreq1;
	private JCheckBox hyp_tenreq1;
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
	private JCheckBox path;
	private JLabel idedi;


	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retenir_Query1 dialog = new Retenir_Query1(null);
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
	public Retenir_Query1(JFrame main)
	{
		super(main,true);
		//setOpacity(22.0f);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(240, 240, 240));
		getContentPane().setBackground(Color.WHITE);
		
		try {
			stm = con.obtenirconnexion().createStatement();
			showCase();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(280,100, 639, 595);
		try
		{
			//javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (Exception e1)
		{
		}
		/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
		this.setTitle("Retention de la requete");
		getContentPane().setLayout(null);
		agec = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		poidsc = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		gsc = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		ager =new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		poidsr = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		gsr = new SpinnerNumberModel(new Integer(0), null, null, new Integer(0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 514, 606, 42);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRetenir = new JButton("Retenir");
		btnRetenir.setForeground(Color.WHITE);
		btnRetenir.setBackground(new Color(219, 112, 147));
		btnRetenir.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 20, 147), new Color(255, 20, 147), new Color(255, 20, 147), new Color(255, 20, 147)));
		btnRetenir.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnRetenir.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent arg0) {
				 
			

				try {
					
					stm.executeQuery("insert into basecase values('"+idedi.getText()+"','"+nipreq.getText()+"','"+jourreq.getText()+"',"
							+"'"+sa_48hreq1.isSelected()+"','"+treq.getText().trim()+"','"+hyp_tenreq1.isSelected()+"','"+ausreq1.isSelected()+"','"+desreq1.isSelected()+"','"+presence_ktreq1.isSelected()+"','"+ablkt_48hreq1.isSelected()+"','"+infec_local_ktreq1.isSelected()+"','"+secreq1.isSelected()+"',"
							 +"'"+m_secreq1.isSelected()+"','"+touxreq1.isSelected()+"','"+dysreq1.isSelected()+"',"
							 +"'"+sond_urinairereq1.isSelected()+"','"+pyuriereq1.isSelected()+"','"+brulure_mictionnellereq1.isSelected()+"',"
							 +"'"+douleur_sus_pubiennereq1.isSelected()+"','"+frissonsreq1.isSelected()+"','"+leuco_urinairereq1.isSelected()+"',"
							 +"'"+gbreq.getText().trim()+"','"+crpreq.getText().trim()+"','"+pctreq.getText().trim()+"',"
							 		+ "'"+path.isSelected()+"','"+pr.getText()+"','"+ur.getText()+"','"+br.getText()+"','"+sktr.getText()+"','"+autrr.getText()+"','"+pasr.getText()+"','"+confr.getText()+"');");
							
							
							
							
							
							
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vis();}
			
		});
				
		btnRetenir.setBounds(52, 11, 143, 23);
		panel_1.add(btnRetenir);
		
		JButton btnRpeter = new JButton("R\u00E9p\u00E9ter");
		btnRpeter.setForeground(Color.WHITE);
		btnRpeter.setBackground(new Color(221, 160, 221));
		btnRpeter.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(148, 0, 211), new Color(148, 0, 211), new Color(148, 0, 211), new Color(148, 0, 211)));
		btnRpeter.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnRpeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vis();
			} 
		});
		btnRpeter.setBounds(267, 11, 134, 23);
		panel_1.add(btnRpeter);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setForeground(Color.WHITE);
		btnQuitter.setBackground(Color.RED);
		btnQuitter.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 0, 0), new Color(128, 0, 0), new Color(128, 0, 0), new Color(128, 0, 0)));
		btnQuitter.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Test2.getInstance().postCycle();
				} catch (Exception ex) {
					org.apache.commons.logging.LogFactory.getLog(Test2.class).error(ex);
				}
				System.exit(-1);
			}
		});
		btnQuitter.setBounds(462, 11, 134, 23);
		panel_1.add(btnQuitter);
		
		jPanel3 = new JPanel();
		jPanel3.setBackground(new Color(255, 255, 255));
		jPanel3.setForeground(new Color(255, 255, 255));
		jPanel3.setBounds(10, 324, 606, 190);
		getContentPane().add(jPanel3);
		
		jLabel5 = new JLabel();
		jLabel5.setBounds(10, 68, 214, 17);
		jLabel5.setText("Infection Urinaire nosocomiale");
		jLabel5.setFont(new Font("Consolas", Font.BOLD, 11));
		
		jLabel4 = new JLabel();
		jLabel4.setBounds(10, 35, 221, 22);
		jLabel4.setText("Infection Pneumopathie nosocomiale");
		jLabel4.setFont(new Font("Consolas", Font.BOLD, 11));
		
		jLabel6 = new JLabel();
		jLabel6.setBounds(10, 94, 221, 17);
		jLabel6.setText("Infection Bact\u00E9riemie nosocomiale");
		jLabel6.setFont(new Font("Consolas", Font.BOLD, 11));
		
		pr = new JTextField();
		pr.setBounds(261, 35, 29, 20);
		
		ur = new JTextField();
		ur.setBounds(261, 65, 29, 20);
		
		br = new JTextField();
		br.setBounds(261, 91, 29, 20);
		
		jLabel9 = new JLabel();
		jLabel9.setBounds(334, 68, 175, 17);
		jLabel9.setText("Pas d'infection nosocomiales");
		jLabel9.setFont(new Font("Consolas", Font.BOLD, 11));
		
		jLabel8 = new JLabel();
		jLabel8.setBounds(334, 38, 131, 17);
		jLabel8.setText("Autres Infection");
		jLabel8.setFont(new Font("Consolas", Font.BOLD, 11));
		
		jLabel7 = new JLabel();
		jLabel7.setBounds(10, 124, 260, 17);
		jLabel7.setText("Infection li\u00E9es aux Cath\u00E9ters nosocomiale");
		jLabel7.setFont(new Font("Consolas", Font.BOLD, 11));
		
		jLabel3 = new JLabel();
		jLabel3.setBounds(241, 0, 83, 22);
		jLabel3.setText("Resultas");
		jLabel3.setFont(new Font("Consolas", Font.BOLD, 11));
		jLabel3.setBackground(new Color(153, 153, 0));
		
		confr = new JTextField();
		confr.setBounds(529, 91, 29, 20);
		
		sktr = new JTextField();
		sktr.setBounds(261, 121, 29, 20);
		
		autrr = new JTextField();
		autrr.setBounds(529, 35, 29, 20);
		
		jLabel10 = new JLabel();
		jLabel10.setBounds(334, 92, 152, 20);
		jLabel10.setText("Confirmer l'infection");
		jLabel10.setFont(new Font("Consolas", Font.BOLD, 11));
		
		pasr = new JTextField();
		pasr.setBounds(530, 65, 29, 20);
		jPanel3.setLayout(null);
		jPanel3.add(jLabel5);
		jPanel3.add(jLabel4);
		jPanel3.add(jLabel6);
		jPanel3.add(jLabel3);
		jPanel3.add(pr);
		jPanel3.add(ur);
		jPanel3.add(br);
		jPanel3.add(jLabel9);
		jPanel3.add(jLabel7);
		jPanel3.add(jLabel8);
		jPanel3.add(jLabel10);
		jPanel3.add(autrr);
		jPanel3.add(confr);
		jPanel3.add(sktr);
		jPanel3.add(pasr);
		
		JLabel lblCasN = new JLabel("Cas N\u00B0:");
		lblCasN.setBounds(391, 155, 46, 27);
		lblCasN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCasN.setBackground(Color.WHITE);
		jPanel3.add(lblCasN);
		
		JLabel an = new JLabel("");
		an.setBounds(72, 10, 46, 14);
		jPanel3.add(an);
		
		idedi = new JLabel("");
		idedi.setBackground(Color.CYAN);
		idedi.setBounds(440, 155, 46, 30);
		jPanel3.add(idedi);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 606, 313);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setToolTipText("Clinique Générale");
		panel_1_1.setLayout(null);
		tabbedPane.addTab("Clinique Général", null, panel_1_1, null);
		
		JLabel lblNip = new JLabel("Nip :");
		lblNip.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNip.setBounds(28, 49, 35, 15);
		panel_1_1.add(lblNip);
		
		nipreq = new JTextField();
		nipreq.setColumns(10);
		nipreq.setBounds(207, 45, 86, 20);
		panel_1_1.add(nipreq);
		
		JLabel lblJour = new JLabel("Jour  :");
		lblJour.setFont(new Font("Consolas", Font.BOLD, 12));
		lblJour.setBounds(28, 90, 49, 15);
		panel_1_1.add(lblJour);
		
		jourreq = new JTextField();
		jourreq.setColumns(10);
		jourreq.setBounds(207, 86, 86, 20);
		panel_1_1.add(jourreq);
		
		JLabel lblLesSymptomesApres = new JLabel("Les symptomes apres 48h :");
		lblLesSymptomesApres.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLesSymptomesApres.setBounds(28, 126, 175, 15);
		panel_1_1.add(lblLesSymptomesApres);
		
		JComboBox sa_48hreq = new JComboBox();
		sa_48hreq.setBackground(Color.WHITE);
		sa_48hreq.setModel(new DefaultComboBoxModel(new String[] {"", "oui", "non"}));
		sa_48hreq.setFont(new Font("Consolas", Font.BOLD, 12));
		sa_48hreq.setBounds(155, 253, 6, 21);
		panel_1_1.add(sa_48hreq);
		
		JLabel lblHypoTension = new JLabel("Hypo tension :");
		lblHypoTension.setFont(new Font("Consolas", Font.BOLD, 12));
		lblHypoTension.setBounds(28, 212, 98, 15);
		panel_1_1.add(lblHypoTension);
		
		JComboBox hyp_tenreq = new JComboBox();
		hyp_tenreq.setBackground(Color.WHITE);
		hyp_tenreq.setModel(new DefaultComboBoxModel(new String[] {"", "oui", "non"}));
		hyp_tenreq.setFont(new Font("Consolas", Font.BOLD, 12));
		hyp_tenreq.setBounds(155, 253, 6, 21);
		panel_1_1.add(hyp_tenreq);
		
		JLabel lblTemprature = new JLabel("Temp\u00E9rature :");
		lblTemprature.setFont(new Font("Consolas", Font.BOLD, 12));
		lblTemprature.setBounds(28, 175, 91, 15);
		panel_1_1.add(lblTemprature);
		
		treq = new JTextField();
		treq.setColumns(10);
		treq.setBounds(207, 171, 86, 20);
		panel_1_1.add(treq);
		
		sa_48hreq1 = new JCheckBox("");
		sa_48hreq1.setBackground(Color.WHITE);
		sa_48hreq1.setBounds(207, 118, 27, 23);
		panel_1_1.add(sa_48hreq1);
		
		hyp_tenreq1 = new JCheckBox("");
		hyp_tenreq1.setBackground(Color.WHITE);
		hyp_tenreq1.setBounds(207, 204, 27, 23);
		panel_1_1.add(hyp_tenreq1);
		panel_1_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNip, nipreq, lblJour, jourreq, lblLesSymptomesApres, sa_48hreq, lblHypoTension, hyp_tenreq, lblTemprature, treq}));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		tabbedPane.addTab("Clinique specifique1", null, panel, null);
		
		lblSecretion = new JLabel("Secretion :   ");
		lblSecretion.setFont(new Font("Consolas", Font.BOLD, 12));
		lblSecretion.setBounds(310, 58, 98, 15);
		panel.add(lblSecretion);
		
		lblModificationScretion = new JLabel("Modification S\u00E9cretion :");
		lblModificationScretion.setFont(new Font("Consolas", Font.BOLD, 12));
		lblModificationScretion.setBounds(310, 90, 168, 15);
		panel.add(lblModificationScretion);
		
		lblToux = new JLabel("toux :");
		lblToux.setFont(new Font("Consolas", Font.BOLD, 12));
		lblToux.setBounds(310, 130, 42, 15);
		panel.add(lblToux);
		
		lblDyspnet = new JLabel("Dyspn\u00E9e :");
		lblDyspnet.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDyspnet.setBounds(310, 156, 63, 15);
		panel.add(lblDyspnet);
		
		lblAuscultaion = new JLabel("Auscultaion pathologique:");
		lblAuscultaion.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAuscultaion.setBounds(10, 58, 189, 15);
		panel.add(lblAuscultaion);
		
		lblDsaturation = new JLabel("D\u00E9saturation :");
		lblDsaturation.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDsaturation.setBounds(10, 90, 98, 15);
		panel.add(lblDsaturation);
		
		lblPrsenceCathters = new JLabel("Pr\u00E9sence KT :   ");
		lblPrsenceCathters.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPrsenceCathters.setBounds(10, 130, 112, 15);
		panel.add(lblPrsenceCathters);
		
		lblAblationCathtersh = new JLabel("Ablation KT -48h :   ");
		lblAblationCathtersh.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAblationCathtersh.setBounds(10, 166, 168, 15);
		panel.add(lblAblationCathtersh);
		
		lblInfectionLocalSur = new JLabel("Infection local sur KT :   ");
		lblInfectionLocalSur.setFont(new Font("Consolas", Font.BOLD, 12));
		lblInfectionLocalSur.setBounds(10, 192, 189, 15);
		panel.add(lblInfectionLocalSur);
		
		ausreq1 = new JCheckBox("");
		ausreq1.setBackground(Color.WHITE);
		ausreq1.setBounds(211, 50, 24, 23);
		panel.add(ausreq1);
		
		desreq1 = new JCheckBox("");
		desreq1.setBackground(Color.WHITE);
		desreq1.setBounds(211, 82, 24, 23);
		panel.add(desreq1);
		
		presence_ktreq1 = new JCheckBox("");
		presence_ktreq1.setBackground(Color.WHITE);
		presence_ktreq1.setBounds(211, 122, 24, 23);
		panel.add(presence_ktreq1);
		
		ablkt_48hreq1 = new JCheckBox("");
		ablkt_48hreq1.setBackground(Color.WHITE);
		ablkt_48hreq1.setBounds(211, 156, 21, 23);
		panel.add(ablkt_48hreq1);
		
		infec_local_ktreq1 = new JCheckBox("");
		infec_local_ktreq1.setBackground(Color.WHITE);
		infec_local_ktreq1.setBounds(211, 192, 32, 23);
		panel.add(infec_local_ktreq1);
		
		secreq1 = new JCheckBox("");
		secreq1.setBackground(Color.WHITE);
		secreq1.setBounds(504, 53, 31, 23);
		panel.add(secreq1);
		
		m_secreq1 = new JCheckBox("");
		m_secreq1.setBackground(Color.WHITE);
		m_secreq1.setBounds(506, 85, 29, 23);
		panel.add(m_secreq1);
		
		touxreq1 = new JCheckBox("");
		touxreq1.setBackground(Color.WHITE);
		touxreq1.setBounds(506, 125, 29, 23);
		panel.add(touxreq1);
		
		dysreq1 = new JCheckBox("");
		dysreq1.setBackground(Color.WHITE);
		dysreq1.setBounds(506, 161, 29, 23);
		panel.add(dysreq1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		tabbedPane.addTab("Clinique spécifique2", null, panel_2, null);
		
		lblSondageUrinaire = new JLabel("Sondage Urinaire :   ");
		lblSondageUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		lblSondageUrinaire.setBounds(24, 37, 147, 15);
		panel_2.add(lblSondageUrinaire);
		
		lblPyurie = new JLabel("Pyurie :   ");
		lblPyurie.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPyurie.setBounds(24, 69, 77, 15);
		panel_2.add(lblPyurie);
		
		lblLeucocyturieUrinaire = new JLabel("Leucocyturie Urinaire :   ");
		lblLeucocyturieUrinaire.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLeucocyturieUrinaire.setBounds(24, 224, 182, 15);
		panel_2.add(lblLeucocyturieUrinaire);
		
		lblBrulureMictionnelle = new JLabel("Brulure mictionnelle :   ");
		lblBrulureMictionnelle.setFont(new Font("Consolas", Font.BOLD, 12));
		lblBrulureMictionnelle.setBounds(24, 104, 175, 15);
		panel_2.add(lblBrulureMictionnelle);
		
		lblDouleurSus = new JLabel("Douleur sus-pubiens :   ");
		lblDouleurSus.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDouleurSus.setBounds(24, 143, 168, 15);
		panel_2.add(lblDouleurSus);
		
		lblFrisson = new JLabel("Frisson :   ");
		lblFrisson.setFont(new Font("Consolas", Font.BOLD, 12));
		lblFrisson.setBounds(24, 185, 84, 15);
		panel_2.add(lblFrisson);
		
		sond_urinairereq1 = new JCheckBox("");
		sond_urinairereq1.setBackground(Color.WHITE);
		sond_urinairereq1.setBounds(301, 32, 27, 23);
		panel_2.add(sond_urinairereq1);
		
		pyuriereq1 = new JCheckBox("");
		pyuriereq1.setBackground(Color.WHITE);
		pyuriereq1.setBounds(301, 69, 27, 23);
		panel_2.add(pyuriereq1);
		
		brulure_mictionnellereq1 = new JCheckBox("");
		brulure_mictionnellereq1.setBackground(Color.WHITE);
		brulure_mictionnellereq1.setBounds(301, 99, 27, 23);
		panel_2.add(brulure_mictionnellereq1);
		
		douleur_sus_pubiennereq1 = new JCheckBox("");
		douleur_sus_pubiennereq1.setBackground(Color.WHITE);
		douleur_sus_pubiennereq1.setBounds(301, 138, 27, 23);
		panel_2.add(douleur_sus_pubiennereq1);
		
		frissonsreq1 = new JCheckBox("");
		frissonsreq1.setBackground(Color.WHITE);
		frissonsreq1.setBounds(301, 180, 27, 23);
		panel_2.add(frissonsreq1);
		
		leuco_urinairereq1 = new JCheckBox("");
		leuco_urinairereq1.setBackground(Color.WHITE);
		leuco_urinairereq1.setBounds(301, 219, 27, 23);
		panel_2.add(leuco_urinairereq1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		tabbedPane.addTab("Biologique", null, panel_3, null);
		
		lblGb = new JLabel("GB :");
		lblGb.setFont(new Font("Consolas", Font.BOLD, 12));
		lblGb.setBounds(22, 60, 28, 15);
		panel_3.add(lblGb);
		
		gbreq = new JTextField();
		gbreq.setColumns(10);
		gbreq.setBounds(84, 56, 86, 20);
		panel_3.add(gbreq);
		
		CRP = new JLabel("CRP :");
		CRP.setFont(new Font("Consolas", Font.BOLD, 12));
		CRP.setBounds(22, 101, 35, 15);
		panel_3.add(CRP);
		
		crpreq = new JTextField();
		crpreq.setColumns(10);
		crpreq.setBounds(84, 97, 86, 20);
		panel_3.add(crpreq);
		
		PCT = new JLabel("PCT :");
		PCT.setFont(new Font("Consolas", Font.BOLD, 12));
		PCT.setBounds(22, 143, 35, 15);
		panel_3.add(PCT);
		
		pctreq = new JTextField();
		pctreq.setColumns(10);
		pctreq.setBounds(84, 139, 86, 20);
		panel_3.add(pctreq);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		tabbedPane.addTab("Radiologique", null, panel_4, null);
		
		lblRxDuPneumo = new JLabel("Radio du thorax pathologique:");
		lblRxDuPneumo.setFont(new Font("Consolas", Font.BOLD, 12));
		lblRxDuPneumo.setBounds(24, 86, 217, 16);
		panel_4.add(lblRxDuPneumo);
		
		path = new JCheckBox("");
		path.setBackground(Color.WHITE);
		path.setBounds(266, 86, 26, 23);
		panel_4.add(path);
		
				}
			
	public void showCases(Collection<CBRCase> eval, int casebasesize)
	{
		cases = new ArrayList<CBRCase>(eval);
		casesToRetain = new ArrayList<CBRCase>();
		currentCase = 0;
		if(numcases<casebasesize)
			numcases = casebasesize+1;
		System.out.println("hhdvjbvberuvjbjkebvuiefbv efuvb"+String.valueOf(numcases));
		idedi.setText(String.valueOf(numcases));
		
	
		showCase();
	}
	public void vis(){
	
		this.setVisible(false);
	}
	
	public void showCase()
	{
	/*	RetrievalResult rr = cases.get(currentCase);
		double sim = rr.getEval();
		
		CBRCase _case = rr.get_case();
		this.lblCasRememors.setText(_case.getID().toString()+" -> "+sim+" ("+(currentCase+1)+"/"+cases.size()+")"); */
		
	
		
		try {
			rs=stm.executeQuery("select * from requete");
			rd=stm.executeQuery("select * from solution");
			while(rs.next()){
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
				
				if (rs.getString(24).equals("true")){ this.path.setSelected(true);}else {this.path.setSelected(false);}
			}
		
			while(rd.next()){
				this.pr.setText(rd.getString(1));
				this.ur.setText(rd.getString(2));
				this.br.setText(rd.getString(3));
				this.sktr.setText(rd.getString(4));
				this.pasr.setText(rd.getString(5));
				this.autrr.setText(rd.getString(6));
				this.confr.setText(rd.getString(7));
				

				/*this.nipreq.setText("hhsglshfklbnsfd");
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
				this.gbreq.setText(""+rs.getDouble(21));
				this.crpreq.setText(""+rs.getDouble(22));
				this.pctreq.setText(""+rs.getDouble(23)); 
				this.rxreq.setSelectedItem(rs.getString(24));*/
				}
		
				
				/*System.out.println("this is solution");
				System.out.println(rd.getString(1));
				System.out.println(rd.getString(2));
				System.out.println(rd.getString(3));
				System.out.println(rd.getString(4));
				System.out.println(rd.getString(5));
				System.out.println(rd.getString(6));
				System.out.println(rd.getString(7));*/
				
			
			
		 }
	       catch (SQLException e) {
			// TODO Auto-generated catch block
		   e.printStackTrace();
		}
}	
}
			
		
		
			



