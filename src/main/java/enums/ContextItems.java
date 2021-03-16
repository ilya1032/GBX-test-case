package enums;

public enum ContextItems {

    NOTE("0"),
    DESK("1"),
    PDF("2"),
    FOLDER("4"),
    COLLECTION("6");

    private String itemName;

    ContextItems(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return String.format("context-menu_%s_click", this.itemName);
    }
}
