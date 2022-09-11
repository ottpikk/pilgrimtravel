package com.pilgrims.travelagency.components;

import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.exceptions.UserNotFoundException;
import com.pilgrims.travelagency.models.Authority;
import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.AuthorityService;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.sql.Date;

import static com.pilgrims.travelagency.utils.Constants.Security.*;

/**
 * Component to initialize data on app startup
 *
 * @author Ott Pikk
 */
@Component
public class DataInit {

    /**
    @Autowired
    private AuthorityService authorityService;
     */

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @PostConstruct
    public void init() throws AuthorityNotFoundException {
        //initAuthorityData();
        initUserData();
    }

    // PRIVATE METHODS //

    /**
    private void initAuthorityData() {
        System.out.println("Starting initializing Authority..");
        Authority authorityAdmin = new Authority();
        authorityAdmin.setName(AUTHORITY_ADMIN);
        createAuthority(authorityAdmin);

        Authority authorityCustomer = new Authority();
        authorityCustomer.setName(AUTHORITY_CUSTOMER);
        createAuthority(authorityCustomer);

        Authority authorityGuest = new Authority();
        authorityGuest.setName(AUTHORITY_GUEST);
        createAuthority(authorityGuest);
    }
     */

    private void initUserData() throws AuthorityNotFoundException {
        System.out.println("Starting initializing User..");
        Authority authority = new Authority();
        authority.setName(AUTHORITY_ADMIN);
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setActive(true);
        user.setAddress("Linn 1, Tänav 2, maja ja korter");
        user.setEmail("suvaline@domeen.com");
        user.setAuthority(authority);

        try {
            userService.createUser(user);
            System.out.println("User " +user.getUserName()+" created successfully");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**private void createAuthority(Authority authority) {
        try {
            Authority resultAuthority = authorityService.findAuthorityByName(authority.getName());
            System.out.println("Cannot pre-initialize authority:" + resultAuthority.getName());
        } catch (AuthorityNotFoundException authorityNotFoundException) {
            authorityService.createAuthority(authority);
        }
    }
     */
}
