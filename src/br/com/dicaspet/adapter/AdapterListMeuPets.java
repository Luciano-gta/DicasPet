package br.com.dicaspet.adapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.dicaspet.R;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.util.TarefaGetImagem;

@SuppressLint("DefaultLocale")
public class AdapterListMeuPets extends BaseAdapter {

	private Context context;
	private ArrayList<Animal> lista;
	

	public AdapterListMeuPets(Context context, ArrayList<Animal> lista) {
		this.context = context;
		this.lista = lista;
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Animal pet = lista.get(position);
		View layout;

		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.item_animais, null);
		} else {
			layout = view;
		}

		TextView nome = (TextView) layout.findViewById(R.id.nomeAnimal);
		ImageView img = (ImageView) layout.findViewById(R.id.imgPet);

		nome.setText(pet.getAni_nome());
		
		if (pet.getAni_foto().isEmpty()) {
			img.setImageResource(R.drawable.ic_img_pet);
		} else {
			 
			Drawable drawable;
			try {
				drawable = new TarefaGetImagem().execute(pet.getAni_foto()).get();
				img.setImageDrawable(drawable);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		
		
/* retirar cor por linha e colocar background
		if (position % 2 == 0) {
			layout.setBackgroundColor(Color.parseColor("#7FFFD4"));
		} else {
			layout.setBackgroundColor(Color.parseColor("#B4F796"));
		}
*/
		return layout;
	}
}
