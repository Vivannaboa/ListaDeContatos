package faccat.br.listadecontatos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName MainActivity
 * Tela principal comtem o ListView
 * Usa o layout activity_main
 */

public class MainActivity extends AppCompatActivity {

    public static List<Contatos> listContatos =new ArrayList<Contatos>();

    //Declaração de variaveis
    private ListView listViewContatos;
    private FloatingActionButton fab;
    public static AdapterListView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperando objetos do arquivo de layout
        listViewContatos = (ListView)findViewById(R.id.listViewContatos);
        fab = (android.support.design.widget.FloatingActionButton) findViewById(R.id.fab2);

        //setando o click do Floating para abrir a tela de cadastro
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadastro = new Intent(getApplication(), CadastroContato.class);
                startActivity(telaCadastro);
            }
        });

        //Setando o click no Listview
        listViewContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String strTelefone =  mAdapter.getTelelefone(position);
                Uri ligar = Uri.parse("tel: " + strTelefone);
                Intent chamarTelefone = new Intent(Intent.ACTION_DIAL, ligar);
                startActivity(chamarTelefone);

            }
        });
    }

    //Metodo da activity
    @Override
    protected void onStart() {
        super.onStart();
        //carrego aqui o listView para que seja sempre atualizada
        mAdapter = new AdapterListView(MainActivity.this, listContatos);
        listViewContatos.setAdapter(mAdapter);
    }



}

