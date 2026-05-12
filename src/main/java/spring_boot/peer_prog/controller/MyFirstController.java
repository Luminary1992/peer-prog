package spring_boot.peer_prog.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring_boot.peer_prog.service.MyFirstService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/app/v1")
@RestController
public class MyFirstController {

    private MyFirstService myFirstService;

    public MyFirstController(MyFirstService myFirstService) {
        this.myFirstService = myFirstService;
    }

    // GET - Read Data from Service OR Database
    @GetMapping(value = "/get-name")
    public ResponseEntity<Map<UUID, String>> getNames(){
        return ResponseEntity.ok(myFirstService.getNames());
    }

    // POST - Adding data
    @PostMapping(value = "/add-name")
    public ResponseEntity<Map<UUID, String>> addNames(@RequestBody String name){

        var response =  myFirstService.saveData(name);

        return ResponseEntity
                .created(URI.create("/app/v1/add-name"))
                .body(response);

    }



}
