package kyy.augm.com;

public class AppData {
	private String[] title = {
			"Advence task killer",  // 1
			"Daum ����",             // 2
			"�ƽ�Ʈ�� ���� ������",  // 3
			"Wheres My Droid",      // 4
			"Brightness Level",     // 5
			"Quick System Info",    // 6
			"My Market",    // 7
			"Music Junk",    // 8
			"�ڵ� �˶� �޸�",    // 9
			"Droid-X", // 10
			"����������",
			"�˽��޽� �ʼ�����",
			"���ȳ�",
			"���ù��Գ�?",
			"���¾� �ϱ��",
			"Cigaroid"
			};
	private String[] contents = {
			"���ҽ� ������ ������ �ðܶ�",               // 1
			"�츮���� ������",                          // 2
			"���ϰ����� �ƽ�Ʈ�� ���� �Ŵ����� �ñ⼼��", // 3
			"�нǿ� ���� �δ��� ���� ����",               // 4
			"Ȩ ȭ�鿡�� �����ϰ� ��� �����ϱ�",         // 5
			"���ϰ� ������ ���ҽ� ����",               // 6
			"���� ���� ���ø����̼� �˻��� �ٿ�ε�",     // 7
			"MP3���� �ѹ��� �˻��� �ٿ�ε�",            // 8
			"Ȩȭ�鿡 ���� ��ũ �޸� �˸���",             // 9
			"���� ���ø����̼� �����ϱ�",                // 10
			"���������� �������� �����ݴϴ� ",
			"�ɽ��Ҷ� ��հ� Ǫ����",
			"���̹��� ���� ��������",
			"���� ���� ���� å������",
			"�ϱ�տ� �����ϼ���",
			"���ش� �� ��踦 �����ô�"
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
