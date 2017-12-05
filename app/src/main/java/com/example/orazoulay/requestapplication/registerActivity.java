package com.example.orazoulay.requestapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class registerActivity extends AppCompatActivity {

    ImageButton regPicButton;
    Button saveButton;
    private static final int RESULT =1;
    EditText firstNameET;
    EditText lastNameET;
    EditText cityET;
    EditText streetET;
    EditText emailET;
    EditText phoneNumberET;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT  && resultCode==RESULT_OK && data!=null){
            Uri selectedImage= data.getData();
            regPicButton.setImageURI(selectedImage);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        saveButton=findViewById(R.id.save_B);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNameET=findViewById(R.id.regFirstName_ET);
                lastNameET=findViewById(R.id.regLastName_ET);
                cityET=findViewById(R.id.regCity_ET);
                streetET=findViewById(R.id.regStreet_ET);
                emailET=findViewById(R.id.regEmail_ET);
                phoneNumberET=findViewById(R.id.regPhoneNum_ET);

                Intent intent= new Intent(registerActivity.this,MapsActivity.class);
                intent.putExtra("firstname",firstNameET.getText().toString());
                intent.putExtra("lastname",lastNameET.getText().toString());
                intent.putExtra("city",cityET.getText().toString());
                intent.putExtra("street",streetET.getText().toString());
                intent.putExtra("email",emailET.getText().toString());
                intent.putExtra("phonenumber",phoneNumberET.getText().toString());

                //startActivity(intent1);
                startActivity(intent);

            }
        });
        regPicButton=findViewById(R.id.regPic_IB);
        regPicButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT);


            }


         });

    }

}
