package kyy.augm.com;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

//==============================================
// SubMain Class
// ���� : ���� ��ưȭ��
//==============================================
public class SubMain extends Activity implements View.OnClickListener{
	ImageButton b1, b2, b3, b4, b5, b6;
	Intent i;
	//==============================================
	// Button Event
	// ���� 
	// Button01 : �ʱ�ȭ�� �̵�
	// Button02 : �߱�ȭ�� �̵�
	// Button03 : ���ȭ�� �̵�
	// Button04 : ��õ����ȭ�� �̵�
	// Button05 : ��õ��ȭ�� �̵�
	// Button06 : ȯ�漳��ȭ�� �̵�
	//==============================================
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.Button01: m_btn1(); break;
			case R.id.Button02: m_btn2(); break;
			case R.id.Button03: m_btn3(); break;
			case R.id.Button04: m_btn4(); break;
			case R.id.Button05: m_btn5(); break;
			case R.id.Button06: m_btn6(); break;
		}
	}
		@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		new DialogCommon(this).DiaEnd();
	}

	private void m_btn1(){
		i = new Intent(this, SubTabHost.class); // �ʱ� 
		i.putExtra("SubMain", "1");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	private void m_btn2(){
		i = new Intent(this, SubTabHost.class); // �߱� 
		i.putExtra("SubMain", "2");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	private void m_btn3(){
		i = new Intent(this, SubTabHost.class); // ��� 
		i.putExtra("SubMain", "3");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	private void m_btn4(){
		i = new Intent(this, SubTabHost.class); // ��õ���� 
		i.putExtra("SubMain", "4");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	private void m_btn5(){
		i = new Intent(this, SubTabHost.class); // ��õ �� 
		i.putExtra("SubMain", "5");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	private void m_btn6(){
		i = new Intent(this, SubTabHost.class); // ȯ�漳�� 
		i.putExtra("SubMain", "6");
		startActivity(i);
		overridePendingTransition(R.anim.fade, R.anim.hold);
		finish();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submain);
		
		b1 = (ImageButton)findViewById(R.id.Button01);
		b2 = (ImageButton)findViewById(R.id.Button02);
		b3 = (ImageButton)findViewById(R.id.Button03);
		b4 = (ImageButton)findViewById(R.id.Button04);
		b5 = (ImageButton)findViewById(R.id.Button05);
		b6 = (ImageButton)findViewById(R.id.Button06);
		
		
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}

}