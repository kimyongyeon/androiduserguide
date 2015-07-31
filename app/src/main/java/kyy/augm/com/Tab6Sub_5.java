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
//���� : �߱� ȭ��
//==============================================
public class Tab6Sub_5 extends NavigationActivity {

	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;
	Intent intent;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab6sub);
		
		i = getIntent();
		String value = i.getStringExtra("Tab6");

		wv = (WebView) findViewById(R.id.WebView02);
		ws = wv.getSettings();

		// Zoom�� �������� �����մϴ�.
		ws.setSupportZoom(true);
		ws.setCacheMode(WebSettings.LOAD_NO_CACHE);
		//ws.setJavaScriptEnabled(false);
		//ws.setPluginsEnabled(false);
		//ws.setBlockNetworkImage(true);
		// WebView�� ����� zoom mechanism�� ���ǰ� ������ treu�� ���� �ݴϴ�.
		ws.setBuiltInZoomControls(true);   
		ws.setDefaultZoom(ZoomDensity.FAR);
		ws.setUseWideViewPort(true);
		wv.setBackgroundColor(Color.BLACK);
		wv.setHorizontalScrollBarEnabled(false);
		wv.setWebViewClient(new InfoWebViewClient()); // �߿�
		
		wv.loadUrl(value);
	}
	
	class InfoWebViewClient extends WebViewClient {
		/**
		 * url �ּҿ� �ش��ϴ� ���������� �ε�
		 */
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);

			// �ȵ���̵� ��ü WebView�� �ƴ� ���� ���� WebView ���� ����Ѵٰ� ���
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
					Toast.makeText(Tab6Sub_5.this, "Please wait for few second...", 1);
					e.getStackTrace();
				}
			}
			
			AndroidUserGuideMain.mToast(Tab6Sub_5.this);
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


