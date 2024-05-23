package com.example.sprinddatajpa.feature.user;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.sprinddatajpa.domain.User;
import com.example.sprinddatajpa.feature.elastic.ELServiceImpl;
import com.example.sprinddatajpa.feature.user.dto.UserRequest;
import com.example.sprinddatajpa.feature.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;
    private final ELServiceImpl elService;

    @PostMapping("")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {

        return  userService.createUser(userRequest);
    }

    @GetMapping("/autoSuggest/{partialUserName}")
    public List<String> autoSuggest(@PathVariable String partialUserName) throws IOException {
        SearchResponse<User> searchResponse = elService.autoSuggest(partialUserName);
        List<Hit<User>> hitList = searchResponse.hits().hits();
        List<User> userList = new ArrayList<>();
        for (Hit<User> hit : hitList) {
            userList.add(hit.source());
        }
        List<String> listUserName = new ArrayList<>();
        for (User user : userList) {
            listUserName.add(user.getName());
        }
        return listUserName;
    }
}
