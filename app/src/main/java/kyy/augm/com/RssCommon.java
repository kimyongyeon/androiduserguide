package kyy.augm.com;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class RssCommon {
	// 실시간 업데이트 XML
	private final String rss = "http://augm.tistory.com/rss";

	// Member 클래스 선언
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
			xpp.setInput(is, "UTF-8"); // XML로 넘어는 인코딩 부분 서버XML파일의 인코딩 부분과 동일하게
			// 해야 제대로 결과를 얻습니다.
			// 아래 부분은 XML 부분이기 때문에 알아서 인터넷이나 참고서적으로 공부하세요.
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
						if (xpp.getName().equals("title")) { // 제목
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

	// 날짜변환 메소드
	private String dataTodate(String dateData) {
		// String date = "Mon, 30 May 2011 14:52:55 +0900";
		String date = dateData;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		Date pubdate = new Date(Date.parse(date));
		date = sdf.format(pubdate);
		return date;
	}
}
