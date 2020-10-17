package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class User {
    public String screenName;
    public String name;
    public String profilePicUrl;

    public User () {} // for parcelable

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.screenName = jsonObject.getString("screen_name");
        user.name = jsonObject.getString("name");
        user.profilePicUrl = jsonObject.getString("profile_image_url_https");

        return user;
    }

}
