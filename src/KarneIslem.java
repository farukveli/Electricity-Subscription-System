import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class KarneIslem extends JFrame {

	private JPanel contentPane;
	private JTextField karne_sil_txt;

	
	public KarneIslem(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 341, 398, 108);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 364, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 398, 438);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		
		JButton karneDuzenle = new JButton("Karne D\u00FCzenle");
		karneDuzenle.setBounds(119, 68, 141, 46);
		karneDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneDuzenle karne = new KarneDuzenle(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		
		panel_1.add(karneDuzenle);
		
		JButton karneKayýt = new JButton("Yeni Karne Kay\u0131t");
		karneKayýt.setBounds(119, 11, 141, 46);
		karneKayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneKayit karne = new KarneKayit(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		panel_1.add(karneKayýt);
		
		JButton karne_sil = new JButton("Karne Sil");
		karne_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		karne_sil.setBounds(119, 128, 141, 46);
		panel_1.add(karne_sil);
		
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu ana = new AnaMenu(conn);
				ana.setVisible(true);
				setVisible(false);
			}
		});
		geri_don.setBounds(119, 51, 141, 46);
		panel.add(geri_don);
		
		JButton geri_don_2 = new JButton("Geri D\u00F6n");
		geri_don_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel.setVisible(true);
				panel_1.setVisible(true);
			}
		});
		geri_don_2.setBounds(128, 381, 141, 46);
		panel_2.add(geri_don_2);
		
		
		JLabel lblNewLabel = new JLabel("Silmek \u0130stedi\u011Finiz Karne No'yu Giriniz:");
		lblNewLabel.setBounds(10, 11, 220, 40);
		panel_2.add(lblNewLabel);
		
		karne_sil_txt = new JTextField();
		karne_sil_txt.setHorizontalAlignment(SwingConstants.CENTER);
		karne_sil_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		karne_sil_txt.setBounds(248, 14, 102, 32);
		panel_2.add(karne_sil_txt);
		karne_sil_txt.setColumns(10);
		
		JButton sil = new JButton("Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Karneler().karne_sil(conn, Integer.parseInt(karne_sil_txt.getText()));
			}
		});
		sil.setBounds(248, 57, 102, 32);
		panel_2.add(sil);
		

	}
}
