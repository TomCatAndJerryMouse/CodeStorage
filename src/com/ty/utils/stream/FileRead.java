package com.ty.utils.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ÎÄ¼þ¶ÁÈ¡
 * 
 * @author Administrator
 */
public class FileRead
{
    public static void main(String[] args)
    {
        try
        {
            InputStream in = new FileInputStream("C:\\Users\\Administrator\\workspace\\Practice\\src\\com\\ty\\utils\\stream\\test.txt");
            byte[] b = new byte[1024];
            int readByte;
            StringBuilder stringBuilder = new StringBuilder();
            while ((readByte = in.read(b)) > 0)
            {
                stringBuilder.append(new String(b, 0, readByte));
            }
            System.out.println(stringBuilder.toString());

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
