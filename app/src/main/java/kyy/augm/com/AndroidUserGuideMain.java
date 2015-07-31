// ==============================================
// 프로그램명     : 안드로이드폰 사용자 가이드
// 소스 제작자    : 김용연
// XML 제작자     : 길민상
// 최초개발날짜 : 2011.05.16
// 최종수정날짜 : 2011.05.21
// ==============================================
package kyy.augm.com;            // 패키지명

// import 항목

import android.app.Activity;     
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

//==============================================
// AndroidUserGuideMain Class
// 설명 : 로그 화면 
//==============================================
public class AndroidUserGuideMain extends Activity {
    /** Called when the activity is first created. */
	public static boolean TabFlag = false;
	
	ImageView iv;
	Intent i;
	
	public static void mToast(Context c){
		//Toast mToast = new Toast (this);
		Toast mToast = new Toast (c);
		//view layout inflate
		//View view = View.inflate(this, R.layout.toast, null); 
		View view = View.inflate(c, R.layout.toast, null);
		ImageView image = (ImageView)view.findViewById(R.id.toast_img);
		image.setBackgroundResource(R.drawable.drag);
		
		//toast에 적용
		mToast.setView(view);
		mToast.setGravity(Gravity.TOP, 0, 220);
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.show();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        iv = (ImageView)findViewById(R.id.ImageView01);       
        iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 서브 버튼 화면(SubMain.java) 이동
				i = new Intent(AndroidUserGuideMain.this, SubMain.class); 
				startActivity(i);
				// 줌인 이동
				overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
				finish();
			}
		});
    }
}