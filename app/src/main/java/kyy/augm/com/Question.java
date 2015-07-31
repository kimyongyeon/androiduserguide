package kyy.augm.com;

public class Question {
	private String item[];       // 문제항목
	private int user_answer;     // 사용자대답
	private int answer;          // 문제의 답
	private String title;        // 문제제목

	boolean AnswerChk(){ // 문제답 체크
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
