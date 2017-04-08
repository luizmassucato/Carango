package br.com.luizmassucato.carango.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.luizmassucato.carango.R;
import br.com.luizmassucato.carango.listener.OnClickListener;
import br.com.luizmassucato.carango.model.Carro;
import br.com.luizmassucato.carango.utils.ConstantesUtils;

/**
 * Created by logonrm on 08/04/2017.
 */

public class CarroListaAdapter
        extends RecyclerView.Adapter<CarroListaAdapter.CarroViewHolder>{

    private List<Carro> carros;
    private Context context;
    private OnClickListener onClickListener;

    public CarroListaAdapter(Context context, List<Carro> carros, OnClickListener onClickListener){
        this.carros = carros;
        this.context = context;
        this.onClickListener = onClickListener;
    }




    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_carro, parent, false);

        return new CarroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CarroViewHolder holder, final int position) {
        Carro carro = carros.get(position);
        holder.tvNomeCarro.setText(carro.getNome());
        holder.tvDescCarro.setText(carro.getNome());

        Picasso.with(context)
                .load(ConstantesUtils.URL_IMAGENS + carro.getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivCarro);

        if(onClickListener != null){
            holder.itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClickListener.onClick(holder.itemView, position);
                        }
                    }

            );
        }

    }

    public Carro getItem(int position){
        return carros.get(position);
    }

    @Override
    public int getItemCount() {
        return this.carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCarro;
        public TextView tvNomeCarro;
        public TextView tvDescCarro;

        public CarroViewHolder(View itemView) {
            super(itemView);

            ivCarro = (ImageView) itemView.findViewById(R.id.ivCarro);
            tvNomeCarro = (TextView) itemView.findViewById(R.id.tvNomeCarro);
            tvDescCarro = (TextView) itemView.findViewById(R.id.tvDescCarro);

        }
    }

}
