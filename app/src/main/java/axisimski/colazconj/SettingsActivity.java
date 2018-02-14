package axisimski.colazconj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {


    Switch showSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        showSteps=(Switch)findViewById(R.id.showSteps);


        //Save Settings in Shared Preferences
        //----------------------------------------------------------------------------------------------
        SharedPreferences SharedPref=getSharedPreferences("userInput", Context.MODE_PRIVATE);

        Boolean SHS=SharedPref.getBoolean("showSteps", false);
        showSteps.setChecked(SHS);

        //----------------------------------------------------------------------------------------------

        //=======================================================================================================
        showSteps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences SharedPref=getSharedPreferences("userInput", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=SharedPref.edit();

                NoSteps ns=new NoSteps();
                withSteps ws =new withSteps();

                if(showSteps.isChecked()){
                    ws.execute();
                    MainActivity.showSteps.setChecked(true);
                    editor.putBoolean("showSteps", true);
                }

                else{
                    MainActivity.showSteps.setChecked(false);
                    editor.putBoolean("showSteps", false);
                    ns.execute();
                }
                editor.apply();
            }
        });
        //=======================================================================================================

        Button Button = (Button) findViewById(R.id.SourceButton);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/axisimski/Collatz-Conjucture-Calculator"));
                startActivity(intent);
            }
        });
    }

}
