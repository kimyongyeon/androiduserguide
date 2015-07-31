package kyy.augm.com;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.Toast;

//==============================================
//Tab1 Class
//설명 : 초급 화면
//==============================================
public class Tab1 extends Activity {

	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabweb);

		Intent i = getIntent();
		String index = i.getStringExtra("SubTabHost");

		if (index.equals("1")) {

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
				// wv.setWebViewClient(new InfoWebViewClient()); // 중요
				wv.setWebViewClient(new InfoWebViewClient()); // 중요

				String data = "file:///android_asset/Tab1.htm";
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

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		new CommonManagement(this).clearApplicationCache(null);
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
					AndroidUserGuideMain.mToast(Tab1.this);
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
