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
import br.com.dicaspet.model.Servico;


@SuppressLint("DefaultLocale")
public class AdapterListServico  extends BaseAdapter{

	private Context context;
	private ListFilter listFilter;
	private ArrayList<Servico> lista;
	private ArrayList<Servico> listaFiltrada;

	public AdapterListServico(Context context, ArrayList<Servico> lista) {
		this.context = context;
		this.lista = lista;
		this.listaFiltrada = new ArrayList<Servico>(lista);

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
		Servico Srv = lista.get(position);
		View layout;

		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.item_servico, null);
		} else {
			layout = view;
		}

		TextView nome = (TextView) layout.findViewById(R.id.descServ);
		TextView preco = (TextView) layout.findViewById(R.id.precoServ);

		nome.setText(Srv.getSrv_descricao());
		preco.setText(Double.toString(Srv.getSrv_preco()));
		
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
				ArrayList<Servico> tempList = new ArrayList<Servico>();

				// search content in friend list
				for (int i = 0; i < listaFiltrada.size(); i++) {
					if (listaFiltrada.get(i).getSrv_descricao().toLowerCase()
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

			lista = (ArrayList<Servico>) results.values;

			notifyDataSetChanged(); // Faz a mudança no listview custom;

		}

	}

	
	
}
