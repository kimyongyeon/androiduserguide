package kyy.augm.com;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

//==============================================
//Tab5 Class
//설명 : 웹화면
//==============================================
public class Tab5 extends Activity {
	DialogCommon dc;
	TextView tv;
	
	String[] title = {
			"게임다운 사이트",
			"칸드로이드",
			"맛클",      
			"테그라크",    
			"초코릿왕자님",
			"안플",    
			"안사모",    
			"스사모"     
			};
	String[] contents = {
			"apk파일로 된 게임을 다운 받을수 있음",         
			"구글 안드로이드 기술 커뮤니티,세미나,교육,책",
			"국내최고 안드로이드 커뮤니티", 
			"속도패치",               
			"테그라크 쉬운설명",         
			"안드로이드폰 사용자 모임1",  
			"안드로이드폰 사용자 모임2",  
			"스마트폰 사용자 모임",
			};
	
	ListView lv;
	LinearLayout ll = null;
	
	Intent intent;
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		intent = new Intent(this, SubMain.class); // 초급 
		//i.putExtra("SubMain", "1");
		startActivity(intent);
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//ActionView_Intent.TabFlag = true;
		
		setContentView(R.layout.listview_5);			
		
		lv = (ListView)findViewById(R.id.ListView02);
		tv = (TextView)findViewById(R.id.TextView05);
		tv.setSelected(true);
		Tab4Adapter sa = new Tab4Adapter(this, title, contents);
		
    	lv.setAdapter(sa);
    	
    	lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				dc = new DialogCommon(Tab5.this);
				dc.DiaMove(title[arg2], 2, arg2);
				// TODO Auto-generated method stub
				
				//Toast.makeText(Tab5.this, title[arg2], 0).show();
			}
    		
		});
	}
	
	class Tab4Adapter extends BaseAdapter {
		private LayoutInflater inflater;
		private String[] title;
		private String[] contents;
		
		Tab4Adapter(Context context, String[] title, String[] contents){
			inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.title = title;
			this.contents = contents;
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
			if(convertView == null){
				convertView = inflater.inflate(R.layout.list_row, parent, false);
				
				/*ll = (LinearLayout)convertView.findViewById(R.id.LinearLayout01);
				if((position%2) == 1){ 
				    ll.setBackgroundColor(Color.rgb(400, 400, 400)); // 홀수행 회색
					//ll.setBackgroundColor(Color.GRAY); // 홀수행 회색
				}else{
					ll.setBackgroundColor(Color.WHITE); // 작수행 흰색
				}*/
				
				TextView tv_str1 = (TextView)convertView.findViewById(R.id.TextView02);
				TextView tv_str2 = (TextView)convertView.findViewById(R.id.TextView03);
				ImageView lv_img1 = (ImageView)convertView.findViewById(R.id.ImageView03);
				tv_str1.setText(title[position]);            // 제목
				tv_str2.setText(contents[position]);         // 내용
				lv_img1.setImageResource(R.drawable.websearch);	 // 아이콘
			}
	
			return convertView;
		}
		
	}
}
