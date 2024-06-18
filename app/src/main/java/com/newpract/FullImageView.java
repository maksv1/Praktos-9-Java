package com.newpract;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri; // Добавьте этот импорт
import android.os.Bundle;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class FullImageView extends AppCompatActivity {
    ImageView fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_image_view);
        fullImage = findViewById(R.id.full_image);

        String imgUriSrc = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imgUriSrc);

        try {
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            fullImage.setImageBitmap(selectedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
