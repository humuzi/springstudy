package learning.com.enumeration;


/**
 * Create by HuQiuYue on 2019-08-09
 */

public enum SexEnum {
    MALE(0,"男"),
    FEMALE(1,"女");

    private int id;
    private String name;

    SexEnum(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SexEnum getSexById(int id){
        for(SexEnum sexEnum : SexEnum.values()){
            if(sexEnum.getId()==id){
                return sexEnum;
            }
        }
        return null;
    }

}



//reimburseStatusEnum.getCode().equals(code)