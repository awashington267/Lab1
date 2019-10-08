package spring.services;

import org.springframework.stereotype.Component;

@Component
public class Quote implements IQuote {
    @Override
    public String quote() {
        return "ahahahhaa";
    }
}
