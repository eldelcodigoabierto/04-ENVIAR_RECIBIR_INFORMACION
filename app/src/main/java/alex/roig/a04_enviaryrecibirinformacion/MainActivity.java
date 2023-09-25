package alex.roig.a04_enviaryrecibirinformacion;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

import alex.roig.a04_enviaryrecibirinformacion.modelos.Direccion;
import alex.roig.a04_enviaryrecibirinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtPassword;

    private EditText txtEmail;
    private Button btnDesencriptar;
    private Button btnCrearDireccion;

    private final int DIRECCIONES = 123;

    private ActivityResultLauncher<Intent> launcherDirecciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();
        inicializaLauncher();

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
        btnCrearDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearDireccionActivity.class);
                //startActivity(intent);
              //  startActivityForResult(intent,DIRECCIONES);
                launcherDirecciones.launch(intent);
            }
        });
    }

    private void inicializaLauncher() {
        //registrar una actividad de retorno con dos partes
        //1- como lanzo la actividad hija(equivakente al startActivityForResult)
        //2- que hago cuando la hija termina(equivalente al onActivityResult)
        launcherDirecciones = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getResultCode() == RESULT_OK){
                                Bundle bundle = result.getData().getExtras();
                                Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                                Toast.makeText(MainActivity.this, direccion.toString(), Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

/*
    /**
     * SE ACTIVA EL RETORNAR StartActivityForResult
     * @param requestCode ---> IDENTIFICADOR DE LA VENTANA O LA ACTIVIDAD QUE SE HA CERRADO
     *                    "EL TIPO DE DATO QUE RETORNA"
     * @param resultCode ---> EL MODO EN EL QUE SE HA CERRADO
     * @param data --> DATOS RETORNADOS(INTENT CON BUNDLE DENTRO)
     */

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //AVERIGUAR QUE ACTIVIDAD SE HA CERRADO
        if (requestCode == DIRECCIONES){
            //AVERIGUAR SI SE HA CERRADO CON EXITO
            if (resultCode == RESULT_OK){
                //AVERIGUAR SI VUELVE CON DATOS
                if (data != null){
                    Bundle bundle = data.getExtras();
                    Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                    Toast.makeText(this, direccion.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
            }
        }
    }
*/
    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
        btnCrearDireccion = findViewById(R.id.btnCrearDireccionMain);
    }
}