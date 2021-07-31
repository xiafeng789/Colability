package net.revoll.colability.i18n.struct;

public class SimpleLanguage {
    private AbstractLanguage language;

    public SimpleLanguage(String lang){
        switch (lang){
            case "Chinese":
                language = new ChineseLanguageConfig();
                break;

            case "default":
                language = new LanguageConfig();
                break;
        }
    }



    public AbstractLanguage getLanguage() {
        if(language==null){
            language = new LanguageConfig();
        }
        return language;
    }
}
