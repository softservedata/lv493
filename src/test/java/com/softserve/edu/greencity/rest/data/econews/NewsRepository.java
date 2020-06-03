package com.softserve.edu.greencity.rest.data.econews;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private static NewsRepository instance = null;

    private NewsRepository() {
    }

    public static NewsRepository get() {
        if (instance == null) {
            synchronized (NewsRepository.class) {
                if (instance == null) {
                    instance = new NewsRepository();
                }
            }
        }
        return instance;
    }

    public News getDefault() {
        return temporary();
    }

    public News temporary() {
        List<String> tags = new ArrayList<String>();
        tags.add("news");
        tags.add("events");
        return new News("C:\\Users\\mJana\\Documents\\GitHub\\lv493\\src\\test\\resources\\ecobag.jpg", "Reusable shopping bag",
                "A reusable shopping bag, sometimes called bag-for-life in the UK", "", tags);
    }

    public News minSymbolsNews(){
        List<String> tags = new ArrayList<String>();
        tags.add("news");
        return new News("", "1",
                "12345678901234567890", "http://", tags);
    }

    public News getIntermediateSymbolsNews(){
        String text = "12345678901234567890";
        String title = "1";
        return new News(title, text, "")
                .addTags("news");
    }

    public News getMaxSymbolsNews(){
        String text = "While we all are going through these strange times, let’s appreciate " +
                "what we already have. We are lucky to be born on this magnificent planet. ";
        String title = "1234567890123456789012345678901234567890123456789012345678901234567890123" +
                "456789012345678901234567890123456789012345678901234567890123456789012345678901234" +
                "5678901234567890";
        String source = "https://www.greenpeace.org/international/story/30150/earth-day-2020/";
        return new News(title, text, source)
                .addTags("news").addTags("ads").addTags("events");
    }

    public News getTitleSizeInvalidOfNews(){
        String text = "Мережа магазинів спеціалізованих на реалізації натуральної та екологічно чистої " +
                "продукції, яка вирощується і виробляється на фермерських господарствах. В асортименті: " +
                "молочна продукція, постійні делікатеси, європейські сири, хлеб, бакалія, грузинські " +
                "продукти, солодощі, органічна косметика, безфосфатні миючі засоби та пральні порошки\n" +
                "Філософія \"Еко-Лавки\" - найкращі продукти з найкращим сервісом.";
        String title = "Еко-лавка. Еко-лавка - це Мережа магазинів спеціалізованих на реалізації натуральної" +
                " та екологічно чистої продукції, яка вирощується і виробляється на фермерських господарствах." +
                "  В асортименті: молочна продукція, постійні делікатеси, європейські сири, хлеб, бакалія, " +
                "грузинські продукти, солодощі, органічна косметика, безфосфатні миючі засоби та пральні" +
                " порошки. Філософія \"Еко-Лавки\" - найкращі продукти з найкращим сервісом.";

               return new News(title, text, "https://eco-lavca.ua/")
                        .addTags("ads");
    }

    public News getEmptyTagsNews(){
        String text = "Мережа магазинів спеціалізованих на реалізації натуральної та екологічно чистої " +
                "продукції, яка вирощується і виробляється на фермерських господарствах.";
        return new News("Еко-лавка", text, "https://eco-lavca.ua");
    }

    public News getTooManyTagsNews(){
        String text = "Мережа магазинів спеціалізованих на реалізації натуральної та екологічно чистої " +
                "продукції, яка вирощується і виробляється на фермерських господарствах.";
        return new News("Еко-лавка", text, "https://eco-lavca.ua")
                        .addTags("ads").addTags("news").addTags("events").addTags("education");
    }

    public News getEmptyTitleNews(){
        String text = "Мережа магазинів спеціалізованих на реалізації натуральної та екологічно чистої " +
                "продукції, яка вирощується і виробляється на фермерських господарствах.";
        return new News("", text, "https://eco-lavca.ua")
                        .addTags("ads");
    }
    public News getEmptyTextNews(){
        return new News("Еко-лавка", "", "https://eco-lavca.ua")
                .addTags("ads");
    }
}