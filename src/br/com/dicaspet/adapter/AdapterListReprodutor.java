package br.com.dicaspet.adapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.dicaspet.R;
import br.com.dicaspet.ReproducaoActivity;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.util.TarefaGetImagem;

public class AdapterListReprodutor extends BaseAdapter {
	private LayoutInflater mInflater;
	private ArrayList<Animal> itens;
	private ImageView ani_foto;
	
	public AdapterListReprodutor(Context context, ArrayList<Animal> itens) {
		// Itens que preencheram o listview
		this.itens = itens;
		// responsavel por pegar o Layout do item.
		mInflater = LayoutInflater.from(context);
	}

	/**
	 * Retorna a quantidade de itens
	 * 
	 * @return
	 */
	public int getCount() {
		return itens.size();
	}

	/**
	 * Retorna o item de acordo com a posicao dele na tela.
	 * 
	 * @param position
	 * @return
	 */
	public Animal getItem(int position) {
		return itens.get(position);
	}

	/**
	 * Sem implementação
	 * 
	 * @param position
	 * @return
	 */
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("ViewHolder")
	public View getView(int position, View view, ViewGroup parent) {
		// Pega o item de acordo com a posção.
		Animal item = itens.get(position);
		// infla o layout para podermos preencher os dados
		view = mInflater.inflate(R.layout.item_reprodutor, null);

		// atravez do layout pego pelo LayoutInflater, pegamos cada id
		// relacionado
		// ao item e definimos as informações.
		((TextView) view.findViewById(R.id.nome_reprodutor)).setText(item
				.getAni_nome());

		((TextView) view.findViewById(R.id.raca_reprodutor)).setText(item
				.getAni_raca());
		((TextView) view.findViewById(R.id.idade_reprodutor)).setText(Double
				.toString(item.getAni_idade()));
		((TextView) view.findViewById(R.id.PorteReprodutor)).setText(item
				.getAni_porte());

		ani_foto = ((ImageView) view.findViewById(R.id.image_animal_reprodutor));

		if (item.getAni_foto().isEmpty()) {
			ani_foto.setImageResource(R.drawable.ic_img_pet);
		} else {

			Drawable drawable;
			try {
				drawable = new TarefaGetImagem().execute(item.getAni_foto())
						.get();
				ani_foto.setImageDrawable(drawable);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return view;
	}
	
	
}
