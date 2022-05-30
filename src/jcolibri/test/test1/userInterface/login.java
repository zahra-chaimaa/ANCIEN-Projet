package jcolibri.test.test1.userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jcolibri.cbrcore.CBRQuery;
import jcolibri.test.test1.Test1;
import jcolibri.test.test1.Test2;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField ident;
	private JPasswordField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 648, 512);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ident = new JTextField();
		ident.setBounds(548, 333, 86, 20);
		panel.add(ident);
		ident.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Test2 recommender;
				if(((ident.getText().equals("besma"))&&(mdp.getText().equals("1234")))||
				   ((ident.getText().equals("ikram"))&&(mdp.getText().equals("4321")))||
				   ((ident.getText().equals("karim"))&&(mdp.getText().equals("3107"))))
				   {
					login.this.dispose();
					Test2.recommender = Test2.getInstance();
					//Test2.recommender.showMainFrame();
						
					//Test2.recommender.bou();

						try
						{
							Test2.recommender.configure();
							Test2.recommender.preCycle();
							Requete_Dialog1 qf = new Requete_Dialog1(null);
						
							boolean cont=true;
							while(cont)
							{
								
								qf.setVisible(true);
								
								
								CBRQuery query = qf.getQuery();
								
							
								System.out.println(query.getDescription());
							
								
								
								Test2.recommender.cycle(query,qf.getK());
								
								
						
								int ans = javax.swing.JOptionPane.showConfirmDialog(null, "Le cycle Pour ce cas est fini\n Voulez-vous le répéter?", "Cycle terminé", javax.swing.JOptionPane.YES_NO_OPTION);
							
								cont = (ans == javax.swing.JOptionPane.YES_OPTION);
								
							}
							
							Test2.recommender.postCycle();
							
							
						}catch(Exception ee)
						{
							
							org.apache.commons.logging.LogFactory.getLog(Test2.class).error(ee);
						
							javax.swing.JOptionPane.showMessageDialog(null, ee.getLocalizedMessage());
						}
						System.exit(0);
						
				
				   }else
			        {
			            JOptionPane.showConfirmDialog(null, "Login ou Mot de passe incorrect...","Erreur",JOptionPane.DEFAULT_OPTION);

			            mdp.setText("");
			            ident.setText("");
			            return;
			        }
			}
		});
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(517, 431, 89, 23);
		panel.add(btnNewButton_2);
		
		mdp = new JPasswordField();
		mdp.setBounds(548, 369, 86, 20);
		panel.add(mdp);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Test2.getInstance().postCycle();
				} catch (Exception ex) {
					org.apache.commons.logging.LogFactory.getLog(Test1.class).error(ex);
				}
				System.exit(-1);
			}
		});
		btnQuitter.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		btnQuitter.setBackground(SystemColor.textHighlight);
		btnQuitter.setBounds(386, 431, 89, 23);
		panel.add(btnQuitter);
		
		JLabel Identifiant = new JLabel("Identifiant : ");
		Identifiant.setFont(new Font("Tahoma", Font.BOLD, 13));
		Identifiant.setBounds(461, 335, 89, 14);
		panel.add(Identifiant);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(437, 371, 113, 14);
		panel.add(lblNewLabel_2);
		
		JLabel photo = new JLabel("");
		photo.setBounds(0, 0, 645, 490);
		panel.add(photo);
		photo.setIcon(new ImageIcon("C:\\Users\\IRATNI Basma\\Desktop\\description\\infection_IRAHACINI\\src\\jcolibri\\test\\test1\\IDP.jpg"));
	}
}



