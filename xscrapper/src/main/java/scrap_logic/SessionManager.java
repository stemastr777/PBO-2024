package scrap_logic;


import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Cookie;


public class SessionManager {
	
	private Browser browser;
	private BrowserContext ctx;
	private ArrayList<Cookie> cookies = new ArrayList<Cookie>();
	
	public SessionManager() {
		try {
            this.browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            
            this.ctx = this.browser.newContext();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BrowserContext getContext() {
		return this.ctx;
	}
	
	public void setCookie(Cookie xcookie) {
		this.cookies.add(xcookie);
		this.ctx.addCookies(this.cookies);
		
		System.out.println("Cookie berhasil ditambahkan ke dalam context.");
	}
	
	public void closeBrowser() {
		try {
			this.ctx.close();
			this.browser.close();
			System.out.println("Browser has been terminated");
		} catch (Exception e) {
			System.out.println("Browser cant be terminated. Something went wrong.");
		}
	}
	
	
	
}
