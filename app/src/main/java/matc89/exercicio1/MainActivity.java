package matc89.exercicio1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private TextView labelMensagem;
    private Button btnCumprimentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = (EditText) findViewById(R.id.editNome);
        labelMensagem = (TextView) findViewById(R.id.labelMensagem);
        btnCumprimentar = (Button) findViewById(R.id.btnCumprimentar);

        btnCumprimentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                labelMensagem.setText("Alô, " + nome + "!");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nome", labelMensagem.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String nome = savedInstanceState.getString("nome");
        labelMensagem.setText(nome);
    }
}
