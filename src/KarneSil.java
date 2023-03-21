import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class KarneSil extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField karne_sil_txt;

	/**
	 * Create the frame.
	 */
	public KarneSil(Connection conn, JPanel karne_islem) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setForeground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Silmek \u0130stedi\u011Finiz Karne No'yu Giriniz:");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBounds(10, 111, 220, 40);
		panel.add(lblNewLabel);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(20, 466, 297, 23);
		uyari.setVisible(false);
		panel.add(uyari);
		
		karne_sil_txt = new JTextField();
		karne_sil_txt.setForeground(new Color(176, 224, 230));
		karne_sil_txt.setBackground(new Color(0, 139, 139));
		karne_sil_txt.setHorizontalAlignment(SwingConstants.CENTER);
		karne_sil_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		karne_sil_txt.setBounds(248, 114, 102, 32);
		karne_sil_txt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(karne_sil_txt);
		karne_sil_txt.setColumns(10);
		
		JButton sil = new JButton("Sil");
		sil.setForeground(new Color(176, 224, 230));
		sil.setBackground(new Color(0, 128, 0));
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(karne_sil_txt.getText().isEmpty()) {
					uyari.setVisible(true);
					uyari.setText("Lütfen Karne No Giriniz");
					uyari.setForeground(Color.red);
				}else {
					int durum =new Karneler().karne_sil(conn, Integer.parseInt(karne_sil_txt.getText()));
					if(durum==0) {
						uyari.setText(karne_sil_txt.getText()+" NO'lu Karne Silinmiþtir!!");
						uyari.setForeground(Color.green);
						uyari.setVisible(true);
					}else {
						uyari.setText(karne_sil_txt.getText()+"NO'lu Karne Bulunamadi!!!");
						uyari.setForeground(Color.red);
						uyari.setVisible(true);
					}
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
				karne_sil_txt.setText("");
				karne_islem.setVisible(true);
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

	public JTextField getKarne_sil_txt() {
		return karne_sil_txt;
	}

	public void setKarne_sil_txt(JTextField karne_sil_txt) {
		this.karne_sil_txt = karne_sil_txt;
	}

}
