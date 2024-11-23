package com.mrone.heapdump.service;

import com.mrone.heapdump.entity.Like;
import com.mrone.heapdump.entity.User;

public interface HeapDumpService {


    void addLike(Like like);

    void addUser(User user);
}
