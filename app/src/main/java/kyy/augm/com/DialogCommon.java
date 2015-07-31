// ====================================================================================
// 다이얼로그 박스 문구 정리
/* ====================================================================================
1) DiaEnd : 종료하시겠습니까? 확인, 취소(네이티브)
2) DiaQna : 문제1. Q&A WIFI란 무엇인가? 1. 머머 2.머머 3.머머(라디오버튼식)
3) DiaCustom : 
  - 축하합니다. 당신은 ?급 유저입니다. 짝짝(손벽치는 이모티콘 추가) 확인
  - 노력하세요. 당신은 ?급 유저입니다. ㅠㅠ(눈물 이모티콘 추가) 확인
  - 힘내세요. 당신은 ?급 유저입니다. 화이팅(손두개를 들어서 화이팅하는 이모티콘 추가) 확인
4) DiaApp : 어플 화면으로  이동 하시겠습니까? 확인, 취소(네이티브)
   DiaWep : 웹 화면으로 이동 하시겠습니까? 확인, 취소(네이티브)
   DiaOption : 환경설정 화면으로 이동 하시겠습니까? 확인, 취소(네이티브)
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
//설명 : 다이얼로그 박스
//==============================================
public class DialogCommon extends AlertDialog.Builder {
	Activity context;
	ActionView_Intent ai;
	AlertDialog.Builder builder = this;
	private Question q2 = new Question(); // 섞은 문제의 객체를 뺀다.
	private Vector<Question> v = new Vector<Question>(); // 랜덤으로 뽑을 백터를 생성
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
	// 종료 메세지
	// ====================================
	public void DiaEnd(){
		setTitle("종료");
		setMessage("정말로 종료하시겠습니까?");
    	//builder.setIcon(R.drawable.giraffe);
    	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(which == -1){
					// 현재어플을 죽임.
					context.finish();
				}else{
					// 현재 어플화면으로 다시 돌아감.
				}
			}
		};
		
    	this.setPositiveButton("예", listener);
    	this.setNegativeButton("아니요", listener);
    	show();
    }
	

	// 문제 초기화
	private void questionInit(){
		Question que1 = new Question();  // 문제 객체 생성(1)
		Question que2 = new Question();  // 문제 객체 생성(2)
		Question que3 = new Question();  // 문제 객체 생성(3)
		Question que4 = new Question();  // 문제 객체 생성(4)
		Question que5 = new Question();  // 문제 객체 생성(5)
		Question que6 = new Question();  // 문제 객체 생성(6)
		Question que7 = new Question();  // 문제 객체 생성(7)
		
		// 문제1 
		que1.setTitle("wi-fi (와이파이)란 무엇인가?");
		String item1[] = {
				"와이파이는 무료이지만 아무 곳에서나 쓸 수 없다것.",
				"통신사에서 제공하는 무선통신망",
				"3세대 이동통신기술",
				"3G망"
				};
		que1.setItem(item1);
		que1.setAnswer(0);
		v.add(que1);
		
		// 문제2
		que2.setTitle("3g란 무엇인가?");
		String item2[] = {
				"무료이지만 아무 곳에서나 쓸 수 없다것.",
				"통신사에서 제공하는 무선통신망 ",
				"네스팟",
				"무선허브"};
		que2.setItem(item2);
		que2.setAnswer(1);
		v.add(que2);
		
		// 문제3
		que3.setTitle("apk파일 이란 무엇인가?");
		String item3[] = {
				"문서파일",
				"그림파일",
				"안드로이드 실행파일",
				"exe파일과 유사한 파일"};
		que3.setItem(item3);
		que3.setAnswer(2);
		v.add(que3);

		// 문제4
		que4.setTitle("어플이란 무엇인가?");
		String item4[] = {
				"응용프로그램", 
				"운영체제",
				"실행파일",
				"응용프로그램,게임,유틸등을 통틀어 부르는것."};
		que4.setItem(item4);
		que4.setAnswer(3);
		v.add(que4);
		
		// 문제5
		que5.setTitle("안드로이드 마켓에 대한 내용중 맞는것은?");
		String item5[] = {
				"구글이 운영하는 안드로이드용 어플을 파는곳",
				"한국에서 게임을 파는곳",
				"경매를 하는곳",
				"옷을 파는곳"};
		que5.setItem(item5);
		que5.setAnswer(0);
		v.add(que5);
		
		// 문제6
		que6.setTitle("위젯에 대한 설명중 가장 옳은것은?");
		String item6[] = {
				"운영체제",
				"응용프로그램",
				"응용프로그램과 운영체제와의 상호작용을 원할하게 도와주는 인터페이스",
				"날씨가 표시되는것"};
		que6.setItem(item6);
		que6.setAnswer(2);
		v.add(que6);
		
		// 문제7
		que7.setTitle("동기화에 대한 설명중 맞는것은?");
		String item7[] = {
				"안드로이드폰과 안드로이드 계정에 내용이 같아지는것",
				"게임이 합쳐지는것",
				"응용프로그램을 모아넣은것",
				"폴더 같은것"};
		que7.setItem(item7);
		que7.setAnswer(0);
		v.add(que7);
	}
	
	// 정답을 체크한다.
	private boolean question_check(Question q){
		return q.AnswerChk();
	}
	
	// ====================================
	// 문제 메세지
	// ====================================
	public void DiaQna(){
		
		questionInit();
		Collections.shuffle(v); // 문제를 섞는다.
		q2 = v.get(0); // 섞은 문제의 객체를 뺀다.
    	builder.setTitle(q2.getTitle());
    	
    	builder.setSingleChoiceItems(q2.getItem(), 0, 
    			new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						q2.setUser_answer(which);
					}
		});
    	
    	builder.setNeutralButton("확인", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				boolean flag = question_check(q2);
				if(flag == true){
					showMsg("정답입니다.", 1);
					//DiaCustom(1);
				}else{
					showMsg("안타깝네요. 다음기회에...", 1);
					snake();
					//DiaCustom(2);
				}
			}
		});
    	builder.show();
	}

	// ====================================
	// 확인 메세지 : 1:고급, 2:중급, 3:초급
	// ====================================
	public void DiaCustom(int idx){
    	//builder.setIcon(R.drawable.elephant);
		builder.setTitle("안내");
		switch (idx){
			case 1 :
		    	builder.setMessage("축하합니다. 당신은 고급 유저입니다.");
		    	builder.setNeutralButton("확인", null);
		    	builder.show();
		    	break;
			case 2 :
		    	builder.setMessage("힘내세요. 당신은  중급 유저입니다.");
		    	builder.setNeutralButton("확인", null);
		    	builder.show();
		    	break;
			case 3 :
		    	builder.setMessage("노력하세요. 당신은 초급 유저입니다.");
		    	builder.setNeutralButton("확인", null);
		    	builder.show();
		    	break;		    	
		}
	}
	// ====================================
	// 이동 메세지
	// idx  => 1:어플화면, 2:웹화면, 3:환경설정화면
	// str  => 각 화면 이름
	// ====================================
	public void DiaMove(String str, int idx, int pos){
		httpStr = str; 
		this.position = pos;
		//builder.setIcon(R.drawable.giraffe);
    	builder.setTitle("이동");
    	switch (idx){
    		case 1:
    			builder.setMessage(str + " 어플 화면으로  이동 하시겠습니까?");
    	    	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					
    					if(which == -1){
    						ai.appMove(appName[position]);
    					}else{
    						// 이동 취소
    					}
    				}
    			};
    	    	builder.setPositiveButton("예", listener);
    	    	builder.setNegativeButton("아니요", listener);
    	    	builder.show();
    	    	break;
    		case 2:
    			builder.setMessage(str + " 웹 화면으로 이동 하시겠습니까?");
    	    	DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {

    					if(which == -1){
        					ai.webMove(httpName[position]); 
    					}else{
    						// 이동 취소
    					}
    				}
    			};
    	    	builder.setPositiveButton("예", listener2);
    	    	builder.setNegativeButton("아니요", listener2);
    	    	builder.show();
    	    	break;
    		case 3:
    			builder.setMessage(str + " 환경설정 화면으로 이동 하시겠습니까?");
    	    	DialogInterface.OnClickListener listener3 = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					if(which == -1){
    						// 환경설정화면으로 이동
    						ai.opMove();
    					}else{
    						// 이동 취소
    					}
    				}
    			};
    	    	builder.setPositiveButton("예", listener3);
    	    	builder.setNegativeButton("아니요", listener3);
    	    	builder.show();
    	    	break;
    	}
    			
	}

	// 정답틀림 흔들기 애니메이션
	private void snake(){ 
		Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
		context.findViewById(R.id.ImageView04).startAnimation(shake);
	}
	
	// ====================================
	// 토스트 메세지
	// i => 0:짧은거, 1:길게
	// ====================================
	private void showMsg(String msg, int i){
    	Toast.makeText(context, msg, i).show();
    }
}
