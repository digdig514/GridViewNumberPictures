package com.example.digdig.creategriedviewexemple.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by digdig on 17-05-18.
 */

public class FileNumberManagement {
    public static ArrayList<Numbers> readFile(Context context, String fileName)
    {

        ArrayList<Numbers> listOfNumbers = new ArrayList<Numbers>();

        AssetManager assetManager = context.getResources().getAssets();

        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));

            BufferedReader br = new BufferedReader(isr);
            String oneLine;
            while ((oneLine=br.readLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(oneLine,",");

                while (st.hasMoreTokens())
                {
                    String data = st.nextToken();
                    int color;
                    if (Integer.valueOf(data)%2==0)
                    {
                        color = Color.RED;
                    }
                    else
                    {
                        color = Color.GREEN;
                    }
                    Numbers nbObj = new Numbers(data,color);
                    listOfNumbers.add(nbObj);
                }

            }

            br.close();
            isr.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
return  listOfNumbers;

    }
}
