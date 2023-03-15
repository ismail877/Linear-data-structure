import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Queue extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int q[];
	private int size;
	private int r= -1;
	private int f=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQueueDataStructure = new JLabel("QUEUE DATA STRUCTURE");
		lblQueueDataStructure.setForeground(Color.BLACK);
		lblQueueDataStructure.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblQueueDataStructure.setBounds(126, 21, 298, 24);
		contentPane.add(lblQueueDataStructure);
		
		JLabel lblEnterTheQueue = new JLabel("ENTER THE QUEUE SIZE");
		lblEnterTheQueue.setBounds(32, 60, 199, 18);
		contentPane.add(lblEnterTheQueue);
		lblEnterTheQueue.setForeground(Color.RED);
		lblEnterTheQueue.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		sizefield = new JTextField();
		sizefield.setBounds(241, 61, 126, 19);
		contentPane.add(sizefield);
		sizefield.setColumns(10);
		
		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CREATE
				size = Integer.valueOf(sizefield.getText());
				q = new int[size];
				String message = "Queue Of Size " +size+ " Created";
				JOptionPane.showMessageDialog(contentPane,message);
			}
		});
		create.setBounds(303, 103, 190, 27);
		contentPane.add(create);
		create.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INSERT				
				int elem;
				if(r == size-1) {
					JOptionPane.showMessageDialog(contentPane,"Insertion Not Possible");
				}
				else {
					elem = Integer.valueOf(element.getText());
					++r;
					q[r]=elem;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
					element.setText("");
				}
			}
		});
		insert.setBounds(394, 144, 99, 27);
		contentPane.add(insert);
		insert.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		displaybox = new JTextField();
		displaybox.setBounds(39, 272, 483, 19);
		contentPane.add(displaybox);
		displaybox.setForeground(Color.BLACK);
		displaybox.setColumns(10);
		displaybox.setBackground(Color.YELLOW);
		
		JButton dispaly = new JButton("DISPLAY");
		dispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY
				String msg="";
				if(r == -1 || f>r) {
					JOptionPane.showMessageDialog(contentPane,"Display Not Possible");
				}
				else {
					for(int i=f; i<=r; i++) {
						msg=msg+" "+q[i];
					}
					displaybox.setText(msg);
				}
			}
		});
		dispaly.setBounds(193, 235, 140, 27);
		contentPane.add(dispaly);
		dispaly.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETE
				if(r == -1 || f>r) {
					JOptionPane.showMessageDialog(contentPane,"Deletion Not Possible");
				}
				else {
					String message = "Element Deleted Is: "+q[f];
					JOptionPane.showMessageDialog(contentPane,message);
					++f;
				}
			}
		});
		delete.setBounds(205, 189, 116, 27);
		contentPane.add(delete);
		delete.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT");
		lblEnterAnElement.setBounds(32, 144, 162, 18);
		contentPane.add(lblEnterAnElement);
		lblEnterAnElement.setForeground(Color.RED);
		lblEnterAnElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		element = new JTextField();
		element.setBounds(241, 149, 126, 19);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(441, 10, 99, 27);
		contentPane.add(btnHome);
	}
}
