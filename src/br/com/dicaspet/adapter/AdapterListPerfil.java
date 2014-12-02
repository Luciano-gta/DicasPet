package br.com.dicaspet.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import br.com.dicaspet.R;
import br.com.dicaspet.model.Mensagem;

@SuppressLint("DefaultLocale")
public class AdapterListPerfil  extends BaseAdapter{

	private Context context;
	private ListFilter listFilter;
	private ArrayList<Mensagem> lista;
	private ArrayList<Mensagem> listaFiltrada;

	public AdapterListPerfil(Context context, ArrayList<Mensagem> lista) {
		this.context = context;
		this.lista = lista;
		this.listaFiltrada = new ArrayList<Mensagem>(lista);

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
		Mensagem Msg = lista.get(position);
		View layout;

		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.pergunta_respostas, null);
		} else {
			layout = view;
		}

		TextView nome = (TextView) layout.findViewById(R.id.textViewPerguntaTitulo);
		nome.setText(Msg.getMsg_titulo());
		
/*
		if (position % 2 == 0) {
			layout.setBackgroundColor(Color.parseColor("#FFF5EE"));
		} else {
			layout.setBackgroundColor(Color.parseColor("#CDC5BF"));
		}
*/
		return layout;
	}

	private class ListFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults filterResults = new FilterResults();

			if (constraint.toString().trim() != null && constraint.length() > 0) {
				ArrayList<Mensagem> tempList = new ArrayList<Mensagem>();

				// search content in friend list
				for (int i = 0; i < listaFiltrada.size(); i++) {
					if (listaFiltrada.get(i).getMsg_titulo().toLowerCase()
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

			lista = (ArrayList<Mensagem>) results.values;

			notifyDataSetChanged(); // Faz a mudança no listview custom;

		}

	}

	
	
}
