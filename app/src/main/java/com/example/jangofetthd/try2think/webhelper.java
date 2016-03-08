package com.example.jangofetthd.try2think;

import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by JangoFettHD on 08.03.2016.
 */
public class webhelper {
    public interface UnzipFile_Progress
    {
        void Progress(int percent, String FileName);
    }

    // unzip(new File("/sdcard/pictures.zip"), new File("/sdcard"));
    public static void UnzipFile(File zipFile, File targetDirectory/*, UnzipFile_Progress progress*/) throws IOException,
            FileNotFoundException
    {
        long total_len = zipFile.length();
        long total_installed_len = 0;

        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        try
        {
            ZipEntry ze;
            int count;
            byte[] buffer = new byte[8192];
            while ((ze = zis.getNextEntry()) != null)
            {
                /*if (progress != null)
                {
                    total_installed_len += ze.getCompressedSize();
                    String file_name = ze.getName();
                    int percent = (int)(total_installed_len * 100 / total_len);
                    progress.Progress(percent, file_name);
                }*/

                File file = new File(targetDirectory, ze.getName());
                File dir = ze.isDirectory() ? file : file.getParentFile();
                if (!dir.isDirectory() && !dir.mkdirs())
                    throw new FileNotFoundException("Failed to ensure directory: " + dir.getAbsolutePath());
                if (ze.isDirectory())
                    continue;
                FileOutputStream fout = new FileOutputStream(file);
                try
                {
                    while ((count = zis.read(buffer)) != -1)
                        fout.write(buffer, 0, count);
                } finally
                {
                    fout.close();
                }

                // if time should be restored as well
                long time = ze.getTime();
                if (time > 0)
                    file.setLastModified(time);
            }
        } finally
        {
            zis.close();
        }
    }

    public static void download(final int section){

        File folder = new File(Environment.getExternalStorageDirectory()+"/try2think"); //section"+section);
        if (!folder.exists()) {folder.mkdirs();
            if(!folder.mkdirs()) {
                Log.i("Problem", "Problem creating folder");
            }
        }
        File folder1 = new File(Environment.getExternalStorageDirectory()+"/try2think", "section"+section);
        if (!folder1.exists()) {
            if(!folder1.mkdirs()) {folder1.mkdirs();
                Log.i("Problem", "Problem creating folder");
            }
        }
        String downloadURL = "http://jangofetthd.me/rebus/section" + section+".zip";
        final String directory = Environment.getExternalStorageDirectory()+"/try2think/section"+section+"/section"+section+".zip";
        Ion.with(Sections.context).load(downloadURL).write(new File(directory))
                .setCallback(new FutureCallback<File>() {
                    @Override
                    public void onCompleted(Exception e, File file) {
                        try {
                            UnzipFile(new File(directory), new File(Environment.getExternalStorageDirectory()+"/try2think/section"+section));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    }
    public static Drawable getImage(int section, int lvl){
        String path = Environment.getExternalStorageDirectory()+"/try2think/section"+section+"/section"+section+"_"+lvl+".PNG";
        Drawable result = Drawable.createFromPath(path);
        return result;
    }
    public static boolean checkSectionFiles(int section) {
        for (int i=0; i<16; i++) {
            if (!new File(Environment.getExternalStorageDirectory()+"/try2think/section"+section+"/section"+section+"_"+i+".PNG").exists()){
                return false;
            }
        }
        return true;
    }
}
