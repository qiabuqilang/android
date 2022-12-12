package com.example.administrator.d3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.administrator.d3.bean.UserInfo;

import java.util.ArrayList;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "UserDBHelper";
    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;
    private static UserDBHelper userDBHelper = null;
    private SQLiteDatabase database = null;
    public static final String TABLE_NAME = "user_info";

    private UserDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    private UserDBHelper(Context context,int version){
        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate");
        String drop_sql = "DROP TABLE IF EXISTS "+ TABLE_NAME +";";
        Log.d(TAG,"drop_sql:"+drop_sql);
        sqLiteDatabase.execSQL(drop_sql);
        String create_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
                + "name VARCHAR NOT NULL," + "age INTEGER NOT NULL,"
                + "height LONG NOT NULL," + "weight FLOAT NOT NULL,"
                + "married INTEGER NOT NULL," + "update_time VARCHAR NOT NULL"
                //演示数据库升级时要先把下面这行注释
                + ",phone VARCHAR" + ",password VARCHAR"
                + ");";
        Log.d(TAG, "create_sql:" + create_sql);
        sqLiteDatabase.execSQL(create_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade oldVersion=" + oldVersion + ", newVersion=" + newVersion);
        if (newVersion > 1) {
            //Android的ALTER命令不支持一次添加多列，只能分多次添加
            String alter_sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + "phone VARCHAR;";
            Log.d(TAG, "alter_sql:" + alter_sql);
            database.execSQL(alter_sql);
            alter_sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + "password VARCHAR;";
            Log.d(TAG, "alter_sql:" + alter_sql);
            database.execSQL(alter_sql);
        }
    }

    public int delete(String condition){
        return database.delete(TABLE_NAME,condition,null);
    }

    public int deleteAll(){
        return database.delete(TABLE_NAME,"TRUE",null);
    }

    public long insert(UserInfo info){
        ArrayList<UserInfo> infoArray = new ArrayList<>();
        infoArray.add(info);
        return insert(infoArray);
    }

    public long insert(ArrayList<UserInfo> infoArrayList){
        long result = -1;
        for (int i=0;i<infoArrayList.size();i++){
            UserInfo userInfo = infoArrayList.get(i);
            ArrayList<UserInfo> temp = new ArrayList<>();
            if (userInfo.name != null && userInfo.name.length() >0){
                String conditon = String.format("name='%s'",userInfo.name);
                temp = query(conditon);
                if (temp.size()>0){
                    update(userInfo,conditon);
                    result = temp.get(0).rowid;
                    continue;
                }
            }
            if (userInfo.phone != null && userInfo.phone.length()>0){
                String condition = String.format("phone='%s'",userInfo.phone);
                temp = query(condition);
                if (temp.size()>0){
                    update(userInfo,condition);
                    result = temp.get(0).rowid;
                    continue;
                }
            }

            ContentValues contentValues = new ContentValues();
            contentValues.put("name",userInfo.name);
            contentValues.put("age",userInfo.age);
            contentValues.put("height",userInfo.height);
            contentValues.put("weight",userInfo.weight);
            contentValues.put("married",userInfo.married);
            contentValues.put("update_time",userInfo.update_time);
            contentValues.put("phone",userInfo.phone);
            contentValues.put("password",userInfo.password);
            result = database.insert(TABLE_NAME,"",contentValues);
        }
        return result;
    }

    public int update(UserInfo userInfo,String condition){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",userInfo.name);
        contentValues.put("age",userInfo.age);
        contentValues.put("height",userInfo.height);
        contentValues.put("weight",userInfo.weight);
        contentValues.put("married",userInfo.married);
        contentValues.put("update_time",userInfo.update_time);
        contentValues.put("phone",userInfo.phone);
        contentValues.put("password",userInfo.password);
        return database.update(TABLE_NAME,contentValues,condition,null);
    }

    public ArrayList<UserInfo> query(String condition){
        String sql = String.format("select rowid,_id,name,age,height,weight,married,update_time,phone,password from %s where %s;",TABLE_NAME,condition);
        Log.d(TAG,"query sql:"+sql);
        ArrayList<UserInfo> infoArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql,null);
        while (cursor.moveToNext()){
            UserInfo userInfo = new UserInfo();
            userInfo.rowid = cursor.getLong(0);
            userInfo.xuhao = cursor.getInt(1);
            userInfo.name = cursor.getString(2);
            userInfo.age = cursor.getInt(3);
            userInfo.height = cursor.getLong(4);
            userInfo.weight = cursor.getFloat(5);
            userInfo.married = (cursor.getInt(6)==0)?false:true;
            userInfo.update_time = cursor.getString(7);
            userInfo.phone = cursor.getString(8);
            userInfo.password = cursor.getString(9);
            infoArrayList.add(userInfo);
        }
        cursor.close();
        return infoArrayList;
    }
    public static UserDBHelper getInstance(Context context,int version){
        if (version > 0 && userDBHelper== null){
            userDBHelper = new UserDBHelper(context,version);
        }else if(userDBHelper == null){
            userDBHelper = new UserDBHelper(context);
        }
        return userDBHelper;
    }

    public SQLiteDatabase openReadLink(){
        if(database == null || !database.isOpen()){
            database = userDBHelper.getReadableDatabase();
        }
        return database;
    }

    public SQLiteDatabase openWriteLink(){
        if(database ==null || !database.isOpen()){
            database = userDBHelper.getWritableDatabase();
        }
        return database;
    }

    public void closeLink(){
        if (database != null && database.isOpen()){
            database.close();
            database = null;
        }
    }

    public UserInfo queryByPhone(String phone) {
        UserInfo info = null;
        ArrayList<UserInfo> infoArray = query(String.format("phone='%s'", phone));
        if (infoArray.size() > 0) {
            info = infoArray.get(0);
        }
        return info;
    }
}
