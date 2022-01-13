package hello.hellospring.domain;

public class Member
{
    private Long id;
    private String name;

    public Member(){

    }

    public long getid() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
