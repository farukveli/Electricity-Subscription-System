import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class AboneIslem extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private AboneKayit abone_kayit; 
	private AboneDuzenle abone_duzenle;
	private AboneSil abone_sil;
	/**
	 * Create the frame.
	 */
	public AboneIslem(Connection conn, JPanel ana_menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		abone_kayit= new AboneKayit(conn,panel);
		contentPane.add(abone_kayit.getPanel());
		abone_kayit.getPanel().setLayout(null);
		abone_kayit.getPanel().setVisible(false);
		
		abone_duzenle= new AboneDuzenle(conn,panel);
		contentPane.add(abone_duzenle.getPanel());
		abone_duzenle.getPanel().setLayout(null);
		abone_duzenle.getPanel().setVisible(false);
		
		abone_sil= new AboneSil(conn,panel);
		contentPane.add(abone_sil.getPanel());
		abone_sil.getPanel().setLayout(null);
		abone_sil.getPanel().setVisible(false);

		JButton aboneKayit = new JButton("Yeni Abone Kay\u0131t");
		aboneKayit.setBackground(new Color(0, 139, 139));
		aboneKayit.setForeground(new Color(176, 224, 230));
		aboneKayit.setBounds(117, 105, 141, 46);
		aboneKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abone_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(aboneKayit);
		
		JButton aboneDuzenle = new JButton("Abone D\u00FCzenle");
		aboneDuzenle.setBackground(new Color(0, 139, 139));
		aboneDuzenle.setForeground(new Color(176, 224, 230));
		aboneDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abone_duzenle.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		aboneDuzenle.setBounds(117, 162, 141, 46);
		panel.add(aboneDuzenle);
		
		JButton sil = new JButton("Abone Sil");
		sil.setBackground(new Color(0, 139, 139));
		sil.setForeground(new Color(176, 224, 230));
		sil.setBounds(117, 219, 141, 46);
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abone_sil.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(sil);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.setBackground(new Color(255, 99, 71));
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ana_menu.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
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
	public AboneKayit getAbone_kayit() {
		return abone_kayit;
	}
	public void setAbone_kayit(AboneKayit abone_kayit) {
		this.abone_kayit = abone_kayit;
	}
	public AboneDuzenle getAbone_duzenle() {
		return abone_duzenle;
	}
	public void setAbone_duzenle(AboneDuzenle abone_duzenle) {
		this.abone_duzenle = abone_duzenle;
	}
	public AboneSil getAbone_sil() {
		return abone_sil;
	}
	public void setAbone_sil(AboneSil abone_sil) {
		this.abone_sil = abone_sil;
	}
}
