package br.com.dicaspet;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.dicaspet.model.ItemReprodutor;

public class AdapterListReprodutor extends BaseAdapter {
	 private LayoutInflater mInflater;
	    private ArrayList<ItemReprodutor> itens;
	 
	    public AdapterListReprodutor(Context context, ArrayList<ItemReprodutor> itens)
	    {
	        //Itens que preencheram o listview
	        this.itens = itens;
	        //responsavel por pegar o Layout do item.
	        mInflater = LayoutInflater.from(context);
	    }
	 
	    /**
	     * Retorna a quantidade de itens
	     *
	     * @return
	     */
	    public int getCount()
	    {
	        return itens.size();
	    }
	 
	    /**
	     * Retorna o item de acordo com a posicao dele na tela.
	     *
	     * @param position
	     * @return
	     */
	    public ItemReprodutor getItem(int position)
	    {
	        return itens.get(position);
	    }
	 
	    /**
	     * Sem implementação
	     *
	     * @param position
	     * @return
	     */
	    public long getItemId(int position)
	    {
	        return position;
	    }
	 
	    @SuppressLint("ViewHolder")
		public View getView(int position, View view, ViewGroup parent)
	    {
	        //Pega o item de acordo com a posção.
	        ItemReprodutor item = itens.get(position);
	        //infla o layout para podermos preencher os dados
	        view = mInflater.inflate(R.layout.item_reprodutor, null);
	 
	        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
	        //ao item e definimos as informações.
	        ((TextView) view.findViewById(R.id.nome_reprodutor)).setText(item.getNome_reprodutor());
	        ((ImageView) view.findViewById(R.id.image_animal_reprodutor)).setImageResource(item.getIconeRid());
	        ((TextView) view.findViewById(R.id.raca_reprodutor)).setText(item.getRaca());
	        ((TextView) view.findViewById(R.id.idade_reprodutor)).setText(item.getIdade());
	        return view;
	    }
	
	
	

}
