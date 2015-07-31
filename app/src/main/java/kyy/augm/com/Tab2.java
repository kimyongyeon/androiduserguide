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
//���� : �߱� ȭ��
//==============================================
public class Tab2 extends Activity {

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

		if (index.equals("2")) {

			InternetChk ic = new InternetChk(this);
			if (ic.isOnline() != false || ic.isOnlineToWifi() != false
					|| ic.isOnlineToMobile() != false) {
				wv = (WebView) findViewById(R.id.WebView01);
				ws = wv.getSettings();

				// Zoom�� �������� �����մϴ�.
				ws.setSupportZoom(true);
				// WebView�� ����� zoom mechanism�� ���ǰ� ������ treu�� ���� �ݴϴ�.
				ws.setBuiltInZoomControls(true);
				ws.setDefaultZoom(ZoomDensity.FAR);
				ws.setUseWideViewPort(true);
				wv.setBackgroundColor(Color.BLACK);
				wv.setHorizontalScrollBarEnabled(false);
				wv.setWebViewClient(new InfoWebViewClient()); // �߿�
				String data = "file:///android_asset/Tab2.htm";
				wv.loadUrl(data);
			} else {
				Toast.makeText(this, "���ͳ� ������ Ȯ���ϼ���.", 0).show();

				try {
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setComponent(new ComponentName(
							"com.android.settings",
							"com.android.settings.Settings"));
					startActivity(intent);
				} catch (Exception e) {
					Toast.makeText(this, "�������� ȯ�漳�� ����� Ȯ���� �� �����ϴ�.", 0).show();
				}
			}
		}

	}

	Intent intent;

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		intent = new Intent(this, SubMain.class); // �ʱ�
		startActivity(intent);
		finish();
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
				if (AndroidUserGuideMain.TabFlag == true) {
					AndroidUserGuideMain.TabFlag = false;
					AndroidUserGuideMain.mToast(Tab2.this);
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
