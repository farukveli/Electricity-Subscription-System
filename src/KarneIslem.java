import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class KarneIslem extends JFrame {

	private JPanel contentPane;

	
	public KarneIslem(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton karneDuzenle = new JButton("Karne D\u00FCzenle");
		karneDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneDuzenle karne = new KarneDuzenle(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		karneDuzenle.setBounds(133, 129, 141, 46);
		contentPane.add(karneDuzenle);
		
		JButton karneKayýt = new JButton("Yeni Karne Kay\u0131t");
		karneKayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneKayit karne = new KarneKayit(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		karneKayýt.setBounds(133, 55, 141, 46);
		contentPane.add(karneKayýt);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu ana = new AnaMenu(conn);
				setVisible(false);
				ana.setVisible(true);
			}
		});
		geri_don.setBounds(133, 339, 141, 46);
		contentPane.add(geri_don);
	}
}
