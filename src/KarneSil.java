import java.awt.BorderLayout;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Silmek \u0130stedi\u011Finiz Karne No'yu Giriniz:");
		lblNewLabel.setBounds(10, 111, 220, 40);
		panel.add(lblNewLabel);
		
		karne_sil_txt = new JTextField();
		karne_sil_txt.setHorizontalAlignment(SwingConstants.CENTER);
		karne_sil_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		karne_sil_txt.setBounds(248, 114, 102, 32);
		panel.add(karne_sil_txt);
		karne_sil_txt.setColumns(10);
		
		JButton sil = new JButton("Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Karneler().karne_sil(conn, Integer.parseInt(karne_sil_txt.getText()));
			}
		});
		sil.setBounds(248, 157, 102, 32);
		panel.add(sil);
		
		JButton geri_don = new JButton("Geri Dön");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
