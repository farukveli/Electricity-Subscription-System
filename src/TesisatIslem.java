import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TesisatIslem extends JFrame {

	private JPanel contentPane;
	
	public TesisatIslem(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton tesisatKayýt = new JButton("Yeni Tesisat Kay\u0131t");
		tesisatKayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TesisatKayit ekran = new TesisatKayit(conn);
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		tesisatKayýt.setBounds(122, 30, 140, 46);
		panel.add(tesisatKayýt);
		
		JButton tesisatDuzenle = new JButton("Tesisat D\u00FCzenle");
		tesisatDuzenle.setBounds(122, 106, 140, 46);
		panel.add(tesisatDuzenle);
		
		JButton tesisatSil = new JButton("Tesisat Sil");
		tesisatSil.setBounds(122, 182, 140, 46);
		panel.add(tesisatSil);
		
		JButton tesisatKayýt_3 = new JButton("Yeni Tesisat Kay\u0131t");
		tesisatKayýt_3.setBounds(122, 389, 140, 46);
		panel.add(tesisatKayýt_3);
		
		
		
		
	}
}
