package vtstokotomasyonu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Hakk\u0131m\u0131zda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hakkimizda ekran3 = new hakkimizda();
				ekran3.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girisekranii ekran = new girisekranii();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Back-2-2-icon.png"));
		btnNewButton.setBounds(801, 27, 48, 48);
		contentPane.add(btnNewButton);
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\User-blue-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(317, 386, 214, 73);
		contentPane.add(btnNewButton_1);
		
		JButton urunyonlendirme = new JButton("\u00DCr\u00FCn Bilgi");
		urunyonlendirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urunlerr ekran2 = new urunlerr();
				ekran2.setVisible(true);
				setVisible(false);
			}
		});
		urunyonlendirme.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\sale-icon.png"));
		urunyonlendirme.setBackground(new Color(128, 128, 0));
		urunyonlendirme.setFont(new Font("Tahoma", Font.BOLD, 15));
		urunyonlendirme.setBounds(505, 233, 214, 73);
		contentPane.add(urunyonlendirme);
		
		JButton musteriyonlendirme = new JButton("M\u00FC\u015Fteri Bilgi");
		musteriyonlendirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteriler ekran = new musteriler();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		musteriyonlendirme.setBackground(new Color(128, 128, 0));
		musteriyonlendirme.setFont(new Font("Tahoma", Font.BOLD, 15));
		musteriyonlendirme.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Documents-icon.png"));
		musteriyonlendirme.setBounds(127, 233, 214, 73);
		contentPane.add(musteriyonlendirme);
		
		JLabel lblNewLabel_1 = new JLabel("Arif Vahit Al\u0131\u00E7");
		lblNewLabel_1.setForeground(new Color(128, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(734, 569, 115, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Stok Kontrol Otomasyonu");
		lblNewLabel.setForeground(new Color(128, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(131, 27, 602, 73);
		contentPane.add(lblNewLabel);
		
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\vahit\\Desktop\\aaa1.jpg"));
		background.setBounds(0, 0, 884, 611);
		contentPane.add(background);
	}

}
