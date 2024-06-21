package kalkulator;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame {

	private JFrame frame;
	private JTextField add_opr1;
	private JTextField add_opr2;
	private JTextField add_res;
	private JTextField sub_opr1;
	private JLabel negation;
	private JTextField sub_opr2;
	private JLabel sub_equal;
	private JTextField sub_res;
	private JButton sub_btn;
	private JTextField mult_opr1;
	private JLabel multiplication;
	private JTextField mult_opr2;
	private JLabel mult_equal;
	private JTextField mult_res;
	private JButton mult_btn;
	private JTextField div_opr1;
	private JLabel division;
	private JTextField div_opr2;
	private JLabel div_equal;
	private JTextField div_res;
	private JButton div_btn;
	private JTextField mod_opr1;
	private JLabel modulus;
	private JTextField mod_opr2;
	private JLabel add_equal_4;
	private JTextField mod_res;
	private JButton mod_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Kalkulator");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(252, 11, 118, 25);
		frame.getContentPane().add(title);
		
		add_opr1 = new JTextField();
		add_opr1.setBounds(71, 67, 86, 25);
		frame.getContentPane().add(add_opr1);
		add_opr1.setColumns(10);
		
		add_opr2 = new JTextField();
		add_opr2.setColumns(10);
		add_opr2.setBounds(201, 67, 86, 25);
		frame.getContentPane().add(add_opr2);
		
		add_res = new JTextField();
		add_res.setColumns(10);
		add_res.setBounds(374, 67, 86, 25);
		add_res.setFocusable(false);
		frame.getContentPane().add(add_res);
		
		JLabel addition = new JLabel("+");
		addition.setHorizontalAlignment(SwingConstants.CENTER);
		addition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addition.setBounds(156, 67, 46, 25);
		frame.getContentPane().add(addition);
		
		JLabel add_equal = new JLabel("=");
		add_equal.setHorizontalAlignment(SwingConstants.CENTER);
		add_equal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add_equal.setBounds(307, 67, 46, 25);
		frame.getContentPane().add(add_equal);
		
		JButton add_btn = new JButton("TAMBAH");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double add_result = Double.parseDouble(add_opr1.getText()) + Double.parseDouble(add_opr2.getText());
					
					DecimalFormat dec_format = new DecimalFormat("#.##");
					
					add_res.setText(dec_format.format(add_result));
				} catch ( Exception e1) {
					add_res.setText("undefined");
				};
			}
		});
		add_btn.setBounds(511, 68, 89, 23);
		frame.getContentPane().add(add_btn);
		
		sub_opr1 = new JTextField();
		sub_opr1.setColumns(10);
		sub_opr1.setBounds(71, 117, 86, 25);
		frame.getContentPane().add(sub_opr1);
		
		negation = new JLabel("-");
		negation.setHorizontalAlignment(SwingConstants.CENTER);
		negation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		negation.setBounds(156, 117, 46, 25);
		frame.getContentPane().add(negation);
		
		sub_opr2 = new JTextField();
		sub_opr2.setColumns(10);
		sub_opr2.setBounds(201, 117, 86, 25);
		frame.getContentPane().add(sub_opr2);
		
		sub_equal = new JLabel("=");
		sub_equal.setHorizontalAlignment(SwingConstants.CENTER);
		sub_equal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sub_equal.setBounds(307, 117, 46, 25);
		frame.getContentPane().add(sub_equal);
		
		sub_res = new JTextField();
		sub_res.setFocusable(false);
		sub_res.setColumns(10);
		sub_res.setBounds(374, 117, 86, 25);
		frame.getContentPane().add(sub_res);
		
		sub_btn = new JButton("KURANG");
		sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double sub_result = Double.parseDouble(sub_opr1.getText()) - Double.parseDouble(sub_opr2.getText());
					
					DecimalFormat dec_format = new DecimalFormat("#.##");
					
					sub_res.setText(dec_format.format(sub_result));
				} catch ( Exception exc ) {
					sub_res.setText("undefined");
				};
			}
		});
		sub_btn.setBounds(511, 118, 89, 23);
		frame.getContentPane().add(sub_btn);
		
		mult_opr1 = new JTextField();
		mult_opr1.setColumns(10);
		mult_opr1.setBounds(71, 165, 86, 25);
		frame.getContentPane().add(mult_opr1);
		
		multiplication = new JLabel("*");
		multiplication.setHorizontalAlignment(SwingConstants.CENTER);
		multiplication.setFont(new Font("Tahoma", Font.PLAIN, 16));
		multiplication.setBounds(156, 165, 46, 25);
		frame.getContentPane().add(multiplication);
		
		mult_opr2 = new JTextField();
		mult_opr2.setColumns(10);
		mult_opr2.setBounds(201, 165, 86, 25);
		frame.getContentPane().add(mult_opr2);
		
		mult_equal = new JLabel("=");
		mult_equal.setHorizontalAlignment(SwingConstants.CENTER);
		mult_equal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mult_equal.setBounds(307, 165, 46, 25);
		frame.getContentPane().add(mult_equal);
		
		mult_res = new JTextField();
		mult_res.setFocusable(false);
		mult_res.setColumns(10);
		mult_res.setBounds(374, 165, 86, 25);
		frame.getContentPane().add(mult_res);
		
		mult_btn = new JButton("KALI");
		mult_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double mult_result = Double.parseDouble(mult_opr1.getText()) * Double.parseDouble(mult_opr2.getText());
					
					DecimalFormat dec_format = new DecimalFormat("#.##");
					
					mult_res.setText(dec_format.format(mult_result));
				} catch ( Exception exc) {
					mult_res.setText("undefined");
				};
			}
		});
		mult_btn.setBounds(511, 166, 89, 23);
		frame.getContentPane().add(mult_btn);
		
		div_opr1 = new JTextField();
		div_opr1.setColumns(10);
		div_opr1.setBounds(71, 214, 86, 25);
		frame.getContentPane().add(div_opr1);
		
		division = new JLabel(":");
		division.setHorizontalAlignment(SwingConstants.CENTER);
		division.setFont(new Font("Tahoma", Font.PLAIN, 16));
		division.setBounds(156, 214, 46, 25);
		frame.getContentPane().add(division);
		
		div_opr2 = new JTextField();
		div_opr2.setColumns(10);
		div_opr2.setBounds(201, 214, 86, 25);
		frame.getContentPane().add(div_opr2);
		
		div_equal = new JLabel("=");
		div_equal.setHorizontalAlignment(SwingConstants.CENTER);
		div_equal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		div_equal.setBounds(307, 214, 46, 25);
		frame.getContentPane().add(div_equal);
		
		div_res = new JTextField();
		div_res.setFocusable(false);
		div_res.setColumns(10);
		div_res.setBounds(374, 214, 86, 25);
		frame.getContentPane().add(div_res);
		
		div_btn = new JButton("BAGI");
		div_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (Integer.parseInt(div_opr2.getText()) == 0) {
						div_res.setText("undefined");
						return;
					}
					
					double div_result = Double.parseDouble(div_opr1.getText()) / Double.parseDouble(div_opr2.getText());
					
					DecimalFormat dec_format = new DecimalFormat("#.##");
					
					div_res.setText(dec_format.format(div_result));
				} catch ( Exception e1) {
					div_res.setText("undefined");
				};
			}
		});
		div_btn.setBounds(511, 215, 89, 23);
		frame.getContentPane().add(div_btn);
		
		mod_opr1 = new JTextField();
		mod_opr1.setColumns(10);
		mod_opr1.setBounds(71, 264, 86, 25);
		frame.getContentPane().add(mod_opr1);
		
		modulus = new JLabel("%");
		modulus.setHorizontalAlignment(SwingConstants.CENTER);
		modulus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		modulus.setBounds(156, 264, 46, 25);
		frame.getContentPane().add(modulus);
		
		mod_opr2 = new JTextField();
		mod_opr2.setColumns(10);
		mod_opr2.setBounds(201, 264, 86, 25);
		frame.getContentPane().add(mod_opr2);
		
		add_equal_4 = new JLabel("=");
		add_equal_4.setHorizontalAlignment(SwingConstants.CENTER);
		add_equal_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add_equal_4.setBounds(307, 264, 46, 25);
		frame.getContentPane().add(add_equal_4);
		
		mod_res = new JTextField();
		mod_res.setFocusable(false);
		mod_res.setColumns(10);
		mod_res.setBounds(374, 264, 86, 25);
		frame.getContentPane().add(mod_res);
		
		mod_btn = new JButton("MOD");
		mod_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int mod_result = Integer.parseInt(mod_opr1.getText()) % Integer.parseInt(mod_opr2.getText());
					
					mod_res.setText(String.valueOf(mod_result));
				} catch ( Exception e1) {
					mod_res.setText("undefined");
				};
			}
		});
		mod_btn.setBounds(511, 265, 89, 23);
		frame.getContentPane().add(mod_btn);
	}
}
