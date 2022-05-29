package com.aws.peachworld.command.member.adapter;

import com.aws.peachworld.command.member.application.MemberAlreadyExistException;
import com.aws.peachworld.command.member.application.SignUp;
import com.aws.peachworld.command.member.application.MemberSignUpService;
import com.aws.peachworld.command.member.application.SignUpComplete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberSignUpController {

    private MemberSignUpService service;

    public MemberSignUpController(MemberSignUpService service) {
        this.service = service;
    }

    @PostMapping("/member")
    public ResponseEntity<SignUpComplete> signUp(@RequestBody SignUp command) {

        try {
            SignUpComplete complete = this.service.signUp(command);

            log.info("sign up completed - member physical id {} | Username {}", complete.getId(), complete.getUsername());

            return ResponseEntity.ok(complete);
        }catch(MemberAlreadyExistException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



