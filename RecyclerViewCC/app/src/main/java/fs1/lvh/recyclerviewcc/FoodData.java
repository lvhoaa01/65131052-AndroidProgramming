package fs1.lvh.recyclerviewcc;

public class FoodData {
    private String name;
    private String price;
    private String description;
    private int avatar;

    public FoodData(int avatar, String description, String name, String price) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
