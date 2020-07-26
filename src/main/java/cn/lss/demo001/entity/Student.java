package cn.lss.demo001.entity;

public class Student {
    private Integer id;
    private String sname;
    private Integer sage;
    private String phone;

    public Student() {
    }



    public Student(Integer id, String sname, Integer sage, String phone) {
        this.id = id;
        this.sname = sname;
        this.sage = sage;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", phone='" + phone + '\'' +
                '}';
    }

}
