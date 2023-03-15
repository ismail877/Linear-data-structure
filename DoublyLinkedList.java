import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import DoublyLinkedList.Node;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoublyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField rearfield;
	private JTextField frontfield;
	private JTextField displaybox;
	class Node{
		Node prelink;
		int data;
		Node nextlink;
	}
	private Node first;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
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
	public DoublyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoublyLinkedList = new JLabel("DOUBLY LINKED LIST DATA STRUCTURE");
		lblDoublyLinkedList.setBounds(10, 34, 428, 22);
		lblDoublyLinkedList.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoublyLinkedList.setForeground(Color.BLACK);
		lblDoublyLinkedList.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		contentPane.add(lblDoublyLinkedList);
		
		JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT");
		lblEnterTheElement.setForeground(Color.RED);
		lblEnterTheElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheElement.setBounds(22, 66, 187, 18);
		contentPane.add(lblEnterTheElement);
		
		rearfield = new JTextField();
		rearfield.setColumns(10);
		rearfield.setBounds(207, 67, 126, 19);
		contentPane.add(rearfield);
		
		JLabel lblEnterTheElement_1 = new JLabel("ENTER THE ELEMENT");
		lblEnterTheElement_1.setForeground(Color.RED);
		lblEnterTheElement_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheElement_1.setBounds(22, 108, 187, 18);
		contentPane.add(lblEnterTheElement_1);
		
		frontfield = new JTextField();
		frontfield.setColumns(10);
		frontfield.setBounds(207, 109, 126, 19);
		contentPane.add(frontfield);
		
		JButton btnInsertRear = new JButton("INSERT REAR");
		btnInsertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REAR INSERTION
				Node temp;
				int elem = Integer.valueOf(rearfield.getText());
				Node newnode = new Node();
				newnode.data=elem;
				newnode.prelink=null;
				newnode.nextlink=null;
				if(first==null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				else {
					temp = first;
					while(temp.nextlink!=null) {
						temp=temp.nextlink;
					}
					temp.nextlink = newnode;
					newnode.prelink=temp;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				rearfield.setText("");
			}
		});
		btnInsertRear.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnInsertRear.setBounds(341, 66, 166, 27);
		contentPane.add(btnInsertRear);
		
		JButton btnInsertFront = new JButton("INSERT FRONT");
		btnInsertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FRONT INSERTION
				int elem = Integer.valueOf(frontfield.getText());
				Node newnode = new Node();
				newnode.data=elem;
				newnode.nextlink=null;
				newnode.prelink=null;
				if(first==null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
				}
				else {
					newnode.nextlink=first;
					first.prelink=newnode;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane,"Insertion of "+elem+" Successful");
					}
				frontfield.setText("");
			}
		});
		btnInsertFront.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnInsertFront.setBounds(343, 108, 164, 27);
		contentPane.add(btnInsertFront);
		
		JButton btnDeleteRear = new JButton("DELETE REAR");
		btnDeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REAR DELETION
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Rear Deletion not possible");
				}
				else if(first.nextlink==null) {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is " +first.data);
					first=null;
				}
				else {
					temp=first;
					while(temp.nextlink.nextlink!=null) {
						temp=temp.nextlink;
					}
					JOptionPane.showMessageDialog(contentPane,"Element deleted is "+temp.nextlink.data);
					temp.nextlink=null;
				}
			}
		});
		btnDeleteRear.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDeleteRear.setBounds(176, 145, 181, 27);
		contentPane.add(btnDeleteRear);
		
		JButton btnDeleteFront = new JButton("DELETE FRONT");
		btnDeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FRONT DELETION
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Rear Deletion not possible");
				}
				else if(first.nextlink==null) {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is " +first.data);
					first.prelink=null;
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Element deleted is " +first.data);
					first = first.nextlink;
					first.prelink=null;
				}
			}
		});
		btnDeleteFront.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDeleteFront.setBounds(176, 182, 181, 27);
		contentPane.add(btnDeleteFront);
		
		JButton btnDisplayForward = new JButton("DISPLAY FORWARD");
		btnDisplayForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FORWARD DISPLAY
				Node temp;
				String msg="";
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
				}
				else if(first.nextlink==null) {
					msg=msg+" "+first.data;
				}
				else {
					temp=first;
					while(temp!= null) {
						msg=msg+" "+temp.data;
						temp=temp.nextlink;
					}
					displaybox.setText(msg);
				}
			}
		});
		btnDisplayForward.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDisplayForward.setBounds(39, 219, 203, 27);
		contentPane.add(btnDisplayForward);
		
		displaybox = new JTextField();
		displaybox.setForeground(Color.BLACK);
		displaybox.setColumns(10);
		displaybox.setBackground(Color.YELLOW);
		displaybox.setBounds(39, 271, 454, 19);
		contentPane.add(displaybox);
		
		JButton btnDisplayReversed = new JButton("DISPLAY REVERSED");
		btnDisplayReversed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REVERSED DISPLAY
				Node temp;
				String msg="";
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
				}
				else if(first.nextlink==null) {
					msg=msg+" "+first.data;
				}
				else {
					temp=first;
					while(temp.nextlink!= null) {
						temp=temp.nextlink;
					}
					while(temp!=null){
						msg=msg+" "+temp.data;
						temp=temp.prelink;
					}
					displaybox.setText(msg);
				}
			}
		});
		btnDisplayReversed.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnDisplayReversed.setBounds(287, 219, 206, 27);
		contentPane.add(btnDisplayReversed);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(419, 10, 98, 27);
		contentPane.add(btnHome);
	}

}
