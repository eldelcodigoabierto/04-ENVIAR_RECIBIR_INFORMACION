package alex.roig.a04_enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import alex.roig.a04_enviaryrecibirinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtPassword;

    private EditText txtEmail;
    private Button btnDesencriptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = txtPassword.getText().toString();
                String email = txtEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                Usuario usuario = new Usuario(email, password);
                // ENVIAR INFORMACION A LA SIGUIENTE ACTIVIDAD
                Bundle bundle = new Bundle();
                bundle.putSerializable("USER", usuario);

                // bundle.putString("PASS", password);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
    }
}