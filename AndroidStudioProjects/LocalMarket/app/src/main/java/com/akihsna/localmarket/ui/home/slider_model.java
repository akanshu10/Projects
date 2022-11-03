package com.akihsna.localmarket.ui.home;

public class slider_model {
    private String banner;
    private String backgroundcolor;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    public slider_model(String banner, String backgroundcolor) {
        this.banner = banner;
        this.backgroundcolor = backgroundcolor;
    }
}
