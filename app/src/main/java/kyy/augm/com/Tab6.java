package kyy.augm.com;

import java.util.ArrayList;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//==============================================
//Tab6 Class
//설명 : 환경설정화면
//==============================================
public class Tab6 extends NavigationActivity {

	ListView lv, lv2;
	ImageView iv;
	Intent i;
	Intent intent;
	Button bt;
	TextView tv1, tv2, tv3, tv4;

	// RSS 클래스를 사용하기 위해 선언
	RssCommon rc = new RssCommon();

	// Member 클래스를 사용하기 위해 선언
	Member m = new Member();

	String[] title = { "WIFI 설정 방법", "블루투스 설정 방법", "USB연결 방법", "응용프로그램 관리"};

	int img[] = { R.drawable.icon_wifi, R.drawable.icon_bluetooth,
			R.drawable.icon_usb, R.drawable.icon_app };

	private void option() { // 환경설정앱 호출
		try {
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.setComponent(new ComponentName("com.android.settings",
					"com.android.settings.Settings"));
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(this, "이폰에서 환경설정 모듈을 확인할 수 없습니다.", 0).show();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ActionView_Intent.TabFlag = true;

		setContentView(R.layout.listview_6);

		// 위젯 바인딩
		lv = (ListView) findViewById(R.id.ListView01);
		lv2 = (ListView) findViewById(R.id.ListView04);
		bt = (Button) findViewById(R.id.Button07);

		bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				option();
			}
		});

		Tab4AdapterTop sa = new Tab4AdapterTop(this, title, img);
		lv.setAdapter(sa);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				moveApp(position);

			}

		});

		InternetChk ic = new InternetChk(this);
		if (ic.isOnline() != false || ic.isOnlineToWifi() != false
				|| ic.isOnlineToMobile() != false) {
			final ArrayList<Member> titleList = (ArrayList) rc.getXmlData();

			Tab4AdapterBottom sa2 = new Tab4AdapterBottom(this, titleList);
			lv2.setAdapter(sa2);

			lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					m = titleList.get(position);
					intent = new Intent(Tab6.this, Tab6Sub_5.class);
					intent.putExtra("Tab6", m.getDescription());
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					goNextHistory("Tab6", intent);
				}

			});
		} else {
			Toast.makeText(this, "인터넷 연결을 확인하세요.", 0).show();

			try {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.setComponent(new ComponentName("com.android.settings",
						"com.android.settings.Settings"));
				startActivity(intent);
			} catch (Exception e) {
				Toast.makeText(this, "이폰에서 환경설정 모듈을 확인할 수 없습니다.", 0).show();
			}
		}
	}

	private void moveApp(int position) {
		switch (position) {
		case 0:
			intent = new Intent(this, Tab6Sub_1.class);
			intent.putExtra("Tab6", "0");
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			goNextHistory("Tab6", intent);
			break;
		case 1:
			intent = new Intent(this, Tab6Sub_2.class);
			intent.putExtra("Tab6", "1");
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			goNextHistory("Tab6", intent);
			break;
		case 2:
			intent = new Intent(this, Tab6Sub_3.class);
			intent.putExtra("Tab6", "2");
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			goNextHistory("Tab6", intent);
			break;

		case 3:
			intent = new Intent(this, Tab6Sub_4.class);
			intent.putExtra("Tab6", "3");
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			goNextHistory("Tab6", intent);

			break;
		}
	}

	// 상단부 리스트뷰
	class Tab4AdapterTop extends BaseAdapter {
		private LayoutInflater inflater;
		private String[] title;
		private int[] img;

		Tab4AdapterTop(Context context, String[] title, int[] img) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.title = title;
			this.img = img;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return title[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_row2, parent,
						false);

				TextView tv_str1 = (TextView) convertView
						.findViewById(R.id.TextView04);
				ImageView lv_img1 = (ImageView) convertView
						.findViewById(R.id.ImageView05);

				tv_str1.setText(title[position]); // 제목
				lv_img1.setImageResource(img[position]); // 아이콘

			}

			return convertView;
		}

	}

	// 하단부 리스트뷰
	class Tab4AdapterBottom extends BaseAdapter {
		private LayoutInflater inflater;
		ArrayList<Member> titleList = new ArrayList<Member>();

		Tab4AdapterBottom(Context context, ArrayList<Member> titleList) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.titleList = titleList;
			// this.img = img;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return titleList.size();
		}

		@Override
		public Member getItem(int position) {
			// TODO Auto-generated method stub
			return titleList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_row3, parent,
						false);

				TextView tv_str1 = (TextView) convertView
						.findViewById(R.id.TextView10);
				TextView tv_str2 = (TextView) convertView
						.findViewById(R.id.TextView11);

				m = titleList.get(position);

				tv_str1.setText(m.getTitle()); // 제목
				tv_str2.setText(m.getDate()); // 날짜

			}

			return convertView;
		}

	}

}
