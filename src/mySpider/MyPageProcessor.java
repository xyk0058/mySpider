package mySpider;

import java.util.ArrayList;
import java.util.List;

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
//		page.addTargetRequests(page.getHtml().xpath("//*[@id=\"zh-profile-follows-list\"]/div/div/a").all());
//		page.addTargetRequests(page.getHtml().xpath("//*[@id=\"zh-profile-follows-list\"]/div/div/a/@href").all());
		String url = page.getUrl().get();
		if (url.contains("followees")) {
			List<String> list = page.getHtml().xpath("//*[@id=\"zh-profile-follows-list\"]/div/div/a/@href").all();
			List<String> urlList = new ArrayList<String>();
			for (int i=0; i<list.size(); ++i) {
				String tmp = list.get(i);
				urlList.add(tmp + "/followees");
//				page.putField("url"+i, tmp + "/followees");
			}
			page.addTargetRequests(urlList);
			System.out.println("TEST: " + urlList.get(0) + " " + urlList.get(1));
		}
//		System.out.println("TEST: " + page.getHtml());
		
//		if(page.getUrl().regex(listpage).match()){
//			//List<String> list = page.getHtml().css("div.pager").links().regex("http://pt.zhixing.bjtu.edu.cn/search/p*").all();
//			page.addTargetRequests(page.getHtml().css("div.pager").links().regex(listpage).all());
//			page.addTargetRequests(page.getHtml().links().regex(contentpage).all());
//			System.out.println("TEST: " + page.getHtml().xpath("/html/body/"));
//		}
//		else if(page.getUrl().regex(contentpage).match()){
//			page.putField("torrentsName", page.getHtml().xpath("//*[@id=\"ct\"]/ul/li[3]/span/text()"));
//			//System.out.println(page.getHtml().xpath("/html/body/"));
//		}
	}
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub	
		site.addCookie("z_c0", "QUJCS3hWbERWZ2tYQUFBQVlRSlZUZDY3UGxmbXRGd09OaVZPSzllOU40bHNiX1ZJQUVuR3BRPT0=|1461137118|8def267ce3c6590935461e666ad3a6ebaa797cf6");
		site.addCookie("udid", "AABADaRangmPTvXpk22W0NRAHCURmsArWVg=|1458025784");
		site.addCookie("q_c1", "5c0c7a7ee88f49b3a0049b5829541172|1460685802000|1458025784000");
		site.addCookie("login", "OGQzZjVkNDA2NGI4NDgzZmFhNzEyYTBkMTgyZTkyNDM=|1461136749|2fa529e0e975bb2c8d2d57abdb263af31a66f05e");
		site.addCookie("l_n_c", "1");		
		site.addCookie("l_cap_id", "ODZkYzEyNmEwZWRkNGNlNmI3NTQzOGRlYzM0MGFhMzM=|1461137077|897a2ce91e5fce4ed66b53a28019bbd2e9fcc6c2");	
		site.addCookie("d_c0", "AIBAQxAcqgmPTquRNcsdINsXbCzN7HA9LJY=|1458814686");		
		site.addCookie("cap_id", "YmExOWFhNjg3MDFmNGFhOThkOTIwM2I4MmZiYmFkNjE=|1461136724|c3a51c283443b193c392e151f0da5ef0f3ca984f");
		site.addCookie("_zap", "33390e33-6f10-4704-bf6a-c53ca2dcddb9");
		site.addCookie("_za", "c0c75fdb-2c83-46f4-b21d-4686429c1fa5");
		site.addCookie("_xsrf", "dad01ec70a4830246e0c1ba06855eabc");
		site.addCookie("__utmz", "51854390.1461133144.19.18.utmcsr=baidu|utmccn=(organic)|utmcmd=organic");
		site.addCookie("__utmv", "51854390.100-1|2=registration_date=20160119=1^3=entry_date=20160119=1");
		site.addCookie("__utmc", "51854390");
		site.addCookie("__utmb", "51854390.38.10.1461136724");
		site.addCookie("__utma", "51854390.2835630.1458025786.1461133144.1461136724.20");
		site.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:23.0) Gecko/20100101 Firefox/23.0");
		return site;
	}
	
}
