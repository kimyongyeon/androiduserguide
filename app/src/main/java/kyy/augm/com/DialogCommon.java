// ====================================================================================
// ���̾�α� �ڽ� ���� ����
/* ====================================================================================
1) DiaEnd : �����Ͻðڽ��ϱ�? Ȯ��, ���(����Ƽ��)
2) DiaQna : ����1. Q&A WIFI�� �����ΰ�? 1. �Ӹ� 2.�Ӹ� 3.�Ӹ�(������ư��)
3) DiaCustom : 
  - �����մϴ�. ����� ?�� �����Դϴ�. ¦¦(�պ�ġ�� �̸�Ƽ�� �߰�) Ȯ��
  - ����ϼ���. ����� ?�� �����Դϴ�. �Ф�(���� �̸�Ƽ�� �߰�) Ȯ��
  - ��������. ����� ?�� �����Դϴ�. ȭ����(�յΰ��� �� ȭ�����ϴ� �̸�Ƽ�� �߰�) Ȯ��
4) DiaApp : ���� ȭ������  �̵� �Ͻðڽ��ϱ�? Ȯ��, ���(����Ƽ��)
   DiaWep : �� ȭ������ �̵� �Ͻðڽ��ϱ�? Ȯ��, ���(����Ƽ��)
   DiaOption : ȯ�漳�� ȭ������ �̵� �Ͻðڽ��ϱ�? Ȯ��, ���(����Ƽ��)
==================================================================================== */
package kyy.augm.com;

import java.util.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;


//==============================================
//DialogCommon Class
//���� : ���̾�α� �ڽ�
//==============================================
public class DialogCommon extends AlertDialog.Builder {
	Activity context;
	ActionView_Intent ai;
	AlertDialog.Builder builder = this;
	private Question q2 = new Question(); // ���� ������ ��ü�� ����.
	private Vector<Question> v = new Vector<Question>(); // �������� ���� ���͸� ����
	String httpStr="";
	AppData ac = new AppData();
	
	String httpName[] = {
			"http://download.pandaapp.com/?net=www&app=soft&controller=android",
			"http://www.kandroid.org/board/kandroid_home.php",
			"http://matpclub.com/s/p11",
			"http://pspmaster.tistory.com/55",
			"http://blog.naver.com/devilhaeyong/10100754484",
			"http://cafe.naver.com/androidpeople",
			"http://cafe.naver.com/flueworld",
			"http://cafe.daum.net/IFP180T",
	};
	String[] appName = ac.getAppName();
	
	private int position;
	
	public DialogCommon(Context context) {
		super(context);
		this.context = (Activity)context;
		ai = new ActionView_Intent(context);
	}
	// ====================================
	// ���� �޼���
	// ====================================
	public void DiaEnd(){
		setTitle("����");
		setMessage("������ �����Ͻðڽ��ϱ�?");
    	//builder.setIcon(R.drawable.giraffe);
    	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(which == -1){
					// ��������� ����.
					context.finish();
				}else{
					// ���� ����ȭ������ �ٽ� ���ư�.
				}
			}
		};
		
    	this.setPositiveButton("��", listener);
    	this.setNegativeButton("�ƴϿ�", listener);
    	show();
    }
	

	// ���� �ʱ�ȭ
	private void questionInit(){
		Question que1 = new Question();  // ���� ��ü ����(1)
		Question que2 = new Question();  // ���� ��ü ����(2)
		Question que3 = new Question();  // ���� ��ü ����(3)
		Question que4 = new Question();  // ���� ��ü ����(4)
		Question que5 = new Question();  // ���� ��ü ����(5)
		Question que6 = new Question();  // ���� ��ü ����(6)
		Question que7 = new Question();  // ���� ��ü ����(7)
		
		// ����1 
		que1.setTitle("wi-fi (��������)�� �����ΰ�?");
		String item1[] = {
				"�������̴� ���������� �ƹ� �������� �� �� ���ٰ�.",
				"��Ż翡�� �����ϴ� ������Ÿ�",
				"3���� �̵���ű��",
				"3G��"
				};
		que1.setItem(item1);
		que1.setAnswer(0);
		v.add(que1);
		
		// ����2
		que2.setTitle("3g�� �����ΰ�?");
		String item2[] = {
				"���������� �ƹ� �������� �� �� ���ٰ�.",
				"��Ż翡�� �����ϴ� ������Ÿ� ",
				"�׽���",
				"�������"};
		que2.setItem(item2);
		que2.setAnswer(1);
		v.add(que2);
		
		// ����3
		que3.setTitle("apk���� �̶� �����ΰ�?");
		String item3[] = {
				"��������",
				"�׸�����",
				"�ȵ���̵� ��������",
				"exe���ϰ� ������ ����"};
		que3.setItem(item3);
		que3.setAnswer(2);
		v.add(que3);

		// ����4
		que4.setTitle("�����̶� �����ΰ�?");
		String item4[] = {
				"�������α׷�", 
				"�ü��",
				"��������",
				"�������α׷�,����,��ƿ���� ��Ʋ�� �θ��°�."};
		que4.setItem(item4);
		que4.setAnswer(3);
		v.add(que4);
		
		// ����5
		que5.setTitle("�ȵ���̵� ���Ͽ� ���� ������ �´°���?");
		String item5[] = {
				"������ ��ϴ� �ȵ���̵�� ������ �Ĵ°�",
				"�ѱ����� ������ �Ĵ°�",
				"��Ÿ� �ϴ°�",
				"���� �Ĵ°�"};
		que5.setItem(item5);
		que5.setAnswer(0);
		v.add(que5);
		
		// ����6
		que6.setTitle("������ ���� ������ ���� ��������?");
		String item6[] = {
				"�ü��",
				"�������α׷�",
				"�������α׷��� �ü������ ��ȣ�ۿ��� �����ϰ� �����ִ� �������̽�",
				"������ ǥ�õǴ°�"};
		que6.setItem(item6);
		que6.setAnswer(2);
		v.add(que6);
		
		// ����7
		que7.setTitle("����ȭ�� ���� ������ �´°���?");
		String item7[] = {
				"�ȵ���̵����� �ȵ���̵� ������ ������ �������°�",
				"������ �������°�",
				"�������α׷��� ��Ƴ�����",
				"���� ������"};
		que7.setItem(item7);
		que7.setAnswer(0);
		v.add(que7);
	}
	
	// ������ üũ�Ѵ�.
	private boolean question_check(Question q){
		return q.AnswerChk();
	}
	
	// ====================================
	// ���� �޼���
	// ====================================
	public void DiaQna(){
		
		questionInit();
		Collections.shuffle(v); // ������ ���´�.
		q2 = v.get(0); // ���� ������ ��ü�� ����.
    	builder.setTitle(q2.getTitle());
    	
    	builder.setSingleChoiceItems(q2.getItem(), 0, 
    			new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						q2.setUser_answer(which);
					}
		});
    	
    	builder.setNeutralButton("Ȯ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				boolean flag = question_check(q2);
				if(flag == true){
					showMsg("�����Դϴ�.", 1);
					//DiaCustom(1);
				}else{
					showMsg("��Ÿ���׿�. ������ȸ��...", 1);
					snake();
					//DiaCustom(2);
				}
			}
		});
    	builder.show();
	}

	// ====================================
	// Ȯ�� �޼��� : 1:���, 2:�߱�, 3:�ʱ�
	// ====================================
	public void DiaCustom(int idx){
    	//builder.setIcon(R.drawable.elephant);
		builder.setTitle("�ȳ�");
		switch (idx){
			case 1 :
		    	builder.setMessage("�����մϴ�. ����� ��� �����Դϴ�.");
		    	builder.setNeutralButton("Ȯ��", null);
		    	builder.show();
		    	break;
			case 2 :
		    	builder.setMessage("��������. �����  �߱� �����Դϴ�.");
		    	builder.setNeutralButton("Ȯ��", null);
		    	builder.show();
		    	break;
			case 3 :
		    	builder.setMessage("����ϼ���. ����� �ʱ� �����Դϴ�.");
		    	builder.setNeutralButton("Ȯ��", null);
		    	builder.show();
		    	break;		    	
		}
	}
	// ====================================
	// �̵� �޼���
	// idx  => 1:����ȭ��, 2:��ȭ��, 3:ȯ�漳��ȭ��
	// str  => �� ȭ�� �̸�
	// ====================================
	public void DiaMove(String str, int idx, int pos){
		httpStr = str; 
		this.position = pos;
		//builder.setIcon(R.drawable.giraffe);
    	builder.setTitle("�̵�");
    	switch (idx){
    		case 1:
    			builder.setMessage(str + " ���� ȭ������  �̵� �Ͻðڽ��ϱ�?");
    	    	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					
    					if(which == -1){
    						ai.appMove(appName[position]);
    					}else{
    						// �̵� ���
    					}
    				}
    			};
    	    	builder.setPositiveButton("��", listener);
    	    	builder.setNegativeButton("�ƴϿ�", listener);
    	    	builder.show();
    	    	break;
    		case 2:
    			builder.setMessage(str + " �� ȭ������ �̵� �Ͻðڽ��ϱ�?");
    	    	DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {

    					if(which == -1){
        					ai.webMove(httpName[position]); 
    					}else{
    						// �̵� ���
    					}
    				}
    			};
    	    	builder.setPositiveButton("��", listener2);
    	    	builder.setNegativeButton("�ƴϿ�", listener2);
    	    	builder.show();
    	    	break;
    		case 3:
    			builder.setMessage(str + " ȯ�漳�� ȭ������ �̵� �Ͻðڽ��ϱ�?");
    	    	DialogInterface.OnClickListener listener3 = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					if(which == -1){
    						// ȯ�漳��ȭ������ �̵�
    						ai.opMove();
    					}else{
    						// �̵� ���
    					}
    				}
    			};
    	    	builder.setPositiveButton("��", listener3);
    	    	builder.setNegativeButton("�ƴϿ�", listener3);
    	    	builder.show();
    	    	break;
    	}
    			
	}

	// ����Ʋ�� ���� �ִϸ��̼�
	private void snake(){ 
		Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
		context.findViewById(R.id.ImageView04).startAnimation(shake);
	}
	
	// ====================================
	// �佺Ʈ �޼���
	// i => 0:ª����, 1:���
	// ====================================
	private void showMsg(String msg, int i){
    	Toast.makeText(context, msg, i).show();
    }
}
