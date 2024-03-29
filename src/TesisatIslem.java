import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TesisatIslem extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private TesisatKayit tesisat_kayit;
	private TesisatDuzenle tesisat_duzenle;
	private TesisatSil tesisat_sil;
	
	public TesisatSil getTesisat_sil() {
		return tesisat_sil;
	}

	public void setTesisat_sil(TesisatSil tesisat_sil) {
		this.tesisat_sil = tesisat_sil;
	}

	public TesisatIslem(Connection conn, JPanel ana_menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tesisat_kayit = new TesisatKayit(conn,panel);
		contentPane.add(tesisat_kayit.getPanel());
		tesisat_kayit.getPanel().setLayout(null);
		tesisat_kayit.getPanel().setVisible(false);
		
		tesisat_duzenle = new TesisatDuzenle(conn,panel);
		contentPane.add(tesisat_duzenle.getPanel());
		tesisat_duzenle.getPanel().setLayout(null);
		tesisat_duzenle.getPanel().setVisible(false);
		
		tesisat_sil = new TesisatSil(conn,panel);
		contentPane.add(tesisat_sil.getPanel());
		tesisat_sil.getPanel().setLayout(null);
		tesisat_sil.getPanel().setVisible(false);
		
		JButton tesisatKayıt = new JButton("Yeni Tesisat Kay\u0131t");
		tesisatKayıt.setForeground(new Color(176, 224, 230));
		tesisatKayıt.setBackground(new Color(0, 139, 139));
		tesisatKayıt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		tesisatKayıt.setBounds(122, 30, 140, 46);
		panel.add(tesisatKayıt);
		
		JButton tesisatDuzenle = new JButton("Tesisat D\u00FCzenle");
		tesisatDuzenle.setForeground(new Color(176, 224, 230));
		tesisatDuzenle.setBackground(new Color(0, 139, 139));
		tesisatDuzenle.setBounds(122, 106, 140, 46);
		tesisatDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_duzenle.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(tesisatDuzenle);
		
		JButton tesisatSil = new JButton("Tesisat Sil");
		tesisatSil.setForeground(new Color(176, 224, 230));
		tesisatSil.setBackground(new Color(0, 139, 139));
		tesisatSil.setBounds(122, 182, 140, 46);
		tesisatSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_sil.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(tesisatSil);	
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.setBackground(new Color(255, 99, 71));
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
