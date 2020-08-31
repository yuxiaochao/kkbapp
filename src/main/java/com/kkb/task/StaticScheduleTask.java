package com.kkb.task;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.kkb.user.entity.User;
import com.kkb.user.mapper.UserMapper;
import com.kkb.utils.CreatName;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@AllArgsConstructor
public class StaticScheduleTask {

    private final UserMapper userMapper;

    //3.添加定时任务
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate = 1000)
    private void configureTasks() {
        Map address = CreatName.getAddress();
        User user = new User();
        user.setUser002(PinyinUtil.getPinyin(address.get("name").toString(), ""));
        user.setUser003("odui9s2k0danmxkkw9a29si2a");
        user.setUser004(address.get("name").toString());
        user.setUser005(address.get("sex").toString());
        user.setUser006(address.get("email").toString());
        user.setUser007(address.get("tel").toString());
        user.setUser008(address.get("road").toString());
        user.setUser009(new Date());
        userMapper.insert(user);
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
