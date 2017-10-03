package teste.mvp.com.apptestemvp.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teste.mvp.com.apptestemvp.R;
import teste.mvp.com.apptestemvp.domain.entities.Marca;

/**
 * Created by softvaro on 28/08/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Marca> mMarcas;
    private OnClickListener<Marca> mListener;

    public RecyclerViewAdapter(List<Marca> marcas) {
        mMarcas = marcas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.recycler_view_marca_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Marca marca = mMarcas.get(position);

        if(marca != null){

            holder.mtvName.setText(marca.getName() == null ? "" : marca.getName());
            holder.mTvKey.setText(marca.getKey() == null ? "" : marca.getKey());

        }
    }

    @Override
    public int getItemCount() {
        return mMarcas != null ? mMarcas.size() : 0;
    }

    public void setOnItemClick(OnClickListener<Marca> mListener){
        this.mListener = mListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mtvName;
        private TextView mTvKey;

        public ViewHolder(final View itemView) {
            super(itemView);
            mtvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvKey = (TextView) itemView.findViewById(R.id.tv_key);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(mMarcas.get(getAdapterPosition()));
                }
            });
        }
    }
}
