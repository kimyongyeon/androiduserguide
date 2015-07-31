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
	// Browser���� URL ȣ���ϱ�
	public void webMove(String str){ 
		Intent intent = new Intent(Intent.ACTION_VIEW,
    		Uri.parse(str));
		c.startActivity(intent);
    }
	// ���Ͽ��� Ư���� �˻�
	public void appMove(String str){ 
		//market://search?q=SK+Communications
    	//Uri uri = Uri.parse("market://search?q=pname:soo.location.sos");  
    	Uri uri = Uri.parse("market://details?id=" + str);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);  
		c.startActivity(intent);  
    }
	// ȯ�漳���� ȣ��
	public void opMove(){   
    	Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setComponent(new ComponentName(
				"com.android.settings", 
				"com.android.settings.Settings"));
		c.startActivity(intent);
    }
}
