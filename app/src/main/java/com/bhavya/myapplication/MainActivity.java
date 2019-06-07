package com.bhavya.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

   String Electiondate="12/5/2019";
//    EditText epicNo=findViewById(R.id.epicNo);
//    EditText mobileNo=findViewById(R.id.mobileNo);
//    EditText pickup=findViewById(R.id.pickup);
//    EditText drop=findViewById(R.id.drop);
//    EditText otp=findViewById(R.id.otp);
    EditText epic;
    EditText epicno;
    EditText mobile;
    EditText pick;
    EditText drop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkDay();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void open_cc(View view)
    {
        ParliamentConstituency parliamentConstituency=new ParliamentConstituency();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,parliamentConstituency).addToBackStack("tag").commit();
    }
    public void goButton(View v)
    {
        epic=(EditText) findViewById(R.id.epicnum);
        String epic1=epic.getText().toString();
        //Log.i("bham","before");
        if(epic1.length()==0){
            //Log.i("bham","after");
            Toast.makeText(this,"Enter EPIC no.!!",Toast.LENGTH_SHORT).show();
        }

         else {
            Log.i("bham","after if");
            ConstraintLayout view = (ConstraintLayout) findViewById(R.id.constraint);
            view.setVisibility(View.VISIBLE);
        }
    }
    public void open_ps(View view)
    {
        PollingStation pollingStation=new PollingStation();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,pollingStation).addToBackStack("tag").commit();
    }
//    public void onBackPressed(View view)
//    {
//        int c=getSupportFragmentManager().getBackStackEntryCount();
//        if(c==0)
//        {
//            super.onBackPressed();
//
//        }
//        else
//        {
//            getSupportFragmentManager().popBackStack();
//
//        }
//    }
    public void openWebsite(View view)
    {
        //Opening the eci training website
        String uri = "http://ecisveep.nic.in/voters/how-to-vote/";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
    }
    public void open_info(View view)
    {

        Information info=new Information();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,info).addToBackStack("tag").commit();
    }
    public void open_kyc(View view)
    {

        KnowYourCandidate kyc=new KnowYourCandidate();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,kyc).addToBackStack("tag").commit();
    }
    public void open_thirdGender(View view)
    {

        ThirdGender thirdGender=new ThirdGender();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,thirdGender).addToBackStack("tag").commit();
    }
    public void showOTP(View view)
    {
        epicno=findViewById(R.id.epicNo);
        mobile = findViewById(R.id.mobileNo);
        pick=findViewById(R.id.pickup);
        drop=findViewById(R.id.drop);
        String mob=mobile.getText().toString();
        String epi=epicno.getText().toString();

        String pic=epicno.getText().toString();

        String dro=epicno.getText().toString();
        if(epi.length()==0||pic.length()==0||dro.length()==0||mob.length()!=10)
        {
            Toast.makeText(this,"Enter the necessary details correctly!",Toast.LENGTH_SHORT).show();
        }
        else if(mob.matches("[0-9]+")) {

            LinearLayout linear = (LinearLayout) findViewById(R.id.linear2);
            linear.setVisibility(View.VISIBLE);
        }

    }
    public void open_feedback(View view)
    {

        Feedback feedback=new Feedback();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,feedback).addToBackStack("tag").commit();
    }
    public void submit(View view)
    {
        EditText submit=findViewById(R.id.otp);
        String s=submit.getText().toString();
        if(s.length()!=0&&s.matches("[0-9]+"))
        {
            Toast.makeText(this,"Your phone number has been verified",Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this,"Enter a valid OTP",Toast.LENGTH_SHORT).show();
        }
    }
public void open_after()
{
    AfterFragment afterFragment = new AfterFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.container, afterFragment).commit();
}

    public void checkDay()
    {//TODO

        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        try { Log.i("bham","before");
            Date theDay = format.parse(Electiondate);
            if (new Date().after(theDay)) {
                Log.i("bham","mid");
               open_after();
            }
            Log.i("bham","after");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void openPlayStore(View view)
    {
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=pwd.eci.com.pwdapp&hl=en_IN"));
            startActivity(intent);

        }catch (Exception ex){
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=pwd.eci.com.pwdapp&hl=en_IN"));
            startActivity(intent);
        }
    }
//    public void checkAll()
//    {
//        String epic1=epic.getText().toString();
//        String mobile=mobileNo.getText().toString();
//        String pick=pickup.getText().toString();
//        String droptime=drop.getText().toString();
//        String otpno=otp.getText().toString();
//       if(epic1==" ")
//        {
//            Toast.makeText(this,"Enter epic number",Toast.LENGTH_SHORT).show();
//        }
//        if(mobile==" ")
//        {
//            Toast.makeText(this,"Enter mobile number",Toast.LENGTH_SHORT).show();
//        }
//        if(pick==" ")
//        {
//            Toast.makeText(this,"Enter pick-up time",Toast.LENGTH_SHORT).show();
//        }
//        if(droptime==" ")
//        {
//            Toast.makeText(this,"Enter drop time",Toast.LENGTH_SHORT).show();
//        }
//        if(otpno==" ")
//        {
//            Toast.makeText(this,"Enter otp number",Toast.LENGTH_SHORT).show();
//        }
//
//    }
    public void goMap(View view)
    {
        String cc="geo:28.6507,77.2334";
        Uri uri=Uri.parse(cc);
        Intent mapIntent=new Intent(Intent.ACTION_VIEW,uri);
//        if(mapIntent.resolveActivity(getPackageManager())!=null)
//        {
            startActivity(mapIntent);
        //}
    }

    public void submitFeedback(View view)
    {
        EditText sub=findViewById(R.id.edit1);
        String s=sub.getText().toString();
        if(s.length()==0)
        {
            Toast.makeText(this,"Empty submission",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Thanks for your feedback!",Toast.LENGTH_SHORT).show();
        }
    }
    public void toastLogin(View v)
    {
        EditText email=findViewById(R.id.edit1);
        EditText password=findViewById(R.id.edit2);
        String email1=email.getText().toString();
        String pass=password.getText().toString();
        if(email1.length()==0&&pass.length()==0)
        {
            Toast.makeText(this,"Enter the necessary details correctly!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show();
        }
    }
    public void login(View v)
    {
        Login login=new Login();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,login).addToBackStack("tag").commit();
    }
    public void register(View v)
    {
        Register register=new Register();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,register).addToBackStack("tag").commit();
    }
    public void toastRegister(View v)
    {
        EditText email=findViewById(R.id.reg_email);
        EditText password=findViewById(R.id.reg_pass);
        EditText name=findViewById(R.id.name);
        String email1=email.getText().toString();
        String pass=password.getText().toString();
        String names=name.getText().toString();
        if(email1.length()==0&&pass.length()==0&&names.length()==0)
        {
            Toast.makeText(this,"Enter the necessary details correctly!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Registration successful!",Toast.LENGTH_SHORT).show();
        }
    }
}
