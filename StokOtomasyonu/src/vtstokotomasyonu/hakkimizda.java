package vtstokotomasyonu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hakkimizda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hakkimizda frame = new hakkimizda();
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
	public hakkimizda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btngeriii = new JButton("");
		btngeriii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu ekran = new menu();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		btngeriii.setIcon(new ImageIcon("C:\\Users\\vahit\\Desktop\\Back-2-2-icon.png"));
		btngeriii.setBounds(800, 10, 48, 48);
		contentPane.add(btngeriii);
		
		JLabel lblNewLabel = new JLabel("G\u00F6rsel Programlama Dersi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(207, 320, 443, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Y\u00F6netim Bili\u015Fim Sistemleri 2. S\u0131n\u0131f");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(184, 188, 502, 82);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Arif Vahit Al\u0131\u00E7 19410051020\r\n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(91, 40, 681, 161);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblProjeyiHazrlayan = new JLabel(new ImageIcon("C:\\Users\\vahit\\Desktop\\aaa1.jpg"));
		lblProjeyiHazrlayan.setText("Hakk\u0131m\u0131zda");
		lblProjeyiHazrlayan.setBounds(0, 0, 884, 611);
		contentPane.add(lblProjeyiHazrlayan);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(107, 343, 45, 13);
		contentPane.add(lblNewLabel_1);
	}
}
