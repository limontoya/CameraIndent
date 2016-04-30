package montoyalinaj.cameraindent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends Activity {

    Button boton_foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_foto = (Button) findViewById(R.id.boton_foto);

        boton_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camara = new Intent();
                camara.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                File carpeta = new File(Environment.getExternalStorageDirectory()+"/cameraIntent");

                //If the folder carpeta, does not exist, create al folders and subfolders in order to create it
                if(!carpeta.exists()){
                    carpeta.mkdirs();
                }

                //Initialize the name of the photo in the folder already created
                File foto = new File(carpeta+"/foto1.jpg");

                //multimedial Storage
                Uri location = Uri.parse(foto.toString());

                camara.putExtra(MediaStore.EXTRA_OUTPUT, location);


                startActivity(camara);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
