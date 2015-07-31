// ==============================================
// ���α׷���     : �ȵ���̵��� ����� ���̵�
// �ҽ� ������    : ��뿬
// XML ������     : ��λ�
// ���ʰ��߳�¥ : 2011.05.16
// ����������¥ : 2011.05.21
// ==============================================
package kyy.augm.com;            // ��Ű����

// import �׸�

import android.app.Activity;     
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

//==============================================
// AndroidUserGuideMain Class
// ���� : �α� ȭ�� 
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
		
		//toast�� ����
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
				// ���� ��ư ȭ��(SubMain.java) �̵�
				i = new Intent(AndroidUserGuideMain.this, SubMain.class); 
				startActivity(i);
				// ���� �̵�
				overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
				finish();
			}
		});
    }
}