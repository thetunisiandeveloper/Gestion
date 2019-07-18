package tn.yoodev.gestion.G_Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.yoodev.gestion.List.ProductList;
import tn.yoodev.gestion.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<ProductList>Products;
    private Context context;

    public ProductAdapter (){}
    public ProductAdapter(List<ProductList> products, Context context) {
        this.Products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductList ac=Products.get(position);


        holder.tcode.setText(ac.getCode());
        holder.tprix.setText(ac.getPrix());
        holder.tcategorie.setText(ac.getCategorie());
        holder.tquantite.setText(ac.getQantite());
        holder.tnomp.setText(ac.getNomp());
        holder.tfournisseur.setText(ac.getFournisseur());
        holder.tmarque.setText(ac.getMarque());

    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tcode,tfournisseur,tmarque,tquantite,tnomp,tprix,tcategorie;

        public ViewHolder(View itemView) {
            super(itemView);

            tcode= (TextView) itemView.findViewById(R.id.dcode);
            tfournisseur=(TextView) itemView.findViewById(R.id.dfournisseur);
            tmarque=(TextView) itemView.findViewById(R.id.dmarque);
            tquantite=(TextView) itemView.findViewById(R.id.dqantite);
            tnomp=(TextView) itemView.findViewById(R.id.dnomp);
            tprix=(TextView) itemView.findViewById(R.id.dprix);
            tcategorie=(TextView) itemView.findViewById(R.id.dcategorie);



        }
    }}
