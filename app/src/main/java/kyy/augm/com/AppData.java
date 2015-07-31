package kyy.augm.com;

public class AppData {
	private String[] title = {
			"Advence task killer",  // 1
			"Daum 지도",             // 2
			"아스트로 파일 관리자",  // 3
			"Wheres My Droid",      // 4
			"Brightness Level",     // 5
			"Quick System Info",    // 6
			"My Market",    // 7
			"Music Junk",    // 8
			"핸디 알람 메모",    // 9
			"Droid-X", // 10
			"수스번역기",
			"알쏭달쏭 초성퀴즈",
			"모기안녕",
			"오늘뭐먹냐?",
			"나는야 암기왕",
			"Cigaroid"
			};
	private String[] contents = {
			"리소스 관리는 나에게 맡겨라",               // 1
			"우리집도 찍혔다",                          // 2
			"파일관리는 아스트로 파일 매니저에 맡기세요", // 3
			"분실에 대한 부담을 덜어 보자",               // 4
			"홈 화면에서 간편하게 밝기 조절하기",         // 5
			"편리하고 강력한 리소스 관리",               // 6
			"쉬운 게임 어플리케이션 검색과 다운로드",     // 7
			"MP3파일 한번에 검색과 다운로드",            // 8
			"홈화면에 생긴 콜크 메모 알림판",             // 9
			"유해 어플리케이션 차단하기",                // 10
			"여러국가의 언어번역을 도와줍니다 ",
			"심심할때 재밌게 푸세요",
			"바이바이 모기야 물러가라",
			"오늘 점심 내가 책임진다",
			"암기왕에 도전하세요",
			"올해는 꼭 담배를 끊읍시다"
			};
	private int icons[] = {
			R.drawable.icon01,
			R.drawable.icon02,
			R.drawable.icon03,
			R.drawable.icon04,
			R.drawable.icon05,
			R.drawable.icon06,
			R.drawable.icon07,
			R.drawable.icon08,
			R.drawable.icon09,
			R.drawable.icon10,
			R.drawable.icon11,
			R.drawable.icon12,
			R.drawable.icon13,
			R.drawable.icon14,
			R.drawable.icon15,
			R.drawable.icon16
	};
	private String[] appName = {
			"com.rechild.advancedtaskkiller",  // 1
			"net.daum.android.map",             // 2
			"com.metago.astro",  // 3
			"com.alienmanfc6.wheresmyandroid",      // 4
			"com.curvefish.widgets.brightnesslevel",     // 5
			"org.uguess.android.sysinfo.pro",    // 6
			"com.teragadgets.android.market",    // 7
			"com.ringtone_music.songs_free_download",    // 8
			"com.nttdocomo.android.handyalarmmemo",    // 9
			"com.safe4kid.safe4kidclient",     // 10
			"soo.trans.tour",
			"initial.quiz.game",
			"gms.mos.test",
			"tim.project.whateat",
			"heo.proj2",
			"pro.aa.test"
			};
	
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	public String[] getContents() {
		return contents;
	}
	public void setContents(String[] contents) {
		this.contents = contents;
	}
	public int[] getIcons() {
		return icons;
	}
	public void setIcons(int[] icons) {
		this.icons = icons;
	}
	public String[] getAppName() {
		return appName;
	}
	public void setAppName(String[] appName) {
		this.appName = appName;
	}
}
