package com.sembozdemir.crashlyticsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonCrash);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    methodThatThrowsFakeException();
                } catch (RuntimeException e) {
                    Crashlytics.logException(e);
                }
            }
        });
    }

    private void methodThatThrowsFakeException() throws RuntimeException {
        throw new RuntimeException("Fake Crash!!");
    }

}
