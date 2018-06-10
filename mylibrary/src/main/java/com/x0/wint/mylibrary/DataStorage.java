package com.x0.wint.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class DataStorage<T> {
    Context context;
    T data;
    String preferences_name;

    public DataStorage(Context context, String preferences_name, T data){
        this.context = context;
        this.preferences_name = preferences_name;
        this.data = data;
    }

    public void storeData(String data_key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferences_name, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        sharedPreferences.edit().putString(data_key, gson.toJson(data)).apply();
    }

    public T loadData(String data_key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferences_name, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        T t = gson.fromJson(sharedPreferences.getString(data_key, ""), new TypeToken<ArrayList<T>>(){}.getType());
        return t;
    }

    public void deleteData(String data_key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferences_name, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(data_key).apply();
    }

    public void setData(T data){
        this.data = data;
    }

    /*public Boolean contain(String preferences_name, String data_key, T data){
        ArrayList<T> t = getData(preferences_name, data_key);
        return t.contains(data);
    }*/
}
