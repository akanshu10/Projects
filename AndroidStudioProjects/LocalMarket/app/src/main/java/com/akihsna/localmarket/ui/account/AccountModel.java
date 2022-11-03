package com.akihsna.localmarket.ui.account;

public class AccountModel {
    private String viewdetails;
    private String accountlayoutname;

    public AccountModel(String viewdetails, String accountlayoutname) {
        this.viewdetails = viewdetails;
        this.accountlayoutname = accountlayoutname;
    }

    public String getViewdetails() {
        return viewdetails;
    }

    public void setViewdetails(String viewdetails) {
        this.viewdetails = viewdetails;
    }

    public String getAccountlayoutname() {
        return accountlayoutname;
    }

    public void setAccountlayoutname(String accountlayoutname) {
        this.accountlayoutname = accountlayoutname;
    }
}
