package br.com.dicaspet.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import br.com.dicaspet.R;
import br.com.dicaspet.model.Animal;

@SuppressLint("DefaultLocale")
public class AdapterListMeuPets extends BaseAdapter {

	private Context context;
	private ListFilter listFilter;
	private ArrayList<Animal> lista;
	private ArrayList<Animal> listaFiltrada;;

	public AdapterListMeuPets(Context context, ArrayList<Animal> lista) {
		this.context = context;
		this.lista = lista;
		this.listaFiltrada = new ArrayList<Animal>(lista);

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

	// Filtro
	public Filter getFilter() {
		if (listFilter == null) {
			listFilter = new ListFilter();
		}
		return listFilter;
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
		nome.setText(pet.getAni_nome());

		if (position % 2 == 0) {
			layout.setBackgroundColor(Color.parseColor("#7FFFD4"));
		} else {
			layout.setBackgroundColor(Color.parseColor("#B4F796"));
		}

		return layout;
	}

	private class ListFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults filterResults = new FilterResults();

			if (constraint.toString().trim() != null && constraint.length() > 0) {
				ArrayList<Animal> tempList = new ArrayList<Animal>();

				// search content in friend list
				for (int i = 0; i < listaFiltrada.size(); i++) {
					if (listaFiltrada.get(i).getAni_nome().toLowerCase()
							.contains(constraint.toString().toLowerCase())) {

						tempList.add(listaFiltrada.get(i));
					}
				}

				filterResults.count = tempList.size();
				filterResults.values = tempList;
			} else {
				filterResults.count = listaFiltrada.size();
				filterResults.values = listaFiltrada;
			}

			return filterResults;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {

			lista = (ArrayList<Animal>) results.values;

			notifyDataSetChanged(); // Faz a mudança no listview custom;

		}

	}
}
