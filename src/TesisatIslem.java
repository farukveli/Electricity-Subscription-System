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
	private JPanel panel;
	private TesisatKayit tesisat_kayit;
	private TesisatDuzenle tesisat_duzenle;
	
	public TesisatIslem(Connection conn, JPanel ana_menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tesisat_kayit = new TesisatKayit(conn,panel);
		contentPane.add(tesisat_kayit.getPanel());
		tesisat_kayit.getPanel().setLayout(null);
		tesisat_kayit.getPanel().setVisible(false);
		
		tesisat_duzenle = new TesisatDuzenle(conn,panel);
		contentPane.add(tesisat_duzenle.getPanel());
		tesisat_duzenle.getPanel().setLayout(null);
		tesisat_duzenle.getPanel().setVisible(false);
		
		JButton tesisatKayýt = new JButton("Yeni Tesisat Kay\u0131t");
		tesisatKayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		tesisatKayýt.setBounds(122, 30, 140, 46);
		panel.add(tesisatKayýt);
		
		JButton tesisatDuzenle = new JButton("Tesisat D\u00FCzenle");
		tesisatDuzenle.setBounds(122, 106, 140, 46);
		tesisatDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_duzenle.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(tesisatDuzenle);
		
		JButton tesisatSil = new JButton("Tesisat Sil");
		tesisatSil.setBounds(122, 182, 140, 46);
		panel.add(tesisatSil);	
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ana_menu.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		
	}

	public TesisatDuzenle getTesisat_duzenle() {
		return tesisat_duzenle;
	}

	public void setTesisat_duzenle(TesisatDuzenle tesisat_duzenle) {
		this.tesisat_duzenle = tesisat_duzenle;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public TesisatKayit getTesisat_kayit() {
		return tesisat_kayit;
	}

	public void setTesisat_kayit(TesisatKayit ekran) {
		this.tesisat_kayit = ekran;
	}
}
