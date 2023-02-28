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

public class TesisatSil extends JFrame {

	private JPanel contentPane;
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
	public JTextField getTesisat_sil_txt() {
		return tesisat_sil_txt;
	}
	public void setTesisat_sil_txt(JTextField tesisat_sil_txt) {
		this.tesisat_sil_txt = tesisat_sil_txt;
	}
	private JPanel panel;
	private JTextField tesisat_sil_txt;
	/**
	 * Create the frame.
	 */
	public TesisatSil(Connection conn, JPanel tesisat_islem) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(20, 466, 297, 23);
		uyari.setVisible(false);
		panel.add(uyari);
		
		JLabel lblNewLabel = new JLabel("Silmek \u0130stedi\u011Finiz Tesisat No'yu Giriniz:");
		lblNewLabel.setBounds(10, 111, 220, 40);
		panel.add(lblNewLabel);
		
		tesisat_sil_txt = new JTextField();
		tesisat_sil_txt.setHorizontalAlignment(SwingConstants.CENTER);
		tesisat_sil_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tesisat_sil_txt.setBounds(248, 114, 102, 32);
		panel.add(tesisat_sil_txt);
		tesisat_sil_txt.setColumns(10);
		
		JButton sil = new JButton("Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int durum =new Tesisat().Tesisat_Sil(conn, Integer.parseInt(tesisat_sil_txt.getText()));
				if(durum==0) {
					uyari.setText(tesisat_sil_txt.getText()+" NO'lu Tesisat Silinmiþtir!!");
					uyari.setForeground(Color.green);
					uyari.setVisible(true);
				}else {
					uyari.setText(tesisat_sil_txt.getText()+"NO'lu Tesisat Bulunamadi!!!");
					uyari.setForeground(Color.red);
					uyari.setVisible(true);
				}
			}
		});
		sil.setBounds(248, 157, 102, 32);
		panel.add(sil);
		
		JButton geri_don = new JButton("Geri Dön");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uyari.setVisible(false);
				tesisat_sil_txt.setText("");
				tesisat_islem.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(248, 198, 102, 32);
		panel.add(geri_don);
	}

}
