package com.example.win.image;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.win.helpers.ImageHelperActivity;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.label.ImageLabel;
import com.google.mlkit.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeling;
import com.google.mlkit.vision.label.custom.CustomImageLabelerOptions;

public class BirdIdentificationActivity extends ImageHelperActivity {
    private ImageLabeler imageLabeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocalModel localModel = new LocalModel.Builder().setAssetFilePath("birds_model_metadata.tflite").build();

        CustomImageLabelerOptions options = new CustomImageLabelerOptions.Builder(localModel).build();
        imageLabeler = ImageLabeling.getClient(options);
    }

    @Override
    protected void runDetection(Bitmap bitmap) {
        InputImage inputImage = InputImage.fromBitmap(bitmap, 0);
        imageLabeler.process(inputImage).addOnSuccessListener( imageLabels-> {
            StringBuilder sb = new StringBuilder();
            for (ImageLabel label : imageLabels) {
                sb.append(label.getText()).append(": ").append(label.getConfidence()).append("\n");
            }
            if (imageLabels.isEmpty()) {
                getOutputTextView().setText("Could not identify!!");
            } else {
                getOutputTextView().setText(sb.toString());
            }
        }).addOnFailureListener(e -> {
            e.printStackTrace();
        });
    }
}
