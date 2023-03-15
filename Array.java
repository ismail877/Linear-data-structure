import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField deleteposition;
	private JTextField insertposition;
	private JTextField displaybox;
	private int arr[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("ARRAY DATA STRUCTURE");
		label1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		label1.setForeground(Color.BLACK);
		label1.setBounds(164, 26, 270, 28);
		contentPane.add(label1);
		
		JLabel lblEnterArrayLength = new JLabel("ENTER ARRAY LENGTH");
		lblEnterArrayLength.setForeground(Color.RED);
		lblEnterArrayLength.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterArrayLength.setBounds(22, 64, 182, 18);
		contentPane.add(lblEnterArrayLength);
		
		length = new JTextField();
		length.setBounds(214, 65, 126, 19);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton create = new JButton("CREATE ARRAY");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for creating array
				int len = Integer.valueOf(length.getText());
				arr = new int[len];
				String message = "Array of length " +len+ " is Created";
				JOptionPane.showMessageDialog(contentPane,message);
			}
		});
		create.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		create.setBounds(162, 104, 143, 23);
		contentPane.add(create);
		
		JLabel lblInsertAnElement = new JLabel("INSERT AN ELEMENT");
		lblInsertAnElement.setForeground(Color.RED);
		lblInsertAnElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblInsertAnElement.setBounds(22, 146, 166, 18);
		contentPane.add(lblInsertAnElement);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(198, 146, 67, 19);
		contentPane.add(element);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for insertion
				int elem = Integer.valueOf(element.getText());
				int pos = Integer.valueOf(insertposition.getText());
				arr[pos]=elem;
				String message = "Element " +elem+ " inserted at position " +pos;
				JOptionPane.showMessageDialog(contentPane,message);
				element.setText("");
				insertposition.setText("");
			}
		});
		insert.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		insert.setBounds(443, 144, 88, 23);
		contentPane.add(insert);
		
		JLabel lblDeletePosition = new JLabel("DELETE POSITION");
		lblDeletePosition.setForeground(Color.RED);
		lblDeletePosition.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblDeletePosition.setBounds(22, 174, 143, 18);
		contentPane.add(lblDeletePosition);
		
		deleteposition = new JTextField();
		deleteposition.setColumns(10);
		deleteposition.setBounds(198, 175, 67, 19);
		contentPane.add(deleteposition);
		
		insertposition = new JTextField();
		insertposition.setColumns(10);
		insertposition.setBounds(366, 147, 67, 19);
		contentPane.add(insertposition);
		
		JLabel lblPosition = new JLabel("POSITION");
		lblPosition.setForeground(Color.RED);
		lblPosition.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPosition.setBounds(275, 146, 74, 18);
		contentPane.add(lblPosition);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deletion
				int pos = Integer.valueOf(deleteposition.getText());
				arr[pos] = 0;
				String message = "Element Deleted at position " +pos;
				JOptionPane.showMessageDialog(contentPane,message);
				deleteposition.setText("");
			}
		});
		delete.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		delete.setBounds(275, 174, 99, 23);
		contentPane.add(delete);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for display
				String msg="";
				for(int i=0; i<=arr.length-1; i++) {
					msg=msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		display.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		display.setBounds(198, 220, 123, 27);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(Color.YELLOW);
		displaybox.setBounds(22, 257, 502, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(457, 10, 99, 27);
		contentPane.add(btnHome);
	}
}
