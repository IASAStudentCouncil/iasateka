package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.services.CodeService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private static final short CODE_LENGTH = 6;
    private static final Random randomizer = new Random();
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public String generateCode() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            resultBuilder.append(randomizer.nextInt());
        }
        return resultBuilder.toString();
    }

    @Override
    public void verifyCode(String email, String code) {
        String realEmail = redisTemplate.opsForValue().get(code);
        if (email.equals(realEmail)) {

        }
    }

    @Override
    public void saveCode(String email, String code) {
        redisTemplate.opsForValue().set(code, email);
    }
}
