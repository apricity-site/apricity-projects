package com.apricity.starter.web.repository.id;

import java.util.UUID;

public class UuidGenerator implements IdGenerator<String>{
    @Override
    public String next() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
