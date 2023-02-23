import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AnaMenu extends JFrame {

	private JPanel contentPane;
	private Connection conn;
	private JTextField baslik;

	/**
	 * Create the frame.
	 */
	public AnaMenu(Connection conn) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Karne \u0130\u015Flemleri");
		btnNewButton.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneIslem karne = new KarneIslem(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		btnNewButton.setBounds(110, 123, 150, 50);
		contentPane.add(btnNewButton);
		
		baslik = new JTextField();
		baslik.setEditable(false);
		baslik.setFont(new Font("Ubuntu", Font.BOLD, 22));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setText("ELEKTR\u0130K DA\u011EITIM S\u0130STEM\u0130");
		baslik.setBounds(10, 11, 364, 66);
		contentPane.add(baslik);
		baslik.setColumns(10);
	}
}
