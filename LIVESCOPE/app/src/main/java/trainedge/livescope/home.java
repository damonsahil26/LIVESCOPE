package trainedge.livescope;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class home extends Activity {
    private final int VIDEO_REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void captureVideo(View view)
    {
Intent camera_intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file=getFilePath();
        Uri video_uri=Uri.fromFile(video_file);
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,video_uri);
        camera_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(camera_intent,VIDEO_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==VIDEO_REQUEST_CODE){
            if(resultCode==RESULT_OK)
            {
                Toast.makeText(getApplicationContext(),"Video Successfully Recorded",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Video Captured Failed...",Toast.LENGTH_LONG).show();
            }
        }
    }

    public File getFilePath()
    {
File folder= new File("sdcard/LIVESCOPE");
        if(!folder.exists())
        {
           folder.mkdir();
        }
        File video_file=new File(folder,"sample_video.mp4");
        return video_file;
    }
}