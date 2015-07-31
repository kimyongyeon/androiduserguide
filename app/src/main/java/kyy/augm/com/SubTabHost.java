package kyy.augm.com;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.talk.KakaoLink;

//==============================================
//SubTabHost Class
//���� : ��ȣ��Ʈ�й� ȭ��
//==============================================
public class SubTabHost extends TabActivity {
	Intent i;
	TabHost tabHost;
	
	String message = "�ȵ���̵� �ʺ��� ���̵� ������ ��õ�մϴ�.";
	String referenceURLString = "https://market.android.com/details?id=kyy.augm.com&feature=search_result";
	String appPackageId = "kyy.augm.com";
	String appVersion = "2.1";

	KakaoLink kakaoLink = null;
	
	//�޴� ��ư�� ó�� 1ȸ ������ �� ȣ��
    public boolean onCreateOptionsMenu (Menu menu){    	
    	MenuItem mi1 = menu.add(0, 0, Menu.NONE, "��۴ޱ�");
    	mi1.setIcon(R.drawable.menu_icon01);
    	MenuItem mi2 = menu.add(0, 1, Menu.NONE, "�̸��Ϻ�����");
    	mi2.setIcon(R.drawable.menu_icon02);
    	
    	MenuItem mi3 = menu.add(0, 2, Menu.NONE, "����õ");
    	mi3.setIcon(R.drawable.menu_icon03);
   	
    	return true;
    }
    
    private View v;
    private TextView tv1,tv2,tv3,tv4,tv5;  
    private void initCustom(){
    	v = View.inflate(this, R.layout.customdialog, null);
    	
    	tv1 = (TextView)v.findViewById(R.id.c_Txt1);
    	tv2 = (TextView)v.findViewById(R.id.c_Txt2);
    	tv3 = (TextView)v.findViewById(R.id.c_Txt3);
    	tv4 = (TextView)v.findViewById(R.id.c_Txt4);
    	tv5 = (TextView)v.findViewById(R.id.c_Txt5);
    	
    	
    	View.OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()){
					case R.id.c_Txt1:
						//showMsg("īī����", 0);
						try{
							kakaoLink = new KakaoLink(SubTabHost.this, referenceURLString, appPackageId, appVersion, message, "UTF-8");
							if (kakaoLink.isAvailable()) {
							    startActivity(kakaoLink.getIntent());
							} else {
							    // īī������ ��ġ�Ǿ� ���� ���� ��쿡 ���� ó��
								Toast.makeText(SubTabHost.this, "īī������ ��ġ���� �ʾҽ��ϴ�.", 0);
								
								Uri uri = Uri.parse("market://details?id=com.kakao.talk");
								Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);  
								startActivity(intent2); 
							}
						}catch(Exception e){
							
						}
						break;
					case R.id.c_Txt2:
						//showMsg("���̽���", 0);
						Intent intent1 = new Intent(Intent.ACTION_VIEW,
					    Uri.parse("http://www.facebook.com/"));
						startActivity(intent1);
						break;
					case R.id.c_Txt3:
						//showMsg("��������", 0);
						Intent intent2 = new Intent(Intent.ACTION_VIEW,
					    Uri.parse("http://m.me2day.net/"));
						startActivity(intent2);
						break;
					case R.id.c_Txt4:
						//showMsg("�̸���", 0);
						Intent i = new Intent(
			    		Intent.ACTION_SENDTO, 
			    		Uri.parse("mailto:"));
						i.putExtra(Intent.EXTRA_TEXT, message+referenceURLString);
						startActivity(i);
						break;
					case R.id.c_Txt5:
						//showMsg("���ڸ޼���", 0);
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.putExtra("sms_body", message+referenceURLString);
						intent.setType("vnd.android-dir/mms-sms");
						startActivity(intent);
						break;
				}				
				
			}
		};
		
		tv1.setOnClickListener(listener);
		tv2.setOnClickListener(listener);
		tv3.setOnClickListener(listener);
		tv4.setOnClickListener(listener);
		tv5.setOnClickListener(listener);
    	
    }
    
    private void customDialog(){
    	// Ŀ���� ���̾�α׸� ���ÿ�.
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	//builder.setIcon(R.drawable.mammoth);
    	builder.setTitle("���� ��� ����");
    	//builder.setNeutralButton("Ȯ��", null);
    	//builder.setNegativeButton("���",null);
    	initCustom();
    	builder.setView(v);
    	builder.show();
    }
    
    public boolean onOptionsItemSelected (MenuItem item){
    	int gId = item.getGroupId();
    	int iId = item.getItemId();
    	if(gId == 0){
    		switch (iId) { 
				case 0: 
					//showMsg("��۴ޱ�", 0); 
					Uri uri = Uri.parse("market://details?id=kyy.augm.com");
					Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);  
					startActivity(intent2); 
					break;
				case 1: 
					//showMsg("�̸��Ϻ�����", 0);				
					Intent intent = new Intent(
				    Intent.ACTION_SENDTO, 
				    Uri.parse("mailto:toyongyeon@gmail.com,gilminsang@gmail.com"));
					startActivity(intent);
					break;
				case 2: 
					//showMsg("����õ", 0);
					customDialog();
					break;
			}
    	}else { //gId == 1
    		switch (iId) {
				case 0: 
					//showMsg("īī����", 0);
					try{
						kakaoLink = new KakaoLink(SubTabHost.this, referenceURLString, appPackageId, appVersion, message, "UTF-8");
						if (kakaoLink.isAvailable()) {
						    startActivity(kakaoLink.getIntent());
						} else {
						    // īī������ ��ġ�Ǿ� ���� ���� ��쿡 ���� ó��
						}
					}catch(Exception e){
						
					}
					break;
				case 1: 
					//showMsg("���̽���", 0);
					Intent intent1 = new Intent(Intent.ACTION_VIEW,
				    Uri.parse("http://www.facebook.com/"));
					startActivity(intent1);
					break;
				case 2: 
					//showMsg("��������", 0);
					Intent intent2 = new Intent(Intent.ACTION_VIEW,
				    Uri.parse("http://m.me2day.net/"));
					startActivity(intent2);
					break;					
				case 3: 
					//showMsg("�̸���", 0);
					Intent i = new Intent(
		    		Intent.ACTION_SENDTO, 
		    		Uri.parse("mailto:"));
					startActivity(i);
					break;
				case 4: 
					//showMsg("���ڸ޼���", 0);
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.putExtra("sms_body", message);
					intent.setType("vnd.android-dir/mms-sms");
					startActivity(intent);
					break;
    		}
    	}
    	
    	return true;
    }
    
/*    private void showMsg(String msg, int option){
    	Toast.makeText(this, msg, option).show();
    }*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subtabhost);
		i = getIntent();
		String value = i.getStringExtra("SubMain");
		int _idx = Integer.parseInt(value);

		tabHost = getTabHost();	
		TabHost.TabSpec spec;
		Intent intent;
		
		
		// �巡�� Toast���� Flag	
		if(_idx == 1 || _idx == 2 || _idx == 3 ){
			AndroidUserGuideMain.TabFlag = true;
		}
		
		// �ʱ�
		intent = new Intent().setClass(this, Tab1.class);
		intent.putExtra("SubTabHost", "1");
		spec = tabHost.newTabSpec("tab1").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_01))
				.setContent(intent);	
		tabHost.addTab(spec);
		// �߱�
		intent = new Intent().setClass(this, Tab2.class);
		intent.putExtra("SubTabHost", "2");
		spec = tabHost.newTabSpec("tab2").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_02))
				.setContent(intent);
		tabHost.addTab(spec);
		// ���
		intent = new Intent().setClass(this, Tab3.class);
		intent.putExtra("SubTabHost", "3");
		spec = tabHost.newTabSpec("tab3").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_03))
				.setContent(intent);
		tabHost.addTab(spec);
		// ȯ�漳��
		intent = new Intent().setClass(this, Tab6Group.class);
		spec = tabHost.newTabSpec("tab6Group").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_06))
				.setContent(intent);
		tabHost.addTab(spec);
		// ��õ����
		intent = new Intent().setClass(this, Tab5.class);
		spec = tabHost.newTabSpec("tab4").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_04))
				.setContent(intent);
		tabHost.addTab(spec);
		// ��õ��
		intent = new Intent().setClass(this, Tab4.class);
		spec = tabHost.newTabSpec("tab5").setIndicator("",
				getResources().getDrawable(R.drawable.t_icon_05))
				.setContent(intent);
		tabHost.addTab(spec);
	
		// ������ ����
		switch (_idx){
			case 1: tabHost.setCurrentTab(0); break;  
			case 2: tabHost.setCurrentTab(1); break; 
			case 3: tabHost.setCurrentTab(2); break; 
			case 4: tabHost.setCurrentTab(5); break; 
			case 5: tabHost.setCurrentTab(4); break; 
			case 6:	tabHost.setCurrentTab(3); break; 
		}
		
		//tabHost.setCurrentTabByTag("tab1");
	}
}
