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
import br.com.dicaspet.model.ItemResposta;

public class AdapterListResposta extends BaseAdapter {
	 private LayoutInflater mInflater;
	    private ArrayList<ItemResposta> itens;
	 
	    public AdapterListResposta(Context context, ArrayList<ItemResposta> itens)
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
	    public ItemResposta getItem(int position)
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
	        ItemResposta item = itens.get(position);
	        //infla o layout para podermos preencher os dados
	        view = mInflater.inflate(R.layout.item_resposta,null);
	 
	        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
	        //ao item e definimos as informações.
	        ((TextView) view.findViewById(R.id.usuario_resposta)).setText(item.getNome_user());
	        ((ImageView) view.findViewById(R.id.image_usuario_resposta)).setImageResource(item.getIconeRid());
	        ((TextView) view.findViewById(R.id.data_resposta)).setText(item.getData());
	        ((TextView) view.findViewById(R.id.resposta)).setText(item.getResposta());
	        return view;
	    }
	
	
	

}
