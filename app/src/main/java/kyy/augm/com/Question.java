package kyy.augm.com;

public class Question {
	private String item[];       // �����׸�
	private int user_answer;     // ����ڴ��
	private int answer;          // ������ ��
	private String title;        // ��������

	boolean AnswerChk(){ // ������ üũ
		if(user_answer == answer){
			return true;
		}
		return false;
	}

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public int getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(int userAnswer) {
		user_answer = userAnswer;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
