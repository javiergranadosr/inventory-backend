package com.company.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseRest {

    private final List<HashMap<String, String>> metadata = new ArrayList<>();

    public List<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String type, String code, String date) {
       HashMap<String, String> map = new HashMap<>();
       map.put("type", type);
       map.put("code", code);
       map.put("date", date);
       metadata.add(map);
    }
}
