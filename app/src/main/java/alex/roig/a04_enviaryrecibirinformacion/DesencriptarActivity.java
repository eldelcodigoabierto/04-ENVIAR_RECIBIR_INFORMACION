package alex.roig.a04_enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import alex.roig.a04_enviaryrecibirinformacion.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        //SACAR LA INFORMACION QUE LLEGA
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null){
            // String password = bundle.getString("PASS");
            Usuario usuario = (Usuario) bundle.getSerializable("USER");
            Toast.makeText(this,usuario.toString(), Toast.LENGTH_SHORT).show();
        }



    }
}