package enums;

public enum NavItems {

    MY_DESK("my-desk"),
    HOME("home"),
    PEOPLE("people");

    private String itemName;

    NavItems(String itemName) {
        this.itemName = itemName;
    }

    public String getItemHref() {
        return itemName;
    }
}
