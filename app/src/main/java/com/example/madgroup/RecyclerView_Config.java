package com.example.madgroup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private LabAdapter mLabAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<Appointmentlab> applab,List<String>keys){
        mContext=context;
        mLabAdapter=new LabAdapter(applab,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mLabAdapter);
    }

    class LabAppView extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mChemId;
        private TextView mDate;
        private TextView mTime;
        private TextView mEmail;
        private TextView mcontNumb;

        private String key;

        public LabAppView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.app_list_item,parent,false));

             mName = (TextView) itemView.findViewById(R.id.name_textView);
             mChemId = (TextView) itemView.findViewById(R.id.chemIdTextView);
             mDate = (TextView) itemView.findViewById(R.id.date_textView);
             mTime = (TextView) itemView.findViewById(R.id.time_textView);
             mEmail = (TextView) itemView.findViewById(R.id.email_textView);
             mcontNumb = (TextView) itemView.findViewById(R.id.contactNum_textView);

             //navigate to another activity that displays the clicked section details
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     Intent intent= new Intent(mContext,DisplayLabBkDetails.class);

                     intent.putExtra("key",key);
                     intent.putExtra("name",mName.getText().toString());
                     intent.putExtra("chemId",mChemId.getText().toString());
                     intent.putExtra("date",mDate.getText().toString());
                     intent.putExtra("time",mTime.getText().toString());
                     intent.putExtra("email",mEmail.getText().toString());
                     intent.putExtra("contactNumb",mcontNumb.getText().toString());

                     mContext.startActivity(intent);

                 }
             });

        }

        public void bind(Appointmentlab appointmentlab,String key){
             mName.setText(appointmentlab.getPatientName());
             mChemId.setText(""+appointmentlab.getChemId());
             mDate.setText(appointmentlab.getDate());
             mTime.setText(appointmentlab.getTime());
             mEmail.setText(appointmentlab.getEmail());
             mcontNumb.setText(""+appointmentlab.getContactNumber());
             this.key = key;
        }

    }
        class LabAdapter extends RecyclerView.Adapter<LabAppView>{

        private List<Appointmentlab> mAppLab;
        private List<String> mKeys;

            public LabAdapter(List<Appointmentlab> mAppLab, List<String> mKeys) {
                this.mAppLab = mAppLab;
                this.mKeys = mKeys;
            }

            @NonNull
            @Override
            public LabAppView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new LabAppView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull LabAppView holder, int position) {

                holder.bind(mAppLab.get(position),mKeys.get(position));

            }

            @Override
            public int getItemCount() {
                return mAppLab.size();
            }
        }
}
