package com.example.bohra.savvysavingappworking;

import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class IO {

    public int pinDecrypt = 0;


    public String readPinFile(String filename)
    {
        File file = new File(Environment.getExternalStorageDirectory(),filename);
        StringBuilder text = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line=br.readLine();

                text.append(line);

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public String readFile(String filename)
    {
        File file = new File(Environment.getExternalStorageDirectory(),filename);
        StringBuilder text = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line="";
            while((line = br.readLine())!=null){
                text.append(line);
                text.append("\n");
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    //Matt, saving encrypted code to the text file to be later read & decrypted.
    public void writeFile(String filename, String content)
    {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),filename);

        int max = 100;
        int min =2;
        try{
            FileOutputStream fos = new FileOutputStream(file);

            int contentTemp = 0;

            contentTemp = Integer.parseInt(content);

            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

            contentTemp = contentTemp*randomNum;
            pinDecrypt = contentTemp;

            String contentS;

            contentS = Integer.toString(contentTemp);

            fos.write(contentS.getBytes());
            fos.close();
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void updateFile(String filename,String content)
    {
        String str = readFile(filename);
        writeFile(filename,str+content);
    }
}
