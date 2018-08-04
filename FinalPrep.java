package finalPrep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gui.CoinFlipper;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ItemListener;
import java.util.Random;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalPrep extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Random rand = new Random();
	int multiFlip = rand.nextInt(2);
	int heads = 0;
	int tails = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FinalPrep frame = new FinalPrep();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinalPrep() 
	{
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Coin Flipping Stats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.DARK_GRAY);
		contentPane.add(pnlTop, BorderLayout.NORTH);
		
		JCheckBox chckbxRunMultipleFlips = new JCheckBox("Run Multiple Flips");
		chckbxRunMultipleFlips.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxRunMultipleFlips.setForeground(Color.WHITE);
		pnlTop.add(chckbxRunMultipleFlips);
		
		textField = new JTextField();
		textField.setText("10");
		textField.setEnabled(false);
		pnlTop.add(textField);
		textField.setColumns(10);
		
		JPanel pnlImage = new JPanel();
		pnlImage.setBackground(Color.DARK_GRAY);
		contentPane.add(pnlImage, BorderLayout.SOUTH);
		
		JLabel lblHeads = new JLabel("Heads: ");
		lblHeads.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeads.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblHeads.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeads.setOpaque(true);
		lblHeads.setForeground(Color.WHITE);
		lblHeads.setBackground(Color.DARK_GRAY);
		pnlImage.add(lblHeads);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		pnlImage.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTails = new JLabel("Tails: ");
		lblTails.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTails.setOpaque(true);
		lblTails.setBackground(Color.DARK_GRAY);
		lblTails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTails.setForeground(Color.WHITE);
		pnlImage.add(lblTails);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		pnlImage.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnFlip = new JButton("Flip");
		btnFlip.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFlip.setBorder(new EmptyBorder(5, 12, 5, 12));
		btnFlip.setOpaque(true);
		btnFlip.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlImage.add(btnFlip);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReset.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnReset.setOpaque(true);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlImage.add(btnReset);
		
		JLabel lblCoins = new JLabel("");
		lblCoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoins.setIcon(new ImageIcon(FinalPrep.class.getResource("/finalPrep/question.png")));
		lblCoins.setOpaque(true);
		lblCoins.setBackground(Color.WHITE);
		contentPane.add(lblCoins, BorderLayout.CENTER);
		
		chckbxRunMultipleFlips.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(chckbxRunMultipleFlips.isSelected())
				{
					textField.setEnabled(true);
					lblCoins.setIcon(new ImageIcon(FinalPrep.class.getResource("/finalPrep/heads-tails.png")));
				} else
					{
						textField.setEnabled(false);
						lblCoins.setIcon(new ImageIcon(FinalPrep.class.getResource("/finalPrep/question.png")));
					}
			}
		});
		
		btnFlip.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent e) 
			{	
				int flip = rand.nextInt(2);
				
				if(chckbxRunMultipleFlips.isSelected())
				{		
					String num = textField.getText();
					int numToss = Integer.parseInt(num);
					
					for(int i = 0; i < numToss; i++)
					{
						int multiFlip = rand.nextInt(2);
						
						if(multiFlip == 0) 
						{
							heads++;
						}
						if(multiFlip == 1) 
						{
							tails++;
						}
					}					
					textField_1.setText(String.valueOf(heads));
					textField_2.setText(String.valueOf(tails));
					
					heads = 0;
					tails = 0;				
				} else
					{
						if(flip == 0) 
						{
							heads++;
							lblCoins.setIcon(new ImageIcon(CoinFlipper.class.getResource("/finalPrep/heads.png")));
							textField_1.setText(String.valueOf(heads));					
						}
						if(flip == 1) 
						{
							tails++;
							lblCoins.setIcon(new ImageIcon(CoinFlipper.class.getResource("/finalPrep/tails.png")));
							textField_2.setText(String.valueOf(tails));
						}
					}
			}
		});
		
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				chckbxRunMultipleFlips.setSelected(false);
				textField.setEnabled(false);
				textField.setText("10");
				lblCoins.setIcon(new ImageIcon(FinalPrep.class.getResource("/finalPrep/question.png")));
				textField_1.setText("");
				textField_2.setText("");
				heads = 0;
				tails = 0;
			}
		});
	}
}