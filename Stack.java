import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Stack extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int s[];
	private int size;
	private int top= -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStackDatastucture = new JLabel("STACK DATA STRUCTURE");
		lblStackDatastucture.setBounds(139, 36, 298, 24);
		lblStackDatastucture.setForeground(Color.BLACK);
		lblStackDatastucture.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		contentPane.add(lblStackDatastucture);
		
		JButton create = new JButton("CREATE STACK");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//STACK CREATION
				size = Integer.valueOf(sizefield.getText());
				s = new int[size];
				String message = "Stack Of Size " +size+ " Created";
				JOptionPane.showMessageDialog(contentPane,message);
			}
		});
		
		create.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		create.setBounds(333, 114, 190, 27);
		contentPane.add(create);
		
		JLabel lblEnterTheStack = new JLabel("ENTER THE STACK SIZE");
		lblEnterTheStack.setForeground(Color.RED);
		lblEnterTheStack.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterTheStack.setBounds(40, 84, 190, 18);
		contentPane.add(lblEnterTheStack);
		
		sizefield = new JTextField();
		sizefield.setColumns(10);
		sizefield.setBounds(240, 85, 126, 19);
		contentPane.add(sizefield);
		
		JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT");
		lblEnterAnElement.setForeground(Color.RED);
		lblEnterAnElement.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterAnElement.setBounds(40, 166, 162, 18);
		contentPane.add(lblEnterAnElement);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(240, 167, 126, 19);
		contentPane.add(element);
		
		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PUSH
				int elem;
				if(top == size-1) {
					JOptionPane.showMessageDialog(contentPane,"Push Not Possible");
				}
				else {
					elem = Integer.valueOf(element.getText());
					++top;
					s[top]=elem;
					JOptionPane.showMessageDialog(contentPane,"Push Successful");
					element.setText("");
				}
			}
		});

		push.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		push.setBounds(424, 162, 99, 27);
		contentPane.add(push);
		
		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//POP
				if(top == -1) {
					JOptionPane.showMessageDialog(contentPane,"Pop Not Possible");
				}
				else {
					String message = "Element Deleted Is: "+s[top];
					JOptionPane.showMessageDialog(contentPane,message);
					--top;
				}
			}
		});
		pop.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		pop.setBounds(227, 196, 88, 27);
		contentPane.add(pop);
		
		JButton dispaly = new JButton("DISPLAY");
		dispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY
				String msg="";
				if(top == -1) {
					JOptionPane.showMessageDialog(contentPane,"Dsplay Not Possible");
				}
				else {
					for(int i=top; i>=0; i--) {
					   msg=msg+" "+s[i];
					}
					displaybox.setText(msg);
				}
			}
		});
	
		dispaly.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		dispaly.setBounds(210, 243, 128, 27);
		contentPane.add(dispaly);
		
		displaybox = new JTextField();
		displaybox.setBackground(Color.YELLOW);
		displaybox.setForeground(new Color(0, 0, 0));
		displaybox.setColumns(10);
		displaybox.setBounds(40, 280, 483, 19);
		contentPane.add(displaybox);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnHome.setBounds(459, 10, 99, 27);
		contentPane.add(btnHome);
	}
}
