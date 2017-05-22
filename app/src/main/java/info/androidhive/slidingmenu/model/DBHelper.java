package info.androidhive.slidingmenu.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 29/6/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mydb.db";
    public static final String FILM_TABLE_NAME_1 = "film";
    public static final String FILM_COLUMN_ID = "id";
    public static final String FILM_COLUMN_NAME = "name";
    public static final String FILM_COLUMN_AGE = "dname";
    public static final String FILM_TABLE_NAME_2 = "film_details";
    public static final String film_details_COLUMN_ID = "id";
    public static final String film_details_COLUMN_fid = "fid";
    public static final String film_details_COLUMN_RATING = "rating";
    public static final String film_details_COLUMN_DESC = "desc";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table film " +
                        "(id integer primary key, name text,dname text)"
        );
        db.execSQL(
                "create table film_details " +
                        "(id integer primary key,fid integer,rating text,desc text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS register");
        onCreate(db);
    }

    public boolean insertfilm(String name, String dname) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("dname", dname);

            long flag = db.insert("film", null, contentValues);
            Log.e("", "" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean insertdetails(Integer fid,String rate, String describ) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("fid", fid);
            contentValues.put("rating", rate);
            contentValues.put("desc", describ);

            long flag = db.insert("film_details", null, contentValues);
            Log.e("", "" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }





    public Cursor getData() {
        Cursor res = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("select * from film", null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public Cursor getDetails(Integer fid) {
        Cursor res = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("select * from film_details where fid="+fid+"", null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public Cursor geteditDetails(Integer id) {
        Cursor res = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("select * from film_details where id="+id+"", null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<String> getAllLabels() {
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT name FROM register";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }


    public Cursor searchData(String nm) {
        Cursor res = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("select * from film where name LIKE '" + nm + "%'", null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, FILM_TABLE_NAME_1);
        return numRows;
    }

    public boolean updatecomments(Integer id, String rate, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rating", rate);
        contentValues.put("desc", desc);
        db.update("film_details", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public boolean deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("film_details",
                "id = ? ",
                new String[]{Integer.toString(id)});
        return true;
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from contacts", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(FILM_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
