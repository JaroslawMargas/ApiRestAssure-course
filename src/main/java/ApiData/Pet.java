package ApiData;


import com.google.gson.Gson;

public class Pet {
    public Long id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tag[] tags;
    public String status;

    public Pet(Long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public static Pet getFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Pet.class);
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
