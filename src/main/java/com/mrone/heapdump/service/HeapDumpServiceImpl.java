package com.mrone.heapdump.service;


import com.mrone.heapdump.entity.Like;
import com.mrone.heapdump.entity.User;
import com.mrone.heapdump.util.CacheUtil;
import org.springframework.stereotype.Service;

@Service
public class HeapDumpServiceImpl implements HeapDumpService{


    @Override
    public void addLike(Like like) {
        CacheUtil.put(like);
    }

    @Override
    public void addUser(User user) {
        CacheUtil.add(user);
    }

}
