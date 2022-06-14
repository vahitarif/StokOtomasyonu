package vtstokotomasyonu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class musteriler extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelm = new DefaultTableModel();
	
	Object[] kolonlar = {"Müþteri Ýd","Ad","Soyad","Telefon","Ödeme Türü","Alýnan Ürün"};
	Object [] satirlar = new Object[6];
	private JTextField tmid;
	private JTextField tad;
	private JTextField tsoyad;
	private JTextField ttelefon;
	private JTextField tmusodeme;
	private JTextField tsatilan;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteriler frame = new musteriler();
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
	public musteriler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btngeri = new JButton("");
		btngeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu ekran = new menu();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		btngeri.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Back-2-2-icon.png"));
		btngeri.setFont(new Font("Tahoma", Font.BOLD, 14));
		btngeri.setBounds(800, 10, 48, 48);
		contentPane.add(btngeri);
		
		JLabel lblNewLabel = new JLabel("M\u00FC\u015Fteriler");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(81, 10, 709, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 70, 836, 268);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelm.setColumnIdentifiers(kolonlar);
		
		table.setBounds(279, 376, 366, 214);
		scrollPane.setViewportView(table);
		
		JButton listelebutton = new JButton("Listele");
		listelebutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Document-icon.png"));
		listelebutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		listelebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelm.setRowCount(0);
				ResultSet mrs = baglantii.yap();
				
				try {
					while(mrs.next()) {
						satirlar[0] = mrs.getString("musteri_id");
						satirlar[1] = mrs.getString("ad");
						satirlar[2] = mrs.getString("soyad");
						satirlar[3] = mrs.getString("telefon");
						satirlar[4] = mrs.getInt("musteri_odemeler");
						satirlar[5] = mrs.getInt("musteri_satilanurun");
						modelm.addRow(satirlar);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				table.setModel(modelm);
				
			}
		});
		listelebutton.setBounds(668, 361, 190, 53);
		contentPane.add(listelebutton);
		
		tad = new JTextField();
		tad.setBounds(22, 402, 386, 32);
		contentPane.add(tad);
		tad.setColumns(10);
		
		tsoyad = new JTextField();
		tsoyad.setBounds(22, 441, 386, 31);
		contentPane.add(tsoyad);
		tsoyad.setColumns(10);
		
		ttelefon = new JTextField();
		ttelefon.setBounds(22, 482, 386, 32);
		contentPane.add(ttelefon);
		ttelefon.setColumns(10);
		
		tmusodeme = new JTextField();
		tmusodeme.setBounds(22, 526, 386, 36);
		contentPane.add(tmusodeme);
		tmusodeme.setColumns(10);
		
		tsatilan = new JTextField();
		tsatilan.setBounds(22, 572, 386, 31);
		contentPane.add(tsatilan);
		tsatilan.setColumns(10);

		tmid = new JTextField();
		tmid.setBounds(22, 361, 386, 31);
		contentPane.add(tmid);
		tmid.setColumns(10);	
		
		JButton kaydetbutton = new JButton("Kaydet");
		kaydetbutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\save-icon.png"));
		kaydetbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		kaydetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String  m_id,ad,soyad,telefon,odeme,alýnan_ürün,sql_string;
				
				m_id = tmid.getText();
				ad = tad.getText();
				soyad = tsoyad.getText();
				telefon = ttelefon.getText();
				odeme = tmusodeme.getText();
				alýnan_ürün = tsatilan.getText();
				
				sql_string = "INSERT INTO tblmusteriler (musteri_id,ad, soyad, telefon, musteri_odemeler,musteri_satilanurun)\r\n"
						+ "VALUES ('"+m_id+"','"+ad+"', '"+soyad+"', '"+telefon+"', '"+odeme+"', '"+alýnan_ürün+"')";
				
				baglantii.yenimusteri(sql_string);
				
			}
		});
		kaydetbutton.setBounds(668, 421, 190, 53);
		contentPane.add(kaydetbutton);
		
		JLabel adlabel = new JLabel("Ad");
		adlabel.setHorizontalAlignment(SwingConstants.CENTER);
		adlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		adlabel.setBounds(418, 402, 102, 32);
		contentPane.add(adlabel);
		
		JLabel soyadlabel = new JLabel("Soyad");
		soyadlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		soyadlabel.setHorizontalAlignment(SwingConstants.CENTER);
		soyadlabel.setBounds(418, 441, 101, 31);
		contentPane.add(soyadlabel);
		
		JLabel telefonlabel = new JLabel("Telefon");
		telefonlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		telefonlabel.setHorizontalAlignment(SwingConstants.CENTER);
		telefonlabel.setBounds(418, 483, 102, 31);
		contentPane.add(telefonlabel);
		
		JLabel odemelabel = new JLabel("\u00D6deme");
		odemelabel.setHorizontalAlignment(SwingConstants.CENTER);
		odemelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		odemelabel.setBounds(418, 526, 102, 36);
		contentPane.add(odemelabel);
		
		JLabel alinanurunlabel = new JLabel("Al\u0131nan \u00DCr\u00FCn");
		alinanurunlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		alinanurunlabel.setHorizontalAlignment(SwingConstants.CENTER);
		alinanurunlabel.setBounds(418, 572, 126, 31);
		contentPane.add(alinanurunlabel);
		
		JLabel idlabel = new JLabel("\u0130D");
		idlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(418, 361, 102, 31);
		contentPane.add(idlabel);
		
		JButton guncellebutton = new JButton("G\u00FCncelle");
		guncellebutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Actions-edit-redo-icon.png"));
		guncellebutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		guncellebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  m_id,ad,soyad,telefon,odeme,alýnan_ürün,sql_string;
				
				m_id = tmid.getText(); 
				ad = tad.getText();
				soyad = tsoyad.getText();
				telefon = ttelefon.getText();
				odeme = tmusodeme.getText();
				alýnan_ürün = tsatilan.getText();
				
				sql_string ="update tblmusteriler set musteri_id="+m_id+","+
						"ad='"+ad+"',soyad='"+soyad+
						"',telefon='"+telefon+
						"',musteri_odemeler='"+odeme+
						"',musteri_satilanurun='"+alýnan_ürün+"'where musteri_id " +m_id;
				baglantii.musteriguncelleme(sql_string);
			}
		});
		guncellebutton.setBounds(668, 487, 190, 53);
		contentPane.add(guncellebutton);
		
		JButton silbutton = new JButton("Sil");
		silbutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Downloads\\Trash-empty-icon.png"));
		silbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		silbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m_id,sql_string;
				
				m_id = tmid.getText();
								
				sql_string ="delete from tblmusteriler where musteri_id = "+m_id;
				
				baglantii.musterisilme(sql_string);
				
			}
		});
		silbutton.setBounds(668, 550, 190, 53);
		contentPane.add(silbutton);
		
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\vahit\\Desktop\\aaa1.jpg"));
		background.setBounds(0, 0, 884, 611);
		contentPane.add(background);
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tmid.setText((String) modelm.getValueAt(table.getSelectedRow(), 0));
				tad.setText((String) modelm.getValueAt(table.getSelectedRow(), 1));
				tsoyad.setText((String) modelm.getValueAt(table.getSelectedRow(), 2));
				ttelefon.setText((String) modelm.getValueAt(table.getSelectedRow(), 3));
				tmusodeme.setText((String) modelm.getValueAt(table.getSelectedRow(), 4).toString());
				tsatilan.setText((String) modelm.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		
		
		//contentPane.add(table);
	}
}
