package test.com.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        Button btnVariantOne = (Button) findViewById(R.id.btn_variant_one);
        Button btnVariantTwo = (Button) findViewById(R.id.btn_variant_two);

        if (btnVariantOne != null) {
            btnVariantOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    runVariantOneActivity();
                }
            });
        }

        if (btnVariantTwo != null) {
            btnVariantTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    runVariantTwoActivity();
                }
            });
        }
    }

    private void runVariantOneActivity() {
        Intent intent = new Intent(this, VariantOneActivity.class);
        startActivity(intent);
    }

    private void runVariantTwoActivity() {
        Intent intent = new Intent(this, VariantTwoActivity.class);
        startActivity(intent);
    }
}
