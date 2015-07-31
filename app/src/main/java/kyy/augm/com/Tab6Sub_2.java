package kyy.augm.com;

import android.app.Activity;
import android.app.ProgressDialog;
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
public class Tab6Sub_2 extends NavigationActivity {

	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;
	Intent intent;
	Intent i;
	String data[] = {
			"file:///android_asset/Tab6Sub_1.htm","file:///android_asset/Tab6Sub_2.htm",
			"file:///android_asset/Tab6Sub_3.htm","file:///android_asset/Tab6Sub_4.htm"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab6sub);
		
		
		i = getIntent();
		String value = i.getStringExtra("Tab6");
		int _idx = Integer.parseInt(value);

		wv = (WebView) findViewById(R.id.WebView02);
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
		
		wv.loadUrl(data[_idx]);
		
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
				try{
					mProgress.show();
				}catch(Exception e){
					Toast.makeText(Tab6Sub_2.this, "Please wait for few second...", 1);
					e.getStackTrace();
				}
			}
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Auto-generated method stub
			//Toast.makeText(activity, "Loading Error" + description,
			//		Toast.LENGTH_SHORT).show();

			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}
	}
}


