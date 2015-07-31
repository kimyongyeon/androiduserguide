package kyy.augm.com;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationGroupActivity extends ActivityGroup {
    ArrayList<View> history; // View���� �����ϱ� ���� List
   NavigationGroupActivity group; // Activity���� �����ϱ� ���� Group
    @Override
   protected void onCreate(Bundle savedInstanceState) {
         // TODO Auto-generated method stub
         super.onCreate(savedInstanceState);
         history = new ArrayList<View>();
         group = this;
   }
    public void changeView(View v)  { // ������ Level�� Activity�� �ٸ� Activity�� �����ϴ� ���

         history.remove(history.size()-1);
         history.add(v);
         setContentView(v);
   }
   public void replaceView(View v) {   // ���ο� Level�� Activity�� �߰��ϴ� ���
         history.add(v);   
         setContentView(v); 
   }   
   public void back() { // Back Key�� �������� ��쿡 ���� ó��
         if(history.size() > 1) {   
             history.remove(history.size()-1);   
             setContentView(history.get(history.size()-1)); 
         }
        else {   
             //finish(); // �ֻ��� Level�� ��� TabActvity�� �����ؾ� �Ѵ�.
        	Intent i = new Intent(this,SubMain.class); // �ʱ� 
    		startActivity(i);
    		finish();
         }   
   }  
   @Override  
   public void onBackPressed() { // Back Key�� ���� Event Handler  
         group.back();   
         return;
   }
}
