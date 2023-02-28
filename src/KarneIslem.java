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
	private JPanel panel;
	private KarneKayit karne_kayit; 
	private KarneDuzenle karne_duzenle;
	private KarneSil karne_sil;
	
	public KarneIslem(Connection conn, JPanel ana_menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		karne_kayit= new KarneKayit(conn,panel);
		contentPane.add(karne_kayit.getPanel());
		karne_kayit.getPanel().setLayout(null);
		karne_kayit.getPanel().setVisible(false);
		
		karne_duzenle= new KarneDuzenle(conn,panel);
		contentPane.add(karne_duzenle.getPanel());
		karne_duzenle.getPanel().setLayout(null);
		karne_duzenle.getPanel().setVisible(false);
		
		karne_sil= new KarneSil(conn,panel);
		contentPane.add(karne_sil.getPanel());
		karne_sil.getPanel().setLayout(null);
		karne_sil.getPanel().setVisible(false);
		

		JButton karneKayýt = new JButton("Yeni Karne Kay\u0131t");
		karneKayýt.setBounds(117, 105, 141, 46);
		karneKayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(karneKayýt);
		
		JButton karneDuzenle = new JButton("Karne D\u00FCzenle");
		karneDuzenle.setBounds(117, 162, 141, 46);
		karneDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_duzenle.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		
		panel.add(karneDuzenle);
		
		
		JButton karneSil = new JButton("Karne Sil");
		karneSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_sil.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		karneSil.setBounds(117, 222, 141, 46);
		panel.add(karneSil);
		
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public KarneKayit getKarne_kayit() {
		return karne_kayit;
	}

	public void setKarne_kayit(KarneKayit karne_kayit) {
		this.karne_kayit = karne_kayit;
	}

	public KarneDuzenle getKarne_duzenle() {
		return karne_duzenle;
	}

	public void setKarne_duzenle(KarneDuzenle karne_duzenle) {
		this.karne_duzenle = karne_duzenle;
	}

	public KarneSil getKarne_sil() {
		return karne_sil;
	}

	public void setKarne_sil(KarneSil karne_sil) {
		this.karne_sil = karne_sil;
	}
}
