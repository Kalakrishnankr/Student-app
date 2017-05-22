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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;
public class ViewfilmFragment extends Fragment {

    public ViewfilmFragment(){}
    DBHelper db ;

    RecyclerView lview;
    RelativeLayout rl;
    RecyclerAdapter mAdapter;

    List<Filmdetails> filmdetailsList;
    String name,dname;
    Integer id;
    Cursor resultSet;
    int uid;
    EditText edt;
    Button btnadd,btnsrch;
    ListAdapter mListAdapter;
    String srch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_film_view, container, false);

        btnsrch=(Button)rootView.findViewById(R.id.btnsrch);
        edt=(EditText)rootView.findViewById(R.id.editText2);
        btnadd=(Button)rootView.findViewById(R.id.btnadd);
       // btnadd.setBackground(getResources().getDrawable(R.drawable.step0001));
        //btnsrch.setBackground(getResources().getDrawable(R.drawable.network_add));
        lview=(RecyclerView)rootView.findViewById(R.id.lview);
        lview.setLayoutManager(new LinearLayoutManager(getActivity()));
        db = new DBHelper(this.getActivity());
        filmdetailsList=new ArrayList<Filmdetails>();
        resultSet = db.getData();
        try {

            if (resultSet != null) {

                resultSet.moveToFirst();
                do {

                    filmdetailsList.add(new Filmdetails(resultSet.getInt(0), resultSet.getString(1),resultSet.getString(2)));
                } while (resultSet.moveToNext());
            }
        }
        catch (Exception e){
            Toast.makeText(getActivity(),"Nothing to display", Toast.LENGTH_SHORT).show();
        }

        if(filmdetailsList != null || filmdetailsList.size() > 0)
        {
            mAdapter=new RecyclerAdapter();
            lview.setAdapter(mAdapter);
        }
       /* lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView nm = (TextView) rootView.findViewById(R.id.txt1);
                TextView dnm = (TextView) rootView.findViewById(R.id.txt2);
                TextView id1 = (TextView) rootView.findViewById(R.id.txt3);

                name = filmdetailsList.get(position).name;
                dname = filmdetailsList.get(position).dname;
                //id=filmdetailsList.get(position).id;
                String value = String.valueOf(filmdetailsList.get(position).id);

                ViewdetailsFragment addmore = new ViewdetailsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putString("id", value);
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


                HomeFragment home = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, home);
                fragmentTransaction.commit();


            }
        });


        btnsrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                srch= edt.getText().toString();
                if (srch.length()== 0) {
                    Toast.makeText(getActivity(), "Enter name", Toast.LENGTH_LONG).show();
                    //srch.setError("Enter name");
                    return;
                }
                Searchview addmore = new Searchview();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putString("name", srch);
                addmore.setArguments(args);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, addmore);
                fragmentTransaction.commit();

            }
        });





        return rootView;
    }



   /* public class ListAdapter extends BaseAdapter
    {


        @Override
        public int getCount() {
            return filmdetailsList.size();
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

            View rowView = inflater.inflate(R.layout.list_view, parent, false);

            try {
               TextView fname = (TextView)rowView.findViewById(R.id.txt1);
                TextView dname = (TextView) rowView.findViewById(R.id.txt2);
                TextView id = (TextView) rowView.findViewById(R.id.txt3);

                fname.setText(filmdetailsList.get(position).name);
                dname.setText(""+filmdetailsList.get(position).dname);
                id.setText(""+filmdetailsList.get(position).id);




            }catch(Exception e)
            {
                e.printStackTrace();
            }


            return rowView;
        }
    }*/

    public class RecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder>
    {

       /* boolean status1;
        RecyclerAdapter(boolean status)
        {
           status1=status;


        }*/

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, null);

            CustomViewHolder viewHolder = new CustomViewHolder(view);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final CustomViewHolder holder, final int position) {

            holder. fname.setText(filmdetailsList.get(position).name);
            holder. dname.setText(filmdetailsList.get(position).dname);
            holder. id.setText(""+filmdetailsList.get(position).id);


            holder.rlMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), employeeList.get(position).name, Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(getActivity().getBaseContext(),
                            TargetActivity.class);
                    intent.putExtra("message", message);
                    getActivity().startActivity(intent);*/



                    ViewdetailsFragment view = new ViewdetailsFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    String name = holder.fname.getText().toString();
                    String dname = holder.dname.getText().toString();
                    String value = holder.id.getText().toString();

                    Bundle args = new Bundle();

                    args.putString("id",value);
                    view.setArguments(args);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, view);
                    fragmentTransaction.commit();
                }
            });


        }

        @Override
        public int getItemCount() {
            return filmdetailsList.size();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

       TextView fname;
        TextView dname;
        TextView id;

        RelativeLayout rlMain;
        public CustomViewHolder(View view) {
            super(view);
            /*textname = (TextView) view.findViewById(R.id.name);
            textage = (TextView) view.findViewById(R.id.age);
            textsex = (TextView) view.findViewById(R.id.sex);
            textid = (TextView) view.findViewById(R.id.no);*/
             fname = (TextView)view.findViewById(R.id.txt1);
            dname = (TextView)view.findViewById(R.id.txt2);
            id = (TextView) view.findViewById(R.id.txt3);
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