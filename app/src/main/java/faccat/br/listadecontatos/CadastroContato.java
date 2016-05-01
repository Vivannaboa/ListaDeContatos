package faccat.br.listadecontatos;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Classename CadastroContato
 * Responsavel por manter o contato
 * Utiliza o layout "activity_cadastro_contato"
 */

public class CadastroContato extends AppCompatActivity {

    //Declaração de váriaveis
    private EditText nome;
    private EditText telefone;
    private Button btnSalvar;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);
        //Botão de voltar da Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Titulo da action bar
        getSupportActionBar().setTitle("Cadastro de Contato");

        //recuperando objetos do arquivo de layout
        nome = (EditText)findViewById(R.id.editTextNome);
        telefone = (EditText)findViewById(R.id.editTextTelefone);
        btnSalvar = (Button)findViewById(R.id.buttonSalvar);

        //formatar telefone
        telefone.addTextChangedListener(new PhoneNumberFormattingTextWatcher("BR"));

        //Captura o click do botão Salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adicionando ao listView o contato
                salvaDados(nome.getText().toString(),telefone.getText().toString());
                limpaCampos();
                finish();
            }
        });
    }

    //Metodo responsavel por adicionar o contato no listView
    private void salvaDados(String nome, String telefone){
        Contatos contato = new Contatos(nome,telefone);
        MainActivity.listContatos.add(contato);

    }
    //Método responsavel por limpar os campos
    private void limpaCampos(){
        nome.setText("");
        telefone.setText("");
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
