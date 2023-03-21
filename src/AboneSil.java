import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AboneSil extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField Abone_sil_txt;
	/**
	 * Create the frame.
	 */
	public AboneSil(Connection conn, JPanel Abone_islem) {
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
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(20, 466, 297, 23);
		uyari.setVisible(false);
		panel.add(uyari);
		
		JLabel lblNewLabel = new JLabel("Silmek \u0130stedi\u011Finiz Abone No'yu Giriniz:");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBounds(10, 111, 220, 40);
		panel.add(lblNewLabel);
		
		Abone_sil_txt = new JTextField();
		Abone_sil_txt.setBackground(new Color(0, 139, 139));
		Abone_sil_txt.setForeground(new Color(176, 224, 230));
		Abone_sil_txt.setHorizontalAlignment(SwingConstants.CENTER);
		Abone_sil_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Abone_sil_txt.setBounds(248, 114, 102, 32);
		panel.add(Abone_sil_txt);
		Abone_sil_txt.setColumns(10);
		
		JButton sil = new JButton("Sil");
		sil.setBackground(new Color(0, 128, 0));
		sil.setForeground(new Color(176, 224, 230));
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int durum =new Abone().Abone_Sil(conn, Integer.parseInt(Abone_sil_txt.getText()));
				if(durum==0) {
					uyari.setText(Abone_sil_txt.getText()+" NO'lu Abone Silinmiþtir!!");
					uyari.setForeground(Color.green);
					uyari.setVisible(true);
				}else {
					uyari.setText(Abone_sil_txt.getText()+"NO'lu Abone Bulunamadi!!!");
					uyari.setForeground(Color.red);
					uyari.setVisible(true);
				}
			}
		});
		sil.setBounds(248, 157, 102, 32);
		panel.add(sil);
		
		JButton geri_don = new JButton("Geri Dön");
		geri_don.setBackground(new Color(255, 99, 71));
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uyari.setVisible(false);
				Abone_sil_txt.setText("");
				Abone_islem.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(248, 198, 102, 32);
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
	public JTextField getAbone_sil_txt() {
		return Abone_sil_txt;
	}
	public void setAbone_sil_txt(JTextField Abone_sil_txt) {
		this.Abone_sil_txt = Abone_sil_txt;
	}
		
}
