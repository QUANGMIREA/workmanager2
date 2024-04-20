package com.example.workmanager2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo các WorkRequest
        OneTimeWorkRequest imageProcessingRequest = new OneTimeWorkRequest.Builder(ImageProcessingWorker.class)
                .build();
        OneTimeWorkRequest dataDownloadRequest = new OneTimeWorkRequest.Builder(DataDownloadWorker.class)
                .build();

        // Lên lịch chạy đồng thời hai công việc
        WorkManager.getInstance(this)
                .enqueue(imageProcessingRequest);
        WorkManager.getInstance(this)
                .enqueue(dataDownloadRequest);
    }
}