package spring_boot.peer_prog.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class MyConstant {

    Map<UUID, String> map = new HashMap<>();

    public Map<UUID, String> addData(String name){
        UUID id = UUID.randomUUID();
        map.put(id, name.replaceAll("\\r\\n ", ""));
        return map;
    }

    public Map<UUID, String> getData(){
        return map;
    }


}
