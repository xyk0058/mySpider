package mySpider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;

public class Main {
	
	//private static String startUrl = "http://pt.zhixing.bjtu.edu.cn/torrents/573294/";
	private static String startUrl = "http://pt.zhixing.bjtu.edu.cn/search/";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Spider githubSpider = Spider.create(new MyPageProcessor()).
				 addUrl(startUrl).addPipeline(new ConcolePipeline()).thread(5);
		 SpiderMonitor.instance().register(githubSpider);
		 githubSpider.run();
	}

}
