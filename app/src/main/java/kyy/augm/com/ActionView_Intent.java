package kyy.augm.com;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ActionView_Intent {
	Context c;
	ActionView_Intent(Context c){
		this.c = c;
	}
	// Browser에서 URL 호출하기
	public void webMove(String str){ 
		Intent intent = new Intent(Intent.ACTION_VIEW,
    		Uri.parse(str));
		c.startActivity(intent);
    }
	// 마켓에서 특정앱 검색
	public void appMove(String str){ 
		//market://search?q=SK+Communications
    	//Uri uri = Uri.parse("market://search?q=pname:soo.location.sos");  
    	Uri uri = Uri.parse("market://details?id=" + str);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);  
		c.startActivity(intent);  
    }
	// 환경설정앱 호출
	public void opMove(){   
    	Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setComponent(new ComponentName(
				"com.android.settings", 
				"com.android.settings.Settings"));
		c.startActivity(intent);
    }
}
