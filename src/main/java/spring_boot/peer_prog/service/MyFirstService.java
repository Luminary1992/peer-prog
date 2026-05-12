package spring_boot.peer_prog.service;

import org.springframework.stereotype.Service;
import spring_boot.peer_prog.constant.MyConstant;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MyFirstService {

    private MyConstant myConstant;

    public MyFirstService(MyConstant myConstant) {
        this.myConstant = myConstant;
    }

    public Map<UUID, String> getNames() {
        return myConstant.getData();
    }

    public Map<UUID, String> saveData(String name) {

        return myConstant.addData(name);

    }
}
