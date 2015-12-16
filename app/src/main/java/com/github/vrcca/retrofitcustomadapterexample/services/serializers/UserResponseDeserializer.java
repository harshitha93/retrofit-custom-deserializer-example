package com.github.vrcca.retrofitcustomadapterexample.services.serializers;

import com.github.vrcca.retrofitcustomadapterexample.model.Admin;
import com.github.vrcca.retrofitcustomadapterexample.model.Editor;
import com.github.vrcca.retrofitcustomadapterexample.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UserResponseDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String type = json.getAsJsonObject().get("type").getAsString();
        if (type.equalsIgnoreCase("admin")) {
            return new Gson().fromJson(json, Admin.class);
        } else if (type.equalsIgnoreCase("editor")) {
            return new Gson().fromJson(json, Editor.class);
        }

        throw new JsonParseException("Unknown user type!");
    }
}
