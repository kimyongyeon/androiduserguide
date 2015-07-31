package kyy.augm.com;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class RssCommon {
	// �ǽð� ������Ʈ XML
	private final String rss = "http://augm.tistory.com/rss";

	// Member Ŭ���� ����
	Member m = new Member();

	public ArrayList<Member> getXmlData() {
		ArrayList<Member> titleList = new ArrayList<Member>();
		boolean isFlag = false;

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8"); // XML�� �Ѿ�� ���ڵ� �κ� ����XML������ ���ڵ� �κа� �����ϰ�
			// �ؾ� ����� ����� ����ϴ�.
			// �Ʒ� �κ��� XML �κ��̱� ������ �˾Ƽ� ���ͳ��̳� ���������� �����ϼ���.
			int eventType = xpp.getEventType();
			Member m = new Member();
			String title = "";
			String description = "";
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("item")) {
						isFlag = true;
					}
					if (isFlag == true) {
						if (xpp.getName().equals("title")) { // ����
							title = xpp.nextText();
						}
						if (xpp.getName().equals("guid")) { // 
							description = xpp.nextText();
						}
						if (xpp.getName().equals("pubDate")) {
							m = new Member();
							m.setTitle(title);
							m.setDescription(description);
							m.setDate(dataTodate(xpp.nextText()));
							titleList.add(m);
						}
					}
				}

				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return titleList;
	}

	// ��¥��ȯ �޼ҵ�
	private String dataTodate(String dateData) {
		// String date = "Mon, 30 May 2011 14:52:55 +0900";
		String date = dateData;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		Date pubdate = new Date(Date.parse(date));
		date = sdf.format(pubdate);
		return date;
	}
}
