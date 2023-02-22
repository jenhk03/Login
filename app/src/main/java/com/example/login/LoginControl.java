package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginControl
{
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;
    public void setPref(Context ctx, String key, String value)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        spe = sp.edit();
        spe.putString(key, value);
        spe.commit();
    }
    public String getPref(Context ctx, String key)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String incl = sp.getString(key, null);
        return incl;
    }
    public Boolean isLogin(Context ctx, String key)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String incl = sp.getString(key, null);
        if (incl != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}