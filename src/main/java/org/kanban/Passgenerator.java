package org.kanban;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passgenerator {

    public static void main(String ...args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //El String que mandamos al metodo encode es el password que queremos encriptar.
	System.out.println(bCryptPasswordEncoder.encode("1234"));
    }
}