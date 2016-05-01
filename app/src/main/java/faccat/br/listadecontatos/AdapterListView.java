package faccat.br.listadecontatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;


/**
 *Classe responsavel por inflar a lista de contatos
 * Utiliza o arquivo de layout "item_list"
 */

public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Contatos> listContatos;

    public AdapterListView(Context context, List<Contatos> listContatos) {
        //seta a lista de contatos
        this.listContatos = listContatos;
        // Objeto responsável por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listContatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listContatos.get(position);
    }
    //aqui fiz uma função para retornar o telefone
    public String getTelelefone(int position){

        return listContatos.get(position).getFone();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {

            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.item_list, null);
            //cria um item de suporte para não precisarmos sempre/ inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.txtNome = ((TextView) view.findViewById(R.id.nome));
            itemHolder.txtTelefone = ((TextView) view.findViewById(R.id.telefone));

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }
        //pega os dados da lista //e define os valores nos itens.
        Contatos item = listContatos.get(position);
        itemHolder.txtNome.setText(item.getNome());
        itemHolder.txtTelefone.setText(item.getFone());

        //retorna a view com as informações
        return view;
    }
    /**
     * Classe de suporte para os itens do layout.
     */
    private class ItemSuporte {
        TextView txtNome;
        TextView txtTelefone;
    }
}

