import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("CHOOSE A DATASTUCTURE");
		Label1.setForeground(new Color(255, 0, 128));
		Label1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		Label1.setBounds(122, 38, 335, 24);
		contentPane.add(Label1);
		
		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				//Array a=new Array();
				//a.setVisible(true);
				new Array().setVisible(true);
			}
		});
	
		array.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		array.setBounds(224, 105, 109, 27);
		contentPane.add(array);
		
		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				new Stack().setVisible(true);
			}
		});
		
		stack.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		stack.setBounds(49, 154, 91, 27);
		contentPane.add(stack);
		
		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				new Queue().setVisible(true);
			}
		});
		queue.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		queue.setBounds(438, 154, 91, 27);
		contentPane.add(queue);
		
		JButton cqueue = new JButton("CIRCULAR QUEUE");
		cqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				new CircularQueue().setVisible(true);
			}
		});
		cqueue.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		cqueue.setBounds(49, 235, 211, 27);
		contentPane.add(cqueue);
		
		JButton sll = new JButton("SINGLY LINKED LIST");
		sll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				new SinglyLinkedList().setVisible(true);
			}
		});
		sll.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		sll.setBounds(292, 235, 237, 27);
		contentPane.add(sll);
		
		JButton dll = new JButton("DOUBLY LINKED LIST");
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OPENING CODE
				new DoublyLinkedList().setVisible(true);
			}
		});
		dll.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		dll.setBounds(151, 305, 253, 27);
		contentPane.add(dll);
	}
}
