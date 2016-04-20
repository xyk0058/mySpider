package mySpider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyPageProcessor implements PageProcessor{
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	private String listpage = "http://pt\\.zhixing\\.bjtu\\.edu\\.cn/search/*";
	private String contentpage = "http://pt\\.zhixing\\.bjtu\\.edu\\.cn/torrents/*";

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		
		if(page.getUrl().regex(listpage).match()){
			//List<String> list = page.getHtml().css("div.pager").links().regex("http://pt.zhixing.bjtu.edu.cn/search/p*").all();
			page.addTargetRequests(page.getHtml().css("div.pager").links().regex(listpage).all());
			page.addTargetRequests(page.getHtml().links().regex(contentpage).all());
			System.out.println("TEST: " + page.getHtml().xpath("/html/body/"));
		}
		else if(page.getUrl().regex(contentpage).match()){
			page.putField("torrentsName", page.getHtml().xpath("//*[@id=\"ct\"]/ul/li[3]/span/text()"));
			//System.out.println(page.getHtml().xpath("/html/body/"));
		}
	}
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		site.addCookie("cgbt_password", "okEopgHxc68yHbDKXnJiaZZUJUncfHwfgW8WIWXRiv5TwAeFHYk13j");
		site.addCookie("cgbt_uid", "5bb0a6f14eabac02b811efUSEyevSDMcCUTwOvhlOI0790TXkBkCx9");
		site.addCookie("PHPSESSID", "q5ga7gpo65sm1m99cgjrhuqod1");
		site.addCookie("zhixing_9328_auth", "fJBEvZrchAUiA9c7YbQ0ytVgynN91mHhX73KjE1EMmqroYneQCmxZs");
		site.addCookie("zhixing_9328_lastact", "1448936781%09uc.php%09");
		//site.addCookie("zhixing_9328_lastvisit", "1448933181");
		site.addCookie("zhixing_9328_saltkey", "AmZs0nII");
		site.addCookie("zhixing_9328_sid", "fd7ZEz");
		return site;
	}
	
}
