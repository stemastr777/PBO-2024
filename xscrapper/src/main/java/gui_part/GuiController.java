package gui_part;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import scrap_logic.PageNavigator;
import scrap_logic.Post;
import scrap_logic.SessionManager;

public class GuiController {

	private JFrame frame;
	private SessionManager active_session;
	private PageNavigator page_nav;
	private String previous_page;
	

	/**
	 * Create the application.
	 */
	public GuiController() {
//		this.page_nav = page_nav;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginPage();
		frame.setVisible(true);
	}
	
	
	public void homePage(Boolean use_cache) {
		
		frame.getContentPane().removeAll();
		
		
		ArrayList<Post> posts = new ArrayList<Post>();
		
		if (use_cache) {
			posts = page_nav.getPostCache();
		} else {
			posts = page_nav.retrieveOwnPosts();
		}
		
		
		JButton backButton = new JButton("Logout");
		backButton.setBounds(27, 11, 89, 23);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				active_session.closeBrowser();
				loginPage();
			}
		});
		frame.getContentPane().add(backButton);
		
		JLabel title = new JLabel("Xscrapper");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(339, 16, 116, 43);
		frame.getContentPane().add(title);
		
		JLabel username_label = new JLabel("Username:  "+page_nav.getUsername());
		username_label.setBounds(29, 82, 200, 29);
		frame.getContentPane().add(username_label);
		
		JButton post_btn = new JButton("Post");
		post_btn.setBounds(624, 73, 104, 29);
		frame.getContentPane().add(post_btn);
		post_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				previous_page = "homePage";
				createTweetPage();
			}
		});
		
		
		JPanel tweets_area_viewport = new JPanel();
		tweets_area_viewport.setBounds(105, 127, 408, 113);
		tweets_area_viewport.setLayout(new BoxLayout(tweets_area_viewport, BoxLayout.Y_AXIS));
		
		
		
		for (int i = 0; i < posts.size(); i++ ) {
			
			Post tweet = posts.get(i);
			
			String text = tweet.getText();
			
			tweets_area_viewport.add(Box.createVerticalStrut(10));
			
			JPanel tweet_panel = new JPanel();
			tweet_panel.setAlignmentX(0.05f);
	        tweet_panel.setMaximumSize(new Dimension(699, 50)); 
	        tweet_panel.setPreferredSize(new Dimension(699, 50)); 
			tweet_panel.setBackground(Color.LIGHT_GRAY);
			tweet_panel.setLayout(new BoxLayout(tweet_panel, BoxLayout.Y_AXIS));
			tweets_area_viewport.add(tweet_panel);
			
			tweet_panel.add(Box.createVerticalStrut(15));
			
			JLabel tweetPeekLabel = new JLabel("Label potongan post");
			tweet_panel.add(tweetPeekLabel);
			
			
			if (text.length() < 4) {
				tweetPeekLabel.setAlignmentX(0.1f);
			} else {
				tweetPeekLabel.setAlignmentX(0.05f);
			}
			
			if (text.length() > 20) {
				tweetPeekLabel.setText(text.substring(0, 20) + "...");
			} else {
				tweetPeekLabel.setText(posts.get(i).getText());
			}
			
			tweet_panel.addMouseListener(new MouseAdapter() {
			
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
					previous_page = "homePage";
					viewTweetPage(tweet);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseEntered(e);
					tweet_panel.setBackground(Color.cyan);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseExited(e);
					tweet_panel.setBackground(Color.lightGray);
				}
				
			});
			
		}
		
		JScrollPane tweets_area = new JScrollPane(tweets_area_viewport);
		
		tweets_area.setBackground(Color.LIGHT_GRAY);
		tweets_area.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		tweets_area.setBounds(29, 137, 699, 308);
		
		frame.getContentPane().add(tweets_area);
		
		// Revalidate and repaint to ensure the new components are displayed
	    frame.getContentPane().revalidate();
	    frame.getContentPane().repaint();
	}

	public void loginPage() {
		
		frame.getContentPane().removeAll();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel loginLabel = new JLabel("Username");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(143, 121, 141, 20);
		frame.getContentPane().add(loginLabel);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(299, 121, 290, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(143, 195, 141, 20);
		frame.getContentPane().add(lblPassword);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(299, 192, 295, 26);
		frame.getContentPane().add(passwordField);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(308, 287, 112, 34);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				active_session = new SessionManager();
				page_nav = new PageNavigator(active_session);
				
				
				loginButton.setEnabled(false);
				
				
				char[] password = passwordField.getPassword();
				String passwordString = new String(password);
				
				page_nav.loginAccount(usernameField.getText(), passwordString);
				
				previous_page = "loginPage";
				
				if (page_nav.getUsername().equals("")) {
					System.out.println("Login gagal.");
					loginPage();
					return;
				}
				
				homePage(false);
			}
		});
		
		frame.getContentPane().add(loginButton);
		
		
		
//		JButton reloginButton = new JButton("Restart");
//		reloginButton.setBounds(606, 31, 106, 26);
//		reloginButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				
//				active_session.closeBrowser();
//				loginPage();
//			}
//		});;
//		frame.getContentPane().add(reloginButton);
		
		// Revalidate and repaint to ensure the new components are displayed
	    frame.getContentPane().revalidate();
	    frame.getContentPane().repaint();
		
	}
	
	public void createTweetPage() {
		
		frame.getContentPane().removeAll();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea tweetTextarea = new JTextArea();
		tweetTextarea.setText("Apa yang sedang Anda pikirkan?");
		tweetTextarea.setBounds(27, 105, 697, 285);
		tweetTextarea.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(tweetTextarea);
		
		
		JScrollPane tweetsScrollPane = new JScrollPane(tweetTextarea);
		tweetsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		tweetsScrollPane.setBounds(29, 105, 699, 308);
		
		frame.getContentPane().add(tweetsScrollPane);
		
		JLabel createTweetLabel = new JLabel("Create new post");
		createTweetLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createTweetLabel.setBounds(24, 62, 228, 25);
		frame.getContentPane().add(createTweetLabel);
		
		JButton postButton = new JButton("Post");
		postButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				postButton.setEnabled(false);
				
				Post post = new Post(tweetTextarea.getText());
				
				page_nav.createPost(post);
				
				previous_page = "createTweetPage";
				
				homePage(false);
			}
		});
		postButton.setBounds(617, 421, 107, 35);
		frame.getContentPane().add(postButton);
		
		JButton backButton = new JButton("Kembali");
		backButton.setBounds(27, 11, 89, 23);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				homePage(true);
			}
		});
		
		
		// Revalidate and repaint to ensure the new components are displayed
	    frame.getContentPane().revalidate();
	    frame.getContentPane().repaint();
	}
	
	public void viewTweetPage(Post tweet) {
		
		frame.getContentPane().removeAll();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea tweetTextarea = new JTextArea();
		tweetTextarea.setText(tweet.getText());
		tweetTextarea.setBounds(27, 105, 697, 285);
		tweetTextarea.setEditable(false);
		tweetTextarea.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(tweetTextarea);
		
		JScrollPane tweetsScrollPane = new JScrollPane(tweetTextarea);
		tweetsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		tweetsScrollPane.setBounds(29, 105, 699, 308);
		
		frame.getContentPane().add(tweetsScrollPane);
		
		
		JLabel viewTweetLabel = new JLabel("Post detail");
		viewTweetLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewTweetLabel.setBounds(24, 62, 228, 25);
		frame.getContentPane().add(viewTweetLabel);
		
		JButton backButton = new JButton("Kembali");
		backButton.setBounds(27, 11, 89, 23);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				homePage(true);
			}
		});
		
		// Revalidate and repaint to ensure the new components are displayed
	    frame.getContentPane().revalidate();
	    frame.getContentPane().repaint();
	}
}
