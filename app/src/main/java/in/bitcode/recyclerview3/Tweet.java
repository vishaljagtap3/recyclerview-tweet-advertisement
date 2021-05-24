package in.bitcode.recyclerview3;

import java.io.Serializable;

public class Tweet implements Serializable {
    private String account, text;

    public Tweet(String account, String text) {
        this.account = account;
        this.text = text;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
