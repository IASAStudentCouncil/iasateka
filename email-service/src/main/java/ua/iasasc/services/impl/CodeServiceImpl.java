package ua.iasasc.services.impl;

import org.springframework.stereotype.Service;
import ua.iasasc.services.CodeService;

import java.util.Random;

@Service
public class CodeServiceImpl implements CodeService {
    private static final short CODE_LENGTH = 6;
    private static final Random randomizer = new Random();

    @Override
    public String generateCode() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            resultBuilder.append(randomizer.nextInt());
        }
        return resultBuilder.toString();
    }
}
