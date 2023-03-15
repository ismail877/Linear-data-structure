import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class CircularQueue extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int cq[];
	private int size;
	private int r= -1;
	private int f=0;
	private int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQueueDataStructure = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
		lblQueueDataStructure.setForeground(Color.BLACK);
		lblQueueDataStructure.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblQueueDataStructure.setBounds(22, 13, 377, 24);
		contentPane.add(lblQueueDataStructure);
		
		JLabel lblEnterTheQueue = new JLabel("ENTER THE CIRCULAR QUEUE SIZE");
		lblEnterTheQueue.setForeground(Color.RED);
		lblEnterTheQueue.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheQueue.setBounds(13, 69, 293, 18);
		contentPane.add(lblEnterTheQueue);
		
		sizefield = new JTextField();
		sizefield.setColumns(10);
		sizefield.setBounds(316, 70, 126, 19);
		contentPane.add(sizefield);
		
		JButton btnCreateCircularQueue = new JButton("CREATE CIRCULAR QUEUE");
		btnCreateCircularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CREATE
				size = Integer.valueOf(sizefield.getText());
				cq = new int[size];
				String message = "Circular Queue Of Size " +size+ " Created";
				JOptionPane.showMessageDialog(contentPane,message);
		
			}
		});
		btnCreateCircularQueue.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnCreateCircularQueue.setBounds(115, 103, 270, 27);
		contentPane.add(btnCreateCircularQueue);
		
		JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT");
		lblEnterAnElement.setForeground(Color.RED);
		lblEnterAnElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterAnElement.setBounds(13, 144, 162, 18);
		contentPane.add(lblEnterAnElement);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(185, 145, 126, 19);
		contentPane.add(element);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INSERTION
				int elem;
				if(count == size) {
					JOptionPane.showMessageDialog(contentPane,"Insertion not possible");
				}
				else {
					elem = Integer.valueOf(element.getText());
					r = (r+1)%size;
					cq[r]=elem;
					count++;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
					element.setText("");
				}
			}
		});
		insert.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		insert.setBounds(343, 140, 99, 27);
		contentPane.add(insert);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETION
				if(count == 0) {
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible");
				}
				else {
					String message = "Element Deleted Is: "+cq[f];
					JOptionPane.showMessageDialog(contentPane,message);
					f=(f+1)%size;
					count--;
				}
			}
		});
		delete.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		delete.setBounds(192, 186, 116, 27);
		contentPane.add(delete);
		
		JButton dispaly = new JButton("DISPLAY");
		dispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY
				String msg="";
				int f1=f;
				if(count == 0) {
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
				}
				else {
					for(int i=1; i<=count; i++) {
						msg=msg+" "+cq[f1];
						f1=(f1+1)%size;
					}
					displaybox.setText(msg);
				}
			}
		});
		dispaly.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		dispaly.setBounds(178, 234, 140, 27);
		contentPane.add(dispaly);
		
		displaybox = new JTextField();
		displaybox.setForeground(Color.BLACK);
		displaybox.setColumns(10);
		displaybox.setBackground(Color.YELLOW);
		displaybox.setBounds(28, 283, 454, 19);
		contentPane.add(displaybox);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(409, 10, 99, 27);
		contentPane.add(btnHome);
	}

}
