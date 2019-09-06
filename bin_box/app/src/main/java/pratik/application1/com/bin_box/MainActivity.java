package pratik.application1.com.bin_box;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        final
        Thread mythread=new Thread()
        {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(1500);



                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean previouslyStarted = prefs.getBoolean("Alreadystarted", false);
                    if(!previouslyStarted) {
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putBoolean("Alreadystarted", Boolean.TRUE);
                        edit.commit();

                        //transfer to slide
                        Intent i=new Intent(MainActivity.this,Login.class);
                        startActivity(i);


                    }
                    else{
                        startActivity(new Intent(MainActivity.this,Login.class));
                    }


                    finish();


                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

    }


}


