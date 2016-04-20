package mySpider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;

public class Main {
	
	//private static String startUrl = "http://pt.zhixing.bjtu.edu.cn/torrents/573294/";
	private static String startUrl = "https://www.zhihu.com/people/kong-xiang-yuan-92/followees";
//	private static String startUrl = "https://www.baidu.com";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Spider zhihuSpider = Spider.create(new MyPageProcessor()).
				 addUrl(startUrl).addPipeline(new FilePipeline()).addPipeline(new ConcolePipeline()).thread(5);
		 SpiderMonitor.instance().register(zhihuSpider);
		 zhihuSpider.run();
	}

}
