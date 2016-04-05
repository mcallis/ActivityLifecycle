/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uoc.pec2.android.activitylifecycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class ActivityA extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = ActivityA.this.getClass().getSimpleName();

    private Button mButtonActivityB;
    private Button mButtonActivityC;
    private Button mButtonFinishActivityA;
    private Button mButtonStartDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TAG, "onCreate");

        // Set views
        mButtonActivityB = (Button) findViewById(R.id.btn_start_b);
        mButtonActivityC = (Button) findViewById(R.id.btn_start_c);
        mButtonFinishActivityA = (Button) findViewById(R.id.btn_finish_a);
        mButtonStartDialog = (Button) findViewById(R.id.btn_start_dialog);

        // Set Listeners
        mButtonActivityB.setOnClickListener(this);
        mButtonActivityC.setOnClickListener(this);
        mButtonFinishActivityA.setOnClickListener(this);
        mButtonStartDialog.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void showDialog() {
        Log.d(TAG, "showDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton(R.string.dialog_ok_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Log.d(TAG, "dismiss");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                Log.d(TAG, "dismiss");
                dialog.dismiss();
            }
        });
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void startActivityB() {
        Log.d(TAG, "startActivityB");
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Log.d(TAG, "startActivityC");
        Intent intent = new Intent(ActivityA.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityA() {
        Log.d(TAG, "finishActivityA");
        ActivityA.this.finish();
    }

    @Override
    public void onClick(View v) {
        if (v == mButtonActivityB) {
            startActivityB();
        } else if (v == mButtonActivityC) {
            startActivityC();
        } else if (v == mButtonFinishActivityA) {
            finishActivityA();
        } else if (v == mButtonStartDialog) {
            showDialog();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed");
    }
}
