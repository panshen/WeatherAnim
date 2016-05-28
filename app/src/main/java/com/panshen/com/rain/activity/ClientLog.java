package com.panshen.com.rain.activity;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class ClientLog {
    public static void downloadimg() {
        File pathFile = Environment.getExternalStorageDirectory().getAbsoluteFile();

        try {
            URL url = new URL("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png");
            try {
                InputStream inputStream = ((HttpURLConnection) url.openConnection()).getInputStream();
                byte[] arrayOfByte = new byte[1024];
                new File(pathFile.getAbsolutePath() + "/cunchu").mkdir();
                FileOutputStream outputStream = new FileOutputStream(new File(pathFile.getAbsolutePath() + "/cunchu/" + UUID.randomUUID().toString()+"2" + ".png"));
                while (true) {
                    int i = inputStream.read(arrayOfByte);
                    if (i == -1)
                        break;
                    outputStream.write(arrayOfByte, 0, i);
                }
            } catch (IOException paramString1) {
                paramString1.printStackTrace();
            }
        } catch (IOException para) {
            para.printStackTrace();
        }
    }
    public static void ClientLogs() {
        File pathFile = Environment.getExternalStorageDirectory()
                .getAbsoluteFile();
        try {
            FileOutputStream foutputStream = new FileOutputStream(new File(
                    pathFile + "/log.txt"));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    foutputStream);
            try {
                outputStreamWriter.write("write TEST");
                outputStreamWriter.close();
                foutputStream.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}