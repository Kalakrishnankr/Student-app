package info.androidhive.slidingmenu;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;
public class ViewdetailsFragment extends Fragment {

    public ViewdetailsFragment(){}
    DBHelper db ;

    RecyclerView lview;
    RelativeLayout rl;
    RecyclerAdapter mAdapter;
    TextView id;
    List<Filmcomments> FilmcommentsList;
    String name,dname;
    Cursor resultSet;
    int uid;
    Button btnadd;
    //ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_details, container, false);

        final String sid=getArguments().getString("id");
        Integer fid=Integer.parseInt(sid);
        btnadd=(Button)rootView.findViewById(R.id.btnadd);
        lview=(RecyclerView)rootView.findViewById(R.id.lview);
        lview.setLayoutManager(new LinearLayoutManager(getActivity()));
        db = new DBHelper(this.getActivity());
        FilmcommentsList=new ArrayList<Filmcomments>();
        resultSet = db.getDetails(fid);
        try {

            if (resultSet != null) {

                resultSet.moveToFirst();
                do {

                    FilmcommentsList.add(new Filmcomments(resultSet.getInt(0), resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
                } while (resultSet.moveToNext());
            }
        }
        catch (Exception e){
            Toast.makeText(getActivity(),"Nothing to display", Toast.LENGTH_SHORT).show();
        }

        if(FilmcommentsList != null || FilmcommentsList.size() > 0)
        {
            /*mListAdapter= new ListAdapter();
            lview.setAdapter(mListAdapter);*/
            mAdapter=new RecyclerAdapter();
            lview.setAdapter(mAdapter);
        }
        /*lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView fid = (TextView) rootView.findViewById(R.id.txtV1);
                TextView rat = (TextView) rootView.findViewById(R.id.txtV2);
                TextView dis = (TextView) rootView.findViewById(R.id.txtV3);


                Integer fid1 = FilmcommentsList.get(position).fid;
                String rt = FilmcommentsList.get(position).rate;
                String des = FilmcommentsList.get(position).desc;

                String value = String.valueOf(FilmcommentsList.get(position).id);

                Editcomments addmore = new Editcomments();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putString("id", value);
                args.putString("fid", String.valueOf(fid1));
                args.putString("rat", rt);
                args.putString("des", des);



                addmore.setArguments(args);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, addmore);
                fragmentTransaction.commit();
                *//*final int val= Integer.parseInt(value);
                onpressed(val);*//*


            }
        });*/

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                DetailsFragment home = new DetailsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putString("id", sid);
                home.setArguments(args);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, home);
                fragmentTransaction.commit();




            }
        });




        return rootView;
    }



    /*public class ListAdapter extends BaseAdapter
    {


        @Override
        public int getCount() {
            return FilmcommentsList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.listitem, parent, false);

            try {
                TextView fid = (TextView)rowView.findViewById(R.id.txtV1);
                TextView rat = (TextView) rowView.findViewById(R.id.txtV2);
                TextView dis = (TextView) rowView.findViewById(R.id.txtV3);
                TextView sid = (TextView) rowView.findViewById(R.id.txtV4);


                fid.setText(""+FilmcommentsList.get(position).fid);
                rat.setText(""+FilmcommentsList.get(position).rate);
                dis.setText(FilmcommentsList.get(position).desc);
                sid.setText(""+FilmcommentsList.get(position).id);






            }catch(Exception e)
            {
                e.printStackTrace();
            }


            return rowView;
        }
    }*/


    public class RecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

       /* boolean status1;
        RecyclerAdapter(boolean status)
        {
           status1=status;


        }*/

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, null);

            CustomViewHolder viewHolder = new CustomViewHolder(view);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final CustomViewHolder holder, final int position) {

            holder. fid.setText(""+FilmcommentsList.get(position).fid);
            holder. rat.setText(FilmcommentsList.get(position).rate);
            holder. dis.setText(FilmcommentsList.get(position).desc);
            holder. sid.setText(""+FilmcommentsList.get(position).id);


            holder.rlMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), employeeList.get(position).name, Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(getActivity().getBaseContext(),
                            TargetActivity.class);
                    intent.putExtra("message", message);
                    getActivity().startActivity(intent);*/




                    String fi = holder.fid.getText().toString();
                    String rt = holder.rat.getText().toString();
                    String des = holder.dis.getText().toString();
                    String value = holder.sid.getText().toString();



                    Editcomments addmore = new Editcomments();
                    FragmentManager fragmentManager = getFragmentManager();
                    Bundle args = new Bundle();
                    args.putString("id", value);
                    args.putString("fid",fi);
                    args.putString("rat", rt);
                    args.putString("des", des);



                    addmore.setArguments(args);

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, addmore);
                    fragmentTransaction.commit();
                }
            });


        }

        @Override
        public int getItemCount() {
            return FilmcommentsList.size();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView rat;
        TextView dis;
        TextView sid;
        TextView fid;

        RelativeLayout rlMain;
        public CustomViewHolder(View view) {
            super(view);
            /*textname = (TextView) view.findViewById(R.id.name);
            textage = (TextView) view.findViewById(R.id.age);
            textsex = (TextView) view.findViewById(R.id.sex);
            textid = (TextView) view.findViewById(R.id.no);*/
            fid = (TextView)view.findViewById(R.id.txtV1);
            rat = (TextView)view.findViewById(R.id.txtV2);
            dis = (TextView) view.findViewById(R.id.txtV3);
            sid = (TextView) view.findViewById(R.id.txtV4);
            rlMain=(RelativeLayout)view.findViewById(R.id.rlMain);
        }
    }



    public void onpressed(final Integer va) {
        new AlertDialog.Builder(this.getActivity())
                .setTitle("Really Delete?")
                .setMessage("Are you sure you want to delete?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        /*db.deletestudent(va);*/

                    }
                }).create().show();
    }
}