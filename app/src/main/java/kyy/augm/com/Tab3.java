package kyy.augm.com;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.Toast;

//==============================================
//Tab1 Class
//설명 : 중급 화면
//==============================================
public class Tab3 extends Activity {

	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabweb);

		Intent i = getIntent();
		String index = i.getStringExtra("SubTabHost");

		if (index.equals("3")) {

			InternetChk ic = new InternetChk(this);
			if (ic.isOnline() != false || ic.isOnlineToWifi() != false
					|| ic.isOnlineToMobile() != false) {
				wv = (WebView) findViewById(R.id.WebView01);
				ws = wv.getSettings();

				// Zoom을 지원할지 지정합니다.
				ws.setSupportZoom(true);
				// WebView에 내장된 zoom mechanism이 사용되고 있으면 treu를 돌려 줍니다.
				ws.setBuiltInZoomControls(true);
				ws.setDefaultZoom(ZoomDensity.FAR);
				ws.setUseWideViewPort(true);
				wv.setBackgroundColor(Color.BLACK);
				wv.setHorizontalScrollBarEnabled(false);
				wv.setWebViewClient(new InfoWebViewClient()); // 중요
				String data = "file:///android_asset/Tab3.htm";
				wv.loadUrl(data);
			} else {
				Toast.makeText(this, "인터넷 연결을 확인하세요.", 0).show();

				try {
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setComponent(new ComponentName(
							"com.android.settings",
							"com.android.settings.Settings"));
					startActivity(intent);
				} catch (Exception e) {
					Toast.makeText(this, "이폰에서 환경설정 모듈을 확인할 수 없습니다.", 0).show();
				}
			}
		}

	}

	Intent intent;

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		intent = new Intent(this, SubMain.class); // 초급
		startActivity(intent);
		finish();
	}

	class InfoWebViewClient extends WebViewClient {
		/**
		 * url 주소에 해당하는 웹페이지를 로딩
		 */
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);

			// 안드로이드 자체 WebView가 아닌 내가 만든 WebView 직접 사용한다고 명시
			return true;
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			if (mProgress == null) {
				mProgress = new ProgressDialog(activity);
				mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				mProgress.setTitle("Loading...");
				mProgress.setMessage("Please wait for few second...");
				mProgress.setCancelable(false);
				mProgress.setButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int whichButton) {
								mProgress.dismiss();
							}
						});

				if (AndroidUserGuideMain.TabFlag == true) {
					AndroidUserGuideMain.TabFlag = false;
					AndroidUserGuideMain.mToast(Tab3.this);
					mProgress.show();
				}
			}
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Auto-generated method stub
			Toast.makeText(activity, "Loading Error" + description,
					Toast.LENGTH_SHORT).show();

			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}
	}
}

/*
 * package kyy.augm.com;
 * 
 * import android.app.Activity; import android.content.Intent; import
 * android.view.MotionEvent; import android.view.View; import android.widget.*;
 * import android.os.Bundle;
 * 
 * //============================================== //Tab3 Class //설명 : 고급 화면
 * //============================================== public class Tab3 extends
 * Activity implements View.OnTouchListener{ private ImageView iv; DialogCommon
 * dc; //private Field fields[] = R.drawable.class.getFields();
 * 
 * private Integer[] img = {
 * R.drawable.high00,R.drawable.high01,R.drawable.high02,R.drawable.high03,
 * R.drawable.high04,R.drawable.high05,R.drawable.high06,R.drawable.high07,
 * R.drawable.high08 };
 * 
 * @Override protected void onCreate(Bundle savedInstanceState) { // TODO
 * Auto-generated method stub super.onCreate(savedInstanceState);
 * setContentView(R.layout.tabimg);
 * 
 * iv = (ImageView)findViewById(R.id.ImageView04); iv.setOnTouchListener(this);
 * 
 * //iv.setImageResource(img[0]); iv.setBackgroundResource(img[0]); }
 * 
 * int i = 0; float x1, x2, y1, y2;
 * 
 * @Override public boolean onTouch(View v, MotionEvent event) { dc = new
 * DialogCommon(this);
 * 
 * if(event.getAction() == MotionEvent.ACTION_DOWN){ x1 = event.getX(); y1 =
 * event.getY();
 * 
 * //Log.i("(x1, y1)", "("+x1+", "+y1+")"); }else if(event.getAction() ==
 * MotionEvent.ACTION_UP){ x2 = event.getX(); y2 = event.getY();
 * 
 * //Log.i("(x2, y2)", "("+x2+", "+y2+")"); float valueX = x1 - x2; if(valueX >
 * 0){ if(i >= (img.length-1) ) i = -1; i++;
 * 
 * if(i == 5){ dc.DiaQna(); }
 * 
 * if(i == img.length-1){ dc.DiaCustom(1); } }else if(valueX < 0){ if(i <= 0) i
 * = (img.length); i--;
 * 
 * } //iv.setImageResource(img[i]); iv.setBackgroundResource(img[i]); }
 * 
 * return true; }
 * 
 * Intent intent;
 * 
 * @Override public void onBackPressed() { super.onBackPressed(); intent = new
 * Intent(this, SubMain.class); // 초급 startActivity(intent); finish(); }
 * 
 * 
 * }
 */