import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.LinkedList;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinglyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField rearfield;
	private JTextField frontfield;
	private JTextField displaybox;
	class Node{
		int data;
		Node link;
	}
	private Node first;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSinglyLinkedData = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		lblSinglyLinkedData.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinglyLinkedData.setForeground(Color.BLACK);
		lblSinglyLinkedData.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblSinglyLinkedData.setBounds(10, 11, 407, 22);
		contentPane.add(lblSinglyLinkedData);
		
		JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT");
		lblEnterTheElement.setForeground(Color.RED);
		lblEnterTheElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheElement.setBounds(10, 71, 187, 18);
		contentPane.add(lblEnterTheElement);
		
		JLabel lblEnterTheElement_1 = new JLabel("ENTER THE ELEMENT");
		lblEnterTheElement_1.setForeground(Color.RED);
		lblEnterTheElement_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheElement_1.setBounds(10, 112, 187, 18);
		contentPane.add(lblEnterTheElement_1);
		
		rearfield = new JTextField();
		rearfield.setColumns(10);
		rearfield.setBounds(207, 72, 126, 19);
		contentPane.add(rearfield);
		
		frontfield = new JTextField();
		frontfield.setColumns(10);
		frontfield.setBounds(207, 113, 126, 19);
		contentPane.add(frontfield);
		
		JButton insertRear = new JButton("INSERT REAR");
		insertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REAR INSERTION
				Node temp;
				int elem = Integer.valueOf(rearfield.getText());
				Node newnode = new Node();
				newnode.data=elem;
				newnode.link=null;
				if(first==null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				else {
					temp = first;
					while(temp.link!=null) {
						temp=temp.link;
					}
					temp.link = newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				rearfield.setText("");
			}
		});
		insertRear.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		insertRear.setBounds(343, 68, 164, 27);
		contentPane.add(insertRear);
		
		JButton insertFront = new JButton("INSERT FRONT");
		insertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FRONT INSERTION
				int elem = Integer.valueOf(frontfield.getText());
				Node newnode = new Node();
				newnode.data=elem;
				newnode.link=null;
				if(first==null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				else {
					newnode.link=first;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
					}
				frontfield.setText("");
			}
		});
		insertFront.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		insertFront.setBounds(343, 108, 164, 27);
		contentPane.add(insertFront);
		
		JButton btnDeleteRear = new JButton("DELETE REAR");
		btnDeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REAR DELETION
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Rear Deletion not possible");
				}
				else if(first.link==null) {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is " +first.data);
					first=null;
				}
				else {
					temp=first;
					while(temp.link.link!=null) {
						temp=temp.link;
					}
					JOptionPane.showMessageDialog(contentPane,"Element deleted is "+temp.link.data);
					temp.link=null;
				}
			}
		});
		btnDeleteRear.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDeleteRear.setBounds(167, 156, 181, 27);
		contentPane.add(btnDeleteRear);
		
		JButton btnDeleteFront = new JButton("DELETE FRONT");
		btnDeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FRONT DELETION
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Front Deletion not possible");
				}
				else if(first.link==null) {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is " +first.data);
					first=null;
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is "+first.data);
					first = first.link;
				}
			}
		});
		btnDeleteFront.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDeleteFront.setBounds(167, 193, 181, 27);
		contentPane.add(btnDeleteFront);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY
				Node temp;
				String msg="";
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
				}
				else if(first.link==null) {
					msg=msg+" "+first.data;
				}
				else {
					temp=first;
					while(temp!= null) {
						msg=msg+" "+temp.data;
						temp=temp.link;
					}
					displaybox.setText(msg);
				}
			}
		});
		btnDisplay.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDisplay.setBounds(182, 230, 151, 27);
		contentPane.add(btnDisplay);
		
		displaybox = new JTextField();
		displaybox.setForeground(Color.BLACK);
		displaybox.setColumns(10);
		displaybox.setBackground(Color.YELLOW);
		displaybox.setBounds(27, 277, 454, 19);
		contentPane.add(displaybox);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(408, 10, 99, 27);
		contentPane.add(btnHome);
	}

}
