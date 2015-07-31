package kyy.augm.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tab6Group extends NavigationGroupActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          // TODO Auto-generated method stub
          super.onCreate(savedInstanceState);
          Intent intent = new Intent(this,Tab6.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
          View view = getLocalActivityManager().startActivity("CounselMainActivity",intent)
             .getDecorView();   
         replaceView(view);   
    }

    @Override
    public void onBackPressed() { // Back Key에 대한 처리 요청
          super.onBackPressed();
    }
}