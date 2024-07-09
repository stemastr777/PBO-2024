package scrap_logic;


import java.util.ArrayList;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.WaitUntilState;

public class PageNavigator {
	
	private SessionManager session_manager;
	private Page page;
	private String username;
	private ArrayList<Post> post_cache;
	
	
	public PageNavigator(SessionManager session_manager) {
		
		this.session_manager = session_manager;
		this.page = session_manager.getContext().newPage();
		page.setDefaultTimeout(0);
	}
	
	public ArrayList<Post> getPostCache() {
		return this.post_cache;
	}
	
	private void setUsername() {
		
		page.navigate("https://x.com");
		this.username = page.getByTestId("SideNav_AccountSwitcher_Button").locator("span").filter(new Locator.FilterOptions().setHasText("@")).innerText();
		
	}
	
	public String getUsername() {
		if (this.username == null) {
			return "";
		}
		return this.username;
	}
	
	public SessionManager getSessionManager() {
		return this.session_manager;
	}	
	
	public void createPost(Post tweet) {
		page.navigate("https://x.com/"+this.username);
		
		
		page.getByTestId("SideNav_NewTweet_Button").focus();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		page.getByTestId("SideNav_NewTweet_Button").click();
		
		page.type("[data-testid=\"tweetTextarea_0RichTextInputContainer\"]", tweet.getText());
		
		
		
		page.getByTestId("tweetButton").click();
		
	}
	
	
	public ArrayList<Post> retrieveOwnPosts() {
	
	
		page.navigate("https://x.com/"+this.username);
		
		ArrayList<Post> posts = new ArrayList<Post>();
		
		try {
			
			page.waitForSelector("[data-testid='tweet']", new Page.WaitForSelectorOptions().setTimeout(10000));
			
			
			int prevTweetDetected = 0;
			
			Locator tweets = page.getByTestId("tweet");
			while (prevTweetDetected != tweets.count()) {
				
				try {
					prevTweetDetected = tweets.count();
					Thread.sleep(1000);
					tweets = page.getByTestId("tweet");
				} catch (Exception e) {
					e.printStackTrace();		
				}
			}
			
			
			
			for (int i = 0; i < tweets.count(); i++) {
				
				Locator tweet = tweets.locator("nth="+String.valueOf(i));
				String text = tweet.getByTestId("tweetText").locator("span").innerText();
				posts.add(new Post(text));
				
			}
			
			this.post_cache = posts;
			
		} catch (TimeoutError e) {
			System.out.println("Gagal dalam retrieve post");
			posts.add(new Post(""));
		}
		
		return posts;
		
	}
	
	
	public void loginAccount(String username, String password) {
		
		
		page.navigate("https://x.com");
		
		page.getByTestId("loginButton").click();
		page.locator("[autocomplete='username']").fill(username);
		page.keyboard().press("Enter");
				
		
		System.out.println("Filling password");
		
		page.waitForSelector("[autocomplete='current-password']", new Page.WaitForSelectorOptions().setTimeout(0));
		
		page.type("[autocomplete='current-password']", password);
		
		page.getByTestId("LoginForm_Login_Button").click();
		
		
		try {
			page.waitForURL("https://x.com/home", new Page.WaitForURLOptions().setWaitUntil(WaitUntilState.COMMIT).setTimeout(8000));
			System.out.println("Berhasil login");
		} catch (TimeoutError e) {
//			this.session_manager.closeBrowser();
			System.out.println("Gagal untuk login.");
			return;
		}
		
		
		for (Cookie cookie : page.context().cookies()) {
			if (cookie.name.equals("auth_token")) {
				
				this.session_manager.setCookie(cookie);
				
				System.out.println("Cookie Name: " + cookie.name);
                System.out.println("Auth Token Cookie Value: " + cookie.value);
				
                break;
            }
		}
		
		setUsername();
		
	}
	
	
}
