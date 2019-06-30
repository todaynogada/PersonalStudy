package com.example.excamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mBtn01, mBtn02;
    ImageView mImg;
    private static final int REQUEST_IMAGE_CAPTURE = 672;
    private String imageFilePath;
    Uri imageUri;
    Uri photoURI, albumURI;
    File photoFile = null;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn01 = findViewById(R.id.btn01);
        mBtn02 = findViewById(R.id.btn02);
        mImg = findViewById(R.id.img);

        mBtn01.setOnClickListener(this);
        mBtn02.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(MainActivity.this,   Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MainActivity.this,   Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MainActivity.this,   Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {

            } else {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 10000);

            }
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 10000: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            FileOutputStream outputStream = null;

            switch (requestCode) {

                case 672:
                    galleryAddPic();
             /*       Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    byte a = (byte) extras.get("data");
                    FileOutputStream outputStream1 = null;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
                    String date = simpleDateFormat.format(new Date());

                    File file_img = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Boodi/");
                    String photofile =  date + ".png";
                    String file_name = file_img.getAbsolutePath() + "/" + photofile;
                    File picfile = new File (file_name);
                    outputStream = new FileOutputStream(picfile);
                    outputStream.write(a);
                    outputStream.close();



                    Log.d("datatest", String.valueOf(a));*/
                 //   Bundle bundle = data.getExtras();
                   // byte[] b = (byte[]) bundle.get("data");
                 //   Bitmap bitmap = (Bitmap)bundle.get("data");

                  //  Log.d("672", String.valueOf( b));
                  //  byte[] key = (byte[]) data.getByteArrayExtra(String.valueOf(photoFile));

                   // File storageDir = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/todaynogada/");
                  //  Log.d("672", String.valueOf(storageDir));
                   // outputStream = new FileOutputStream(storageDir);
                   // outputStream.write(b);
                    //outputStream.close();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                    try {
                        photoFile = createImageFile2();
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        Log.e("captureCamera Error", ex.toString());
                    }
                    if (photoFile != null) {
                        //photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile);
                       // takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                       // takePictureIntent.getByteArrayExtra(String.valueOf(photoFile));

                        Uri providerURI = FileProvider.getUriForFile(this, getPackageName(), photoFile);
                        imageUri = providerURI;
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, providerURI);
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }

                break;
            case R.id.btn02:
                break;

        }
    }

    public File createImageFile2() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + ".jpg";
        File imageFile = null;
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/Pictures", "gyeom");

        if (!storageDir.exists()) {
            Log.i("mCurrentPhotoPath1", storageDir.toString());
            storageDir.mkdirs();
        }

        imageFile = new File(storageDir, imageFileName);
        mCurrentPhotoPath = imageFile.getAbsolutePath();

        return imageFile;
    }

    private void galleryAddPic(){
        Log.i("galleryAddPic", "Call");
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        // 해당 경로에 있는 파일을 객체화(새로 파일을 만든다는 것으로 이해하면 안 됨)
        File f = new File(mCurrentPhotoPath);
        Log.d("사진저장경로", mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
        Toast.makeText(this, "사진이 앨범에 저장되었습니다.", Toast.LENGTH_SHORT).show();
    }


    private File createImageFile() throws IOException {
       String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
       File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //File storageDir = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/todaynogada/");

        Log.d("storageDir디렉토리:::", String.valueOf(storageDir));
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        File file = new File(storageDir + "/" + imageFileName) ;
        FileOutputStream fo = null;
        fo = new FileOutputStream(file);
        int data = 0;

        while((data = System.in.read()) != -1) {
            // 입력받은 내용을 파일 내용으로 기록한다.
           // fo.write(photoUri);
        }

        fo.flush();
        fo.close();


       // imageFilePath = image.getAbsolutePath();
      //  Log.d("image:::", String.valueOf(image));
        return image;

    }






}
