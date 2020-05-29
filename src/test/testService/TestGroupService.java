package test.testService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Gps;
import main.domian.User;
import main.service.GpsService;
import main.service.impl.GpsServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestGroupService {

    GpsService gpsService = new GpsServiceImpl();
    @Test
    public void testAddGroup(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = new ArrayList<>();
        try {
             users= objectMapper.readValue("[{\"email\":\"aaa\",\"name\":null,\"password\":null},{\"email\":\"asd\",\"name\":null,\"password\":null}]", new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(users);

        Integer count = gpsService.addGps(users, new Gps(null, "testGroup", "thisisfortest"));
        System.out.println(count);


    }

    @Test
    public void testFindGroupsByEmail() {
        System.out.println(gpsService.findGroupsByEmail("u6889341@anu.edu.au"));
    }
}
