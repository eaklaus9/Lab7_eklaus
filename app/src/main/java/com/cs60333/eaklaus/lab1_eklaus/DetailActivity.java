package com.cs60333.eaklaus.lab1_eklaus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by eakla on 2/16/2017.
 */

public class DetailActivity extends AppCompatActivity {
    public static int CAMERA_REQUEST = 1888;

    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "BestMoments" + timestamp + ".jpg";
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri imageUri = Uri.parse(pictureDirectoryPath);
                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    ImageView imgView = (ImageView) findViewById(R.id.photo_taken);
                    imgView.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        Button camera = (Button) findViewById(R.id.button_camera);
        camera.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File PictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureName = getPictureName();
                File imageFile = new File(PictureDirectory, pictureName);
                Uri pictureUri = Uri.fromFile(imageFile);
                //Ask about this line
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);}

        });


        // Unbundle the team object from MainActivity

        Team teams = (Team) getIntent().getSerializableExtra("team");


        // Assign information to correct views
        TextView detail_time = (TextView) findViewById(R.id.detail_time);
        detail_time.setText(teams.getDetailTime());

        TextView detail_location = (TextView) findViewById(R.id.detail_location);
        detail_location.setText(teams.getDetailLocation());

        ImageView away_logo = (ImageView) findViewById(R.id.away_team_logo);
        String awayDrawableName = teams.getTeamLogo();
        int awayID = getApplicationContext().getResources().getIdentifier(awayDrawableName ,
                "drawable", getApplicationContext().getPackageName());
        away_logo.setImageResource(awayID);

        TextView away_name = (TextView) findViewById(R.id.away_team_name);
        away_name.setText(teams.getTeamName());

        TextView away_mascot = (TextView) findViewById(R.id.away_team_mascot);
        away_mascot.setText(teams.getAwayMascot());

        TextView away_record = (TextView) findViewById(R.id.away_record);
        away_record.setText(teams.getAwayRecord());

        TextView timeleft = (TextView) findViewById(R.id.timeleft);
        timeleft.setText(teams.getTimeLeft());

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(teams.getGameScore());

    }
        }

