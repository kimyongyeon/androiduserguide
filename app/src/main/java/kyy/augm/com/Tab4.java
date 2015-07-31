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
//Tab4 Class
//설명 : 추천어플화면
//==============================================
public class Tab4 extends Activity {
	AppData ac = new AppData();
	private class List{
		String[] title = ac.getTitle();
		String[] contents = ac.getContents();
		int icons[] = ac.getIcons();
		int tCnt = title.length;
	}
	
	ListView lv;
	LinearLayout ll = null;
	DialogCommon dc;
	List list = new List();
	
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
		setContentView(R.layout.listview_4);			
		
		lv = (ListView)findViewById(R.id.ListView03);
		
		Tab4Adapter sa = new Tab4Adapter(this, list);
		
    	lv.setAdapter(sa);
    	
    	lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				dc = new DialogCommon(Tab4.this);
				dc.DiaMove(list.title[arg2], 1, arg2);
				//Toast.makeText(Tab4.this, list.title[arg2], 0).show();
			}
    		
		});
	}
	
	class Tab4Adapter extends BaseAdapter {
		private LayoutInflater inflater;
		private List list;
		
		Tab4Adapter(Context context, List list){
			inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.list = list;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.tCnt;
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return list.title[position];
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
			}
			TextView tv_str1 = (TextView)convertView.findViewById(R.id.TextView02);
			TextView tv_str2 = (TextView)convertView.findViewById(R.id.TextView03);
			ImageView lv_img1 = (ImageView)convertView.findViewById(R.id.ImageView03);
			
			for(int i=0; i<list.tCnt; i++)
			{
				tv_str1.setText(list.title[position]);            // 제목
				tv_str2.setText(list.contents[position]);         // 내용
				lv_img1.setImageResource(list.icons[position]);	 // 아이콘	
			}
	
			return convertView;
		}
		
	}
}
