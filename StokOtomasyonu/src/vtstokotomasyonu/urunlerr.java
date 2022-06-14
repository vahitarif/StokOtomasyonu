package vtstokotomasyonu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class urunlerr extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelu = new DefaultTableModel();
	
	Object[] kolon = {"Ürün ÝD","Ürün Model","Ürün Renk","Ürün Cinsiyet"};
	Object[] satir = new Object[4];
	private JTextField turunýd;
	private JTextField turunmodeli;
	private JTextField turunrengi;
	private JTextField turuncinsiyeti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					urunlerr frame = new urunlerr();
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
	public urunlerr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton geributton = new JButton("");
		geributton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu ekran = new menu();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		geributton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Back-2-2-icon.png"));
		geributton.setBounds(797, 10, 48, 48);
		contentPane.add(geributton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(26, 63, 826, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelu.setColumnIdentifiers(kolon);
		modelu.addRow(satir);
		table.setModel(modelu);
		table.setBounds(290, 333, 363, 201);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u00DCr\u00FCnler");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(87, 10, 672, 43);
		contentPane.add(lblNewLabel);
		
		turunýd = new JTextField();
		turunýd.setBounds(185, 305, 204, 54);
		contentPane.add(turunýd);
		turunýd.setColumns(10);
		
		turunmodeli = new JTextField();
		turunmodeli.setBounds(185, 369, 204, 54);
		contentPane.add(turunmodeli);
		turunmodeli.setColumns(10);
		
		turunrengi = new JTextField();
		turunrengi.setBounds(185, 433, 204, 54);
		contentPane.add(turunrengi);
		turunrengi.setColumns(10);
		
		turuncinsiyeti = new JTextField();
		turuncinsiyeti.setBounds(185, 497, 204, 54);
		contentPane.add(turuncinsiyeti);
		turuncinsiyeti.setColumns(10);
		
		JLabel urunidlabel = new JLabel("\u00DCr\u00FCn ID");
		urunidlabel.setHorizontalAlignment(SwingConstants.CENTER);
		urunidlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		urunidlabel.setBounds(10, 305, 157, 54);
		contentPane.add(urunidlabel);
		
		JLabel urunmodellabel = new JLabel("\u00DCr\u00FCn Modeli");
		urunmodellabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		urunmodellabel.setHorizontalAlignment(SwingConstants.CENTER);
		urunmodellabel.setBounds(10, 369, 157, 54);
		contentPane.add(urunmodellabel);
		
		JLabel urunrenklabel = new JLabel("\u00DCr\u00FCn Renk");
		urunrenklabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		urunrenklabel.setHorizontalAlignment(SwingConstants.CENTER);
		urunrenklabel.setBounds(10, 433, 157, 54);
		contentPane.add(urunrenklabel);
		
		JLabel uruncinsiyetlabel = new JLabel("\u00DCr\u00FCn Cinsiyet");
		uruncinsiyetlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		uruncinsiyetlabel.setHorizontalAlignment(SwingConstants.CENTER);
		uruncinsiyetlabel.setBounds(0, 497, 176, 54);
		contentPane.add(uruncinsiyetlabel);
		
		JButton silbutton = new JButton("Sil");
		silbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urunýd,sql_string;
				
				urunýd = turunýd.getText();
								
				sql_string ="delete from tblurunler where urun_id = "+urunýd;
				
				baglantii.musterisilme(sql_string);
			}
		});
		silbutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Downloads\\Trash-empty-icon.png"));
		silbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		silbutton.setBounds(679, 305, 155, 86);
		contentPane.add(silbutton);
		
		JButton kaydetbutton = new JButton("Kaydet");
		kaydetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String urunid,urunmodel,urunrenk,uruncinsiyet,sql_string;
				
				urunid = turunýd.getText();
				urunmodel = turunmodeli.getText();
				urunrenk = turunrengi.getText();
				uruncinsiyet = turuncinsiyeti.getText();
				
				
				sql_string = "INSERT INTO tblurunler (urun_id,urunler_urunmodeli, urunler_renk, urunler_cinsiyet)\r\n"
						+ "VALUES ('"+urunid+"','"+urunmodel+"', '"+urunrenk+"', '"+uruncinsiyet+"')";
				
				baglantii.yenimusteri(sql_string);
				
			}
		});
		kaydetbutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\save-icon.png"));
		kaydetbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		kaydetbutton.setBounds(446, 305, 155, 86);
		contentPane.add(kaydetbutton);
		
		JButton guncellebutton = new JButton("G\u00FCncelle");
		guncellebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urunid,urunmodel,urunrenk,uruncinsiyet,sql_string;
				
				urunid = turunýd.getText();
				urunmodel = turunmodeli.getText();
				urunrenk = turunrengi.getText();
				uruncinsiyet = turuncinsiyeti.getText();
				
				sql_string ="UPDATE tblurunler SET urun_id="+urunid+","+
						"urunler_urunmodeli='"+urunmodel+"',urunler_renk='"+urunrenk+
						"',urunler_cinsiyet='"+uruncinsiyet+"'where urun_id"+urunid;
				
				System.out.println(sql_string);
	
						
				baglantii.musteriguncelleme(sql_string);
				
			}
		});
		guncellebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		guncellebutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\reload-icon (1).png"));
		guncellebutton.setBounds(446, 469, 155, 86);
		contentPane.add(guncellebutton);
		
		JButton bilgibutton = new JButton("Bilgi");
		bilgibutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bilgi ekran = new bilgi();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		bilgibutton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Information-icon.png"));
		bilgibutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		bilgibutton.setBounds(679, 469, 155, 86);
		contentPane.add(bilgibutton);
		
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\vahit\\Desktop\\aaa1.jpg"));
		background.setBounds(0, 0, 884, 611);
		contentPane.add(background);
		//contentPane.add(table);
		baglanListele();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turunýd.setText((String) modelu.getValueAt(table.getSelectedRow(),0).toString());
				turunmodeli.setText((String) modelu.getValueAt(table.getSelectedRow(), 1).toString());;
				turunrengi.setText((String) modelu.getValueAt(table.getSelectedRow(), 2).toString());
				turuncinsiyeti.setText((String) modelu.getValueAt(table.getSelectedRow(), 3).toString());
			}
		});
	}

	
	void baglanListele() {
        baglantii.yap();
        String listeleSql = "select*from tblurunler";
        ResultSet mrs = baglantii.sorgu(listeleSql);

        modelu.setColumnCount(0);
        modelu.setRowCount(0);
        modelu.setColumnIdentifiers(kolon);


        try {
            while (mrs.next()) {
                satir[0] = mrs.getInt("urun_id");
                satir[1] = mrs.getInt("urunler_urunmodeli");
                satir[2] = mrs.getInt("urunler_renk");
                satir[3] = mrs.getInt("urunler_cinsiyet");
                
                modelu.addRow(satir);

            }
            table.setModel(modelu);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
}
