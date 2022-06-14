package vtstokotomasyonu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class girisekranii extends JFrame {

	private JPanel contentPane;
	private JTextField tadminad;
	private JTextField tadminsifre;
	private JLabel basliklabel;
	static String kullaniciadi;
	static String kullanicisifre;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisekranii frame = new girisekranii();
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
	public girisekranii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminadlabel = new JLabel("Admin Ad");
		adminadlabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminadlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		adminadlabel.setBounds(450, 216, 122, 37);
		contentPane.add(adminadlabel);
		
		JLabel lblAdminifre = new JLabel("Admin \u015Eifre");
		lblAdminifre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminifre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminifre.setBounds(450, 288, 122, 37);
		contentPane.add(lblAdminifre);
		
		basliklabel = new JLabel("Stok Otomasyonu Kullan\u0131c\u0131 Giri\u015Fi");
		basliklabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		basliklabel.setHorizontalAlignment(SwingConstants.CENTER);
		basliklabel.setBounds(110, 25, 661, 57);
		contentPane.add(basliklabel);
		
		tadminad = new JTextField();
		tadminad.setBounds(627, 214, 203, 39);
		contentPane.add(tadminad);
		tadminad.setColumns(10);
		
		tadminsifre = new JTextField();
		tadminsifre.setBounds(627, 288, 203, 39);
		contentPane.add(tadminsifre);
		tadminsifre.setColumns(10);
		
		JButton girisbutton = new JButton("Giri\u015F");
		girisbutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\User-Interface-Enter-icon.png"));
		girisbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciadi = tadminad.getText();
				kullanicisifre = tadminsifre.getText();
				
				String sql_string= "select count(admin_id)as giris from tbladmin where kullanici_adi='"+kullaniciadi+"' and sifre='"+kullanicisifre+"'";
				
				ResultSet mrs = baglantii.yap();
				mrs = baglantii.sorgu(sql_string);
				
				try {
					while (mrs.next()) {
						if(mrs.getInt("giris")==1) {
							menu ekr = new menu();
							ekr.setVisible(true);
							setVisible(false);
						}else {girisbutton.setText("Hata");}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		girisbutton.setFont(new Font("Tahoma", Font.BOLD, 30));
		girisbutton.setBounds(447, 385, 383, 73);
		contentPane.add(girisbutton);
		
		background = new JLabel(new ImageIcon("C:\\Users\\vahit\\Desktop\\bg2.jpg"));
		background.setBounds(0, 0, 884, 611);
		contentPane.add(background);
		
		
	}
}
