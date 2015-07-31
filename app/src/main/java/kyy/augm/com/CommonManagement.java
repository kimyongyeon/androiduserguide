package kyy.augm.com;

import android.app.Activity;

public class CommonManagement {
	Activity a;
	
	CommonManagement(Activity a){
		this.a = a;
	}

	public void clearApplicationCache(java.io.File dir){
        if(dir==null)
            dir = a.getCacheDir();
        else;
        if(dir==null)
            return;
        else;
        java.io.File[] children = dir.listFiles();
        try{
            for(int i=0;i<children.length;i++)
                if(children[i].isDirectory())
                    clearApplicationCache(children[i]);
                else children[i].delete();
        }
        catch(Exception e){}
    }
}
