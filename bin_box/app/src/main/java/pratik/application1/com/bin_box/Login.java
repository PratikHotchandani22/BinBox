package pratik.application1.com.bin_box;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {


    EditText PhNumber, Name;
    ImageButton BtnContinue;

    user us;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        PhNumber = (EditText)findViewById(R.id.PhNumber);
        Name = (EditText)findViewById(R.id.Name);
        BtnContinue = (ImageButton)findViewById(R.id.Conti);


        BtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString().trim();
                String PNo =  PhNumber.getText().toString().trim();
                us = new user(name,PNo);


            }
        });
    }
}
